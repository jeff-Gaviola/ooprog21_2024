import java.util.Scanner;

public class SpoonerismGenerator {

    // Method to get a word from the user
    public static String getWord(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine().toLowerCase();
    }

    // Method to find the first vowel index in a word
    public static int findFirstVowel(String word) {
        String vowels = "aeiou";
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                return i;
            }
        }
        return -1; // No vowel found
    }

    public static void main(String[] args) {
        // Get two words from the user
        String word1 = getWord("Enter the first word: ");
        String word2 = getWord("Enter the second word: ");

        // Find the index of the first vowel in each word
        int vowelIndex1 = findFirstVowel(word1);
        int vowelIndex2 = findFirstVowel(word2);

        // Check if both words have a valid consonant cluster before the first vowel
        if (vowelIndex1 <= 0 || vowelIndex2 <= 0) {
            System.out.println("Words are not suitable for spoonerizing.");
        } else {
            // Create spoonerized words
            String spoonerized1 = word2.substring(0, vowelIndex2) + word1.substring(vowelIndex1);
            String spoonerized2 = word1.substring(0, vowelIndex1) + word2.substring(vowelIndex2);

            // Print the original and spoonerized words
            System.out.println("Original words: " + word1 + " and " + word2);
            System.out.println("Spoonerized words: " + spoonerized1 + " and " + spoonerized2);
        }
    }
}
