import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * @Author Clayton Glenn & Deborah Trytten
 * @Version Program 13
 * @Date 11/19/2016
 * 
 * @Description This program plays a game of Go Fish
 */
public class Program13_ClaytonGlenn
{
	public static int STARTING_HAND_SIZE = 7;
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		//Create deck
		ArrayList<Integer> pool=createDeck();
		
		//Play go fish
		playOneGame(pool, input);
	}
	
	public static void playOneGame(ArrayList<Integer> pool, Scanner input)
	{
		ArrayList<Integer> computer = new ArrayList<Integer>();
		ArrayList<Integer> person = new ArrayList<Integer>();
		ArrayList<Integer> computerPile = new ArrayList<Integer> ();
		ArrayList<Integer> personPile = new ArrayList<Integer>();

		//Deal cards
		dealHands(pool, person, computer);
		System.out.println("Your cards are: \n" + person + "\n");
		
		//Play the game
		while (computerPile.size() + personPile.size() < 52 || !pool.isEmpty())
		{
			
			// Let the person play first
			// show the person their cards
			if (!person.isEmpty())
			{
				System.out.println("What card do you want?");
				int card = input.nextInt();
				System.out.println("");
				
				//Play one turn with the person doing the choosing
				playOneTurn(card, person, computer, personPile, computerPile, pool);
			}
			else
			{
				//Let the player draw from the deck
				person.add(pool.get(0));
				pool.remove(0);	
			}
		
			showGameState(person, computerPile, personPile);
			System.out.println("");
			
			// Now it is the computer's turn
			// Randomly choose a card
			if (!computer.isEmpty())
			{
				int card = computer.get((int)(Math.random()*computer.size()));	
				System.out.println("Do you have any "  + card + "'s ?");
				
				//Play one turn with the computer doing the choosing
				playOneTurn(card, computer, person, computerPile, personPile, pool);
			}
			else if (!pool.isEmpty())
			{
				
				//Let the computer draw from the deck
				computer.add(pool.get(0));
				pool.remove(0);
			}
			showGameState(person, computerPile, personPile);
		}
		
		//Determine the winner and tell the user--remember ties are possible
		if(pool.isEmpty())
		{
			if(personPile.size() > computerPile.size())
				System.out.println("You won the game of GO FISH!!! Congrats!");
			else if(personPile.size() < computerPile.size())
				System.out.println("You lose. Maybe next time");
			else
				System.out.println("You tie.");
		}
	}
	
	public static void showGameState(ArrayList<Integer> person, ArrayList<Integer> computerPile,
																											ArrayList<Integer> personPile)
	{
		//Show cards
		System.out.println("Here are your cards");
		showCards(person);
		System.out.println("Here is your pile");
		showCards(personPile);
		System.out.println("Here is my pile");
		showCards(computerPile);
	}
	
	public static void playOneTurn(int card, ArrayList<Integer> chooser, ArrayList<Integer> chosen,
			ArrayList<Integer> chooserPile, ArrayList<Integer> chosenPile, ArrayList<Integer> pool)
	{
		if (chosen.contains(card))
		{
			//Chosen gives cards to Chooser
			transferCards(card, chooser, chosen);
			
			//If there is a set of four matching cards, put them up on the table
			ArrayList <Integer> indexList = new ArrayList<Integer>();
			
			//Prepare for search algorithm
			for(int index = 0; index < chooser.size(); ++index)
			{
				for(int i = 0; i < chooser.size(); ++i)
				{
					if(chooser.get(index) == chooser.get(i))
					{
						indexList.add(chooser.get(i));
					}
				}
				
				//See if chooser owns all four cards and put on table
				if(indexList.size() == 4)
				{
					transferCards(indexList.get(0), chooserPile, chooser);
				}
				
				//Clear index list
				indexList.clear();
			}
		}
		
		else
		{
			
			//Print go fish
			System.out.println("Go fish! \n");
		
			//Draw a card by removing it from the pool and putting it in the chooser's hand
			chooser.add(pool.get(0));
			pool.remove(0);
			
			//If there is a set of four matching cards, put them on the table
			ArrayList <Integer> indexList = new ArrayList<Integer>();
			for(int index = 0; index < chooser.size(); ++index)
			{
				
				//Construct indexList to compare
				for(int i = 0; i < chooser.size(); ++i)
				{
					if(chooser.get(index) == chooser.get(i))
					{
						indexList.add(chooser.get(i));
					}
				}
				
				//Take card sets from hand and put on table
				if(indexList.size() == 4)
				{
					transferCards(indexList.get(0), chooserPile, chooser);
				}
				
				//Clear Index for next 4x search
				indexList.clear();
			}
		}
	}
	
	public static void transferCards(int card, ArrayList<Integer> destination, ArrayList<Integer> source)
	{
		//Transfer cards from chosen to chooser
		while (source.contains(card))
		{
			destination.add(card);
			source.remove(new Integer(card)); // this is that tricky thing from the handout
		}
	}
	
	public static void dealHands(ArrayList<Integer> deck, ArrayList<Integer> hand1, ArrayList<Integer> hand2)
	{
		
		//Deal the cards for player
		for(int index = 0; index < STARTING_HAND_SIZE; ++index)
		{
			hand1.add(deck.get(0));
			deck.remove(0);
		}
		
		//Deal the cards for computer
		for(int index = 0; index < STARTING_HAND_SIZE; ++index)
		{
			hand2.add(deck.get(0));
			deck.remove(0);
		}
		
		//Sort players hand for readability
		Collections.sort(hand1);
	}
	
	public static ArrayList<Integer> createDeck()
	{
		ArrayList<Integer> deck = new ArrayList<Integer>();
		
		//Assign cards to deck list
		for(int cards = 1; cards <= 52; cards++)
		{
			deck.add(cards % 13 + 1);	
		}
		
		//Shuffle Deck
		Collections.shuffle(deck);
		
		//Return
		return deck;
	}
	
	public static void showCards(ArrayList<Integer> cards)
	{
		//Sort the cards to make it easier for the user to know what they have
		Collections.sort(cards);
		
		//Show user their cards
		for (Integer i: cards)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
}


