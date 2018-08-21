/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.core;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class UnitObservableAbstract implements Unit {
	private List<UnitObserver> observersOrdered = new LinkedList<UnitObserver>();
	private Set<UnitObserver> observersSet = new HashSet<UnitObserver>();

	@Override
	public void addObserver(UnitObserver obs) {
		if (!observersSet.contains(obs)) {
			observersOrdered.add(obs);
			observersSet.add(obs);
		}
	}

	@Override
	public void removeObserver(UnitObserver obs) {
		observersOrdered.remove(obs);
		observersSet.remove(obs);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void notifyObservers() {
		Object[] copy = observersOrdered.toArray();
		for (Object u : copy)
			((UnitObserver) u).update(this);
	}
}
