package CoolNumber;

import java.util.*;

public class CoolNumbers {

    private static ArrayList<String> coolNumbers = new ArrayList<>();
    private static Random random;

    // method to generate cool numbers
    public static List<String> generateCoolNumbers() {

        int countOfCoolNumbers = 2_000_005;

        StringBuilder coolNumber;

        for(int i = 0; i < countOfCoolNumbers; i++){

            coolNumber = new StringBuilder();

            coolNumber.append(generateLetterInCoolNumber()).
                        append(generateNumbersInCoolNumber()).
                        append(generateLetterInCoolNumber()).
                        append(generateLetterInCoolNumber()).
                        append(generateCodeOfRegion());

            coolNumbers.add(coolNumber.toString());
        }

        return coolNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        
        for(String coolNumber : list){
            if(coolNumber.contains(number)) return true;
        }

        return false;
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {

        return Collections.binarySearch(sortedList, number) > -1;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

        return treeSet.contains(number);
    }

    private static String generateLetterInCoolNumber(){

        char [] allowedLetters = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
        int lengthAllowedLetters = allowedLetters.length;

        random = new Random();
        int indexAllowedLetter = random.nextInt(lengthAllowedLetters);

        return Character.toString(allowedLetters[indexAllowedLetter]);
    }


    private static String generateNumbersInCoolNumber() {

        String numberInCoolNumber = "";

        random = new Random();
        int newNumber = random.nextInt(9) + 1;
        numberInCoolNumber = Integer.toString(newNumber) + newNumber + newNumber;

        return numberInCoolNumber;
    }

    private static String generateCodeOfRegion() {

        String codeOfRegion = "";

        int numberForRegion = (int)(Math.random() * 200);

        if(numberForRegion < 10){
            codeOfRegion = "0" + numberForRegion;
        }
        else {
            codeOfRegion = Integer.toString(numberForRegion);
        }

        return codeOfRegion;
    }



}
