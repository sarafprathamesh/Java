package DAL;

import poco.BankAccount;
import java.util.List;

public interface BankDAL {

	List<BankAccount> getAllAccounts();

	int insertAccount(BankAccount account);

	int updateAccount(BankAccount account);

	int deleteAccount(int id);
	
	int moneyTransfer(int sid,int rid,double amount);

}
