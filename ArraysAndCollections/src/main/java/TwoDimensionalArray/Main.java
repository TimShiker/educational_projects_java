package TwoDimensionalArray;

public class Main {
    public static void main(String[] args) {

        char[][] printArray = TwoDimensionalArray.getTwoDimensionalArray(5);

        if (printArray != null){
            for(char[] symbols : printArray){
                System.out.println(symbols);
            }
        }
        else {
            System.out.println("Error. Array length must be greater than 0");
        }


    }
}
