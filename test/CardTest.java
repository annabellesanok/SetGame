import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.CardCount;
import cs3500.set.model.hw02.CardFilling;
import cs3500.set.model.hw02.CardShape;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests the construction of the card class and its toString.
 */
public class CardTest {
  Card c1;
  Card c2;
  Card c3;

  @Before
  public void init() {
    this.c1 = new Card(CardCount.One, CardFilling.Full, CardShape.Diamond);
    this.c2 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Squiggle);
    this.c3 = new Card(CardCount.Three, CardFilling.Striped, CardShape.Oval);
  }

  @Test
  public void testValidConstruction() {
    this.c1 = new Card(CardCount.One, CardFilling.Full, CardShape.Diamond);
    assertEquals("1FD", this.c1.toString());
    this.c2 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Squiggle);
    assertEquals("2EQ", this.c2.toString());
    this.c3 = new Card(CardCount.Three, CardFilling.Striped, CardShape.Oval);
    assertEquals("3SO", this.c3.toString());
  }


  @Test
  public void testInvalidConstruction1() {
    try {
      this.c2 = new Card(CardCount.One, CardFilling.Full, null);
      fail("Should have thrown an IllegalArgumentException when given a null");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testtoString() {
    this.c1 = new Card(CardCount.One, CardFilling.Full, CardShape.Diamond);
    assertEquals("1FD", this.c1.toString());
    this.c2 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Squiggle);
    assertEquals("2EQ", this.c2.toString());
    this.c3 = new Card(CardCount.Three, CardFilling.Striped, CardShape.Oval);
    assertEquals("3SO", this.c3.toString());
  }

}
