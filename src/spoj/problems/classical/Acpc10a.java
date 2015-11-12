/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/ACPC10A/
==========================================================
STATUS : AC in 0.08s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Acpc10a {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> finalRes=new ArrayList<String>();
		boolean stop=true;
		while(stop) {
			StringBuffer str=new StringBuffer(br.readLine());
			String[] un= str.toString().split(" ");
			int u0=Integer.parseInt(un[0]);
			int u1=Integer.parseInt(un[1]);
			int u2=Integer.parseInt(un[2]);
			if(u0==0 && u1==0 && u2==0) {
				stop=false;
			} else {
				if(u2-u1==u1-u0) {
					int u3=u2+ (u2 -u1);
					finalRes.add("AP " + Integer.toString(u3));
				} else {
					int u3=u2*(u2/u1);
					finalRes.add("GP " + Integer.toString(u3));
				}
			}
		}
		
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
}
