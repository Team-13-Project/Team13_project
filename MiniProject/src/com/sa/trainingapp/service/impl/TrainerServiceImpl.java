package com.sa.trainingapp.service.impl;
/**
 * Chandra Shekhar H M for SkillAssure
 */
import java.util.List;

import com.sa.trainingapp.beans.Education;
import com.sa.trainingapp.beans.Trainer;
import com.sa.trainingapp.dao.TrainerDao;
import com.sa.trainingapp.dao.jpa.JpaTrainerDao;
import com.sa.trainingapp.service.TrainerService;

public class TrainerServiceImpl implements TrainerService {
	private TrainerDao trainerDao;
	
	public TrainerServiceImpl() {
		this.trainerDao = new JpaTrainerDao();
	}
	
	@Override
	public long addTrainer(Trainer trainer) {
		return trainerDao.saveTrainer(trainer);
	}

	@Override
	public boolean editTrainer(Trainer trainer) {
		return trainerDao.updateTrainer(trainer);
	}

	@Override
	public Trainer getTrainerByTrainerId(long trainerId) {
		return trainerDao.getTrainer(trainerId);
	}

	@Override
	public Trainer getTrainerByEmailId(String emailId) {
		return trainerDao.getTrainer(emailId);
	}

	@Override
	public List<Trainer> getAllTrainers() {
		return trainerDao.getTrainers();
	}

	public TrainerDao getTrainerDao() {
		return trainerDao;
	}

	public void setTrainerDao(TrainerDao trainerDao) {
		this.trainerDao = trainerDao;
	}
	
	

	@Override
	public long addTrainersEducationInfo(Trainer trainer, Education education) {
		// TODO Auto-generated method stub
		return trainerDao.saveTrainersEducationInfo(trainer, education);
	}

	@Override
	public boolean editEducationInfo(Education education) {
		// TODO Auto-generated method stub
		return trainerDao.updateEducationInfo(education);
	}

	@Override
	public Education viewEducationInfo(long trainerId) {
		// TODO Auto-generated method stub
		return trainerDao.findEducationInfo(trainerId);
	}
}
