package parts;

import javax.swing.ImageIcon;

public class ImageSize
{

	public static ImageIcon image;

	public static void main(String[] args)
	{

		String path = "C://development//apache-tomcat-6.0.26//apache-tomcat-6.0.26//webapps//pc-content//trunk//xml//ip//M//SAT//SA38//images//";
		String name = "M-SAT-SA38-P007-C14-G.swf";

		image = new ImageIcon(path + name);

		int width = image.getIconWidth();
		int height = image.getIconHeight();
		System.out.println("The width of image: " + width);
		System.out.println("The height of image: " + height);
	}

}