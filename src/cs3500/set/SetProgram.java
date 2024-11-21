package cs3500.set;

import java.io.IOException;
import java.io.InputStreamReader;

import cs3500.set.controller.SetGameController;
import cs3500.set.controller.SetGameControllerImpl;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.view.SetGameTextView;
import cs3500.set.view.SetGameView;

/**
 * Program that allows for running a game of set.
 */
public class SetProgram {
  /**
   * Main method that allows you to play a game of set.
   * @param args represent inputs that the user uses to play the game
   * @throws IOException when there is in IO transmission error
   */
  public static void main(String[] args) throws IOException {
    SetGameModel model = new SetThreeGameModel();
    Appendable ap = System.out;
    SetGameView view = new SetGameTextView(model, ap);
    Readable rd = new InputStreamReader(System.in);
    SetGameController controller = new SetGameControllerImpl(model, view, rd);
    controller.playGame();
  }
}
