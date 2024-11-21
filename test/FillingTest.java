import cs3500.set.model.hw02.CardFilling;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests the methods of CardFilling.
 */
public class FillingTest {
  CardFilling f1;
  CardFilling f2;
  CardFilling f3;

  @Test
  public void testgetFillingValue() {
    this.f1 = CardFilling.Full;
    assertEquals("F", this.f1.getFillingValue());
    this.f2 = CardFilling.Empty;
    assertEquals("E", this.f2.getFillingValue());
    this.f3 = CardFilling.Striped;
    assertEquals("S", this.f3.getFillingValue());
  }
}