package com.sa.trainingapp.main;


import com.sa.trainingapp.beans.Trainer;
import com.sa.trainingapp.dao.jpa.JpaTrainerDao;
import com.sa.trainingapp.service.impl.TrainerServiceImpl;

//This testmain is to add the trainer details
public class TestMain1 
{
	public static void main(String[] args) 
	{
		// Identify test data
		String fullName = "Umesh";
		String emailId = "umeshfarrow@gmail.com";
		float target = 10_00_000.0f;
		int age = 25;

		// Create a Trainer
		Trainer trainer = new Trainer(fullName, emailId, target, age);
		
		// Create Trainer service
		TrainerServiceImpl service = new TrainerServiceImpl();
		
		// Set dao implementation to be used by service
		service.setTrainerDao(new JpaTrainerDao());
		
		// Save Trainer
		long status=0;
		status=service.addTrainer(trainer);
		
		// Display storing trainer status
		String message1 = "Saved successfully ";
		String message2 = "Something went wrong!!! \n Try Again";
		System.out.println(status>0 ? message1 : message2);

	}

}
