package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner mSc = new Scanner(System.in);
    
    
    void mainMenu(){
        System.out.println("Enter you're choice");
        System.out.println("1. Create account");
        System.out.println("2. Login account");
        System.out.println("3. Quit the program.");
    }
    
    void createAccountMenu(User user, ArrayList<User> u){
        String username, password;
        System.out.println("Enter you're username -> ");
        username = mSc.nextLine();
        
        while(allReadyExits(u, username)){
            System.out.println("Usera already exits please choose another username.");
            username = mSc.nextLine();
        }
        
        System.out.println("Enter you're password -> ");
        password = mSc.nextLine();
        user.setUsername(username);
        user.setPassword(password);
        u.add(user);
        System.out.println("Account created successfully.");
    }
    
    private boolean allReadyExits(ArrayList<User> u, String name){
        int i;
        for(i=0;i<u.size();i++){
            if(u.get(i).getUsername().toLowerCase().equals(name.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    
    void loginScreen(ArrayList<User> users){
        String username, password;
        
        System.out.println("Enter username -> ");
        username = mSc.nextLine();
        System.out.println("Enter password -> ");
        password = mSc.nextLine();
        
        int index = loginChecker(username, password, users);
        if(index < 0){
            System.out.println("Incorrect username or password.\n");
        }
        else{
            loggedin(users.get(index));
        }
    }
    
    private int loginChecker( String username, String password, ArrayList<User> users){
        int index = -1;
        for(User usr : users){
            index++;
            if(usr.getUsername().toLowerCase().equals(username.toLowerCase()) && usr.getPassword().equals(password)){
                return index;
            }
        }
        index = -99;
        return index;
    }
    
//    section after user successfully logged in.
    void loggedin(User user){
        System.out.println("\nHello "+user.getUsername());
        while(true){
            System.out.println("Please select you're choice -> ");
            System.out.println("1. Check Balance.");
            System.out.println("2. Deposit money.");
            System.out.println("3. Withdraw money.");
            System.out.println("4. Logout.");
            System.out.println("\n");
            
            int usrInp;
            usrInp = mSc.nextInt();
            
            if(usrInp == 1){
                System.out.println("");
                System.out.println("Balance : " + user.checkBalance());
                System.out.println("");
            }
            else if(usrInp == 2){
                int money;
                System.out.println("Enter amount -> ");
                money = mSc.nextInt();
                user.addMoney(money);
                System.out.println("Money added successfully. Balance : " + user.checkBalance());
            }
            else if(usrInp == 3){
                int money;
                System.out.println("Enter amount -> ");
                money = mSc.nextInt();
                if( user.checkBalance() >= money ){
                    user.withDrawMoney(money);
                    System.out.println("Withdraw Successful. You're new balance is : "+user.checkBalance());
                }
                else{
                    System.out.println("Not enough money.");
                }
            }
            else if(usrInp == 4){
                System.out.println("Loggedout successfully.");
                break;
            }
            else{
                System.out.println("Invalid input.");
            }
        }
    }
}
