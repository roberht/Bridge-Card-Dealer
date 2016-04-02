import java.util.ArrayList;
import java.util.Collections;

// written by Robert Herrera
//This class is used to represent an individual card.
// Has methods to get individual cards' private members and
//  methods for displaying ArrayList of several cards and their private data.
//
//	cardSuit 1 = Spades
//			 2 = Hearts
//			 3 = Diamonds
//			 4 = Clubs
// cardValue 2-10 = 2-10
//			 11= Jack
//			 12= Queen
//			 13= King
//			 14 = Ace
//
public class Card implements Comparable<Card>
{
	private int cardValue;
	private int cardSuit;
	// constructor creates new card with suit and face value
	public Card(int suit, int value)
	{
		if(suit < 1|| suit >4)
		{
			throw new IllegalArgumentException();	//invalid card suit 
		}
		if(value < 2|| value >15)
		{
			throw new IllegalArgumentException();	//invalid card value
		}
		cardSuit = suit;
		cardValue = value;
	}
	//returns face value of card as int
	public int getValue()
	{
		return cardValue;
	}
	//returns suit value of card as int
	public int getSuit()
	{
		return cardSuit;
	}
	//displays card suit and face values as their private int representations
	public String toString()
	{
		return  "Card Suit: " +getSuit()+ " Card Value: " +getValue();
	}
	//returns card face value as corresponding string i.e "A" for 14
	public String getValueAsString()
	{	// retrieve cards internal value as int
		int num = getValue();
		switch (num)
		{	//return string representation. 
	        case 2:   return  "2";
	        case 3:   return  "3";
	        case 4:   return  "4";
	        case 5:   return  "5";
	        case 6:   return  "6";
	        case 7:   return  "7";
	        case 8:   return  "8";
	        case 9:   return  "9";
	        case 10:  return  "10";
	        case 11:  return  "J";
	        case 12:  return  "Q";
	        case 13:  return  "K";
	        case 14:  return  "A";
	        default:  return  " ";
		}
	}
	//returns card suit as corresponding suit i.e "Spades" for '1'.
	public String getSuitAsString()
	{	//get card suit's internal value as int
		int num = getSuit();
		switch (num)
		{	//return string representation of suit
	        case 1:   return  "Spades";
	        case 2:   return  "Hearts";
	        case 3:   return  "Diamonds";
	        case 4:   return  "Clubs";
	        default:  return  " ";
		}
	}
	//accepts an arraylist (representing a players hand) and players name.
	//displays and centers player name, and cards next to corresponding suit name.
	// displays suit name even if player doesn't have any cards of its type.
	public static void displayHand(ArrayList hand, String playerName)
	{
		ArrayList myHand = hand;
		String name = playerName;
		// corresponding cards will be appended to these variables
		String spades="";
		String hearts="";
		String diamonds="";
		String clubs="";
		
		int cardIndex;
		for(cardIndex=0; cardIndex<myHand.size();cardIndex++)
		{
			int num = ((Card) myHand.get(cardIndex)).getSuit();
			//compare each card in hand to suit, and append appropriate values
			switch (num)
			{
				//appends cards to corresponding suit string
		        case 1:   spades += ((Card) myHand.get(cardIndex)).getValueAsString() +" ";
		        break;
		        case 2:   hearts += ((Card) myHand.get(cardIndex)).getValueAsString() +" ";
		        break;
		        case 3:   diamonds += ((Card) myHand.get(cardIndex)).getValueAsString()+" ";
		        break;
		        case 4:   clubs += ((Card) myHand.get(cardIndex)).getValueAsString()+" "; 
		        break;
		        default:  System.out.println("Invalid card");
			}
		}		
		   		//centered using tab. displays suit name and corresponding cards
				//("\n%-40s %-10s %1s","Spades: "+spades,"Spades: ",spades2);
	        	System.out.println("\t\t\t" +name);		
	    		System.out.println("\t\t\tSpades:   "+spades);
	    		System.out.println("\t\t\tHearts:   "+hearts);
	    		System.out.println("\t\t\tDiamonds: "+diamonds);
	    		System.out.println("\t\t\tClubs:    "+clubs);
	     
	}
	//accepts two arraylists (representing two players' hands) and two players' names.
	//displays 1st params cards left justified, and 2nd params cards tabbed over.
	// displays suit name even if player doesn't have any cards of its type.
	public static void displayHand(ArrayList hand, ArrayList otherHand, String playerName, String othPlayerName)
	{
		ArrayList myHand = hand;
		ArrayList othHand = otherHand;
		String name = playerName;
		String name2 = othPlayerName;
		String spades="";
		String hearts="";
		String diamonds="";
		String clubs="";
		
		//variables for other hand	
		String spades2="";
		String hearts2="";
		String diamonds2="";
		String clubs2="";
		
		int cardIndex;
		for(cardIndex=0; cardIndex<myHand.size();cardIndex++)
		{
			int num = ((Card) myHand.get(cardIndex)).getSuit();

			switch (num)
			{
				//appends cards to corresponding suit string
		        case 1:   spades += ((Card) myHand.get(cardIndex)).getValueAsString() +" ";
		        break;
		        case 2:   hearts += ((Card) myHand.get(cardIndex)).getValueAsString() +" ";
		        break;
		        case 3:   diamonds += ((Card) myHand.get(cardIndex)).getValueAsString()+" ";
		        break;
		        case 4:   clubs += ((Card) myHand.get(cardIndex)).getValueAsString()+" "; 
		        break;
		        default:  System.out.println("Invalid card");
			}
		}	
		for(cardIndex=0; cardIndex<othHand.size();cardIndex++)
		{
			int num = ((Card) othHand.get(cardIndex)).getSuit();

			switch (num)
			{
				//appends cards to corresponding suit string for 2nd player's cards
		        case 1:   spades2 += ((Card) othHand.get(cardIndex)).getValueAsString() +" ";
		        break;
		        case 2:   hearts2 += ((Card) othHand.get(cardIndex)).getValueAsString() +" ";
		        break;
		        case 3:   diamonds2 += ((Card) othHand.get(cardIndex)).getValueAsString()+" ";
		        break;
		        case 4:   clubs2 += ((Card) othHand.get(cardIndex)).getValueAsString()+" "; 
		        break;
		        default:  System.out.println("Invalid card");
			}
		}	  
				//displays 1st params cards left justified, and 2nd params cards tabbed over.
				// displays suit name even if player doesn't have any cards of its type.
			    System.out.printf("%-50s %-10s",name,name2);		
	    		System.out.printf("\n%-50s %-10s %1s","Spades:   "+spades,"Spades: ",spades2);
	    		System.out.printf("\n%-50s %-10s %1s","Hearts:   "+hearts,"Spades: ", hearts2);
	    		System.out.printf("\n%-50s %-10s %1s","Diamonds: "+diamonds,"Diamonds: ", diamonds2);
	    		System.out.printf("\n%-50s %-10s %1s","Clubs:    "+clubs,"Clubs: ", clubs2);
	    		System.out.println(); 
	}
	// accepts Card object
	// compares suit first. Only compares card face value if their suits are equal
	// returns 1 if calling object is greater than object passed
	// returns -1 if calling object is less than object passed
	public int compareTo(Card anotherCard)
	{
		if(Integer.compare(this.getSuit(), anotherCard.getSuit()) == 1)	//
		{
			return 1;
		}
		if(Integer.compare(this.getSuit(), anotherCard.getSuit()) == 0)
		{
			if (Integer.compare(this.getValue(), anotherCard.getValue()) ==1)
			{
				return -1;
			}
		}
		else if(Integer.compare(this.getSuit(), anotherCard.getSuit()) == -1)
		{
			return -1;
		}
		return cardSuit;
	}
}
