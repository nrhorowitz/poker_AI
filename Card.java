public class Card {
  private String value;
  private String suit;

  public Card(String value, String suit) {
    this.value = value;
    this.suit = suit;
  }

  public String getValue() {
    return value;
  }
  public String getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return value + " of " + suit;
  }

  @Override
  public boolean equals(Object o) {
    Card c = (Card)o;
    if((c.getValue().equals(value)) && (c.getSuit().equals(suit))) {
      return true;
    } else {
      return false;
    }
  }

}
