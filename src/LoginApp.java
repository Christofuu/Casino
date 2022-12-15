
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//import org.json.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.*;



public class LoginApp {

// Maybe this class should be an interface? include the fields in the casino class?
    //FIELD
private static Scanner userInput = new Scanner(System.in);
private static String inputId, inputPassword;
private static String[] loginInfo = {inputId, inputPassword};
//TODO have user chips and money update from hashmap on login
//TODO populate hashmap with userdata stored in textfile on program start and termination
//TODO once done handle hashmap collisions
public static HashMap<String[], Integer[]> userDataList = new HashMap<>();
private static File userDataFile = new File("userData.json");
private static boolean runState;
private static JSONObject newUserInfo = new JSONObject();
private static String[] userInfo = {"username", "password"};
private static Integer[] userChipsAndCash = {0, 0};

public LoginApp() {
}  



	/**
	 * Iterates through JSON File of all users data
	 * Stores that data locally in a hashmap
	 * @return
	 */
	public static void fileToHashMap() {
		JSONObject obj;
		
		BufferedReader br = null;
		
		try {
			
			FileReader fileReader = new FileReader(userDataFile);
			br = new BufferedReader(fileReader);
			obj = (JSONObject) new JSONParser().parse(br);
			JSONObject storedUserInfo = obj;
			JSONArray users = (JSONArray) storedUserInfo.get("Users");
			
			for (int i = 0; i < users.size(); i++) {
				JSONObject currentUser = new JSONObject();
				currentUser = (JSONObject) users.get(i);
				
				String username = (String)currentUser.get("Username");
				String password = (String)currentUser.get("Password");
				String[] loginData = {username, password};
				int chips = ((Long) currentUser.get("Chips")).intValue();
				int money = ((Long) currentUser.get("Money")).intValue();
				Integer[] userScore = {chips, money};				
				userDataList.put(loginData, userScore);
			}
			

		}
        catch (Exception e){
            e.printStackTrace();
        }
		finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// TODO update for JSON implementaion
	// rewrite whole json? or just whats been updated?
	// if there's an easy way to have this update a single entry, we can call it as needed
	public static void hashMapToFile() {
		PrintWriter pw = null;
		
		try {
			pw  = new PrintWriter(new FileWriter(userDataFile));
			// bf.write(((JSONAware) obj).toJSONString());
			pw.println("{\n\"Users\": [");
			for (Map.Entry<String[], Integer[]> entry : userDataList.entrySet()) {
				pw.println("{\n\"Username\": \"" + entry.getKey()[0] + "\",");
				pw.println("\"Password\": \"" + entry.getKey()[1] + "\",");
				pw.println("\"Chips\": \"" + entry.getValue()[0] + "\",");
				pw.println("\"Money\": \"" + entry.getValue()[1] + "\"\n},");
			}
			pw.println("]\n}");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

    
  /**
   * The main function of the program.1
   * 
   * @param args The command line arguments.
   */
  public static void main(String[] args) {

        runState = true;
        
        try {
        	if (userDataFile.createNewFile()) {
        		System.out.println("Previous user data not found. Created new data file.");
        	}
        	else {
        		System.out.println("Previous user data found.");
        	}
        } catch (IOException e) {
        	System.out.println("An error occurred.");
        	e.printStackTrace();
        }
        
        // testing map to text file
        // https://www.geeksforgeeks.org/reading-text-file-into-java-hashmap/
        
        fileToHashMap();
        
        // prints out hashmap to test if it worked
        for (Map.Entry<String[], Integer[]> entry : userDataList.entrySet()) {
        	System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        
        do{
            System.out.println("Choose menu");
            System.out.println("1. Create account  \n2. Login  \n3. Delete Account \n4. Return To Casino");
            
            int select = userInput.nextInt();
            
            switch(select){
                
                case 1:
                    createAccount();
                    break;

                case 2:
                    loginAccount();
                    break;
                
                // case 3:
                //     deleteAccount();
                //     break;

                case 4:
                    try
					{
						Casino.main(args);
					}
					catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    break;


                default:
                System.out.println("Select a menu option by entering a value from 1 to 4.");
				break;
            }

        }while(runState);
    }

  	// TODO Rewrite this for JSON implementation
    public static void updateUserInfo()
    {
    	loginInfo[0] = inputId;
    	loginInfo[1] = inputPassword;
    }
    
    /**
     * Creates a new account for the player.
     */
    public static void createAccount() {
        
		boolean validId = false;
		do {
            System.out.println("Enter your ID");
            inputId = userInput.next();
            
            if (inputId != null) {
            	Casino.getPlayer().setUsername(inputId);
            	validId = true;
            } else continue;
            
            System.out.println("Enter Password");
            inputPassword = userInput.next();
            
            updateUserInfo();
            userDataList.put(loginInfo, userChipsAndCash);
            
		} while (validId == false);
        
    }
    
    private static void setAccount(Player player, String inputId, String inputPassword, int inputChips, int inputMoney) 
    {
        player.setUsername(inputId);
        player.setChips(inputChips);
        player.setMoney(inputMoney);
        // TODO maybe have to add setChips and setMoney, test more
    }
    
    //TODO : updateAccount should update txtfile that check userId and userPW and change user chip and usermoney

    /*
     * 
     */
    public static void updateAccount() 
    {
    	updateUserInfo();

        boolean updateAccount  = false;

        do {
            
        	if (userDataList.containsKey(loginInfo)) {
        		// TODO format userinfo assignment here
        		System.out.println(Casino.getPlayer().getUsername() + " ");
        		userDataList.replace(loginInfo, userChipsAndCash);
        		
        		// test print
        		for (Map.Entry<String[], Integer[]> entry : userDataList.entrySet()) {
                	System.out.println(entry.getKey() + ":" + entry.getValue());
                }
            	
            	updateAccount = true;
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
    // TODO rewrite for JSON implementation
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
    	//TODO arrays are objects so the hashmap wont treat a new array with user input as equal to stored key, because of diff hashcodes
    	// find soln
        boolean loginSuccess  = false;

        do {
                System.out.println("Enter your ID");
                inputId = userInput.next();
                System.out.println("Enter Password");
                inputPassword = userInput.next();
                loginInfo[0] = inputId;
                loginInfo[1] = inputPassword;
                
                if (userDataList.containsKey(loginInfo)) {
                	Casino.getPlayer().setUsername(inputId);
                	userChipsAndCash = userDataList.get(loginInfo);

                	Casino.getPlayer().setChips(userChipsAndCash[0]);
                	Casino.getPlayer().setMoney(userChipsAndCash[1]);

                	loginSuccess = true;
                }
                else {
                	System.out.println("Invalid username or password.");
                	// exits loop so they aren't stuck if they dont have an account/cant login
                	loginSuccess = true;
                }
 
        } while (loginSuccess != true);
    }

    public static boolean checkUsername() {

        boolean accountReal = true;
         
        // TODO user has to enter a username with at least 1 character 
        if (Casino.getPlayer().getUsername() == null)
        {
            accountReal = false;
        } 
         
        return accountReal;
        
    }
    
    public static void setRunState(boolean state)
    {
    	runState = state;
    }
}
