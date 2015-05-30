package com.digitalwolf.gamedata;

public class KeyData {

	private static float[][] keyPosition1 = {
		{86.5f, 15.5f}
		};
	
	private static float[][] keyPosition2 = {
		{86,16}
		};
	
	private static float[][] keyPosition3 = {
		{86f,17f}
		};
	
	private static float[][] keyPosition4 = {
		{80,17f}
		};
	
	private static float[][] keyPosition5 = {
		{52,16f}
		};
	
	
	private static float[][] keyPosition6 = {
		{79f,5f}
		};
	
	private static float[][] keyPosition7 = {
		{188f,16f}
		};
	
	private static float[][] keyPosition8 = {
		{186f,1f}
		};
	//
	public static float[][] getKeyPosition(int levelID) {
		// TODO Auto-generated method stub
		switch(levelID){
	case 1:
		return keyPosition1;
	
	case 2:
		return keyPosition2;
		
	case 3:
		return keyPosition3;			
	
    case 4:
	return keyPosition4;			
    
    case 5:
    return keyPosition5;	
    
    case 6:
	    return keyPosition6;	
	    
    case 7:
	    return keyPosition7;	
	    
    case 8:
	    return keyPosition8;	
}	
	return keyPosition1;
}

}
