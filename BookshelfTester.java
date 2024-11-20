// Name: Martha Ann Williams
// USC NetID: marthaan
// CSCI455 PA2
// Fall 2023

import java.util.ArrayList;

/**
 * Class BookshelfTester
 * Unit tester for Bookshelf class.
 * Should have the structure of others in this course:
 * - uses hard-coded data (no user input)
 * - shows both expected and actual results
 * - tests various combinations of calling the methods
 * - tests for general and edge cases
 */

public class BookshelfTester {

   public static void main(String[] args) {

      System.out.println("----------Exercise 2----------");

      System.out.println("Test constructor of empty Bookshelf, using toString() method");
      Bookshelf bookshelfEmpty = new Bookshelf();
      System.out.println("Expected: []");
      System.out.print("Actual: ");
      System.out.println(bookshelfEmpty.toString());
      System.out.println();

      System.out.println("Test constructor of non-empty Bookshelf, using toString() method");
      ArrayList<Integer> pileOfBooks0 = new ArrayList<>();
      pileOfBooks0.add(0);
      pileOfBooks0.add(9);
      pileOfBooks0.add(6);
      Bookshelf bookshelfNotEmpty = new Bookshelf(pileOfBooks0);
      System.out.println("Expected: [0, 9, 6]");
      System.out.print("Actual: ");
      System.out.println(bookshelfNotEmpty.toString());
      System.out.println();


      System.out.println("----------Exercise 3----------");

      System.out.println("TEST #1: addLast() method");
      ArrayList<Integer> pileOfBooks1 = new ArrayList<>();
      pileOfBooks1.add(8);
      pileOfBooks1.add(3);
      pileOfBooks1.add(10);
      Bookshelf bookshelfAddLast = new Bookshelf(pileOfBooks1);
      System.out.println("Bookshelf before addLast(): ");
      System.out.println(bookshelfAddLast.toString());
      bookshelfAddLast.addLast(9);
      System.out.println("Bookshelf after addLast(): ");
      System.out.println("Expected: [8, 3, 10, 9]");
      System.out.println("Actual: " + bookshelfAddLast.toString());
      System.out.println();

      System.out.println("TEST #2: removeLast() method");
      ArrayList<Integer> pileOfBooks2 = new ArrayList<>();
      pileOfBooks2.add(20);
      pileOfBooks2.add(7);
      pileOfBooks2.add(32);
      pileOfBooks2.add(0);
      pileOfBooks2.add(1);
      Bookshelf bookshelfRemoveLast = new Bookshelf(pileOfBooks2);
      System.out.println("Bookshelf before removeLast(): ");
      System.out.println(bookshelfRemoveLast.toString());
      int removeLastHeight = bookshelfRemoveLast.removeLast();
      System.out.println("Height removed: ");
      System.out.println("Expected: 1");
      System.out.println("Actual: " + removeLastHeight);
      System.out.println("Bookshelf after removeLast(): ");
      System.out.println("Expected: [20, 7, 32, 0]");
      System.out.println("Actual: " + bookshelfRemoveLast.toString());
      System.out.println();

      System.out.println("TEST #3: getHeight() method");
      ArrayList<Integer> pileOfBooks3 = new ArrayList<>();
      pileOfBooks3.add(4);
      pileOfBooks3.add(100);
      pileOfBooks3.add(34);
      pileOfBooks3.add(0);
      Bookshelf bookshelfGetHeight = new Bookshelf(pileOfBooks3);
      System.out.println("Bookshelf before getHeight(): ");
      System.out.println(bookshelfGetHeight.toString());
      int heightAtPos= bookshelfGetHeight.getHeight(2);
      System.out.println("After getHeight(2), height at position 2 is: ");
      System.out.println("Expected: 34");
      System.out.println("Actual: " + heightAtPos);
      System.out.println("Actual: " + bookshelfGetHeight.toString());
      System.out.println();

      System.out.println("TEST #4: test size()");
      ArrayList<Integer> pileOfBooks4 = new ArrayList<>();
      pileOfBooks4.add(0);
      pileOfBooks4.add(99);
      pileOfBooks4.add(54);
      pileOfBooks4.add(2);
      Bookshelf bookshelfSize = new Bookshelf(pileOfBooks4);
      System.out.println("Bookshelf before size(): ");
      System.out.println(bookshelfSize.toString());
      int sizeTest4 = bookshelfSize.size();
      System.out.println("After size(), bookshelf size is: ");
      System.out.println("Expected: 4");
      System.out.println("Actual: " + sizeTest4);
      System.out.println();


      System.out.println("----------Exercise 4----------");

      System.out.println("TEST #5: test addFront()");
      ArrayList<Integer> pileOfBooks5 = new ArrayList<>();
      pileOfBooks5.add(3);
      pileOfBooks5.add(73);
      pileOfBooks5.add(1);
      pileOfBooks5.add(3);
      Bookshelf bookshelfAddFront = new Bookshelf(pileOfBooks5);
      System.out.println("Bookshelf before addFront(): ");
      System.out.println(bookshelfAddFront.toString());
      bookshelfAddFront.addFront(2);
      System.out.println("Bookshelf after addFront(): ");
      System.out.println("Expected: [2, 3, 73, 1, 3]");
      System.out.println("Actual: " + bookshelfAddFront);
      System.out.println();

      System.out.println("TEST #6: test removeFront()");
      ArrayList<Integer> pileOfBooks6 = new ArrayList<>();
      pileOfBooks6.add(99);
      pileOfBooks6.add(33);
      pileOfBooks6.add(0);
      pileOfBooks6.add(4);
      Bookshelf bookshelfRemoveFront = new Bookshelf(pileOfBooks6);
      System.out.println("Bookshelf before removeFront(): ");
      System.out.println(bookshelfRemoveFront.toString());
      int removeHeight = bookshelfRemoveFront.removeFront();
      System.out.println("After removeFront(), height removed is: ");
      System.out.println("Expected: 99");
      System.out.println("Actual: " + removeHeight);
      System.out.println("Bookshelf after removeFront(): ");
      System.out.println("Expected: [33, 0, 4]");
      System.out.println("Actual: " + bookshelfRemoveFront.toString());
      System.out.println();

      System.out.println("TEST #7: test isSorted()");
      ArrayList<Integer> pileOfBooks7 = new ArrayList<>();
      pileOfBooks7.add(1);
      pileOfBooks7.add(2);
      pileOfBooks7.add(3);
      pileOfBooks7.add(4);
      Bookshelf bookshelfIsSorted = new Bookshelf(pileOfBooks7);
      System.out.println("Bookshelf before isSorted(): ");
      System.out.println(bookshelfIsSorted.toString());
      boolean resultIsSorted1 = bookshelfIsSorted.isSorted();
      System.out.println("Bookshelf result of isSorted(): ");
      System.out.println("Expected: true");
      System.out.println("Actual: " + resultIsSorted1);
      System.out.println();
      pileOfBooks7.add(0);
      Bookshelf bookshelfIsSorted2 = new Bookshelf(pileOfBooks7);
      System.out.println("Bookshelf after adding height 0: ");
      System.out.println(bookshelfIsSorted2.toString());
      boolean resultIsSorted2 = bookshelfIsSorted2.isSorted();
      System.out.println("Bookshelf result of isSorted() again: ");
      System.out.println("Expected: false");
      System.out.println("Actual: " + resultIsSorted2);
      System.out.println();


      System.out.println("----------Exercise 5----------");
      System.out.println("In Bookshelf, see: ");
      System.out.println("1. representation invariant comment");
      System.out.println("2. isValidBookshelf() method");
      System.out.println("3. isValidBookshelf() assert statements in both constructors");
      System.out.println("4. TestAssert");
      System.out.println("5. assert statements in any other methods");
   }
}