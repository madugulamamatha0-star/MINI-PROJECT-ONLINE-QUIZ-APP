import java.util.*;

class Question {
    private String questionText;
    private String[] options;
    private int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void display() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(int userChoice) {
        return userChoice == correctOption;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        loadQuestions();
    }

    private void loadQuestions() {
        questions.add(new Question(
                "Which language is used for Android development?",
                new String[]{"Python", "Java", "C++", "Swift"},
                2));

        questions.add(new Question(
                "Who invented Java programming?",
                new String[]{"Dennis Ritchie", "James Gosling", "Guido van Rossum", "Bjarne Stroustrup"},
                2));

        questions.add(new Question(
                "Which company owns Java today?",
                new String[]{"Google", "Microsoft", "Oracle", "IBM"},
                3));

        questions.add(new Question(
                "What does JVM stand for?",
                new String[]{"Java Virtual Machine", "Java Very Much", "Just Virtual Memory", "None"},
                1));

        questions.add(new Question(
                "Which keyword is used to inherit a class?",
                new String[]{"extends", "implements", "inherit", "super"},
                1));
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n======= WELCOME TO ONLINE QUIZ APP =======");

        for (Question q : questions) {
            q.display();
            System.out.print("Enter your answer (1-4): ");
            int ans = sc.nextInt();

            if (q.checkAnswer(ans)) {
                System.out.println("Correct! ✔");
                score++;
            } else {
                System.out.println("Wrong ✖");
            }
        }

        System.out.println("\n======= QUIZ FINISHED =======");
        System.out.println("Your Score: " + score + " / " + questions.size());

        if (score == questions.size()) {
            System.out.println("🔥 Excellent! Perfect score!");
        } else if (score >= questions.size() / 2) {
            System.out.println("👍 Good Job!");
        } else {
            System.out.println("🙂 Keep practicing!");
        }
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.start();
    }
}
