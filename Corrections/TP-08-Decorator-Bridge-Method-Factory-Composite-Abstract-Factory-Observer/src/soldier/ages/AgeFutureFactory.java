/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.ages;

import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.equipment.WeaponGun;
import soldier.equipment.WeaponShield;
import soldier.core.Equipment;
import soldier.units.UnitBikerMan;
import soldier.units.UnitRobot;

public class AgeFutureFactory implements AgeAbstractFactory {

	@Override
	public Unit infantryUnit(String name) {
		return new UnitRobot(name);
	}

	@Override
	public Unit riderUnit(String name) {
		return new UnitBikerMan(name);
	}

	@Override
	public Equipment attackWeapon() {
		return new WeaponGun();
	}

	@Override
	public Equipment defenseWeapon() {
		return new WeaponShield();
	}
}
