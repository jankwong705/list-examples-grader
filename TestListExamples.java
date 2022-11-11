import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.*;

class StringMethods implements StringChecker {
  public boolean checkString(String s) {
      return s.contains("s");
  }
}

public class TestListExamples {
  @Test
  public void testFilter() {
      StringChecker sc = new StringMethods();
      List<String> s = new ArrayList<>();
      List<String> expected = new ArrayList<>();
      s.add("seasame");
      expected.add("seasame");
      s.add("sonata");
      expected.add("sonata");
      s.add("diego");
      s.add("sofa");
      expected.add("sofa");
      s.add("detrimental");
      s.add("coffee");
      List<String> results = ListExamples.filter(s, sc);
      assertEquals(expected, results);
  }

  @Test
  public void testMerge() {
      List<String> s1 = new ArrayList<>();
      List<String> s2 = new ArrayList<>();
      s1.add("apple");
      s1.add("banana");
      s1.add("chaisma");
      s1.add("dormitory");
      s2.add("concerning");
      s2.add("dimension");
      s2.add("event");
      s2.add("fancy");
      List<String> expected = new ArrayList<>();
      expected.add("apple");
      expected.add("banana");
      expected.add("chaisma");
      expected.add("concerning");
      expected.add("dimension");
      expected.add("dormitory");
      expected.add("event");
      expected.add("fancy");
      List<String> results = ListExamples.merge(s1, s2);
      assertEquals(expected, results);
  }

}
