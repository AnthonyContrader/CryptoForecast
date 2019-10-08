package it.contrader.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrendDTO {

	private Long id;

	private int variation;

	private String date;
	
	private Long idcoin;

	

}
