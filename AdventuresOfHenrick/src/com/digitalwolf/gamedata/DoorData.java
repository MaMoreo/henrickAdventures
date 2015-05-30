package com.digitalwolf.gamedata;

public class DoorData {

	private static float[][] doorPosition1 = {
		{86f,4f}
		};
	
	private static float[][] doorPosition2 = {
		{86f,4f}
		};
	
	private static float[][] doorPosition3 = {
			{86f,4f}
			};
		
	private static float[][] doorPosition4 = {
		{4f,4f}
		};
	
	private static float[][] doorPosition5 = {
		{116f,11f}
		};
	
	private static float[][] doorPosition6 = {
		{1f,13f}
		};
	
	private static float[][] doorPosition7 = {
		{139f,1f}
		};
	
	private static float[][] doorPosition8 = {
		{181f,15f}
		};
	
	public static float[][] getDoorPosition(int levelID) {
		// TODO Auto-generated method stub
		switch(levelID){
		case 1:
			return doorPosition1;
		
		case 2:
			return doorPosition2;
			
		case 3:
			return doorPosition3;			
		
	    case 4:
		return doorPosition4;			
	    
        case 5:
	    return doorPosition5;	
	    
        case 6:
		    return doorPosition6;
		    
        case 7:
		    return doorPosition7;
		    
        case 8:
		    return doorPosition8;
        
	}	
		return doorPosition1;
	}
}
