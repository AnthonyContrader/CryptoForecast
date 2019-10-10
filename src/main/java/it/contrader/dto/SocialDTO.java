package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SocialDTO {

	private Long id;
	private int reddit;
	private int telegram;
	private int likefb;
	private int twitter;
	
	private CoinDTO coinDTO;

	

}