package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CoinDTO {

	private Long id;

	private String namecoin;

	private int price;

	private int circulating;

}