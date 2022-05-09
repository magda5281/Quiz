
import java.util.Objects;
import java.util.Scanner;

public class Quiz {

    public static void main(String[] args) {
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
        login();
        //initialize quiz, passing questions array as an argument
        takeQuiz(questions);
    }


    // login method; how do I take it out of that file????
    public static void login() {
        // ADMIN // not case-sensitive
        // you can try to submit 3 times and after that you are logged-out
        // username can not be blank

        String username = "admin";
        String password = "Password123!";
        //variables to store input
        String inputUsername;
        String passwordInput;
        // attempts to log in with wrong password
        int attempts = 0;
        boolean valid = false;
        Scanner input = new Scanner(System.in);

        // check  if attempts are no more than 3
        while (attempts < 3 && !valid) {
            //collect username data
            System.out.println("Enter username");
            inputUsername = input.nextLine();
            // the username can not be blank
            while (inputUsername.equals("")) {
                System.out.println("Username can not be blank. Try again.");
                System.out.println("Enter username");
                inputUsername = input.nextLine();
            }
            //when we have username we mark an attempt
            attempts += 1;
            // collect password input
            System.out.println("Enter password");
            passwordInput = input.nextLine();
            // check if inputs are valid, and we have a success or not
            if (username.equalsIgnoreCase(inputUsername) && password.equals(passwordInput)) {
                valid = true;
                System.out.println("You are successfully logged in");
            } else {
                System.out.println("Wrong username or password.");
            }
        }
        if (!valid) {
            System.out.println("Your exceeded number of tries. Your account is locked. Come back in 3 hours");
        }
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




