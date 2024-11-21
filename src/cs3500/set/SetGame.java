package cs3500.set;

import java.io.InputStreamReader;
import java.util.Scanner;

import cs3500.set.controller.SetGameController;
import cs3500.set.controller.SetGameControllerImpl;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.model.hw03.GeneralSetGameModel;
import cs3500.set.view.SetGameTextView;
import cs3500.set.view.SetGameView;

/**
 * A main method that allows the game to be played.
 */
public final class SetGame {
  /**
   * Allows the game to be played with either a set three game model, or a general model.
   * @param args represents the command inputted for the desired model
   */
  public static void main(String[] args) {
    Readable rd = new InputStreamReader(System.in);
    Scanner sc = new Scanner(rd);
    Appendable ap = System.out;
    String instruction = sc.next();
    if (instruction.equals("three")) {
      SetGameModel threemodel = new SetThreeGameModel();
      SetGameView view = new SetGameTextView(threemodel, ap);
      SetGameController controller = new SetGameControllerImpl(threemodel, view, rd);
      controller.playGame();
    }
    else if (instruction.equals("general")) {
      SetGameModel generalmodel = new GeneralSetGameModel();
      SetGameView view = new SetGameTextView(generalmodel, ap);
      SetGameController controller = new SetGameControllerImpl(generalmodel, view, rd);
      controller.playGame();
    }
  }
}