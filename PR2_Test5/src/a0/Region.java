package a01428941;
import java.util.*;
import java.io.*;

public class Region implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2543662140996137323L;
	private String name;
	private EnumSet<Npc> set;
	
	public Region(String name, EnumSet<Npc> set) {
		if(name == null || set.isEmpty()) {
			throw new IllegalArgumentException("werte beachten!");
		}
		this.name = name;
		this.set = set;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EnumSet<Npc> getSet() {
		return set;
	}
	public void setSet(EnumSet<Npc> set) {
		this.set = set;
	}
	
	public double regionValue() {
		double temp = 0;
		Iterator<Npc> it = set.iterator();
		while(it.hasNext()) {
			temp += it.next().value();
		}
		return temp;
	}
	
	@Override
	public String toString() {
		return this.name + ": " + this.regionValue();
	}
}
