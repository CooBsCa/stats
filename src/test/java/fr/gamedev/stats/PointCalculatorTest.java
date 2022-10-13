package fr.gamedev.stats;

import org.junit.Test;

import fr.gamedev.stats.fixedSizeCoeficient.FscRule;
import junit.framework.TestCase;

public class PointCalculatorTest extends TestCase{
	
	PointCalculator pc;
	@Test
    public void testLinearFscFirstTime(){
    	 pc = PointCalculator.getInstance();
    	int dataSource = 0;
    	FscRule rules = FscRule.fromString("[linear with first Time bonus, rounded up (accumulated_points)] FSC[(500)(up)(accumulated_points-*)i-1]");
    	assertEquals(510, pc.fsc(dataSource, true, (short) 10, rules));
    }
}
