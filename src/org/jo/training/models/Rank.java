package org.jo.training.models;

/**
 * @author Joseph T
 */
public enum Rank {
  TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), HEIGHT(8), NINE(9), JACK(10), QUEEN(
      11), KING(12), ACE(13);

  private int rankValue;

  Rank(int value) {
    this.rankValue = value;
  }

  public int value() {
    return rankValue;
  }
}
