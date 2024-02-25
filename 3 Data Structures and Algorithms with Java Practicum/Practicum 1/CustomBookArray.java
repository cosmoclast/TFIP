/**
 * Class to create a dynamic array that can add book objects, delete book objects and
 * search for book objects. Also contains overridden toString method to return a formatted
 * String of the book titles in the dynamic array
 *
 * @author Bernard Yeo
 */
public class CustomBookArray {
    /**
     * Size of the array
     */
    private int arraySize;
    /**
     * Keep track of numbers of objects stored at any point of time
     */
    private int arrayCount;
    /**
     * Maximum size of the array
     */
    private static final int LIMIT = 8;
    /**
     * Array containing Book objects
     */
    private Book[] booksArray;

    /**
     * Constructor to initialise the arraySize, arrayCount and booksArray
     */
    public CustomBookArray(){
        this.arraySize = 2;
        this.arrayCount = 0;
        this.booksArray = new Book[arraySize];
    }

    /**
     * Method to add a book object to the dynamic array. Will double the array size
     * when number of items in the array exceeds the current array size,
     * up to a maximum of size 8.
     *
     * @param bookToAdd Book object to add to the dynamic array
     */
    protected void add(Book bookToAdd) {

        if((this.arrayCount + 1) > LIMIT){
            System.out.println("You have reached the maximum array size");

        }else if((this.arrayCount + 1) > this.arraySize){
            this.arraySize *= 2;
            this.arraySize = Integer.min(LIMIT, this.arraySize);
            resizeArray();
            this.booksArray[this.arrayCount] = bookToAdd;
            this.arrayCount++;

        }else{
            booksArray[this.arrayCount] = bookToAdd;
            this.arrayCount++;
        }
    }

    /**
     * Method to delete a book object from the dynamic array. To match the title,
     * it is case-insensitive. Will half the array size when the number of items
     * in the array is half of the array size, down to a minimum size of 2.
     * Will delete the first occurrence if there are duplicates.
     *
     * @param titleToDelete Title of the book object to delete
     */
    protected void delete(String titleToDelete){

        if(searchBook(titleToDelete) == -1){
            System.out.println("There are no such titles to delete");
        }else{
            for(int j = searchBook(titleToDelete); j < this.arrayCount - 1; j++)
                this.booksArray[j] = this.booksArray[j+1];
            this.arrayCount--;
        }

        if(this.arrayCount <= (this.arraySize/2)){
            this.arraySize /= 2;
            this.arraySize = Integer.max(2,this.arraySize);
            resizeArray();
        }
    }

    /**
     * Method to resize a dynamic array by copying of items from the
     * old array to the new array with a new array size
     */
    private void resizeArray(){
        Book[] tempBooksArray = new Book[this.arraySize];

        for(int i = 0; i < this.arrayCount; i++)
            tempBooksArray[i] = this.booksArray[i];

        this.booksArray = tempBooksArray;
    }

    /**
     * Method to search for a book title in the array. To match the title,
     * it is case-insensitive. Will only return index of the first occurrence
     * if there are duplicates.
     *
     * @param titleToSearch Title of the book to search in the array
     * @return Index value of the title in the array, returns -1 if title not found in the array
     */
    protected int searchBook(String titleToSearch){
        for(int i = 0; i < this.arrayCount; i++){
            if(this.booksArray[i].getTitle().equalsIgnoreCase(titleToSearch))
                return i;
        }
        return -1;
    }

    /**
     * Getter to access the array size
     *
     * @return Size of the array
     */
    protected int getArraySize(){
        return this.arraySize;

    }

    /**
     * Overridden toString method from Object class
     *
     * @return Titles in the book array
     */
    @Override
    public String toString(){
        String allTitles = "";

        for(int i = 0; i < this.arrayCount; i++){
            if(i == 0){
                allTitles = allTitles + this.booksArray[i].getTitle();
            } else {
                allTitles = allTitles + ", " + this.booksArray[i].getTitle();
            }
        }

        return String.format("[%s]", allTitles);
    }
}
