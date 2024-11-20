// Name: Martha Ann Williams            // TODO: might not be necessary
// USC NetID: marthaan
// CSCI455 PA2
// Fall 2023

import java.util.ArrayList;

/**
 * Class TestAssert
 * Small program.
 * Calls the one-argument Bookshelf constructor twice:
 * 1. Once where it satisfies its precondition
 * 2. Once where it does not satisfy its precondition
 * Run this program with and without the -ea flag.
 * (Your program should fail for the bad call when assertions are turned on)
 */

public class TestAssert {
   public static void main(String[] args) {
       ArrayList<Integer> pileOfBooksAssert1 = new ArrayList<>();
       pileOfBooksAssert1.add(0);
       pileOfBooksAssert1.add(3);
       pileOfBooksAssert1.add(0);
       pileOfBooksAssert1.add(1);
       Bookshelf bookshelfAssert1 = new Bookshelf(pileOfBooksAssert1);
       System.out.println(bookshelfAssert1.toString());

       ArrayList<Integer> pileOfBooksAssert2 = new ArrayList<>();
       pileOfBooksAssert2.add(0);
       pileOfBooksAssert2.add(-1);
       pileOfBooksAssert2.add(4);
       pileOfBooksAssert2.add(-4);
       Bookshelf bookshelfAssert2 = new Bookshelf(pileOfBooksAssert2);
       // boolean validResult = bookshelfAssert2.isValidBookshelf();
       // System.out.println(validResult);
       System.out.println(bookshelfAssert2.toString());
   }

}