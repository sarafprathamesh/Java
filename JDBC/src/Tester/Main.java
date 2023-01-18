package Tester;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;

import DAL.BankDALImplemented;
import DBConnection.DBUtil;
import poco.BankAccount;

public class Main {

	public static void main(String[] args) {
		try {
		DBUtil.OpenConnection();
		BankDALImplemented bankDal=new BankDALImplemented();
		
		int choice=0;
		Scanner sc=new Scanner(System.in);
			
		do {
			System.out.println("1.Get All Accounts\n"
								+ "2.Insert Account\n"
								+ "3.Update Account\n"
								+ "4.Delete Account\n"
								+ "5.Money Transfer");
			
			System.out.println("Enter Your Choice : ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				List<BankAccount> list=bankDal.getAllAccounts();
				list.forEach(b->System.out.println(b));
				break;
				
			case 2:
				System.out.println("Enter AccountNo,Account Holder's name,Branch,Balance");
				BankAccount account=new BankAccount(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
				bankDal.insertAccount(account);
				break;
				
			case 3:
				System.out.println("Enter AccountNo, newAccount Holder's name, newBranch, newBalance");
				BankAccount account1=new BankAccount(sc.nextInt(),sc.next(),sc.next(),sc.nextDouble());
				bankDal.updateAccount(account1);
				break;
				
			case 4:
				System.out.println("Enter AccountNo");
				int accNo =sc.nextInt();
				bankDal.deleteAccount(accNo);
				break;
			case 5:
				System.out.println("Enter Sender's Account Number,Receivers's Account Number,Amount");
				int sAccNo =sc.nextInt();
				int rAccNo =sc.nextInt();
				double amount=sc.nextDouble();
				bankDal.moneyTransfer(sAccNo, rAccNo, amount);
				break;
			case 6:
				choice=6;
				break;	
			}
		}while(choice!=6);
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}

}
