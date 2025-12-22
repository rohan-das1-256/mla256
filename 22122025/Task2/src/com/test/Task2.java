package com.test;

import java.util.Scanner;

class Account {
    private int acc_num;
    private String acc_name;
    private double acc_bal;
	
    public int getAcc_num() {
		return acc_num;
	}
	public void setAcc_num(int acc_num) {
		this.acc_num = acc_num;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public double getAcc_bal() {
		return acc_bal;
	}
	public void setAcc_bal(double acc_bal) {
		this.acc_bal = acc_bal;
	}
    
    
    
    
}


public class Task2 {
	
	static void createAccount() {
		
		
		System.out.println("account created");
	}
	

	


	public static void main(String[] args) {
		
		Account acc = new Account();
		Task2 task = new Task2();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--BANK ACCOUNT MANAGEMENT SYSTEM--");
        System.out.println("choose any one from the below:");
        System.out.println("1. create account\n" +
        					"2. login\n"+
        					"3. transfer\n"+
        					"4. withdraw\n"+
        					"5. check balance\n"+
        					"0. EXIT");
        
        int response = sc.nextInt();
        
        boolean running = true;
        
        while(running) {
        	switch (response) {
    		case 1: 
    			System.out.println("Creating account...");
    			//task.createAccount();
    			pause(sc);
    			break;
    		case 2:
    			System.out.println("Looging you in...");
    			pause(sc);
    			break;
    		case 3:
    			System.out.print("Whom to transfer(account number):");
    			pause(sc);
    			break;
    		case 4:
    			System.out.print("Amount to be withdrawn: ");
    			pause(sc);
    			break;
    		case 5:
    			System.out.println("Available balance: ");
    			pause(sc);
    			break;
    		case 0:
    			System.out.println("Bye!");
    			running = false;
    			break;
    		default:
    			throw new IllegalArgumentException("Unexpected value: " + response);
    		}
        }
        
        
   
	}
	
	private static void pause(Scanner sc) {
        System.out.print("Press Enter to continue...");
        sc.nextLine();
    }
	
}
