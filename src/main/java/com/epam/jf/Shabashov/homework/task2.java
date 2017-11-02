package com.epam.jf.Shabashov.homework;

public class task2{
	public static void main(String[] args) {
		int n_min=0;
		int n_max=0;
		for (int i=0;i<args.length;i++) {
			if (args[i].length()>=args[n_max].length()) n_max=i;
			if (args[i].length()<=args[n_min].length()) n_min=i;
		}
		System.out.println("Minimal string: "+args[n_min]);
		System.out.println("Maximal string: "+args[n_max]);
	}
}