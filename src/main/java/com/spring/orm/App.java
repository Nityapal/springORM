package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;


public class App 
{
    public static void main( String[] args )
    {

    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    	
//    	Student student= new Student(36,"nitya","knp");
//    	int r= studentDao.insert(student);
//    	System.out.println("done: "+r);
    	
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	
    	boolean go=true;
    	
    	while(go) {
    		System.out.println("PRESS 1 FOR ADDING NEW STUDENT");
        	System.out.println("PRESS 2 FOR DISPALYING ALL STUDENTS");
        	System.out.println("PRESS 3 FOR GETTING DETAILS OF SINGLE STUDENT");
        	System.out.println("PRESS 4 FOR DELETING A STUDENT");
        	System.out.println("PRESS 5 FOR UPDATING A STUDENT");
        	System.out.println("PRESS 6 FOR EXIT");
        	
        	try {
        		
        		int input= Integer.parseInt(br.readLine());
        		switch(input) {
        		case 1:
        			//add
        			
        			//taking inputs from users
        			System.out.println("Enter user id: ");
        			int uId= Integer.parseInt(br.readLine());
        			
        			System.out.println("Enter user name: ");
        			String uName= br.readLine();
        			
        			System.out.println("Enter user city: ");
        			String uCity= br.readLine();
        			
        			//creating student object and setting values
        			Student s= new Student();
        			s.setStudentId(uId);
        			s.setStudentName(uName);
        			s.setStudentCity(uCity);
        			
        			//saving student obj to database by calling insert fn of StudentDao
        			int r= studentDao.insert(s);
        			System.out.println(r+" student added");
        			System.out.println("############################");
        			
        			break;
	        	case 2:
	        		//display
	        		System.out.println("############################");
	        		List<Student> allStudents = studentDao.getAllStudents();
	        		for(Student st: allStudents) {
	        			System.out.println("name: "+st.getStudentName());
	        			System.out.println("id: "+st.getStudentId());
	        			System.out.println("city: "+st.getStudentCity());
	        			System.out.println("--------------------------------");
	        		}
	        		System.out.println("############################");
	        		
	        		break;
		    	case 3:
		    		//get details
		    		
		    		System.out.println("enter user id: ");
		    		int userId= Integer.parseInt(br.readLine());
		    		Student st= studentDao.getStudent(userId);
		    		System.out.println("name: "+st.getStudentName());
        			System.out.println("id: "+st.getStudentId());
        			System.out.println("city: "+st.getStudentCity());
		    		
		    		break;
			    case 4:
			    	//delete
			    	
			    	System.out.println("enter user id: ");
		    		int usId= Integer.parseInt(br.readLine());
		    		studentDao.deleteStudent(usId);
		    		System.out.println("done!!");
			    	
			    	break;
				case 5:
					//update
					
					System.out.println("enter user id: ");
					 
					
					break;
				case 6:
					//exit
					go= false;
					break;		
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 6.");
					break;
        		}
        	}catch(Exception e) {
        		System.out.println("INVALID INPUT; TRY ANOTHER ONE");
        		System.out.println(e.getMessage());
        	}
    	}
    	System.out.println("THNAKS FOR USING MY APPLICATION!!!");
    }
}
