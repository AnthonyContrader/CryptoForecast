package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

public class CommitDTO {

	private Long id;
	private String date;
	private int stars;
	private int fork;
	private int watcher;
	private int collaborators;
	private int number;
	
	private CoinDTO coinDTO;
	

}