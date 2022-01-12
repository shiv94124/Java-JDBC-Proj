package com.student.manage;
import java.sql.*;

public class StudentDao {
	static Connection conn = DatabaseConnectionProvider.createConnection();
	public static boolean insertStudentToDB(Student st) {
		boolean f = false;
		try {
			String q = "insert into student(sname,sphone,scity) values(?,?,?)";
			// prepared Statement
			PreparedStatement pstmt = conn.prepareStatement(q);
			pstmt.setString(1, st.getSname());
			pstmt.setString(2, st.getSphone());
			pstmt.setString(3,st.getScity());
			
			// execute
			pstmt.executeUpdate();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int sid) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String q = "delete from student where sid = ?";
			// prepared Statement
			PreparedStatement pstmt = conn.prepareStatement(q);
			pstmt.setInt(1,sid);
			// execute
			pstmt.executeUpdate();
			f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub
		try {
			String q = "select * from student";
			Statement stmt = conn.createStatement();
			ResultSet set = stmt.executeQuery(q);
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				System.out.println(id);
				System.out.println(name);
				System.out.println(phone);
				System.out.println(city);
				System.out.println("-----------------------------");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateStudent(int id, String name, String phone, String city) {
		String q = "update student set sname = ?, sphone = ?, scity = ? where sid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(q);
			pstmt.setString(1, name);
			pstmt.setString(2,phone);
			pstmt.setString(3,city);
			pstmt.setInt(4, id);
			pstmt.executeUpdate();
			System.out.println("Student is updated successfully.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
