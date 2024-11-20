// Name: Martha Ann Williams
// USC NetID: marthaan
// CSCI455 PA2
// Fall 2023

import java.util.ArrayList;

/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.   
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
*/

public class Bookshelf {

    /**
      Representation invariant:

      This bookshelf must always have non-negative integer elements.
      Thus, all heights in this bookshelf are greater than 0.
   */
   private ArrayList<Integer> books;

   /**
    * Creates an empty Bookshelf object i.e. with no books
    */
   public Bookshelf() {
      this.books = new ArrayList<>();
      assert isValidBookshelf();
   }

   /**
    * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
    * values: [20, 1, 9].
    * 
    * PRE: pileOfBooks contains an array list of 0 or more positive numbers
    * representing the height of each book.
    */
   public Bookshelf(ArrayList<Integer> pileOfBooks) {
      this.books = new ArrayList<>(pileOfBooks);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the start of the Bookshelf, i.e., it
    * will end up at position 0.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addFront(int height) {
      assert height > 0;
      books.add(0, height);
      assert isValidBookshelf();
   }

   /**
    * Inserts book with specified height at the end of the Bookshelf.
    * 
    * PRE: height > 0 (height of book is always positive)
    */
   public void addLast(int height) {
      assert height > 0;
      books.add(height);
      assert isValidBookshelf();
   }

   /**
    * Removes book at the start of the Bookshelf and returns the height of the
    * removed book.
    *
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeFront() {
      assert books.size() > 0;

      int removeHeight = books.get(0);
      books.remove(0);

      assert isValidBookshelf();
      return removeHeight;
   }

   /**
    * Removes book at the end of the Bookshelf and returns the height of the
    * removed book.
    * 
    * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
    */
   public int removeLast() {
      assert books.size() > 0;

      int heightRemoved = books.get(books.size() - 1);
      books.remove(books.size() - 1);

      assert isValidBookshelf();
      return heightRemoved;
   }

   /*
    * Gets the height of the book at the given position.
    * 
    * PRE: 0 <= position < this.size()
    */
   public int getHeight(int position) {
      assert 0 <= position && position < books.size();

      assert isValidBookshelf();
      return books.get(position);
   }

   /**
    * Returns number of books on the this Bookshelf.
    */
   public int size() {
      assert books.size() >= 0;                               // TODO: not necessary, but do we cover null bookshelf already? (i.e., does validBookshelf cover it)?

      assert isValidBookshelf();
      return books.size();
   }

   /**
    * Returns string representation of this Bookshelf. Returns a string with the height of all
    * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
    * by example here:  “[7, 33, 5, 4, 3]”
    */
   public String toString() {
      assert books.toString() != null;                           // TODO: same thing here as above

      assert isValidBookshelf();
      return books.toString();
   }

   /**
    * Returns true iff the books on this Bookshelf are in non-decreasing order.
    * (Note: this is an accessor; it does not change the bookshelf.)
    */
   public boolean isSorted() {
      boolean sorted = true;

      for (int i = 1; i < books.size(); i++) {
         if (books.get(i - 1) > books.get(i)) {
            sorted = false;
         }
      }

      assert isValidBookshelf();
      return sorted;
   }

   /**
    * Returns true iff the Bookshelf data is in a valid state.
    * (See representation invariant comment for more details.)
    */
   private boolean isValidBookshelf() {
      boolean valid = true;

      for (int height : books) {
         if (height < 0) {
            valid = false;
         }
      }

      return valid;
   }
}
