package com.example.project.Spell_Checker;

import com.example.project.Binary_Search.BinarySearch;

public class Test {
    public static void main(String[] args) {
        SpellChecker checker = new SpellChecker();

        boolean result = checker.binarySpellCheck("frost");
        int loopCount = checker.getLoopCounter();
        
        System.out.println(result);
    }
}
