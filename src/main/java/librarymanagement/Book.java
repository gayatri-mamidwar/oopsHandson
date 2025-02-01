package librarymanagement;

public abstract class Book implements Lendable {
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;

    abstract void displayBookDetails();            //abstract method doesnt have body

    public Book() {
        isAvailable = true;
    }

    public Book(String isbn, String title, String author){
        this.isbn = isbn;           //use this.variable name in parameterized constructor value initialization
        this.title = title;
        this.author = author;
        this.isAvailable = true;        //initially book will be available so mark it as true
    }

    public Book(Book other){
        this.isbn = other.isbn;
        this.title = other.title;
        this.author = other.title;
    }

    @Override
    public boolean lend(User user) {
        if(isAvailable && user.canBorrowBooks()){
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public void returnBook(User user) {
        isAvailable = true;
        user.returnBook();
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
