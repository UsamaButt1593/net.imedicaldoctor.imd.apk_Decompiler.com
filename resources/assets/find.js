
// the main entry point to start the search
function highlightAllOccurencesOfString(keywordsArray, resultIdPrefix) {
    //first item is the search term, so leave as is, others are synonyms, so search with break
    var keywords = escapeRegexChars(keywordsArray[0]);
    for(var ii=1; ii<keywordsArray.length; ii++) {
        keywords = keywords + "|\\b" + escapeRegexChars(keywordsArray[ii]) + "\\b";
    }
    var keywordPattern = new RegExp(keywords, "i"); //case insensitive
    removeAllHighlights();
    var tmpArray = new Array();
    
    var objTopLevelElement = document.getElementById("contentBody");
    if (objTopLevelElement == null) {
        objTopLevelElement = document.body;
    }
    highlightAllOccurencesOfStringForElement(objTopLevelElement, keywordPattern, tmpArray, resultIdPrefix);
    var objInstances = new Array();
    //reverse the array
    var allSpans = document.getElementsByTagName("span");
    for (var ii=0; ii<allSpans.length; ii++) {
        var id = allSpans[ii].getAttribute("id");
        if (id != null && id.indexOf(resultIdPrefix) == 0) {
            objInstances[objInstances.length] = id;
        }
    }
    
    var jsonStringForArray = (JSON.stringify(objInstances));
    
    return jsonStringForArray;
}

// helper function, recursively searches in elements and their child nodes
function highlightAllOccurencesOfStringForElement(element, keywordPattern, instances, resultIdPrefix) {
    if (element) {
        if (element.nodeType == 3) {        // Text node
            while (true) {


                if (element.parentNode instanceof HTMLStyleElement ){
                    break;
                }

                var value = element.nodeValue;  // Search for keyword in text node
                //var idx = value.toLowerCase().indexOf(keyword);



                var match = keywordPattern.exec(value);

                if (match == null) {
                    break;             // not found, abort
                }


                var idx = match.index;
                var span = document.createElement("span");
                var text = document.createTextNode(value.substr(idx, match[0].length));
                var curId = resultIdPrefix + instances.length;
                span.appendChild(text);
                span.setAttribute("class", "highlighted");
                span.setAttribute("id", curId);
                text = document.createTextNode(value.substr(idx + match[0].length));
                instances[instances.length] = curId;
                element.deleteData(idx, value.length - idx);
                var next = element.nextSibling;
                element.parentNode.insertBefore(span, next);
                element.parentNode.insertBefore(text, next);
                element = text;
            }
        } else if (element.nodeType == 1) { // Element node

            if (isVisible(element) &&
            element.nodeName.toLowerCase() != 'select' &&
            element.nodeName.toLowerCase() != 'script' &&
            element.className.toLowerCase() != 'visibleprintonly' &&
            element.className.toLowerCase() != 'visiblenever') {
                for (var i=element.childNodes.length-1; i>=0; i--) {
                    highlightAllOccurencesOfStringForElement(element.childNodes[i], keywordPattern, instances, resultIdPrefix);
                }
            }
        }
    }
}

function isVisible(elem){
    return !!( elem.offsetWidth || elem.offsetHeight || elem.getClientRects().length );
}
// helper function, recursively removes the highlights in elements and their childs
function removeAllHighlightsForElement(element, resultIdPrefix) {
    if (element) {
        if (element.nodeType == 1) {
            var id = element.getAttribute("id");
            if (id != null && id.indexOf(resultIdPrefix) == 0) {
                var text = element.removeChild(element.firstChild);
                element.parentNode.insertBefore(text,element);
                element.parentNode.removeChild(element);
                return true;
            } else {
                var normalize = false;
                for (var i = element.childNodes.length - 1; i >= 0; i--) {
                    if (removeAllHighlightsForElement(element.childNodes[i], resultIdPrefix)) {
                        normalize = true;
                    }
                }
                if (normalize) {
                    element.normalize();
                }
            }
        }
    }
    return false;
}

// the main entry point to remove the highlights
function removeAllHighlights(resultIdPrefix) {
    var objTopLevelElement = document.getElementById("contentBody");
    if (objTopLevelElement == null) {
        objTopLevelElement = document.body;
    }
    removeAllHighlightsForElement(objTopLevelElement, resultIdPrefix);
}

function escapeRegexChars(input) {
    var output = input.replace("\\", "\\\\")
    .replace("?", "\\?")
    .replace(".", "\\.")
    .replace("^", "\\^")
    .replace("$", "\\$")
    .replace("*", "\\*")
    .replace("+", "\\+")
    .replace("{", "\\{")
    .replace("[", "\\[")
    .replace("]", "\\]")
    .replace("|", "\\|")
    .replace("(", "\\(")
    .replace(")", "\\)");
    return output;
}

function goToSelectedItem(itemId) {
    var obj = document.getElementById(itemId);
    obj.className = 'highlightedCurrent';
    obj.scrollIntoView(true);
    document.body.scrollTop = window.pageYOffset - 50;
}
