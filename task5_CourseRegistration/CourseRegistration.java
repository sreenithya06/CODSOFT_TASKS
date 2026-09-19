import java.util.Scanner;

public class CourseRegistration {

    static Scanner scanner = new Scanner(System.in);

    static String[] courseCodes = {
        "CS101",
        "CS102",
        "CS103",
        "CS104"
    };

    static String[] courseTitles = {
        "Java Programming",
        "Database Management",
        "Web Development",
        "Data Structures"
    };

    static String[] descriptions = {
        "Learn Java programming and object-oriented concepts.",
        "Learn database concepts and SQL.",
        "Learn HTML, CSS, JavaScript and web development.",
        "Learn arrays, linked lists, stacks and queues."
    };

    static String[] schedules = {
        "Monday 10:00 AM",
        "Tuesday 11:00 AM",
        "Wednesday 10:00 AM",
        "Thursday 11:00 AM"
    };

    static int[] capacities = {
        3, 3, 3, 3
    };

    static int[] registeredStudents = {
        0, 0, 0, 0
    };

    static String studentId;
    static String studentName;

    static boolean[] registeredCourses = new boolean[4];

    public static void main(String[] args) {

        System.out.println("**************************************");
        System.out.println("     STUDENT COURSE REGISTRATION");
        System.out.println("**************************************");

        System.out.print("Enter Student ID: ");
        studentId = scanner.nextLine();

        System.out.print("Enter Student Name: ");
        studentName = scanner.nextLine();

        int choice;

        do {

            System.out.println("\n**************************************");
            System.out.println("              MENU");
            System.out.println("**************************************");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. View My Registered Courses");
            System.out.println("5. Exit");
            System.out.println("**************************************");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:
                    registerCourse();
                    break;

                case 3:
                    dropCourse();
                    break;

                case 4:
                    displayRegisteredCourses();
                    break;

                case 5:
                    System.out.println(
                        "\nThank you for using the system!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please select 1-5."
                    );
            }

        } while (choice != 5);

        scanner.close();
    }

    static void displayCourses() {

        System.out.println("\n**************************************");
        System.out.println("          AVAILABLE COURSES");
        System.out.println("**************************************");

        for (int i = 0; i < courseCodes.length; i++) {

            int availableSlots =
                    capacities[i] - registeredStudents[i];

            System.out.println("\nCourse Code : " + courseCodes[i]);
            System.out.println("Course Title: " + courseTitles[i]);
            System.out.println("Description : " + descriptions[i]);
            System.out.println("Schedule    : " + schedules[i]);
            System.out.println("Capacity    : " + capacities[i]);
            System.out.println("Available   : " + availableSlots);

            System.out.println("--------------------------------------");
        }
    }

    static void registerCourse() {

        System.out.print(
            "\nEnter course code to register: "
        );

        String courseCode = scanner.nextLine().toUpperCase();

        int index = findCourse(courseCode);

        if (index == -1) {

            System.out.println(
                "Course not found! Please enter a valid course code."
            );
            return;
        }

        if (registeredCourses[index]) {

            System.out.println(
                "You are already registered for this course!"
            );
            return;
        }

        if (registeredStudents[index] >= capacities[index]) {

            System.out.println(
                "Sorry! This course is full."
            );
            return;
        }

        registeredCourses[index] = true;
        registeredStudents[index]++;

        System.out.println(
            "\nCourse registered successfully!"
        );

        System.out.println(
            "Course Code : " + courseCodes[index]
        );

        System.out.println(
            "Course      : " + courseTitles[index]
        );

        System.out.println(
            "Student     : " + studentName
        );
    }

    static void dropCourse() {

        System.out.print(
            "\nEnter course code to drop: "
        );

        String courseCode = scanner.nextLine().toUpperCase();

        int index = findCourse(courseCode);

        if (index == -1) {

            System.out.println(
                "Course not found! Please enter a valid course code."
            );
            return;
        }

        if (!registeredCourses[index]) {

            System.out.println(
                "You are not registered for this course!"
            );
            return;
        }

        registeredCourses[index] = false;
        registeredStudents[index]--;

        System.out.println(
            "\nCourse dropped successfully!"
        );

        System.out.println(
            "Course Code : " + courseCodes[index]
        );

        System.out.println(
            "Course      : " + courseTitles[index]
        );
    }

    static void displayRegisteredCourses() {

        System.out.println("\n**************************************");
        System.out.println("        MY REGISTERED COURSES");
        System.out.println("**************************************");

        boolean found = false;

        for (int i = 0; i < courseCodes.length; i++) {

            if (registeredCourses[i]) {

                System.out.println(
                    "\nCourse Code : " + courseCodes[i]
                );

                System.out.println(
                    "Course Title: " + courseTitles[i]
                );

                System.out.println(
                    "Schedule    : " + schedules[i]
                );

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                "No courses registered."
            );
        }
    }

    static int findCourse(String courseCode) {

        for (int i = 0; i < courseCodes.length; i++) {

            if (courseCodes[i].equals(courseCode)) {
                return i;
            }
        }

        return -1;
    }
}