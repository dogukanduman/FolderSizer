package com.donovan.foldersizer;

public class PrintHelper {
	
	
	public static String printRow(int size,String s)
	{
		StringBuilder sBuilder=new StringBuilder(size);
		for(int i=0;i<size;i++)
		{
			sBuilder.append(s);
		}
		return sBuilder.toString();
	}
	public static String printRowBordered(int size,String r,String border)
	{
		StringBuilder sBuilder=new StringBuilder(size);
		sBuilder.append(border);
		for(int i=0;i<size;i++)
		{
			sBuilder.append(r);
		}
		sBuilder.append(border);
		return sBuilder.toString();
	}
}
