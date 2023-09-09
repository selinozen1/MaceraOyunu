package maceraOyunu;

import java.util.Random;

public abstract class SavasAlani extends Location {
	private Canavar canavar;
	private String erzak;
	private int toplamCanavar;
	
	public SavasAlani(Oyuncu oyuncu, String isim, Canavar canavar, String erzak, int toplamCanavar) {
		super(oyuncu, isim);
		this.canavar = canavar;
		this.erzak = erzak;
		this.toplamCanavar = toplamCanavar;
	}
	
	public Canavar getCanavar() {
		return canavar;
	}

	public void setCanavar(Canavar canavar) {
		this.canavar = canavar;
	}

	public String getErzak() {
		return erzak;
	}

	public void setErzak(String erzak) {
		this.erzak = erzak;
	}

	public int getToplamCanavar() {
		return this.toplamCanavar;
	}

	public void setTotalCanavar(int toplamCanavar) {
		this.toplamCanavar = toplamCanavar;
	}

	@Override
	public boolean onLocation() {
		int canavarSayisi = this.randomCanavar();
		System.out.println("Suan bu alandasiniz --> " + this.getIsim());
		System.out.println("Dikkat ediniz, burada " + canavarSayisi + " " + this.getCanavar().getIsim() + " yasiyor!!");
		System.out.print("Savas veya kac, birini sec :");
		String durumSecme = scan.nextLine().toUpperCase();
		if(durumSecme.equals("S")) {
			if(savas(canavarSayisi)) {
				System.out.println();
				System.out.println(this.getIsim() + " lokasyonundaki tum dusmanlari yendiniz!!");
				return true;
			}
		}
		
		if(this.getOyuncu().getSaglik() <= 0) { //eşitlik olmaz ise buga giriyor
			System.out.println();
			System.out.println("Tahtali koyu boyladinizz!");
			return false;
		}
		return true;
	}
	
	public boolean savas(int canavarSayisi) {
		for(int i = 1 ; i < canavarSayisi ; i++) {
			this.getCanavar().setSaglik(this.getCanavar().getAnaSaglik());
			oyuncuIstatistigi();
			canavarIstatistigi(i);
			while(this.getOyuncu().getSaglik() > 0 && this.getCanavar().getSaglik() > 0) {
				System.out.println("Vur veya kac : ");
				String savasmaSecme = scan.nextLine().toUpperCase();
				if(savasmaSecme.equals("V")) {
					System.out.println("Siz vurdunuz!");
					this.getCanavar().setSaglik(this.getCanavar().getSaglik() - this.getOyuncu().getTotalHasar());
					afterHit();
					if(this.getCanavar().getSaglik() > 0) {
						System.out.println();
						System.out.println("Canavar size vurdu!");
						int canavarHasari = this.getCanavar().getHasar() - this.getOyuncu().getStok().getZirh().getBlok();
						if(canavarHasari < 0) {
							canavarHasari = 0;
						}
						this.getOyuncu().setSaglik(this.getOyuncu().getSaglik() - canavarHasari);
						afterHit();
					}
				}else {
					return false;
				}
			}
			
			if(this.getCanavar().getSaglik() < this.getOyuncu().getSaglik()) {
				System.out.println();
				System.out.println("Dusmani yendinizzz");
				System.out.println(this.getCanavar().getPara() + " para kazandiniz");
				this.getOyuncu().setPara(this.getOyuncu().getPara() + this.getCanavar().getPara());
				System.out.println("Guncel paraniz : " + this.getOyuncu().getPara());
			}else {
				return false;
			}
		}
		return true;
	}
	
	public void afterHit() {
		System.out.println("Caniniz : " + this.getOyuncu().getSaglik());
		System.out.println(this.getCanavar().getIsim() + " cani : " + this.getCanavar().getSaglik());
	}
	
	public void oyuncuIstatistigi() {
		System.out.println();
		System.out.println("OYUNCU DEGERLERI");
		System.out.println("----------------");
		System.out.println("Saglik : " + this.getOyuncu().getSaglik());
		System.out.println("Silah : " + this.getOyuncu().getSilah().getIsim());
		System.out.println("Hasar : " + this.getOyuncu().getTotalHasar());
		System.out.println("Zirh : " + this.getOyuncu().getZirh().getIsim());
		System.out.println("Bloklama : " + this.getOyuncu().getStok().getZirh().getBlok());
		System.out.println("Para : " + this.getOyuncu().getPara());
	
	}
	
	public void canavarIstatistigi(int i) {
		System.out.println();
		System.out.println(i + "." + this.getCanavar().getIsim() + " degerleri");
		System.out.println("----------------");
		System.out.println("Saglik : " + this.getCanavar().getSaglik());
		System.out.println("Hasar : " + this.getCanavar().getHasar());
		System.out.println("Para : " + this.getCanavar().getPara());
	}
	
	public int randomCanavar() {
		Random rand = new Random();
		return rand.nextInt(this.getToplamCanavar()) + 1;
	}
	

}
