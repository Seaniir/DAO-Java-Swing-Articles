package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao {
	//Appel de la connection
	Connection connect = GetConnection.getConnection();
	
	public void inscription(User user) {
		
		try {
			PreparedStatement sql = connect.prepareStatement("INSERT INTO user (nom, prenom,email,pwd) VALUES"
					+ "(?,?,?,PASSWORD(?))");
			sql.setString(1, user.getNom());
			sql.setString(2, user.getPrenom());
			sql.setString(3, user.getEmail());
			sql.setString(4, user.getPwd());
			
			sql.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean mailExist(String mail) {
		Boolean msg = false;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email = ?");
			
			sql.setString(1, mail);
			
			ResultSet rs = sql.executeQuery();
			
			if(!rs.next()) {
				msg = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
	}
	
	public boolean login(String mail, String password) {
		
		Boolean msg = false;
		try {
			PreparedStatement sql = connect.prepareStatement("SELECT * FROM user WHERE email=? AND pwd=PASSWORD(?)");
			sql.setString(1, mail);
			sql.setString(2, password);
			System.out.println(sql);
			ResultSet rs = sql.executeQuery();
			
			if(rs.next()) {
				msg = true;
				User.currentUser = new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("pwd"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return msg;
		
	}
}