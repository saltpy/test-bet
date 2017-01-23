package com.saltpy.testbet.data;

public class Position {

	private final Odds odds;
	private final Stake stake;

	public Position(Odds odds, Stake stake) {
		this.odds = odds;
		this.stake = stake;
	}

	public int returns() {
		return Math.round(odds.multiplier() * stake.penceValue());
	}

}
