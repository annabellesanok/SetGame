package cs3500.set.model.hw02;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class to represent the methods of a set game.
 * Helps to minimize duplicate code among the different set models.
 */

public abstract class AbstractSetGameModel implements SetGameModel {
  protected int score;
  protected List<Card> deck;
  protected Card[][] grid;
  protected int height;
  protected int width;
  protected boolean start;
  protected boolean gameOver;


  //returns true if coord is within the grid, false if it isn't
  protected boolean isValidCoord(Coord coord) {
    return (coord.row <= (height - 1) && coord.row >= 0
            && coord.col <= (width - 1) && coord.col >= 0);
  }

  @Override
  public void claimSet(Coord coord1, Coord coord2, Coord coord3) {
    //protects in the case where the game hasn't started yet
    if (!this.start) {
      throw new IllegalStateException("Game has not started!");
    }
    //protects in the case of the 3 selected cards not representing a set
    if (!isValidSet(coord1, coord2, coord3)) {
      throw new IllegalArgumentException("Selected cards don't form a valid set!");
    }
    //protects in the case of claiming a card outside the grid
    if (!isValidCoord(coord1) || !isValidCoord(coord2) || !isValidCoord(coord3)) {
      throw new IllegalArgumentException("Selected card is off the grid");
    }
    else {
      this.score = this.score + 1;
      if (deck.size() < 3) {
        this.gameOver = true;
      }
      if (this.deck.size() > 2) {
        int row1 = coord1.row;
        int col1 = coord1.col;
        //sets the card at the first coord to the card at the top of deck, and removes from deck
        this.grid[row1][col1] = deck.get(0);
        deck.remove(0);

        int row2 = coord2.row;
        int col2 = coord2.col;
        this.grid[row2][col2] = deck.get(0);
        deck.remove(0);

        int row3 = coord3.row;
        int col3 = coord3.col;
        this.grid[row3][col3] = deck.get(0);
        deck.remove(0);
        if (!anySetsPresent()) {
          this.gameOver = true;
        }
      }
    }
  }

  @Override
  public void startGameWithDeck(List deck, int height, int width) throws IllegalArgumentException {
    if ((height != 3) && (width != 3)) {
      throw new IllegalArgumentException("Height and Width must each be equal to 3!");
    }
    if (deck.size() < 9) {
      throw new IllegalArgumentException("Deck has to have at least 9 cards!");
    }
    if (deck == null) {
      throw new IllegalArgumentException("Deck cannot be null!");
    } else {
      this.deck = new ArrayList<Card>();
      this.grid = null;
      this.score = 0;
      this.height = 0;
      this.width = 0;
      this.start = false;

      this.height = height;
      this.width = width;
      this.deck = deck;
      this.start = true;
      Card[][] arr = new Card[height][width];
      for (int i = 0; i < (height * width); i++) {
        int row = i / width;
        int col = i % width;
        arr[row][col] = (Card) deck.get(i);
      }
      deck.subList(0, (height * width)).clear();
      this.grid = arr;
    }
  }

  @Override
  public int getWidth() throws IllegalStateException {
    //protects in the case where the game hasn't started yet
    if (!this.start) {
      throw new IllegalStateException("Game has not started!");
    } else {
      return this.width;
    }
  }

  @Override
  public int getHeight() throws IllegalStateException {
    if (!this.start) {
      throw new IllegalStateException("Game has not started!");
    } else {
      return this.height;
    }
  }

  @Override
  public int getScore() throws IllegalStateException {
    if (!this.start) {
      throw new IllegalStateException("Game has not started!");
    } else {
      return this.score;
    }
  }

  @Override
  public boolean anySetsPresent() {
    if (!this.start) {
      throw new IllegalStateException("Game has not started!");
    }
    ArrayList<Coord> gridCoords = new ArrayList<>();

    for (int i = 0; i <= height - 1; i++) {
      for (int j = 0; j <= width - 1; j++) {
        Coord coord = new Coord(i, j);
        gridCoords.add(coord);
      }
    }
    for (int i = 0; i < height * width; i++) {
      for (int j = 0; j < height * width; j++) {
        for (int k = 0; k < height * width; k++) {
          if (this.isValidSet(gridCoords.get(i), gridCoords.get(j), gridCoords.get(k))
                  && (i != j) && (j != k) && (i != k)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  @Override
  public boolean isValidSet(Coord coord1, Coord coord2, Coord coord3)
          throws IllegalArgumentException {

    Card card1 = getCardAtCoord(coord1);
    Card card2 = getCardAtCoord(coord2);
    Card card3 = getCardAtCoord(coord3);

    if (!isValidCoord(coord1) || !isValidCoord(coord2) || !isValidCoord(coord3)) {
      throw new IllegalArgumentException("Selected card is off the grid");
    } else {
      return (((threeEqualStrings(card1.count.getCountValue(), card2.count.getCountValue(),
              card3.count.getCountValue()))
              ||
              (threeUnequalStrings(card1.count.getCountValue(), card2.count.getCountValue(),
                      card3.count.getCountValue())))
              &&
              ((threeEqualStrings(card1.filling.getFillingValue(), card2.filling.getFillingValue(),
                      card3.filling.getFillingValue()))
                      ||
                      (threeUnequalStrings(card1.filling.getFillingValue(),
                              card2.filling.getFillingValue(),
                              card3.filling.getFillingValue())))
              &&
              ((threeEqualStrings(card1.shape.getShapeValue(), card2.shape.getShapeValue(),
                      card3.shape.getShapeValue()))
                      ||
                      (threeUnequalStrings(card1.shape.getShapeValue(), card2.shape.getShapeValue(),
                              card3.shape.getShapeValue()))));
    }
  }

  private boolean threeEqualStrings(String s1, String s2, String s3) {
    return ((s1.equals(s2)) && (s2.equals(s3)) && (s1.equals(s3)));
  }

  private boolean threeUnequalStrings(String s1, String s2, String s3) {
    return ((s1 != s2) && (s2 != s3) && (s1 != s3));
  }

  @Override
  public Card getCardAtCoord(int row, int col) {
    if (!this.start) {
      throw new IllegalStateException("Game has not started!");
    }
    if (!isValidCoord(new Coord(row, col))) {
      throw new IllegalArgumentException("Selected card is off the grid");
    }
    return this.grid[row][col];
  }

  @Override
  public Card getCardAtCoord(Coord coord) {
    if (!this.start) {
      throw new IllegalStateException("Game has not started!");
    }
    if (!isValidCoord(coord)) {
      throw new IllegalArgumentException("Selected card is off the grid");
    }
    return this.grid[coord.row][coord.col];
  }

  @Override
  public boolean isGameOver() {
    return this.gameOver;
  }

  @Override
  public List getCompleteDeck() {
    List<Card> deck = new ArrayList<Card>();
    for (CardCount cc : CardCount.values()) {
      for (CardFilling cf : CardFilling.values()) {
        for (CardShape cs : CardShape.values()) {
          Card card = new Card(cc, cf, cs);
          if (!deck.contains(card)) {
            deck.add(card);
          }
        }
      }
    }
    return deck;
  }

  /**
   * Returns the deck as a string, to help with testing.
   */
  public String deckAsString() {
    String resultDeck = "";
    for (Card c : this.deck) {
      resultDeck = resultDeck + c.toString();
    }
    return resultDeck;
  }
}
