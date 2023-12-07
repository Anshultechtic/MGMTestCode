package sqlTests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

import dBClasses.DBMethods;

public class DBTest extends DBMethods {

	@Test
	public void getRowIDByITemNameTest() throws SQLException {

		getRowIDByItemName("0");

	}

	@Test
	public void getRowIDByITemName() throws SQLException {

		getColIDByItemName("0");

	}

	@Test
	public void getCellIDByITemName() throws SQLException {

		getItemNameByRowIDAndColID(1000000101 , 30000002);

	}

	@Test
	public void getnumberOfItemByCellID() throws SQLException {

		getItemByCellID(20000415, 30000031);

	}

	@Test
	public void noOfRowsIntRowForMasterTG() throws SQLException {
		long TGID = 3000000001l;

		long Row = 1000000001;
		int noOfRowIDs = 0;
		boolean status = true;
		long count = getNoOfRowsInTG(TGID, Row);

		while (count == 16) {

//			System.out.println("\n"+Row);
			count = getNoOfRowsInTG(TGID, Row+1);
			Row++;
			
        
			noOfRowIDs++;

		}
		System.out.println("\nTotal no of Rows are =" + noOfRowIDs);
		
		System.out.println("\nTotal no of Rows are =" + noOfRowIDs);
		Assert.assertEquals(noOfRowIDs, 27);

	}

	@Test
	public void noOfRowsIntRowForDDtsTG() throws SQLException {
		long TGID = 3000000002l;

		long Row = 1000000101;
		int noOfRowIDs = 0;
	
		long count = getNoOfRowsInTG(TGID, Row);

		while (count == 10) {

//			System.out.println("\n"+Row);
			count = getNoOfRowsInTG(TGID, Row+1);
			Row++;
			
        
			noOfRowIDs++;

		}
		System.out.println("\nTotal no of Rows are =" + noOfRowIDs);
		
		System.out.println("\nTotal no of Rows are =" + noOfRowIDs);
		Assert.assertEquals(noOfRowIDs, 264);

	}

	@Test
	public void noOfRowsIntRowForALLDDtsTG() throws SQLException {
		long TGID = 3000000003l;

		long Row = 1000000101;
		int noOfRowIDs = 0;

		long count = getNoOfRowsInTG(TGID, Row);

		while (count == 10) {

			Row++;
//			System.out.println("\n"+Row);
			count = getNoOfRowsInTG(TGID, Row);
			noOfRowIDs++;

		}

		System.out.println("\nTotal no of Rows are =" + noOfRowIDs);

	}

	@Test
	public void noOfRowsIntRowForLabelsTG() throws SQLException {
		long TGID = 3000000004l;

		long Row = 1000000365;
		int noOfRowIDs = 0;
		boolean status = true;
		long count = getNoOfRowsInTG(TGID, Row);

		while (count == 13) {

//			System.out.println("\n"+Row);
			count = getNoOfRowsInTG(TGID, Row+1);
			Row++;
			
        
			noOfRowIDs++;

		}
		System.out.println("\nTotal no of Rows are =" + noOfRowIDs);
		
		System.out.println("\nTotal no of Rows are =" + noOfRowIDs);
		Assert.assertEquals(noOfRowIDs, 121);

	}

	@Test
	public void noOfRowsIntRowForALLLabelsTG() throws SQLException {
		long TGID = 3000000005l;

		long Row = 10000001012l;
		int noOfRowIDs = 0;

		long count = getNoOfRowsInTG(TGID, Row);

		while (count == 10) {

			Row++;
//			System.out.println("\n"+Row);
			count = getNoOfRowsInTG(TGID, Row);
			noOfRowIDs++;

		}

		System.out.println("\nTotal no of Rows are =" + noOfRowIDs);

	}

}
