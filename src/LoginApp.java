
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.annotation.processing.FilerException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
public class LoginApp {

    //FIELD
private static Scanner userInput = new Scanner(System.in);
private static String inputId, inputPassword;
private static int inputChips;
private static int inputMoney = 1000;
public static List<String> userDataList = new ArrayList<String>();
// private static Player playerData = new Player(Casino.getPlayer().getMoney(), Casino.getPlayer().getChips(), Casino.getPlayer().getPassword(), Casino.getPlayer().getUsername());
private static File txtFile = new File("userData.txt");

// private static String userData;

  /**
   * The main function of the program.1
   * 
   * @param args The command line arguments.
   */
  public static void main(String[] args) {

        boolean runState = true;
        
        do{
            System.out.println("Choose menu");
            System.out.println("1. Create account  \n2. Login  \n3. Delete Account \n4. Return To Casino");
            
            int select = userInput.nextInt();
            
            switch(select){
                
                case 1:
                    creatAccount();
                    break;

                case 2:
                    loginAccount();
                    break;
                
                // case 3:
                //     deleteAccount();
                //     break;

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


    /**
     * Creates a new account for the player.
     */
    public static void creatAccount() {
        
		boolean validId = false;
		do {
            System.out.println("Enter your ID");
            inputId = userInput.next();
            
            if (inputId != null) {
            	Casino.getPlayer().setId(inputId);
            	validId = true;
            } else continue;
            
            System.out.println("Enter Password");
            inputPassword = userInput.next();
            Casino.getPlayer().setPassword(inputPassword);
            
		} while (validId == false);
       
        /**
         * Writes the user's information to the userData.txt.
         * @param inputId The user's ID.
         * @param inputPassword The user's password.
         */
        try {
                FileWriter myWriter = new FileWriter("userData.txt", true);
                PrintWriter myPrintWriter = new PrintWriter(myWriter);
                
                myPrintWriter.println(inputId + " " + inputPassword + " "  + inputChips + " "  + inputMoney);

                System.out.println("-----------------------------");
                System.out.println("You've successfully created account!");
                System.out.println("-----------------------------");

                myPrintWriter.close();
                myWriter.close();
                setAccount(Casino.getPlayer(), inputId, inputPassword, inputChips, inputMoney);

        } catch(IOException e) {
                System.out.println("An error occurred");
                e.printStackTrace();
            }
        
    }
    
    private static void setAccount(Player player, String inputId, String inputPassword, int inputChips, int inputMoney)
    {
        player.setUsername(inputId);
        player.setPassword(inputPassword);
        player.setChips(inputChips);
        player.setMoney(inputMoney);
        // TODO maybe have to add setChips and setMoney, test more
    }
    
    public static void updateAccount(Player player, String userId, String userPassword, int userChip, int userMoney) 
    {
        player.setId(userId);;
        player.setPassword(userPassword);
        player.setChips(userChip);
        player.setMoney(userMoney);

        boolean updateAccount  = false;

        do {
            
            try {
                String line = null;
                FileReader fileReader = new FileReader(txtFile);
                List<String> userDataList = new ArrayList<String>();
                FileWriter myWriter = new FileWriter("userData.txt", true);
                PrintWriter myPrintWriter = new PrintWriter(myWriter);
                BufferedReader bReader = new BufferedReader(fileReader);

                //Create ArrayList of user Data [userID, userPassword, userChip, userCash]
                while ((line = bReader.readLine()) != null)
                {   
                    userDataList.add(line);
                }    
                
                for (String userData : userDataList) {
                    
                    if  ((userData.contains(userId)))
                    { 
                        myPrintWriter.println(userId + " " + userPassword + " "  + userChip + " "  + userMoney);
                        System.out.println("---------------------------------");
                        System.out.println("Successfully Updated Account");
                        System.out.println("---------------------------------");
                        myPrintWriter.close();
                        bReader.close();
                        updateAccount = true;
        
                    } else{
                        System.out.println("---------------------------------");
                        System.out.println("Please Enter Valid ID and Password");
                        System.out.println("---------------------------------");
                        return;
                    }
                }
            
                
                    
          

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        

        
        }while(updateAccount != true);
    
    }
    /**
     *
     *
     * Logs in the account.
     * 
     * @return Whether the login was successful.
     */
    private static void loginAccount() {

        /**
         * Checks if the input ID and password are valid.
         * Checks for a matching user ID and password in the text file, login if they match
         * @param inputId The ID of the player.
         * @param inputPassword The password of the player.
         * @return Whether the ID and password are valid.
         */
        
        // searching algorithim for inputId in userData.txt
        // if not found return invalid id
        // if found check if line below contains correct password
        // if both true login account
        boolean loginSuccess  = false;

        do {
            
            try {
                String line = null;
                FileReader fileReader = new FileReader(txtFile);
                BufferedReader bReader = new BufferedReader(fileReader);
                
                //Create ArrayList of user Data [userID, userPassword, userChip, userCash]
                while ((line = bReader.readLine()) != null)
                {   
                    userDataList.add(line);
                    System.out.println(userDataList);
                }
                
                //userInput
                System.out.println("Enter your ID");
                inputId = userInput.next();
                System.out.println("Enter Password");
                inputPassword = userInput.next();
                
                

                for (String userData : userDataList) {
                    
                    if  ((userData.contains(inputId)) && (userData.contains(inputPassword)))
                        { 
                            //Change userDataList to String Array
                            String[] userDataString = userDataList.toArray(new String[3]);
                            String splitUserData = userDataString[0];

                            //Change userData String Array to String
                            userDataString = splitUserData.split(" ");
                            
                            //Set Player data from userData.txt
                            final String userId = userDataString[0];
                            final String userPassword = userDataString[1];
                            final int userChip = Integer.valueOf(userDataString[2]);
                            final int userCash = Integer.valueOf(userDataString[3]);
    
                            System.out.println("---------------------------------");
                            System.out.println("Login Success");
                            System.out.println("---------------------------------");
                            setAccount(Casino.getPlayer(), userId, userPassword, userChip, userCash);
                            bReader.close();
                            loginSuccess = true;
    
                        } else {    
                            System.out.println("---------------------------------");
                            System.out.println("Please Enter Valid userID and Password");
                            System.out.println("---------------------------------");

                            return;
                        }
                }
               
                
                    
            } catch (FileNotFoundException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } while (loginSuccess != true);
    }

    public static boolean checkId() {
        boolean accountReal = true;
         
        // TODO user has to enter a username with at least 1 character 
        if (Casino.getPlayer().getId().equals(null))
        {
            accountReal = false;
        } 
         
        return accountReal;
        
    }
}
