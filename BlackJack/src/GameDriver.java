import java.util.Scanner;


public class GameDriver {

    public static void main(String[] args){
        boolean playing = true;
        boolean hitting;
        Deck gameDeck;
        Player player;
        Player dealer;

        Scanner in = new Scanner(System.in);
        while (playing){
            //ask user if thet want to play
            System.out.println("Would you like to play a game of blackjack? Yes or no.");

            String choiceMenu = in.nextLine();
            if(choiceMenu.equalsIgnoreCase("yes".trim())){

                gameDeck = new Deck();
                player = new Player(false);
                dealer = new Player(true);
                gameDeck.shuffleDeck();
                player.addCard(gameDeck.dealCard());
                player.addCard(gameDeck.dealCard());
                dealer.addCard(gameDeck.dealCard());
                dealer.addCard(gameDeck.dealCard());
                hitting = true;
                String choiceUser;

                while(hitting && player.checkHandValue() <21 && dealer.checkHandValue() < 21){
                    System.out.println("Dealer drew: "+dealer.listVisibleCards());
                    System.out.println("You drew: "+player.listVisibleCards());
                    System.out.println("Enter hit to hit or stay to stay");
                    choiceUser = in.nextLine();

                    if(choiceUser.equalsIgnoreCase("hit".trim())){
                        player.addCard(gameDeck.dealCard());
                        player.checkAceValueSwitch();
                    }
                    else if (choiceUser.equalsIgnoreCase("stay".trim())){
                        hitting = false;
                    }

                }

                //dealer draws until 17 or higher
                while(dealer.checkHandValue()<17 ){
                    dealer.addCard(gameDeck.dealCard());
                    dealer.checkAceValueSwitch();
                }

                dealer.getCard(0).flip();

                if (dealer.checkHandValue()==21 && player.checkHandValue()!=21){
                    System.out.println("Dealer hand: "+ dealer.listVisibleCards());
                    System.out.println("Your hand: "+ player.listVisibleCards());
                    System.out.println("Dealer got 21, you lose.");

                }
                else if(player.checkHandValue()==21 && dealer.checkHandValue()!=21){
                    System.out.println("Dealer hand: "+ dealer.listVisibleCards());
                    System.out.println("Your hand: "+ player.listVisibleCards());
                    System.out.println("You got 21, you win.");
                }
                else if(player.checkHandValue() > 21){
                    System.out.println("Dealer hand: "+ dealer.listVisibleCards());
                    System.out.println("Your hand: "+ player.listVisibleCards());
                    System.out.println("You busted, dealer wins.");
                }
                else if(dealer.checkHandValue()> 21){
                    System.out.println("Dealer hand: "+ dealer.listVisibleCards());
                    System.out.println("Your hand: "+ player.listVisibleCards());
                    System.out.println("Dealer busted, you win.");
                }
                else if(dealer.checkHandValue() > player.checkHandValue()){
                    System.out.println("Dealer hand: "+ dealer.listVisibleCards());
                    System.out.println("Your hand: "+ player.listVisibleCards());
                    System.out.println("Dealer wins.");
                }
                else if(dealer.checkHandValue() < player.checkHandValue()){
                    System.out.println("Dealer hand: "+ dealer.listVisibleCards());
                    System.out.println("Your hand: "+ player.listVisibleCards());
                    System.out.println("You win.");
                }
                else if(dealer.checkHandValue() == player.checkHandValue()){
                    System.out.println("Dealer hand: "+ dealer.listVisibleCards());
                    System.out.println("Your hand: "+ player.listVisibleCards());
                    System.out.println("Tied game.");
                }
                else if(dealer.checkHandValue() >21 && player.checkHandValue() > 21){
                    System.out.println("Dealer hand: "+ dealer.listVisibleCards());
                    System.out.println("Your hand: "+ player.listVisibleCards());
                    System.out.println("Both you and the dealer busted. Dealer wins.");
                }

            }
            else if(choiceMenu.equalsIgnoreCase("no".trim())){
                playing = false;
            }
            else {
                System.out.println("I'm sorry, that was not a valid option.");
            }
        }
    }
}
