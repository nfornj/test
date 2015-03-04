package com.neeraj.calculate;


import java.math.BigDecimal;
import java.util.Date;

import com.neeraj.calculate.dto.CostDTO;
import com.neeraj.calculate.exception.CheckException;
import com.neeraj.calculate.implementation.CostCalculator;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Calculator{

	public CostDTO createDTO(String id, BigDecimal cost, Date costDate ) {
		CostDTO costDTO = new CostDTO();
		costDTO.setCostID(id);
		costDTO.setCostAmount(cost);
		costDTO.setDate(costDate);
		return costDTO;
	}

	public static void main(String args[]) throws ParseException {
		Calculator tc = new Calculator();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		CostDTO obj1 = tc.createDTO("2", new BigDecimal(40.00),dateFormat.parse("02/12/2015"));
		CostDTO obj2 = tc.createDTO("2", new BigDecimal(30.12),dateFormat.parse("02/12/2016"));
		CostDTO outputObj = new CostDTO();

		CostCalculator cci = new CostCalculator(); //Changed here
		try {
			outputObj = cci.add(obj1, obj2);
		} catch (CheckException ce) {
			System.out.println(ce.getMessage());
			System.exit(1) ;
		}

		System.out.println("Input Arguments are  Object ID = "+obj1.getCostID()+"Object 1 Cost: "+obj1.getCostAmount()+" Object2 Cost: "+obj2.getCostAmount()+"Object 1 Date :"+obj1.getCostDate()+"Object 2 Date :"+ obj2.getCostDate());
		System.out.println("Add :"+outputObj.getCostID()+" | Cost= "+outputObj.getCostAmount());

		try {
			outputObj = cci.substract(obj1, obj2);
		} catch (CheckException ce) {
			System.out.println(ce.getMessage());
			System.exit(1) ;
		}

		System.out.println("Subtract :"+outputObj.getCostID()+" | Cost= "+outputObj.getCostAmount());

	}

}

