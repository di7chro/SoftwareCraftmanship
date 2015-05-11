Refactoring to Visitor pattern
==============================

Import the project, run the tests (`FullSystemTest`). Refactor the classes `Partition` and `Session` to visitor pattern.

If you want to increase the challenge, follow these rules:

* you may NOT modify the contract of ColumnStorage nor the TableStorage classes - they're used in production and must be backwards compatible
* you may NOT modify the Storage interface


The Problem Domain
------------------

This is simplified production code, and the domain centers around storing of data objects. In this code base, there are
two different types of data storage: `ColumnStorage` and `TableStorage`. In order to load data from either of these
you start out with a `Session`. You tell the `Session` what storages to use (Column or Table) and then you can ask the
`Session` to: `load` data; `refresh` the data (by rereading all storage's files to get the latest available); `getSize` 
to see how many bytes of RAM this session is consuming; `getLatestCommitId` to get the latest seen commit id.

The objects stored are actually version controlled (well they are in the _real_ code base, you can't really see it in 
this simplified version) and each "save" is given an ever increasing "commit id".

Now, there's one more concept to this data model, and that is `Partition`. A `Session` actually doesn't hold references
to `Storage` objects, but to `Partition` objects. These `Partition` objects in turn can hold either other `Partitions`,
and/or `Storage` objects.

While all the operations are available from the `Session` class, they're also available on the `Partition` level, but 
not all `Storage` types support the `refresh` operation for instance.

A typical tree would look like this:

    Session
      |
      +---Partition
      |     |
      |     +---ColumnStorage (file:/tmp/dump1.json)
      |     |
      |     +---TableStorage (file:/tmp/dump2.sql)
      |     
      +---Partition
            |
            +---Partition
            |     |
            |     +--- ColumnStorage (file:/tmp/dump3.json)
            |
            +---ColumnStorage (file:/tmp/dump4.json)
            |
            +---TableStorage (file:/tmp/dump5.sql)


(In the real code base, the Partitions are clever filters that applies a filter and only shows the data objects that 
pass the filter. In this simplified example, they're only kept to make the Visitor pattern more obvious.)


The Problem
-----------

There are currently several "operations" which, when invoked, traverse the tree structure and does some work on each node in the graph. 
Code to handle traversing this structure is found in _all_ of these "operations". 
You should refactor this into a pattern that follows a Visitor pattern.

The operations are:

* printInfo
* load
* refresh
* getLatestCommitId
* getSize


Refactoring
===========

The refactoring cycle:

* run the tests and make sure everything is passing
* comment out the code you want to refactor
* put a dumb implementation in place
* run the tests and see some of them fail
* if no tests are failing, undo back to the beginning, add tests and start over until you have a sufficient test suite
* write the new code
* run the tests and make sure everything is passing


Visitor Pattern
===============

Don't read this unless you get stuck, or have no clue on how to use the Visitor pattern. Perhaps try reading http://en.wikipedia.org/wiki/Visitor_pattern

Each concrete Visitor knows what to do at each level in the structure, such as representing the visited object/node as JSON. The visitor, however, doesn't know how to traverse the structure. If it knew this, all visitors would have to know this which may lead to duplication of code, and certainly breaks Single Responsibility Principle. The Visitor thus has one method per object type that it visits.

Each visited object (node), knows how to "welcome" the Visotor object (traditionally the method is called `accept`), and pass the Visitor object around. This 'traversing the structure'-logic is put into the structure itself, and is typically marked with an interface, Visitable.


    class Visitable():
        def accept(self, visitor):
            pass

    class Visitor():
        def processParent(self, parent):
            pass
        def processChild(self, child):
            pass

    class Parent(Visitable):
        def accept(self, visitor):
            visitor.processParent(self)
            for c in self.children:
                c.accept(visitor)

    class SomeVisitor():
        def processParent(self, parent_object):
            doSomething ...
        def processChild(self, child_object):
            doSomethingElse ...


Additional Tasks
----------------

* Consider adding a way to save the structure, as XML, to a File.
* Consider adding a way to save the structure, as JSON, to a File.

* Consider doing away with the accept method, see
    http://perfectjpattern.sourceforge.net/dp-visitor.html and 
    http://perfectjpattern.sourceforge.net/xref/org/perfectjpattern/core/behavioral/visitor/AbstractVisitor.html


Notes
-----

The Storage interface is not present in the Python version of this exercise. Python uses duck typing and as such doesn't need a common base class in order to invoke methods on objects that share a common name.

Yes, the Logging.out is a replacement for System.out - the Python code does this much butter.

Yes, the `_mock_data` loading is so much simple with duck typing and object literal declaration support in the language, ie Python wins again. :-)

