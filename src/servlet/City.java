package servlet;

public class City {
	private String ime,pttBroj;

	public City(String ime, String pttBroj) {
		super();
		this.ime = ime;
		this.pttBroj = pttBroj;
	}

	public City() {
		super();
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(String pttBroj) {
		this.pttBroj = pttBroj;
	}
	
	
}
