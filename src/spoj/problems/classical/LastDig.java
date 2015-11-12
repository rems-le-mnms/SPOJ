/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/LASTDIG/
==========================================================
STATUS : AC in 0.06s
 */
package spoj.problems.classical;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class LastDig {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c=Integer.parseInt(br.readLine());
		for(int i=0;i<c;i++) {
			String[] n=br.readLine().split(" ");
			System.out.println(new BigInteger(n[0]).modPow(new BigInteger(n[1]), new BigInteger("10")));
		}
	}
}
