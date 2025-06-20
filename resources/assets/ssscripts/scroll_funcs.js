// JavaScript Document
//$("#bodyContainer").bind( "scroll",    render );
//$(window).scroll(render);
// shim for frame listener

window.requestAnimFrame = (function(){
	
      return  window.requestAnimationFrame       || 
              window.webkitRequestAnimationFrame || 
              window.mozRequestAnimationFrame    || 
              window.oRequestAnimationFrame      || 
              window.msRequestAnimationFrame     || 
              function( callback ){
                window.setTimeout(callback, 1000 / 60);
              };
    })();

	
    // on every frame, call render()
    (function animloop(){
      requestAnimFrame(animloop);
      render();
    })();

/**/

var lastScroll = 0, isScrolling = false;
function render(){
	//alert("BAH");
  var thisScroll = $(window).scrollTop();
  var scrollTops = new Array();
  
  var entryLength = document.getElementsByClassName("entryarea").length;
  
  
  for (var i = 0; i<entryLength; i++) {
		scrollTops.push($(document.getElementsByClassName("entryarea").item(i)).offset().top);  
		
		if ((thisScroll + $('#bodyContainer').offset().top) >= scrollTops[i]) {
			if (i !== 0) {
				var prevEl = $(document.getElementsByClassName("entryarea").item(i-1));
			}
			var el = $(document.getElementsByClassName("entryarea").item(i));
			if (prevEl) {
				if (prevEl.hasClass ('active')) {
					prevEl.removeClass('active');
				}
			}
			if (!el.hasClass ('active')) {
				el.addClass('active');
			}
		} else {
			var el = $(document.getElementsByClassName("entryarea").item(i));
			if (el.hasClass ('active')) {
				el.removeClass('active');
			}
		}
  }
    
  if(lastScroll !== thisScroll){
     if(!isScrolling){
        // scrolling has started, fade out div
       // $('#search_tab').stop().fadeOut('slow'); 
     }
     isScrolling = true;
   }else{
     if(isScrolling){
       // scrolling has stopped, fade in div
       //$('#search_tab').stop().fadeIn('slow'); 
     }
     isScrolling = false;
  }
  lastScroll = thisScroll;
}

function scrollPageToId(id) {
	var scrollTopAmt = $(id).offset().top + "px";
	$("html, body").animate({ scrollTop: scrollTopAmt  });
}

function findAndScrollToParentContainer(eId) {
    // Find the closest outer div with class entryarea
    var el = $('#' + eId).closest(".entryarea");
    
    if (el) {
        scrollPageToId('#' + el.attr('id'));
    }
}


//