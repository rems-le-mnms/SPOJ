/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/NSTEPS/
==========================================================
STATUS : AC in 0.20s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Nsteps {

	public static void main(String[] args) throws Exception {
		
		ArrayList <String> finalRes=new ArrayList <String>();
		ArrayList <Integer[]> number=new ArrayList<Integer[]>();
		/* Prépa nombre */
		int y=0;
		for(int i=0;i<10000;i++) {
			number.add(new Integer[2]);
			number.get(i)[0]=y;
			number.get(i)[1]=y+2;
			if(i%2==0) {
					y=y+1;
			} else {
				y=y+3;
			}
		}
		y=y+3;
		number.add(new Integer[2]);
		number.get(10000)[0]=20000;
		number.get(10000)[1]=-1;
		
		/* Lecture de N */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			StringBuffer str=new StringBuffer(br.readLine());
			String [] split=str.toString().split(" ");
			int x1=Integer.parseInt(split[1]);
			int x2=Integer.parseInt(split[0]);
			if(x1<=10000 && x2 <=10001 && x1>=0 && x2>=0) {
				if(x1==x2) {
					finalRes.add(Integer.toString(number.get(x1)[0]));
				} else if (x2 == x1 + 2) {
					finalRes.add(Integer.toString(number.get(x1)[1]));
				} else {
					finalRes.add("No Number");
				}
			} else {
				finalRes.add("No Number");
			}
		}
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
		
	}

}
