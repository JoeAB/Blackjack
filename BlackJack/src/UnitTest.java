
public class UnitTest {

    public static void main(String[] args){
        //create card and test methods
        Card cardTest = new Card(10,"King", "Spades");
        System.out.println(cardTest.getValue());
        System.out.println(cardTest.getName());
        System.out.println(cardTest.getSuit());
        System.out.println(cardTest.isVisible());
        cardTest.flip();
        System.out.println(cardTest.isVisible());
        cardTest.setValue(5);
        System.out.println(cardTest.getValue());
        cardTest.setValue(10);
        System.out.println(cardTest.getValue());



        //create deck and test methods
        Deck testDeck = new Deck();
        testDeck.shuffleDeck();
        System.out.println("Test deck 1");
        System.out.println(testDeck.dealCard().getName());
        System.out.println(testDeck.dealCard().getName());
        System.out.println(testDeck.dealCard().getName());
        System.out.println(testDeck.dealCard().getName());
        System.out.println(testDeck.dealCard().getName());


        Deck testDeck2 = new Deck();
        System.out.println("Test deck 2");
        System.out.println(testDeck2.dealCard().getName());
        System.out.println(testDeck2.dealCard().getName());
        System.out.println(testDeck2.dealCard().getName());
        System.out.println(testDeck2.dealCard().getName());
        System.out.println(testDeck2.dealCard().getName());

        Deck testDeck3 = new Deck();
        testDeck3.shuffleDeck();
        System.out.println("Test deck 3");
        System.out.println(testDeck3.dealCard().getName());
        System.out.println(testDeck3.dealCard().getName());
        System.out.println(testDeck3.dealCard().getName());
        System.out.println(testDeck3.dealCard().getName());
        System.out.println(testDeck3.dealCard().getName());


        //create player and test methods
        Player testPlayer = new Player(false);
        testPlayer.addCard(cardTest);
        System.out.println(testPlayer.checkHandValue());
        System.out.println(testPlayer.listVisibleCards());
        testPlayer.addCard(testDeck2.dealCard());
        System.out.println(testPlayer.checkHandValue());
        System.out.println(testPlayer.listVisibleCards());

    }


}
