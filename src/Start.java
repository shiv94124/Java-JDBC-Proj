import java.io.*;
import com.student.manage.*;
public class Start {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Student Management App!!!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to Add Student.");
			System.out.println("Press 2 to Delete Student.");
			System.out.println("Press 3 to Retrieve Student.");
			System.out.println("Press 4 to Update Student.");
			System.out.println("Press 5 to Exit App.");
			int c = Integer.parseInt(br.readLine());
			if(c==1) {
				//add Student
				System.out.println("Enter Studetn name:");
				String name = br.readLine();
				System.out.println("Enter studetnt's phone no");
				String phoneNo = br.readLine();
				System.out.println("Enter Student's cityName");
				String city = br.readLine();
				Student st = new Student(name,phoneNo,city);
				boolean ans = StudentDao.insertStudentToDB(st);
				if(ans) {
					System.out.println("Student is added successfully!"); 
				}
				else {
					System.out.println("Something went wrong..");
				}
			}else if(c==2) {
				// delete student 
				System.out.println("Enter student's id:");
				int sid = Integer.parseInt(br.readLine());
				boolean ans = StudentDao.deleteStudent(sid);
				if(ans) {
					System.out.println("Student is deleted successfully.");
				}else {
					System.out.println("Something went worng...");
				}
			}else if(c==3) {
				// retrieve All student
				StudentDao.showAllStudent();
			}else if(c==4) {
				// update student
				System.out.println("Enter the student's id");
				int sid = Integer.parseInt(br.readLine());
				System.out.println("Enter updated name:");
				String sname = br.readLine();
				System.out.println("Enter updated phoneno");
				String sphone = br.readLine();
				System.out.println("Enter updated city:");
				String scity = br.readLine();
				StudentDao.updateStudent(sid, sname, sphone, scity);
			}else if(c==5) {
				//exit..
				break;
			}
		}
		System.out.println("You are now out of the App.");
		System.out.println("Thank you for using the App, See you soon !!");
	}

}
