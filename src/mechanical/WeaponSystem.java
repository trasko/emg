package mechanical;

public class WeaponSystem extends MechSystem {
	private static final long serialVersionUID = 231793468536262108L;
	
	/**
	 * @param description
	 * @param weight
	 * @param size
	 * @param state
	 * @param heat
	 * @param dmgChunk
	 * @param dmgFreq
	 */
	public WeaponSystem(Mecha installedIn, String description, double weight, double size,
			double state, double heat, double dmgChunk, double dmgFreq) {
		super(installedIn,description, weight, size, state, heat);
		this.dmgChunk = dmgChunk;
		this.dmgFreq = dmgFreq;
	}

	double dmgChunk;
	double dmgFreq;

	public String getKind() {
		return "weap";
	}
}
