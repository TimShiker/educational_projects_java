package TwoDimensionalArray;

public class TwoDimensionalArray {
    public static char symbol = 'X';
    public static char space = ' ';

    public static char[][] getTwoDimensionalArray(int size) {

        if (size < 1) {
            return null;
        }

        char[][] twoDimensionalArray = new char[size][size];

        for(int i = 0; i < twoDimensionalArray.length; i++){
            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                if(j == i || j == twoDimensionalArray.length - 1 - i){
                    twoDimensionalArray[i][j] = symbol;
                }
                else {
                    twoDimensionalArray[i][j] = space;
                }
            }
        }

        return twoDimensionalArray;
    }
}
