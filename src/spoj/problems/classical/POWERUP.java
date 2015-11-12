/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/POWERUP/
==========================================================
STATUS : TLE
NOTE : Very very difficult.... Need another algorithm ( based on modular exponentiation / quick exponentiation I think ...)
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class POWERUP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean stop=true;
		while(stop) {
			String line=br.readLine();
			String input[] = line.split(" ");
			if(Integer.parseInt(input[0])==-1) {
				stop=false;
			} else {
				BigInteger a=new BigInteger(input[0]);
				BigInteger b=new BigInteger(input[1]);
				int c=Integer.parseInt(input[2]);
				BigInteger m=new BigInteger("1000000007");
				System.out.println(a.modPow(b.pow(c), m).toString());
			}
		}
	}
	
}
