package maceraOyunu;

import java.util.Scanner;

public class Oyuncu {
	private int id;
	private int hasar;
	private int saglik;
	private int anaSaglik;
	private int para;
	private String isim;
	private String karakterIsmi;
	private Scanner scan = new Scanner(System.in);
	private Stok stok;
	
	public Oyuncu(String isim) {
		this.isim = isim;
		this.stok = new Stok(null);
	}
	
	public Oyuncu() {
	}
	
	public int getTotalHasar() {
		return this.hasar + this.getStok().getSilah().getHasar();
	}

	public int getHasar() {
		return this.hasar;
	}
	
	public void setHasar(int hasar) {
		this.hasar = hasar;
	}
	
	public int getSaglik() {
		return this.saglik;
	}
	
	public void setSaglik(int saglik) {
		this.saglik = saglik;
	}
	
	public int getAnaSaglik() {
		return this.anaSaglik;
	}

	public void setAnaSaglik(int anaSaglik) {
		this.anaSaglik = anaSaglik;
	}

	public int getPara() {
		return this.para;
	}
	
	public void setPara(int para) {
		this.para = para;
	}
	
	public String getIsim() {
		return this.isim;
	}
	
	public void setIsim(String isim) {
		this.isim = isim;
	}
	
	public String getKarakterIsmi() {
		return this.karakterIsmi;
	}
	
	public void setKarakterIsmi(String karakterIsmi) {
		this.karakterIsmi = karakterIsmi;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Stok getStok() {
		return stok;
	}

	public void setStok(Stok stok) {
		this.stok = stok;
	}
	
	public Silahlar getSilah() {
		return this.getStok().getSilah();
	}
	
	public Zirhlar getZirh() {
		return this.getStok().getZirh();
	}

	public void karakterSecme() {
		Karakter[] list = {new Samuray("Samuray", 7, 20, 50, 1), new Okcu("Okcu", 9, 18, 40, 2), new Sovalye("Sovalye", 5, 14, 25, 3)};
		System.out.println();
		System.out.println("KARAKTERLER");
		for(Karakter k : list) {
			System.out.println("Id : " + k.getId() + "\tKarakter => " + k.getIsim() +
					"   \t Hasar : " + k.getHasar() +  
					"\t Saglik : " + k.getSaglik() + 
					"\t Para : " + k.getPara());
		}
	
		
		System.out.println();
		System.out.print("Bir karakter seciniz : ");
		int karakterSecme = scan.nextInt();
		switch(karakterSecme) {
		case 1:
			oyuncu(new Samuray("Samuray", 7, 20, 50, 1));
			break;
		case 2:
			oyuncu(new Okcu("Okcu", 9, 18, 40, 2));
			break;
		case 3:
			oyuncu(new Sovalye("Sovalye", 5, 14, 25, 3));
			break;
			default:
				oyuncu(new Okcu("Okcu", 9, 18, 17, 2));
		}
		System.out.println("Secilen karakter " + this.getKarakterIsmi() + ". \nOyunda basarilar dileriz!");
		System.out.println();
	}

	private void oyuncu(Karakter karakter) {
		this.setHasar(karakter.getHasar());
		this.setSaglik(karakter.getSaglik());
		this.setAnaSaglik(karakter.getSaglik());
		this.setPara(karakter.getPara());
		this.setKarakterIsmi(karakter.getIsim());
	}
	
	public void printInfo() {
		System.out.println();
		System.out.println(
				"Silahiniz : " + this.getStok().getSilah().getIsim() +
				", Zirh : " + this.getStok().getZirh().getIsim() +
				", Blok : " + this.getStok().getZirh().getBlok() + 
				", Hasariniz : " + this.getTotalHasar() +
				", Saglik : " + this.getSaglik() + 
				", Para : " + this.getPara());
	}
	
	
}
	

