package bench.test;

import bench.cpu.CPUThreading;
import logging.ConsoleLogger;
import logging.ILogger;
import logging.JSONDBLogger;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class executor {
	public float score;

	public void execute() {
		PCSpecs specs = new PCSpecs();
		specs.PCSpec();

		int cores = Integer.valueOf(specs.proc4);
		// int cores = 2;
		ITimer timer = new Timer();
		ILogger log = new ConsoleLogger();
		JSONDBLogger jdb = new JSONDBLogger("db.json", true);
		TimeUnit timeUnit = TimeUnit.milli;
		CPUThreading bench = new CPUThreading();
		long time;

		bench.initialize(10000000);
		for (int threads = 1; threads <= cores * 2; threads *= 2) {
			timer.start();
			bench.run(new Integer(threads));
			time = timer.stop();
			score = 0.0f;
			log.write("Threads:", threads, "-> time:", (time / 1000000), "ms");
			time = time / 1000000;

			score += threads * 100000 / time;

			log.writeTime(timer.stop(), timeUnit);
		}
		log.write("SCORE:", score);
		
		jdb.add("Hostname", specs.hostname);
		jdb.add("IPAdress", specs.ipadress);
		jdb.add("OS Name", specs.hostname);
		jdb.add("OS Type", specs.ostype);
		jdb.add("CPU Identifier", specs.proc1);
		jdb.add("CPU Architecture", specs.proc2);
//		the following line returns null pointer exception
//		jdb.add("CPU ArchitEW6432", specs.proc3);
		jdb.add("CPU Nr. of Cores", specs.proc4);
		jdb.add("Score", score);
		jdb.write();
	}
}
