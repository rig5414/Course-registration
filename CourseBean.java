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

public class CourseBean implements Serializable {
    private final String id;
    private final String title;
    private final String instructor; // Added instructor field
    private int availability;
    private CourseBean prerequisite; // added field to prevent output error on the MainApplication

    public CourseBean(String id, String title, String instructor, int availability) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.availability = availability;
    }

    public String getId() {
        return id;
    }
    // Getters and Setters for title, instructor, and availability
    
    public String getTitle(){
        return title;
    }
    public String getInstructor(){
        return instructor;
    }
    public int getAvailability(){
        return availability;
    }

    public void decrementAvailability() {
        if (availability > 0) {
            availability--;
            System.out.println("Availability for " + title + " decreased to " + availability);
        } else {
            System.out.println("Error: Course availability is already at 0.");
        }
    }

    public CourseBean getPrerequisite(){
        return prerequisite;
    }
    public void setPrerequisite(CourseBean prerequisite){
        this.prerequisite = prerequisite;
    }
    public boolean hasPrerequisite(){
        return prerequisite != null;
    }
}

