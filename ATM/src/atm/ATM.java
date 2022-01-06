package atm;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ATM {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        ArrayList<User> users = new ArrayList<User>();
        
        while(true){
            int userInp;
            menu.mainMenu();
            userInp = sc.nextInt();
            
            if(userInp == 1){
                User usr = new User();
                menu.createAccountMenu(usr, users);
                System.out.println("\n");
            }
            else if(userInp == 2){
                menu.loginScreen(users);
            }
            else if(userInp == 3){
                System.out.println("Thank you for running the program. Hope to see you soon.\n");
                break;
            }
            else{
                System.out.println("Please enter a valid input.");
            }
        }
        
    }
    
}
