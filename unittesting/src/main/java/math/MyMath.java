package math;


/*
 * @author - iasonasma
 *  
 */
public class MyMath {

	/*Performs the basic factorial of a int
	 * @param the number which we will get the factorial
	 * @return the factorial of the n number
	 * @exception IllegalArgumentException when the n is negative
	 * @exception IllegalArgumentException when the n is bigger than 12
	 */
    public int factorial(int n) 
    { 
        if (n == 0) 
          return 1; 
        else if( n < 0) {
        	throw new IllegalArgumentException("n should be bigger than 0");
        }
        else if ( n > 12)
        { 
        	throw new IllegalArgumentException("n should be less than 12");
        }
          
        return n*factorial(n-1); 
    }   
    
    /*Finding if a given integer is prime or not.
     * @param the integer to check if it's prime or not
     * @exception IllegalArgumentException when the n is less than 2
     */
    
    public boolean isPrime(int n) {
    	
    	if(n<=2) {
    		throw new IllegalArgumentException("Integer must be greater than or same with 2");
    	}
        for(int i=2;2*i<n;i++) { 
            if(n%i==0)
                return false;
        }
        return true;
    }
}
