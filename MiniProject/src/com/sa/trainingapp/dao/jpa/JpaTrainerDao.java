package com.sa.trainingapp.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sa.trainingapp.beans.Education;
import com.sa.trainingapp.beans.Trainer;
import com.sa.trainingapp.dao.TrainerDao;
import com.sa.trainingapp.dao.util.JpaUtil;

public class JpaTrainerDao implements TrainerDao {

	@Override
	public long saveTrainer(Trainer trainer) {
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();
		
		// Begin Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		// Save / Persist User
		em.persist(trainer);
		
		// Commit Transaction
		et.commit();
		
		// Close the Manager
		em.close();
		
		return trainer.getTrainerId();
	}

	@Override
	public boolean updateTrainer(Trainer trainer) {
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();
		
		// Begin Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		// Save / Persist User
		Trainer persistentTrainer = em.find(Trainer.class, trainer.getTrainerId());
		persistentTrainer.setFullName(trainer.getFullName());
		persistentTrainer.setEmailId(trainer.getEmailId());
		persistentTrainer.setAge(trainer.getAge());
		persistentTrainer.setYearlyTarget(trainer.getYearlyTarget());
		
		// Commit Transaction
		et.commit();
		
		// Close the Manager
		em.close();
		
		return true;
	}

	@Override
	public Trainer getTrainer(long trainerId) {
		Trainer persistentTrainer = null;
		
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();
		
		// Query for trainer_id
		persistentTrainer = em.find(Trainer.class, trainerId);
		
		// Close the Manager
		em.close(); 
		
		// Return the trainer details
		return persistentTrainer;
	}

	@Override
	public Trainer getTrainer(String email) {
		Trainer trainer = null;
		
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();
		
		// Query for email id
		Query query = em.createQuery("select t from Trainer t where t.emailId =:trainerEmailId", Trainer.class);
		
		// Execute the statement
		query.setParameter("trainerEmailId", email);
		List<Trainer> trainers = query.getResultList();
		
		// If list is empty, then assign null
		trainer = ((trainers.size() == 0) ? null : trainers.get(0));
		
		// Close the Manager
		em.close(); 
		
		// Return the trainer
		return trainer;
	}

	@Override
	public List<Trainer> getTrainers() {
		List<Trainer> trainers = null;
		
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();
		
		// Query for user_id
		TypedQuery<Trainer> query = em.createQuery("select t from Trainer t", Trainer.class);
		
		// Execute the statement
		trainers = query.getResultList();
		
		// Close the Manager
		em.close(); 
		
		// Return trainers
		return trainers;
	}

	@Override
	public long saveTrainersEducationInfo(Trainer trainer, Education education) {
		Trainer trainer1 = null;

		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Begin Transaction
		EntityTransaction et = em.getTransaction();
		et.begin();

		// Save / Persist Education
		em.persist(education);

		// to find the details trainer details by using trainer id
		trainer1 = em.find(Trainer.class, trainer.getTrainerId());

		// to find the details education details by using education id
		Education education1 = em.find(Education.class, education.getEducationId());

		// setting the education to the trainer1
		trainer1.setEducation(education1);

		et.commit();
		em.close();

		// returning the educationId
		return education.getEducationId();
	}

	@Override
	public boolean updateEducationInfo(Education education) {
		// Get Entity Manager
				EntityManager em = JpaUtil.getEntityManager();

				// Begin Transaction
				EntityTransaction et = em.getTransaction();
				et.begin();

				// Save / Persist Education
				Education existingEducation = em.find(Education.class, education.getEducationId());

				// setting the updated data to the education
				existingEducation.setInstituteName(education.getInstituteName());
				existingEducation.setDegree(education.getDegree());
				existingEducation.setSpecialization(education.getSpecialization());
				existingEducation.setStartYear(education.getStartYear());
				existingEducation.setEndYear(education.getEndYear());
				existingEducation.setCourseDuration(education.getCourseDuration());
				existingEducation.setBoard(education.getBoard());
				existingEducation.setPercentage(education.getPercentage());
				existingEducation.setCity(education.getCity());
				existingEducation.setState(education.getState());
				existingEducation.setCountry(education.getCountry());

				// Commit Transaction
				et.commit();

				// Close the Manager
				em.close();
				return true;
	}

	@Override
	public Education findEducationInfo(long trainerId) 
	{
		Education education = null;
		// Get Entity Manager
		EntityManager em = JpaUtil.getEntityManager();

		// Executing the query
		Query query = em.createQuery("select e from Trainer t inner join Education e "
				+ " on e.educationId = t.education.educationId where t.trainerId =:trainersId");

		// setting the query
		query.setParameter("trainersId", trainerId);

		//it will get the result of the query
		List<Education> educations = query.getResultList();

		// If list is empty, then assign null
		education = ((educations.size() == 0) ? null : educations.get(0));

		// Close the Manager
		em.close();

		return education;
	}

}
