package com.donovan.foldersizer;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;



public class FolderSizer {
	
	  public static void main(String [] args) {
	    	
	    	
	    	//args=new String[2];
	    	//args[0]="/Users/ttdduman/downLoads";
	    	//args[1]="10";
	    	if (args.length > 0) {
	    	    Path path = Paths.get(args[0]);
	         
	        	FolderTraverse ft  =new FolderTraverse(path);
	        	List<File> fileList=ft.getFileList();
	          
	            Collections.sort(fileList);
	            
	            int limit=fileList.size();
	            if(args.length > 1)
	            {
	            	limit=Integer.parseInt(args[1]);
	            }
	            
	            System.out.println();
	            System.out.println(PrintHelper.printRowBordered(93, "-","║"));
	        	System.out.println(String.format("║%-60s %-10s %-10s %-10s║","Name","Size","Type","SubFiles"));
	        	System.out.println(PrintHelper.printRowBordered(93, "-","║"));
	        	fileList=fileList.subList(0, Math.min(limit,fileList.size()));
	        	
	            for(File f:fileList)
	            {
	            	FolderTraverse temp  =new FolderTraverse(f.path);
		        	List<File> fl=temp.getFileList();
		        	f.setSubFolderSize(fl.size());
	            	System.out.println(f.toString());
	            	
	            }
	        	System.out.println(PrintHelper.printRowBordered(93, "-","║"));
	        
	      }
	    	 else
	    	    {
	    	    	System.out.println("None parameter!");
	    	    }
	    }
}
