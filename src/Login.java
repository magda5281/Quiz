import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

    public class Login {

        static void login() throws FileNotFoundException {
            // ADMIN // not case-sensitive
            // you can try to submit 3 times and after that you are logged-out
            // username can not be blank

            //variables to store input
            String inputUsername;
            String passwordInput;
            // attempts to log in with wrong password
            int attempts = 0;
            boolean valid = false;
            Scanner input = new Scanner(System.in);

            // check  if attempts are no more than 3 and valid
            System.out.println("before while loop " + valid);
            while (attempts < 3 && !valid) {
                System.out.println("after while loop " + valid);
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
                // check if inputs match databsase
                //create string out of collected data to check against what is in the database
                String credentials = inputUsername + " " + passwordInput + "\n";
                //what file am I reading ; do i have access to database
                File f = new File("Registration.txt");

                if (f.exists()) {
                    //read file
                    Scanner content = new Scanner(f);
                    //compare our inputs against the database
                    while (content.hasNextLine() && !valid) {
                        //assign each line to var data
                        String data = content.nextLine();
                        //compare data with credentials string
                        if (data.trim().equals(credentials)) {

                            System.out.println("You are successfully logged in");
                            System.out.println("Hello ");
                            System.out.println(attempts);
                            valid = true;
                        } else {
                            System.out.println("Wrong username or password.");

                        }
                        if (attempts >= 3) {
                            System.out.println("Your exceeded number of tries. Your account is locked. Come back in 3 hours");
                            System.exit(1);

                        }

                    }
                    content.close();
                }

            }
            input.close();
        }
    }



