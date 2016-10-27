
var entryId;

function changeMainUrl( xyz, current_play_type)
{
	
	
	
	
	 entryId=xyz;
	 
	 
    

	 jQuery("#vod_close_button").show();
	 $("#player").html(kWidget.embed({
			"targetId" : "kaltura_player_1477484309",
			"wid" : "_2199811",
			"uiconf_id" : 36776161,
			"flashvars" : {
				"streamerType" : "auto",
					"autoPlay": true
								},
			"cache_st" : 1477484309,
			"entry_id" : entryId
		}));
	 
	 
	 $("#player").attr('data-current_play_type',current_play_type);
	 
	 
	
 if(current_play_type=='close')
	 jQuery("#vod_close_button").hide();
	
 
 
 
 

	  console.log(' current_play_type'+current_play_type)	;
	 
	 
}


function playAdd( xyz, current_play_type, time_start)
{
	
	
	
	
	 entryId=xyz;
	 
	 
	
	var current= $("#player").attr("data-current_play_type");

	 
	 console.log("current_play_type"+current);
	 
	 
		 jQuery("#vod_close_button").hide();
		 $("#player").html(kWidget.embed({
				"targetId" : "kaltura_player_1477484309",
				"wid" : "_2199811",
				"uiconf_id" : 36776161,
				"flashvars" : {
					'streamerType' : 'auto',
						'autoPlay': true,
						'mediaProxy.mediaPlayFrom' : time_start,
						
						'externalInterfaceDisabled' : false 
				},
				"cache_st" : 1477484309,
				"entry_id" : entryId
			}));	

	 $("#player").attr('data-current_play_type',current_play_type);
	 
}


