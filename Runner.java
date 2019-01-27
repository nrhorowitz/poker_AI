import java.util.Scanner;
public class Runner {
  public static void main(String[] args) {
    Deck deck = new Deck();
    deck.showBoard();
    Scanner sc = new Scanner(System.in);
    while(true) {
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
  }
}
