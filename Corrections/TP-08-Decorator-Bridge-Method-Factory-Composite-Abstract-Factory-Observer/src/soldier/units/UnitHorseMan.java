/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.units;

import soldier.core.Equipment;
import soldier.core.EquipmentException;
import soldier.core.UnitRider;

public class UnitHorseMan extends UnitRider {

	public UnitHorseMan(String soldierName) {
		super(soldierName, new BehaviorSoldierStd(20, 120));
	}

	/**
	 * A HorseMan can only have two equipments, and one of each kind
	 */
	@Override
	public void addEquipment(Equipment w) {
		int nbW = nbWeapons();
		if (nbW > 1)
			throw new EquipmentException();
		if (nbW == 1 && getEquipments().next().getClass() == w.getClass())
			throw new EquipmentException();
		super.addEquipment(w);
	}

}
