
import java.util.*;

public class Blackjack_potluri 
{

    /**
     * @param args the command line arguments
     */
    public static String WinConditions(Player X, Player Opponent)
    {
        System.out.println("Player score: "+X.getScore());
        System.out.println("Computer score: "+Opponent.getScore());
        if(X.getScore()==21)
        {
            return "Congrats you got the dub.";
        }
        else if(Opponent.getScore()==21)
        {
            return "You took the L.";
            
        }
        if(checkagain(X))
        {
            return "You took the L.";
        }        
        else if(checkagain(Opponent))
        {
            return "Congrats you got the dub.";
        }
        if(X.getScore()>Opponent.getScore())
        {
            return "Congrats you got the dub.";
        }
        else if(X.getScore()==Opponent.getScore())
        {
            return "You have a tie.";
        }
        else{
            return "You took the L.";
        }
    }
    public static void PlayCode(Deck deck, Player X, Player Opponent)//this allows the user to hit/stand
            //It also calculates the total score from recieving the cards in the Deck class
    {
        boolean OpponentHits = false;
        boolean CompleteGame = true;
        boolean PlayerHits = false;
        
        ArrayList<Card> frHand = new ArrayList<Card>();
        while(CompleteGame=true)
        {
            frHand=X.getHand();
            System.out.println("Here is your hand:");
            for(int i = 0; i<X.getHand().size(); i++)
            {
                System.out.println(frHand.get(i).getName()+" with value of "+frHand.get(i).getValue()+".");//this gets the current card with the hand
            }
            System.out.println("Your score is: "+X.getScore());
            System.out.println("To Hit, respond with y or n. Responding with n says that you stand.");
            String playerChoice;
            Scanner input1 = new Scanner(System.in);
            
            if(Opponent.getScore()<17)
            {
                System.out.println("Computer hits.");
                Opponent.addCard(deck.getTopCard());
                OpponentHits = true;
            }
            else
            {
                System.out.println("Computer stands.");
            }
           if(!OpponentHits&&!PlayerHits)
            {
                CompleteGame=false;
            } 
           if(checkagain(X)||checkagain(Opponent))
            {
                CompleteGame=false;
            }
           if((""+input1.next().charAt(0)).equals("y"))
            {
                X.addCard(deck.getTopCard());
                System.out.println("You have: "+X.getLastCard().getName());
                PlayerHits = true;
            }
           
            OpponentHits=false;
            PlayerHits=false;
            
        }
        System.out.println(WinConditions(X, Opponent));
        
    }
    public static boolean checkagain(Player playersss)
    {
        if(playersss.getScore()>21)
        {
            return true;
        }
        return false;
    }
    public static void main(String[] args) 
    {
        Deck deck = new Deck();
        deck.shuffle();
        boolean PlayAgain = true;
        while(PlayAgain)
        {
            Player X = new Player();
            Player Opponent = new Player();
            X.addCard(deck.getTopCard());
            X.addCard(deck.getTopCard());
            Opponent.addCard(deck.getTopCard());
            Opponent.addCard(deck.getTopCard());
            PlayCode(deck, X, Opponent);
            String playerChoice;
            System.out.println("Play again? type yes or no");
            Scanner diffinput = new Scanner(System.in);
            if(!(""+diffinput.next().charAt(0)).equals("y"))//this if statement changes the PlayAgain variable if the user still wants to play.
            {
                PlayAgain=false;
            }
            X = null;
            Opponent = null;
        }
        
    }
    
   
}