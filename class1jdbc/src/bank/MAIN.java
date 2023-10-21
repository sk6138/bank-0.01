package bank;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


    	
    	//1. load driver
    	//2. connection estblisment
    	//3.statement
    	//4. query
    	//5. close

    	public class MAIN {
    		
    	    public static void main(String[] args) {
    	    	
    	    	bankOpen(true);
    	    	
    	    
    	    	
    	    	
   	    	}  
    	    

			private static void bankOpen(boolean b) {
				 Bank bank = new Bank();
	    	        Scanner sc = new Scanner(System.in);
	    	     

	    	        while (true) {
	    	            System.out.println("\nBanking System Menu:");
	    	            System.out.println("1. Create Account");
	    	            System.out.println("2. Access Account");
	    	            System.out.println("3. Close Account");
	    	            System.out.println("4. Exit");
	    	            System.out.print("Enter your choice: ");

	    	            int choice = sc.nextInt();
	    	            sc.nextLine(); // Consume the newline character

	    	            switch (choice) {
	    	                case 1:
	    	                
	    	                	
	    	                	
	    	                    System.out.print("Enter your first name: ");
	    	                    String firstname = sc.nextLine();
	    	                    System.out.print("Enter your last name: ");
	    	                    String lastname = sc.nextLine();
	    	                    // if(accountHolder==""){
	    	                    //     System.out.println("Do Not Use Number");
	    	                    //     break;
	    	                    // }
	    	                    System.out.print("Enter initial balance: ");
	    	                    try {
	    	                        double initialBalance = sc.nextDouble();
	    	                        BankAccount newAccount = bank.createAccount(firstname,lastname, initialBalance);
	    	                    System.out.println("Account created with account number: " + newAccount.getAccountNumber());
	    	                    } catch (InputMismatchException e) {
	    	                        // TODO: handle exception
	    	                        throw new InputMismatchException("use only digits in Initial balance");
	    	                    }
	    	                    break;
	    	                    
	    	                    
	    	                case 2:
	    	                    System.out.print("Enter account number: ");
	    	                    int accountNumber = sc.nextInt();
	    	                    BankAccount account = bank.getAccount(accountNumber);   //account object
	    	                    if (account != null) {
	    	                        System.out.println("Account Holder: " + account.getAccountHolder());
	    	                        System.out.println("Account Balance: $" + account.getBalance());
	    	                        System.out.println("1. Deposit");
	    	                        System.out.println("2. Withdraw");
	    	                        System.out.println("3. Back");
	    	                        System.out.print("Enter your choice: ");
	    	                        int subChoice = sc.nextInt();
	    	                        switch (subChoice) {
	    	                            case 1:
	    	                                System.out.print("Enter deposit amount: ");
	    	                                try {
	    	                                  double depositAmount = sc.nextDouble();
	    	                                account.deposit(depositAmount);
	    	                                System.out.println("Deposit successful. New balance: $" + account.getBalance());
	    	                                 
	    	                                } catch (InputMismatchException e) {
	    	                                    // TODO: handle exception
	    	                                      throw new InputMismatchException("use only digits in deposit balance");
	    	                                }
	    	                                 break;
	    	                            case 2:
	    	                                System.out.print("Enter withdrawal amount: ");
	    	                                try {
	    	                                      double withdrawalAmount = sc.nextDouble();
	    	                                account.withdraw(withdrawalAmount);
	    	                                System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
	    	                               
	    	                                    
	    	                                } catch (InputMismatchException e) {
	    	                                    // TODO: handle exception
	    	                                      throw new InputMismatchException("use only digits in withdrawal balance");
	    	                                }
	    	                               break;
	    	                        }
	    	                    } else {
	    	                    	
//	    	                        System.out.println("Account not found.");
	    	                    	
	    	                    }
	    	                    break;
	    	                case 3:
	    	                	while(true) {
	    	                	System.out.println("**************IMPORTANT NOTES***************************************************** ");
	    	                	System.out.println("first of all withdraw all money , \n if you are not withdraw the money you will lose the money \n \t\t\t THANK YOU!");
	    	                	System.out.println("**********************************************************************************");
	    	                	System.out.println("1.withdrawl money");
	    	                	System.out.println("2. transfer money");
	    	                	System.out.println("3. close Account");
	    	                	System.out.println("4. BACk");
	    	                	System.out.print("Enter your choice: ");
	    	                	int closechoice = sc.nextInt();
	    	                	switch(closechoice) {
	    	                	  
	    	                	case 1:
	    	                		 System.out.print("Enter account number: ");
	 	    	                     accountNumber = sc.nextInt();
	 	    	                    BankAccount account3 = bank.getAccount(accountNumber);   //account object
	    	                		
	    	                		System.out.print("Enter withdrawal amount: ");
	                                try {
	                                      double withdrawalAmount = sc.nextDouble();
	                                account3.withdraw(withdrawalAmount);
	                                System.out.println("Withdrawal successful. New balance: $" + account3.getBalance());
	                               
	                                    
	                                } catch (InputMismatchException e) {
	                                    // TODO: handle exception
	                                      throw new InputMismatchException("use only digits in withdrawal balance");
	                                }
	    	                		break;
	    	                		
	    	                	case 2:
	    	                		System.out.println("this option is not working currently");
	    	                		break;
	    	                		
	    	                	case 3:
	    	                		System.out.print("enter account number");
		    	                	accountNumber=sc.nextInt();
		    	                	BankAccount account1 = bank.getAccount(accountNumber);
		    	                	
		    	                	SavingAccount delete = new SavingAccount();
		    	                	try {
		    	                	delete.deletedata(accountNumber);
		    	                	System.out.println("Account is Closed Permanently");
		    	                	System.out.println("please gives your FeedBack for Improvement");
		    	                	System.out.println("Thank you !");
		    	                	}
		    	                	catch(Exception e) {
		    	                		e.printStackTrace();
		    	                		System.out.println("please recheck your Account Number then Do it again !");
		    	                	}
	    	                		break;
	    	                		
	    	                	case 4:
	    	                		bankOpen(true);
	    	                		break;
	    	                		
	    	                	default:
	    	                		System.out.println("Invalid choice. Please try again.");
	    	                	
	    	                	}
	    	                	}
	    	            
	    	                
	    	                	
	    	                case 4:
	    	                    System.out.println("Thank you for using the Banking System.");
	    	                    bankOpen(true);
	    	                    System.exit(0);
	    	                default:
	    	                    System.out.println("Invalid choice. Please try again.");
	    	            }
	    	        }
				
			}
    	}
    	
    	
    	
    	


    	class Bank {
    	    private List<BankAccount> accounts;

    	    public Bank() {
    	        accounts = new ArrayList<>();
    	    }

    	    public BankAccount createAccount(String firstname,String lastname, double initialBalance) {
    	        BankAccount account = new BankAccount(firstname , lastname, initialBalance);
    	        accounts.add(account);
    	        return account;
    	    }

    	    public BankAccount getAccount(int accountNumber) {
    	        for (BankAccount account : accounts) {
    	            if (account.getAccountNumber() == accountNumber) {
    	                return account;
    	            }
    	        }
    	        System.out.println("account not found");
    	        return null;
    	    }
    	}

    	
    	class BankAccount {
    	    private int accountNumber;
    	    private String firstname;
    	    private String lastname;
    	    private double balance;
    	    SavingAccount SA = new SavingAccount();

    	    public BankAccount(String firstname,String lastname, double initialBalance) {
    	    	this.accountNumber = generateAccountNumber();
    	        this.firstname = firstname;
    	        this.lastname = lastname;
    	        this.balance = initialBalance;
    	        
    	    	SA.createAC(firstname,lastname,initialBalance,balance,accountNumber);
    	        
    	    }
    	    

    	    public int getAccountNumber() {
    	        return accountNumber;
    	    }

    	    public String getAccountHolder() {
    	        return firstname+lastname;
    	    }

    	    public double getBalance() {
    	        return balance;
    	    }

    	    public void deposit(double amount) {
    	        balance += amount;
    	        SA.updatebalance(accountNumber,balance);
    	    }

    	    public void withdraw(double amount) {
    	        if (amount <= balance) {
    	            balance -= amount;
    	        } else {
    	            System.out.println("Insufficient balance.");
    	        }
    	        SA.updatebalance(accountNumber,balance);
    	    }

    	    private int generateAccountNumber() {
    	        // Generate a random 6-digit account number
    	        Random rand = new Random();
    	        return 100000 + rand.nextInt(900000);
    	    }
    	  
    	}

    	
  
 