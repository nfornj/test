package com.neeraj.calculate.implementation;

import com.neeraj.calculate.dto.CostDTO;
import com.neeraj.calculate.exception.CheckException;
import com.neeraj.calculate.interfaces.CostCalculatorInterface;

public class CostCalculator implements CostCalculatorInterface{

	public CostDTO add(CostDTO obj1 , CostDTO obj2) throws CheckException
	{
		//MathContext mc = new MathContext(0);
		CostDTO retObj = new CostDTO() ;
		String id1 = obj1.getCostID() ;
		String id2 = obj2.getCostID() ;
		if(id1.equalsIgnoreCase(id2))
		{
			retObj.setCostID(id1);
			retObj.setCostAmount(obj1.getCostAmount().add( obj2.getCostAmount()));
		}
		else
			throw new CheckException("Both Objects should carry same ID values to proceed further.");


		return retObj ;
	}
	
	public CostDTO substract(CostDTO obj1 , CostDTO obj2) throws CheckException
	{

		CostDTO retObj = new CostDTO() ;
		String id1 = obj1.getCostID() ;
		String id2 = obj2.getCostID() ;
		if(id1.equalsIgnoreCase(id2))
		{
			retObj.setCostID(id1);
			retObj.setCostAmount(obj1.getCostAmount().subtract( obj2.getCostAmount()));

		}
		else
			throw new CheckException("Both Objects should carry same ID values to proceed further.");

		return retObj ;
	}
}
