/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/HANGOVER/
==========================================================
STATUS : AC in 0.07s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hangover {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean stop=true;
		while(stop) {
			double input=Double.parseDouble(br.readLine());
			if(input==0) {
				stop=false;
			} else {
				double sum=0;
				double div=2;
				while(sum<input) {
					sum=sum+(1/div);
					div++;
				}
				finalRes.add(Double.toString(div-2).split("\\.")[0] + " card(s)");
			}
		}
		
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
}
