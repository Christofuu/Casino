import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Leaderboard
{
	// this class will write the data of the current user to a json array of scores
	// score will be chips + cash
	private static File leaderboardData = new File("leaderboard.json");
	
	public static void leaderboardToString() {
		JSONObject obj;
		
		BufferedReader br = null;
		
		try {
			
			FileReader fileReader = new FileReader(leaderboardData);
			br = new BufferedReader(fileReader);
			obj = (JSONObject) new JSONParser().parse(br);
			JSONObject storedUserInfo = obj;
			JSONArray users = (JSONArray) storedUserInfo.get("Users");
			
			for (int i = 1; i < users.size(); i++) {
				JSONObject currentUser = new JSONObject();
				currentUser = (JSONObject) users.get(i - 1);
				
				String username = (String)currentUser.get("Username");
				int score = ((Long) currentUser.get("Score")).intValue();
				int chips = ((Long) currentUser.get("Chips")).intValue();
				int money = ((Long) currentUser.get("Money")).intValue();
				
				System.out.println(i + ".) " + username + "\nScore: " + score + "\nChips: " + chips + "\nMoney: " + money);
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
	
	@SuppressWarnings("unchecked")
	public static void updateLeaderboard() {
		JSONObject obj;
		
		BufferedReader br = null;
		
		try {
			
			FileReader fileReader = new FileReader(leaderboardData);
			br = new BufferedReader(fileReader);
			obj = (JSONObject) new JSONParser().parse(br);
			JSONObject storedUserInfo = obj;
			JSONArray users = (JSONArray) storedUserInfo.get("Users");
			
			JSONObject currentUser = new JSONObject();
			currentUser.put("Username", Casino.getPlayer().getUsername());
			currentUser.put("Score", Casino.getPlayerScore());
			currentUser.put("Chips", Casino.getPlayer().getChips());
			currentUser.put("Money", Casino.getPlayer().getMoney());
			
			JSONObject topEntry = new JSONObject(); 
			topEntry = (JSONObject) users.get(0);
			int topEntryScore = ((Long) topEntry.get("Score")).intValue();
			if (Casino.getPlayerScore() > topEntryScore) {
				users.add(0, currentUser);
			}
			
			else {
				JSONObject currentEntry = new JSONObject();
				JSONObject previousEntry = new JSONObject();
				for (int i = 1; i < users.size(); i++) {
					currentEntry = (JSONObject) users.get(i);
					previousEntry = (JSONObject) users.get(i-1);
					int currentEntryScore = ((Long) currentEntry.get("Score")).intValue();
					int previousEntryScore = ((Long) previousEntry.get("Score")).intValue();
					
					if (Casino.getPlayerScore() <= previousEntryScore && Casino.getPlayerScore() >= currentEntryScore) {
						users.add(i, currentUser);
						writeToLeaderboardFile(users);
						return;
					}
				}
				users.add(currentUser);
			}
			writeToLeaderboardFile(users);

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
	
	public static void writeToLeaderboardFile(JSONArray users) throws IOException {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(leaderboardData);
				pw.println("{\n\"Users\":[");
				for (int i = 0; i < users.size(); i++) {
					pw.print(users.get(i));
					if (i != users.size() - 1) {
						pw.println(",");
					}
				}
				pw.println("\n]\n}");
				
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		finally {
			try {
				pw.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		updateLeaderboard();
		leaderboardToString();
	}
}
