/*
==========================================================
Author	: 		Rémi Kaeffer
Description : 	http://www.spoj.com/problems/LGIC/
==========================================================
STATUS : AC in 0.23s
 */
package spoj.problems.riddle;

public class Lgic {
	public static void main (String[] args) throws java.lang.Exception
	  {
	     java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
	     String s=r.readLine();
	     int a = Integer.parseInt(s);
	     int res=a;
	     for(int i=1;i<a;i++) {
	    	 res=res*(a-i);
	     }
	     res=res + (int) Math.pow(2, a) - a;
	     System.out.println(res);
	  }
}
