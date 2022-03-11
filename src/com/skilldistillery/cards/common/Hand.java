package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;
	
	public Hand() { 
	setCards(new ArrayList<Card>());	
	}
	public void addCard(Card card) {
		getCards().add(card);
	}
	public void clear() {
		cards.clear();
	}
	public abstract int getHandValue();
	
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	public String toString() {
		return "Hand " + getCards();	
	}
}
