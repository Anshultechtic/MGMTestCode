package sqlTests;

import java.sql.SQLException;

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

		getItemNameByRowIDAndColID(20000004, 30000002);

	}

	@Test
	public void getnumberOfItemByCellID() throws SQLException {

		getItemByCellID(20000415, 30000031);

	}

}
