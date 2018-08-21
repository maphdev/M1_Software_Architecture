/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.core;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class UnitGroup extends UnitObservableAbstract {

	private Set<Unit> units;
	private String name;

	public UnitGroup(String name) {
		this.name = name;
		units = new TreeSet<Unit>(new Comparator<Unit>() {
			@Override
			public int compare(Unit o1, Unit o2) {
				if (o1.getName().compareTo(o2.getName()) == 0)
					return o1.hashCode() - o2.hashCode();
				else
					return o1.getName().compareTo(o2.getName());
			}
		});
	}

	@Override
	public void addUnit(Unit au) {
		units.add(au);
	}

	@Override
	public void removeUnit(Unit au) {
		units.remove(au);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getHealthPoints() {
		float sum = 0.f;
		for (Unit u : units)
			sum += u.getHealthPoints();
		return sum;
	}

	@Override
	public boolean alive() {
		return getHealthPoints() > 0.f;
	}

	@Override
	public void heal() {
		for (Unit u : units)
			u.heal();
	}

	@Override
	public float parry(float force) {
		while(alive() && force > 0) {

			float nbUnits = 0.f;
			for(Unit u : units)
				if (u.alive()) ++nbUnits;

			float toParry = force / nbUnits;
			force = 0.f;
			for(Unit u : units) {
				if (!u.alive()) continue;
				force += u.parry(toParry);
			}
		}
		return force;
	}
	
	@Override
	public float strike() {
		float sum = 0;
		for (Unit u : units) {
			if (u.alive())
				sum += u.strike();
		}
		return sum;
	}

	@Override
	public Iterator<Unit> subUnits() {
		return units.iterator();
	}

	@Override
	public Iterator<Equipment> getEquipments() {
		if (units.isEmpty())
			return Collections.emptyIterator();
		return new Iterator<Equipment>() {
			Iterator<Unit> itUnit = subUnits();
			Iterator<Equipment> curIt = itUnit.next().getEquipments();

			@Override
			public boolean hasNext() {
				while (!curIt.hasNext() && itUnit.hasNext())
					curIt = itUnit.next().getEquipments();
				return curIt.hasNext();
			}

			@Override
			public Equipment next() {
				return curIt.next();
			}
		};
	}

	/**
	 * Attach the equipment to the first Unit that can get it.
	 */
	@Override
	public void addEquipment(Equipment w) {
		Iterator<Unit> it = subUnits();
		while (it.hasNext()) {
			Unit u = it.next();
			try {
				u.addEquipment(w);
				return;
			} catch (EquipmentException b) {
				if (!it.hasNext())
					throw b;
			}
		}
	}

	@Override
	public void removeEquipment(Equipment w) {
		for (Iterator<Unit> it = subUnits(); it.hasNext(); it.next()
				.removeEquipment(w)) {
		}
	}
 
}
