package org.jo.training.models;

/**
 * @author Joseph T
 */
public enum Suit {
  DIAMONDS(1), HEARTS(2), SPIDERS(3), CLUBS(4);

  private int value;

  Suit(int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
