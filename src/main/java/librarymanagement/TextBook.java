package librarymanagement;

public class TextBook extends Book {
    private String subject;
    private int edition;

    public TextBook(String isbn, String title, String author, int edition, String subject){
        super(isbn, title, author);
        this.edition = edition;
        this.subject = subject;
    }

    @Override
    void displayBookDetails() {
        System.out.println("BOOK DETAILS- ");
        System.out.println("Title: " + getTitle());
        System.out.println("Subject: "+subject);
        System.out.println("ISBN: " + getIsbn());
        System.out.println("Author: "+getAuthor());
        System.out.println("Edition: "+edition);
    }
}
