/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/SAMER08F/
==========================================================
STATUS : AC in 0.06s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Samer08f {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> finalRes=new ArrayList<String>();
		boolean stop=true;
		while(stop) {
			StringBuffer str=new StringBuffer(br.readLine());
			if(Integer.parseInt(str.toString())==0) {
				stop=false;
			} else {
				int res=0;
				for(int i=1;i<=Integer.parseInt(str.toString());i++) {
					res=res+(i*i);
				}
				finalRes.add(Integer.toString(res));
			}
		}
		
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}

}
