/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CourseRegistration;

/**
 *
 * @author Capita
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentBean implements Serializable {
    private static final int MAX_REGISTERED_COURSES = 6;

    private final String name; //Added studentId field
    private final List<CourseBean> registeredCourses;
    private final String studentId;
  

    public StudentBean(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.registeredCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Getters and Setters for studentId
    public String getStudentId(){
        return studentId;
    }

    public List<CourseBean> getRegisteredCourses() {
        return registeredCourses;
    }


    public boolean canRegisterForCourse(CourseBean course) {
        // Check if the student is not already registered for the course
        if (!registeredCourses.contains(course)) {
            // Check if the student has not exceeded the maximum number of registered courses
            if (registeredCourses.size() < MAX_REGISTERED_COURSES) {
                return true;
            } else {
                System.out.println(name + " has reached the maximum number of registered courses.");
            }
        } else {
            System.out.println(name + " is already registered for course: " + course.getTitle());
        }
        return false;
    }
    
    public void registerForCourse(CourseBean course) {
        if (canRegisterForCourse(course)) {
            registeredCourses.add(course);
            System.out.println(name + " registered for course: " + course.getTitle());
        } else {
            System.out.println(name + " cannot register for course: " + course.getTitle());
        }
    }
}
