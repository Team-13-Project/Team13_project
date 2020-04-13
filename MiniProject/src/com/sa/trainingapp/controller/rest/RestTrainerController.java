package com.sa.trainingapp.controller.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sa.trainingapp.beans.Education;
import com.sa.trainingapp.beans.Trainer;
import com.sa.trainingapp.service.TrainerService;
import com.sa.trainingapp.service.impl.TrainerServiceImpl;

@Path("/trainers")
public class RestTrainerController {
	private TrainerService service;
	
	public RestTrainerController() {
		this.service = new TrainerServiceImpl();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Trainer> getTrainers() {
		return service.getAllTrainers();
	}
	
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Trainer getTrainerById(@PathParam("id") long id) {
		return service.getTrainerByTrainerId(id);
	}
	
	@GET
	@Path("/email/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Trainer getTrainerByEmail(@PathParam("email") String email) {
		return service.getTrainerByEmailId(email);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Trainer addTrainer(Trainer trainer) {
		System.out.println("Got post request data + " + trainer);
		service.addTrainer(trainer);
		return trainer;
	}
	
	
	//this is for adding the education
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Education addTrainersEducationInfo(Trainer trainer, Education education) {
		System.out.println("Got post request data + " + trainer +" "+ education);
		service.addTrainersEducationInfo(trainer, education);
		return education;
	}
	
	
	//this is for editing the education
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Education editEducationInfo(Education education) {
		System.out.println("Got post request data + " + education);
		service.editEducationInfo(education);
		return education;
	}
	
	//this is for viewing the education
	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Education viewEducationInfo(@PathParam("id")long id) {
		return service.viewEducationInfo(id);
	}
}
