import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Iterator;

public class Deck {
  private ArrayList<String> board;
  private ArrayList<Card> opponentHand;
  private ArrayList<Card> playerHand;
  private ArrayList<Card> boardHand;
  private ArrayList<Card> stackDeck;

  private Map<String, ArrayList<Card>> deckLookup;

  public Deck() {
    board = new ArrayList<String>();
    deckLookup = new HashMap<String, ArrayList<Card>>();
    resetBoard();
    board.add("Opponent");
    board.add("Player");
    board.add("Board");
    board.add("Deck");
    deckLookup.put("Opponent", opponentHand);
    deckLookup.put("Player", playerHand);
    deckLookup.put("Board", boardHand);
    deckLookup.put("Deck", stackDeck);
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
    for(String s: board) {
      System.out.println("---" + s + "----");
      for(Card c: deckLookup.get(s)) {
        System.out.println(c.toString());
      }
    }
  }

  public void dealCard(String destination, String cardName) {
    String[] cardValues = cardName.split(" of ");
    for(int i = 0; i < stackDeck.size(); i++) {
      if((stackDeck.get(i).getValue().equals(cardValues[0])) && (stackDeck.get(i).getSuit().equals(cardValues[1]))) {
        deckLookup.get(destination).add(stackDeck.remove(i));
        return;
      }
    }
  }



}
