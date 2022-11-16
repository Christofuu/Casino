
import java.util.Scanner;
import java.util.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class LoginApp {

// Maybe this class should be an interface? include the fields in the casino class?
    //FIELD
private static Scanner userInput = new Scanner(System.in);
private static String inputId, inputPassword;
//TODO have user chips and money update from hashmap on login
//TODO populate hashmap with userdata stored in textfile on program start and termination
//TODO once done handle hashmap collisions
public static HashMap<String, String> userDataList = new HashMap<String, String>();
private static File txtFile = new File("userData.txt");
private static boolean runState;
private static String userInfo = "idpass:chips money";
private static String chipsRegex = "chips^[0-9]$";
private static String moneyRegex = "money^[0-9]$";
private static Pattern chipPattern = Pattern.compile(chipsRegex);
private static Pattern moneyPattern = Pattern.compile(moneyRegex);
private static Matcher chipMatcher = chipPattern.matcher(userInfo);
private static Matcher moneyMatcher = moneyPattern.matcher(userInfo);

public LoginApp() {
}  



	public static HashMap<String, String> fileToHashMap() {
		BufferedReader br = null;
		HashMap<String, String> map = new HashMap<String, String>();
		
		try {
			br = new BufferedReader(new FileReader(txtFile));
			String line = null;
			
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(":");
				System.out.println(parts.length);
				System.out.println(parts);
				String userAndPass = parts[0].trim();
				String chipsAndMoney = parts[1].trim();
				
				if (!userAndPass.equals("") && !chipsAndMoney.equals("")) {
					map.put(userAndPass, chipsAndMoney);
				}
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
		
		return map;
	}
	
	public static void hashMapToFile() {
		BufferedWriter bf = null;
		
		try {
			bf  = new BufferedWriter(new FileWriter(txtFile));
			
			for (Map.Entry<String, String> entry : userDataList.entrySet()) {
				bf.write(entry.getKey() + ":" + entry.getValue());
				bf.newLine();
			}
			bf.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bf.close();
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
        	if (txtFile.createNewFile()) {
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
        
        userDataList = fileToHashMap();
        
        // prints out hashmap to test if it worked
        for (Map.Entry<String, String> entry : userDataList.entrySet()) {
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
                    Casino.main(args);
                    break;


                default:
                System.out.println("Select a menu option by entering a value from 1 to 4.");
				break;
            }

        }while(runState);
    }

    public static void updateUserInfo()
    {
    	if (userDataList.containsKey(Casino.getPlayer().getUsername() + Casino.getPlayer().getPassword())) {
        	userInfo = userDataList.get(Casino.getPlayer().getUsername() + Casino.getPlayer().getPassword());
        	
        	while (chipMatcher.find()) {
        		if (chipMatcher.group().length() != 0) {
        			Casino.getPlayer().setChips(Integer.parseInt(chipMatcher.group()));
        		}
        	}
        	while (moneyMatcher.find()) {
        		if (moneyMatcher.group().length() != 0) {
        			Casino.getPlayer().setMoney(Integer.parseInt(moneyMatcher.group()));
        		}
        	}
    	}
    	else {
    		userInfo = " chips" + Casino.getPlayer().getChips() + " money" + Casino.getPlayer().getMoney() ;//+ " \n";
    	}
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
            Casino.getPlayer().setPassword(inputPassword);
            
            updateUserInfo();
            userDataList.put(inputId + inputPassword, userInfo);
            
		} while (validId == false);
        
    }
    
    private static void setAccount(Player player, String inputId, String inputPassword, int inputChips, int inputMoney) 
    {
        player.setUsername(inputId);
        player.setPassword(inputPassword);
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
            
        	if (userDataList.containsKey(Casino.getPlayer().getUsername() + Casino.getPlayer().getPassword())) {
        		// TODO format userinfo assignment here
        		System.out.println(Casino.getPlayer().getUsername() + Casino.getPlayer().getPassword());
        		userDataList.replace(Casino.getPlayer().getUsername() + Casino.getPlayer().getPassword(), "chips9999 money9999:" );
        		
        		// test print
        		for (Map.Entry<String, String> entry : userDataList.entrySet()) {
                	System.out.println(entry.getKey() + ":" + entry.getValue());
                }
        		
//            	userInfo = userDataList.get(inputId + inputPassword);
//            	StringBuffer buffer = new StringBuffer();
//            	
//            	//TODO figure out how the fuck regex works
//            	while (chipMatcher.find()) {
//            		if (chipMatcher.group().length() != 0) {
//            			chipMatcher.appendReplacement(buffer, String.valueOf(Casino.getPlayer().getChips()));
//            		}
//            	}
//            	while (moneyMatcher.find()) {
//            		if (moneyMatcher.group().length() != 0) {
//            			moneyMatcher.appendReplacement(buffer, String.valueOf(Casino.getPlayer().getChips()));
//            		}
//            	}
            	
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
                System.out.println("Enter your ID");
                inputId = userInput.next();
                System.out.println("Enter Password");
                inputPassword = userInput.next();
                
                if (userDataList.containsKey(inputId + inputPassword)) {
                	Casino.getPlayer().setUsername(inputId);
                	Casino.getPlayer().setPassword(inputPassword);
                	userInfo = userDataList.get(inputId + inputPassword);
                	
                	while (chipMatcher.find()) {
                		if (chipMatcher.group().length() != 0) {
                			Casino.getPlayer().setChips(Integer.parseInt(chipMatcher.group()));
                		}
                	}
                	while (moneyMatcher.find()) {
                		if (moneyMatcher.group().length() != 0) {
                			Casino.getPlayer().setMoney(Integer.parseInt(moneyMatcher.group()));
                		}
                	}
                	
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
