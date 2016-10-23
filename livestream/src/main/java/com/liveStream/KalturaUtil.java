package com.liveStream;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kaltura.client.KalturaApiException;
import com.kaltura.client.types.KalturaBaseEntry;
import com.kaltura.client.types.KalturaMediaEntry;
import com.kaltura.client.types.KalturaMediaListResponse;
import com.kaltura.client.types.KalturaPlaylist;

public class KalturaUtil {

	static Logger log = Logger.getLogger(KalturaUtil.class.getName());
	   
	
	public  KalturaMediaListResponse retrieveMediaList() throws KalturaApiException {
		KalturaMediaListResponse list =null;
		try
		{
		 list =  KalturaSessionGen.getClient().getMediaService().list();
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
			
		}
		
	return list;
	
	}
		
	
	
	public  ArrayList retrieveMediaMetaData()  {

		ArrayList metaData_media=new ArrayList();
		try
		{
		KalturaMediaListResponse list =  retrieveMediaList();
	
		
		if (list.totalCount > 0) {
			System.out.println("The account contains " + list.totalCount + " entries.");
			for (KalturaBaseEntry entry : list.objects) {
				metaData_media.add(entry);
				System.out.println("\t \"" + entry.name + "\""+" "+entry.tags);
			}
		} else {
			System.out.println("This account doesn't have any entries in it.");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	return metaData_media;
	
	}
	
	
	
	public  ArrayList retrievePlaylistMetaData()  {

		ArrayList metaData_media=new ArrayList();
		try
		{
		KalturaPlaylist list ;
	
		 list =  KalturaSessionGen.getClient().getPlaylistService().get("0_c398if1h");
		if (list !=null) {
			
				System.out.println("\t \"" + list.executeUrl + "\"");
			
		} else {
			System.out.println("This account doesn't have any entries in it.");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	return metaData_media;
	
	}
	
	
}
