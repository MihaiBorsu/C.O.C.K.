package bench;

import bench.cpu.CPUFixedPoint;
import bench.cpu.CPUThreadedHashing;
import bench.cpu.CPUThreadedHashing_2;
import bench.cpu.FixedPointOption;
import logging.ConsoleLogger;
import logging.FileLogger;
import logging.ILogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class demo {

	public static void main(String[] args) {

 		ITimer timer = new Timer();
 		ILogger log = new ConsoleLogger();	
 		TimeUnit timeUnit = TimeUnit.milli;				
 	//	CPUThreadedHashing bench = new CPUThreadedHashing();	
  	   CPUThreadedHashing_2 bench = new CPUThreadedHashing_2();	
 		
  	// int hashCode = 790776505; //  "hash"
 		 int hashCode = 1676316699;//   "akaroa"
  		// int hashCode = 132368363; //  bonusHash
 		
 		Integer[] param = new Integer[] { new Integer(6), 
 										  new Integer(hashCode),
 										  new Integer(4)};
 				
 		System.out.println("Start!\n");	
 		timer.start();
 		bench.run(param);
 		log.writeTime(timer.stop(), timeUnit);		
  		System.out.println("Results: " + bench.getResult().toString());
 		log.close();

	}
}