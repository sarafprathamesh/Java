package DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import poco.BankAccount;
import DBConnection.DBUtil;

public class BankDALImplemented implements BankDAL {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt1, pstmt2, pstmt3;
	private ResultSet rset;
	private CallableStatement cstmt;

	public BankDALImplemented() throws SQLException {
		con = DBUtil.getCon();
		stmt = con.createStatement();

		pstmt1 = con.prepareStatement("insert into account values(?,?,?,?)");
		pstmt2 = con.prepareStatement("update account set accName=?,branch=?,balance=? where accNo=?");
		pstmt3 = con.prepareStatement("delete from account where accNo=?");
		cstmt = con.prepareCall("{call moneyTransfer(?,?,?,?,?)}");

		cstmt.registerOutParameter(4, Types.DOUBLE);
		cstmt.registerOutParameter(5, Types.DOUBLE);

	}

	@Override
	public List<BankAccount> getAllAccounts() {
		List<BankAccount> allAccounts = new ArrayList<BankAccount>();

		try {
			rset = stmt.executeQuery("select * from account");

			while (rset.next()) {
				allAccounts.add(new BankAccount(rset.getInt("accNo"), rset.getString("accName"),
						rset.getString("branch"), rset.getDouble("balance")));
			}
			return allAccounts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int insertAccount(BankAccount account) {

		try {
			pstmt1.setInt(1, account.getAccountNo());

			pstmt1.setString(2, account.getAccName());

			pstmt1.setString(3, account.getBranch());

			pstmt1.setDouble(4, account.getBalance());

			int status = pstmt1.executeUpdate();
			return status;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateAccount(BankAccount account) {
		try {

			pstmt2.setInt(4, account.getAccountNo());

			pstmt2.setString(1, account.getAccName());

			pstmt2.setString(2, account.getBranch());

			pstmt2.setDouble(3, account.getBalance());

			int status = pstmt2.executeUpdate();
			return status;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteAccount(int account) {
		try {

			pstmt3.setInt(1, account);
			int status = pstmt3.executeUpdate();
			return status;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int moneyTransfer(int sid, int rid, double amount) {
		try {
			cstmt.setInt(1, sid);
			cstmt.setInt(2, rid);
			cstmt.setDouble(3, amount);
			int i = cstmt.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
