/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/JULKA/
==========================================================
STATUS : AC in 0.06s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Julka {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> finalRes=new ArrayList<String>();
		for(int i=0;i<10;i++) {
			BigInteger n=new BigInteger(new StringBuffer(br.readLine()).toString());
			BigInteger z=new BigInteger(new StringBuffer(br.readLine()).toString());
			BigInteger y=n.subtract(z);
			finalRes.add(y.divide(new BigInteger("2")).add(z).toString());
			finalRes.add(y.divide(new BigInteger("2")).toString());
		}
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
}
