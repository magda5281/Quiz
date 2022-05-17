import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;


public class Registration {
    public static void register() throws FileNotFoundException
    {
        //initialize scanner
        Scanner sc=new Scanner(System.in);
        String usernameInstructionMessage = "Username must be 5-20 letters or numbers and can include:\".\",\" _\",\"-\" ";
        String passwordInstructionMessage = "Password must be minimum 8 letters.\n" +
                "Password must include at least: 1 x uppercase, 1 x lowercase, a number and a special character";

        try {

            File obj = new File("Registration.txt");

            if (obj.createNewFile())
            {
                System.out.println("File is created");
            }

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        System.out.println("Enter Username: ");
        String username=sc.nextLine();


        while (!Validation.usernameValidation(username)){
            System.out.println(usernameInstructionMessage);
            System.out.println("Enter Username: ");
             username=sc.nextLine();
        }


        System.out.println("Enter Password: ");
        String password=sc.nextLine();

        while (!Validation.passwordValidation(password)){
            System.out.println(passwordInstructionMessage);
            System.out.println("Enter Password: ");
            password=sc.nextLine();
        }

        System.out.println("Confirm Password: ");
        String confPassword=sc.nextLine();
        System.out.println(confPassword);
        username=username.trim();
        password=password.trim();
        confPassword=confPassword.trim();

//take username and password and create a string
        String credentials= username+" "+password;

        //if all inputs are correct and passwords are matching check if user is already registered
        if(password.equals(confPassword))
        {


//create a file where you store credentials
            File f = new File("Registration.txt");
            //check if file already exists
            if (!f.exists()) {
                System.out.println("");
            }
            else {
                System.out.println("File already exists");
            }
            //reading content of the file if exists
            Scanner content = new Scanner(f);

            //when file has lines of data
            while (content.hasNextLine()) {
                //assign each line to var data
                String data = content.nextLine();
                //compare data with credentials string
                if(data.equals(credentials))
                {
                    System.out.println("Already Registered");
                    System.out.println("Please login");
                    content.close();
                    Login.login();

                }

            }


                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Registration.txt", true));
                    writer.write(username+" "+password+"\n");
                    writer.close();
                }
                catch (IOException e) {
                    System.out.println("exception occurred" + e);
                }

                System.out.println("Successfully Registered");
            //                    Login.login();
                // powitaj usera i otworz aplikacje

        }
        sc.close();
    }





}
