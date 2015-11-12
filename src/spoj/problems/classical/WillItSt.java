/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/WILLITST/
==========================================================
STATUS : AC in 1.10s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WillItSt {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n=Long.parseLong(br.readLine());
		if(n!=0 && (n&(n-1))==0) {
			System.out.println("TAK");
		} else {
			System.out.println("NIE");
		}
	}
}
