import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOptionIndex;

    public QuizQuestion(String question, List<String> options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}
class QuizGame {
    private List<QuizQuestion> questions;
    private int currentQuestionIndex;
    private int score;

    public QuizGame() {
        questions = new ArrayList<>();
        initializeQuestions();
    }

    private void initializeQuestions() {
        List<String> options1 = new ArrayList<>();
        options1.add("A. Option 1");
        options1.add("B. Option 2");
        options1.add("C. Option 3");
        options1.add("D. Option 4");
        questions.add(new QuizQuestion("Question 1: What is 1+1?", options1, 1));

        List<String> options2 = new ArrayList<>();
        options2.add("A. Option 1");
        options2.add("B. Option 2");
        options2.add("C. Option 3");
        options2.add("D. Option 4");
        questions.add(new QuizQuestion("Question 2: What is 2+2?", options2, 3));
    }

    public void startQuiz() {
        currentQuestionIndex = 0;
        score = 0;

        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            presentQuestion(question);
            System.out.print("Enter your choice (A/B/C/D): ");
            String userChoice = scanner.nextLine().toUpperCase();

            if (userChoice.equals(question.getOptions().get(question.getCorrectOptionIndex()).substring(0, 1))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("\nQuiz ended! Your score: " + score + "/" + questions.size());
    }

    private void presentQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        for (String option : question.getOptions()) {
            System.out.println(option);
        }
    }

    public static void main(String[] args) {
        QuizGame quizGame = new QuizGame();
        quizGame.startQuiz();
    }
}