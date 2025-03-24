package DesignPatterns.BuilderPattern;

public class Builder {
    String name;
    int age;
    double psp;
    String universityName;
    String batch;
    long id;
    int gradYear;
    String phoneNumber;

    public String getName() {
        return name;
    }

    //Every setter method should return same builder i.e this
    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public double getPsp() {
        return psp;
    }

    public Builder setPsp(double psp) {
        this.psp = psp;
        return this;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Builder setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }

    public String getBatch() {
        return batch;
    }

    public Builder setBatch(String batch) {
        this.batch = batch;
        return this;
    }

    public long getId() {
        return id;
    }

    public Builder setId(long id) {
        this.id = id;
        return this;
    }

    public int getGradYear() {
        return gradYear;
    }

    public Builder setGradYear(int gradYear) {
        this.gradYear = gradYear;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Builder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    //build() doing validation checks & creating Student obj
    public void build(){
        //gradYear > 2020 & phoneNumber should be valid
        if(gradYear <= 2020){
            throw new RuntimeException("gradYear must be greater than 2020");
        }
        if(!isValidPhoneNumber(phoneNumber)){
            throw new RuntimeException("Phone number must be valid");
        }

//        return new Student(this);
    }


    private boolean isValidPhoneNumber(String phoneNumber) {

        // Check if length is exactly 10
        if (phoneNumber.length() != 10) return false;

        // Check if all characters are digits
        for (char ch : phoneNumber.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        // Check if it starts with 6, 7, 8, or 9
        return phoneNumber.charAt(0) >= '6' && phoneNumber.charAt(0) <= '9';
    }
}
