package com.skilldistillery.cards.blackjack;

public class Playing {
		

			public BlackjackHand hand;

			public Playing() {
				this.hand = new BlackjackHand();
			}
			public void playerWins() {
				System.out.println("You Win");
				System.out.println("Play Again? Y or N");
			}
			public void showHand() {
				System.out.println("Your hand: " + hand.getCards() + " " + hand.getHandValue());
			}

			public void ShowCardValueRank() {
				System.out.println(hand.getCards().get(0) + " and " + hand.getCards().get(1));
			}


		}
		


