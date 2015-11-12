/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/TESTINT/
==========================================================
STATUS : AC in 0.19s
 */
package spoj.problems.basics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Testint {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res;
		res = Integer.parseInt(br.readLine());
		res += Integer.parseInt(br.readLine());
		System.out.println(res);
		
	}
}
