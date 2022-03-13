package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int sum = 0;
		for (Card card : this.getCards()) {
			sum += card.getValue();
		}
		return sum;
	}

	public boolean blackjack() {
		int sum = getHandValue();
		if (sum == 21) {
			return true;
		} else {
			return false;
		}

	}

	public boolean bust() {
		int sum = getHandValue();
		if (sum > 21) {
			return true;
		} else
			return false;
	}

}
