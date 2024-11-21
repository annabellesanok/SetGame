package cs3500.set.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.view.SetGameView;

/**
 * Implements the controller interface, and provides a controller for a set game to be played.
 */
public class SetGameControllerImpl implements SetGameController {

  private Readable in;
  private SetGameModel model;
  private SetGameView view;

  /**
   * Represents a controller that allows you to play a game of set.
   * @param model represents the set game model that handles functionality
   * @param view contains messages and grid that are displayed to the viewer
   * @param in the inputs that are being delegated to the model and view
   * @throws IllegalArgumentException when any of the fields are null
   */
  public SetGameControllerImpl(SetGameModel model, SetGameView view, Readable in)
          throws IllegalArgumentException {
    if (model == null || view == null || in == null) {
      throw new IllegalArgumentException("inputs cannot be null!");
    }
    this.model = model;
    this.view = view;
    this.in = in;
  }

  /**
   * Starts a game of set.
   * @throws IllegalStateException if there is an IO exception or a NoSuchElement exception
   */
  public void playGame() throws IllegalStateException {
    Scanner scan = new Scanner(in);
    try {
      int height = 0;
      int width = 0;
      String in = "";
      boolean quit = false;
      boolean validHeightWidth = false;
      while (!validHeightWidth && !quit) {
        if (isQuit(in)) {
          quit = true;
        } else {
          height = getValidVal(scan);
          if (height == -1) {
            in = "q";
            quit = true;
          }
          width = getValidVal(scan);
          if (width == -1) {
            in = "q";
            quit = true;
          }
          if (!quit) {
            try {
              if (height != model.getHeight() || width != model.getWidth()) {
                throw new IllegalArgumentException("Height and width must be equal to 3.");
              }
              validHeightWidth = true;
            } catch (IllegalArgumentException | NoSuchElementException e) {
              view.renderMessage("Invalid height/width. Try again. " + e.getMessage());
            }
          }
        }
      }
      if (quit) {
        view.renderMessage("Game quit!");
        view.renderMessage("Score: 0");
      }
      if (!quit) {
        model.startGameWithDeck(model.getCompleteDeck(), height, width);
      }
      String input = "";
      while (!model.isGameOver() && !quit) {
        view.renderGrid();
        view.renderMessage("Score: " + model.getScore());
        input = "";
        int row1 = getValidVal(scan);
        if (row1 == -1) {
          input = "q";
        }
        int col1 = getValidVal(scan);
        if (col1 == -1) {
          input = "q";
        }
        int row2 = getValidVal(scan);
        if (row2 == -1) {
          input = "q";
        }
        int col2 = getValidVal(scan);
        if (col2 == -1) {
          input = "q";
        }
        int row3 = getValidVal(scan);
        if (row3 == -1) {
          input = "q";
        }
        int col3 = getValidVal(scan);
        if (col3 == -1) {
          input = "q";
        }
        if (isQuit(input)) {
          quit = true;
          view.renderMessage("Game quit!");
          view.renderMessage("State of game when quit:");
          view.renderGrid();
          view.renderMessage("Score: " + model.getScore());
        } else {
          try {
            Coord c1 = new Coord(row1 - 1, col1 - 1);
            Coord c2 = new Coord(row2 - 1, col2 - 1);
            Coord c3 = new Coord(row3 - 1, col3 - 1);
            model.claimSet(c1, c2, c3);
          } catch (IllegalArgumentException e) {
            view.renderMessage("Invalid claim. Try again. " + e.getMessage());
          }
        }
      }
      if (!quit) {
        if (!isQuit(input)) {
          view.renderMessage("Game over!");
          view.renderMessage("Score: " + model.getScore());
        }
      }
    } catch (IOException | NoSuchElementException error) {
      throw new IllegalStateException("IO Error");
    }
  }

  private int getValidVal(Scanner scan) throws IOException, NoSuchElementException {
    int val = 0;
    boolean validVal = false;
    while (!validVal) {
      if (scan.hasNext("q") || scan.hasNext("Q")) {
        return -1;
      }
      try {
        scan.hasNext();
      } catch (NoSuchElementException ex) {
        throw new IllegalStateException("No more inputs to read");
      }
      try {
        val = scan.nextInt();
        validVal = true;
      } catch (InputMismatchException e) {
        scan.next();
      }
    }
    return val;
  }

  private boolean isQuit(String in) {
    return in.equals("q") || in.equals("Q");
  }
}
