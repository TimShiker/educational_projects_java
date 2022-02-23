package MaskingInformation;

import java.util.Scanner;

public class MaskingInformation {

    public static final char LEFT_SIGN = '<';
    public static final char RIGHT_SIGN = '>';
    public static final String EXAMPLE_TEXT =  "Example input text (pay attention to the signs < and >): " +
            "'<3434> 3612 1245 <2323>'.";
    public static final String MSG_ERROR = "Error input text. " + EXAMPLE_TEXT + "\"" +
                                        "\nBut your input text: ";
    public static final String PLACE_HOLDER = "***";
    public static final String TRUE_ANSWER = "It's your masking information: ";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter information for masking. " + EXAMPLE_TEXT);
        String safe = scanner.nextLine();

        System.out.println(searchAndReplaceDiamonds(safe) + "\n");

    }

    public static String searchAndReplaceDiamonds(String text) {

        String newText = "";
        int countOfSign = 0;
        int textLength = text.length();

        for(int i = 0; i < textLength; i++){

            char character = text.charAt(i);

            if(character == LEFT_SIGN){
                if(countOfSign != 0){

                    return MSG_ERROR + text;
                }
                countOfSign++;
            }

            if(countOfSign == 0){
                newText = newText + character;
            }

            if(character == RIGHT_SIGN){
                if(countOfSign != 1){
                    return MSG_ERROR + text;
                }
                countOfSign--;
                newText = newText + PLACE_HOLDER;
            }

            if(i == textLength - 1 && countOfSign != 0){
                return MSG_ERROR + text;
            }
        }

        return TRUE_ANSWER + newText;
    }
}