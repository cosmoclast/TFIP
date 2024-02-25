/**
 * Class to create a book object and store the title, author and number of pages
 * of the book. Also contains overridden toString method to return a formatted
 * String of the title, author and number of pages of the book.
 *
 * @author Bernard Yeo
 */
public class Book {
    /**
     * Title of the book
     */
    private String title;
    /**
     * Author of the book
     */
    private String author;
    /**
     * Number of pages of the book
     */
    private int page;

    /**
     * Constructor to initialise the variables of the Book class
     *
     * @param title Title of the book
     * @param author Author of the book
     * @param page Number of pages of the book
     */
    public Book(String title, String author, int page){
        this.title = title;
        this.author = author;
        this.page = page;
    }

    /**
     * Getter to access the title of the book
     *
     * @return Title of the book
     */
    protected String getTitle(){
        return this.title;
    }

    /**
     * Overridden toString method from Object class
     *
     * @return Title, author and number of pages of the book
     */
    @Override
    public String toString(){
        return String.format("""
                %s
                    Author: %s
                    Page: %d               
                """,
                    this.title,
                    this.author,
                    this.page);
    }
}
