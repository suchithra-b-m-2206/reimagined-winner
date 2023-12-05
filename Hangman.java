import java.util.Scanner;

public class HangmanGame {
    private static final String[] WORDS = {"java", "programming", "hangman", "computer", "coding"};
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        String selectedWord = selectRandomWord();
        char[] wordToGuess = selectedWord.toCharArray();
        boolean[] guessedLetters = new boolean[wordToGuess.length];
        int incorrectTries = 0;

        System.out.println("Welcome to Hangman!");

        while (incorrectTries < MAX_TRIES && !isWordGuessed(guessedLetters)) {
            displayWord(wordToGuess, guessedLetters);
            char guess = getUserGuess();
            
            if (checkGuess(guess, wordToGuess, guessedLetters)) {
                System.out.println("Good guess!");
            } else {
                System.out.println("Incorrect guess. Try again.");
                incorrectTries++;
            }
        }

        if (isWordGuessed(guessedLetters)) {
            System.out.println("Congratulations! You guessed the word: " + selectedWord);
        } else {
            System.out.println("Sorry, you ran out of tries. The correct word was: " + selectedWord);
        }
    }

    private static String selectRandomWord() {
        int randomIndex = (int) (Math.random() * WORDS.length);
        return WORDS[randomIndex];
    }

    private static void displayWord(char[] wordToGuess, boolean[] guessedLetters) {
        for (int i = 0; i < wordToGuess.length; i++) {
            if (guessedLetters[i]) {
                System.out.print(wordToGuess[i] + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
    }

    private static char getUserGuess() {
        System.out.print("Enter your guess: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().charAt(0);
    }

    private static boolean checkGuess(char guess, char[] wordToGuess, boolean[] guessedLetters) {
        boolean correctGuess = false;
        for (int i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i] == guess) {
                guessedLetters[i] = true;
                correctGuess = true;
            }
        }
        return correctGuess;
    }

    private static boolean isWordGuessed(boolean[] guessedLetters) {
        for (boolean guessedLetter : guessedLetters) {
            if (!guessedLetter) {
                return false;
            }
        }
        return true;
    }
}
