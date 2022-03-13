package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;



public class Dealing {

	public BlackjackHand dealerHand;

	public void showHand() {
		System.out.println("Dealer Hand: " + dealerHand.getCards() + " " + dealerHand.getHandValue());
	}
	
	public Dealing() {
		this.dealerHand = new BlackjackHand();
	}

	public void dealerWins() {
		System.out.println("You Lose");
		System.out.println("Play Again? Y or N");
	}
	
	public void ShowCardValueRank() {
		System.out.println(dealerHand.getCards().get(1));
	}

	private void printHandandValue(List<Card> hand, int value) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total Value: " + value);
	}


}

