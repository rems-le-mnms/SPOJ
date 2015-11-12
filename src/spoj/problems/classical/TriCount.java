/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/TRICOUNT/
==========================================================
STATUS : AC in 1.25s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class TriCount {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cas=Integer.parseInt(br.readLine());
		for(int i=0;i<cas;i++) {
			long n=Long.parseLong(br.readLine());
			System.out.println(Long.toString((long)(n*(n+2)*(2*n+1)/8)));
		}
	}
}
