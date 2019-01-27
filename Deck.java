import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Iterator;

public class Deck {
  private ArrayList<Pair<String, ArrayList<Card>>> board;
  private ArrayList<Card> opponentHand;
  private ArrayList<Card> playerHand;
  private ArrayList<Card> boardHand;
  private ArrayList<Card> stackDeck;

  public Deck() {
    board = new ArrayList<Pair<String, ArrayList<Card>>>();
    resetBoard();
    board.add(new Pair("Opponent Hand", opponentHand));
    board.add(new Pair("Player Hand", playerHand));
    board.add(new Pair("Board", boardHand));
    board.add(new Pair("Deck", stackDeck));
  }

  public void resetBoard() {
    opponentHand = new ArrayList<Card>();
    playerHand = new ArrayList<Card>();
    boardHand = new ArrayList<Card>();
    stackDeck = new ArrayList<Card>();
    Map<Integer, String> valueLookup = new HashMap<Integer, String>();
    valueLookup.put(0, "2");
    valueLookup.put(1, "3");
    valueLookup.put(2, "4");
    valueLookup.put(3, "5");
    valueLookup.put(4, "6");
    valueLookup.put(5, "7");
    valueLookup.put(6, "8");
    valueLookup.put(7, "9");
    valueLookup.put(8, "10");
    valueLookup.put(9, "J");
    valueLookup.put(10, "Q");
    valueLookup.put(11, "K");
    valueLookup.put(12, "A");
    Map<Integer, String> suitLookup = new HashMap<Integer, String>();
    suitLookup.put(0, "Clubs");
    suitLookup.put(1, "Diamonds");
    suitLookup.put(2, "Hearts");
    suitLookup.put(3, "Spades");
    for(int i = 0; i < 13; i++) {
      for(int j = 0; j < 4; j++) {
        stackDeck.add(new Card(valueLookup.get(i), suitLookup.get(j)));
      }
    }
  }

  public void showBoard() {
    for(Pair<String, ArrayList<Card>> p: board) {
      System.out.println("---" + p.getKey() + "----");
      for(Card c: p.getValue()) {
        System.out.println(c.toString());
      }
    }
  }


}
