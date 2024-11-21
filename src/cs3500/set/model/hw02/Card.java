package cs3500.set.model.hw02;

/**
 * A card is a game piece that contains a count, filling, and shape.
 */

public class Card {
  protected final CardCount count;
  protected final CardFilling filling;
  protected final CardShape shape;
  protected Coord location;

  /**
   * Creates a Card using a count, filling, and shape.
   * @param count represents the number of shapes on the card
   * @param filling represents the shading of the shapes
   * @param shape represents the shape of the card
   * @throws IllegalArgumentException when an invalid or null value is passed into each field
   */

  public Card(CardCount count, CardFilling filling, CardShape shape)
          throws IllegalArgumentException {
    this.count = count;
    this.filling = filling;
    this.shape = shape;


    if ((count != CardCount.One) && (count != CardCount.Two) && (count != CardCount.Three)) {
      throw new IllegalArgumentException("Invalid count");
    }
    if ((filling != CardFilling.Full) && (filling != CardFilling.Striped) &&
            (filling != CardFilling.Empty)) {
      throw new IllegalArgumentException("Invalid filling");
    }
    if ((shape != CardShape.Oval) && (shape != CardShape.Diamond) &&
            (shape != CardShape.Squiggle)) {
      throw new IllegalArgumentException("Invalid shape");
    }

  }

  @Override
  public String toString() {
    return (this.count.getCountValue() + this.filling.getFillingValue() +
            this.shape.getShapeValue());
  }

}
