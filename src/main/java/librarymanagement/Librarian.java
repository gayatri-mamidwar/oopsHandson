package librarymanagement;


public class Librarian extends User {

    private String employeeNumber;

    public Librarian(String employeeNumber, String name, String contactInfo){
        super(name, contactInfo);
        this.employeeNumber = employeeNumber;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Librarian Dashboard: ");
        System.out.println("employeeNumber: " + employeeNumber + "Name: " + getName());
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    public void addNewBook(Book book){
        System.out.println("Book added");
    }

    public void removeBook(Book book){
        System.out.println("Book removed");
    }
}
