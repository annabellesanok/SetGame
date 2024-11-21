import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.CardCount;
import cs3500.set.model.hw02.CardFilling;
import cs3500.set.model.hw02.CardShape;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.model.hw03.GeneralSetGameModel;
import cs3500.set.view.SetGameTextView;

/**
 * Tests the methods and constructor of SetGameTextView.
 */

public class SetGameTextViewTest {
  SetGameTextView s1;

  Card c1 = new Card(CardCount.One, CardFilling.Empty, CardShape.Diamond);
  Card c2 = new Card(CardCount.One, CardFilling.Striped, CardShape.Diamond);
  Card c3 = new Card(CardCount.One, CardFilling.Full, CardShape.Diamond);
  Card c4 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Diamond);
  Card c5 = new Card(CardCount.Two, CardFilling.Striped, CardShape.Diamond);
  Card c6 = new Card(CardCount.Two, CardFilling.Full, CardShape.Diamond);
  Card c7 = new Card(CardCount.Three, CardFilling.Empty, CardShape.Diamond);
  Card c8 = new Card(CardCount.Three, CardFilling.Striped, CardShape.Diamond);
  Card c9 = new Card(CardCount.Three, CardFilling.Full, CardShape.Diamond);
  Card c10 = new Card(CardCount.One, CardFilling.Empty, CardShape.Oval);
  Card c11 = new Card(CardCount.One, CardFilling.Striped, CardShape.Oval);
  Card c12 = new Card(CardCount.One, CardFilling.Full, CardShape.Oval);
  Card c13 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Oval);
  Card c14 = new Card(CardCount.Two, CardFilling.Striped, CardShape.Oval);
  Card c15 = new Card(CardCount.Two, CardFilling.Full, CardShape.Oval);
  Card c16 = new Card(CardCount.Three, CardFilling.Empty, CardShape.Oval);
  Card c17 = new Card(CardCount.Three, CardFilling.Striped, CardShape.Oval);
  Card c18 = new Card(CardCount.Three, CardFilling.Full, CardShape.Oval);
  Card c19 = new Card(CardCount.One, CardFilling.Empty, CardShape.Squiggle);
  Card c20 = new Card(CardCount.One, CardFilling.Striped, CardShape.Squiggle);
  Card c21 = new Card(CardCount.One, CardFilling.Full, CardShape.Squiggle);
  Card c22 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Squiggle);
  Card c23 = new Card(CardCount.Two, CardFilling.Striped, CardShape.Squiggle);
  Card c24 = new Card(CardCount.Two, CardFilling.Full, CardShape.Squiggle);
  Card c25 = new Card(CardCount.Three, CardFilling.Empty, CardShape.Squiggle);
  Card c26 = new Card(CardCount.Three, CardFilling.Striped, CardShape.Squiggle);
  Card c27 = new Card(CardCount.Three, CardFilling.Full, CardShape.Squiggle);
  List<Card> deckn = new ArrayList<Card>(Arrays.asList(c18, c14, c1, c4, c21, c26, c9, c10, c23,
          c19));

  List<Card> deck = new ArrayList<Card>(Arrays.asList(c18, c14, c1, c4, c21, c26, c9, c10, c23,
          c19, c25, c6, c27, c16, c15, c2, c11, c22, c13, c12, c24, c3, c5, c7, c8, c17, c20));

  //the grid after the game is started given deckn
  String viewdeckn = "3FO 2SO 1ED\n2ED 1FQ 3SQ\n3FD 1EO 2SQ";
  String viewdeck = "3FO 2SO\n1ED 2ED\n1FQ 3SQ\n3FD 1EO";

  String viewdeck2 = "2SQ 1EQ\n3EQ 2FD\n3FQ 3EO";

  @Test
  public void testInvalidConstruction() {
    try {
      this.s1 = new SetGameTextView(null);
      fail("Should have thrown an IllegalArgumentException when given invalid filling");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testtoString() {
    SetThreeGameModel game = new SetThreeGameModel();
    game.startGameWithDeck(deckn, 3,3);
    s1 = new SetGameTextView(game);
    assertEquals(viewdeckn, s1.toString());
  }

  @Test
  public void testtoString2() {
    GeneralSetGameModel game2 = new GeneralSetGameModel();
    game2.startGameWithDeck(deck, 2,2);
    s1 = new SetGameTextView(game2);
    assertEquals(viewdeck, s1.toString());
    GeneralSetGameModel game3 = new GeneralSetGameModel();
    game3.startGameWithDeck(deck, 3,2);
    SetGameTextView s2 = new SetGameTextView(game3);
    assertEquals(viewdeck2, s2.toString());
  }


  @Test
  public void testInvalidConstruction2() {
    try {
      this.s1 = new SetGameTextView(new SetThreeGameModel(), null);
      fail("Should have thrown an IllegalArgumentException when given invalid destination");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }


}
