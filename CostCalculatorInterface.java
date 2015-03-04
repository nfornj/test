package com.neeraj.calculate.interfaces;

import com.neeraj.calculate.dto.CostDTO;
import com.neeraj.calculate.exception.CheckException;

public interface CostCalculatorInterface {
	
	public CostDTO add(CostDTO object1,CostDTO object2) throws CheckException;
	public CostDTO substract(CostDTO object1,CostDTO object2) throws CheckException;

}
