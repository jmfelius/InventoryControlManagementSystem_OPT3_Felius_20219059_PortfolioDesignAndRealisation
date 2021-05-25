import java.util.ArrayList;
import java.util.Scanner;

/**
 *      The singleton pattern is used. Only one user (the Adminitrator is allowed access.
 *      Username and password are declared in Constructor
 *
 *      The method "...isAuthenticated" (......Login.getInstance().isAuthenticated();) can then be
 *      used throughout the other classes and
 *      make objects exclusively accessible to the authenticated user.
 *
 */

public class Login {

    private static Login singleton;
    private String username;
    private String password;
    private String loggedInUser;

    private Login() {
        username = "admin";
        password = "admin";
        loggedInUser = null;
    }


    /**
     * This is a Singleton pattern: only 1 object is made of this class when authentication is requested.
     * As a result other object can be made exclusively available to authenticated person.
     * Pattern is tweaked code based on example of Karel van der Lelij, tutor at HHS, May 2021
     *
     * @return
     */
    public static Login getInstance() {

        if (singleton == null) {
            singleton = new Login();
        }

        return singleton;
    }

    private boolean userIsAuthenticated() {
        return loggedInUser != null;
    }

    /**
     * authentication is done based on username and password
     * of Administrator as declared in Constructor
     *
     * @return
     */
    public boolean isAuthenticated() {
        if (userIsAuthenticated()) {
            return true;
        }
        else
        {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 3; i++) {
                System.out.println("Enter your username:");
                String userName = scanner.nextLine();
                System.out.println("Enter your password:");
                String passWord = scanner.nextLine();


                if ((username.equals(userName)) && password.equals(passWord))
                {
                    System.out.printf("The administrator with username %s is authorized \n", this.username);
                    loggedInUser = username;
                    return true;
                }
                    System.out.println("Failed to login because the username and password does not match.");

            }
            return false;
        }
    }
    public void resetLoggedInUser()
    {
        singleton = null;
     }
}

