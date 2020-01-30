package a01428941;

public enum Npc {
	TiluaPflanze(30, 7),Blattalsik(1, 1),Ektofron(42, 2),Sandgeist(12, 1),Undaron(30, 3);
	
	private int Gold;
	private int Erfahrung;
	
	Npc(int Gold, int Erfahrung){
		this.Gold = Gold;
		this.Erfahrung = Erfahrung;
	}
	
	public int value() {
		return this.Gold + this.Erfahrung;
	}
	
	@Override
	public String toString() {
		return this.name();
	}
}
