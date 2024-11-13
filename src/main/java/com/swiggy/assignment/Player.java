package com.swiggy.assignment;

public class Player {
	private String name;
	private int health;
	private int strength;
	private int attack;
	
	public Player(String name, int health,int strength, int attack) {
		this.name =name;
		this.health=health;
		this.strength=strength;
		this.attack=attack;
		
	}
	public int getHealth() {
		return health;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isAlive() {
		return health > 0;
	}
	
	public void reduceHealth(int damage) {
		this.health = Math.max(0,this.health - damage);
		//to avoid negative health
	}
	public int calculateAttackDamage(int diceRoll) {
		return attack * diceRoll;
	}
	
	public int calculateDefenseDamage(int diceRoll) {
		return strength * diceRoll;
	}

}


