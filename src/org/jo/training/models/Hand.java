package org.jo.training.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joseph T
 */
public class Hand {

  private List<PlayingCard> cards;

  public Hand() {
    this.cards = new ArrayList<>();
  }

  public PlayingCard getCard(int index) {
    return cards.get(index);
  }

  public void addCard(PlayingCard card) {
    cards.add(card);
  }

  public PlayingCard removeCard() {
    return cards.get(0);
  }
}
