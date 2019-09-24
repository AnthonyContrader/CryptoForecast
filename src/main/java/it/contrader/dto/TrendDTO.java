package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class TrendDTO {
	
	private int idtrend;

	private String variation;
	
	private String time;
	
	private String namecoin;

	
	
	public TrendDTO() {
		
	}



	public TrendDTO(String variation, String time, String namecoin) {
	
		this.variation = variation;
		this.time = time;
		this.namecoin = namecoin;
	}
	
	
	public TrendDTO(int idtrend, String variation, String time, String namecoin) {
	
		this.idtrend = idtrend;
		this.variation = variation;
		this.time = time;
		this.namecoin = namecoin;
	}



	public int getId() {
		return idtrend;
	}



	public void setId(int idtrend) {
		this.idtrend = idtrend;
	}



	public String getVariation() {
		return variation;
	}



	public void setVariation(String variation) {
		this.variation = variation;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getNamecoin() {
		return namecoin;
	}



	public void setNamecoin(String namecoin) {
		this.namecoin = namecoin;
	}



	@Override
	public String toString() {
		return  idtrend + "\t"  + variation +"\t\t" +   time + "\t\t" + namecoin;
	}
}
