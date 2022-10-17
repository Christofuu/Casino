import java.util.Scanner;

public class LoginApp {

    //FIELD
  private static int usernumber = 0; // track PLYER number
 

  private static Player players[] = new Player[20];  //MAX player is 20
  private static Scanner userInput = new Scanner(System.in);
  private static String inputId, inputPassword, inputUsername;
  

  public static void main(String[] args) {
    for(int i = 0; i < 20; i++){
        players[i] = new Player(); //
    }

        boolean runState = true;
        
        do{
            System.out.println("Choose menu");
            System.out.println("1. Create account  \n2. Login  \n3. Delete Account \n4. Enter to Casino");
            
            int select = userInput.nextInt();
            
            switch(select){
                
                case 1:
                    if(usernumber == 20){
                        System.out.println("User ID is full");
                        break;
                    }
                    else 
                    creatAccount();
                    break;

                case 2:
                    loginAccount();
                    break;
                
                case 3:
                    deleteAccount();
                    break;

                case 4:
                    Casino.main(args);
                    break;

                default:
                System.out.println("Select a menu option by entering a value from 1 to 4.");
				break;
            }

        }while(runState);
    }

    public LoginApp() {
    }  


    private static void creatAccount() {

        System.out.println("Enter your ID");
        inputId = userInput.next();
        players[usernumber].setId(inputId);
        
        
        System.out.println("Enter Password");
        inputPassword = userInput.next();
        players[usernumber].setPassword(inputPassword);
        
        
        System.out.println("Enter User Name");
        inputUsername = userInput.next();
        players[usernumber].setUsername(inputUsername);
        

        usernumber++; //to track 20 user
        
    }

    private static void loginAccount() {

        System.out.println("Enter your ID");
        inputId = userInput.next();
        System.out.println("Enter Password");
        inputPassword = userInput.next();

        int loginSuccess = 0;
        for(int i = 0; i < players.length; i++){
            if (inputId.equals(players[i].getId()) && inputPassword.equals(players[i].getPassword()))
            {
                System.out.println("Successfully login to your account");
                System.out.println("Hi " + players[i].getUsername());
                players[i].setId(inputId);
                players[i].setPassword(inputPassword);
                loginSuccess = 1;
                break;
            }
        if(loginSuccess == 0){
            System.out.println("Wrong userID and Password");
            }
        }
        
    }
    private static void deleteAccount() {
        System.out.println("Enter your ID");
        inputId = userInput.next();
        System.out.println("Enter Password");
        inputPassword = userInput.next();
        int deleteSuccess = 0;

        for (int i = 0; i < players.length; i++) {
            if (inputId.equals(players[i].getId()) && inputPassword.equals(players[i].getPassword())) {
                
                System.out.println("Succesefully Deleted User Account");
                players[i].setId(null);
                players[i].setPassword(null);
                players[i].setUsername(null);
                usernumber--; //decrease user Number
                deleteSuccess = 1;
            }
            if (deleteSuccess == 0) {

                System.out.println("No other account");
                
            }
        }
    }
}
