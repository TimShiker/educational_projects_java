package CoolNumber;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        List<String> checkList = CoolNumbers.generateCoolNumbers();
        String coolNumberForSearch = "Р111АУ60";

        // searchInHashSet
        HashSet<String> listInHash = new HashSet<>(checkList);
        long searchInHashSetTime;
        long startTimeForSearchInHashSet = System.nanoTime();

        if(CoolNumbers.searchInHashSet(listInHash, coolNumberForSearch)){
            searchInHashSetTime = System.nanoTime() - startTimeForSearchInHashSet;
            System.out.println("Search in HashSet: number found, search took "
                    +  searchInHashSetTime + " nanoseconds");
        }
        else {
            searchInHashSetTime = System.nanoTime() - startTimeForSearchInHashSet;
            System.out.println("Search in HashSet: number not found, search took "
                    +  searchInHashSetTime + " nanoseconds");
        }

        // searchInTreeSet
        TreeSet<String> listInTreeSet = new TreeSet<String>(checkList);
        long searchInTreeSetTime;
        long startTimeForSearchInTreeSet = System.nanoTime();

        if(CoolNumbers.searchInTreeSet(listInTreeSet, coolNumberForSearch)){
            searchInTreeSetTime = System.nanoTime() - startTimeForSearchInTreeSet;
            System.out.println("TreeSat search: number found, search took " +  searchInTreeSetTime + " nanoseconds");
        }
        else {
            searchInTreeSetTime = System.nanoTime() - startTimeForSearchInTreeSet;
            System.out.println("TreeSat search: number found, search took " +  searchInTreeSetTime + " nanoseconds");
        }

        // bruteForceSearchInList
        long bruteForceSearchTime;
        long startTimeForBruteForceSearch = System.nanoTime();

        if(CoolNumbers.bruteForceSearchInList(checkList, coolNumberForSearch)){
            bruteForceSearchTime = System.nanoTime() - startTimeForBruteForceSearch;
            System.out.println("Search by brute force: number found, search took " +  bruteForceSearchTime +
                    " nanoseconds.");
        }
        else {
            bruteForceSearchTime = System.nanoTime() - startTimeForBruteForceSearch;
            System.out.println("ПSearch by brute force: number found, search took " +  bruteForceSearchTime +
                    " nanoseconds.");
        }

        // binarySearchInList
        Collections.sort(checkList);
        long binarySearchTime;
        long startTimeBinarySearch = System.nanoTime();

        if(CoolNumbers.binarySearchInList(checkList, coolNumberForSearch)){
            binarySearchTime = System.nanoTime() - startTimeBinarySearch;
            System.out.println("Binary search: number found, search took " +  binarySearchTime + " nanoseconds");
        }
        else {
            binarySearchTime = System.nanoTime() - startTimeBinarySearch;
            System.out.println("Binary search: number found, search took " +  binarySearchTime + " nanoseconds");
        }
    }
}
