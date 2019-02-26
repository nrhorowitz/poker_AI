import java.util.Scanner;
public class Runner {
  public static void main(String[] args) {
    boolean probability = false;
    Deck deck = new Deck();
    deck.showBoard();
    Scanner sc = new Scanner(System.in);
    while(probability) {
      String userInput = sc.nextLine();
      if(userInput.startsWith("move ")) {
        userInput = userInput.substring(5);
        if(userInput.startsWith("Player ")) {
          userInput = userInput.substring(7);
          String destination = "Player";
          deck.dealCard(destination, userInput);
        }
      } else if(userInput.startsWith("show")) {
        deck.showBoard();
        }

      sc = new Scanner(System.in);
    }
    int count = numberOfWays("1pair");
    System.out.println("Number of ways: " + count);
  }

  public static int numberOfWays(String input) {
      System.out.println();
      if (input.equals("1pair")) {
          DeckRaw deck = new DeckRaw();
          DeckRaw hand = new DeckRaw();
          int count = 0;
          for (int a = 0; a < deck.size()-4; a += 1) {
              for (int b = 1; b < deck.size()-3; b += 1) {
                  for (int c = 2; c < deck.size()-2; c += 1) {
                      for (int d = 3; d < deck.size()-1; d += 1) {
                          for (int e = 4; e < deck.size(); e += 1) {
                              hand.empty();
                              hand.add(deck.get(a));
                              hand.add(deck.get(b));
                              hand.add(deck.get(c));
                              hand.add(deck.get(d));
                              hand.add(deck.get(e));
                              if (hand.type().equals("1pair")) {
                                  count += 1;
                                  //System.out.println("found");
                              }
                          }
                      }
                  }
              }
          }
          return count;
      }
      return 0;
  }
}
