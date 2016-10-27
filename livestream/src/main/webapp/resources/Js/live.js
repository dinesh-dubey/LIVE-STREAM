
var entryId;

$(document).ready(function() {
	$(".thumbnail").click(function () {
	    $(".thumbnail").removeClass("active");
	    $(this).addClass("active");        
	});
	});
function changeMainUrl( xyz, current_play_type)
{
	/*$("#responsive li a").removeClass('active');
	$(this).addClass("active");
	console.log(this);*/
	
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
	 
	 
	
 if(current_play_type!='vod')
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
						'controlBarContainer.plugin': false
						
				},
				"cache_st" : 1477484309,
				"entry_id" : entryId
			}));	

	 $("#player").attr('data-current_play_type',current_play_type);
	 
}


