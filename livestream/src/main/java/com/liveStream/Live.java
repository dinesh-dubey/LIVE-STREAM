package com.liveStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
//import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaltura.client.KalturaApiException;

//import org.apache.commons.httpclient.util.HttpURLConnection;

/**
 * Servlet implementation class Live
 */
public class Live extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Live() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("--------------doGet--------------------");

		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			System.out.println("--------------doPost--------------------");
			
			String entryId="1_6a0qjqkg";
		//	String entryId="0_oosnpuph";
			
			System.out.println("hi");
			
KalturaSessionGen ksg=new KalturaSessionGen();

String ks=ksg.getClient().getSessionId();
			URL url = new URL(
					"http://www.kaltura.com/api_v3/index.php?service=media&action=get&entryId="+entryId+"&ks="+ks);
			
			System.out.print(url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();
			
			
			ksg.list();
		//	response.sendRedirect("player.html"); 
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);

		} catch (MalformedURLException e) {


		} catch (IOException e) {

			e.printStackTrace();

		} catch (KalturaApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	

}
