/**
 * D. Auber & P. Narbel
 * Solution TD Architecture Logicielle 2016 Université Bordeaux.
 */
package test;


import soldier.ages.AgeFutureFactory;
import soldier.ages.AgeMiddleFactory;
import soldier.core.AgeAbstractFactory;
import soldier.core.Unit;
import soldier.core.UnitGroup;

public class MainFightTwoAges {

	public static Unit createTeam(AgeAbstractFactory fact, String prefix)  {
		UnitGroup sg = new UnitGroup(prefix + "Animals");
		UnitGroup worms  = new UnitGroup(prefix + "Worms");
		UnitGroup pig = new UnitGroup(prefix + "Pigs");
		
		sg.addUnit(pig);
		sg.addUnit(worms);

		worms.addUnit(fact.infantryUnit(prefix + "nicky"));
		worms.addUnit(fact.infantryUnit(prefix + "tomy"));
		worms.addEquipment(fact.attackWeapon());
		worms.addEquipment(fact.defenseWeapon());
		worms.addEquipment(fact.attackWeapon());
		worms.addEquipment(fact.toy());

		pig.addUnit(fact.riderUnit(prefix + "jenny"));
		pig.addUnit(fact.riderUnit(prefix + "kenny"));
		pig.addEquipment(fact.defenseWeapon());
		pig.addEquipment(fact.defenseWeapon());
		
		return sg;
	}
	
	public static void main(String[] args) {

		AgeAbstractFactory age1 = new AgeMiddleFactory();
		AgeAbstractFactory age2 = new AgeFutureFactory();

		Unit team1 = createTeam(age1, "Team1::"); 
		Unit team2 = createTeam(age2, "Team2::"); 
		
		int round = 0;
		while(team1.alive() && team2.alive()) {
			System.out.println("Round  #" + round++);
			float st1 = team1.strike();
			System.out.println(team1.getName() + " attack with force : " + st1);
			team2.parry(st1);
			float st2 = team2.strike();
			System.out.println(team2.getName() + " attack with force : " + st2);
			team1.parry(st2);
		}
		System.out.println("The end ... " + (team1.alive() ? team1.getName() : team2.getName()) + " won." );
	}

}
