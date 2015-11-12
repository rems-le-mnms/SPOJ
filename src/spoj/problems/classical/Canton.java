/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/CANTON/
==========================================================
STATUS : WA
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Canton {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0; i<t ; i++) {
			int input=Integer.parseInt(br.readLine());
			if (input==1) {
				finalRes.add("TERM 1 IS 1/1");	
			} else {
				int n=calculeDiag(input);
				int endPoint=(n*(n+1)) / 2;
				int diff=endPoint-input;
				if(n%2 == 0) {
					finalRes.add("TERM " + Integer.toString(input) + " IS " + Integer.toString(n-diff)  + "/" + Integer.toString(diff+1));
				}  else {
					finalRes.add("TERM " + Integer.toString(input) + " IS " + Integer.toString(1+diff)+ "/" + Integer.toString(n-diff));
				}
			}
			
		}
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
	
	public static int calculeDiag(int n) {
		return (int)Math.rint(Math.sqrt(8*n + 1)/2);
	}
}
