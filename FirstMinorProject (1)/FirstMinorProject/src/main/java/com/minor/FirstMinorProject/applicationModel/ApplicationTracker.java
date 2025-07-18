package com.minor.FirstMinorProject.applicationModel;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ApplicationTracker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateApplied ;
	private String companyName;
	private String positionTitle;
	private String location;
	private String appliedThrough;
	private String compensation;
	private String status;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate lastFollowUp;

}
