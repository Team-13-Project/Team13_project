package com.sa.trainingapp.main;

import com.sa.trainingapp.beans.Education;
import com.sa.trainingapp.beans.Trainer;
import com.sa.trainingapp.service.impl.TrainerServiceImpl;

//this testmain is to add education to the DB
public class TestMain6 
{
	public static void main(String[] args) 
	{
		//setting the data of the Education
		String instituteName = "The Oxford College of Science";
		String degree = "MCA";
		String specialization = "Computer Science";
		int startYear = 2015;
		int endYear = 2018;
		int courseDuration = 3;
		String board = "Bangalore University"; //board of institution
		int percentage = 72;
		String city = "Bangalore";
		String state = "Karnataka";
		String country = "India";
		
		//create the trainer
		Trainer trainer = new Trainer();
		long trainerId = 1; 
		trainer.setTrainerId(trainerId);
		
		//create the education
		Education education = new Education(instituteName, degree, specialization, startYear, endYear, 
								courseDuration, board, percentage, city, state, country);
		
		//setting the education to the trainer 
		trainer.setEducation(education);
		
		// Create Trainer service
		TrainerServiceImpl service = new TrainerServiceImpl();
		
		//getting the details of the trainerID
		Trainer trainerObj = service.getTrainerByTrainerId(trainerId);
		
		//add the trainerObj and education 
		long status = 0;
		status=service.addTrainersEducationInfo(trainerObj, education);

		// Display storing Education status
		String message1 = "Saved successfully ";
		String message2 = "Something went wrong!!! \n Try Again";
		System.out.println(status>0 ? message1 : message2);
		
	}

}
