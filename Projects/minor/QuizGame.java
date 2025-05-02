import java.util.Scanner;

class Question {
    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question, String[] options, int answer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = answer;
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println(question);
        for (int i=0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your Answer : ");
        int answer = sc.nextInt();
        return answer == correctAnswer;
    }
}

public class QuizGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question[] questions = {
            new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, 1),
            new Question("Which planet is known as the Red Planet?", new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 2),
            new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 2)
        };

        int score = 0;

        for (Question q : questions) {
            if (q.askQuestion(sc)) {
                System.out.println("Correct!");
                score++;
            }
            else {
                System.out.println("Wrong!");
                score--;
            }
        }

        System.out.println("Quiz is over! Your Score: " + score + "/" + questions.length);
        sc.close();
    }
}