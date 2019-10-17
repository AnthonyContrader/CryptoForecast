package it.contrader.dto;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

public class CoinDTO {

	private Long id;

	private String namecoin;

	private int price;

	private int circulating;
	
	private String symbol;
	
	/*private List<TrendDTO> trendsDTO;
	
	private List<CommitDTO> commitsDTO;
	
	private List<SocialDTO> socialsDTO; 
	*/
	

	

}