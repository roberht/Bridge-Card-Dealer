// Written by Robert Herrera
// This program simulates a game of Bridge using a standard deck of 52 cards.
// It creates a deck, shuffles it, and deals 4 hands of 13 cards each.
// Players' hands are displayed below players' name in descending order, along with their respective suit,
// formatted to be displayed in the major cardinal directions.
// This is repeated 5 times.
import java.util.ArrayList;
import java.util.Collections;
public class BridgeDemo 
{
	public static void main(String[] args) 
	{
		//number of sets of hands to display
		for(int i=0; i<5; i++)
		{
			//number of players cards will be dealt to
			int numPlayers = 4; 
			//Create deck to hold card objects
			ArrayList<Card> deck = new ArrayList<>();
			//create 52 cards. 13 of each suit
			// and add to deck.
			for(int suit = 1; suit<5; suit++)
			{
				for(int faceVal = 2;faceVal <15; faceVal++)
				{
					deck.add(new Card(suit, faceVal));
				}
			}
			
			//Shuffle the deck using Collections method
			Collections.shuffle(deck);
			
			//create 4 arraylists to represent players' "hands"
			//cards will be dealt from deck to hands
			ArrayList<Card> nHand = new ArrayList<>();
			ArrayList<Card> eHand = new ArrayList<>();
			ArrayList<Card> sHand = new ArrayList<>();
			ArrayList<Card> wHand = new ArrayList<>();
			
			//2d arraylist
			//add players' hands to arraylist of players		
			ArrayList<ArrayList> players = new ArrayList<>();
			players.add(nHand);
			players.add(eHand);
			players.add(sHand);
			players.add(wHand);
			
			int cardIndex=0;
			int playerIndex;
			// "deal" cards to each player
			while(cardIndex < deck.size())
			{
				// deals one card at a time to each player
				for (playerIndex=0; playerIndex < numPlayers; playerIndex++)
				{
					Card temp = deck.get(cardIndex);
					players.get(playerIndex).add(temp);
					cardIndex++;
				}
			}
			//enhanced for loop to sort each players' cards
			for (ArrayList playerHand : players)
				Collections.sort(playerHand);
	
			//display players cards
			System.out.println();
			//displays cards centered
			Card.displayHand(nHand, "NORTH");
			//displays two sets of cards
			//1st left justified, 2nd set on right side
			Card.displayHand(wHand, eHand,"WEST","EAST");	
			Card.displayHand(sHand, "SOUTH");
			System.out.println();
			System.out.println("=====================================================================");
		}
	}
}

