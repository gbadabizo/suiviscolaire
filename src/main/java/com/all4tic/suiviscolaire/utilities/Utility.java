package com.all4tic.suiviscolaire.utilities;

import java.util.Random;

public class Utility {
	public static final int SUCCESSFUL_CODE=800; 
	public static final int USER_EXIST_CODE = 802;
	public static final int FAILLURE_CODE = 700;
	 public static int generateRandomDigits(int n) {
	        int m = (int) Math.pow(10, n - 1);
	        return m + new Random().nextInt(9 * m);
	    }
}
