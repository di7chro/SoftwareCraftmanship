# Software Craftmanship

Här samlas all källkod som tillverkas i kursen Software Craftmanship som går på Högskolan Väst under vären 2015

## 1. Intro TDD
Här skapades den första katan, String Calculator

Coding Dojo
-   En plats dit man går för att träna 
-   Övning, delibirate practice
-   Smart vs Professional (Readable, Maintainable, Changeable)
Agilt
-   Sustainable Pace
-   Automatiserade tester mycket viktigt idag

TestDriven development by example av Kent Beck
-   http://www.amazon.com/Test-Driven-Development-By-Example/dp/0321146530
-   Bra på att demonstrera hur TDD går till i praktiken

Nytta med TDD
-   More confident, productive, reliable, agile
    

## 2. Forts + ObjectOrientering
Här skapade vi den andra katan, BowlingKata
JUnit test Class Lifecycle

Svaret från övningen:
-   static_before
-   Hello
-   before
-   one
-   after
-   Hello
-   before
-   two
-   after
-   static_after

En ny test skapas i JUnit som en ny klass med methoden som enda del i denna klass, som anropas. Därför skapas klassen flera gånger.

2. Förkortningar på bra tester
-   F ast
-   I ndependant
-   R epeatable
-   S elf validation
-   T imely

Eller den här:
-   A utomatic
-   T horough
-   R epeatable
-   I ndependant
-   P rofessional

Eller denna variant:
-   R ight (testa rätt sak)
-   B oundries condition (testa gränsfallen)
-   I nverse condition (kan man testa motsatsen av testet)
-   C rosscheck (finns det annat sätt att komma till samma slutsats)
-   E xceptions (hur hanteras dessa)
-   P erformance
-   S et ()

Black-Box och White-Box testing

Inom WhiteBox-test har man möjligheten att kunna titta in i lådan för att se hur saker fungerar.

## 3. Test Double
Inför detta pas gjorde vi som hemarbete den tredje katan, PokerKata
Nu skall den göras på riktigt.

### Klassdiagram

#### Kort
-   Färg
-   Värde
  
#### Kortlek
-   Kort
-   Blanda

#### Spelare
-   5 Kort

#### Spel
-   Kortlek
-   Regler
-   Spelare
-   Jämför händer

## 4. Intro till Test Doubles
Kata som gjordes under detta pass var TagManagerKata

-   Unit-tester prövar en isolerad enhet
-   När en klass dependar på andra (DOC, Dependent on collaborators) behöver vi isolera dem från testerna
-   Test doubles är stand-ins för DOC och gör att vi kan isolera units för att testa ordentligt
   
### Test Doubles
-   Fake. 
-   Stub. Mer implementerade än Fake. Även med Stub som är det States som hanteras.
-   Mock. Ramverk används. KAn preparera vissa objekt för att returnera något känt. Medtod-anrop.  
-   Spies. Övervakar vad som händer.

### Mock
För workers så körs ofta Classical TDD, medan i Managers så används oftast Mock. Med stubbar kollar man alltid hur States förhåller sig. 
Med mock används i Arrange-delen mock-object som saknar implementation, och i Assert-delen används verify() för att kolla. Vi kollar inte States, utan snarare om anropen har kommit. 

För att använda mock i Eclipse används Mockito (mockito.org)
Exempel: Event event = Mockito.mock(Event.class);

## 5. Refactoring och Clean Code
BDD: Behaviour Driven Development. Att utifrån förklarande exempel mellan olika personer och User Stories kunna komma fram till vilket produkt/funktionalitet som skall utvecklas.
Cucumber school: att få business att prata med utvecklare.
Bok: Specification by example av Gojko Adzic

### Clean Code
Bra bok om clean code: Kent Beck: Implementation Patterns
-   Vad som anses vara Clean Code beror mycket på den context den befinner sig i.
-   SKapa tydliga datatyper istället för att skicka runt märkliga datatyper
-   Läsbar kod är: Readable, Changeable och Understandable
-   Clean Code skrivs för människor, inte datorer
-   DRY: Dont repeat yourself
-   YAGNI: You aint gonna need it. Själva grunden till TDD
-   Law of Demeter
-   Broken Window Syndrome: Om något är helt oc något liten del går sönder, så laga den lilla biten direkt annars blir fel delar snart trasiga.

### Software Patterns
-   Boken Refactoring to patterns av Joshua(?) är kanon.
-   




