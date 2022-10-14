package fr.gamedev.stats.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.gamedev.stats.PointCalculator;
import fr.gamedev.stats.fixedSizeCoeficient.FscRule;




@RestController
public class FscController {
	
	
    	static FscRule rule1 = FscRule.fromString("[Fixed step coefficient plus firstTime bonus rounded up (accumulated points)] FSC[(100)(up)(accumulated_points-*)500-2|1000-1.5|2000-1|5000-0.75|10000-0.5|50000-0.25|i-0.01]");
    	static FscRule rule2 = FscRule.fromString("[(repetition)] FSC[(5)(down)(repetition-*)10-1|50-0.75|100-0.5|i-0.001]");
    	static FscRule rule3 = FscRule.fromString("[linear with first Time bonus, rounded up (accumulated_points)] FSC[(500)(up)(accumulated_points-*)i-1]");

		@RequestMapping("/")
	    String hello() {
	        return "Hello World, Spring Boot!";
	    }
		
		
		@RequestMapping("/stats/fsc")
	    public int calculFsc(@RequestParam() int currentPoint, @RequestParam() boolean isFirstTime, @RequestParam() short basePoints, @RequestParam() String afscRuleName) {

	        // afscRuleName;
			FscRule afscRule;
	        if (afscRuleName.equals("rule1")) {
	        	afscRule = rule1;
	        }else if (afscRuleName.equals("rule2")) {
	        	afscRule = rule2;
	        }else if (afscRuleName.equals("rule3")) {
	        	afscRule = rule3;
	        }else {
	        	afscRule = null;
	        	System.out.print("La règle inconnue ou non précisé");
	        }


	     return PointCalculator.getInstance().fsc(currentPoint, isFirstTime, basePoints, afscRule);
	    }
}
