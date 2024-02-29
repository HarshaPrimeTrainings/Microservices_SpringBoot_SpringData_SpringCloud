package com.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderManagment {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_boot_ashokeit", "root",
					"admin");

			con.setAutoCommit(false);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("oid :: ");
			Integer oid = Integer.parseInt(br.readLine());
			System.out.println("amount :: ");
			Integer amount = Integer.parseInt(br.readLine());
			System.out.println("status :: ");
			String status = br.readLine();

			PreparedStatement stmt = con.prepareStatement("insert into ordermng values (?,?,?)");
			stmt.setInt(1, oid);
			stmt.setInt(2, amount);
			stmt.setString(3, status);
			int record = stmt.executeUpdate();
			System.out.println("Placing order :" + record);

			Statement stmnt1 = con.createStatement();
			ResultSet rs = stmnt1.executeQuery("select * from payment");
			rs.next();
			Integer paymentamount = rs.getInt("amount");
			if (paymentamount >= amount) {
				int balance = paymentamount - amount;
				Statement stmnt2 = con.createStatement();
				stmnt2.execute("update payment set amount="+balance+" where pid = 1");
				System.out.println("Payment Deducted :: " + amount);
				
			} else {
				System.out.println("Insufficient Balance");
			}
			System.out.println("order placed successfully");
			con.commit();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
