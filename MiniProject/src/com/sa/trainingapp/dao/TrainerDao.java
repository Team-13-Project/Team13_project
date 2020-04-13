package com.sa.trainingapp.dao;
/**
 * Chandra Shekhar H M for SkillAssure
 */
import java.util.List;

import com.sa.trainingapp.beans.Education;
import com.sa.trainingapp.beans.Trainer;

public interface TrainerDao {
	long saveTrainer(Trainer trainer);
	
	boolean updateTrainer(Trainer trainer);
	
	Trainer getTrainer(long trainerId);
	
	Trainer getTrainer(String emailId);
	
	List<Trainer> getTrainers();
	
	//this is for adding education to the trainer
	long saveTrainersEducationInfo(Trainer trainer, Education education);
	boolean updateEducationInfo(Education education);
	Education findEducationInfo(long trainerId);
}
