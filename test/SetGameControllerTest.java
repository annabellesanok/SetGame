import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

import cs3500.set.controller.SetGameController;
import cs3500.set.controller.SetGameControllerImpl;
import cs3500.set.model.hw02.Coord;
import cs3500.set.model.hw02.SetGameModel;
import cs3500.set.model.hw02.SetThreeGameModel;
import cs3500.set.view.SetGameTextView;
import cs3500.set.view.SetGameView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Tests the interaction between the controller, model, and view.
 */
public class SetGameControllerTest {
  SetGameModel model = new SetThreeGameModel();

  class AppendableAlwaysThrowsExceptionMock implements Appendable {

    @Override
    public Appendable append(CharSequence csq) throws IOException {
      throw new IOException();
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
      throw new IOException();
    }

    @Override
    public Appendable append(char c) throws IOException {
      throw new IOException();
    }
  }

  /**
   * Mock class that gives the capacity to check whether the arguments are being passed.
   * in correctly.
   */
  public class ConfirmInputsMock implements SetGameModel {
    final StringBuilder log;

    public ConfirmInputsMock(StringBuilder log) {
      this.log = log;
    }

    @Override
    public void claimSet(Coord coord1, Coord coord2, Coord coord3) {
      log.append("Claimed: c1 = " + coord1 + "c2 = " + coord2
              + "c3 = " + coord3);
    }

    @Override
    public void startGameWithDeck(List deck, int height, int width)
            throws IllegalArgumentException {
      log.append("Started: deck = " + deck.toString() + "height = " + height + "width = " + width);
    }

    @Override
    public int getWidth() throws IllegalStateException {
      return 0;
    }

    @Override
    public int getHeight() throws IllegalStateException {
      return 0;
    }

    @Override
    public int getScore() throws IllegalStateException {
      return 0;
    }

    @Override
    public boolean anySetsPresent() {
      return false;
    }

    @Override
    public boolean isValidSet(Coord coord1, Coord coord2, Coord coord3)
            throws IllegalArgumentException {
      log.append("is valid set claim: c1 = " + coord1 + "c2 = " + coord2 + "c3 = " + coord3);
      return false;
    }

    @Override
    public Object getCardAtCoord(int row, int col) {
      log.append("Get at coord: row = " + row + "col = " + col);
      return null;
    }

    @Override
    public Object getCardAtCoord(Coord coord) {
      log.append("Get at coord: coord = " + coord);
      return null;
    }

    @Override
    public boolean isGameOver() {
      return false;
    }

    @Override
    public List getCompleteDeck() {
      return null;
    }
  }

  /**
   * Mock class for the view.
   */
  public class ConfirmInputsToViewMock implements SetGameView {
    final StringBuilder log;

    /**
     * Provides a mock for the view that allows to check whether inputs are properly transmitted.
     * @param log represents a log of the inputs
     */
    public ConfirmInputsToViewMock(StringBuilder log) {
      this.log = log;
    }

    @Override
    public void renderGrid() throws IOException {
      //should be empty
    }

    @Override
    public void renderMessage(String message) throws IOException {
      this.log.append("Message: " + message);
    }
  }



  //tests illegal argument exception with a null model
  @Test
  public void testInvalidConstruction() {
    Readable in = new StringReader("q");
    Appendable out = new StringBuilder();
    try {
      SetGameController controller = new SetGameControllerImpl(null,
              new SetGameTextView(model, out), in);
      fail("Should have thrown an IllegalArgumentException when given invalid destination");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests illegal argument exception with a null view
  @Test
  public void testInvalidConstruction2() {
    Readable in = new StringReader("q");
    Appendable out = new StringBuilder();
    try {
      SetGameController controller = new SetGameControllerImpl(model,
              null, in);
      fail("Should have thrown an IllegalArgumentException when given invalid destination");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests illegal argument exception with a null readable
  @Test
  public void testInvalidConstruction3() {
    Readable in = new StringReader("q");
    Appendable out = new StringBuilder();
    try {
      SetGameController controller = new SetGameControllerImpl(null,
              new SetGameTextView(model, out), null);
      fail("Should have thrown an IllegalArgumentException when given invalid destination");
    } catch (IllegalArgumentException e) {
      //do nothing
    }
  }

  //tests that quitting displays the correct message
  @Test
  public void testQuitMessage() {
    Readable in = new StringReader("3 \n 3 \n q");
    Appendable out = new StringBuilder();
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, out), in);
    controller.playGame();
    assertEquals("1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 0\nGame quit!\n" +
                    "State of game when quit:\n1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 0\n"
            , out.toString());
  }

  //tests that quitting immediately displays correct message
  @Test
  public void testImmediateQuit() {
    Readable in = new StringReader("q");
    Appendable out = new StringBuilder();
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, out), in);
    controller.playGame();
    assertEquals("Game quit!\nScore: 0\n", out.toString());
  }

  //tests that score is incremented and displayed properly
  @Test
  public void testShowScoreAfterSetClaimed() {
    Readable in = new StringReader("3 3 1 1 1 2 1 3 q");
    Appendable out = new StringBuilder();
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, out), in);
    controller.playGame();
    assertEquals("1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\n" +
                    "Score: 0\n2EO 2EQ 2ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 1\nGame quit!\n" +
                    "State of game when quit:\n2EO 2EQ 2ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 1\n"
            , out.toString());
  }

  //tests that the game continues after invalid input is entered
  @Test
  public void testContinueAfterInvalidInput() {
    Readable in = new StringReader("3 3 1 a 1 1 2 1 3 q");
    Appendable out = new StringBuilder();
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, out), in);
    controller.playGame();
    assertEquals("1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\n" +
                    "Score: 0\n2EO 2EQ 2ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 1\nGame quit!\n" +
                    "State of game when quit:\n2EO 2EQ 2ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 1\n"
            , out.toString());
  }

  //tests that game functions after valid width and height are set
  @Test
  public void testValidWidthHeight() {
    Readable in = new StringReader("3 \n 3 \n q");
    Appendable out = new StringBuilder();
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, out), in);
    controller.playGame();
    assertEquals("1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 0\nGame quit!\n" +
                    "State of game when quit:\n1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 0\n"
            , out.toString());
  }

  //tests that the state of the game is properly rendered after height and width are set
  @Test
  public void testShowGrid() {
    Readable in = new StringReader("3 \n 3 \n q");
    Appendable out = new StringBuilder();
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, out), in);
    controller.playGame();
    assertEquals("1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 0\nGame quit!\n" +
                    "State of game when quit:\n1EO 1EQ 1ED\n1SO 1SQ 1SD\n1FO 1FQ 1FD\nScore: 0\n"
            , out.toString());
  }

  //tests an invalid width
  @Test
  public void testInvalidWidth() {
    Readable in = new StringReader("3 2 q");
    Appendable out = new StringBuilder();
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, out), in);
    controller.playGame();
    assertEquals("Invalid height/width. Try again. Height and width must be equal to 3." +
                    "\nGame quit!\nScore: 0\n", out.toString());
  }

  //tests an invalid height
  @Test
  public void testInvalidHeight() {
    Readable in = new StringReader("2 3 q");
    Appendable out = new StringBuilder();
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, out), in);
    controller.playGame();
    assertEquals("Invalid height/width. Try again. Height and width must be equal to 3." +
            "\nGame quit!\nScore: 0\n", out.toString());
  }

  //tests that an ioexception is thrown properly due to render message
  @Test
  public void testReactionToIOExceptionRenderMessage() {
    Readable in = new StringReader("3 3 q");
    StringBuilder log = new StringBuilder();
    SetGameView view = new SetGameTextView(model, new AppendableAlwaysThrowsExceptionMock());
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, log), in);
    try {
      view.renderMessage("test io");
      fail("Expected IOException");
    } catch (IOException ignore) {
      //do nothing b/c you passed
    }
  }

  //tests that an ioexception is thrown properly due to render grid
  @Test
  public void testReactionToIOExceptionRenderGrid() {
    Readable in = new StringReader("3 3 q");
    StringBuilder log = new StringBuilder();
    model.startGameWithDeck(model.getCompleteDeck(), 3, 3);
    SetGameView view = new SetGameTextView(model, new AppendableAlwaysThrowsExceptionMock());
    SetGameController controller =
            new SetGameControllerImpl(model, new SetGameTextView(model, log), in);
    try {
      view.renderGrid();
      fail("Expected IOException");
    } catch (IOException ignore) {
      //do nothing b/c you passed
    }
  }

  //tests that an IllegalState is thrown in the controller
  @Test
  public void testReactionToIOExceptionInController() {
    Readable in = new StringReader("3 3 q");
    StringBuilder log = new StringBuilder();
    model.startGameWithDeck(model.getCompleteDeck(), 3, 3);
    SetGameView view = new SetGameTextView(model, new AppendableAlwaysThrowsExceptionMock());
    SetGameController controller = new SetGameControllerImpl(model, view, in);
    try {
      controller.playGame();
      fail("Expected IllegalState due to IOException");
    } catch (IllegalStateException ignore) {
      //do nothing b/c you passed
    }
  }

  //test proper inputs for a valid claim set
  @Test
  public void testInputsGoDirectlyToModel() throws IOException {
    Readable in = new StringReader("3 4 q");
    StringBuilder log = new StringBuilder();
    SetGameController controller = new SetGameControllerImpl(new ConfirmInputsMock(log),
            new SetGameTextView(model, log), in);
    controller.playGame();
    assertEquals("Claimed: c1 = (1, 1) c2 = (1, 2) c3 = (1, 3)", log.toString());
  }

  //test proper inputs for an invalid claim set
  @Test
  public void testInputsGoDirectlyToModel2() throws IOException {
    Reader in = new StringReader("3 3 1 1 2 2 1 3 q");
    StringBuilder dontCareOutput = new StringBuilder();
    StringBuilder log = new StringBuilder();
    SetGameModel mockmodel = new ConfirmInputsMock(log);
    SetGameController controller2 = new SetGameControllerImpl(mockmodel,
            new SetGameTextView(mockmodel, dontCareOutput), in);
    controller2.playGame();
    assertEquals("Claimed: c1 = (1, 1) c2 = (2, 2) c3 = (1, 3)", log.toString());
  }

  //test proper inputs for a valid claim set
  @Test
  public void testInputsGoDirectlyToModel3() throws IOException {
    Reader in = new StringReader("3 3 1 1 1 2 1 3 q");
    StringBuilder dontCareOutput = new StringBuilder();
    StringBuilder log = new StringBuilder();
    SetGameModel mockmodel = new ConfirmInputsMock(log);
    SetGameController controller2 = new SetGameControllerImpl(mockmodel,
            new SetGameTextView(mockmodel, dontCareOutput), in);
    controller2.playGame();
    assertEquals("Claimed: c1 = (1, 1) c2 = (1, 2) c3 = (1, 3)", log.toString());
  }

  //test proper inputs for a valid claimset with illegal character
  @Test
  public void testInputsGoDirectlyToModel4() throws IOException {
    Reader in = new StringReader("3 3 1 a 1 2 2 1 3 q");
    StringBuilder dontCareOutput = new StringBuilder();
    StringBuilder log = new StringBuilder();
    SetGameModel mockmodel = new ConfirmInputsMock(log);
    SetGameController controller2 = new SetGameControllerImpl(mockmodel,
            new SetGameTextView(mockmodel, dontCareOutput), in);
    controller2.playGame();
    assertEquals("Claimed: c1 = (1, 1) c2 = (2, 2) c3 = (1, 3)", log.toString());
  }

  //input invalid height/width
  @Test
  public void testInputsGoDirectlyToView() throws IOException {
    Readable in = new StringReader("3 4 q");
    StringBuilder log = new StringBuilder();
    SetGameController controller = new SetGameControllerImpl(model,
            new ConfirmInputsToViewMock(log), in);
    controller.playGame();
    assertEquals("Message: Invalid height/width. Try again. " +
            "Height and width must be equal to 3.Message: Game quit!" +
            "Message: Score: 0", log.toString());
  }

  //claimed valid set
  @Test
  public void testInputsGoDirectlyToView2() throws IOException {
    Readable in = new StringReader("3 3 1 1 1 2 1 3 q");
    StringBuilder log = new StringBuilder();
    SetGameController controller = new SetGameControllerImpl(model,
            new ConfirmInputsToViewMock(log), in);
    controller.playGame();
    assertEquals("Message: Score: 0Message: Score: 1Message: Game quit!" +
            "Message: State of game when quit:Message: Score: 1", log.toString());
  }

  //entered invalid value then claimed valid set
  @Test
  public void testInputsGoDirectlyToView3() throws IOException {
    Readable in = new StringReader("3 3 1 a 1 1 2 1 3 q");
    StringBuilder log = new StringBuilder();
    SetGameController controller = new SetGameControllerImpl(model,
            new ConfirmInputsToViewMock(log), in);
    controller.playGame();
    assertEquals("Message: Score: 0Message: Score: 1Message: Game quit!" +
            "Message: State of game when quit:Message: Score: 1", log.toString());
  }

  //entered invalid value then claimed invalid set
  @Test
  public void testInputsGoDirectlyToView4() throws IOException {
    Readable in = new StringReader("3 3 1 a 1 2 2 1 3 q");
    StringBuilder log = new StringBuilder();
    SetGameController controller = new SetGameControllerImpl(model,
            new ConfirmInputsToViewMock(log), in);
    controller.playGame();
    assertEquals("Message: Score: 0Message: Invalid claim. Try again. " +
            "Selected cards don't form a valid set!Message: Score: 0Message: " +
            "Game quit!Message: State of game when quit:Message: Score: 0", log.toString());
  }

  //claimed value that's not on grid
  @Test
  public void testInputsGoDirectlyToView5() throws IOException {
    Readable in = new StringReader("3 3 1 1 1 4 1 3 q");
    StringBuilder log = new StringBuilder();
    SetGameController controller = new SetGameControllerImpl(model,
            new ConfirmInputsToViewMock(log), in);
    controller.playGame();
    assertEquals("Message: Score: 0Message: Invalid claim. Try again. Selected " +
            "card is off the gridMessage: Score: 0Message: Game quit!Message: State of game " +
            "when quit:Message: Score: 0", log.toString());
  }

}


