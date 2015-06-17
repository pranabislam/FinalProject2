import java.util.*;


public class GameRunner {

    public static void main(String[] args){
        
	
	Scanner sc = new Scanner(System.in);
	Deck deck = new Deck(1, true);

	Player user = new Player("User");
	Player dealer = new Player("Dealer");
	
	user.addCard(deck.dealNextCard());
	dealer.addCard(deck.dealNextCard());
	user.addCard(deck.dealNextCard());
	dealer.addCard(deck.dealNextCard());

	System.out.println("Cards have been dealt\n");
	user.printHand(true);
	dealer.printHand(false);
	System.out.println("\n");
	
	boolean userDone = false;
	boolean dealerDone = false;
	String ans;

	while (!userDone || !dealerDone){
	    
	    if (!userDone){
		System.out.println("Hit or Stay? (Enter H or S: ");
		ans = sc.next();
		System.out.println();

		if(ans.compareToIgnoreCase("H") == 0){
		    userDone = !user.addCard(deck.dealNextCard());
		    user.printHand(true);
		}
		else {
		    userDone = true;
		}
	    }
	    if (!dealerDone){
		if (dealer.getHandSum() < 17){
		    System.out.println("The Dealer hits\n");
		    dealerDone = !dealer.addCard(deck.dealNextCard());
		    dealer.printHand(false);
		}
		else {
		    System.out.println("The dealer stays\n");
		    dealerDone = true;
		    
		}
	    }
	    System.out.println();
    }
	sc.close();
	
	user.printHand(true);
	dealer.printHand(true);
	
	int userSum = user.getHandSum();
	int dealerSum = dealer.getHandSum();

	if(userSum > dealerSum && userSum <= 21 || dealerSum > 21){
	    System.out.println("You win!!!");
	}
	else{
	    System.out.println("Dealer wins, better luck next time!");
	}
    }
}
