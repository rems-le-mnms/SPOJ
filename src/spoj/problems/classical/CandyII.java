/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/CANDY2/
==========================================================
STATUS : TODO
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class CandyII {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		ArrayList <ArrayList<Integer>> input=new ArrayList<ArrayList<Integer>>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int j=0;j<t;j++) {
			input.add(new ArrayList<Integer>());
			int nb=Integer.parseInt(br.readLine());
			for(int k=0;k<nb;k++) {
				input.get(j).add(Integer.parseInt(br.readLine()));
			}
		}
		
		for(int i=0;i<input.size();i++) {
			BigInteger sum=new BigInteger("0");
			for (int j=0;j<input.get(i).size();j++) {
				//sum=sum.add(input.get(i).get(j));
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
