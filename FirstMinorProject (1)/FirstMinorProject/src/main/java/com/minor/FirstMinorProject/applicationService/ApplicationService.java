package com.minor.FirstMinorProject.applicationService;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import com.minor.FirstMinorProject.applicationModel.ApplicationTracker;
import com.minor.FirstMinorProject.applicationRepository.ApplicationRepository;

@Service
public class ApplicationService {
	@Autowired
	ApplicationRepository AppRepo;

	public ApplicationTracker addThis(ApplicationTracker newValue) {
		ApplicationTracker toBeUpdated =  new ApplicationTracker();
		toBeUpdated.setAppliedThrough(newValue.getAppliedThrough());
		toBeUpdated.setCompanyName(newValue.getCompanyName());
		toBeUpdated.setCompensation(newValue.getCompensation());
		toBeUpdated.setDateApplied(newValue.getDateApplied());
		toBeUpdated.setLastFollowUp(newValue.getLastFollowUp());
		toBeUpdated.setLocation(newValue.getLocation());
		toBeUpdated.setPositionTitle(newValue.getPositionTitle());
		toBeUpdated.setStatus(newValue.getStatus());
	    return	AppRepo.save(toBeUpdated);
	
	}
	public List<ApplicationTracker> getAll() {
		return AppRepo.findAll();
	}
	public ApplicationTracker deleteThis(int id) {
		AppRepo.deleteById(id);
		return null;
	}
	public ApplicationTracker getThis(int applicationId) {
		// TODO Auto-generated method stub
		return AppRepo.findById(applicationId).get();
		
	}
	public  ApplicationTracker updateThis(int id , ApplicationTracker newValue) {
		// TODO Auto-generated method stub
		 ApplicationTracker toUpdate = getThis(id);
		 ApplicationTracker.builder().lastFollowUp(newValue.getLastFollowUp())
		 .location(newValue.getLocation())
		 .positionTitle(newValue.getPositionTitle())
		 .appliedThrough(newValue.getAppliedThrough())
		 .companyName(newValue.getCompanyName())
		 .compensation(newValue.getCompensation())
		 .status(newValue.getStatus())
		 .dateApplied(newValue.getDateApplied())
		 .build();
		
		return AppRepo.save(toUpdate);
	}

}
