package com.liveStream;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class FetchKalturaEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String entryId = "";
		int time=0;
	long loginTime=	System.currentTimeMillis();
		ServletContext context = getServletContext();
		
		if (context.getAttribute("videoduration") != null) {
			 time = Integer.parseInt(context.getAttribute("videoduration").toString());
		}
		
		if (context.getAttribute("taggedVideo") != null) {
			entryId = context.getAttribute("taggedVideo").toString();
		}/*else{
			context.setAttribute("taggedVideo","1_t2ssbfzu");
			entryId = context.getAttribute("taggedVideo").toString();
		}*/
		
		
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("entryId", entryId);
			jsonObject.put("time", time);
			
			if(null !=context.getAttribute("pushtime")){
				long pushTime=(long) context.getAttribute("pushtime");
				long timediff=(pushTime-loginTime)/1000;
				jsonObject.put("timediff", timediff);
				}
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonObject.toString());
		} catch (JSONException e) {

		}
	}

}
