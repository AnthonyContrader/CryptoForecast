package it.contrader.dto;

/**
 * 
 * @author team GDA
 *
 *Il DTO � simile al Model ma pu� contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "User".
 */
public class CoinDTO {
	
	private int idcoin;

	private String name;
	
	private int quotation;
	
	private String symbol;

	//costruttore senza campi
		public CoinDTO() {
		
	}
		
// costruttore senza campo idcoin
public CoinDTO(String name, int quotation, String symbol) {

		this.name = name;
		this.quotation = quotation;
		this.symbol = symbol;
	}


//costruttore con campi
	public CoinDTO(int idcoin, String name, int quotation, String symbol) {
	
		this.idcoin = idcoin;
		this.name = name;
		this.quotation = quotation;
		this.symbol = symbol;
	}

//costruttore getters and setters
	public int getId() {
		return idcoin;
	}



	public void setId(int idcoin) {
		this.idcoin = idcoin;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getQuotation() {
		return quotation;
	}



	public void setQuotation(int quotation) {
		this.quotation = quotation;
	}



	public String getSymbol() {
		return symbol;
	}



	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}



	@Override
	public String toString() {
		return  idcoin + "\t"  + name +"\t\t" +   quotation + "\t\t" + symbol;
	}
}
