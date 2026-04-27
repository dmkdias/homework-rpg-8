package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.*;
import java.util.List;

public class CombatFloor extends TowerFloor {
    private Monster enemy;

    protected String getFloorName() { return "Dark Dungeon"; }
    protected void setup(List<Hero> party) { enemy = new Monster("Orc", 40, 12); }

    protected FloorResult resolveChallenge(List<Hero> party) {
        for (Hero h : party) {
            if (h.getState().canAct()) {
                enemy.takeDamage(h.getState().modifyOutgoingDamage(h.getAttackPower()));
            }
        }
        boolean cleared = !enemy.isAlive();
        return new FloorResult(cleared, 10, "Fought an Orc.");
    }

    protected void awardLoot(List<Hero> party, FloorResult result) {
        System.out.println("Gained some gold!");
    }
}