package com.narxoz.rpg.tower;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.TowerFloor;
import java.util.List;

public class TowerRunner {
    public TowerRunResult run(List<Hero> party, List<TowerFloor> floors) {
        int cleared = 0;
        for (TowerFloor f : floors) {
            party.forEach(h -> h.getState().onTurnStart(h));
            if (!f.explore(party).isCleared()) break;
            cleared++;
            party.forEach(h -> h.getState().onTurnEnd(h));
        }
        return new TowerRunResult(cleared, (int)party.stream().filter(Hero::isAlive).count(), cleared == floors.size());
    }
}
