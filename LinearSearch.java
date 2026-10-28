import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Utility class for array generation and linear search operations.
 *
 * Created by: Shem
 * Created on: Oct, 27, 2026
 * Generates an array of 10 random integers (0 to 100), sorts them with
 * Arrays.sort(), displays them, and performs a linear search based on user
 * input. Continues looping until the user enters 'q' to quit.
 */
public final class LinearSearch {

    /** Max bound for random number generation (exclusive). */
    private static final int MAX_BOUND = 101;

    /** Array size constant. */
    private static final int ARRAY_SIZE = 10;

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private LinearSearch() {
    }

    /**
     * Performs a linear search on an array of integers.
     *
     * @param numbers the array of integers to search through
     * @param target the integer value to find
     * @return the index of the target if found, or -1 if not found
     */
    public static int linearSearch(final int[] numbers, final int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Generates and returns an array of 10 random integers from 0 to 100.
     *
     * @return an array of 10 random integers
     */
    public static int[] populateArray() {
        final int[] numbers = new int[ARRAY_SIZE];
        final Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(MAX_BOUND);
        }
        return numbers;
    }

    /**
     * Main entry point of the program.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.println(
            "What number are you searching for in the list below? "
                + "Enter \"q\" to quit."
        );

        while (true) {
            final int[] numbers = populateArray();
            Arrays.sort(numbers);

            final StringBuilder line = new StringBuilder();
            for (final int num : numbers) {
                line.append(num).append(" ");
            }

            System.out.print(line.toString().trim() + "   Number: ");
            final String input = scanner.next();

            if ("q".equalsIgnoreCase(input)) {
                System.out.println("Thank you for playing!");
                break;
            }

            try {
                final int target = Integer.parseInt(input);
                final int index = linearSearch(numbers, target);

                if (index != -1) {
                    System.out.println(
                        "The number " + target
                            + " is found at index " + index + "."
                    );
                } else {
                    System.out.println(
                        "The number " + target
                            + " is not found in the list of numbers."
                    );
                }
            } catch (final NumberFormatException e) {
                System.out.println(
                    "Invalid input! "
                        + "Please enter a valid integer or 'q' to quit."
                );
            }
        }

        scanner.close();
    }
}
