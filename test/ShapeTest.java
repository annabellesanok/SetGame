import cs3500.set.model.hw02.CardShape;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of CardShape.
 */
public class ShapeTest {
  CardShape s1;
  CardShape s2;
  CardShape s3;

  @Test
  public void testgetShapeValue() {
    this.s1 = CardShape.Oval;
    assertEquals("O", this.s1.getShapeValue());
    this.s2 = CardShape.Diamond;
    assertEquals("D", this.s2.getShapeValue());
    this.s3 = CardShape.Squiggle;
    assertEquals("Q", this.s3.getShapeValue());
  }
}


