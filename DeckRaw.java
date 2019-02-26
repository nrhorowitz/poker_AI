import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class DeckRaw {
    public ArrayList<Card> deck;

    public DeckRaw() {
        deck = new ArrayList<Card>();
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
            deck.add(new Card(valueLookup.get(i), suitLookup.get(j)));
          }
        }
    }

    public Card get(int index) {
        return deck.get(index);
    }

    public int size() {
        return deck.size();
    }

    public void add(Card c) {
        deck.add(c);
    }

    public void empty() {
        deck = new ArrayList<Card>();
    }

    public String type() {
        Map<String, Integer> counter = new HashMap<String, Integer>();
        for (int i = 0; i < size(); i += 1) {
            String value = get(i).getValue();
            if (counter.containsKey(value)) {
                counter.put(value, counter.get(value)+1);
            } else {
                counter.put(value, 1);
            }
        }
        if (counter.size() == 4) {
            return "1pair";
        }
        return "None";

    }


}
