import javax.sound.sampled.*;
import java.io.*;
 

public class Player{
    
    private String name;
   
    private Card[] hand = new Card[10];

    //number of cards in the person's hand
    private int numCards; 
    
    public Player(String pName){
	
	this.name = pName;

	this.emptyHand();

    }

    public void emptyHand(){
	
	for(int x = 0; x < 10; x++){
	    this.hand[x] = null;
	}
	this.numCards = 0;
    }
    
    //returns false if sum of cards > 21 
    public boolean addCard(Card ccard){
	if (this.numCards == 10){
	    System.err.printf("%s's has too many cards", this.name);
	    System.exit(1);
	}

	this.hand[this.numCards] = ccard;
	this.numCards++;

	return (this.getHandSum() <= 21);

    }

    public int getHandSum() {
	
	int handSum = 0;
       
	int cardNum; 
	int numAces = 0;

	for (int c = 0; c < this.numCards;c++){
	    cardNum = this.hand[c].getNumber();
	    
	    if(cardNum == 1){
		numAces++;
		handSum += 11;
	    }
	    else if (cardNum > 10){
		handSum+= 10;
	    }
	    else handSum+= cardNum;
	}
	
	while(handSum > 21 && numAces > 0){
	    handSum-= 10;
	    numAces--;
	}
	return handSum;
	
	
	
	
    }

    public void printHand(boolean firstCard){
	
	System.out.printf("%s's cards:\n", this.name);
	for (int x = 0; x<this.numCards; x++){
	    if (x == 0 && !firstCard){
		System.out.println("   [hidden]");
	    }
	    else {
		System.out.printf("  %s\n", this.hand[x].toString());
	    }
	}
    }

}
