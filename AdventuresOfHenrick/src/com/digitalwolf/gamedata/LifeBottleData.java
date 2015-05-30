package com.digitalwolf.gamedata;

public class LifeBottleData {

	//Posicion de las botellas en fase 1, 2 etc...
	private static float[][] eggPosition1 = {
		{14.0f,15f},{82.0f,11f},
		
		};
	
	private static float[][] eggPosition2 = {
		{1, 16f},{21,4},{35,8}
		};
	
	private static float[][] eggPosition3 = {
		{24,4f},{41,17f}
		};
	
	
	private static float[][] eggPosition4 = {
		{2,16f},
		{72f,9f}
		};
	
	private static float[][] eggPosition5 = {
		{21,4f},{92f,10f},{51f,8f},{85f,6f},
		
		};

	
	private static float[][] eggPosition6 = {
		{0.6f,4},{17.8f,12},{33.7f,2}
		};
	
	private static float[][] eggPosition7 = {
		{29f,4f},{66f,6f},{78f,6f},{104f,1f},{122f,1f},{189f,10f},
		};
	
	private static float[][] eggPosition8 = {
		{122.5f,7f},{18.5f,11f},{83f,1f},{2f,16f},{87f,17f},{198f,16f}
		};
	
	
	//
	public static float[][] getLifeBottlePosition(int levelID) {
		switch(levelID){
		
		case 1:
			return eggPosition1;
		
		case 2:
			return eggPosition2;
			
		case 3:
			return eggPosition3;			
		
	    case 4:
		return eggPosition4;			
	    
        case 5:
	    return eggPosition5;
	    
        case 6:
		    return eggPosition6;	
		    
        case 7:
		    return eggPosition7;	
		    
        case 8:
		    return eggPosition8;	
        
	}	
		return eggPosition1;
	}


}
