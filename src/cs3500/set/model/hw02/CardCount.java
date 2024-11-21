package cs3500.set.model.hw02;
/**
 * A CardCount is an enumeration containing the 3 possibilities for count values.
 * These values are represented as strings, and they are 1, 2, or 3.
 */

public enum CardCount {
  One("1"), Two("2"), Three("3");

  private final String value;

  CardCount(String value) {
    this.value = value;
  }

  public String getCountValue() {
    return this.value;
  }
}


