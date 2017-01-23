package com.saltpy.testbet.unit;

import static org.junit.Assert.*;
import org.junit.Test;

import com.saltpy.testbet.data.Stake;

public class TestStake {
	
	@Test
	public void testToString() {
		assertEquals("0.05", new Stake(5).toString());
	}

}
