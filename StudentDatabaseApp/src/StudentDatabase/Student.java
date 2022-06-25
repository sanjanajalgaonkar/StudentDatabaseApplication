package StudentDatabase;

import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses = null;
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;
    private static int id = 1000; //static variable
    //not specific to on object but all objects //it belongs to the class not instance of the object

    //Constructor prompts users to enter name and year
    public Student() {
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter Student First Name: ");
        this.firstName = in.nextLine();

        System.out.println("Enter Student Last Name: ");
        this.lastName = in.nextLine();

        System.out.println("1 - Freshmen\n2- Sophmore\n3- Junior\n4- Senior\nEnter Student Class Level: ");
        this.gradeYear = in.nextInt();

        setStudentID();

    }

    //Generate ID
    private void setStudentID() {
        //Grade level + ID
        id++;
        this.studentID = gradeYear + "" + id;
    }

    //Enroll in courses
    public void enroll() {
        //get inside loop, user hits 0 to done enrolling
        do {
            System.out.print("Enter course to enroll (Q to quit)");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            }
            else {
                break;
            }
        }
        while (1 != 0);
    }

    //View Balance
    public void viewBalance() {
        System.out.println("Your balance is : $" + tuitionBalance);
    }

    //Pay Tuition
    public void payTuition(){
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("Thank you for your payment of $" + payment);
        viewBalance();
    }

    //Show Status
    public String toString(){
        return "Name: " + firstName + " " + lastName +
                "\nGrade Level: " + gradeYear +
                "\nStudent ID: " + studentID +
                "\nBalance: $" + tuitionBalance;
    }


}
