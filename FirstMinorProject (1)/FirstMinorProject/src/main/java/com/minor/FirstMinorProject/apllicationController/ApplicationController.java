package com.minor.FirstMinorProject.apllicationController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.minor.FirstMinorProject.applicationModel.ApplicationTracker;
import com.minor.FirstMinorProject.applicationService.ApplicationService;

@Controller
public class ApplicationController {
	@Autowired 
	ApplicationService ApplicationService;
	@RequestMapping("/getAllApplication")
	public String getAllApplication(Model model) {
	List<ApplicationTracker> Applications = ApplicationService.getAll();
	model.addAttribute("Applications",Applications);
	return "AllApplications" ;
		
	}
	@PostMapping("/addApplication")
	public ApplicationTracker addByRequestBody( @PathVariable int ApplicationId ,@ModelAttribute ApplicationTracker curr) {
	ApplicationTracker toAdd = ApplicationService.addThis(curr);
	return toAdd;
	}
	
	@RequestMapping("/addProductForm")
	public String addProductForm(Model model) {
		ApplicationTracker newApplication = new ApplicationTracker();
		model.addAttribute("Application",newApplication);
		return "AddApplicationForm";
	}
	
	@DeleteMapping("/deleteApplication/{ApplicationId}")
	public ResponseEntity<ApplicationTracker> deleteThis(@PathVariable int ApplicationId){
	return new ResponseEntity<ApplicationTracker>(ApplicationService.deleteThis(ApplicationId),HttpStatus.ACCEPTED);
	}
	@RequestMapping("/updateApplicationForm/{ApplicationId}")
	public String updateProductForm(@PathVariable int ApplicationId , Model model) {
	ApplicationTracker fetchedApplication =	ApplicationService.getThis(ApplicationId);
	model.addAttribute("Application",fetchedApplication);
	return "UpdateApplicationForm";
	}
	
	@PostMapping("/updateApplication/{ApplicationId}")
	public ResponseEntity<ApplicationTracker> updateApplication(@PathVariable int ApplicationId , @RequestBody ApplicationTracker newValue) {
	  return new ResponseEntity<ApplicationTracker>	(ApplicationService.updateThis(ApplicationId, newValue) , HttpStatus.ACCEPTED);
	}

}
