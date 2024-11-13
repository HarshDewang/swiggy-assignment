package com.swiggy.assignment;

public class Arena {
    private Player playerA;
    private Player playerB;
    private Dice dice;

    // Constructor to initialize the Arena with two players and a dice
    public Arena(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    // Method to start the battle
    public void startBattle() {
        System.out.println("The battle begins between " + playerA.getName() + " and " + playerB.getName());
        
        // Continue until one player dies (health reaches 0)
        while (playerA.isAlive() && playerB.isAlive()) {
            takeTurn();  // Each turn, a player attacks and the other defends
        }

        // Battle ends, print the winner
        System.out.println("Battle ended. Winner: " + (playerA.isAlive() ? playerA.getName() : playerB.getName()));
    }

    // Method to manage each turn of the battle
    private void takeTurn() {
        // Determine who attacks first based on the player's health
        Player attacker = (playerA.getHealth() <= playerB.getHealth()) ? playerA : playerB;
        Player defender = (attacker == playerA) ? playerB : playerA;

        // Roll the dice for both the attacker and defender
        int attackRoll = dice.roll();  // Attacker's roll
        int defenseRoll = dice.roll(); // Defender's roll

        // Calculate the attack damage and defense damage
        int attackDamage = attacker.calculateAttackDamage(attackRoll);
        int defenseDamage = defender.calculateDefenseDamage(defenseRoll);

        // Calculate the final damage dealt (attack damage minus defense damage)
        int damageDealt = Math.max(0, attackDamage - defenseDamage);

        // Apply the damage to the defender's health
        defender.reduceHealth(damageDealt);

        // Output the result of the turn in a readable format
        System.out.println(attacker.getName() + " attacks with roll " + attackRoll +
                " (Damage: " + attackDamage + ") | " + defender.getName() + " defends with roll " + defenseRoll +
                " (Defense: " + defenseDamage + ") | " + defender.getName() + " Health reduced by " + damageDealt +
                " to " + defender.getHealth());
    }
}

