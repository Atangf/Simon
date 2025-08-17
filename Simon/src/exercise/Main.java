package exercise;

import java.util.Scanner;
import java.util.Random; 

public class Main {

	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();

	static String pick = "";
	static String compChoice = "";
	static String storeAnswer = "";
	static String user = "";
	static int score = 0;
		
	public static void main(String[] args) {
		System.out.println("Welcome to Simon Says Game!");
		welcome();
	}
	
	public static void welcome(){
	System.out.println("Do you want to play? Type yes or no");
	pick = scan.nextLine();
		if (pick.equals("yes")) {
			playGame();
		}
		else if (pick.equals("no")) {
			System.out.println("Thanks for playing goodbye!");
		}
		else {
			System.out.println("Incorrect input. Try Again");
			welcome();
		}	
	}
	
	public static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	
	public static void checkScore(){
		try {
			if (user.equals(storeAnswer)) {
				score++;
				System.out.println("correct!");
				System.out.println("Score: " + score);
				Thread.sleep(2000);
				clearScreen();
			}
			else {
				score--;
				System.out.println("Wrong!");
				System.out.println("Score: " + score);
				Thread.sleep(2000);
				clearScreen();
		}
	}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
 
	public static void playGame(){
		while (score < 5) {
			String[] colors = {"blue", "green", "yellow", "red"};
			System.out.println("Simon says: ");
			int count = 0;

			try {
				while(count < 3) {
					int num = ran.nextInt(4);
					compChoice = colors[num] + " ";
			
					System.out.print(compChoice);
			
					Thread.sleep(1000);
					count++;
					storeAnswer = storeAnswer + compChoice;
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		
			clearScreen();
			System.out.println("Your turn!");
				user = scan.nextLine();
				user = user + " ";
				checkScore();
				
			storeAnswer = "";
			user = "";
			}
		
		System.out.println("You won!");
		welcome();
	}
}
