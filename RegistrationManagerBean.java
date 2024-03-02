/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CourseRegistration;

import java.io.Serializable;

/**
 *
 * @author Capita
 */
public class RegistrationManagerBean implements Serializable {
    public boolean registerStudentForCourse(StudentBean student, CourseBean course) {
        if (validateRegistration(student, course)) {
            student.registerForCourse(course);
            course.decrementAvailability();
            System.out.println("Registration successful for " + student.getName() + " in course " + course.getTitle());
            return true;
        } else {
            System.out.println("Registration failed for " + student.getName() + " in course " + course.getTitle());
            return false;
        }
    }

    private boolean validateRegistration(StudentBean student, CourseBean course) {
        // Check if the course is available
        if (course.getAvailability() > 0) {
            // Check if the student is eligible (e.g., not exceeding maximum registered courses)
            if (student.canRegisterForCourse(course)) {
                return true;
            } else {
                System.out.println("Student " + student.getName() + " has reached the maximum number of registered courses.");
            }
        } else {
            System.out.println("Course " + course.getTitle() + " is already full. Registration failed.");
        }
        return false;
    }
}
