import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.CardCount;
import cs3500.set.model.hw02.CardFilling;
import cs3500.set.model.hw02.CardShape;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.SetThreeGameModel;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the methods of SetThreeGameModel.
 */
public class SetThreeGameModelTest {
  SetThreeGameModel s1;

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
  Card cd1 = new Card(CardCount.Two, CardFilling.Full, CardShape.Oval);
  Card cd2 = new Card(CardCount.Two, CardFilling.Full, CardShape.Oval);
  Card cd3 = new Card(CardCount.Two, CardFilling.Full, CardShape.Diamond);
  Card cd4 = new Card(CardCount.Two, CardFilling.Full, CardShape.Diamond);
  Card cd5 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Squiggle);
  Card cd6 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Squiggle);
  Card cd7 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Diamond);
  Card cd8 = new Card(CardCount.Two, CardFilling.Empty, CardShape.Diamond);
  Card cd9 = new Card(CardCount.One, CardFilling.Empty, CardShape.Oval);
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

  //deck after set has been found
  List<Card> deckas = new ArrayList<Card>(Arrays.asList(c27, c16, c15,
          c2, c11, c22, c13, c12, c24, c3, c5, c7, c8, c17, c20));

  //deck with no sets
  List<Card> deckns = new ArrayList<Card>(Arrays.asList(cd1, cd2, cd3, cd4, cd5, cd6, cd7,
          cd8, cd9));
  List<Card> deckns2 = new ArrayList<Card>(Arrays.asList(c1, c2, c3, cd1, cd2, cd3, cd4, cd5,
          cd6, cd7, cd8, cd9));

  //deck with less than 9 cards
  List<Card> sdeck = new ArrayList<Card>(Arrays.asList(cd1, cd2, cd3, cd4, cd5, cd6));

  //deck with not enough cards to replace a set
  List<Card> deckn = new ArrayList<Card>(Arrays.asList(c18, c14, c1, c4, c21, c26, c9,
          c10, c23, c19));

  //deckm after start is called and grid is made
  List<Card> decknas = new ArrayList<Card>(Arrays.asList(c19));


  //deck in the order that getCompleteDeck produces
  List<Card> deckcd = new ArrayList<Card>(Arrays.asList(n10, c19, n1, c11, c20, c2, c12, n21, c3,
          c13, c22, n4, n14, n23, c5, c15, c24, c6, c16, c25, c7, c17, n26, c8, n18, c27, n7));

  //the grid after the game is started given deckn
  Card[][] grid1 = new Card[3][3];


  private Card[][] makeArray1() {

    grid1[0][0] = c18;
    grid1[0][1] = c14;
    grid1[0][2] = c1;
    grid1[1][0] = c4;
    grid1[1][1] = c21;
    grid1[1][2] = c26;
    grid1[2][0] = c9;
    grid1[2][1] = c10;
    grid1[2][2] = c23;
    return grid1;
  }

  //the grid after a set is claimed
  Card[][] grid2 = new Card[3][3];


  private Card[][] makeArray2() {

    grid2[0][0] = c19;
    grid2[0][1] = c14;
    grid2[0][2] = c25;
    grid2[1][0] = c4;
    grid2[1][1] = c21;
    grid2[1][2] = c26;
    grid2[2][0] = c9;
    grid2[2][1] = c10;
    grid2[2][2] = c6;
    return grid2;
  }

  @Before
  public void init() {
    this.s1 = new SetThreeGameModel();
    s1.startGameWithDeck(deck, 3, 3);
  }

  @Test
  public void testgetHeight() {
    assertEquals(3, s1.getHeight());
  }

  //tests getheight before the game has been started
  @Test
  public void testinvalidgetHeight() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.getHeight();
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testgetWidth() {
    assertEquals(3, s1.getWidth());
  }

  //tests getwidth before the game has been started
  @Test
  public void testinvalidgetWidth() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.getWidth();
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testgetScore() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 2);
    Coord c3 = new Coord(2, 2);
    assertEquals(0, s1.getScore());
    s1.claimSet(c1, c2, c3);
    assertEquals(1, s1.getScore());
  }

  //tests getscore before the game has been started
  @Test
  public void testinvalidgetScore() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.getScore();
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testgetCardAtCoord() {
    assertEquals((new Card(CardCount.One, CardFilling.Full, CardShape.Squiggle)).toString(),
            this.s1.getCardAtCoord(1, 1).toString());
    assertEquals((new Card(CardCount.One, CardFilling.Empty, CardShape.Diamond)).toString(),
            this.s1.getCardAtCoord(0, 2).toString());
  }

  //tests the case where the game hasn't started
  @Test
  public void testinvalidgetCardAtCoord() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.getCardAtCoord(1, 1);
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  //tests the case where the chosen coordinate is outside of the grid
  @Test
  public void testinvalidgetCardAtCoord2() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.getCardAtCoord(3, 0);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testgetCardAtCoord2() {
    Coord c1 = new Coord(1, 1);
    Coord c2 = new Coord(0, 2);
    assertEquals((new Card(CardCount.One, CardFilling.Full, CardShape.Squiggle)).toString(),
            this.s1.getCardAtCoord(c1).toString());
    assertEquals((new Card(CardCount.One, CardFilling.Empty, CardShape.Diamond)).toString(),
            this.s1.getCardAtCoord(c2).toString());
  }

  //tests the case where the game hasn't started
  @Test
  public void testinvalidgetCardAtCoord3() {
    Coord c1 = new Coord(1, 1);
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.getCardAtCoord(c1);
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  //tests the case where the chosen coordinate is outside of the grid
  @Test
  public void testinvalidgetCardAtCoord4() {
    Coord c1 = new Coord(3,-1);
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.getCardAtCoord(c1);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testisValidSet() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    s2.startGameWithDeck(deckns, 3, 3);
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 2);
    Coord c3 = new Coord(2, 2);
    Coord c4 = new Coord(0, 1);
    Coord c6 = new Coord(0, 2);
    assertEquals(true, s1.isValidSet(c1, c2, c3));
    assertEquals(false, s1.isValidSet(c1, c2, c4));
    assertEquals(false, s2.isValidSet(c1, c6, c4));
  }

  //tests the case where the game hasn't started
  @Test
  public void testinvalidisValidSet() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 2);
    Coord c3 = new Coord(2, 2);
    try {
      s2.isValidSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  //tests the case where the chosen coordinates are outside of the grid
  @Test
  public void testinvalidisValidSet3() {
    Coord c1 = new Coord(3, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(2, 2);
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.isValidSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testanySetsPresent() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    s2.startGameWithDeck(deckns, 3, 3);
    assertEquals(true, s1.anySetsPresent());
    assertEquals(false, s2.anySetsPresent());
  }

  //tests the case where the game hasn't started
  @Test
  public void testinvalidanySetsPresent() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.anySetsPresent();
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void teststartGameWithDeck() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    s2.startGameWithDeck(deckn, 3, 3);
    assertEquals(c18, s2.getCardAtCoord(0, 0));
    assertEquals(3, s2.getHeight());
    assertEquals(3, s2.getWidth());
    assertEquals("1EQ", s2.deckAsString());
  }


  //tests the case where the height and width aren't 3
  @Test
  public void testinvalidHeightAndWidth() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.startGameWithDeck(deck, 4, 5);
      fail("Should have thrown an IllegalArgumentException " +
              "because the height and width have to be 3");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests the case where the deck is too short
  @Test
  public void testinvalidDeckSize() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.startGameWithDeck(sdeck, 3, 3);
      fail("Should have thrown an IllegalArgumentException " +
              "because deck has to have at least 9 cards!");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests the case where the deck is null
  @Test
  public void testnulldeck() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.startGameWithDeck(null, 3, 3);
      fail("Should have thrown an NullPointerException because the height and width have to be 3");
    } catch (NullPointerException e) {
      //do nothing
    }
  }

  @Test
  public void testclaimSet() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 2);
    Coord c3 = new Coord(2, 2);
    SetThreeGameModel s2 = new SetThreeGameModel();
    s1.claimSet(c1, c2, c3);
    assertEquals(3, s1.getHeight());
    assertEquals(3, s1.getHeight());
    assertEquals(1, s1.getScore());
    assertEquals("3FQ3EO2FO1SD1SO2EQ2EO1FO2FQ1FD2SD3ED3SD3SO1SQ", s1.deckAsString());
  }

  //tests the case where 2 selected cards are the same
  @Test
  public void testinvalidclaimSet1() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 0);
    Coord c3 = new Coord(2, 2);
    try {
      s1.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalArgumentException because the " +
              "height and width have to be 3");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests the case where the claimed set isn't a valid set
  @Test
  public void testinvalidclaimSet2() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(2, 2);
    try {
      s1.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalArgumentException because cards don't form a set");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests the case where the game hasn't started yet
  @Test
  public void testinvalidclaimSet3() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(2, 2);
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the game hasn't started");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  //tests the case where the claimed coordinates are outside of the grid
  @Test
  public void testinvalidclaimSet4() {
    Coord c1 = new Coord(3, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(2, 2);
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  //tests the case where the claimed coordinates are outside of the grid
  @Test
  public void testinvalidclaimSet5() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 3);
    Coord c3 = new Coord(2, 2);
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  //tests the case where the claimed coordinates are outside of the grid
  @Test
  public void testinvalidclaimSet6() {
    Coord c1 = new Coord(0, 0);
    Coord c2 = new Coord(0, 1);
    Coord c3 = new Coord(4, 2);
    SetThreeGameModel s2 = new SetThreeGameModel();
    try {
      s2.claimSet(c1, c2, c3);
      fail("Should have thrown an IllegalStateException because the coordinate isnt on the grid");
    } catch (IllegalStateException e) {
      //do nothing
    }
  }

  @Test
  public void testisGameOver() {
    Coord c1 = new Coord(0,0);
    Coord c2 = new Coord(0,1);
    Coord c3 = new Coord(0,2);
    SetThreeGameModel s2 = new SetThreeGameModel();
    s2.startGameWithDeck(deckas, 3, 3);
    SetThreeGameModel s3 = new SetThreeGameModel();
    s3.startGameWithDeck(deckns2, 3, 3);
    s3.claimSet(c1, c2, c3);
    assertEquals(false, s2.isGameOver());
    assertEquals(true, s3.isGameOver());
    assertEquals(false, s1.isGameOver());
  }

  @Test
  public void testisGameOverAfterClaimSets() {
    Coord c1 = new Coord(0, 0);
    Coord c4 = new Coord(0, 1);
    Coord c2 = new Coord(0, 2);
    Coord c3 = new Coord(2, 2);
    SetThreeGameModel s2 = new SetThreeGameModel();
    SetThreeGameModel s3 = new SetThreeGameModel();
    s2.startGameWithDeck(deckn, 3, 3);
    s3.startGameWithDeck(s3.getCompleteDeck(), 3, 3);
    s1.claimSet(c1, c2, c3);
    assertEquals(false, s1.isGameOver());
    s2.claimSet(c1, c2, c3);
    assertEquals(true, s2.isGameOver());
    s3.claimSet(c1, c2, c4);
    assertEquals(false, s3.isGameOver());
  }

  @Test
  public void testgetCompleteDeck() {
    SetThreeGameModel s2 = new SetThreeGameModel();
    s2.startGameWithDeck(deckcd, 3, 3);
    String deckstring1 = s2.deckAsString();
    SetThreeGameModel s3 = new SetThreeGameModel();
    s3.startGameWithDeck(s2.getCompleteDeck(), 3, 3);
    String deckstring2 = s3.deckAsString();
    assertEquals(deckstring1, deckstring2);
  }



}


