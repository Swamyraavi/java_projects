import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description
                + "\nCapacity: " + capacity + "\nSchedule: " + schedule + "\n";
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (registeredCourses.size() < 5) {
            registeredCourses.add(course);
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("You have reached the maximum limit of registered courses.");
        }
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        System.out.println("Course dropped successfully.");
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + "\nName: " + name + "\nRegistered Courses: " + registeredCourses + "\n";
    }
}

class CourseRegistrationSystem {
    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS101", "Introduction to Programming", "Introduction to programming concepts using Java.", 30, "Mon/Wed 9:00-10:30"));
        courses.add(new Course("MATH201", "Calculus I", "Introduction to differential and integral calculus.", 25, "Tue/Thu 13:00-14:30"));
        // Add more courses

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "John Doe"));
        students.add(new Student(2, "Jane Smith"));
        // Add more students

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View Student Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Courses:");
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentID = scanner.nextInt();
                    System.out.print("Enter course code to register: ");
                    String courseCode = scanner.next();
                    Course courseToRegister = findCourse(courses, courseCode);
                    if (courseToReg