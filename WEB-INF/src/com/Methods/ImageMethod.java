package com.Methods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Dao.ImageDAO;

public class ImageMethod 
{
	static ResultSet rs=null;
	static boolean flag=false;
	
	//----------------------------Remove Unwanted Topics------------------------
	
	public static String RemoveUnwantedTopics(String m_comment_word)
	{
		String preposition[]={"a","an","at","the","of","that","on","is","this","am",
				"it","in","then","them","from","or","its","you","like","too","i","and",
				"he","she","not","no"};
		
			
			for(int j=0;j<preposition.length;j++)
			{
				if(m_comment_word.equals(preposition[j]))
				{
					m_comment_word=null;
					break;
				}
			}
		
		return m_comment_word;
		
	}
	
	//---------------------------- Remove Repeated Topics------------------------
	
	public static ArrayList<String> RemoveRepeatedTopics(ArrayList topic_list)
	{
		if(topic_list.size()!=0 && topic_list!=null)
		{
			for(int i=0;i<topic_list.size();i++)
			{
				String t=(String) topic_list.get(i);
				
				System.out.println(" topic_list  :"+t);
				for(int j=i+1;j<topic_list.size();j++)
				{
					String t1=(String) topic_list.get(j);
				
					System.out.println(" t1 img_list :"+t1+" J value L:"+j);
					
					if(t.equals(t1))
					{
						System.out.println("*********************************");
						topic_list.remove(j);
						System.out.println(" topic_list(remove) i :"+topic_list);
						j--;
						
					}
				}
			}
		}
		return topic_list;
		
	}
	
	
	
	
	
}
