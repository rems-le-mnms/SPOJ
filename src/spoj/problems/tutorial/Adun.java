/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/ADUN/
==========================================================
STATUS : AC in 0.30s
 */
package spoj.problems.tutorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Adun {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long res;
		res = Long.parseLong(br.readLine());
		res += Long.parseLong(br.readLine());
		System.out.println(res);
	}
}
