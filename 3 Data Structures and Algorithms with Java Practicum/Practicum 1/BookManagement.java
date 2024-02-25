/**
 * Class to create 2 dynamic arrays that and to call the appropriate array's methods
 * based on the first letter of the title ie a, A or b, B.
 *
 * @author Bernard Yeo
 */
public class BookManagement {
    /**
     * Dynamic array with book titles starting with letter a or A
     */
    private CustomBookArray letterABooks;
    /**
     * Dynamic array with book titles starting with letter b or B
     */
    private CustomBookArray letterBBooks;

    /**
     * Constructor to initialise the aA array and bB array
     */
    public BookManagement() {
        this.letterABooks = new CustomBookArray();
        this.letterBBooks = new CustomBookArray();
    }

    /**
     * Method to call the appropriate array's add method based on
     * title of the book object. The letter to match is case-insensitive.
     * Will print message if the title of the book object does not start
     * with a, A or b, B
     *
     * @param bookToAdd Book object to add to the aA or bB array
     */
    protected void add(Book bookToAdd) {
        String bookTitleCheck = bookToAdd.getTitle().substring(0, 1);

        if (bookTitleCheck.equalsIgnoreCase("a")) {
            this.letterABooks.add(bookToAdd);
        } else if (bookTitleCheck.equalsIgnoreCase("b")) {
            this.letterBBooks.add(bookToAdd);
        } else {
            System.out.println("Title needs to begin with a or b");
        }
    }

    /**
     * Method to call the appropriate array's delete method based on
     * title of the book. The letter to match is case-insensitive.
     * Will print message if the title of the book does not start
     * with a, A or b, B
     *
     * @param bookToDelete Title of the book to delete
     */
    protected void delete(String bookToDelete) {
        String bookTitleCheck = bookToDelete.substring(0, 1);

        if (bookTitleCheck.equalsIgnoreCase("a")) {
            this.letterABooks.delete(bookToDelete);
        } else if (bookTitleCheck.equalsIgnoreCase("b")) {
            this.letterBBooks.delete(bookToDelete);
        } else {
            System.out.println("Title needs to begin with a or b");
        }
    }

    /**
     * A display method which prints the contents of both arrays
     * with the following format:
     * A: [Apple, Airplane, Apollo]
     * B: [Banana, Burger]
     */
    protected void display() {
        System.out.println("A: " + this.letterABooks);
        System.out.println("B: " + this.letterBBooks);
    }

    /**
     * A display method which prints the contents of the chosen array
     * of books using the following format:
     * A: [Apple, Airplane, Apollo]
     * B: [Banana, Burger]
     * The letter to match is case-insensitive
     *
     * @param startingLetter Letter to match the aA array or bB array
     */
    protected void display(String startingLetter) {
        if (startingLetter.equalsIgnoreCase("a")) {
            System.out.println("A: " + this.letterABooks);
        } else if (startingLetter.equalsIgnoreCase("b")) {
            System.out.println("B: " + this.letterBBooks);
        } else {
            System.out.println("Title needs to begin with a or b");
        }

    }

    /**
     * Method to call the appropriate array's searchBook method based on
     * title of the book. The letter to match is case-insensitive.
     * Will print message if the title does not start with a, A or b, B
     *
     * @param titleToSearch Title of the book to search
     */
    protected void searchBook(String titleToSearch) {
        String bookTitleCheck = titleToSearch.substring(0, 1);

        if (bookTitleCheck.equalsIgnoreCase("a")) {
            System.out.println(this.letterABooks.searchBook(titleToSearch));
        } else if (bookTitleCheck.equalsIgnoreCase("b")) {
            System.out.println(this.letterBBooks.searchBook(titleToSearch));
        } else {
            System.out.println("Title needs to begin with a or b");
        }
    }

    /**
     * Method to call the appropriate array's getArraySize method based on
     * user selection of a, A or b, B. The letter to match is case-insensitive.
     * Will print message if user did not select a, A or b, B and return -1.
     *
     * @param startingLetter First letter of the array
     * @return Size of the array
     */
    protected int getArraySize(String startingLetter) {
        if (startingLetter.equalsIgnoreCase("a")) {
            return this.letterABooks.getArraySize();
        } else if (startingLetter.equalsIgnoreCase("b")) {
            return this.letterBBooks.getArraySize();
        } else {
            System.out.println("Title needs to begin with a or b");
            return -1;
        }
    }
}