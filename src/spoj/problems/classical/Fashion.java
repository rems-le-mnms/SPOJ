/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/FASHION/
==========================================================
STATUS : AC in 0.10s
 */
package spoj.problems.classical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Fashion {
	public static void main(String[] args) throws Exception {
		ArrayList <String> finalRes=new ArrayList <String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int i=0; i<t ; i++) {
			int nb=Integer.parseInt(br.readLine());
			String[] x=br.readLine().split(" ");
			String[] y=br.readLine().split(" ");
			int[] xx=new int[nb];
			int[] yy=new int[nb];
			for(int j=0;j<nb;j++) {
				xx[j]=Integer.parseInt(x[j]);
				yy[j]=Integer.parseInt(y[j]);
			}
			Arrays.sort(xx);
			Arrays.sort(yy);
			int sum=0;
			for(int j=0;j<nb;j++) {
				sum=sum+(xx[j]*yy[j]);
			}
			finalRes.add(Integer.toString(sum));
		}
		for(int i=0;i<finalRes.size();i++) {
			System.out.println(finalRes.get(i));
		}
	}
}
