package maceraOyunu;

public abstract class NormalLocation extends Location {
	public NormalLocation(Oyuncu oyuncu, String isim) {
		super(oyuncu, isim);
		
	}
	public abstract boolean onLocation();

	

}
