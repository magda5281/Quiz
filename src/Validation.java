import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    //Add registration to your login script allowing the user to add their details.
//Think about the UX and add appropriate instructions to assist the user
//With the password set rules; uppercase, lowercase, numbers, symbols
//Check the password validity (hint: ASCII table)
//Hide the password from view when the user is typing



static boolean usernameValidation(String username){
    final String USERNAME_PATTERN = "^[a-zA-Z/d]([._-](?![._-])|[a-zA-Z/d]){3,18}[a-zA-Z/d]$";

       return validateStrings(username.trim(), USERNAME_PATTERN);

}


    static boolean passwordValidation(String password){
    // To check - why it doesn't allow me to start password with a number ???
    final String PASSWORD_PATTERN = "^[a-zA-Z0-9](?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*#?&])[A-Za-z0-9@$!%*#?&]{6,18}";
     return validateStrings(password.trim(), PASSWORD_PATTERN);
    }


    public static boolean validateStrings (String string, String PATTERN){
        // simple regex
        //private static final String USERNAME_PATTERN = "^[a-z0-9\\._-]{5,20}$";
        // strict regex
//        ^[a-zA-Z0-9]      # start with an alphanumeric character
//                    # follow by a dot, hyphen, or underscore, negative lookahead to
//                     (         # start of (group 1)
////       [._-](?![._-])      # ensures dot, hyphen, and underscore does not appear consecutively
//                |               # or
//          [a-zA-Z0-9]     # an alphanumeric character
//                  )       # end of (group 1)
//        {3,18}            # ensures the length of (group 1) between 3 and 18
//        [a-zA-Z0-9]$      # end with an alphanumeric character
//
//                          # {3,18} plus the first and last alphanumeric characters,
//                          # total length became {5,20}

        final Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();

    }

}
