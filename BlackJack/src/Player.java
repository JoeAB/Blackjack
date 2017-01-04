import java.util.ArrayList;

public class Player {
    private ArrayList<Card> hand;
    private int handValue;
    private boolean isComputer;

    public Player(boolean isComputer){
        this.isComputer = isComputer;
        hand = new ArrayList<Card>();
        handValue = 0;
    }

    public void addCard(Card drawnCard ){
        if(hand.size() < 1 && isComputer){
            drawnCard.putFaceDown();
        }
        hand.add(drawnCard);
        handValue = handValue + drawnCard.getValue();

    }
    public int checkHandValue(){
        return handValue;
    }

    public String listVisibleCards(){
        String returnString = "";
        for(Card card:hand) {
            if(card.isVisible()){
                returnString += card.getName() + "\n";
            }
        }
        return returnString;
    }
    public Card getCard(int index){

        return hand.get(index);
    }
    public void checkAceValueSwitch(){
        for (Card handCard: hand) {
            if (handCard.getValue()==11 && handValue > 21){
                handCard.setValue(1);
                handValue = (handValue - 11) +1;
            }

        }
    }
}
