/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.core;

import java.util.Collections;
import java.util.Iterator;

public abstract class UnitSimple extends UnitObservableAbstract {

	private BehaviorSoldier behavior;
	private String name;

	public UnitSimple(String name, BehaviorSoldier behavior) {
		this.behavior = behavior;
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getHealthPoints() {
		return behavior.getHealthPoints();
	}

	@Override
	public boolean alive() {
		return behavior.alive();
	}

	@Override
	public void heal() {
		behavior.heal();
	}

	@Override
	public float parry(float force) {
		float result = behavior.parry(force);
		notifyObservers();
		return result;
	}

	@Override
	public float strike() {
		float result = behavior.strike();
		return result;
	}

	@Override
	public void addEquipment(Equipment w) {
		behavior = w.createExtension(behavior);
	}

	@Override
	public void removeEquipment(Equipment w) {
		BehaviorSoldier current = behavior;
		BehaviorSoldier previous = behavior;
		while (current instanceof BehaviorExtension
				&& ((BehaviorExtension) current).getOwner() != w) {
			previous = current;
			current = ((BehaviorExtension) current).parent();
		}
		if (((BehaviorExtension) current).getOwner() == w) {
			((BehaviorExtension) previous)
					.reparent(((BehaviorExtension) previous).parent());
		}
	}

	@Override
	public Iterator<Equipment> getEquipments() {
		return new Iterator<Equipment>() {
			BehaviorSoldier current = behavior;

			@Override
			public boolean hasNext() {
				return current instanceof BehaviorExtension;
			}

			@Override
			public Equipment next() {
				Equipment tmp = ((BehaviorExtension) current).getOwner();
				current = ((BehaviorExtension) current).parent();
				return tmp;
			}
		};
	}

	@Override
	final public Iterator<Unit> subUnits() {
		return Collections.emptyIterator();
	}

	@Override
	final public void addUnit(Unit au) {
		throw new UnsupportedOperationException();
	}

	@Override
	final public void removeUnit(Unit au) {
	}

	public int nbWeapons() {
		int result = 0;
		for (Iterator<Equipment> it = getEquipments(); it.hasNext(); it.next())
			++result;
		return result;
	}
}
