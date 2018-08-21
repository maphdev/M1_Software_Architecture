/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.core;

import java.util.Iterator;

public abstract class UnitSimple {

	private BehaviorSoldier behavior;
	private String name;

	public UnitSimple(String name, BehaviorSoldier behavior) {
		this.behavior = behavior;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public float getHealthPoints() {
		return behavior.getHealthPoints();
	}

	public boolean alive() {
		return behavior.alive();
	}

	public void heal() {
		behavior.heal();
	}

	public float parry(float force) {
		float result = behavior.parry(force);
		return result;
	}

	public float strike() {
		float result = behavior.strike();
		return result;
	}

	public void addEquipment(Equipment w) {
		behavior = w.createExtension(behavior);
	}

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

	public Iterator<Equipment> getWeapons() {
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

	public int nbWeapons() {
		int result = 0;
		for (Iterator<Equipment> it = getWeapons(); it.hasNext(); it.next())
			++result;
		return result;
	}
}
