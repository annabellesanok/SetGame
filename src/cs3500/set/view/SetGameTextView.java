package cs3500.set.view;

import java.io.IOException;

import cs3500.set.model.hw02.Card;
import cs3500.set.model.hw02.SetGameModelState;


/**
 * A SetGameTextView gives a view into the current state of the grid with its toString method.
 */

public class SetGameTextView implements SetGameView {
  private SetGameModelState game;
  private Appendable destination;

  /**
   * Takes in a SetGameModelState.
   * @param game represents the current game that is being viewed
   * @throws IllegalArgumentException when the given model is null
   */
  public SetGameTextView(SetGameModelState game) throws IllegalArgumentException {
    if (game == null) {
      throw new IllegalArgumentException("game cannot be null");
    }
    this.game = game;
    this.destination = System.out;
  }

  /**
   * Takes in a SetGameModelState.
   * @param game represents the current game that is being viewed
   * @param destination represents the destination that the view is being sent to
   * @throws IllegalArgumentException when the given model is null
   */

  public SetGameTextView(SetGameModelState game, Appendable destination)
          throws IllegalArgumentException {
    if (game == null || destination == null) {
      throw new IllegalArgumentException("game or destination cannot be null");
    }
    this.game = game;
    this.destination = destination;
  }


  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < game.getHeight(); i++) {
      for (int j = 0; j < game.getWidth(); j++) {
        Card card = (Card) game.getCardAtCoord(i, j );
        str.append(card.toString());
        if (j != game.getWidth() - 1) {
          str.append(" ");
        }
        else {
          if (i != game.getHeight() - 1) {
            str.append("\n");
          }
        }
      }
    }
    return str.toString();
  }

  @Override
  public void renderGrid() throws IOException {
    this.destination.append(this.toString() + "\n");
  }

  @Override
  public void renderMessage(String message) throws IOException {
    this.destination.append(message + "\n");
  }
}
