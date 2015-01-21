package parts;

public class ImageInfo
{

	int width;
	int height;
	String format;

	public ImageInfo()
	{
		width = 20;
		height = 20;
		format = "gif";
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public String getFormat()
	{
		return format;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

}
