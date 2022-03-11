package com.skilldistillery.cards.common;

import java.util.Objects;

public class Card {
	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	private Suit suit;
	private Rank rank;

	Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(suit, rank);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return suit == other.suit && rank == other.rank;
	}

	


	public int getValue() {
		return rank.getValue();
	}

}
