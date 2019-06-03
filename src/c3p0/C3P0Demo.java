package c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class C3P0Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql="select * from t_user";
		
		ComboPooledDataSource cp = new ComboPooledDataSource("usersystem");
		Connection conn;
		try {
			conn = cp.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
