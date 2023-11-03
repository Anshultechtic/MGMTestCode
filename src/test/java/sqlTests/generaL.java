package sqlTests;

import java.math.BigInteger;

public class generaL {

	
	
	public static void main(String[] args) {
		
		   BigInteger bigInteger1 = new BigInteger("12345");
	        BigInteger bigInteger2 = new BigInteger("98");

	        BigInteger maxBigInteger = bigInteger2.max(bigInteger1);

	        System.out.println("The maximum BigInteger value is: \n" + maxBigInteger);
	        
	    }
	
		
		
	
}
