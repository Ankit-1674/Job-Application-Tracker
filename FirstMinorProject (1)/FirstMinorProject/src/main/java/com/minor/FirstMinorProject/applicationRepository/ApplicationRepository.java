package com.minor.FirstMinorProject.applicationRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.minor.FirstMinorProject.applicationModel.ApplicationTracker;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationTracker , Integer> {
	
}
