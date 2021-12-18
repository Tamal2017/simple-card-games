package org.jo.training.models;

import java.util.ArrayList;

public class TestDeck extends Deck {

  public TestDeck() {
    var cards = new ArrayList<PlayingCard>();
    for (int i = 0; i < 20; ++i) {
      cards.add(new PlayingCard(Rank.ACE, Suit.CLUBS));
    }
    shuffle();
  }
}
