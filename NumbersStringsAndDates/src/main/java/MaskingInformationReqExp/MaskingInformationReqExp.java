package MaskingInformationReqExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskingInformationReqExp {

    public static final String leftSign = "<";
    public static final String rightSign = ">";
    public static final String msgError = "Error input text. " +
            "Example input text (pay attention to the signs < and >): " +
            "\"<3434> 3612 1245 <2323>" + "\"" +
            "\nBut your input text: ";

    public static void main(String[] args) {

        String text = "Number of credit card <4008> <8912> 4355 6565 <3434>";

        System.out.println(searchAndReplaceDiamonds(text, "***"));

    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        String textOut;

        String regex = "\\s?\\<[\\d,\\s]+\\>\\s?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if(matcher.find()){
            textOut = text.replaceAll("\\<[\\d,\\s]+\\>", placeholder);
        }
        else {
            return msgError + text;
        }

        if(textOut.contains(leftSign) || textOut.contains(rightSign)){
            return msgError + text;
        }

        return textOut;
    }

}