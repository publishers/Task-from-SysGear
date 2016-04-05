package matches;

public class SquareMatches {
  private int numberSquares;
  private int numberMatches;

  public SquareMatches(int numberSquares) {
    if (numberSquares > 0) {
      this.numberSquares = numberSquares;
    } else {
      System.err.println("number Squares has to more than 0");
    }
  }

  public void process() {
    int oneSideMatches = (int) Math.sqrt(numberSquares);

    int maxSquaresOnSide = (int) Math.round((numberSquares - Math.pow(oneSideMatches, 2)) / oneSideMatches) + oneSideMatches;

    if (numberSquares - (oneSideMatches * maxSquaresOnSide) >= 1) {
      maxSquaresOnSide += 1;
    }

    int numberMatchesOnBoard = oneSideMatches + maxSquaresOnSide - 2;
    int numberMatchesInside = numberSquares - (numberMatchesOnBoard + 1);

    numberMatches = 4 + 3 * numberMatchesOnBoard + 2 * numberMatchesInside;
  }

  public String toString() {
    return "" + numberMatches;
  }

}
