package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.dao.AppDAOImpl;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner-> {
			//createInstrctor(appDAO);
			//findInstructor(appDAO);

			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			createInstrctorWithCourses(appDAO);
		};

	}

	private void createInstrctorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Susan","Public","susan.public@luv2code.com");
		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com","video " +
				"Games");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some course
		Course tempCourse1 = new Course("Air Guitar");
		Course tempCourse2 = new Course("the pinball");
		// add course to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// saving the instructor
		System.out.println(" Saving instructor "+ tempInstructor);
		System.out.println(" the courses "+ tempInstructor.getCourses());
		// NOTE : this will also save the courses
		// because of the CascadeType.PERSIST
		appDAO.save(tempInstructor);
		System.out.println("Done");


	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId =3;
		System.out.println("Deleting instructor detail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done !");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId =2;
		// get the instructor detail object
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail :"+tempInstructorDetail);

		// print the associated instructor
		System.out.println("Associated instructor :"+ tempInstructorDetail.getInstructor());

		System.out.println("Done");


	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: "+ theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done !!!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId =2;
		System.out.println("Finding instructor id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("The Associate instructorDetail only: "+ tempInstructor.getInstructorDetail());

	}

	private void createInstrctor(AppDAO appDAO) {
	/*	 // create the instructor
		Instructor tempInstructor = new Instructor("Chad","Darby","darby@luv2code.com");
		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","luv 2 code!!!!");
            */
		// create the instructor
		Instructor tempInstructor = new Instructor("Madhu","Patel","madhu@luv2code.com");
		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube","Guitar");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		//NOTE : this will ALSO save the details object
		//because of CascadeType.ALL
		//
		System.out.println("Saving instructor :"+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");





	}

}
