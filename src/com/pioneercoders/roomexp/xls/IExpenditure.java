package com.pioneercoders.roomexp.xls;

import com.pioneercoders.roomexp.common.IConfig;

public interface IExpenditure extends IConfig{
	
	public void insertExpenditure(String name, String description, String amount);
	
	public Object[][] getExpenditureSheet();

}
