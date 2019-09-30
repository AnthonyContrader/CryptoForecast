package it.contrader.dto;

/**
 * 
 * @author team GDA
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class TrendDTO {
	
	private int idtrend;
	private String time;
	private int variation;
	private String namecoin;

	
	
	public TrendDTO() {
		
	}



	public TrendDTO(String time, int variation, String namecoin) {
	
		this.time = time;
		this.variation = variation;
		this.namecoin = namecoin;
	}
	
	
	public TrendDTO(int idtrend, String time, int variation, String namecoin) {
	
		this.idtrend = idtrend;
		this.time = time;
		this.variation = variation;
		this.namecoin = namecoin;
	}



	public int getId() {
		return idtrend;
	}



	public void setId(int idtrend) {
		this.idtrend = idtrend;
	}

	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}

	public int getVariation() {
		return variation;
	}



	public void setVariation(int variation) {
		this.variation = variation;
	}




	public String getNamecoin() {
		return namecoin;
	}



	public void setNamecoin(String namecoin) {
		this.namecoin = namecoin;
	}



	@Override
	public String toString() {
		return  idtrend + "\t"  + time +"\t\t" +   variation + "\t\t" + namecoin;
	}
}
