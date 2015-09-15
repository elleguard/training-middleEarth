package com.usaa.MiddleEarth;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.usaa.MiddleEarth.Deed;
import com.usaa.MiddleEarth.DeedBank;
import com.usaa.MiddleEarth.Token;

public class removeAllPropertiesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Token aragorn = new Token();
		Deed shire = new Deed(1, 50, "The Shire", 10, 25, "Bank");
		Deed mordor = new Deed(8, 175, "Mordor", 70, 90, "Bank");
		aragorn.addToProperties(shire);
		aragorn.addToProperties(mordor);
		shire.setOwnedBy("Aragorn");
		mordor.setOwnedBy("Aragorn");
		DeedBank deedbank = new DeedBank();

		
		aragorn.removeAllPropertiesForBankruptcy(aragorn.getPropertyDeeds(), deedbank.getAllDeeds());
		for(int i=0; i < aragorn.getPropertyDeeds().size(); i++) {
			
			System.out.println(aragorn.getPropertyDeeds().get(i).getPropertyName());
			
		}
		for(int i=0; i < deedbank.getAllDeeds().size(); i++) {
			System.out.println(deedbank.getAllDeeds().get(i).getOwnedBy());
		}
		
		
		
	}

}
