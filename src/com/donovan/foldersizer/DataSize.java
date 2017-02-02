package com.donovan.foldersizer;
enum DataSizeType {
	Byte(1){
	    @Override
	    public String toString() {
	      return "B";
	    }
	  },
	KiloByte(1000){
	    @Override
	    public String toString() {
	      return "KB";
	    }
	  },
	MegeByte(1000*1000) {
	    @Override
	    public String toString() {
	      return "MB";
	    }
	  },
	GigaByte(1000*1000*1000){
	    @Override
	    public String toString() {
	      return "GB";
	    }
	  };
	
	  private final int value;

	    private DataSizeType(int value) {
	        this.value = value;
	    }
	    
	    public int getValue() {
	        return value;
	    }
	    public static DataSizeType getDataSizeType(long dataSize) {
	    	
	    	if(dataSize<KiloByte.getValue())
	    	{
	    		 return Byte;	
	    	}
	    	if(dataSize<MegeByte.getValue())
	    	{
	    		 return KiloByte;	
	    	}
	    	if(dataSize<GigaByte.getValue())
	    	{
	    		 return MegeByte;	
	    	}
	    	return GigaByte;
	    	
	       
	    }
	    public static String format(long size,DataSizeType type)
	    {
	    	return (size/type.getValue())+type.toString();
	    }
}


