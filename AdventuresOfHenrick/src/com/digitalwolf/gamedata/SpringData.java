package com.digitalwolf.gamedata;

public class SpringData {

	private static float[][] springPosition1 = {
	};
	
	private static float[][] springPosition2 = {
		{78f,4f},{14.5f,4f}
		};
	
	private static float[][] springPosition3 = {
		{0.3f,4f},{78f,4f}
		};
	
	private static float[][] springPosition4 = {
		{37.3f,4f},{32f,4f}
		};
	
	private static float[][] springPosition5 = {
		{14f,4f},{97f,4f}
		};
	
	private static float[][] springPosition6 = {
		{75f,4f}
		};
	
	private static float[][] springPosition7 = {
		{62f,1f},
		};
	
	private static float[][] springPosition8 = {
		
		};
	
	//ACCESSOR METHOD
	public static float[][] getSpringPosition(int levelID) {
		// TODO Auto-generated method stub
		
		switch(levelID){
		case 1:
			return springPosition1;
		
		case 2:
			return springPosition2;
			
		case 3:
			return springPosition3;			
		
	    case 4:
		return springPosition4;			
	    
        case 5:
	    return springPosition5;	
	    
        case 6:
		    return springPosition6;	
		    
        case 7:
		    return springPosition7;	
		    
        case 8:
		    return springPosition8;	
        
	}	
		return springPosition1;
	}
}
