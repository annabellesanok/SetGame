package cs3500.set.controller;

/**
 * Controller that facilities the interactions between the view being displayed to the player,
 * and the model properly handling inputs.
 */
public interface SetGameController {

  /**
   * method that starts a new game of set.
   * throws an IllegalStateException if the controller can't read input or transmit output.
   */
  void playGame() throws IllegalStateException;
}
