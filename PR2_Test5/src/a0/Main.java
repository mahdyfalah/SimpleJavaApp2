package a01428941;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
	//Aufgabe 1:
		Region kolnir = new Region("Kolnir", EnumSet.of(Npc.TiluaPflanze,Npc.Sandgeist));
		Dungeon festung = new Dungeon("Festung", EnumSet.of(Npc.Ektofron,Npc.Blattalsik,Npc.Undaron));
		
		System.out.println(kolnir);
		System.out.println(festung);
	//Aufgabe 2
		Region terbat = new Region("Terbat", EnumSet.of(Npc.Blattalsik,Npc.Sandgeist,Npc.Ektofron));
		Region anatubien = new Region("Anatubien", EnumSet.of(Npc.Blattalsik));
		Region tanien = new Region("Tanien", EnumSet.of(Npc.Undaron,Npc.TiluaPflanze));
		
		final List<Region> list = new ArrayList<Region>();
		list.add(kolnir);
		list.add(festung);
		list.add(terbat);
		list.add(anatubien);
		list.add(tanien);
		
		//output
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("fw.sr"))){
			out.writeObject(list);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		//Input
		List<Region> fwList = new ArrayList<Region>();
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("fw.sr"))){
			fwList = (ArrayList<Region>) in.readObject();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("***********list after read************");
		for(Region r : fwList)
			System.out.println(r);
		
		Collections.shuffle(fwList);
		System.out.println("***********list after shuffle************");
		for(Region r : fwList)
			System.out.println(r);
	//Aufgabe 3
		Map<Npc, List<Region>> map = new HashMap<Npc, List<Region>>();
		for(Region r : fwList) {
			Iterator<Npc> it = r.getSet().iterator();
			while(it.hasNext()) {
				Npc key = it.next();
				if(!map.containsKey(key)) {
					map.put(key, new ArrayList<Region>());
					map.get(key).add(r);
				}else {
					map.get(key).add(r);
				}
			}
		}
		
		System.out.println("***********map************");
		for(Map.Entry<Npc, List<Region>> me : map.entrySet()) {
			System.out.println("Key : " + me.getKey());
			for(Region r : me.getValue()) {
				System.out.println("    " + r);
			}
		}
		
		System.out.println("***********map after sort************");
		for(Map.Entry<Npc, List<Region>> me : map.entrySet()) {
			Collections.sort(me.getValue(), Comparator.comparing(Region::regionValue));
		}
		
		for(Map.Entry<Npc, List<Region>> me : map.entrySet()) {
			System.out.println("Key : " + me.getKey());
			for(Region r : me.getValue()) {
				System.out.println("    " + r);
			}
		}
		
	}
}
