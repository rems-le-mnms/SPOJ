/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/FCTRL2/
==========================================================
STATUS : AC in 0.10s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Fctrl2 {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cas=Integer.parseInt(br.readLine());
		for(int i=0;i<cas;i++) {
			BigInteger n=new BigInteger(br.readLine());
			finalRes.add(factoriel(n).toString());
		}
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
	
	public static BigInteger factoriel(BigInteger n) {
		if(n.toString()=="0") {
			return new BigInteger("1");
		} 
		return n.multiply(factoriel(n.subtract(new BigInteger("1"))));
	}
}
