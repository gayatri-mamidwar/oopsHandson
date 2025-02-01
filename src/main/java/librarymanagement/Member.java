package librarymanagement;

public class Member extends User{

    private int borrowedBooksCount;
    private final static int MAX_BORROW_LIMIT = 5;         //final -> used to declare constant, static -> to make global variable

    //default constructor
    public Member(){
        super();                //parent cls default constructor called. inside it new member id generation logic is there.
        borrowedBooksCount = 0;
//        MAX_BORROW_LIMIT = 0;      //no need bcz we are using it as constant
    }

    //Parameterized constructor
    public Member(String name, String contactInfo){
        super(name, contactInfo);                       //here, parent cls parameterized constructor gets called.it generates new user id
        borrowedBooksCount = 0;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Member Dashboard: " );
        System.out.println("Name: "+ getName());
        System.out.println("Number of Books Borrowed: " + borrowedBooksCount);
    }

    @Override
    public boolean canBorrowBooks() {
        //we need to check if current member can borrow more books?
        return borrowedBooksCount < MAX_BORROW_LIMIT;
    }

    @Override
    public void returnBook() {
        borrowedBooksCount--;
    }
}
