/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package soldier.equipment;

import soldier.core.BehaviorExtension;
import soldier.core.BehaviorSoldier;
import soldier.core.EquipmentToy;

public class EquipmentTrumpet extends EquipmentToy {

	@Override
	public EquipmentTrumpet clone() {
		return (EquipmentTrumpet) super.clone();
	}

	@Override
	public String getName() {
		return "Trumpet";
	}

	@Override
	public BehaviorSoldier createExtension(BehaviorSoldier s) {
		return new BehaviorExtension(this, s) {
			@Override
			public float strike() {
				java.awt.Toolkit.getDefaultToolkit().beep();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return super.strike();
			}
		};
		
	}

	@Override
	public void accept(WeaponVisitor v) {
		// TODO Auto-generated method stub
		
	}
}
