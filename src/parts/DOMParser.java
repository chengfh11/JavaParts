package junk;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMParser
{
	public static void main(String argv[])
	{
		try
		{

			File fXmlFile = new File("/Users/archer/Downloads/junk.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			Node channelNode = doc.getElementsByTagName("channel").item(0);
			Node itemNode = doc.getElementsByTagName("item").item(0);

			if (itemNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element itemElement = (Element) itemNode;
				System.out.println("item title: " + itemElement.getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
				System.out.println("item link: " + itemElement.getElementsByTagName("link").item(0).getFirstChild().getNodeValue());
				System.out.println("item pubDate: " + itemElement.getElementsByTagName("pubDate").item(0).getFirstChild().getNodeValue());
			}

			if (channelNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) channelNode;
				System.out.println("channel title: " + eElement.getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
				System.out.println("channel description: " + eElement.getElementsByTagName("description").item(0).getFirstChild().getNodeValue());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}