package com.example.project.Spell_Checker;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SpellChecker {
    private ArrayList<String> dictionary;
    private static int loopCounter;

    public SpellChecker() {
        dictionary = new ArrayList<String>();
        importDictionary();
    }

    public ArrayList<String> getDictionary() {
        return dictionary;
    }

    public int getLoopCounter(){
        return loopCounter;
    }

    /** This uses LINEAR search to find a word in dictionary and returns
     *  true if the word is in dictionary and false otherwise.
     *
     *  It also tracks the number of words checked (loop iterations) and
     *  prints that value out before returning.
     */
    public boolean linearSpellCheck(String word) {
        loopCounter = 0; // for testing
        for (String s : dictionary) {
            loopCounter++; // for testing
            if (word.equals(s)) {
                System.out.println("-- LINEAR SEARCH: Number of words checked (loop iterations): " + loopCounter);
                return true;
            }
        }
        System.out.println("-- LINEAR SEARCH: Number of words checked (loop iterations): " + loopCounter);
        return false;
    }



    /** This uses BINARY search to find a word in dictionary and returns
     *  true if the word is in dictionary and false otherwise.
     *
     *  It also tracks the number of words checked (loop iterations) and
     *  prints that value out before returning.
     */
    public boolean binarySpellCheck(String word) {
        loopCounter = 0;
        int leftIdx = 0;   // TODO: assign this initial value
        int rightIdx = dictionary.size() - 1;  // TODO: assign this initial value
        if (dictionary.size() == 0) {
            return false;
        }
        if (dictionary.get(0) == word) {
            return true;
        }

        while (leftIdx < rightIdx) {  // TODO: determine this condition (hint: see slides 61-63)
            loopCounter++; // for testing
            int middleIdx = (rightIdx+leftIdx) / 2;  // TODO: determine what this should be
            System.out.print(dictionary.get(middleIdx) + "\n"); // for testing

            // TODO: write the rest of the code to compare middleIdx to the word
            //  and adjust leftIdx and rightIdx as appropriate (see slides if needed)
            if (dictionary.get(middleIdx).equals(word)) {
                return true;
            } else if (dictionary.get(middleIdx).compareTo(word) > 0) {
                rightIdx = middleIdx - 1;
            } else {
                leftIdx = middleIdx + 1;
            }
            System.out.println(leftIdx + " " + rightIdx + " " + middleIdx);
        }
        if (leftIdx == rightIdx) {
            // Make sure to increment loop counter because this is another check for the word
            loopCounter++;
            if (dictionary.get(leftIdx) == word) {
                return true;
            }
        }
        return false;
    }

    // private helper method, called in the constructor, which loads the words
    // from the dictionary.txt text file into the "dictionary" instance variable!
    private void importDictionary() {
        try {
            File myFile = new File("src/main/java/com/example/project/Spell_Checker/dictionary.txt");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                dictionary.add(data);
            }
            System.out.println("\ndictionary.txt file imported successfully!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        SpellChecker checker = new SpellChecker();
        System.out.println("----------------------------- SPELL CHECKER -------------------------------");
        System.out.println("The spell checker dictionary has " + checker.getDictionary().size() + " words in it!");

        System.out.println("Enter a word to look up; if the word is not found, it is not");
        System.out.print("spelled correctly (or is simply not a word), or type q to quit: ");
        Scanner scan = new Scanner(System.in);
        String word = scan.nextLine();

        while (!word.equals("q")) {
            if (checker.binarySpellCheck(word)) {
                System.out.println("-- " + word + " WAS found in the dictionary (so it's spelled correctly)");
            } else {
                System.out.println("-- " + word + " was NOT found in the dictionary (so it's not spelled correctly)");
            }
            System.out.print("Enter a word to look up or q to quit: ");
            word = scan.nextLine();
        }
        scan.close();
    }
}
