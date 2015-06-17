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
	
	

	
	
    }

}
