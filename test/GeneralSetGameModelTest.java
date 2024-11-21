import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.CardCount;
import cs3500.set.model.hw02.CardFilling;
import cs3500.set.model.hw02.CardShape;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw03.GeneralSetGameModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the methods of the new GeneralSetGameModel.
 */
public class GeneralSetGameModelTest {
  GeneralSetGameModel s1;

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

  Card n10 = new Card(CardCount.One, CardFilling.Empty, CardShape.Oval);
  Card n1 = new Card(CardCount.One, CardFilling.Empty, CardShape.Diamond);
  Card n21 = new Card(CardCount.One, CardFilling.Full, CardShape.Squiggle);
  Card n4 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Diamond);
  Card n14 = new Card(CardCount.Two, CardFilling.Striped, CardShape.Oval);
  Card n23 = new Card(CardCount.Two, CardFilling.Striped, CardShape.Squiggle);
  Card n26 = new Card(CardCount.Three, CardFilling.Striped, CardShape.Squiggle);
  Card n18 = new Card(CardCount.Three, CardFilling.Full, CardShape.Oval);
  Card n7 = new Card(CardCount.Three, CardFilling.Full, CardShape.Diamond);

  //complete deck
  List<Card> deck = new ArrayList<Card>(Arrays.asList(c18, c14, c1, c4, c21, c26, c9, c10, c23,
          c19, c25, c6, c27, c16, c15, c2, c11, c22, c13, c12, c24, c3, c5, c7, c8, c17, c20));

  List<Card> deckas = new ArrayList<Card>(Arrays.asList(c24, c3, c5, c7, c8, c17, c20));


  //deck with no sets initially and enough cards to add a row
  List<Card> deck1 = new ArrayList<Card>(Arrays.asList(c15, c15, c6, c6, c22, c22, c4, c4, c10,
          c10, c24, c24, c14, c14));

  //deck after start is called
  List<Card> deck1as = new ArrayList<Card>(Arrays.asList(c14, c14));

  List<Card> deck3 = new ArrayList<Card>(Arrays.asList(c15, c15, c6, c6, c22, c22, c4, c4, c10,
          c10, c24, c24, c14, c14));

  List<Card> deck3as = new ArrayList<Card>(Arrays.asList(c14, c14));

  List<Card> deck4 = new ArrayList<Card>(Arrays.asList(c15, c6, c24, c21, c18, c22, c4, c4, c10,
          c10, c24, c24, c14, c14));

  List<Card> deck4as = new ArrayList<Card>(Arrays.asList(c18, c22, c4, c4, c10,
          c10, c24, c24, c14, c14));

  List<Card> deck2 = new ArrayList<Card>(Arrays.asList(c15, c15, c6, c6, c22, c22, c4, c4, c10,
          c10, c24, c24, c14, c14));

  List<Card> deckcd = new ArrayList<Card>(Arrays.asList(n10, c19, n1, c11, c20, c2, c12, n21, c3,
          c13, c22, n4, n14, n23, c5, c15, c24, c6, c16, c25, c7, c17, n26, c8, n18, c27, n7));

  List<Card> deck6 = new ArrayList<Card>(Arrays.asList(c1, c22, c7, c4, c12, c26));

  List<Card> deck6as = new ArrayList<Card>(Arrays.asList(c12, c26));

  List<Card> deck2as = new ArrayList<Card>(Arrays.asList(c14, c14));

  List<Card> deck5 = new ArrayList<Card>(Arrays.asList(c18, c17, c16, c1, c2, c3, c5, c8, c1,
          c19, c25, c6, c27, c16, c15, c2, c11, c22, c13, c12, c4, c5, c6, c1, c2, c3, c20));

  List<Card> deck7 = new ArrayList<Card>(Arrays.asList(c15, c15, c6, c6, c22, c22, c4, c4, c10,
          c10));

  List<Card> deck7b = new ArrayList<Card>(Arrays.asList(c15, c15, c6, c24, c24));
  List<Card> deck7c = new ArrayList<Card>(Arrays.asList(c15, c15, c6, c21, c27));

  //deck 5 after claimed a set
  List<Card> deck5acs = new ArrayList<Card>(Arrays.asList(c1, c2, c3, c20));

  //deck 5 after claimed 2 sets
  List<Card> deck5a2cs = new ArrayList<Card>(Arrays.asList(c20));

  List<Card> empty = new ArrayList<Card>();

  List<Card> deck10 = new ArrayList<Card>(Arrays.asList(c15, c6, c24, c22, c4, c4, c10,
          c10, c22));

  @Test
  public void startGameWithDeck() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    GeneralSetGameModel s3 = new GeneralSetGameModel();
    GeneralSetGameModel s4 = new GeneralSetGameModel();
    GeneralSetGameModel s5 = new GeneralSetGameModel();
    GeneralSetGameModel s6 = new GeneralSetGameModel();
    GeneralSetGameModel s7 = new GeneralSetGameModel();
    GeneralSetGameModel s8 = new GeneralSetGameModel();
    //no sets intially so one row has to be added
    s2.startGameWithDeck(deck1, 3, 3);
    assertEquals("2SO2SO", s2.deckAsString());
    assertEquals(false, s7.isGameOver());
    //set exists so no rows have to be added
    s3.startGameWithDeck(deck4, 2, 2);
    assertEquals("3FO2EQ2ED2ED1EO1EO2FQ2FQ2SO2SO", s3.deckAsString());
    assertEquals(false, s7.isGameOver());
    //no sets initially so one row has to be added
    s4.startGameWithDeck(deck2, 2, 4);
    assertEquals("2SO2SO", s4.deckAsString());
    assertEquals(false, s7.isGameOver());
    //set exists so no rows have to be added
    s5.startGameWithDeck(deck, 4, 5);
    assertEquals("2FQ1FD2SD3ED3SD3SO1SQ", s5.deckAsString());
    assertEquals(false, s7.isGameOver());
    //no sets initially so two rows have to be added
    s6.startGameWithDeck(deck3, 2, 3);
    assertEquals("2SO2SO", s2.deckAsString());
    assertEquals(false, s7.isGameOver());
    //no sets so rows are added until the game is over
    s7.startGameWithDeck(deck7, 2, 3);
    assertEquals(true, s7.isGameOver());
    s8.startGameWithDeck(deck6, 1, 3);
    assertEquals("", s8.deckAsString());
    assertEquals(2, s8.getHeight());
  }

  @Test
  public void claimSet() {
    Coord c1 = new Coord(0,0);
    Coord c2 = new Coord(0,1);
    Coord c3 = new Coord(0,2);
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    GeneralSetGameModel s3 = new GeneralSetGameModel();
    GeneralSetGameModel s4 = new GeneralSetGameModel();
    GeneralSetGameModel s5 = new GeneralSetGameModel();
    s5.startGameWithDeck(deck5, 4, 5);
    s5.claimSet(c1, c2, c3);
    assertEquals("1ED1SD1FD1SQ", s5.deckAsString());
    s5.claimSet(c1, c2, c3);
    assertEquals("1SQ", s5.deckAsString());
    //tests that game is over after all sets are claimed
    s5.claimSet(c1, c2, c3);
    assertEquals(true, s5.isGameOver());
  }

  //test case where deck is too small for grid
  @Test
  public void testinvalidStartGameWithDeck() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    try {
      s2.startGameWithDeck(deck, 7, 6);
      fail("Should have thrown an IllegalArgumentException because the deck is too small");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //test case where deck is too small to claim a set
  @Test
  public void testinvalidStartGameWithDeck2() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    try {
      s2.startGameWithDeck(deck, 1, 2);
      fail("Should have thrown an IllegalArgumentException because the deck is too small");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //test case with negative height
  @Test
  public void testinvalidStartGameWithDeck3() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    try {
      s2.startGameWithDeck(deck, -3, 2);
      fail("Should have thrown an IllegalArgumentException because height is negative");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //test case with negative width
  @Test
  public void testinvalidStartGameWithDeck4() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    try {
      s2.startGameWithDeck(deck, 3, -2);
      fail("Should have thrown an IllegalArgumentException because width is negative");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //test case with null deck
  @Test
  public void testinvalidStartGameWithDeck5() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    try {
      s2.startGameWithDeck(null, 3, 2);
      fail("Should have thrown an IllegalArgumentException because width is negative");
    } catch (NullPointerException e) {
      //do nothing
    }
  }

  //tests the case where the claimed set isn't a valid set
  @Test
  public void testinvalidclaimSet() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    s2.startGameWithDeck(deck, 2, 3);
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(0, 2);
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalArgumentException because cards don't form a set");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests the case where the game hasn't started yet
  @Test
  public void testinvalidclaimSet2() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(0, 2);
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  //tests the case where the claimed coordinates are outside the grid
  @Test
  public void testinvalidclaimSet3() {
    Coord c1 = new Coord(3, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(2, 5);
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    s2.startGameWithDeck(deck, 4, 4);
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests the case where the claimed coordinates are outside the grid
  @Test
  public void testinvalidclaimSet4() {
    Coord c1 = new Coord(6, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(2, 2);
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    s2.startGameWithDeck(deck, 4, 4);
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests the case where the claimed coordinates are outside the grid
  @Test
  public void testinvalidclaimSet5() {
    Coord c1 = new Coord(3, 0);
    Coord c2 = new Coord(0, -1);
    Coord c3 = new Coord(2, 2);
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    s2.startGameWithDeck(deck, 4, 4);
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  @Test
  public void testgetHeight() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    GeneralSetGameModel s4 = new GeneralSetGameModel();
    GeneralSetGameModel s5 = new GeneralSetGameModel();
    GeneralSetGameModel s6 = new GeneralSetGameModel();
    GeneralSetGameModel s8 = new GeneralSetGameModel();
    //no sets intially so one row has to be added
    s2.startGameWithDeck(deck1, 3, 3);
    assertEquals(4, s2.getHeight());
    //no sets initially so one row has to be added
    s4.startGameWithDeck(deck2, 2, 4);
    assertEquals(3, s4.getHeight());
    //set exists so no rows have to be added
    s5.startGameWithDeck(deck, 4, 5);
    assertEquals(4, s5.getHeight());
    //no sets initially so two rows have to be added
    s6.startGameWithDeck(deck3, 2, 3);
    assertEquals(4, s6.getHeight());
    //no sets so rows are added until the game is over
    s8.startGameWithDeck(deck6, 1, 3);
    assertEquals(2, s8.getHeight());
  }

  @Test
  public void testgetWidth() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    GeneralSetGameModel s4 = new GeneralSetGameModel();
    GeneralSetGameModel s5 = new GeneralSetGameModel();
    GeneralSetGameModel s6 = new GeneralSetGameModel();
    GeneralSetGameModel s8 = new GeneralSetGameModel();
    //no sets intially so one row has to be added
    s2.startGameWithDeck(deck1, 3, 3);
    assertEquals(3, s2.getWidth());
    //no sets initially so one row has to be added
    s4.startGameWithDeck(deck2, 2, 4);
    assertEquals(4, s4.getWidth());
    //set exists so no rows have to be added
    s5.startGameWithDeck(deck, 4, 5);
    assertEquals(5, s5.getWidth());
    //no sets initially so two rows have to be added
    s6.startGameWithDeck(deck3, 2, 3);
    assertEquals(3, s6.getWidth());
    //no sets so rows are added until the game is over
    s8.startGameWithDeck(deck6, 1, 3);
    assertEquals(3, s8.getWidth());
  }

  @Test
  public void testanySetsPresent() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    GeneralSetGameModel s3 = new GeneralSetGameModel();
    GeneralSetGameModel s4 = new GeneralSetGameModel();
    GeneralSetGameModel s7 = new GeneralSetGameModel();
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(1, 0);
    //no sets intially so one row has to be added
    s2.startGameWithDeck(deck1, 3, 3);
    assertEquals(true, s2.anySetsPresent());
    //set exists so no rows have to be added
    s3.startGameWithDeck(deck4, 2, 2);
    assertEquals(true, s3.anySetsPresent());
    //no sets initially so one row has to be added
    s4.startGameWithDeck(deck2, 2, 4);
    assertEquals(true, s4.anySetsPresent());
    s7.startGameWithDeck(deck10, 2, 2);
    s7.claimSet(c1, c2, c3);
    assertEquals(false, s7.anySetsPresent());
  }

  @Test
  public void testisGameOver() {
    //game is over after not enough cards to replace a set
    Coord c1 = new Coord(0,0);
    Coord c2 = new Coord(0,1);
    Coord c3 = new Coord(0,2);
    Coord c4 = new Coord(1,0);
    Coord c5 = new Coord(1,1);
    GeneralSetGameModel s5 = new GeneralSetGameModel();
    s5.startGameWithDeck(deck5, 4, 5);
    s5.claimSet(c1, c2, c3);
    assertEquals("1ED1SD1FD1SQ", s5.deckAsString());
    s5.claimSet(c1, c2, c3);
    assertEquals("1SQ", s5.deckAsString());
    //tests that game is over after all sets are claimed
    s5.claimSet(c1, c2, c3);
    assertEquals(true, s5.isGameOver());

    //game is over after not enough cards to replace a row in claimset
    GeneralSetGameModel s6 = new GeneralSetGameModel();
    s6.startGameWithDeck(deck7b, 2, 2);
    s6.claimSet(c1, c4, c5);
    assertEquals(true, s6.isGameOver());

    //game is over after not enough cards to replace a row in start
    GeneralSetGameModel s7 = new GeneralSetGameModel();
    s7.startGameWithDeck(deck7c, 2, 2);
    assertEquals(true, s7.isGameOver());
  }

  @Test
  public void testisValidSet() {
    //game is over after not enough cards to replace a set
    Coord c1 = new Coord(0,0);
    Coord c2 = new Coord(0,1);
    Coord c3 = new Coord(0,2);
    Coord c4 = new Coord(1,0);
    Coord c5 = new Coord(1,1);
    GeneralSetGameModel s5 = new GeneralSetGameModel();
    s5.startGameWithDeck(deck5, 4, 5);
    assertEquals(true, s5.isValidSet(c1, c2, c3));
    s5.claimSet(c1, c2, c3);
    assertEquals(true, s5.isValidSet(c1, c2, c3));
    assertEquals(false, s5.isValidSet(c1, c2, c5));

    //game is over after not enough cards to replace a row in claimset
    GeneralSetGameModel s6 = new GeneralSetGameModel();
    s6.startGameWithDeck(deck7b, 2, 2);
    assertEquals(true, s6.isValidSet(c1, c4, c5));
    assertEquals(false, s6.isValidSet(c1, c2, c5));
  }

  @Test
  public void getScore() {
    Coord c1 = new Coord(0,0);
    Coord c2 = new Coord(0,1);
    Coord c3 = new Coord(0,2);
    Coord c4 = new Coord(1,0);
    GeneralSetGameModel s5 = new GeneralSetGameModel();
    s5.startGameWithDeck(deck5, 4, 5);
    s5.claimSet(c1, c2, c3);
    assertEquals(1, s5.getScore());
    try {
      s5.claimSet(c1, c2, c4);
      fail("Should have thrown an IllegalStateException because this is an invalid set");
    } catch (IllegalArgumentException ex) {
      //do nothing
    }
    assertEquals(1, s5.getScore());
    s5.claimSet(c1, c2, c3);
    assertEquals(2, s5.getScore());
    //tests that game is over after all sets are claimed
    s5.claimSet(c1, c2, c3);
    assertEquals(3, s5.getScore());
    assertEquals(true, s5.isGameOver());
  }

  @Test
  public void getCardAtCoord1() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    GeneralSetGameModel s3 = new GeneralSetGameModel();
    s2.startGameWithDeck(deck, 3, 3);
    assertEquals("3FO", s2.getCardAtCoord(0, 0).toString());
    assertEquals("2ED", s2.getCardAtCoord(1, 0).toString());
    assertEquals("3SQ", s2.getCardAtCoord(1, 2).toString());
    s3.startGameWithDeck(deck, 2, 4);
    assertEquals("1EQ", s3.getCardAtCoord(0, 0).toString());
    assertEquals("3FQ", s3.getCardAtCoord(0, 3).toString());
    assertEquals("2FO", s3.getCardAtCoord(1, 1).toString());
  }

  @Test
  public void getCardAtCoord2() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    GeneralSetGameModel s3 = new GeneralSetGameModel();
    s2.startGameWithDeck(deck, 3, 3);
    Coord c1 = new Coord(0,0);
    Coord c2 = new Coord(1,0);
    Coord c3 = new Coord(1,2);
    Coord c4 = new Coord(0,3);
    Coord c5 = new Coord(1,1);
    assertEquals("3FO", s2.getCardAtCoord(c1).toString());
    assertEquals("2ED", s2.getCardAtCoord(c2).toString());
    assertEquals("3SQ", s2.getCardAtCoord(c3).toString());
    s3.startGameWithDeck(deck, 2, 4);
    assertEquals("1EQ", s3.getCardAtCoord(c1).toString());
    assertEquals("3FQ", s3.getCardAtCoord(c4).toString());
    assertEquals("2FO", s3.getCardAtCoord(c5).toString());
  }

  @Test
  public void testgetCompleteDeck() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    s2.startGameWithDeck(deckcd, 3, 3);
    String deckstring1 = s2.deckAsString();
    GeneralSetGameModel s3 = new GeneralSetGameModel();
    s3.startGameWithDeck(s2.getCompleteDeck(), 3, 3);
    String deckstring2 = s3.deckAsString();
    assertEquals(deckstring1, deckstring2);
  }

  @Test
  public void testinvalidGetCoord() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    Coord c1 = new Coord(0,0);
    try {
      s2.getCardAtCoord(c1);
      fail("Should have thrown an IllegalStateException because game hasn't started yet");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testinvalidGetCoord2() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    try {
      s2.getCardAtCoord(new Coord(0,0));
      fail("Should have thrown an IllegalStateException because game hasn't started yet");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testinvalidGetWidth() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    Coord c1 = new Coord(0,0);
    try {
      s2.getWidth();
      fail("Should have thrown an IllegalStateException because game hasn't started yet");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testinvalidGetHeight() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    Coord c1 = new Coord(0,0);
    try {
      s2.getHeight();
      fail("Should have thrown an IllegalStateException because game hasn't started yet");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testinvalidanySetsPresent() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    Coord c1 = new Coord(0,0);
    try {
      s2.anySetsPresent();
      fail("Should have thrown an IllegalStateException because game hasn't started yet");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testinvalidisValidSet() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    Coord c1 = new Coord(0,0);
    Coord c2 = new Coord(1,0);
    Coord c3 = new Coord(1,2);
    Coord c4 = new Coord(0,3);
    Coord c5 = new Coord(1,1);
    try {
      s2.isValidSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because game hasn't started yet");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testinvalidisValidSet2() {
    GeneralSetGameModel s2 = new GeneralSetGameModel();
    Coord c1 = new Coord(0,0);
    Coord c2 = new Coord(1,0);
    Coord c4 = new Coord(0,3);
    s2.startGameWithDeck(deck, 2, 2);
    try {
      s2.isValidSet(c1, c2, c4);
      fail("Should have thrown an IllegalArgumentException because card is off grid");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

}
