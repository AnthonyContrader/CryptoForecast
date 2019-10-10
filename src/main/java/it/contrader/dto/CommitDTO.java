package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CommitDTO {

	private Long id;
	private int stars;
	private int fork;
	private int watcher;
	private int collaborators;
	private int number;
	
	private CoinDTO coinDTO;
	

}