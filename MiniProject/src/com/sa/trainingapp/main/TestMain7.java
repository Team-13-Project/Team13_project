package com.sa.trainingapp.main;

import com.sa.trainingapp.beans.Education;
import com.sa.trainingapp.beans.Trainer;
import com.sa.trainingapp.dao.jpa.JpaTrainerDao;
import com.sa.trainingapp.service.impl.TrainerServiceImpl;

public class TestMain7 
{
	public static void main(String[] args) 
	{
		// setting the data of the Education
		long educationId = 2;
		String instituteName = "The Oxford College of Science";
		String degree = "MCA";
		String specialization = "Computer Science";
		int startYear = 2015;
		int endYear = 2018;
		int courseDuration = 3;
		String board = "Bangalore"; // board of institution
		int percentage = 72;
		String city = "BLR";
		String state = "Kar";
		String country = "India";

		//create the education
		Education education = new Education(instituteName, degree, specialization, startYear, endYear, courseDuration,
				board, percentage, city, state, country);
		
		//setting the education to the educationID
		education.setEducationId(educationId);
		
		long trainerId = 1;
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerId);
		
		// Create Trainer service
		TrainerServiceImpl service = new TrainerServiceImpl();
		
		// Set dao implementation to be used by service
		service.setTrainerDao(new JpaTrainerDao());
		
		boolean status =  service.editEducationInfo(education);
		
		// Display update Education status
		String message1 = "Updated successfully ";
		String message2 = "Something went wrong!!! \n Not updated";
		System.out.println(status ? message1 : message2);

	}

}
