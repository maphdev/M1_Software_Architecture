/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.units;

import soldier.core.EquipmentException;
import soldier.core.UnitInfantry;
import soldier.core.Equipment;

public class UnitCenturion extends UnitInfantry {

	public UnitCenturion(String soldierName) {
		super(soldierName, new BehaviorSoldierStd(200, 50));
	}

	/**
	 * A Centurion can have at most two equipments
	 */
	@Override
	public void addEquipment(Equipment w) {
		if (nbWeapons() > 1)
			throw new EquipmentException();
		super.addEquipment(w);
	}

}
