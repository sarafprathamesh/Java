package poco;

public class BankAccount {
	private int accountNo;
	private String accName;
	private String branch;
	private double balance;
	
	public BankAccount(int accountNo, String accName, String branch, double balance) {
		
		this.accountNo = accountNo;
		this.accName = accName;
		this.branch = branch;
		this.balance = balance;
	}

	public BankAccount() {
		
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accName=" + accName + ", branch=" + branch + ", balance="
				+ balance + "]";
	}
	
	
	
	
	
	
	
	
	
}
