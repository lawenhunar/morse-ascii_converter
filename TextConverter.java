import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextConverter {
    class Colors {
        // Define ANSI color codes
        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
    }

    private static final Map<Character, String> morseCodeMap = new HashMap<>();

    static {
        // Morse code map for letters A-Z and numbers 0-9
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', ".----");
        morseCodeMap.put('2', "..---");
        morseCodeMap.put('3', "...--");
        morseCodeMap.put('4', "....-");
        morseCodeMap.put('5', ".....");
        morseCodeMap.put('6', "-....");
        morseCodeMap.put('7', "--...");
        morseCodeMap.put('8', "---..");
        morseCodeMap.put('9', "----.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Colors.BLUE + "Choose conversion type:" + Colors.RESET);
        System.out.println(Colors.YELLOW + "1. English to Morse Code" + Colors.RESET);
        System.out.println(Colors.YELLOW + "2. English to ASCII" + Colors.RESET);
        System.out.print(Colors.GREEN + "Enter 1 or 2: " + Colors.RESET);

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline

        System.out.print(Colors.BLUE + "Enter the word to convert: " + Colors.RESET);
        String word = scanner.nextLine().toUpperCase();

        if (choice == 1) {
            System.out.println(Colors.CYAN + "Morse Code:" + Colors.RESET);
            System.out.println(Colors.PURPLE + convertToMorse(word) + Colors.RESET);

        } else if (choice == 2) {
            System.out.println(Colors.CYAN + "ASCII Codes:" + Colors.RESET);
            System.out.println(Colors.PURPLE + convertToASCII(word) + Colors.RESET);
        } else {
            System.out.println(Colors.RED + "Invalid choice. Please restart the program." + Colors.RESET);
        }

        scanner.close();
    }

    private static String convertToMorse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (morseCodeMap.containsKey(c)) {
                morse.append(morseCodeMap.get(c)).append(" ");
            } else {
                morse.append("? "); // Unknown character
            }
        }
        return morse.toString();
    }

    private static String convertToASCII(String text) {
        StringBuilder ascii = new StringBuilder();
        for (char c : text.toCharArray()) {
            ascii.append((int) c).append(" ");
        }
        return ascii.toString();
    }
}
