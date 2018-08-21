/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.core;

public interface Equipment extends Cloneable {
	String getName();

	BehaviorSoldier createExtension(BehaviorSoldier s);

	Equipment clone();
}
