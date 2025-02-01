package librarymanagement;

public class NovelBook extends Book {
    private String genre;

    public NovelBook(String isbn, String title, String author, String genre){       //pass parent + current cls attributes in param constructor
        super(isbn, title, author);
        this.genre = genre;
        //genre = "";     //can't do like this in parameterized constructor. bcz value varies as per obj hence use this
    }

    @Override
    void displayBookDetails() {
        System.out.println("BOOK DETAILS- ");
        System.out.println("Title: " + getTitle());
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Author: "+getAuthor());
        System.out.println("Genre: "+genre);
    }
}
