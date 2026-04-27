package com.narxoz.rpg.state;
import com.narxoz.rpg.combatant.Hero;

public class PoisonedState implements HeroState {
    private int duration = 2;
    public String getName() { return "Poisoned"; }
    public int modifyOutgoingDamage(int basePower) { return basePower - 2; }
    public int modifyIncomingDamage(int rawDamage) { return rawDamage; }

    public void onTurnStart(Hero hero) {
        System.out.println(hero.getName() + " suffering from poison! -5 HP");
        hero.takeDamage(5);
    }

    public void onTurnEnd(Hero hero) {
        duration--;
        if (duration <= 0) {
            hero.setState(new NormalState());
        }
    }
    public boolean canAct() { return true; }
}
