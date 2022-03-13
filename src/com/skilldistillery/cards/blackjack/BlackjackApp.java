package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;





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
		}
	}
	private void hitOrStay() {
		System.out.println("1) to Hit or 2) to Stay");
		int hitorstay = kb.nextInt();
		if (hitorstay == 1) {
			this.play.hand.addCard(this.deck.dealCard());
			this.play.showHand();
			checkHand();
		} else if (hitorstay == 2) {
			System.out.println("You: " + this.play.hand.getCards() + " " + this.play.hand.getHandValue());
			dealerTurn();
		}
	}
	
		private void dealerTurn() {
			while(this.deal.dealerHand.getHandValue() < 17) {
				deal.dealerHand.addCard(this.deck.dealCard());
			}
		}
	}


