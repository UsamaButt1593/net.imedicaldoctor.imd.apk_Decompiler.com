
function onBodyLoad() {
    var objBody = document.getElementsByTagName('body')[0];
    objBody.addEventListener("touchstart", touchStart, false);
    objBody.addEventListener("touchend", touchEnd, false);
    objBody.addEventListener("gestureend", gestureEnd, false);
    objBody.addEventListener("gesturestart", gestureStart, false);
    // try this for iOS 3.1.3 -- it doesn't like the CSS
    document.documentElement.style.webkitTouchCallout = "none";
}

var disableZoom = false;

function getUTDWebURLScheme() {
    return "zoomwebaction://";
}

function getUTDAppURLScheme() {
    return "zoomwebaction://";
}

function touchStart(event) {
    if (event.touches.length > 2) {
        disableZoom = true;
    }
}

function touchEnd(event) {
    disableZoom = false;
}

function gestureStart(event) {
    //    alert("mdown");
    event.preventDefault();
}

function gestureEnd(event) {
    if (!disableZoom) {
        var uri = null;
        
        if (event.scale > 1.0) {
            uri = getUTDWebURLScheme() + "zoomIn";
        } else {
            uri = getUTDWebURLScheme() + "zoomOut";
        }
        event.preventDefault();
        document.location.href = uri;
    }
}

function currentWebkitTextSizeAdjust() {
    var objBody = document.getElementsByTagName('body')[0];
    var size = objBody.style.webkitTextSizeAdjust;
    // (unset size is null)
    if (size == null) {
        size = 100;
    }
    return size;
}

function setWebkitTextSizeAdjust(percentInt) {
    var percentString = percentInt + "%";
    var ojbBody = document.getElementsByTagName('body')[0];
    ojbBody.style.webkitTextSizeAdjust = percentString;
    
    // send this request to hide the HUD (it says resizing text)
    var uri = getUTDWebURLScheme() + "zoomFinished";
    //alert(uri);
    document.location.href = uri;
    //    alert("hi" + body.style.webkitTextSizeAdjust);
}


// Use dim/undim with ontouchstart/ontouchend to make HTML elements (ie buttons) reponsive to touches.
function dim(element) {
    element.style.opacity = .5;    
}

function undim(element) {
    element.style.opacity = 1;
}
// JavaScript Document
function setFontSize(which_size) {
	var new_size = null;
	
	switch(which_size.toLowerCase()) {
		case "tiny":
			new_size = '.9em'
			break;
		case "small":
			new_size = '1.0em'
			break;
		case "large":
			new_size = '1.1em'
			break;
		case "huge":
			new_size = '1.2em'
			break;
		default:
			new_size = '1em'
			break;
	}
    
	$("body").css({"font-size" : new_size});
}

// JavaScript Document
function resizeImageHotspots(which_width) {
    which_width = which_width.substring(0, which_width.length - 2);
	var intWidth = parseInt(which_width);
    $(document).find('img')
    .each(function() {
          var imgWidth = parseInt($(this).attr('width'));
          var originalHeight = $(this).attr('originalHeight');
          var originalWidth = $(this).attr('originalWidth');
          
          if (originalHeight == null || originalWidth == null) {
              $(this).attr('originalHeight',$(this).attr('height'));
              $(this).attr('originalWidth',$(this).attr('width'));
              
              originalHeight = $(this).attr('height');
              originalWidth = $(this).attr('width');
          }
          
          if (intWidth < originalWidth) {
              var newHeight = originalHeight * (intWidth / originalWidth);
              $(this).attr('height', newHeight);
              $(this).attr('width', intWidth);
          } else if (intWidth < imgWidth) {
              var newHeight = originalHeight * (intWidth / imgWidth);
              $(this).attr('height', newHeight);
              $(this).attr('width', intWidth);
          } else {
              $(this).attr('height', originalHeight);
              $(this).attr('width', originalWidth);
          }
          
          if ((intWidth < originalWidth || intWidth < imgWidth) && $(this).attr('usemap')) {
              $(this).mapster({
                              onClick : function(e) {
                                  try {
                                      var clickEvent = document.createEvent('MouseEvents');
                                      clickEvent.initEvent('click',false,true);
                                      this.dispatchEvent(clickEvent);
                                  }catch(e){
    //                              alert(e);
                                  }
                              }
                              
                              });
              $(this).mapster('resize',intWidth,0,0);
          }
    });
}

function trim(stringToTrim) {
    if( stringToTrim == null) {
        return stringToTrim;
    }
    var patt1 = /^\s+|\s+$/g;
    return stringToTrim.replace(patt1,"");
}

function checkAnswers(actionstring) {
    var array = actionstring.split(";");
    var correct = false;
    var url;
    var incorrectString;
    
    for (var k = 0; k < array.length; k++) {
        var str = trim(array[k]);
        if (str.indexOf("url=") >= 0) {
            url = str.substring(4);
        } else if (str.indexOf("incorrect=") >= 0) {
            incorrectString = str.substring(10);
        }
    }
    
    $(document).find('input').
    each(function() {
         if ($(this).attr('inputType') != "BUTN") {
         var answer = trim($(this).attr('answer'));
         var value = trim($(this).attr('value'));
         
         if ($(this).attr('inputType') == "FITB") {
         if (answer.toUpperCase() == value.toUpperCase()) {
         correct = true;
         } else {
         correct = false;
         return false;
         }
         
         } else if ($(this).attr('inputType') == "OLMA") {
         var answerArray = answer.split(" ");
         var valueArray = value.split(" ");
         var allMatched = true;
         var count = 0;
         
         for (var i = 0; i < valueArray.length; i++) {
         var word = valueArray[i];
         
         if (word.length > 0) {
         if (count >= answerArray.length || word.toUpperCase() != answerArray[count].toUpperCase()) {
         correct = false;
         allMatched = false;
         break;
         }
         
         count++;
         }
         }
         
         if (allMatched && count == answerArray.length) {
         correct = true;
         } else {
         correct = false;
         return false;
         }
         } else if ($(this).attr('inputType') == "ULMA") {
         var answerArray = answer.toUpperCase().split(" ");
         var valueArray = value.toUpperCase().split(" ");
         var allMatched = true;
         var count = 0;
         var alreadyFoundElements = new Array();
         
         for (var i = 0; i < valueArray.length; i++) {
         var word = trim(valueArray[i]);
         
         if (word.length > 0 && alreadyFoundElements.indexOf(word) < 0) {
         if (count >= answerArray.length || answerArray.indexOf(word) < 0) {
         correct = false;
         allMatched = false;
         break;
         }
         
         count++;
         alreadyFoundElements.push(word);
         }
         }
         
         if (allMatched && count == answerArray.length) {
         correct = true;
         } else {
         correct = false;
         return false;
         }
         }
         
         }
         });
    var eventString ="";
    if (correct) {
        eventString = "skyscape:"+url;
    } else {
        eventString = "skyscape:tooltip:"+incorrectString;
    }
    
    $("#checkAnswerButton").attr('href',''+eventString);
    $("#checkAnswerButton").attr('rel','external');
    try {
        var clickEvent = document.createEvent('MouseEvents');
        clickEvent.initEvent('click',false,true);
        document.getElementById('checkAnswerButton').dispatchEvent(clickEvent);
    } catch(e){
        alert(e);
    } 		
}


function updateLinks() {
    var links = document.links;
    var qnaElements = new Array();
    var newElements = new Array();
    for (var i = 0; i < links.length; i++) {
    	var hrefUrl = links[i].getAttribute('href');
    	if(hrefUrl.indexOf('artinart:FORM%BUTN:') > -1) {
    		hrefUrl = hrefUrl.substring('artinart:FORM%BUTN:'.length).replace(/,,/gi,"@").replace(/,/gi,";").replace(/@/gi,",,").split(';');
    		qnaElements.push(links[i]);
    		newElements.push('<input type="button" value="'+hrefUrl[0].split('=')[1]+'\" onclick="checkAnswers(\''+hrefUrl[1]+";"+hrefUrl[2]+'\')\" /><a href="" id="checkAnswerButton" style="display:none;" ></a>');
    	} else if(hrefUrl.indexOf('artinart:FORM%OLMA') > -1 || hrefUrl.indexOf('artinart:FORM%ULMA') > -1 || hrefUrl.indexOf('artinart:FORM%FITB') > -1) {
    		qnaElements.push(links[i]);
    		newElements.push('<input  inputType="'+hrefUrl.split(':')[1].split('%')[1]+'\" answer="'+hrefUrl.split(':')[2].split('=')[1]+'"  />');
    	} else {
    		links[i].href = "skyscape:" + hrefUrl;
    	}
        
    }
    
    for(var i=0;i<qnaElements.length;i++) {
    	$(qnaElements[i]).replaceWith(newElements[i]);
    }
}

function findAndReplaceImageWithUnicode() {
    var images = document.images;
    var imageList = new Array();
    var textList = new Array();
    var numReplacements = 0;
    for (var i = 0; i < images.length; i++) {
        var attrib = images[i].getAttribute('unicode');
        if (attrib != null && attrib.length > 0) {
            var replacementStr = "";
            var charList = attrib.split(" ");
            
            for (var j = 0; j < charList.length; j++) {
                replacementStr += String.fromCharCode(parseInt(charList[j].substring(2), 16));
            }
            
            if (replacementStr.length > 0) {
                imageList.push(images[i]);
                textList.push(document.createTextNode(replacementStr));
                
                numReplacements++;
            }
        }
    }
    
    for (var k = 0; k < numReplacements; k++) {
        var image = imageList[k];
        var text = textList[k];
        
        image.parentNode.replaceChild(text, image);
    }
}

function getImageList() {
    var srcList = "";
    var images = document.images;
    for (var i = 0; i < images.length; i++) {
        if (i > 0) {
            srcList += "|";
        }
        
        srcList += images[i].getAttribute('src');
    }
    
    return srcList;
}

function updateImageSource(original, updated) {
    var images = document.images;
    
    for (var i = 0; i < images.length; i++) {
        if (images[i].getAttribute('src') == original) {
            images[i].src = updated;
        }
    }
}


function updatePlayImage() {
    var images = document.images;
    
    for (var i = 0; i < images.length; i++) {
        if (images[i].getAttribute('alt') == 'audio') {
            images[i].src = 'ssimages/play@2x.png';
        }
    }
}
