

var jumped = false;
var EN4LanguageName = "";
var EN4EJdict = false;
var EN4thes = false;
var EN4iPad = false;
var EN4flashDef = false;
var EN4actionMenu = true;
var x = 0;
var pinched = false;
var firsttap = true;
watchtap = false;
var myBack = "";

document.addEventListener('touchstart', function(e) {
if (watchtap)
{
window.location.href = 'gottap://';
watchtap = false;
}
if (firsttap)
{
window.location.href = 'firsttap://';
firsttap = false;
}
}, false);

function arrowf(el)
{
el.parentElement.style.webkitBoxShadow = 'none';
el.parentElement.id = "show";
var senses = el.parentElement.getElementsByTagName('*');
if (senses.length > 0)
{
var i = 0;
for(i in senses)
{
if (senses[i])
{
try
{
if (! senses[i].hasAttribute('class'))
{
senses[i].setAttribute('class', 'show');
}
}
catch( e ){
  //alert( e );
}
}
}
}
}
function pinchIn()
{
document.getElementById('open').style.display = 'block';
document.getElementById('close').style.display = 'none';

if (pinched == true)
{
return;
}

while (els = document.getElementById('arrow'))
{
els.parentElement.removeChild(els);
}
while (els = document.getElementById('arrowh'))
{
els.parentElement.removeChild(els);
}

while (els = document.getElementById('show'))
{

//alert(els.innerText);

//return;

els.removeAttribute('id');

var senses2 = els.getElementsByTagName('*');
if (senses2.length > 0)
{
	var ii = 0;
	for(ii in senses2)
	{
		try
		{
			if (senses2[ii].hasAttribute('class'))
			{
				if (senses2[ii].className.match('show'))
				{
				senses2[ii].removeAttribute('class');
				}
			}
		}
		catch( e ){
		//alert(e);
		}
	}
//}
//}
}

}

var senses = document.getElementsByTagName('p:Sense');
if (senses.length > 0)
{
var i = 0;
for(i in senses)
{
var arrowh= document.createElement('arrowh');
arrowh.id = "arrow";
var arrow = document.createElement('arrow');
arrow.innerHTML = "　";
arrow.id = "arrow";
arrow.onclick = function () {arrowf(this);};

try{
senses[i].appendChild(arrowh);
senses[i].appendChild(arrow);
}
catch( e ){
//alert(e);
}

if ((senses[i].className) && (senses[i].className.match(/^newline$/)))
{
var first = senses[i].firstChild;
if ((first) && (first.className) && (first.className.match(/^sensenum$/)))
{
	first.innerHTML = first.innerHTML + ' ';
}
}

}
}

var senses = document.getElementsByTagName('p:Subsense');
if (senses.length > 0)
{
var i = 0;
for(i in senses)
{
var first = senses[i].firstChild;
if (first)
{
	first.innerHTML = first.innerHTML + ' ';
}
}
}


pinched = true;
document.getElementById('body').setAttribute('class', 'body2');
setTimeout('body2()', 1000);

}

function pinchOut()
{

if (pinched == false)
{
return;
}

pinched = false;
document.getElementById('open').style.display = 'none';
document.getElementById('close').style.display = 'block';
document.getElementById('body').removeAttribute('class');

while (elsx = document.getElementById('arrow'))
{
elsx.parentElement.removeChild(elsx);
}
while (elsx = document.getElementById('arrowh'))
{
elsx.parentElement.removeChild(elsx);
}

while (els = document.getElementById('show'))
{
els.id = 'none';
els.removeAttribute('id');
var senses = els.getElementsByTagName('*');
if (senses.length > 0)
{
var i = 0;
for(i in senses)
{
	if (senses[i])
	{
		try
		{
		if (senses[i].className.match('show'))
			{
			senses[i].removeAttribute('class');
			}
		}
		catch( e ){
		//alert(e);
		}
	}
}

}
}


}
function graphicson()
{
var senses = document.getElementsByTagName('p:FLOATJ');
if (senses.length > 0)
{
var i = 0;
for(i in senses)
{
if (senses[i])
{
try
	{
	senses[i].setAttribute('class', 'show');
	}
	catch( e ){
	}
}
}
}
senses = document.getElementsByTagName('p:FLOATJ2');
if (senses.length > 0)
{
var i = 0;
for(i in senses)
{
if (senses[i])
{
try
	{
	senses[i].setAttribute('class', 'show');
	}
	catch( e ){
	}
}
}
}
senses = document.getElementsByTagName('p:FLOATX');
if (senses.length > 0)
{
var i = 0;
for(i in senses)
{
if (senses[i])
{
try
	{
	senses[i].setAttribute('class', 'show');
	}
	catch( e ){
	}
}
}
}
}
function body2()
{
document.getElementById('body').setAttribute('class', 'body');
}
function doSounds()
{
if (EN4flashDef == false)
{
return;
}
pinchIn();
var sounds = document.getElementsByTagName('a');
if (sounds.length > 0)
{
var i = 0;
for(i in sounds)
{
 if (sounds[i].className.match('uk') )
 {
  var snd = new Audio(sounds[i].href);
  if (sounds[parseInt(i) + 1].className.match('us') )
  {
  snd.addEventListener('ended', function()
  {
  var snd2 = new Audio(sounds[parseInt(i) + 1].href);
  snd2.play(); }, false);
  }
  snd.play();
 break;
 }
}
}
}

function FIELD(ind)
{
	var back = myBack;
 	
 	var backhm = document.getElementsByTagName('p:Head');
 	if ((backhm) && (backhm.length > 0))
		 {
		 	var hmms = backhm[0].getElementsByTagName('p:HOMNUM');
		 	if (hmms.length > 0)
		 	{
		 	back = back + ' ' + hmms[0].innerText;
		 	}
		 }
 	back = back.replace(' ', '+');
 	back = encodeURIComponent(back);
	location.href = 'about://topics/' + ind + '.html?back=ldoce%3A%2F%2F' + back + '%3Fexact=on';
}
function placeBM(el)
{
var myDirect = el.parentElement.nextElementSibling.innerText;
location.href = 'directbm://' + myDirect;
}
function doTags2() 
{

myBack = document.getElementsByTagName('p:HWD');
myBack = myBack[0].innerText;

/*
var floats = document.getElementsByTagName('p:propformprep');
if (floats.length > 0)
{
var i;
var back = document.getElementsByTagName('p:HWD');
 	back = back[0].innerText;
 	
for(i in floats) 
	{
		if (floats[i].innerText)
		{
		var bit = floats[i].innerText;
		//alert(bit);
		if (bit.match(/\+/))
		{
			bit = bit.replace('+', back + ' ');
			bit = bit.replace(']', '');
			bit = bit.replace('[', '');
			bit = bit.replace(/ $/, '');
			floats[i].innerHTML = bit;
		}
		}
	}
}
*/
if (window.devicePixelRatio > 1)
{
var floats = document.getElementsByTagName('p:floatj');
if (floats.length > 0)
{
var i;
for(i in floats) 
{
	if ((floats[i].firstChild) && (floats[i].firstChild.href))
	{
		var bit = '<img src="' + floats[i].firstChild.href + '" width="' + floats[i].firstChild.firstChild.width + '" height="' + floats[i].firstChild.firstChild.height + '">';
		floats[i].firstChild.innerHTML = bit;
	}
}
}

var floats = document.getElementsByTagName('p:floatx');
if (floats.length > 0)
{
var i;
for(i in floats) 
	{
		if (floats[i].innerHTML)
		{
		var bit = floats[i].innerHTML;
		bit = bit.replace(' src="j/', ' width="' + floats[i].firstChild.width + '" height="' + floats[i].firstChild.height + '" src="j/r800_');
		floats[i].innerHTML = bit;
		}
	}
}

var floats = document.getElementsByTagName('p:floatj2');
if (floats.length > 0)
{
var i;
for(i in floats) 
	{
		if ((floats[i].firstChild) && (floats[i].firstChild.href))
		{
			var bit = '<img src="' + floats[i].firstChild.href + '" width="310">';
			floats[i].firstChild.innerHTML = bit;
			floats[i].style.border = '0px';
			floats[i].style.webkitBoxShadow= 'none';
		}
	}
}
}
var places = document.getElementsByTagName('place');
if (places.length > 0)
{
	document.getElementById('placer').style.display = 'block';
	document.getElementById('placea').style.display = 'block';
	var i;
	for(i in places) 
	{
		var next = places[i].nextElementSibling;
		if ((next) && (next.id) && (next.id.match('udcontentID')))
		{
			places[i].id = next.innerText;
		}
		places[i].innerHTML = '<a name="pl' + i + '" id="pl' + i + '"></a><span onclick="placeBM(this);" class="placebm">　</span>';
		if (i == 0)
		{
		document.getElementById('myplace0').style.display = 'block';
		}
		else if (i == 1)
		{
		document.getElementById('myplace1').style.display = 'block';
		}
		else if (i == 2)
		{
		document.getElementById('myplace2').style.display = 'block';
		}
		else if (i == 3)
		{
		document.getElementById('myplace3').style.display = 'block';
		}
		else if (i == 4)
		{
		document.getElementById('myplace4').style.display = 'block';
		}
	}
}
if (EN4flashDef == false)
{
	if (window.devicePixelRatio > 1)
	{
	doTags1();
	}
	else
	{
	setTimeout('doTags1()', 90);
	}
}
setTimeout('doTagsLang()', 100);
//setTimeout('doSounds()', 990);
var myloc = location.href;
if (myloc.match('#t_'))
{
var myloca = myloc.split('#t_');
var mylocb = myloca[1].split('#s_');
var gotit = false;
var elem = document.getElementById('t_' + mylocb[0]);
if (myloc.match('#s_'))
{
var els = elem.parentElement.getElementsByTagName('p:Sense');
if (els.length > 0)
{
	var sense = parseInt(myloca[1]);
	var senn = els[sense - 1];
	if (senn)
	{	
	senn.scrollIntoView(true);	
	senn.style.backgroundColor = "#DDDDDD";
	setTimeout('doFlashS(' + sense +  ')', 400);	
	gotit = true;
	}
}
}
if (! gotit)
{
elem.nextSibling.style.backgroundColor = "#DDDDDD";
setTimeout('doFlash()', 400);
}

}
else if (myloc.match('#sp_'))
{
var myloca = myloc.split('#sp_');
var elem = document.getElementById('sp_' + myloca[1]);

elem.nextSibling.style.backgroundColor = "#DDDDDD";
elem.nextSibling.style.borderColor = "#DDDDDD";
setTimeout('doFlashSP()', 400);
}
else if (myloc.match('#s_'))
{
var myloca = myloc.split('#s_');
var els = document.getElementsByTagName('p:Sense');
if (els.length > 0)
{
	var sense = parseInt(myloca[1]);
	var senn = els[sense - 1];
	if (senn)
	{
	senn.scrollIntoView(true);
	senn.style.backgroundColor = "#DDDDDD";
	setTimeout('doFlashS(' + sense +  ')', 400);		
	}
}
}
else if (myloc.match('sensenum='))
{
var myloca = myloc.split('sensenum=');
var myloca2 = myloca[1].split('&');
var els = document.getElementsByTagName('p:Sense');
if (els)
{
	var sense = parseInt(myloca2[0]);
	var senn = els[sense - 1];
	if (senn)
	{
	senn.scrollIntoView(true);
	senn.style.backgroundColor = "#DDDDDD";
	setTimeout('doFlashS(' + sense +  ')', 400);		
	}
}
}
}
function doFlashS(sense)
{
var els = document.getElementsByTagName('p:Sense');
if (els)
{
	var senn = els[sense - 1];
	if (senn)
	{
	senn.scrollIntoView(true);
	senn.style.backgroundColor = "white";
	setTimeout('doFlashS2(' + sense +  ')', 400);		
	}
}
}
function doFlashS2(sense)
{
var els = document.getElementsByTagName('p:Sense');
if (els)
{
	var senn = els[sense - 1];
	if (senn)
	{
	senn.scrollIntoView(true);
	senn.style.backgroundColor = "#DDDDDD";
	setTimeout('doFlashS3(' + sense +  ')', 400);		
	}
}
}
function doFlashS3(sense)
{
var els = document.getElementsByTagName('p:Sense');
if (els)
{
	var senn = els[sense - 1];
	if (senn)
	{
	senn.scrollIntoView(true);
	senn.style.backgroundColor = "white";
	setTimeout('doFlashS4(' + sense +  ')', 400);
	}
}
}
function doFlashS3(sense)
{
var els = document.getElementsByTagName('p:Sense');
if (els)
{
	var senn = els[sense - 1];
	if (senn)
	{
	senn.scrollIntoView(true);
	senn.style.backgroundColor = "#DDDDDD";
	setTimeout('doFlashS5(' + sense +  ')', 400);
	}
}
}
function doFlashS5(sense)
{
var els = document.getElementsByTagName('p:Sense');
if (els)
{
	var senn = els[sense - 1];
	if (senn)
	{
	senn.scrollIntoView(true);
	senn.style.backgroundColor = "white";
	}
}
}
function doFlashSP()
{
var myloca = location.href.split('#sp_');
var elem = document.getElementById('sp_' + myloca[1]);
elem.scrollIntoView(true);

elem.nextSibling.style.backgroundColor = "#06C";
elem.nextSibling.style.borderColor = "#06C";

setTimeout('doFlashSP2()', 400);
}
function doFlashSP2()
{
var myloca = location.href.split('#sp_');
var elem = document.getElementById('sp_' + myloca[1]);

elem.nextSibling.style.backgroundColor = "#DDDDDD";
elem.nextSibling.style.borderColor = "#DDDDDD";

setTimeout('doFlashSP3()', 400);
}
function doFlashSP3()
{
var myloca = location.href.split('#sp_');
var elem = document.getElementById('sp_' + myloca[1]);

elem.nextSibling.style.backgroundColor = "#06C";
elem.nextSibling.style.borderColor = "#06C";
}
function doFlash()
{
var myloca = location.href.split('#t_');
var elem = document.getElementById('t_' + myloca[1]);
if (myloca[1] > 599) //and less than 640
{
elem.parentElement.scrollIntoView(true);
}
else
{
elem.scrollIntoView(true);
}
elem.nextSibling.style.backgroundColor = "white";

setTimeout('doFlash2()', 400);
}
function doFlash2()
{
var myloca = location.href.split('#t_');
var elem = document.getElementById('t_' + myloca[1]);

elem.nextSibling.style.backgroundColor = "DDDDDD";

setTimeout('doFlash3()', 400);
}
function doFlash3()
{
var myloca = location.href.split('#t_');
var elem = document.getElementById('t_' + myloca[1]);

elem.nextSibling.style.backgroundColor = "white";

setTimeout('doFlash4()', 400);
}
function doFlash4()
{
var myloca = location.href.split('#t_');
var elem = document.getElementById('t_' + myloca[1]);

elem.nextSibling.style.backgroundColor = "DDDDDD";

setTimeout('doFlash5()', 400);
}
function doFlash5()
{
var myloca = location.href.split('#t_');
var elem = document.getElementById('t_' + myloca[1]);

elem.nextSibling.style.backgroundColor = "transparent";
}

function doFlashj(id)
{
var elem = document.getElementById('tagged_' + id);
elem.style.backgroundColor = "DDDDDD";
setTimeout('doFlashj2(' + id + ')', 500);
}
function doFlashj2(id)
{
var elem = document.getElementById('tagged_' + id);
elem.style.backgroundColor = "transparent";
}

function doTags1()
{
var anchors = document.getElementsByTagName('p:m');
if (anchors)
{
for (var itag=0; itag<anchors.length; itag++) 
{
 var bittt = anchors[itag].firstChild.href;

 if (screen.width == 768)
 {
 //anchors[itag].innerHTML ='';
 anchors[itag].innerHTML = '<video id="myVideo" src="' + bittt　+ '" width="120px" height="90px" type="video/mp4" controls></video>'; //controls
 //anchors[itag].firstChild.setAttribute("webkitSupportsFullscreen", "false");
 //anchors[itag].firstChild.muted = true;
 //anchors[itag].firstChild.load();
//anchors[itag].firstChild.play();
 //anchors[itag].setAttribute("onclick","playMe(this)");
 //player.volume = .5
  }
 else
 {
 anchors[itag].innerHTML = '<video src="' + bittt　+ '" width="120px" height="90px"></video>'; // autoplay loop
 }
}
}
var myloc = location.href;
if (myloc.match('#j_'))
{
document.getElementById('load').style.display = 'block';
}

//var pattern = new RegExp("(^|\\s)tM(\\s|$)");
//var els = document.getElementsByTagName('*');
i = 0;
while (els = document.getElementById('tM'))
{
 x++;
 i++;
 clickedTag(els);
 els.id = 'tagged_' + x;
 if (i > 10)
 {
 	setTimeout('doTagsX()', 100);
 	return;
 }
}

if ((! jumped) && (myloc.match('#j_')))
{
var myloca = myloc.split('#j_');
var elem = document.getElementById('tagged_' + myloca[1]);
if (elem)
{
elem.scrollIntoView(true);
setTimeout('doFlashj(' + myloca[1] + ')', 10);
}
}
jumped = true;
document.getElementById('load').style.display = 'none';
}
function doTagsLang()
{
if ( (EN4LanguageName) && (EN4LanguageName == '日本語') )
{
document.getElementById('enfour').style.display = 'inline';
}
else
{
document.getElementById('enfour2').style.display = 'inline';
}
/*
if (EN4LanguageName) 
{

	if (EN4LanguageName == '日本語')
	{
	
	var posblock = document.getElementsByTagName('p:POS');
	
	for (var itag=0; itag<posblock.length; itag++) 
	{
		if (posblock[itag].innerHTML.match(/^noun$/))
			{
			posblock[itag].innerHTML = '名詞';
			}
		else if (posblock[itag].innerHTML.match(/^adjective$/))
			{
			posblock[itag].innerHTML = '形容詞';
			}
		else if (posblock[itag].innerHTML.match(/^verb$/))
			{
			posblock[itag].innerHTML = '動詞';
			}
	}
	
	posblock = document.getElementsByTagName('span');
	
	for (var itag=0; itag<posblock.length; itag++) 
	{
		if (posblock[itag].innerHTML.match(/^\[transitive\]$/))
			{
			posblock[itag].innerHTML = '[他動詞]';
			}
		else if (posblock[itag].innerHTML.match(/^\[intransitive\]$/))
			{
			posblock[itag].innerHTML = '[自動詞]';
			}
		else if (posblock[itag].innerHTML.match(/^\[countable\]$/))
			{
			posblock[itag].innerHTML = '[可算]';
			}
		else if (posblock[itag].innerHTML.match(/^\[not before noun\]$/))
			{
			posblock[itag].innerHTML = '[名詞の前不可]';
			}
		else if (posblock[itag].innerHTML.match(/^\[only before noun\]$/))
			{
			posblock[itag].innerHTML = '[名詞の前のみ]';
			}
		else if (posblock[itag].innerHTML.match(/^\[uncountable\]$/))
			{
			posblock[itag].innerHTML = '[不可算]';
			}
		
	}
	
	posblock = document.getElementsByTagName('p:GEO');
	
	for (var itag=0; itag<posblock.length; itag++) 
	{
		if (posblock[itag].innerHTML.match(/^BrE$/))
			{
			posblock[itag].innerHTML = '英国';
			}
		else if (posblock[itag].innerHTML.match(/^AmE$/))
			{
			posblock[itag].innerHTML = '米語';
			}
		else if (posblock[itag].innerHTML.match(/^ AmE$/))
			{
			posblock[itag].innerHTML = ' 米語';
			}
		else if (posblock[itag].innerHTML.match(/^ BrE$/))
			{
			posblock[itag].innerHTML = ' 英国';
			}
	}
	
	}
	elseif (EN4LanguageName == '한국어')
	{
	
	var posblock = document.getElementsByTagName('p:POS');
	
	for (var itag=0; itag<posblock.length; itag++) 
	{
		if (posblock[itag].innerHTML.match(/^noun$/))
			{
			posblock[itag].innerHTML = '명사';
			}
		else if (posblock[itag].innerHTML.match(/^adjective$/))
			{
			posblock[itag].innerHTML = '형용사';
			}
		else if (posblock[itag].innerHTML.match(/^verb$/))
			{
			posblock[itag].innerHTML = '동사';
			}
	}
	
	var posblock2 = document.getElementsByTagName('span');
	
	for (var itag2=0; itag2<posblock2.length; itag2++) 
	{
		if (posblock2[itag2].innerHTML.match(/^\[transitive\]$/))
			{
			posblock2[itag2].innerHTML = '[타동사]';
			}
		else if (posblock2[itag2].innerHTML.match(/^\[intransitive\]$/))
			{
			posblock2[itag2].innerHTML = '[자동사]';
			}
		else if (posblock2[itag2].innerHTML.match(/^\[countable\]$/))
			{
			posblock2[itag2].innerHTML = '[가산]';
			}
		else if (posblock2[itag2].innerHTML.match(/^\[not before noun\]$/))
			{
			posblock2[itag2].innerHTML = '[名詞の前不可]';
			}
		else if (posblock2[itag2].innerHTML.match(/^\[only before noun\]$/))
			{
			posblock2[itag2].innerHTML = '[名詞の前のみ]';
			}
		else if (posblock2[itag2].innerHTML.match(/^\[uncountable\]$/))
			{
			posblock2[itag2].innerHTML = '[불가산]';
			}
		
	}
	
	var posblock3 = document.getElementsByTagName('p:GEO');
	
	for (var itag3=0; itag3<posblock3.length; itag3++) 
	{
		if (posblock3[itag3].innerHTML.match(/^BrE$/))
			{
			posblock3[itag3].innerHTML = '영국 영어';
			}
		else if (posblock3[itag3].innerHTML.match(/^AmE$/))
			{
			posblock3[itag3].innerHTML = '미국 영어';
			}
		else if (posblock3[itag3].innerHTML.match(/^ AmE$/))
			{
			posblock3[itag3].innerHTML = ' 미국 영어';
			}
		else if (posblock3[itag3].innerHTML.match(/^ BrE$/))
			{
			posblock3[itag3].innerHTML = ' 영국 영어';
			}
	}
	}

}
*/
document.getElementById("body").style.display = 'block';
if (document.height > (screen.height - 80))
{
if (window.devicePixelRatio > 1)
{
document.getElementById('closeAll').src= "j/closeAll@2x.png";
document.getElementById('openAll').src= "j/openAll@2x.png";
}
document.getElementById('close').style.display = 'block';
}

}
/* want to speed up on 3GS by making > 40 */
function doTagsX() 
{
var myloc = location.href;

if ((! jumped) && (myloc.match('#j_')))
{
var myloca = myloc.split('#j_');
if (x >= myloca[1])
{
var elem = document.getElementById('tagged_' + myloca[1]);
if (elem)
{
//alert("got");
jumped = true;
document.getElementById('load').style.display = 'none';
elem.scrollIntoView(true);
setTimeout('doFlashj(' + myloca[1] + ')', 10);
}
}
}
i = 0;
while (els = document.getElementById('tM'))
{
 x++;
 i++;
 clickedTag(els);
 els.id = 'tagged_' + x;
 if (i > 20)
 {
 	setTimeout('doTagsX()', 100);
 	return;
 }
}

if (! jumped)
{
if (myloc.match('#j_'))
{
var myloca = myloc.split('#j_');
var elem = document.getElementById('tagged_' + myloca[1]);
if (elem)
{
elem.scrollIntoView(true);
setTimeout('doFlashj(' + myloca[1] + ')', 10);
}
}
jumped = true;
document.getElementById('load').style.display = 'none';
}
}
function spmenukick(el) {
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

var menua = document.getElementsByTagName('spmenu');
var i;
for(i in menua) 
	{
	if (menua[i].style)
	{
	var menu = menua[i].style;
	
	if (menu.display == "block")
	{
	 menu.display = "none";
	 }
	 else
	 {
	 menu.display = "block";
	 }
	}
	}

var colo = document.getElementsByTagName('p:ColloBox');
if ( (colo)	&& (colo.length > 0))
{
if (! document.getElementById('colo'))
{
var newdiv = document.createElement("a");
newdiv.setAttribute("name","#colo");
newdiv.setAttribute("id","colo");
colo[0].insertBefore(newdiv, colo[0].firstChild);
var newdiv = document.createElement("splist");
newdiv.setAttribute("onclick","menuJump(this,'colo')");
var txt = document.createTextNode("Collocations ↓");
newdiv.appendChild(txt); 
newdiv.className += 'Collo';
el.nextSibling.appendChild(newdiv);
}
}
var colo = document.getElementsByTagName('p:thesbox');
if ( (colo)	&& (colo.length > 0))
{
if (! document.getElementById('thes'))
{
var newdiv = document.createElement("a");
newdiv.setAttribute("name","#thes");
newdiv.setAttribute("id","thes");
colo[0].insertBefore(newdiv, colo[0].firstChild);
var newdiv = document.createElement("splist");
newdiv.setAttribute("onclick","menuJump(this,'thes')");
var txt = document.createTextNode("Thesaurus ↓");
newdiv.appendChild(txt); 
newdiv.className += 'Collo';
el.nextSibling.appendChild(newdiv);
}
}
var colo = document.getElementsByTagName('ety');
if ( (colo)	&& (colo.length > 0))
{
if (! document.getElementById('ety'))
{
var newdiv = document.createElement("a");
newdiv.setAttribute("name","#ety");
newdiv.setAttribute("id","ety");
colo[0].insertBefore(newdiv, colo[0].firstChild);
var newdiv = document.createElement("splist");
newdiv.setAttribute("onclick","menuJump(this,'ety')");
var txt = document.createTextNode("Word origin ↓");
newdiv.appendChild(txt); 
newdiv.className += 'Ety';
el.nextSibling.appendChild(newdiv);
}
}
}
function menuJump(el,tag) {
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);
location.href = '#' + tag;
var elem = document.getElementById(tag);
elem.nextSibling.style.backgroundColor = "#DDDDDD";
elem.nextSibling.style.borderColor = "#DDDDDD";
setTimeout('doFlashSP()', 400);
}
function PC()
{
	var back = myBack;
 	var backhm = document.getElementsByTagName('p:Head');
 	if ((backhm) && (backhm.length > 0))
		 {
		 	var hmms = backhm[0].getElementsByTagName('p:HOMNUM');
		 	if (hmms.length > 0)
		 	{
		 	back = back + ' ' + hmms[0].innerText;
		 	}
		 }
 	back = back.replace(' ', '+');
 	back = encodeURIComponent(back);
	location.href = 'about://2.1_prons.html?back=ldoce%3A%2F%2F' + back + '%3Fexact=on';
}
function th()
{

var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(document.getElementById("th"));
sel.removeAllRanges();
sel.addRange(range);

var word = myBack;

var sec = ['À','Á','Â','Ã','Ä','Å','à','á','â','ã','ä','å','Ò','Ó','Ô','Õ','Õ','Ö','Ø','ò','ó','ô','õ','ö','ø','È','É','Ê','Ë','è','é','ê','ë','ð','Ç','ç','Ð','Ì','Í','Î','Ï','ì','í','î','ï','Ù','Ú','Û','Ü','ù','ú','û','ü','Ñ','ñ','Š','š','Ÿ','ÿ','ý','Ž','ž'];
var rep = ['A','A','A','A','A','A','a','a','a','a','a','a','O','O','O','O','O','O','O','o','o','o','o','o','o','E','E','E','E','e','e','e','e','e','C','c','D','I','I','I','I','i','i','i','i','U','U','U','U','u','u','u','u','N','n','S','s','Y','y','y','Z','z'];
var y;
	for (var y = 0; y < 61; y++)
	{
	word = word.replace(sec[y], rep[y]);
	}
	var back = word;

	var backhm = document.getElementsByTagName('p:Head');
	
	if ((backhm) && (backhm.length > 0))
	 {
		var hmms = backhm[0].getElementsByTagName('p:HOMNUM');
		if (hmms.length > 0)
		{
		var hommer = hmms[0].innerText;
		if (hommer != '1')
		{
			back = back + ' ' + hommer;
		}
		}
	 }
	word = word.replace(' ', '+');
	word = encodeURIComponent(word);
	back = back.replace(' ', '+');
	back = encodeURIComponent(back);
/*
if (! EN4LanguageName == '日本語')
{
	document.getElementById("th").style.display = 'none';
}
*/
	location.href = 'thes://' + word + '?exact=on&back=ldoce%3A%2F%2F' + back + '%3Fexact=on';
	
	//setTimeout("thes('" + back + "')", 1200);
}

function HYPH() {
var el = document.getElementsByTagName('p:HWD')[0];
//var el2 = document.getElementsByTagName('p:HYPH')[0];
//if (el.innerText != el2.innerText)
//{

if (el.style.display == 'block')
{
el.style.display = '';
var sel = window.getSelection();
sel.removeAllRanges();
}
else
{
var text = el.innerText;
var len = text.length;
if (len < 5) {
var lenval = 80;
}
else if (len < 11) {
var lenval = 50;
}
else if (text.match(" ")) {
var lenval = 40;
}
else if (text.match("-")) {
var lenval = 40;
}
else {
var lenval = Math.floor(300 / len);
if (lenval < 26) {
var lenval = 26;
}
if (lenval > 80) {
var lenval = 80;
}
}
el.style.fontSize = lenval;
el.style.lineHeight = 1.1;

el.style.display = 'block';
//document.getElementById("th").style.display = 'block';
location.href = '#top';

var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

if ((! navigator.userAgent.match('OS 3_1')) && (! navigator.userAgent.match('acintosh')) && (! navigator.userAgent.match('ndroid')) )
{
if (watchtap)
{
return;
}
var x = el.offsetLeft - window.pageXOffset; //+ Math.floor(el.offsetWidth / 2)
var lH = getStyle(el, 'line-height');
var y = el.offsetTop - window.pageYOffset ; //+ parseInt(lH)

var tlbox = el.offsetLeft - window.pageXOffset;
//var trboy = el.offsetRight - window.pageXOffset;

window.location.href = 'actionmenu://' + tlbox + '&' + y + '&' + Math.floor(el.offsetWidth) + '&' + lH +'&0';
document.getElementById("body").style.backgroundColor = "#F8F8F8";
el.style.backgroundColor = "#CCDDED";
var elem = document.getElementById('selected');
if (elem)
{
elem.style.backgroundColor = "transparent";
elem.id = 'unselected';
}
el.id = 'selected';

}
}

}
function exas(el, targ)
{
var el2 = document.getElementById('activeexas')
if (el2)
{
el2.removeAttribute("id");
if (el2.className)
{
el2.removeAttribute("onclick");
el2.setAttribute("onclick","exas(this,'" + el2.className  + "');");
}
}
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

//el.setAttribute("style","background:transparent url(g/loading.gif) no-repeat center center; -webkit-background-size: 18px 18px;");
el.setAttribute("id", 'downloading');
el.setAttribute("class", targ);
el.removeAttribute("onclick");
setTimeout('doExasBack()', 1500);
targ = targ.replace('%20', '%5F');
sel.removeAllRanges();
location.href = 'sound://www.enfour.com/ldoce/' + targ;
}
function badSound()
{
var el2 = document.getElementById('activeexas')
if (el2)
{
el2.removeAttribute("id");
if (el2.className)
{
el2.removeAttribute("onclick");
el2.setAttribute("onclick","exas(this,'" + el2.className + "');");
}
}
var el = document.getElementById('downloading')
if (el)
{
el.removeAttribute("id");
if (el.className)
{
el.removeAttribute("onclick");
el.setAttribute("onclick","exas(this,'" + el.className + "');");
}
}
}
function soundAgain(el)
{
location.href = 'soundagain://me';
}
function doExasBack()
{
var el = document.getElementById('downloading')
if (el)
{
el.setAttribute("id", 'activeexas');
//el.setAttribute("style",null);
//el.setAttribute("class", wav);
el.setAttribute("onclick","soundAgain(this);");
//el.onclick = function () {soundAgain(this);};
/*
if (window.devicePixelRatio > 1)
{
el.setAttribute("style","background:transparent url(j/speaker@2x.png) no-repeat center left; -webkit-background-size: 27px 14px;");
}
else
{
el.setAttribute("style","background:transparent url(j/speaker.png) no-repeat center left; -webkit-background-size: none;");
}
*/
}
}
function goText(word, j, el)
{
if ( (EN4actionMenu == true) && (! navigator.userAgent.match('OS 3_1')) && (! navigator.userAgent.match('acintosh')) && (! navigator.userAgent.match('ndroid')) )
{
if (watchtap)
{
return;
}

	var x = el.offsetLeft + Math.floor(el.offsetWidth / 2) - window.pageXOffset;
	var lH = getStyle(el, 'line-height');
	var y = el.offsetTop - window.pageYOffset ; //+ parseInt(lH)
	
	var tlbox = el.offsetLeft - window.pageXOffset;
	//var trboy = el.offsetRight - window.pageXOffset;
	
	
	window.location.href = 'actionmenu://' + tlbox + '&' + y + '&' + Math.floor(el.offsetWidth) + '&' + lH +'&' + j;
	el.style.backgroundColor = "#CCDDED";
	document.getElementById("body").style.backgroundColor = "#F8F8F8";
	var elem = document.getElementById('selected');
	if (elem)
	{
	elem.style.backgroundColor = "transparent";
	elem.id = 'unselected';
	}
	el.id = 'selected';
	return;
}
	
	var back = myBack;
 	var backhm = document.getElementsByTagName('p:Head');
	
	if ((backhm) && (backhm.length > 0))
	 {
		var hmms = backhm[0].getElementsByTagName('p:HOMNUM');
		if (hmms.length > 0)
		{
		var hommer = hmms[0].innerText;
		if (hommer != '1')
		{
			back = back + ' ' + hommer;
		}
		}
	 }
	
 	back = back.replace(' ', '+');
 	
 	var sense = false;
 	
 	/*
 	if (word.match('#s_'))
	{
	var myloca = word.split('#s_');
	sense = true;
	word = myloca[0];
	
	}
	*/
 	
	//word = word.replace(/,/g, '');
	
	word = cleanWord(word);
	
	var sec = ['À','Á','Â','Ã','Ä','Å','à','á','â','ã','ä','å','Ò','Ó','Ô','Õ','Õ','Ö','Ø','ò','ó','ô','õ','ö','ø','È','É','Ê','Ë','è','é','ê','ë','ð','Ç','ç','Ð','Ì','Í','Î','Ï','ì','í','î','ï','Ù','Ú','Û','Ü','ù','ú','û','ü','Ñ','ñ','Š','š','Ÿ','ÿ','ý','Ž','ž'];
	
	var rep = ['A','A','A','A','A','A','a','a','a','a','a','a','O','O','O','O','O','O','O','o','o','o','o','o','o','E','E','E','E','e','e','e','e','e','C','c','D','I','I','I','I','i','i','i','i','U','U','U','U','u','u','u','u','N','n','S','s','Y','y','y','Z','z'];
	var y;
	for (var y = 0; y < 61; y++)
	{
	word = word.replace(sec[y], rep[y]);
	back = back.replace(sec[y], rep[y]);
	}

	word = encodeURIComponent(word);
	back = encodeURIComponent(back);
	
	//word = word.replace(/%23s_/, '#s_');
	//back = back.replace(/%23t_/, '#t_');
	var url = 'ldoce://' + word + '?exact=on&back=ldoce%3A%2F%2F' + back + '%3Fexact=on';
	
	if (sense)
	{
		//url = url + '#s_' + myloca[1];
		var url = 'ldoce://' + word + '?exact=on&sensenum=' + myloca[1] + '&back=ldoce%3A%2F%2F' + back + '%3Fexact=on';
	}
	else
	{
		var url = 'ldoce://' + word + '?exact=on&back=ldoce%3A%2F%2F' + back + '%3Fexact=on';
	}
	//alert(url);
	
	if (j)
	{
	url = url + '%23j_' + j;
	}
	
	
	location.href = url;
	
}
/*
// make a new header via URL
	var back = document.getElementsByTagName('body');
	back = back[0].innerHTML;
	back = encodeURIComponent(back);
	location.href = 'mailto:?body=' + back;
*/	
function REFHWD(el)
{
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

var word = el.innerHTML;

word = word.replace(/^ /, '');
word = word.replace(/<span class="neutral">at<\/span>/g, '');
	
var parent = el.parentElement;

if ((parent.tagName.match ('P:CROSSREFTO') ) && (parent.attributes[0]) && (parent.attributes[0].nodeName.match ('href') ))
{
	if (( el.previousElementSibling ) && (el.previousElementSibling.tagName.match ('P:REFHWD') ) )
	{
	}
	else
	{
	var loc = parent.attributes[0].nodeValue;
	}
}

if (! loc)
{
	var next = el.firstChild;
	
	if ((next) && (! next.nodeName.match( '#text')) && (next.tagName.match(/^A$/)) && (next.hash) )
		{
		var loc = next.hash;
		}
}

var hom = el.nextSibling; //.getElementsByTagName('p:REFHOMNUM');

if ((hom) && (! hom.nodeName.match( '#text')))
{
if (hom.tagName.match('P:REFHOMNUM'))
{
	word = word + ' ' + hom.innerText;
	
	var hom2 = hom.nextSibling;
	if ((hom2) && (hom2.tagName.match('P:REFSENSENUM')))
	{
	 var sense = hom2.innerText;
	 sense = sense.replace('(', '');
	 sense = sense.replace(')', '');
	 //word = word + '#s_' + sense;
	}
}
else  if (hom.tagName.match('P:REFSENSENUM'))
{
 var sense = hom.innerText;
 sense = sense.replace('(', '');
 sense = sense.replace(')', '');
 //word = word + '#s_' + sense;
}	
}
if (loc)
{
	var back = myBack
	
	var backhm = document.getElementsByTagName('p:Head');
	
	if ((backhm) && (backhm.length > 0))
	 {
		var hmms = backhm[0].getElementsByTagName('p:HOMNUM');
		if (hmms.length > 0)
		{
		back = back + ' ' + hmms[0].innerText;
		}
	 }
	
	back = back.replace(' ', '+');
	back = encodeURIComponent(back);
	if (sense)
	{
	loc = loc + '#s_' + sense;
	}
	location.href = loc + '?back=ldoce%3A%2F%2F' + back + '%3Fexact=on';
	return false;
}
else
{
/*
if (sense)
{
	word = word + '#s_' + sense;
}
*/
goText(word, '', el);
}
}
function SYN(el)
{
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

var word = el.innerHTML;

word = word.replace(/^ /, '');
word = word.replace(/<span class="synopp">[^<>]+<\/span> /g, '');
word = word.replace(/<span class="geo">[^<>]+<\/span>/g, '');
word = word.replace(/<span class="[^<>]+">([^<>]+)<\/span>/g, '$1');
word = word.replace(/<p:geo>[^<>]+<\/p:geo>/g, '');
word = word.replace(/:/g, '');
word = word.replace(/\./g, '');
word = word.replace(/,/g, '');
word = word.replace(/ $/, '');

//goText(word, '', el);

var back = myBack;
var backhm = document.getElementsByTagName('p:Head');

if ((backhm) && (backhm.length > 0))
 {
	var hmms = backhm[0].getElementsByTagName('p:HOMNUM');
	if (hmms.length > 0)
	{
	var hommer = hmms[0].innerText;
	if (hommer != '1')
	{
		back = back + ' ' + hommer;
	}
	}
 }

back = back.replace(' ', '+');

var sense = false;


var sec = ['À','Á','Â','Ã','Ä','Å','à','á','â','ã','ä','å','Ò','Ó','Ô','Õ','Õ','Ö','Ø','ò','ó','ô','õ','ö','ø','È','É','Ê','Ë','è','é','ê','ë','ð','Ç','ç','Ð','Ì','Í','Î','Ï','ì','í','î','ï','Ù','Ú','Û','Ü','ù','ú','û','ü','Ñ','ñ','Š','š','Ÿ','ÿ','ý','Ž','ž'];

var rep = ['A','A','A','A','A','A','a','a','a','a','a','a','O','O','O','O','O','O','O','o','o','o','o','o','o','E','E','E','E','e','e','e','e','e','C','c','D','I','I','I','I','i','i','i','i','U','U','U','U','u','u','u','u','N','n','S','s','Y','y','y','Z','z'];
var y;
for (var y = 0; y < 61; y++)
{
word = word.replace(sec[y], rep[y]);
back = back.replace(sec[y], rep[y]);
}

word = encodeURIComponent(word);
back = encodeURIComponent(back);


location.href =  'ldoce://' + word + '?exact=on&back=ldoce%3A%2F%2F' + back + '%3Fexact=on';


}

function RELATEDWD(el)
{
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

var word = el.innerHTML;

word = word.replace(/^ /, '');
word = word.replace(/<span class="neutral">,<\/span>/, '');
	
goText(word, '', el);
}
function placeit(el,tag) {
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);
location.href = '#' + tag;
var els = document.getElementById(tag);
if (els)
{
els.parentElement.previousElementSibling.scrollIntoView(true);
}
}
function tC(el, localv)
{
if (EN4flashDef == true)
{
return;
}
var local = localv;
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

var word = el.innerText; //firstChild.data; //innerHTML;

	var els = el.parentElement;
var hash = '';
var tagged = false;
if (els)
{
	var elss = els.parentElement;
	if ((els.id) && (els.id.match('tagged_')) )
	{
	tagged = true;
	var myloca = els.id.split('agged_');
	}
	else if ( (elss.id) && (elss.id.match('tagged_')) )
	{
	tagged = true;
	var myloca = elss.id.split('agged_');
	}
}
if ((tagged) && (myloca[1]))
{
	goText(word, myloca[1], el);
}
else
{
	goText(word, '', el);
}

}
function clickedTag(tag)
{
var nonSearch = Array(
'sth', 'sb', '-', '/', 'etc', 'sb’s'
);

var newTag = "";
var text = tag.innerHTML;  

text = text.replace(/ id="tM"/g, '');

text = text.replace(/<\//g, '<_');

text = text.replace(/<img src="g\/us\.png"/g, '<imgsrcus');
text = text.replace(/<img src="g\/gb\.png"/g, '<imgsrcgb');


text = text.replace(/ onclick="refhwd(this)"/g, '');
text = text.replace(/ onclick="relatedwd(this)"/g, '');
text = text.replace(/ onclick="syn(this)"/g, '');

text = text.replace(/ onclick=/g, '_onclick=');
text = text.replace(/ class=/g, '_class=');
text = text.replace(/ href=/g, '_href=');
text = text.replace(/se1 num=/g, 'se1_num=');
text = text.replace(/this, '/g, "this,'"); //"

text = text.replace(/\//g, ' / ');
text = text.replace(/<br>/g, ' <br>');
text = text.replace(/>/g, '> ');
//text = text.replace(/-/g, ' ');
text = text.replace(/  /g, ' ');
text = text.replace(/> <_exas/g, '><_exas');

text = text.replace(/<hom/g, ' <hom');
text = text.replace(/<span_class="neutral/g, ' <span_class="neutral'); // '

text = text.replace(/ style="background:transparent [^<>]+>/g, '>');

if (text.match(" "))
{

var texta = text.split(' ');
var i;
for(i in texta) {
	var word2 = texta[i];
	var word = word2.replace(/,/g, '');
	
	if (word2.match("["))
		word = '';
	if (word2.match("]"))
		word = '';
	if (word2.match("–"))
		word = '';
	if (word2.match('inf>'))
		word = '';
	if (word2.match('infg>'))
		word = '';
	if (word2.match('<pron'))
		word = '';
	if (word2.match('p:geo'))
		word = '';
	if (word2.match('_href'))
		word = '';
	if (word2.match('<a>'))
		word = '';
	if (word2.match('<_a>'))
		word = '';
	if (word2.match('exas>'))
		word = '';
	if (word2.match('<exas'))
		word = '';
	if (word2.match('refsensenum'))
		word = '';
	//if (word2.match('colloinexa'))
	//	word = '';
	if (word2.match('%'))
		word = '';
		
	word = word.replace(/<[^<>]+>/g, '');
	
	word = word.replace(/<br>/g, '');
	
	word = word.replace(/"/g, ''); //"
	word = word.replace(/:/g, '');
	word = word.replace(/\./g, '');
	//word = word.replace(/\//g, '');
	word = word.replace(/\?/g, '');
	word = word.replace(/!/g, '');
	word = word.replace(/\(/g, '');
	word = word.replace(/\)/g, '');
	word = word.replace(/=/g, '');
	word = word.replace(/'$/, '');
	word = word.replace(/^'/, '');
	word = word.replace(/“/g, '');
	word = word.replace(/”/g, '');
	word = word.replace(/\.\.\./g, '');
	word = word.replace(/’/g, '');
	word = word.replace(/‘/g, '');
	
	word = word.replace(/;/g, '');
	word = word.replace("\n", '');
	word = word.replace("|", '');
	
	//word = word.replace(/<_/g, '</');
	word2 = word2.replace(/<_/g, '</');
	
	word = word.replace(/_/g, ' ');
	word2 = word2.replace(/_/g, ' ');
	
	word = word.toLowerCase();
	
	word = word.replace(/^[0-9]+$/g, '');
	

	if (word.length == 0){
		newTag = newTag + word2 + " ";
	}
	else
	{
		//var wordx = word.replace(/<[^<>]+>/g, ''); //strip html tags;
		if ( (word == myBack) && ( (navigator.userAgent.match('OS 3_1')) || ( navigator.userAgent.match('acintosh')) || ( navigator.userAgent.match('ndroid')) ) )
		{
			//need to put inside tags
			newTag = newTag +  word2 + " "; //'<font color="red">' + word2 + '</font>' + " ";
		}
		else
		{
		var xn;
		var i=0;
		for (xn in nonSearch){
			if (nonSearch[xn] == word){
				newTag = newTag + word2 + " ";
				var i=1;
				break;
				}
		}
		
		if (i == 0)
		{
			var wordx = word2.replace(/<[^<>]+>/g, '');
			var worde = '';
			var wordb = '';
			if (word2.match("</"))
			{
			var wordt = word2.split('</');
			wordt = wordt[0];
			var worde = word2.replace(wordt, '');
			if (wordt.match("<"))
			{
			var wordb = wordt.replace(/>[^>]+$/, '>'); 
			}
			}
			else if (word2.match("<"))
			{
			var wordb = word2.replace(/^<([^<>]+)>.+/, '<$1>');
			}
			newTag = newTag + wordb + "<span class=\"textSelectable\" onclick=\"tC(this,1)\">" + wordx + "</span> " + worde;
		}
		}
	}
  }

newTag = newTag.replace(/  /g, ' ');

//newTag = newTag.replace(/<_/g, '</');

newTag = newTag.replace(/\( /g, '(');
newTag = newTag.replace(/ \)/g, ')');

newTag = newTag.replace(/\(<([^ ]+)> /g, '(<$1>');
newTag = newTag.replace(/\(<([^ ]+)> /g, '(<$1>');
newTag = newTag.replace(/\(<([^ ]+)> /g, '(<$1>');

newTag = newTag.replace(/ <([^ ]+)>\)/g, '<$1>)');
newTag = newTag.replace(/ <([^ ]+)>\)/g, '<$1>)');

newTag = newTag.replace(/<a href="#([^<>]+)"> <span class="textSelectable" onclick="tC\(this,1\)">([^<>]+)<\/span>/g, ' <a href="#$1">$2');

newTag = newTag.replace(/<\/span> <\/i>/g, '</span></i> ');
newTag = newTag.replace(/  /g, ' ');
newTag = newTag.replace(/> ,/g, '>,');
newTag = newTag.replace(/-<i> /g, '-<i>');

/*newTag = newTag.replace(/ <\/dum> /g, ' </dum>');
newTag = newTag.replace(/ <\/exp>/g, '</exp>');
newTag = newTag.replace(/<ex> /g, '<ex>');*/

newTag = newTag.replace(/ <\/b>/g, '</b> ');
newTag = newTag.replace(/<\/b> \./g, '</b>.');

newTag = newTag.replace(/<\/hom> /g, '</hom>');
newTag = newTag.replace(/ <hom>/g, '<hom>');
newTag = newTag.replace(/<hom> /g, '<hom>');
newTag = newTag.replace(/<p:geo> /g, '<p:geo>');

newTag = newTag.replace(/ \/ /g, '/');
 
newTag = newTag.replace(/<imgsrcus/g, '<img src="g/us.png"');
newTag = newTag.replace(/<imgsrcgb/g, '<img src="g/gb.png"');

newTag = newTag.replace(/>\(/g, '> (');
newTag = newTag.replace(/tC\(this,1\)"> \(/g, 'tC(this,1)">(');

newTag = newTag.replace(/<\/([^<>]+)><([^/<>]+)>/g, '</$1> <$2>');

newTag = newTag.replace(/> :/g, '>: ');
newTag = newTag.replace(/> ;/g, '>;');
newTag = newTag.replace(/> \./g, '>.');
newTag = newTag.replace(/> ,/g, '>,');
 
newTag = newTag.replace(/ <span class="neutral/g, '<span class="neutral'); //'
newTag = newTag.replace(/ \|<\/span> /g, '|</span>');

newTag = newTag.replace(/=<\/span> /g, '=</span>');
newTag = newTag.replace(/ <\/p:gloss>/g, '</p:gloss>');
newTag = newTag.replace(/ <\/p:suffix>/g, '</p:suffix>');
newTag = newTag.replace(/><\/exas>/g, '>&nbsp;&nbsp;&nbsp;&nbsp;</exas>');
newTag = newTag.replace(/<\/exas> /g, '</exas>');
newTag = newTag.replace(/<([^<>\/]+)> <span class="textSelectable"/g, '<$1><span class="textSelectable"');
newTag = newTag.replace(/\)<\/span>/g, ')</span>');
newTag = newTag.replace(/ !/g, '!');

newTag = newTag.replace(/<\/p:refhwd> <p:suffix>/g, '<\/p:refhwd><p:suffix>');
 
newTag = newTag.replace(/  /g, ' ');
newTag = newTag.replace(/ $/, '');
newTag = newTag.replace(/<span><\/span>/g, '');
newTag = newTag.replace(/<p:nondv> /g, '<p:nondv>');
newTag = newTag.replace(/<p:colloinexa> /g, '<p:colloinexa>');
newTag = newTag.replace(/ <\/p:colloinexa>/g, '</p:colloinexa>');
newTag = newTag.replace(/<\/span>\/<span class="textSelectable/g, '</span> <span class="hyphen">/</span> <span class="textSelectable');

tag.innerHTML = newTag;
}
else
{
text = text.replace(/_/g, ' ');
tag.innerHTML = "<span class=\"textSelectable\" onclick=\"tC(this,1)\">" + text + "</span>";
}
}
function swDial(el) {
location.href = '#top';
if ( (EN4LanguageName) && (EN4LanguageName == '日本語') )
{
document.getElementById('jcancel').style.display = 'inline-block';
}
else
{
document.getElementById('cancel').style.display = 'inline-block';
}
var text = el.innerText;
var num = 'top ' + text[1] + '000 ';
if (text.match('W'))
{
var answer = "written";
}
else if (text.match('S'))
{
var answer = "spoken";
}
else
{
var answer = "academic";
num = '';
}
var tex = '<center><br><hw><p:FREQ>' + text + '</p:FREQ> <b>= ' +  num + answer + ' words</b></hw></center><br><hr><br><pr><p:FREQ>' + text + '</p:FREQ> marked words are in the ' +  num + 'most frequent words in ' + answer + ' English</pr>';
document.getElementById('dtext').innerHTML = tex;
document.getElementById('dial').style.display = 'block';
document.getElementById('dial').style.zIndex = 2000;
}
function closedial()
{
var large = document.getElementById('dial');
large.style.display = 'none';
document.getElementById('dtext').innerHTML = "";
}
/* start UniDict 4 functions */
function getBack()
{
var back = myBack;

var backhm = document.getElementsByTagName('p:Head');
if ((backhm) && (backhm.length > 0))
	 {
		var hmms = backhm[0].getElementsByTagName('p:HOMNUM');
		if (hmms.length > 0)
		{
			if (! hmms[0].innerText.match("1"))
			{
			back = back + ' ' + hmms[0].innerText;
			}
		}
	 }
back = back.replace(/ /g, '+');
return back;
}
function getSelf()
{
return "ldoce://";
}
function getPaired()
{
return "lej://";
}
function myLang()
{
return "en";
}
function pairLang()
{
return "en";
}
function unSelect()
{
document.getElementById("body").style.backgroundColor = "#F8F8F8";
var elem = document.getElementById('selected');
if (elem)
{
elem.style.backgroundColor = "transparent";
elem.id = 'unselected';
}
var sel = window.getSelection();
sel.removeAllRanges();
}
function getStyle(x,styleProp)
{
    //var x = document.getElementById(el);
    if (x.currentStyle)
        var y = x.currentStyle[styleProp];
    else if (window.getComputedStyle)
        var y = document.defaultView.getComputedStyle(x,null).getPropertyValue(styleProp);
    if (y.match('normal'))
    {
    	y = x.offsetHeight;
    }
    else
    {
    y = y.replace("px", '');
    }
    return y;
}
function cleanSelection()
{
var word = window.getSelection().toString();

var elem = document.getElementById('selected');
if (elem)
{
	if (elem.tagName.match ('P:REFHWD'))
	{
	word = word.replace(/^at /, '');
	}
}
word = cleanWord(word);

return word;
}
function cleanWord(word)
{
word = word.replace(/ˌ/g, '');
word = word.replace(/ˈ/g, '');

word = word.replace(/ /g, ' '); //nbspace
word = word.replace(/  /g, ' ');
word = word.replace(/  /g, ' ');
word = word.replace(/^  /g, '');
word = word.replace(/^ /g, '');

word = word.replace(/  /, ' ');

word = word.replace("<br>", '');
word = word.replace(/<[^<]+>/g, '');

word = word.replace(/"/g, ''); //"
word = word.replace(/:/g, '');
word = word.replace(/\.$/g, '');
word = word.replace(/\//g, '');
word = word.replace(/\?/g, '');
word = word.replace(/!/g, '');
word = word.replace(/\(/g, '');
word = word.replace(/\)/g, '');
word = word.replace(/'$/, ''); //'
word = word.replace(/^'/, ''); //'
word = word.replace(/,$/, '');

word = word.replace(/‘/g, '');
word = word.replace(/n’t/g, "n't");
word = word.replace(/’s/g, "'s");
word = word.replace(/’/g, '');

//word = word.replace(/\[/g, '');
//word = word.replace(/\]/g, '');
word = word.replace(/;/g, '');
//word = word.replace(/-/g, '');
word = word.replace("\n", '');
word = word.replace("|", '');
//word = word.replace("[", ''); //for bug in <mass>
word = word.replace(/ $/, '');
word = word.replace(/^ /, '');


word = word.replace(/➔ /, '');
word = word.replace(/^ /, '');
return word;
}

function closeHWD()
{
var el = document.getElementsByTagName('p:HWD')[0];
var sel = window.getSelection();
sel.removeAllRanges();
el.style.display = '';
}
function selectAll()
{
var el = document.getElementById("body");
el.style.backgroundColor = "#CCDDED";
var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

var elem = document.getElementById('selected');
if (elem)
{
elem.style.backgroundColor = "transparent";
elem.id = 'unselected';
}
}
function copyAll()
{
var el = document.getElementById("body");

var sel = window.getSelection();
var range = document.createRange();
range.selectNodeContents(el);
sel.removeAllRanges();
sel.addRange(range);

var returnee = window.getSelection().toString();

sel.removeAllRanges();

returnee = returnee.replace(/^12[4-9]*/, '');
returnee = returnee.replace(/\)/g, ') ');
returnee = returnee.replace(/BrE/g, ' (BrE)');
returnee = returnee.replace(/AmE/g, ' (AmE)');
returnee = returnee.replace(/  /g, ' ');
returnee = rereturneetText.replace(/➔/g, "\n ➔");

return returnee;
}
function getJPOS()
{
var els = document.getElementById('selected');
if (els)
{
	var tagged = false;
	var elss = els.parentElement;
	
	if ((els.id) && (els.id.match('tagged_')) )
	{
	tagged = true;
	var myloca = els.id.split('agged_');
	}
	else if ( (elss.id) && (elss.id.match('tagged_')) )
	{
	tagged = true;
	var myloca = elss.id.split('agged_');
	}
	
	if ((tagged) && (myloca[1]))
	{
		return myloca[1];
	}

}
}
function findGraphic()
{
var graphics = document.getElementsByTagName('p:FLOATJ');
if (graphics.length > 0)
{
return graphics[0].firstChild.firstChild.src;
}
graphics = document.getElementsByTagName('p:FLOATX');
if (graphics.length > 0)
{
return graphics[0].firstChild.firstChild.src;
}
}
function copyAllHTML()
{
var el = document.getElementById("body");
return '<body>' + el.innerHTML + '</body></html>';
}
function copyAllHTMLfull(print)
{

var el = document.getElementById("body");

if (print == false)
{
var keepHTML = el.outerHTML;
}
var els = el.getElementsByTagName("*");

for(var i = -1, l = els.length; ++i < l;)
{

if (els[i])
{
if ((els[i].tagName) && (els[i].tagName.match(/^HR$/)) )
{
els[i].outerHTML = "<p style=\"display: block;\">_____________</p>";
}
else if ((els[i].tagName) && (els[i].tagName.match(/^BR$/)))
{
els[i].outerHTML = "<p style=\"display: block;\"> </p>";
}
else if ((els[i].tagName) && (els[i].tagName.match('MYPLACE')))
{
els[i].outerHTML = "<p style=\"display: none;\"></p>";
}
else if ((els[i].tagName) && (els[i].tagName.match('PLACE')))
{
els[i].outerHTML = "<p style=\"display: none;\"></p>";
}
else if ((els[i].tagName) && (els[i].tagName.match(/^P\:G$/)))
{
els[i].outerHTML = "<p style=\"display: none;\"></p>";
}
else if ((els[i].tagName) && (els[i].tagName.match(/^P\:M$/)))
{
els[i].outerHTML = "<p style=\"display: none;\"></p>";
}
else if ((els[i].tagName) && (els[i].tagName.match(/^IMG$/)))
{
els[i].outerHTML = "<p style=\"display: none;\"></p>";
}
else if ((els[i].tagName) && (els[i].tagName.match(/^P\:FLOAT/)))
{
els[i].outerHTML = "<p style=\"display: none;\"></p>";
}
else if ((els[i].tagName) && (els[i].tagName.match(/^SPMENUKICK$/)))
{
els[i].outerHTML = "<p style=\"display: none;\"></p>";
}
else if ((els[i].tagName) && (els[i].tagName.match(/^P\:FIELDLINE$/)))
{
els[i].outerHTML = "<p style=\"display: none;\"></p>";
}
else
{

if ((els[i].tagName) && (els[i].tagName.match(/^EXAS$/)))
{
els[i].style.marginLeft = "0px";
}
if ((els[i].tagName) && (els[i].tagName.match(/^P\:EXAMPLE$/)))
{
els[i].style.paddingLeft = "0px";
}
if ((els[i].tagName) && (els[i].tagName.match(/^P\:FREQ$/)))
{
els[i].style.backgroundColor = "pink";
}
if ((els[i].tagName) && (els[i].tagName.match(/^P\:AC$/)))
{
els[i].style.backgroundColor = "pink";
}
if ((els[i].tagName) && (els[i].tagName.match(/^ETY$/)))
{
els[i].style.backgroundColor = "#CFCFCF";
}
if ((els[i].className) && (els[i].className.match(/^sensenum/)))
{
els[i].style.marginLeft = "-16px";
}

var comStyle = window.getComputedStyle(els[i]);

var stl = 'display: ' + comStyle.display;
if (comStyle.display != 'none')
{
if (comStyle.backgroundColor != 'rgba(0, 0, 0, 0)')
{
stl = stl + '; background-color: ' + comStyle.backgroundColor;
}
if (comStyle.marginRight != "0px")
{
stl = stl + '; margin-right: ' + comStyle.marginRight
}
if (comStyle.marginLeft != "0px")
{
stl = stl + '; margin-left: ' + comStyle.marginLeft
}
if (comStyle.marginBottom != "0px")
{
stl = stl + '; margin-bottom: ' + comStyle.marginBottom
}
if (comStyle.marginTop != "0px")
{
stl = stl + '; margin-top: ' + comStyle.marginTop
}
if (comStyle.paddingBottom != "0px")
{
stl = stl + '; padding-bottom: ' + comStyle.paddingBottom
}
if (comStyle.paddingLeft != "0px")
{
stl = stl + '; padding-left: ' + comStyle.paddingLeft
}
if (comStyle.paddingRight != "0px")
{
stl = stl + '; padding-right: ' + comStyle.paddingRight
}
if (comStyle.paddingTop != "0px")
{
stl = stl + '; padding-top: ' + comStyle.paddingTop
}


if (comStyle.borderTopWidth != '0px')
{
stl = stl + '; border-top-width: ' + comStyle.borderTopWidth;
stl = stl + '; border-top-color: ' + comStyle.borderTopColor;
stl = stl + '; border-top-style: ' + comStyle.borderTopStyle;
}

if (comStyle.borderLeftWidth != '0px')
{
stl = stl + '; border-left-width: ' + comStyle.borderLeftWidth;
stl = stl + '; border-left-color: ' + comStyle.borderLeftColor;
stl = stl + '; border-left-style: ' + comStyle.borderLeftStyle;
}

if (comStyle.borderRightWidth != '0px')
{
stl = stl + '; border-right-width: ' + comStyle.borderRightWidth;
stl = stl + '; border-right-color: ' + comStyle.borderRightColor;
stl = stl + '; border-right-style: ' + comStyle.borderRightStyle;
}

if (comStyle.borderBottomWidth != '0px')
{
stl = stl + '; border-bottom-width: ' + comStyle.borderBottomWidth;
stl = stl + '; border-bottom-color: ' + comStyle.borderBottomColor;
stl = stl + '; border-bottom-style: ' + comStyle.borderBottomStyle;
}


if ( (els[i].innerText) && (els[i].innerText.length > 0))
{
if (comStyle.fontWeight != "normal")
{
stl = stl + '; font-weight: ' + comStyle.fontWeight
}
if (comStyle.fontStyle != "normal")
{
stl = stl + '; font-style: ' + comStyle.fontStyle
}
if (comStyle.fontSize != "19px")
{
stl = stl + '; font-size: ' + comStyle.fontSize
}
if (comStyle.fontVariant != "normal")
{
stl = stl + '; font-variant: ' + comStyle.fontVariant
}
if (comStyle.verticalAlign != "baseline")
{
stl = stl + '; vertical-align: ' + comStyle.verticalAlign
}
if (! comStyle.fontFamily.match( "Arial")) 
{
stl = stl + '; font-family: ' + comStyle.fontFamily
}
if (comStyle.color != "rgb(0, 0, 0)") //#000;
{
stl = stl + '; color: ' + comStyle.color
}
if (comStyle.textDecoration != "none")
{
stl = stl + '; text-decoration: ' + comStyle.textDecoration
}
if (comStyle.fontVariant != "normal")
{
stl = stl + '; font-variant: ' + comStyle.fontVariant
}
if ( (comStyle.lineHeight != "22px") && (comStyle.lineHeight != "normal") )
{
stl = stl + '; line-height: ' + comStyle.lineHeight
}
/*
if (comStyle.textIndent != "0px")
{
stl = stl + '; text-indent: ' + comStyle.textIndent
}
*/
}
}

els[i].setAttribute("style", stl);

}


els[i].removeAttribute('width');
els[i].removeAttribute('height');
els[i].removeAttribute('src');
els[i].removeAttribute('id');
els[i].removeAttribute('class');
els[i].removeAttribute('onclick');
els[i].removeAttribute('type');

els[i].removeAttribute('name');
els[i].removeAttribute('href');

els[i].removeAttribute('num');

//for hr
els[i].removeAttribute('size');
els[i].removeAttribute('color');

}
}

el.removeAttribute('onload');
el.removeAttribute('background');
//el.removeAttribute('class');
el.removeAttribute('id');

el.setAttribute("style", "display: block; font-family: Arial");

var retText = el.innerHTML;

if (print == false)
{
el.outerHTML = keepHTML ;
keepHTML = '';
}

retText = retText.replace(/<p:orthvar ([^>]+?)>/g, '<p:orthvar $1><span style="color: #999;">/ </span>');
retText = retText.replace(/<p:geo ([^>]+?)>/g, '<p:geo $1>(');
retText = retText.replace(/<p:registerlab ([^>]+?)>/g, '<p:registerlab $1>(');
retText = retText.replace(/<\/p:geo>/g, ')</p:geo>');
retText = retText.replace(/<\/p:registerlab>/g, ')</p:registerlab>');

retText = retText.replace(/<p:proncodes ([^>]+?)>/g, '<p:proncodes $1> <span style="color: #999;">／</span>');
retText = retText.replace(/<\/p:proncodes>/g, '<span style="color: #999;">／</span> </p:proncodes>');

retText = retText.replace(/<div id="placer".+?<\/myplace6><\/div>/, '');

retText = retText.replace(/<img ([^>]+?)>/g, '');

retText = retText.replace(/<sup /g, '____sup ');
retText = retText.replace(/<sub /g, '____sub ');
retText = retText.replace(/<\/sup>/g, '____/sup>');
retText = retText.replace(/<\/sub>/g, '____/sub>');

retText = retText.replace(/<[^<>\/ ]+ /g, '<span ');
retText = retText.replace(/<[^<>\/ ]+>/g, '<span>');
retText = retText.replace(/<[^<>\/ ]+>/g, '<span>');

retText = retText.replace(/<\/[^>]+>/g, '</span>');

retText = retText.replace(/____sup /g, '<sup ');
retText = retText.replace(/____sub /g, '<sub ');
retText = retText.replace(/____\/sup>/g, '</sup>');
retText = retText.replace(/____\/sub>/g, '</sub>');

retText = retText.replace(/&nbsp;&nbsp;&nbsp;&nbsp;/g, "&nbsp;");


retText = retText.replace(/<span style="display: none;">([^<>]*)<\/span>/g, '');
retText = retText.replace(/<span style="display: none([^<>"]*)">([^<>]*)<\/span>/g, '');
retText = retText.replace(/<span style="display: none">([^<>]*)<\/span>/g, '');
retText = retText.replace(/<span style="display: none">([^<>]*)<\/span>/g, '');

retText = retText.replace(/<span style="display: inline([^<>"]*)"><\/span>/g, '');

retText = retText.replace(/<span style="([^<>"]+)">([^<>]+)<\/span><span style="$1">([^<>]*)<\/span><\/span>/g, "<span style=\"$1\">$2</span>");
retText = retText.replace(/<span style="([^<>"]+)">([^<>]+)<\/span><span style="$1">([^<>]*)<\/span><\/span>/g, "<span style=\"$1\">$2</span>");
retText = retText.replace(/<span style="([^<>"]+)">([^<>]+)<\/span><span style="$1">([^<>]*)<\/span><\/span>/g, "<span style=\"$1\">$2</span>");
retText = retText.replace(/<span style="([^<>"]+)">([^<>]+)<\/span><span style="$1">([^<>]*)<\/span><\/span>/g, "<span style=\"$1\">$2</span>");

//retText = retText.replace(/<span style="([^<>"]+)">([^<>]+)<\/span>([^<>]*)<span style="$1">/g, "<span style=\"$1\">$2$3");

retText = retText.replace(/<span style="display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px">/g, "<span style=\"display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px">/g, "<span style=\"display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px">/g, "<span style=\"display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px">/g, "<span style=\"display: inline; font-size: 18px; font-family: HiraKakuProN-W3; line-height: 21px\">$1$2");

retText = retText.replace(/<span style="display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb\(102, 102, 102\); line-height: 21px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb\(102, 102, 102\); line-height: 21px">/g, "<span style=\"display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb(102, 102, 102); line-height: 21px\">$1$2");
retText = retText.replace(/<span style="display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb\(102, 102, 102\); line-height: 21px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb\(102, 102, 102\); line-height: 21px">/g, "<span style=\"display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb(102, 102, 102); line-height: 21px\">$1$2");
retText = retText.replace(/<span style="display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb\(102, 102, 102\); line-height: 21px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb\(102, 102, 102\); line-height: 21px">/g, "<span style=\"display: inline; margin-right: 4px; font-size: 16px; font-family: HiraKakuProN-W3; color: rgb(102, 102, 102); line-height: 21px\">$1$2");

retText = retText.replace(/<span style="display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 20px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 20px">/g, "<span style=\"display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb(0, 0, 102); line-height: 20px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 20px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 20px">/g, "<span style=\"display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb(0, 0, 102); line-height: 20px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 20px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 20px">/g, "<span style=\"display: inline; font-style: italic; font-family: Helvetica-Oblique, sans-serif; color: rgb(0, 0, 102); line-height: 20px\">$1$2");

retText = retText.replace(/<span style="display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 25px; text-indent: -48px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 25px; text-indent: -48px">/g, "<span style=\"display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb(0, 0, 102); line-height: 25px; text-indent: -48px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 25px; text-indent: -48px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 25px; text-indent: -48px">/g, "<span style=\"display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb(0, 0, 102); line-height: 25px; text-indent: -48px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 25px; text-indent: -48px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb\(0, 0, 102\); line-height: 25px; text-indent: -48px">/g, "<span style=\"display: inline; font-style: italic; font-size: 24px; font-family: Helvetica-Oblique, sans-serif; color: rgb(0, 0, 102); line-height: 25px; text-indent: -48px\">$1$2");

retText = retText.replace(/<span style="display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px">/g, "<span style=\"display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px">/g, "<span style=\"display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px\">$1$2");
retText = retText.replace(/<span style="display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px">([^<>]+)<\/span>([^<>]*)<span style="display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px">/g, "<span style=\"display: inline; font-size: 22px; font-family: HiraKakuProN-W3; line-height: 24px\">$1$2");


retText = retText.replace(/<span ([^>]+?)>_____________<\/span>/g, '<hr />');

retText = retText.replace(/ class="body"/g, '');
retText = retText.replace(/ class="body2"/g, '');

if (print == true)
{
el.innerHTML = retText ;
}
else
{
return retText;
}
}
/* end UniDict 4 functions */