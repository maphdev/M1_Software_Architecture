/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */


import soldier.core.UnitSimple;
import soldier.equipment.EquipmentTrumpet;
import soldier.equipment.WeaponShield;
import soldier.equipment.WeaponSword;
import soldier.units.UnitCenturion;
import soldier.units.UnitRobot;

public class MainFightExemple {
	
	public static void main(String[] args) {

		UnitSimple trooper = new UnitCenturion("StormTrooper");
		UnitSimple r2 = new UnitRobot("R2D2");
		
		trooper.addEquipment(new WeaponSword());
		trooper.addEquipment(new WeaponShield());
		
		r2.addEquipment(new WeaponShield());
		r2.addEquipment(new EquipmentTrumpet());
		
		int round = 0;
		while(trooper.alive() && r2.alive()) {
			System.out.println("Round  #" + round++);
			float st1 = trooper.strike();
			System.out.println(trooper.getName() + " attack with force : " + st1);
			r2.parry(st1);
			if (r2.alive()) {
				float st2 = r2.strike();
				System.out.println(r2.getName() + " attack with force : " + st2);
				trooper.parry(st2);
			}
		}
		System.out.println("The end ... " + (trooper.alive() ? trooper.getName() : r2.getName()) + " won." );
	}

}
