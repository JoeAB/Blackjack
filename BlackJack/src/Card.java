
public class Card {

    private int value;
    private String name;
    private String suit;
    private boolean visible;

    public Card(int value){
        this.value = value;
    }
    public Card(int value, String name, String suit){
        this.value = value;
        this.name = name;
        this.suit = suit;
        visible = true;
    }
    public int getValue(){
        return value;
    }
    public String getName(){
        return (name + " of "+suit);
    }
    public String getSuit(){
        return suit;
    }
    public void putFaceDown(){
        visible = false;
    }
    public boolean isVisible(){
        return visible;
    }
    public void flip(){
        visible = true;
    }
    public void setValue(int value){
        this.value = value;
    }
}











