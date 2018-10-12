package testNG_Package;

import java.time.LocalTime;


import org.testng.annotations.Test;

public class Randomtime {
	static LocalTime localTime;
	static long currentmins;
	static long remainingminstoday;
	static long randomtime;
	
	// @Test(enabled=false)          // if any unit not ready - this method. if ready - can change to @Test(enabled=true)    
	//@Test(priority=1)
	@Test
		public static void Current_local_Time() {
		
	    localTime = LocalTime.now();
	    System.out.println("Hour : " + localTime.getHour());
	    System.out.println("Minute : " + localTime.getMinute());
	    System.out.println("Second : " + localTime.getSecond());
		}
    //@Test(enabled=false)
	//@Test(priority=2)
    //@Test(dependsOnMethods="") // if any method depends on other method
	@Test	    
	    public static void Find_Today_RemaingMinutes() {
	    	
	     currentmins = (localTime.getHour()*60) + localTime.getMinute();
	     remainingminstoday = 1439 - currentmins;
	     randomtime=(int)(Math.random()*((remainingminstoday-0)+1))+0;
    }
	@Test 
    public static void RandomTime_into_LocalTime() {
	    localTime = localTime.plusMinutes(randomtime);
	    }
   @Test	    
       public static void Elapsed_minutes(){
	    	
	    System.out.println("Elapsed Mins : " + currentmins);
	    
	    }
	    
   @Test
       public static void Remaining_Minutes() {
	    	
	    System.out.println("Remaining mins today : " + remainingminstoday);
	    }

   @Test
	   public static void Random_Minutes() {
	    System.out.println("Random minutes added : " + randomtime);
	    }
   
   @Test
	   public static void Random_Time_After_Added() {
	    System.out.println("Random time after current time : " + localTime);
	   }
	
   @Test
       public static void Cron_Tab() {
	    System.out.println("Cron tab : " + localTime.getMinute() + " " + localTime.getHour() + " * * *");
	}

}
