/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.equipment;

import soldier.core.BehaviorExtension;
import soldier.core.BehaviorSoldier;
import soldier.core.Equipment;

public class BehaviorExtConst extends BehaviorExtension {
	private float strikeCst;
	private float paryCst;

	public BehaviorExtConst(Equipment owner, BehaviorSoldier s, float strikeCst,
			float paryCst) {
		super(owner, s);
		this.strikeCst = strikeCst;
		this.paryCst = paryCst;
	}

	@Override
	public float parry(float force) {
		return super.parry(Math.max(0, force - paryCst));
	}

	@Override
	public float strike() {
		return strikeCst + super.strike();
	}
}
