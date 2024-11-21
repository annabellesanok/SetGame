import cs3500.set.model.hw02.CardCount;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of CardCount.
 */
public class CountTest {
  CardCount c1;
  CardCount c2;
  CardCount c3;

  @Test
  public void testgetCountValue() {
    this.c1 = CardCount.One;
    assertEquals("1", this.c1.getCountValue());
    this.c2 = CardCount.Two;
    assertEquals("2", this.c2.getCountValue());
    this.c3 = CardCount.Three;
    assertEquals("3", this.c3.getCountValue());
  }
}


