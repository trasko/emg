package mechanical;

public class MovementSystem extends MechSystem {
	private static final long serialVersionUID = 9049359035298270433L;
	
	/**
	 * @param description
	 * @param weight
	 * @param size
	 * @param state
	 * @param heat
	 * @param speed
	 * @param weightcap
	 * @param speedlossPerWeight
	 */
	public MovementSystem(Mecha installedIn,String description, double weight, double size,
			double state, double heat, double speed, double weightcap,
			double speedlossPerWeight) {
		super(installedIn, description, weight, size, state, heat);
		this.speed = speed;
		this.weightcap = weightcap;
		this.speedlossPerWeight = speedlossPerWeight;
	}

	double speed;
	double weightcap;
	double speedlossPerWeight;

	public String getKind() {
		return "move";
	}
	
	public double getCurrentSpeed(double atThisWeight){
		double tmp;
		tmp = atThisWeight- weightcap;
		if (tmp> 0){
			tmp = speed-tmp*speedlossPerWeight;
		}
		else tmp = speed;
		
		if (tmp< 0){
			tmp = 0;
		}
		
		return tmp;
	}

	@Override
	public String toString() {
		return super.toString()+",\n topspeed=" + speed + ",\n weightcap=" + weightcap
				+ ",\n lost speed per additional weight unit=" + speedlossPerWeight
				+ ",\n currently reachable due to load="+getCurrentSpeed(installedIn.getTotalWeight());
	}
}
