// Name: Martha Ann Williams
// USC NetID: marthaan
// CSCI455 PA2
// Fall 2023

import java.util.Scanner;

/**
 * Class BookshelfKeeperProg
 *
 * Terminal-based interactive program that contains the main method
 * and is used to read user input. Program allows the user to perform
 * a series of pickPos and putHeight operations on a BookshelfKeeper object, and
 * will print these results. Program can also be run in a batch
 * mode by using input and output redirection.
 */

public class BKProg2 {

    static Scanner in = new Scanner(System.in);

    public static boolean buildBookshelf(Bookshelf bookshelf) {
        System.out.println("Please enter initial arrangement of books followed by newline: ");

        String line = in.nextLine();
        Scanner lineScan = new Scanner(line);
        int height = 0;

        boolean valid = true;

        while (lineScan.hasNext()) {
            height = Integer.parseInt(lineScan.next());
            if (height <= 0) {
                System.out.println("ERROR: Height of a book must be positive.");
                System.out.println("Exiting Program.");
                valid = false;
            }
            else {
                bookshelf.addLast(height);
            }
        }
        if (!bookshelf.isSorted()) {
            System.out.println("ERROR: Heights must be specified in non-decreasing order.");
            System.out.println("Exiting Program.");
            valid = false;
        }
        return valid;
    }

    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();

        boolean valid = BKProg2.buildBookshelf(bookshelf);

        String line;
        Scanner lineScan;
        int numCalls = 0;
        int totalCalls = 0;

        if (valid) {
            BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(bookshelf);
            System.out.println(bookshelfKeeper.toString() + " " + numCalls + " " + totalCalls);
            System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");

            boolean end = false;

            while (!end) {
                line = in.nextLine();
                lineScan = new Scanner(line);
                String methodTemp = lineScan.next();
                int putIndex = 0;
                int pickIndex = 0;
                if (!methodTemp.equals("pick") && !methodTemp.equals("put") && !methodTemp.equals("end")) {
                    System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
                    System.out.println("Exiting Program.");
                    end = true;
                }
                else if (methodTemp.equals("pick")) {
                    pickIndex = Integer.parseInt(lineScan.next());
                    if (pickIndex < 0 || pickIndex >= bookshelfKeeper.getNumBooks()) {
                        System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
                        System.out.println("Exiting Program.");
                        end = true;
                    }
                    else {
                        numCalls = bookshelfKeeper.pickPos(pickIndex);
                        totalCalls = bookshelfKeeper.getTotalOperations();
                        System.out.println(bookshelfKeeper.toString() + " " + numCalls + " " + totalCalls);
                    }
                }
                else if (methodTemp.equals("put")) {
                    putIndex = Integer.parseInt(lineScan.next());
                    if (putIndex <= 0) {
                        System.out.println("ERROR: Height of a book must be positive.");
                        System.out.println("Exiting Program.");
                        end = true;
                    }
                    else {
                        numCalls = bookshelfKeeper.putHeight(putIndex);
                        totalCalls = bookshelfKeeper.getTotalOperations();
                        System.out.println(bookshelfKeeper.toString() + " " + numCalls + " " + totalCalls);
                    }
                }
                else if (methodTemp.equals("end")) {
                    System.out.println("Exiting Program.");
                    end = true;
                }
            }
        }
    }
}