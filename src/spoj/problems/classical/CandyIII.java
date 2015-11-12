/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/CANDY3/
==========================================================
STATUS : AC in 0.14s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class CandyIII {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		ArrayList <ArrayList<BigInteger>> input=new ArrayList<ArrayList<BigInteger>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Integer.parseInt(br.readLine());
		for(int j=0;j<t;j++) {
			br.readLine();
			input.add(new ArrayList<BigInteger>());
			int nb=Integer.parseInt(br.readLine());
			for(int k=0;k<nb;k++) {
				input.get(j).add(new BigInteger(br.readLine()));
			}
		}
		
		for(int i=0;i<input.size();i++) {
			BigInteger sum=new BigInteger("0");
			for (int j=0;j<input.get(i).size();j++) {
				sum=sum.add(input.get(i).get(j));
			}
			if(sum.remainder(new BigInteger(Integer.toString(input.get(i).size()))).toString()=="0") {
				finalRes.add("YES");
			} else {
				finalRes.add("NO");
			}
		}
		
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
				
	}
}
