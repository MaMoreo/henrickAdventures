package com.digitalwolf.gamedata;

public class DragonData {

	private static float[][] dragonPosition1 = {
		{41,6.6f}, {78f, 16f}
		};
	
	private static float[][] dragonPosition2 = {
		{80,16f},{42f,9f}
		};
	
	private static float[][] dragonPosition3 = {
		{80,16f}, {34f,16f},{53.7f,4.4f}
		};


	private static float[][] dragonPosition4 = {
		{24.5f,11.5f},{72,16f}
		};

    private static float[][] dragonPosition5 = {
    	{37f,16.2f},
			};

	private static float[][] dragonPosition6 = {
				{33.7f,2}
				};

	private static float[][] dragonPosition7 = {
		{46f,15.7f},{183f,12f}
		};
	
	private static float[][] dragonPosition8 = {
		{24f,14f},{125f,11f},{179f,11f},
	};
	
	//
	public static float[][] getDragonPosition(int levelID) {
		// TODO Auto-generated method stub
		switch(levelID){
		case 1:
			return dragonPosition1;
		
		case 2:
			return dragonPosition2;
			
		case 3:
			return dragonPosition3;			
		
	    case 4:
		return dragonPosition4;			
	    
        case 5:
	    return dragonPosition5;	
	    
        case 6:
		    return dragonPosition6;	 
		    
        case 7:
		    return dragonPosition7;	 
		    
        case 8:
		    return dragonPosition8;	 
	}	
		return dragonPosition1;
	}
}
