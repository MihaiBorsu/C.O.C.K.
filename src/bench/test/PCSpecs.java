package bench.test;

import java.io.BufferedReader;
import java.io.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.*;

public class PCSpecs {
	public String hostname;
	public String ipadress;
	public String nameos;
	public String ostype;
	public String osversion;
	public String proc1; //CPU Identifier
	public String proc2; //CPU Architecture:
	public String proc3; //CPU ArchitEW6432
	public String proc4; //CPU no of cores
	private String command="";
	
	private int getNumberOfCPUCores() {
	    OSValidator osValidator = new OSValidator();
	    String command = "";
	    if(osValidator.isMac()){
	        command = "sysctl -n machdep.cpu.core_count";
	    }else if(osValidator.isUnix()){
	        command = "lscpu";
	    }else if(osValidator.isWindows()){
	        command = "cmd /C WMIC CPU Get /Format:List";
	    }
	    Process process = null;
	    int numberOfCores = 0;
	    int sockets = 0;
	    try {
	        if(osValidator.isMac()){
	            String[] cmd = { "/bin/sh", "-c", command};
	            process = Runtime.getRuntime().exec(cmd);
	        }else{
	            process = Runtime.getRuntime().exec(command);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    BufferedReader reader = new BufferedReader(
	            new InputStreamReader(process.getInputStream()));
	    String line;

	    try {
	        while ((line = reader.readLine()) != null) {
	            if(osValidator.isMac()){
	                numberOfCores = line.length() > 0 ? Integer.parseInt(line) : 0;
	            }else if (osValidator.isUnix()) {
	                if (line.contains("Core(s) per socket:")) {
	                    numberOfCores = Integer.parseInt(line.split("\\s+")[line.split("\\s+").length - 1]);
	                }
	                if(line.contains("Socket(s):")){
	                    sockets = Integer.parseInt(line.split("\\s+")[line.split("\\s+").length - 1]);
	                }
	            } else if (osValidator.isWindows()) {
	                if (line.contains("NumberOfCores")) {
	                    numberOfCores = Integer.parseInt(line.split("=")[1]);
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    if(osValidator.isUnix()){
	        return numberOfCores * sockets;
	    }
	    return numberOfCores;
	}

	public void PCSpec() {

		InetAddress ip;

		try {
			ip = InetAddress.getLocalHost();

			hostname = ip.getHostName();
			ipadress = ip.getHostAddress();
			nameos = System.getProperty("os.name");
			ostype = System.getProperty("os.arch");
			osversion = System.getProperty("os.version");
			//final byte[] address = NetworkInterface.getNetworkInterfaces().nextElement().getHardwareAddress();
			proc1 = System.getenv("PROCESSOR_IDENTIFIER");//Arrays.toString(address)
			proc2 = System.getenv("PROCESSOR_ARCHITECTURE");
			proc3 = System.getenv("PROCESSOR_ARCHITEW6432");
			proc4 = String.valueOf(getNumberOfCPUCores());
		}
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}