
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) throws FileNotFoundException {
        WelcomePage.welcome();




        //data/questions - could I move these questions to separate file????How??
        String q1 = """
                What is 4+5?
                (a) 1
                (b) 8
                (c) 9
                (d) 0""";
        String q2 = """
                What is 20-5?
                (a) 6\s
                (b) 9
                (c) 15
                (d) 4""";
        String q3 = """
                What is 100*2?
                (a) 200\s
                (b) 2000
                (c) 20
                (d) 2""";

        // create an array of question objects using a template Question
        Question[] questions = {
                new Question(q1, "c"),
                new Question(q2, "c"),
                new Question(q3, "a"),

        };
        //login first
        Login.login();
        //initialize quiz, passing questions array as an argument
        takeQuiz(questions);
    }




    // logic of quiz; quiz will take questions object
    // when do I use public static void???
    public static void takeQuiz(Question[] questions) {
        // keep track of correct answers
        int score = 0;
        // keep record of an answer
        String answer;
        // initialize scanner to read users answer
        Scanner input = new Scanner(System.in);
        // loop through array of question objects and display prompt

        for (int i = 0; i < questions.length; i++) {
            do {
                System.out.println(questions[i].prompt);
                //collect an answer
                System.out.print("Choose an option (a,b,c or d): ");
                answer = input.nextLine();
            }
            while (Objects.equals(answer, ""));
            if (answer.equals(questions[i].answer)) {
                score++;
            }
        }

        System.out.println("You got " + score + " out of " + questions.length + " correct answers");
    }
}




