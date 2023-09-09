package maceraOyunu;

public  class GuvenliEv extends NormalLocation {
	public GuvenliEv(Oyuncu oyuncu) {
		super(oyuncu, "Guvenli ev");
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Guvenli evdesiniz.");
		System.out.println("Canlariniz yenilendi.");
		this.getOyuncu().setSaglik(this.getOyuncu().getAnaSaglik());
		return true;
	}

}
