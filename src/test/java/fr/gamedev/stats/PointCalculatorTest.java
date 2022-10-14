package fr.gamedev.stats;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.gamedev.stats.fixedSizeCoeficient.FscRule;
import junit.framework.Assert;
import junit.framework.TestCase;

public class PointCalculatorTest extends TestCase{
	
	PointCalculator pc;
	@BeforeClass
    public void setUp() {
        pc = PointCalculator.getInstance();
    }
	
	@Test
	public void testFirstTimeBonus() {
    	int dataSource = 2000;
    	FscRule rules = FscRule.fromString("[linear with first Time bonus, rounded up (accumulated_points)] FSC[(300)(up)(accumulated_points-*)i-1]");
    	assertEquals(320, pc.fsc(dataSource, true, (short) 20, rules));
	}
	
	@Test
	public void testWithoutFirstTimeBonus() {
    	int dataSource = 2000;
    	FscRule rules = FscRule.fromString("[linear without first Time bonus, rounded up (accumulated_points)] FSC[(300)(up)(accumulated_points-*)i-1]");
    	assertEquals(20, pc.fsc(dataSource, false, (short) 20, rules));
	}
	
	@Test 
	public void testCase1A() {
		int dataSource = 3518;
		FscRule rules = FscRule.fromString("[Fixed step coefficient plus firstTime bonus rounded up (accumulated points)] FSC[(100)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");
		assertEquals(38,this.pc.fsc(dataSource, false,(short)50, rules));
	}
	
	@Test
	public void testCase1B() {
		int datasource = 0;
		FscRule rules = FscRule.fromString("[Fixed step coefficient plus firstTime bonus rounded up (accumulated points)] FSC[(100)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");
		assertEquals(200,this.pc.fsc(datasource, false, (short)100, rules));
	}
	
	@Test //Step Based on repetition
	public void testCase2A() {
		int datasource= 0;
		FscRule rules = FscRule.fromString("[(repetition)] FSC[(5)(down)(repetition-*)10-1|50-0.75|100-0.5|i-0.001]");
		assertEquals(55,this.pc.fsc(datasource, true, (short)50, rules));
	}	
}
