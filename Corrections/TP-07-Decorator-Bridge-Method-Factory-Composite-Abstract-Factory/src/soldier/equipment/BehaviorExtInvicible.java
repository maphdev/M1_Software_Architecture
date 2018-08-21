/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.equipment;

import soldier.core.BehaviorExtension;
import soldier.core.BehaviorSoldier;
import soldier.core.Equipment;

public class BehaviorExtInvicible extends BehaviorExtension {
	public BehaviorExtInvicible(Equipment owner, BehaviorSoldier s) {
		super(owner, s);
	}

	@Override
	public float parry(float force) {
		return super.parry(0);
	}
}
