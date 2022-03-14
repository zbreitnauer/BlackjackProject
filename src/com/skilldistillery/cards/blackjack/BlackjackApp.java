package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.*;





public class BlackjackApp {
	
	public Playing play;
	public Dealing deal;
	public Deck deck;
	public Scanner kb;

	public static void main(String[] args) {
		BlackjackApp blackJack = new BlackjackApp();
		blackJack.run();
		
	}
	
	public void run() {
		kb = new Scanner(System.in);
		this.play = new Playing();
		this.deal = new Dealing();
		this.deck = new Deck();
		
		System.out.println("Would you like to play Blackjack? Y or N");
		String input = kb.nextLine();
		if (input.equalsIgnoreCase("Y")) {
			newGame();
		} else {
			System.out.println("Goodbye");
			}
		}
	private void newGame() {
		this.deck.shuffle();
		this.play.hand.addCard(this.deck.dealCard());
		this.deal.dealerHand.addCard(this.deck.dealCard());
		this.play.hand.addCard(this.deck.dealCard());
		this.deal.dealerHand.addCard(this.deck.dealCard());
		System.out.println("Dealer has: ");
		this.deal.ShowCardValueRank();
		System.out.println("You have ");
		this.play.ShowCardValueRank();
		checkHand();
	}
	private void checkHand() {
		if(this.play.hand.bust()) {
			System.out.println("Bust!");
			whoWins();
		}
		if (this.play.hand.bust() || !this.play.hand.blackjack()) {
			hitOrStay();}
		}
	
	private void hitOrStay() {
		System.out.println("1) to Hit or 2) to Stay");
		String hitorstay = kb.nextLine();
		if (hitorstay.equals("1")) {
			this.play.hand.addCard(this.deck.dealCard());
			this.play.showHand();
			checkHand();
		} else if (hitorstay.equals("2")) {
			System.out.println("You: " + this.play.hand.getCards() + " " + this.play.hand.getHandValue());
			dealerTurn();
		}
	}
	
		private void dealerTurn() {
			while(this.deal.dealerHand.getHandValue() < 17) {
				deal.dealerHand.addCard(this.deck.dealCard());
			}
			whoWins();
		}
		private void whoWins() {
			if (this.play.hand.bust() || this.deal.dealerHand.blackjack()
					|| !this.deal.dealerHand.bust() && this.deal.dealerHand.getHandValue() > this.play.hand.getHandValue()) {
				this.deal.showHand();
				deal.dealerWins();
		}
			if (this.play.hand.blackjack() || this.deal.dealerHand.bust()
					|| !this.play.hand.bust() && this.play.hand.getHandValue() > this.deal.dealerHand.getHandValue()) {
				this.deal.showHand();
				play.playerWins();

			}

			if (this.play.hand.getHandValue() == this.deal.dealerHand.getHandValue()) {
				this.deal.showHand();
				System.out.println("Push");
			}

			String playAgain = kb.nextLine();
			if (playAgain.equalsIgnoreCase("Y")) {
				this.deal.dealerHand.clear();
				this.play.hand.clear();
				Deck deck = new Deck();
				newGame();

			} else if (playAgain.equalsIgnoreCase("N")) {
				System.out.println("Good Game!");
			}

			kb.close();
		}
	}



