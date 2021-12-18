package org.jo.training.models;

public class Player implements IPlayer {

  private String name;
  private Hand hand;

  public Player(String name) {
    this.name = name;
    this.hand = new Hand();
  }

  public String getName() {
    return name;
  }

  public void addCardToHand(PlayingCard card) {
    hand.addCard(card);
  }

  public PlayingCard getCard(int index) {
    return hand.getCard(index);
  }

  public PlayingCard removeCard() {
    return hand.removeCard();
  }
}
