package project2;

import java.util.Scanner;

public class player {
	int banked;
	String name;
	int rolled;
	static dice Dice;
	Scanner input= new Scanner(System.in);
	static{
		Dice=new dice();
	}
	public player(String Pname){
		name=Pname;
		banked=0;
		
	}
	
	public void play(){
		rolled=0;
		System.out.println("How many dice would you like to roll?");
		int numDice=input.nextInt();
		int result = 0;
		
		for(int i=0;i<numDice;i++){
			result=Proll();
			if(result==1){
				result=0;
				break;}
			result=result+result;
			
		}
		System.out.println(name + " has rolled a " + result);
	}
	
	
	private int Proll() {
		int Presult = dice.roll();
		
		return Presult;
	}
public int getBanked(){
	return banked;
		
	}
	}

	