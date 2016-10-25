jQuery(document).ready(function() {
  
   /*jQuery("#gallery").unitegallery({
       gallery_width:"100%"
   });*/
  // invokeTavantAds('1_t2ssbfzu');
   setInterval(function(){
	   invokeTavantAds();
	},5000);
   
});

var entryId = "";
var timeOutVar="";

function invokeTavantAds(){
	
	$.ajax({
	      type:"get",
	      url:"/livestream/FetchKalturaEntry",
	      datatype:"json",
	      success:function(response) {
	    	  var kalturaEntryId = response.entryId;
	    	  var time=response.time;
	    	  console.log(entryId);
	    	  
	    	  if(kalturaEntryId !='' && kalturaEntryId!=entryId ){
	    		  clearTimeout(timeOutVar);
	    		  console.log(entryId);
	    		  console.log("2");
	    		  
	    		  console.log(kalturaEntryId);
	    		  entryId = kalturaEntryId;
	    		  console.log("hello");
	    		  
	    		  console.log(time);
	    		  
	    		  //var kalturaScript = " <script src=\"https://cdnapisec.kaltura.com/p/2199811/sp/219981100/embedIframeJs/uiconf_id/36838491/partner_id/2199811?autoembed=true&entry_id="+kalturaEntryId+"&playerId=kaltura_player_1477208074&cache_st=1477208074&width=560&height=395&flashvars[streamerType]=auto\"></script>";
	    		  var kalturaScript = "<iframe src=\"http://www.kaltura.com/p/2199811/sp/219981100/embedIframeJs/uiconf_id/36776161/partner_id/2199811?iframeembed=true&playerId=kaltura_player_1477377967&entry_id="+kalturaEntryId+"&flashvars[autoPlay]=true&flashvars[share.plugin]=true width=\"400\" height=\"330\" allowfullscreen webkitallowfullscreen mozAllowFullScreen frameborder=\"0\"></iframe>";
	    		  jQuery("#tavantAdsVideo").html('');
	    		  jQuery("#tavantAdsVideo").html(kalturaScript);
	    		  jQuery("#livestreamVideo").hide();
	    		  jQuery("#tavantAdsVideo").show();
	    		  
	    		  timeOutVar = setTimeout(function(){
	    			  jQuery("#livestreamVideo").show();
		    		  jQuery("#tavantAdsVideo").hide();
		    		  console.log("intimeout");
	    			}, time*1000);
	    	  }
	      }
	    });
	   
	   
	
	
}