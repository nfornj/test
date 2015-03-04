package com.neeraj.calculate.testing;
import org.junit.Test;
import java.math.BigDecimal;
import com.neeraj.calculate.dto.CostDTO;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.neeraj.calculate.exception.CheckException;
import com.neeraj.calculate.implementation.CostCalculator;
import com.neeraj.calculate.interfaces.CostCalculatorInterface;

public class TestingCalculator {

	public CostDTO createDTO(String id, BigDecimal cost) {
		CostDTO costDTO = new CostDTO();

		costDTO.setCostID(id);
		costDTO.setCostAmount(cost);
		return costDTO;
	}
	@Test
	public void testAdd() {
		CostDTO obj1 = createDTO("2", new BigDecimal(123.00));
		CostDTO obj2 = createDTO("2", new BigDecimal(103.20));
		CostDTO outputObj = new CostDTO();

		CostCalculatorInterface cci = new CostCalculator();
		try {
			outputObj = cci.add(obj1, obj2);
		} catch (CheckException ce) {
			System.out.println(ce.getMessage());
			System.exit(1) ;
		}

		System.out.println("Input Arguments are  Object ID = "+obj1.getCostID()+"Object 1 Cost: "+obj1.getCostAmount()+" Object2 Cost: "+obj2.getCostAmount()+"Object 1 Date :"+obj1.getCostDate()+"Object 2 Date :"+ obj2.getCostDate());
		System.out.println("Add :"+outputObj.getCostID()+" | "+outputObj.getCostAmount());

	}

	@Test
	public void testSubstract() {
		CostDTO obj1 = createDTO("2", new BigDecimal(123.00));
		CostDTO obj2 = createDTO("2", new BigDecimal(103.20));
		CostDTO outputObj = new CostDTO();

		CostCalculatorInterface cci = new CostCalculator();
		try {

			outputObj = cci.substract(obj1, obj2);
		} catch (CheckException ce) {
			System.out.println(ce.getMessage());
			System.exit(1) ;
		}
		System.out.println("Input Arguments are  Object ID = "+obj1.getCostID()+"Object 1 Cost: "+obj1.getCostAmount()+" Object2 Cost: "+obj2.getCostAmount()+"Object 1 Date :"+obj1.getCostDate()+"Object 2 Date :"+ obj2.getCostDate());
		
		System.out.println("Subtract\n"+outputObj.getCostID()+" | "+outputObj.getCostAmount());
	}
	
	
	@RunWith(Suite.class)
	@SuiteClasses({ TestingCalculator.class })
	public class JunitTestSuite {

	} 

} 
