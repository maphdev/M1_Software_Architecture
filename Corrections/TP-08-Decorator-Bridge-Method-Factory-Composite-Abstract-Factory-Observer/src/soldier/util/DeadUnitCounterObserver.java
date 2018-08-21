/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.util;

import soldier.core.Unit;
import soldier.core.UnitObserver;

public class DeadUnitCounterObserver implements UnitObserver {
	private int deadUnit = 0;

	@Override
	public void update(Unit unit) {
		if (!unit.alive()) {
			++deadUnit;
			// System.out.println(unit.getName() + " is the " + deadUnit +
			// "th death, please stop war !!!");
			unit.removeObserver(this);
		}
	}

	public int getNumberOfDeadUnits() {
		return deadUnit;
	}
}