package session3;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class PokerGameComparatorTest {

	@Test
	public void test_sort_by_value() {

		List<Card> originalList = Arrays.asList(new Card("3H"), new Card("5H"), new Card("2H"));

		PokerGameComparator comparator = new PokerGameComparator();
		Collections.sort(originalList, comparator);

		assertEquals(5, originalList.get(0).getValue());
		assertEquals(3, originalList.get(1).getValue());
		assertEquals(2, originalList.get(2).getValue());

	}

}
