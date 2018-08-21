/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.core;

import soldier.equipment.WeaponVisitor;

public abstract class EquipmentAttack extends EquipmentAbstract {

	@Override
	public void accept(WeaponVisitor v) {
		v.visit(this);
	}

}
