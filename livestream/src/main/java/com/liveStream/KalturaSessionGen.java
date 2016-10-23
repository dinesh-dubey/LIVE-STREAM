package com.liveStream;

import java.util.ArrayList;
import java.util.Iterator;

import com.kaltura.client.KalturaApiException;
import com.kaltura.client.KalturaClient;
import com.kaltura.client.KalturaConfiguration;
import com.kaltura.client.enums.KalturaSessionType;
import com.kaltura.client.types.KalturaLiveStreamConfiguration;
import com.kaltura.client.types.KalturaLiveStreamEntry;
import com.kaltura.client.types.KalturaMediaEntry;
import com.kaltura.client.types.KalturaMediaListResponse;
import com.kaltura.client.types.KalturaMetadataListResponse;

public class KalturaSessionGen {
	static KalturaClient  client=null;
	
	public static void main(String... s) throws KalturaApiException
	{
		
		
		list();
	}
	
	public  static KalturaClient getClient()
	{
		String secret = "cb70c153f1825b0e9cd518fee32b763b" ; // Secret Id
		String userId = "fb94f1b9fc0bc785d49407d654a32fde"; //add user id
		int partnerId = 2199811; //add user id
		
		String serviceUrl="http://www.kaltura.com/";
		KalturaSessionType type = KalturaSessionType.ADMIN;
		/* It is enum defined in kaltura api . It could if either KalturaSessionType.USER or KalturaSessionType.ADMIN */
		//int partnerId = 100;
		int expiry = 0;
		
		
		String ks="";
		KalturaConfiguration config = new KalturaConfiguration();
		config.setEndpoint(serviceUrl);
		try {
			// Create the client and open session
			if(client==null)
			{
				client = new KalturaClient(config);
			 ks = client.generateSession(secret, userId, KalturaSessionType.ADMIN, partnerId);
			client.setSessionId(ks);
			//KalturaMetadataListResponse list=	client.getMetadataService().list();
			
			}
			else
				return client;
			
			
		} catch(Exception ex) {
			client = null;
			System.out.print("Exception msg:"+ex.getMessage());
		}
		
		
		System.out.println("Generated KS locally: [" + client.getSessionId() + "]");
	
		
		return client;
	}
	
	
	static void list() throws KalturaApiException {

		KalturaMediaListResponse list =  getClient().getMediaService().list();
		if (list.totalCount > 0) {
			System.out.println("The account contains " + list.totalCount + " entries.");
			for (KalturaMediaEntry entry : list.objects) {
				System.out.println("\t \"" + entry.name + "\"");
			}
		} else {
			System.out.println("This account doesn't have any entries in it.");
		}
	
		
		String entryId="0_oosnpuph";
		/*for live entry
		KalturaLiveStreamEntry liveEntry=getClient().getLiveStreamService().get(entryId);
		String dataUrl=liveEntry.streamUrl;
		
		ArrayList urlObj=getClient().getLiveStreamService().get(entryId).liveStreamConfigurations;
		
		System.out.println("Stream url:");
		
		KalturaLiveStreamConfiguration obj[]=new KalturaLiveStreamConfiguration[urlObj.size()];
		
		System.out.println("==> For Loop Example.");
		for (int i = 0; i < urlObj.size(); i++) {
			 obj[i]=(KalturaLiveStreamConfiguration) urlObj.get(i);
			
			
			
		}
 
		System.out.println(	obj[1].streamName+" "+obj[1].publishUrl);
		
		
		System.out.println(liveEntry.name);
		*/
		 entryId="1_6a0qjqkg";
		
		KalturaMediaEntry mediaEntry = getClient().getMediaService().get(entryId);
		System.out.print(mediaEntry.name);
		
		System.out.print(mediaEntry.dataUrl);
		
		
}
	
}
