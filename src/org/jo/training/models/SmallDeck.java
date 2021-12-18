package org.jo.training.models;

import java.util.ArrayList;

public class SmallDeck extends Deck {

  public SmallDeck() {
    cards = new ArrayList<>();
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        if (rank.value() > 7) {
          cards.add(new PlayingCard(rank, suit));
        }
      }
    }
    shuffle();
  }
}
