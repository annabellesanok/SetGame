package cs3500.set.model.hw02;
/**
 * A CardFilling is an enumeration containing the 3 possibilities for filling values.
 * These values are represented as strings, and they are either Empty, Striped, or Full.
 */

public enum CardFilling {
  Empty("E"), Striped("S"), Full("F");

  private final String value;

  CardFilling(String value) {
    this.value = value;
  }

  public String getFillingValue() {
    return this.value;
  }
}
