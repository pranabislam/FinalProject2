import java.util.Random;
import java.util.*;

public class Deck {

    private Card[] myCards;
    private ArrayList<Card> myCards;
    private LinkedList<Card> myCards;

    private int numCards;

    public Deck(){
	this(1, false);
    }

    public Deck (int numDecks, boolean shuffle){
	this.numCards = numDeck * 52; 
	this.myCards = new Card[this.numCards];

	int c = 0;
 
	for (int d = 0; d < numDecks; d++){

	    for (int s = 0; s < 4; s++){

		for (int n = 1; n <= 13; n++){

		    this.myCards[c] = newCard(Suit.values()[s], n);
		    c++;
		}
	    }
	}

	if (shuffle){
	    this.shuffle();
	}
    }

    public void shuffle(){
	Random rng = new Random();
	Card temp;
	int j;

	for (int i = 0; i < this.numCards; i++){
	    j = rng.nextInt(this.numCards);
	    temp = this.myCards[i];
	    this.myCards[i] = this.myCards[j];
	    this.myCards[j] = temp;
	}
    }

    public Card dealNextCard(){
	Card top = this.myCards[0];
	for (int c = 1; c < this.numCards; c++){
	    this.myCards[c-1] = this.myCards[c];
	}
	this.myCards[c-1] = this.myCards[c];

	this.numCards--;

	return top;
    }

    public void printDeck(int numToPrint){
	for (int c = 0; c < numToPrint; c++){
	    System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c]+toString());
	}
	System.out.printf("\t[%d others]\n", this.numCards-numToPrint);
    }
}
