/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.ages;

import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.equipment.WeaponShield;
import soldier.equipment.WeaponSword;
import soldier.core.Equipment;
import soldier.units.UnitCenturion;
import soldier.units.UnitHorseMan;

public class AgeMiddleFactory implements AgeAbstractFactory {

	@Override
	public Unit infantryUnit(String name) {
		return new UnitCenturion(name);
	}

	@Override
	public Unit riderUnit(String name) {
		return new UnitHorseMan(name);
	}

	@Override
	public Equipment attackWeapon() {
		return new WeaponSword();
	}

	@Override
	public Equipment defenseWeapon() {
		return new WeaponShield();
	}
}
