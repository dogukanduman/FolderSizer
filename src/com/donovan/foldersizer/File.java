package com.donovan.foldersizer;

import java.nio.file.Path;

public class File implements Comparable<File> {
String fileName;
String extension;
String type;
long size;
Path path;
DataSizeType dataSizeType;
int subFolderSize;

public File(String fileName, long size,String type,Path path)  {
	super();
	this.fileName = fileName;
	this.extension = "";
	this.size = size;
	this.type=type;
	this.path=path;
	this.dataSizeType=DataSizeType.getDataSizeType(size);
}

public String getFileName() {
	return fileName;
}

public String getExtension() {
	return extension;
}

public String getType() {
	return type;
}

public long getSize() {
	return size;
}

public Path getPath() {
	return path;
}

public int getSubFolderSize() {
	return subFolderSize;
}

public void setSubFolderSize(int subFolderSize) {
	this.subFolderSize = subFolderSize;
}
@Override
public int compareTo(File o) {
	 return this.size > o.size ? -1 : (this.size == o.size ? 0 : 1);
}
@Override
public String toString() {
	
	return String.format("║%-60s %-10s %-10s %-10s║", fileName.length()>60?fileName.substring(0,60):fileName,DataSizeType.format(this.size,this.dataSizeType ),this.type,this.type.equals("Folder")?subFolderSize:0);
	
	/*return "File [fileName=" + fileName + ", extension=" + extension + ", type=" + type + ", size=" + size + ", path="
			+ path + "]";*/
}


}
