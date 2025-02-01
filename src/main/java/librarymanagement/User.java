package librarymanagement;

//class having some methods without body hence declare class as abstract. Its child will implement abstract method body
public abstract class User {
    private String userId;
    private String name;
    private String contactInfo;
    private static int totalUsers;

    //abstract methods for abstract class
    public abstract void  displayDashboard();
    public abstract boolean canBorrowBooks();
    public abstract void returnBook();

    //default constructor
    public User() {
        this.userId = generateUniqueId();           //every time new user created we need new userId
    }

    //parameterized constructor
    public User(String name, String contactInfo) {
        this.userId = generateUniqueId();           //every time new user created we need new userId
        this.name = name;
        this.contactInfo = contactInfo;
    }

    //copy constructor
    public User(User other){
        this.userId = generateUniqueId();           //every time new user created we need new userId
        this.name = other.name;
        this.contactInfo = other.contactInfo;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }



    public static int getTotalUsers() {
        return totalUsers;
    }

    private final String generateUniqueId() {
        totalUsers++;     //instead of calling totalUsers++ in every constructor of User. write it here bcz this method is called every time new user gets created
        return "User-" + totalUsers;
    }
}
