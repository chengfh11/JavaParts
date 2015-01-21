package parts;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.KeywordAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;

/** Index all text files under a directory. */
public class IndexFiles
{

	private IndexFiles()
	{
	}

	static final File INDEX_DIR = new File("C:\\development\\index");

	/** Index all text files under a directory. */
	public static void main(String[] args)
	{

		boolean remote = true;

		String lo = "SA34";
		String contentPath = "";

		String[] arg;

		String basePath = "";

		if (remote)
		{
			basePath = "Z:\\";
			arg = new String[] { lo, "remote" };

		}
		else
		{
			basePath = "C:\\development\\apache-tomcat-6.0.26\\apache-tomcat-6.0.26\\webapps\\pc-content\\xml\\";
			arg = new String[] { lo, "" };
		}
		if (lo.contains("SA"))
		{
			contentPath = basePath + "ip\\M\\SAT\\" + lo;
		}
		else if (lo.contains("AC"))
		{
			contentPath = basePath + "ip\\M\\ACT\\" + lo;
		}
		else if (lo.contains("PS"))
		{
			contentPath = basePath + "ip\\M\\PSA\\" + lo;
		}

		if (INDEX_DIR.exists())
		{
			System.out.println("Cannot save index to '" + INDEX_DIR + "' directory, please delete it first");
			System.out.println("deleting directory. Success --> " + deleteDirectory(INDEX_DIR));
		}

		final File docDir = new File(contentPath);
		if (!docDir.exists() || !docDir.canRead())
		{
			System.out.println("Document directory '" + docDir.getAbsolutePath() + "' does not exist or is not readable, please check the path");
			System.exit(1);
		}

		Date start = new Date();
		try
		{
			IndexWriter writer = new IndexWriter(FSDirectory.open(INDEX_DIR), new KeywordAnalyzer(), true, IndexWriter.MaxFieldLength.LIMITED);
			System.out.println("Indexing to directory '" + INDEX_DIR + "'...");
			indexDocs(writer, docDir);
			System.out.println("Optimizing...");
			writer.optimize();
			writer.close();

			Date end = new Date();
			System.out.println(((end.getTime() - start.getTime()) / 1000) + " total seconds");

		}
		catch (IOException e)
		{
			System.out.println(" caught a " + e.getClass() + "\n with message: " + e.getMessage());
		}
		IPQIImageInfo.main(arg);
	}

	static void indexDocs(IndexWriter writer, File file) throws IOException
	{
		// do not try to index files that cannot be read
		if (file.canRead())
		{
			if (file.isDirectory())
			{
				String[] files = file.list();
				// an IO error could occur
				if (files != null)
				{
					for (int i = 0; i < files.length; i++)
					{
						indexDocs(writer, new File(file, files[i]));
					}
				}
			}
			else
			{
				try
				{
					if (!(file.getName().contains("svn") || file.getName().contains("entries") || file.getName().contains(".swf") || file.getName().contains(".xml")))
					{
						System.out.println("adding " + file);
						writer.addDocument(FileDocument.Document(file));
					}
				}
				// at least on windows, some temporary files raise this exception with an "access denied" message
				// checking if the file can be read doesn't help
				catch (FileNotFoundException fnfe)
				{
					;
				}
			}
		}
	}

	static public boolean deleteDirectory(File path)
	{
		if (path.exists())
		{
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++)
			{
				if (files[i].isDirectory())
				{
					deleteDirectory(files[i]);
				}
				else
				{
					files[i].delete();
				}
			}
		}
		return (path.delete());
	}
}
