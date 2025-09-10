// Task3 - Student.java
import java.util.Objects;

public class Task3_Student {
    private String id;      // student ID
    private String name;    // student name
    private double grade;   // student grade

    // constructor
    public Task3_Student(String id, String name, double grade) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.grade = grade;
    }

    // getters
    public String getId() { 
        return id; 
    }
    public String getName() { 
        return name; 
    }
    public double getGrade() { 
        return grade; 
    }

    // setters
    public void setName(String name) { 
        this.name = Objects.requireNonNull(name, "name"); 
    }
    public void setGrade(double grade) { 
        this.grade = grade; 
    }

    // display student info as string
    @Override
    public String toString() {
        return String.format("Student{id ='%s', name ='%s', grade = %.2f}", id, name, grade);
    }
}
