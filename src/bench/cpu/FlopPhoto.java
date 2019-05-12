package bench.cpu;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

import bench.IBenchmark;

public class FlopPhoto implements IBenchmark
{
	BufferedImage img,copy;
	int height,width;
	
	@Override
	public void initialize(int size) {
		BufferedImage img = null;
		//reading an image
		try 
		{
		    img = ImageIO.read(new File("strawberry.jpeg"));
		}
		catch(IOException e) 
		{
			System.out.println("Image reading failed");
		}
		
	    height = img.getHeight();
	    width = img.getWidth();
	    BufferedImage copy = img;
		
	}
	@Override
	public void run() {
		for(int i=0;i<1000000; i++)
		{
			for(int x=0; x<width; x++)
				for(int y=0; y<height/2; y++)
				{
					int tmp = img.getRGB(x,y);
		            img.setRGB(x,y, img.getRGB(x,img.getHeight()-y-1));
		            img.setRGB(x, img.getHeight()-y-1, tmp);
				}
		}
	}
	@Override
	public void run(Object option) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void warmUp() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void warmUp(Object option) {
		// TODO Auto-generated method stub
		
	}

}
