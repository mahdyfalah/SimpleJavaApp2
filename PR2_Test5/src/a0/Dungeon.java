package a01428941;
import java.util.*;

public class Dungeon extends Region {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4294020419359710876L;

	public Dungeon(String name, EnumSet<Npc> set) {
		super(name, set);
	}
	
	@Override
	public double regionValue() {
		return super.regionValue() + (super.regionValue() / 2);
	}
	
}
