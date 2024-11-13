package com.swiggy.assignment;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ArenaTest {
	private Player playerA;
	private Player playerB;
	private Dice dice;
	private Arena arena;

    /**
     * Rigorous Test :-)
     */
	@BeforeEach
    public void setUp() {
        playerA = new Player("playerA", 100, 10, 15);
        playerB = new Player("playerB", 100, 8, 12);
        dice = new Dice();
        arena = new Arena(playerA, playerB);
    }

    @Test
    public void testPlayerReduceHealth() {
        playerA.reduceHealth(20);
        assertEquals(80, playerA.getHealth());
        playerA.reduceHealth(90);
        assertEquals(0, playerA.getHealth());  // Health should not go negative
    }

    // Test that Dice produces a roll between 1 and 6
    @Test
    public void testDiceRollRange() {
        for (int i = 0; i < 100; i++) {  // Test multiple rolls to check the range
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6, "Dice roll is out of bounds");
        }
    }

    // Test calculateAttackDamage and calculateDefenseDamage methods in Player
    @Test
    public void testPlayerAttackAndDefenseDamage() {
        int attackRoll = 3;
        int defenseRoll = 2;

        int expectedAttackDamage = playerA.calculateAttackDamage(attackRoll); // Should be 15 * 3 = 45
        int expectedDefenseDamage = playerB.calculateDefenseDamage(defenseRoll); // Should be 8 * 2 = 16

        assertEquals(45, expectedAttackDamage);
        assertEquals(16, expectedDefenseDamage);
    }

    // Test Arena's startBattle method to ensure a winner is determined
    @Test
    public void testStartBattle() {
        arena.startBattle();
        assertTrue(!playerA.isAlive() || !playerB.isAlive(), "One of the players should be dead at the end of the battle");

        // Verify that only one player remains alive
        if (playerA.isAlive()) {
            assertFalse(playerB.isAlive());
        } else {
            assertFalse(playerA.isAlive());
        }
    }

}
