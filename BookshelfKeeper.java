// Name: Martha Ann Williams
// USC NetID: marthaan
// CSCI455 PA2
// Fall 2023

/**
 * Class BookshelfKeeper 
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in 
 * non-decreasing order by height, with the restriction that single books can only be added 
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put 
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

    /**
     * Representation invariant:
     *
     * This BookshelfKeeper contains a Bookshelf. A Bookshelf can be not sorted,
     * but this Bookshelf must be empty or sorted in non-decreasing order by
     * the keeper (both before and after any mutator operations).
     * Total operations must be the minimum sum of all mutator calls performed
     * on the contained Bookshelf, via pick and put, and be at least 0. The result of
     * these pick and put operations must keep the Bookshelf sorted based on book height.
   */
   private Bookshelf bookshelf;
   private int totalOperations;

   /**
    * Creates a BookShelfKeeper object with an empty bookshelf
    */
   public BookshelfKeeper() {
      this.bookshelf = new Bookshelf();
      this.totalOperations = 0;

      assert isValidBookshelfKeeper();
   }

   /**
    * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
    * Note: method does not make a defensive copy of the bookshelf.
    *
    * PRE: sortedBookshelf.isSorted() is true.
    */
   public BookshelfKeeper(Bookshelf sortedBookshelf) {
      assert sortedBookshelf.isSorted();

      this.bookshelf = sortedBookshelf;
      this.totalOperations = 0;

      assert isValidBookshelfKeeper();
   }

   /**
    * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted 
    * after picking up the book.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: 0 <= position < getNumBooks()
    */
   public int pickPos(int position) {
      assert 0 <= position && position < this.getNumBooks();
      int countCalls = 0;

      // if position is not first/last, returned countCall still 0
      int helperCount1 = pickFirstLast(bookshelf, position);
      countCalls += helperCount1;

      // if position is not first/last, pick book from the correct end of bookshelf
      if (countCalls == 0) {
         int helperCount2 = pickHalves(bookshelf, position);
         countCalls += helperCount2;
      }

      totalOperations += countCalls;

      assert isValidBookshelfKeeper();
      return countCalls;
   }

   /**
    * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted 
    * after the insertion.
    * 
    * Returns the number of calls to mutators on the contained bookshelf used to complete this
    * operation. This must be the minimum number to complete the operation.
    * 
    * PRE: height > 0
    */
   public int putHeight(int height) {
      assert height > 0;

      int countCalls = 0;

      int putHelper1 = putFirstLast(bookshelf, height);
      countCalls += putHelper1;

      if (countCalls == 0) {
         int putPos = putPosition(bookshelf, height);
         int putHelper2 = putHalves(bookshelf, height, putPos);
         countCalls += putHelper2;
      }

      totalOperations += countCalls;

      assert isValidBookshelfKeeper();
      return countCalls;
   }

   /**
    * Returns the total number of calls made to mutators on the contained bookshelf
    * so far, i.e., all the ones done to perform all of the pick and put operations
    * that have been requested up to now.
    */
   public int getTotalOperations() {
      assert isValidBookshelfKeeper();
      return totalOperations;
   }

   /**
    * Returns the number of books on the contained bookshelf.
    */
   public int getNumBooks() {
      assert isValidBookshelfKeeper();
      return bookshelf.size();
   }

   /**
    * Returns string representation of this BookshelfKeeper. Returns a String containing height
    * of all books present in the bookshelf in the order they are on the bookshelf, followed 
    * by the number of bookshelf mutator calls made to perform the last pick or put operation, 
    * followed by the total number of such calls made since we created this BookshelfKeeper.
    * 
    * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
    * 
    */
   public String toString() {
      assert isValidBookshelfKeeper();
      return bookshelf.toString();
   }

   /**
    * Returns true iff the BookshelfKeeper data is in a valid state.
    * (See representation invariant comment for details.)
    */
   private boolean isValidBookshelfKeeper() {
      boolean valid = true;

      for (int i = 0; i < bookshelf.size() - 1; i++) {
         if (bookshelf.getHeight(i) > bookshelf.getHeight(i + 1)) {
            valid = false;
         }
      }

      return valid;
   }

   /**
    * Removes book from only the front or end of the contained Bookshelf                  // TODO: remove @ stuff? given comments don't use this format
    */
   private int pickFirstLast(Bookshelf bookshelf, int position) {             // TODO: error check for out of bounds position?
      int size = bookshelf.size();
      int countCalls = 0;

      if (position == 0) {
         bookshelf.removeFront();
         countCalls++;
      }
      else if (position == size - 1) {
         bookshelf.removeLast();
         countCalls++;
      }

      return countCalls;
   }

   /**
    * Picks the book based on if position is in front half or back
    * half of the contained Bookshelf
    */
   private int pickHalves(Bookshelf bookshelf, int position) {
      Bookshelf temps = new Bookshelf();

      int size = bookshelf.size();
      int sizeHalf = size / 2;
      int countCalls = 0;

      if (position < sizeHalf) {                         // if position is in firstHalf
         for (int i = 0; i <= position; i++) {
            temps.addLast(bookshelf.removeFront());
            countCalls++;
         }
         for (int j = position - 1; j >= 0; j--) {
            bookshelf.addFront(temps.getHeight(j));
            countCalls++;
         }
      }
      else if (position >= sizeHalf && position < size) {      // if position is in secondHalf
         for (int i = size - 1; i >= position; i--) {
            temps.addLast(bookshelf.removeLast());
            countCalls++;
         }
         for (int j = temps.size() - 2; j >= 0; j--) {
            bookshelf.addLast(temps.getHeight(j));
            countCalls++;
         }
      }

      return countCalls;
   }

   /**
    * Puts the book only at the front or the back of the contained Bookshelf
    */
   private int putFirstLast(Bookshelf bookshelf, int height) {
      int size = bookshelf.size();
      int countCalls = 0;

      if (bookshelf.size() == 0) {
         bookshelf.addFront(height);
         countCalls++;
      }
      else if (height <= bookshelf.getHeight(0)) {
         bookshelf.addFront(height);
         countCalls++;
      }
      else if (height >= bookshelf.getHeight(size - 1)) {
         bookshelf.addLast(height);
         countCalls++;
      }

      return countCalls;
   }

   /**
    * Finds the position where the book of a certain height should
    * be put in the contained Bookshelf
    */
   private int putPosition(Bookshelf bookshelf, int height) {
      int size = bookshelf.size();
      int putPos = 0;

      for (int i = 0; i < size; i++) {
         if (bookshelf.getHeight(i) >= height) {
            putPos = i;
            i = size;
         }
      }

      return putPos;
   }

   /**
    * Puts the book of the given height in the contained Bookshelf
    * at the correct position
    */
   private int putHalves(Bookshelf bookshelf, int height, int putPos) {
      Bookshelf temps = new Bookshelf();

      int size = bookshelf.size();
      int sizeHalf = size / 2;
      int countCalls = 0;

      if (putPos < sizeHalf) {
         for (int j = 0; j < putPos; j++) {
            temps.addLast(bookshelf.removeFront());
            countCalls++;
         }
         bookshelf.addFront(height);
         countCalls++;
         for (int k = temps.size() - 1; k >= 0; k--) {
            bookshelf.addFront(temps.getHeight(k));
            countCalls++;
         }
      }
      if (putPos >= sizeHalf && putPos < size) {
         for (int j = size - 1; j >= putPos; j--) {
            temps.addLast(bookshelf.removeLast());
            countCalls++;
         }
         bookshelf.addLast(height);
         countCalls++;
         for (int k = temps.size() - 1; k >= 0; k--) {
            bookshelf.addLast(temps.getHeight(k));
            countCalls++;
         }
      }

      return countCalls;
   }
}
