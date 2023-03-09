/**
 * @author Max Day
 * Created At: 2023/03/09
 */

public class Main {
    /**
     * NOTE: THis is very overcomplicated. Honestly wouldn't really recommend doing it this way but its rly funny overcomplicating to test your knowledge. One thing I could have done better was to use an enum or string array to check the values for the text characters in the count but its kinda a hassle and not something i wanna invest extra time into
     */
    public static void main(String[] args) {
        printShape(5, 0, "STOP"); // radius and count and then what to print
        printShape(5, 0, "G0");
    }

    /**
     * @param rad
     * @param count
     * @Note this method is used to print the shape of a circle and the lower sign
     * The loop spam is not nice to read but by using Math.sqrt we can easily find the outer edges and work out the edges of the circle.
     * The stem is not hard
     * @apiNote Prints the main shape of
     */
    public static void printShape(int rad, int count, String input) {
        for (int i = 0; i <= 2 * rad; i++) {
            for (int j = 0; j <= 2 * rad; j++) {
                double dist = Math.sqrt((i - rad) * (i - rad) + (j - rad) * (j - rad)); // distance
                if (dist > rad - .5 && dist < rad + .5) // rad calc
                    System.out.print(" *");
                else {
                    input = (input.length() <= 2 ? String.format(" %s ", input) : input); // kinda bullshit but works and thats fine
                    System.out.print(placeLetter(count, input));
                    count++;
                }
            }
            System.out.println();
        }
        //sign pole
        for (int i = 0; i < rad + 1; i++) {
            for (int j = 0; j < rad * 2; j++) System.out.print(" ");
            System.out.println("**");
        }
        // pyramid base
        int k = 0;
        for (int i = 1; i <= 5; ++i, k = 0) {
            for (int j = 1; j <= 5 - i; ++j) {
                System.out.print("  ");
            }
            while (k != 2 * i) {
                System.out.print(" *");
                ++k;
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    /**
     * @param count
     * @return
     * @apiNote I would rather not have to use a switch but its just annoying to search through an enumeration or a int array to check if values exist
     */
    public static String placeLetter(int count, String input) {
        switch (count) {
            case 43 -> {
                return input.charAt(0) + " ";
            }
            case 45 -> {
                return input.charAt(1) + " ";
            }
            case 47 -> {
                return input.charAt(2) + " ";
            }
            case 49 -> {
                return input.charAt(3) + " ";
            }
            default -> {
                return "  ";
            }
        }
    }

}
