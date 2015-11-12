/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/FCTRL/
==========================================================
STATUS : AC in 0.64s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Fctrl {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cas=Integer.parseInt(br.readLine());
		for(int i=0;i<cas;i++) {
			boolean stop = true;
			long a=Long.parseLong(br.readLine());
			long div=5;
			long res=0;
			while(stop){
				if(a / div == 0) {
					stop=false;
				} else {
					res=res+(a / div);
					div = div*5;
				}
			}
			finalRes.add(Long.toString(res));
		}
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
}
