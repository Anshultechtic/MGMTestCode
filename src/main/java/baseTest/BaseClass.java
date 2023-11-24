package baseTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.testng.annotations.AfterMethod;

public class BaseClass {

	public String temp = null;
	int count = 0;
	public ArrayList<String> resultStatus = new ArrayList<>();

	public void ResultStatuses(ArrayList<String> temp) {

		int i = 0;

		for (String s : temp) {

			i++;
			System.out.println(i + " " + s);
		}

	}

}
