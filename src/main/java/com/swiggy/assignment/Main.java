package com.swiggy.assignment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create two players with initial health, strength, and attack values
        Player playerA = new Player("Player A", 100, 10, 15);  // Player A with 100 health, 10 strength, 15 attack
        Player playerB = new Player("Player B", 100, 8, 12);   // Player B with 100 health, 8 strength, 12 attack

        // Create an Arena object with the two players
        Arena arena = new Arena(playerA, playerB);

        // Start the battle
        arena.startBattle();

	}

}
