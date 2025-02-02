package cs3500.set.model.hw03;

/**
 * Do not modify this file. This file should compile correctly with your code!
 */
public class Hw04TypeChecks {
  /**
   * Runs the program, but this method should NEVER be run.
   * It does nothing of import.
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Readable rd = null;
    Appendable ap = null;
    helperSetThree(new cs3500.set.model.hw02.SetThreeGameModel(),
            rd, ap);
    helperGeneral(new cs3500.set.model.hw03.GeneralSetGameModel(),
            rd, ap);
  }

  private static void helperSetThree(cs3500.set.model.hw02.SetGameModel model,
                                     Readable rd,Appendable ap) {
    new cs3500.set.controller.SetGameControllerImpl(model,
            new cs3500.set.view.SetGameTextView(model, ap), rd);
  }

  private static void helperGeneral(cs3500.set.model.hw02.SetGameModel model,
                                    Readable rd,Appendable ap) {
    new cs3500.set.controller.SetGameControllerImpl(model,
            new cs3500.set.view.SetGameTextView(model, ap), rd);
  }

}
