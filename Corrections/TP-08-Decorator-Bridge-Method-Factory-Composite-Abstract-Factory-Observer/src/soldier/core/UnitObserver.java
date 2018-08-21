/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.core;

/**
 * Generic version of the Observer design pattern
 * @param <Unit>
 */
public interface UnitObserver {
	void update(Unit s);
}
