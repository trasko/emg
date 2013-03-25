package mechanical;

import java.io.Serializable;

public class MechSystem implements Serializable {
	private static final long serialVersionUID = -4916280253450994712L;
	
	/**
	 * @param description the name
	 * @param weight the weight
	 * @param size how big
	 * @param state in hitpoints
	 * @param heat in Kelvin
	 */
	public MechSystem(Mecha installedIn,String description, double weight, double size,
			double state, double heat) {
		super();
		this.description = description;
		this.weight = weight;
		this.size = size;
		this.state = state;
		this.heat = heat;
		this.installedIn = installedIn;
	}

	@Override
	public String toString() {
		return description + ":\n weight=" + weight
				+ ",\n size=" + size + ",\n state=" + state + ",\n heat=" + heat;
	}

	String description;
	double weight;
	double size;
	double state;
	double heat;
	Mecha installedIn;
	
	public String getKind() {
		return "base";
	}
	
}
