import java.util.Scanner;

public class QuizApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] questions = {
            "Which language is primarily used for Android development?",
            "Which keyword is used to create a class in Java?",
            "Which method is the entry point of a Java program?",
            "Which of these is NOT a Java primitive data type?",
            "Which symbol is used to end a statement in Java?"
        };

        String[][] options = {
            {"A. Java", "B. Python", "C. HTML", "D. SQL"},
            {"A. function", "B. class", "C. object", "D. define"},
            {"A. start()", "B. run()", "C. main()", "D. execute()"},
            {"A. int", "B. boolean", "C. String", "D. double"},
            {"A. .", "B. :", "C. ;", "D. ,"}
        };

        char[] correctAnswers = {'A', 'B', 'C', 'C', 'C'};

        int score = 0;
        int correctAnswersCount = 0;
        int incorrectAnswersCount = 0;

        System.out.println("**************************************");
        System.out.println("        QUIZ APPLICATION");
        System.out.println("**************************************");
        System.out.println("You have 10 seconds for each question.");
        System.out.println("--------------------------------------");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\nQuestion " + (i + 1));
            System.out.println(questions[i]);

            for (String option : options[i]) {
                System.out.println(option);
            }

            System.out.println("--------------------------------------");

            System.out.print("Enter your answer (A/B/C/D): ");

            long startTime = System.currentTimeMillis();

            String answer = scanner.nextLine().trim().toUpperCase();

            long endTime = System.currentTimeMillis();

            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken > 10) {

                System.out.println("Time's up!");
                System.out.println(
                    "Correct answer: " + correctAnswers[i]
                );

                incorrectAnswersCount++;

            } else if (answer.equals(
                    String.valueOf(correctAnswers[i]))) {

                System.out.println("Correct Answer!");

                score++;
                correctAnswersCount++;

            } else {

                System.out.println("Incorrect Answer!");
                System.out.println(
                    "Correct answer: " + correctAnswers[i]
                );

                incorrectAnswersCount++;
            }
        }

        double percentage =
                ((double) score / questions.length) * 100;

        System.out.println("\n**************************************");
        System.out.println("             QUIZ RESULT");
        System.out.println("**************************************");

        System.out.println(
            "Total Questions   : " + questions.length
        );

        System.out.println(
            "Correct Answers   : " + correctAnswersCount
        );

        System.out.println(
            "Incorrect Answers : " + incorrectAnswersCount
        );

        System.out.println(
            "Final Score       : " + score + "/" + questions.length
        );

        System.out.printf(
            "Percentage        : %.2f%%\n",
            percentage
        );

        System.out.println("**************************************");

        scanner.close();
    }
}