package DesignPatterns.BuilderPattern;

public class Student {
    String name;
    int age;
    double psp;
    String universityName;
    String batch;
    long id;
    int gradYear;
    String phoneNumber;

    /* Using basic thing, we need to create lots of constructor approx. 2^N constructors-
    Student(String name, int age, double psp, String universityName, String batch, long id, int gradYear, String phoneNumber) {
    }

    Student(String name, int age){
    }

    Student(String name, String universityName){
    }
     */

    /* Make student class constructor as private. We r keeping Builder cls inside Student so builder can access it. if we
       keep Builder cls outside then Builder also cant access it bcz of private scope
     */
    private Student(Builder builder){
        this.gradYear = builder.gradYear;
        this.age = builder.age;
        this.id = builder.id;
        this.batch = builder.batch;
        this.psp = builder.psp;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.universityName = builder.universityName;
    }

    //getBuilder() should return new Builder object
    public static Builder getBuilder(){
        return new Builder();
    }

    //Builder for Student should exist inside the Student not anywhere.Bcz only Builder should hv access to create student obj
    public static class Builder {
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
        public Student build(){
            //gradYear > 2020 & phoneNumber should be valid
            if(gradYear <= 2020){
                throw new RuntimeException("gradYear must be greater than 2020");
            }
            if(!isValidPhoneNumber(phoneNumber)){
                throw new RuntimeException("Phone number must be valid");
            }

            return new Student(this);
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

}
