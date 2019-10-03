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
public class CommitDTO {
	
	private int id;

	private String namecoin;
	
	private int number;
	
	private String data;

	//costruttore senza campi
		public CommitDTO() {
		
	}
		
		
		
// costruttore senza campo idcoin
public CommitDTO(String namecoin, int number, String data) {

		this.namecoin = namecoin;
		this.number = number;
		this.data = data;
	}


//costruttore con campi
	public CommitDTO(int id, String namecoin, int number, String data) {
	
		this.id = id;
		this.namecoin = namecoin;
		this.number = number;
		this.data = data;
	}

//costruttore getters and setters
	public int getId() {
		return this.id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNamecoin() {
		return this.namecoin;
	}



	public void setNamecoin(String namecoin) {
		this.namecoin = namecoin;
	}



	public int getNumber() {
		return this.number;
	}


	public void setNumber(int number) {
		this.number = number;
	}
	



	public String getData() {
		return this.data;
	}


	public void setData(String data) {
		this.data = data;
	}






	@Override
	public String toString() {
		return  id + "\t"  + namecoin +"\t\t" +   number + "\t\t" + data;
	}
}
