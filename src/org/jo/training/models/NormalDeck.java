package org.jo.training.models;

import java.util.ArrayList;

public class NormalDeck extends Deck {

  public NormalDeck() {
    cards = new ArrayList<>();
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        cards.add(new PlayingCard(rank, suit));
      }
    }
    shuffle();
  }

}
