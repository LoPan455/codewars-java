package io.tjohander;


import java.util.HashSet;

public class CountingDuplicates {

    public static int duplicateCount(String text) {
        // Write your code here
        int result = 0;
        System.out.println();


        // Create an array of chars for comparison
        // but the problem here is that if the text string has duplicates, they'll be searched for again.
        // the solution might be a Set
        HashSet<Character> characterHashSet = new HashSet<>();
        for (int i = 0; i < text.length() ; i++) {
            characterHashSet.add(text.toLowerCase().charAt(i));
        }

        // now let's go through the set and check each character for occurrences of each member.
        for(Character character : characterHashSet) {

            // we're going to need some way of tracking occurrences
            int occurrences = 0;

            // iterate
            for (int j = 0; j < text.length(); j++) {
                if (character == text.toLowerCase().charAt(j)) {
                    occurrences++;
                }
            }

            // if we get more than one occurrence, it should be tallied.
            if (occurrences > 1) {
                result++;
            }
        }
        return result;
    }
}
