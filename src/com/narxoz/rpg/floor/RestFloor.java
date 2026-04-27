package com.narxoz.rpg.floor;
import com.narxoz.rpg.combatant.Hero;
import java.util.List;

public class RestFloor extends TowerFloor {
    protected String getFloorName() { return "Healing Fountain"; }
    protected void setup(List<Hero> party) {}
    protected FloorResult resolveChallenge(List<Hero> party) {
        party.forEach(h -> h.heal(20));
        return new FloorResult(true, 0, "Heroes rested.");
    }
    protected void awardLoot(List<Hero> party, FloorResult result) {}

    @Override
    protected boolean shouldAwardLoot(FloorResult result) { return false; }
}
