package cs3500.set.model.hw02;

/**
 * A CardShape is an enumeration containing the 3 possibilities for shape values.
 * These values are represented as strings and they are either Oval, Squiggle, or Diamond.
 */

public enum CardShape {
  Oval("O"), Squiggle("Q"), Diamond("D");

  private final String value;

  CardShape(String value) {
    this.value = value;
  }

  public String getShapeValue() {
    return this.value;
  }
}
