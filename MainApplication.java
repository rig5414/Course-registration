/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CourseRegistration;

import java.util.Scanner;

/**
 *
 * @author Capita
 */
public class MainApplication {

    public static void main(String[] args) {
        CourseCatalogBean courseCatalog = new CourseCatalogBean();

        try (Scanner scanner = new Scanner(System.in)) {
            // Adding sample courses to the catalog
            CourseBean course1 = new CourseBean("SCO308", "Design and Analysis of Programming", "Mr. Kimeu", 3);
            CourseBean course2 = new CourseBean("SCO304", "Advanced Database Systems", "Mr. Mathenge", 3);
            CourseBean course3 = new CourseBean("SCO302", "Software Project Management", "Mr. Omuya", 3);
            CourseBean course4 = new CourseBean("SCO310", "Component Programming", "Mr. George", 3);
            CourseBean course5 = new CourseBean("SCO306", "Programming Languages", "Mrs. Mercy", 3);
            CourseBean course6 = new CourseBean("SCO300", "Computer Networks", "Mrs. Veronicah", 3);

            // Setting prerequisites for courses
            course3.setPrerequisite(course1);

            // Adding courses to the catalog
            courseCatalog.addCourse(course1);
            courseCatalog.addCourse(course2);
            courseCatalog.addCourse(course3);
            courseCatalog.addCourse(course4);
            courseCatalog.addCourse(course5);
            courseCatalog.addCourse(course6);

            // Displaying available courses with details
            displayAllCourses(courseCatalog);

            // Getting student information from the user
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String studentId = scanner.nextLine();
            StudentBean student = new StudentBean(studentName, studentId);

            // Registering for courses
            boolean continueRegistration = true;
            while (continueRegistration) {
                // Displaying available courses for registration
                displayAllCoursesForRegistration(courseCatalog);

                // Getting course registration information from the user
                System.out.print("Enter course number to register for (or 0 to finish, -1 to register all): ");
                int courseNumber = scanner.nextInt();

                if (courseNumber == 0) {
                    continueRegistration = false;
                } else if (courseNumber == -1) {
                    // Register for all courses
                    registerForAllCourses(student, courseCatalog);
                    continueRegistration = false; // Exit registration loop
                } else if (courseNumber >= 1 && courseNumber <= courseCatalog.getAllCourses().size()) {
                    CourseBean selectedCourse = courseCatalog.getAllCourses().get(courseNumber - 1);

                    // Attempting to register the student for the selected course
                    RegistrationManagerBean registrationManager = new RegistrationManagerBean();
                    registrationManager.registerStudentForCourse(student, selectedCourse);

                    // Displaying registered courses for the student
                    displayRegisteredCourses(student);

                    // Displaying updated availability for courses
                    displayCourseAvailability(courseCatalog);
                } else {
                    System.out.println("Invalid course number. Please enter a valid course number.");
                }

                // Consume the newline character
                scanner.nextLine();
            }
        }
    }

    private static void registerForAllCourses(StudentBean student, CourseCatalogBean courseCatalog) {
        for (CourseBean course : courseCatalog.getAllCourses()) {
            RegistrationManagerBean registrationManager = new RegistrationManagerBean();
            registrationManager.registerStudentForCourse(student, course);
        }

        // Displaying registered courses for the student
        displayRegisteredCourses(student);

        // Displaying updated availability for courses
        displayCourseAvailability(courseCatalog);
    }

    private static void displayAllCoursesForRegistration(CourseCatalogBean courseCatalog) {
        System.out.println("Available courses for registration:");
        int index = 1;
        for (CourseBean course : courseCatalog.getAllCourses()) {
            System.out.println(index + ". " + course.getTitle() + " (ID: " + course.getId() + ")");
            index++;
        }
        System.out.println("0. Finish Registration");
        System.out.println("-1. Register for all courses");
        System.out.println("----------------------");
    }

    private static void displayCourseAvailability(CourseCatalogBean courseCatalog) {
        System.out.println("Updated availability for all courses:");
        for (CourseBean course : courseCatalog.getAllCourses()) {
            System.out.println(course.getTitle() + ": " + course.getAvailability());
        }
        System.out.println("----------------------");
    }

    private static void displayRegisteredCourses(StudentBean student) {
        System.out.println("Registered courses for " + student.getName() + ":");
        for (CourseBean course : student.getRegisteredCourses()) {
            System.out.println(course.getTitle());
        }
        System.out.println("----------------------");
    }

    private static void displayAllCourses(CourseCatalogBean courseCatalog) {
        System.out.println("All courses in the catalog:");
        for (CourseBean course : courseCatalog.getAllCourses()) {
            System.out.println(course.getTitle() + " (Availability: " + course.getAvailability() + ")");
            if (course.hasPrerequisite()) {
                System.out.println("  Prerequisite: " + course.getPrerequisite().getTitle());
            }
        }
        System.out.println("----------------------");
    }
}


