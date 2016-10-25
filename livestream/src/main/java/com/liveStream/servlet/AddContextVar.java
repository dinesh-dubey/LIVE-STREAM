package com.liveStream.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaltura.client.KalturaApiException;
import com.kaltura.client.types.KalturaBaseEntry;
import com.kaltura.client.types.KalturaMediaEntry;
import com.kaltura.client.types.KalturaMediaInfo;
import com.kaltura.client.types.KalturaMediaListResponse;
import com.kaltura.client.types.KalturaPlayableEntry;
import com.liveStream.KalturaSessionGen;

/**
 * Servlet implementation class AddContextVar
 */

public class AddContextVar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContextVar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String taggedVideo=request.getParameter("taggedVideo");
		
		
		KalturaMediaEntry km=null;
		try {
			km = KalturaSessionGen.getClient().getMediaService().get(taggedVideo);
		} catch (KalturaApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int  videoDuration=km.duration;
		
		ServletContext context=getServletContext();  
		context.setAttribute("taggedVideo", taggedVideo);
		context.setAttribute("videoduration", videoDuration);
		
		System.out.println(context.getAttribute("taggedVideo"));
		System.out.println(context.getAttribute("videoduration"));
		
		try {
			Thread.sleep(videoDuration*1000);
			removecontextattr(context);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
 
	 
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	public static  void removecontextattr (ServletContext context){
		
	context.removeAttribute("taggedVideo");
	System.out.println("hi"+context.getAttribute("taggedVideo"));
	context.removeAttribute("videoduration");

	
	
	}

}
