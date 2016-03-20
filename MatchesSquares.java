/**
* Created by Sergey ML on 28.07.14.
*/
public class MatchesSquares {
    private int numberSquares;
    private int numberMatches;

    public int getNumberMatches() {
        return numberMatches;
    }

    public MatchesSquares(int numberSquares) {
        if (numberSquares > 0) {
            this.numberSquares = numberSquares;
        } else {
            System.err.println("numverSquares have to more than 0");
        }
    }

    public void createSolution() {
        int side = (int) (Math.sqrt(numberSquares));
        int borderSquares = (int) Math.round((numberSquares - Math.pow(side, 2)) / side)
                + side;//count the numbers of squares on sides the border of squares

        if ((numberSquares - (side * borderSquares)) >= 1) //to clarify count of borderSquares
            borderSquares += 1;

        int three = side + borderSquares - 2;//number Squares outside
        int two = numberSquares - (three + 1); //number Squares inside

        numberMatches = 4 + 3 * three + 2 * two;
    }

    public String toString(){
        return ""+numberMatches;
    }
}
