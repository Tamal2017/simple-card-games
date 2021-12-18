package org.jo.training.models;

/**
 * @author Joseph T
 */
public interface IPlayer {

   String getName();

   void addCardToHand(PlayingCard card);

   PlayingCard getCard(int index);

   PlayingCard removeCard();
}
