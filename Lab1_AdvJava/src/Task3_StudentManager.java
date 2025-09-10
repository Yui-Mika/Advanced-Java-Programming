// Task3 - StudentManager.java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Task3_StudentManager {
    // list to store students
    private final List<Task3_Student> students = new ArrayList<>();

    // add a new student
    public void addStudent(Task3_Student s) {
        // could check duplicate ID here
        students.add(s);
    }

    // display all students
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students.");
            return;
        }
        System.out.println("=== Student List ===");
        for (Task3_Student s : students) {
            System.out.println(s);
        }
    }

    // find a student by ID
    public Optional<Task3_Student> findById(String id) {
        for (Task3_Student s : students) {
            if (s.getId().equalsIgnoreCase(id)) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    // remove a student by ID
    public boolean removeById(String id) {
        return students.removeIf(s -> s.getId().equalsIgnoreCase(id));
    }

    // sort students by grade (high to low), if same grade then by name
    public void sortByGradeDesc() {
        students.sort(Comparator.comparingDouble(Task3_Student::getGrade).reversed()
                .thenComparing(Task3_Student::getName));
    }

    public static void main(String[] args) {
        Task3_StudentManager mgr = new Task3_StudentManager();

        // 1) add some sample students
        mgr.addStudent(new Task3_Student("S001", "Phu", 8.5));
        mgr.addStudent(new Task3_Student("S003", "Thien", 9.2));
        mgr.addStudent(new Task3_Student("S002", "Nguyen", 7.8));
        mgr.addStudent(new Task3_Student("S004", "Dan", 9.2));

        // 2) display all students
        mgr.displayAll();

        // 3) search by ID
        System.out.println("\n=== Search by ID (S002) ===");
        Optional<Task3_Student> found = mgr.findById("S002");
        System.out.println(found.map(Object::toString).orElse("Not found."));

        // 4) remove by ID
        System.out.println("\n=== Remove by ID (S003) ===");
        boolean removed = mgr.removeById("S003");
        System.out.println("Removed: " + removed);
        mgr.displayAll();

        // 5) sort by grade in descending order
        System.out.println("\n=== Sort by grade DESC ===");
        mgr.sortByGradeDesc();
        mgr.displayAll();
    }
}
