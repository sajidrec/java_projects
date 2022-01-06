package atm;

public class User {
    
    private String username, password;
    private int balance = 0;
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
    
    public void addMoney(int money){
        this.balance += money;
    }
    public void withDrawMoney(int money){
        this.balance -= money;
    }
    public int checkBalance(){
        return this.balance;
    }
}
