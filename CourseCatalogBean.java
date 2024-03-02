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

public class CourseCatalogBean implements Serializable {
    private final List<CourseBean> courses;

    public CourseCatalogBean() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(CourseBean course) {
        if (!courses.contains(course)) {
            courses.add(course);
            System.out.println("Course " + course.getTitle() + " added to the catalog.");
        } else {
            System.out.println("Course with ID " + course.getId() + " already exists. Cannot add duplicate.");
        }
    }

    public CourseBean getCourse(String courseId) {
        List<CourseBean> matchingCourses = courses.stream()
                .filter(course -> course.getId().equals(courseId))
                .toList();
        if (matchingCourses.isEmpty()){
            return null; // or throw an exception if desired
        } else if (matchingCourses.size()>1){
            System.out.println("Error: Multiple courses found with Id " + courseId + ".");
        }
        return matchingCourses.get(0);
    }

    public List<CourseBean> getAllCourses() {
        return new ArrayList<>(courses); //Return a copy to make the list immutable
    }
}

