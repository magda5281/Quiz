import java.util.Scanner;

    public class Login {

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
                System.out.println("Enter username: ");
                inputUsername = input.nextLine();
                // the username can not be blank
                while (inputUsername.equals("")) {
                    System.out.println("Username can not be blank. Try again.");
                    System.out.println("Enter username: ");
                    inputUsername = input.nextLine();
                }
                //when we have username we mark an attempt
                attempts += 1;
                // collect password input
                System.out.println("Enter password: ");
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
    }


