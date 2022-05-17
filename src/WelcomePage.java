import java.io.FileNotFoundException;
import java.util.Scanner;

public class WelcomePage {


public static  void welcome() throws FileNotFoundException {

    System.out.println("Welcome to the QUIZZZZZ!!!");
    System.out.println();

    int choice;
    Scanner sc=new Scanner(System.in);
    System.out.println("1. Registration. ");
    System.out.println("2. Login. ");

    System.out.println("Enter your Choice");
    choice=sc.nextInt();
//    sc.nextLine();

    if(choice==1)
    {
Registration.register();
    }
    else if(choice==2)
    {
      Login.login();
    }
    else
    {
        System.out.println("Choose Proper Option");
    }
    sc.close();
}

}
