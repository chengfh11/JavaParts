package parts;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMParser
{
	public static void main(String argv[])
	{
		try
		{
			// This was feed xml
			File fXmlFile = new File("/Users/archer/Downloads/junk.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			// convert Document to string
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString().replaceAll("\n|\r", "");
			// -------------------

			System.out.println(">>> " + output);

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