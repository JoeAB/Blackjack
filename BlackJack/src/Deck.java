import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private int currentPlace;

    public Deck(){
        deck = new ArrayList<Card>();
        for(int i=0; i <= 3; i++){
            //determine suit here
            String suit;
            if(i==0)
                suit = "Clubs";
            else if(i==1)
                suit = "Hearts";
            else if(i==2)
                suit = "Diamonds";
            else
                suit = "Spades";

            for(int j=1; j<= 13; j++){
                if(j==1)
                    deck.add(new Card(11,"Ace", suit));
                else if(j==11)
                    deck.add(new Card(10, "Jack", suit));
                else if(j==12)
                    deck.add(new Card(10, "Queen", suit));
                else if(j==13)
                    deck.add(new Card(10,"King", suit));
                else
                    deck.add(new Card(j, ""+j, suit));
            }
            currentPlace = 0;
        }
    }
    public void shuffleDeck(){
        for (int i = 0; i <deck.size() -1; i++)
        {
            int moveIndex = (int) (Math.random() * deck.size());
            Card cardHolder = deck.get(moveIndex);
            deck.set(moveIndex, deck.get(i));
            deck.set(i, cardHolder);
        }
    }
    public Card dealCard(){
        Card returnCard = deck.get(currentPlace);
        currentPlace++;
        return returnCard;
    }
}
