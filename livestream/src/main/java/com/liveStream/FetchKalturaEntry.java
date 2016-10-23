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
		ServletContext context = getServletContext();
		if (context.getAttribute("kalturaEntryId") != null) {
			entryId = context.getAttribute("kalturaEntryId").toString();
		}else{
			context.setAttribute("kalturaEntryId","1_t2ssbfzu");
			entryId = context.getAttribute("kalturaEntryId").toString();
		}
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("entryId", entryId);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonObject.toString());
		} catch (JSONException e) {

		}
	}

}
