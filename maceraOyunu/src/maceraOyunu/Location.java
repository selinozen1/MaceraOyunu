package maceraOyunu;

import java.util.Scanner;

public  abstract class Location {
	private Oyuncu oyuncu;
	private String isim;
	protected Scanner scan = new Scanner(System.in);
	
	public Location(Oyuncu oyuncu, String isim) {
		this.oyuncu = oyuncu;
		this.isim = isim;
	}

	public Oyuncu getOyuncu() {
		return this.oyuncu;
	}

	public void setOyuncu(Oyuncu oyuncu) {
		this.oyuncu = oyuncu;
	}

	public String getIsim() {
		return this.isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}
	
	 public abstract boolean onLocation();
	
	
	

}
