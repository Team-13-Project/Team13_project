package com.sa.trainingapp.service;
/**
 * Chandra Shekhar H M for SkillAssure
 */
import java.util.List;

import com.sa.trainingapp.beans.Education;
import com.sa.trainingapp.beans.Trainer;

public interface TrainerService {
	// Returns the generated trainer id
	long addTrainer(Trainer trainer);
	
	boolean editTrainer(Trainer trainer);
	
	Trainer getTrainerByTrainerId(long trainerId);
	
	Trainer getTrainerByEmailId(String emailId);
	
	List<Trainer> getAllTrainers();
	
	
	
	long addTrainersEducationInfo(Trainer trainer, Education education);
	
	boolean editEducationInfo(Education education);
	
	Education viewEducationInfo(long trainerId);
}
