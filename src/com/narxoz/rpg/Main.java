package com.narxoz.rpg;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.floor.*;
import com.narxoz.rpg.state.PoisonedState;
import com.narxoz.rpg.tower.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Hero h1 = new Hero("Warrior", 100, 15, 5);
        h1.setState(new PoisonedState()); // Разные стартовые состояния
        Hero h2 = new Hero("Archer", 80, 20, 2);

        TowerRunner runner = new TowerRunner();
        TowerRunResult res = runner.run(Arrays.asList(h1, h2), Arrays.asList(
                new CombatFloor(), new RestFloor(), new CombatFloor(), new CombatFloor()
        ));

        System.out.println("Floors Cleared: " + res.getFloorsCleared()); // Печать результата
    }
}