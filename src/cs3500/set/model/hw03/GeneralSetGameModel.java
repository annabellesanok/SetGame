package cs3500.set.model.hw03;

import java.util.ArrayList;
import java.util.List;

import cs3500.set.model.hw02.AbstractSetGameModel;
import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.Coord;

/**
 * Represents a general game of set, which can be played with any given height and width.
 */
public class GeneralSetGameModel extends AbstractSetGameModel {

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
    } else {
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
          addRow();
        }
      }
    }
  }

  @Override
  public void startGameWithDeck(List deck, int height, int width) throws IllegalArgumentException {
    if (height * width < 3) {
      throw new IllegalArgumentException("Deck is too small!");
    }
    if (height < 0 ||  width < 0) {
      throw new IllegalArgumentException("Can't have a negative height and width!");
    }
    if (deck.size() < height * width) {
      throw new IllegalArgumentException("Deck is too small for given height and width!");
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

      //initializes grid and adds an extra row if there's no sets present
      Card[][] arr = new Card[height][width];
      for (int i = 0; i < (height * width); i++) {
        int row = i / width;
        int col = i % width;
        arr[row][col] = (Card) deck.get(i);
      }
      deck.subList(0, (height * width)).clear();
      this.grid = arr;
      if (!anySetsPresent()) {
        addRow();
      }
    }
  }

  private void addRow() {
    while (!anySetsPresent() && !isGameOver()) {
      //makes a copy of the current grid
      Card[][] arr2 = new Card[height + 1][width];
      for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
          arr2[row][col] = this.grid[row][col];
        }
      }
      //adding a new row
      try {
        int addrow = height;
        for (int col = 0; col < width; col++) {
          arr2[addrow][col] = (Card) deck.get(col);
        }
        deck.subList(0, (width)).clear();
        this.height = height + 1;
        this.grid = arr2;
      } catch (IndexOutOfBoundsException e) {
        this.gameOver = true;
      }
      this.grid = arr2;
    }
  }
}
