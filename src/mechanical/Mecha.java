package mechanical;

import java.util.HashMap;

public class Mecha {
	
	String name="DEFAULT";
	
	public HashMap<String,MechSystem> systems = new HashMap<String,MechSystem>();

	@Override
	public String toString() {
		String result = "Mecha "+name+" with the systems: \n";
		for (String e:systems.keySet()){
			result += e+" : "+systems.get(e).toString()+"\n";
		}
		result += "\n";
		return result;
	}

	public double getTotalWeight() {
		double result = 0;
		for (String e:systems.keySet()){
			result += systems.get(e).weight;
		}
		return result;
	}
	
	
	

}
