var __output__ = "";
var __avp__ = true;
var __vars__ = null;
var __timerid__ = null;


function __changePrecision__(value) {
    __oldInputValues__ = null;
    __precision__ = Number(value);
    __calculateNow__();
}
function __getValue__(obj) {
    if ((typeof(obj.type) != "string") && (obj.length > 0) && (obj[0] != null) && (obj[0].type == "radio")) {
        for (var i = 0; i < obj.length; i++) {
            if (obj[i].checked == true) {
				try {
					return eval(obj[i].value);
				}catch(e) {
					return obj[i].value;
				}
            }
        }
        __avp__ = false;
    } else if ((obj.type == "number") || (obj.type == "text")) {
        if (obj.value == "" || obj.value == ".") {
            __avp__ = false;
            return obj.value;
        }
        return eval(obj.value);
    } else if (obj.type == "hidden") {
        return eval(obj.value);
    } else if (obj.type == "textarea") {
        return eval(obj.value);
    } else if (obj.type == "checkbox") {
        if (obj.checked == true) {
            return eval(obj.value);
        }
    } else if (obj.type == "select-one") {
        if (obj.options.length > 0 && obj.selectedIndex > -1) {
            var val = obj.options[obj.selectedIndex].value;
		    if (val == undefined || val == "") {
                __avp__ = false;
            }
			try {
				return eval(val);
            }catch(e) {
				return val;
			}
        }
    } else if (obj.type == "select-multiple") {
        var val = [];
        var j = 0;

        for (var i = 0; i < obj.options.length; i++) {
            if (obj.options[i].selected) {
                val[j++] = eval(obj.options[i].value);
            }
        }

        return val;
    }
    return "";
}

function __printOutput__() {
document.getElementById('resultBox').className = "result";
    var objResult = document.getElementById("div_txtResult");
    if (objResult) {
        objResult.innerHTML = "";
    }
    
    if (__vars__ == null) { 
        if (__avp__) {
            if (objResult) {
                objResult.innerHTML = __round__(__output__);
            }
        } else {
            __clear__();
        }
    } else {
        for (i = 0; i < __vars__.length; i++) {
            if (__vars__[i]) {
                __vars__[i].value = "";
                var divname=  'div_' + __vars__[i].id;
				var obj = document.getElementById(divname);
				obj.innerHTML ="";
            }
        }

        if (__avp__) {
            values = __output__.split('|');
            remainder = "";

            for (i = 0; i < values.length; i++) {
                pair = values[i].split(':');
                if (pair.length >= 2) {
                    if (pair[0] < __vars__.length && __vars__[pair[0]]) {
						__vars__[pair[0]].value = "" + __round__(pair.slice(1, pair.length));
						var divname=  'div_' + __vars__[pair[0]].id;
						var obj = document.getElementById(divname);
						obj.innerHTML =__vars__[pair[0]].value;
                    } else {
                        remainder += pair[1]; 
                    }
                } else {
                    remainder += pair;
                }
            }

            if (remainder != "") {
                if (objResult) {
                    objResult.innerHTML = __round__(remainder);
                } else {
                    alert(remainder);
                }
            }
        }
    }
}


function __round__(obj) {
document.getElementById('resultBox').className = "result resultdone";
    var intValue = Number(obj); 
    if (isNaN(intValue)) {
        var rx = new RegExp(/([-])?([0-9])+(\.([0-9])+)?/);
        var result = rx.exec(obj);

        if (result != null) {
            var value = "";
            var remainder = obj;
            
            intValue = Number(result[0]);	    

            while (intValue != "" && !isNaN(intValue)) {         
                var multiplier = Math.pow(10, __precision__);
                intValue = Math.round(intValue * multiplier) / multiplier;

                if (isNaN(intValue)) {
                    value += RegExp.leftContext + result[0];
                } else {
                    value += RegExp.leftContext + intValue;
                }

                remainder = RegExp.rightContext;
                result = rx.exec(remainder);
                
                if (result == null) {
                    intValue = "";
                } else {
                    intValue = Number(result[0]);
                }
            }

            if (value != "") {
                return value + remainder;
            }
        }
    } else if (obj != "") {
        var multiplier = Math.pow(10, __precision__);
        intValue = Math.round(intValue * multiplier) / multiplier;

        if (!isNaN(intValue)) {
            return intValue;
        }
    }
	
    return obj;
}

function __getInputValue__(obj) { 
    var value = __getValue__(obj);

    var intValue = Number(value);
    if (value != "" && typeof(value) == "string" && !isNaN(intValue)) {
        value = intValue;
    }
    return value;
}

function print(obj) {
    __output__ += obj;
}

function __calculateNow__() {
    // Disable smart calculation for now and clear result
    __oldInputValues__ = null;
    __avp__ = false; 
    __printOutput__();
    __output__ = "";
    __avp__ = true;
    if (__calculate__(document.artform)) {
        __printOutput__();
    }
}

function __calculate__(obj)
{
	if (obj)
	{		
		eval(obj.form.id + '_func();');
	}
}


function __startCalculating__() {
    __timerid__ = setInterval("__calculateNow__()", 250);
}

function __stopCalculating__() {
    clearInterval(__timerid__);
    __calculateNow__();
}

function __delayedCalculate__() {

    clearTimeout(__timerid__ );

    __timerid__ = setTimeout("__calculateNow__()", 250);

}

function __clear__() {
    var objResult = document.getElementById("div_txtResult");
    if (objResult) {
        objResult.innerHTML = "";
    }

    __avp__ = false; 
}

function RoundOff1(InV, tol) {
    retVal = InV;
    rem = InV % tol;

    if ((rem/tol) >= 0.5) {
        retVal = InV - rem + tol;
    } else {
        retVal = InV - rem;
    }

    return retVal;
}

function roundOffDC(inp) {
	if (isNaN(inp))	{
		newval = 0;
	}else if (inp > 20) {
        if (inp > 1000000) {
            newval = RoundOff1(inp, 10000);
        } else if (inp > 100000) {
            newval = RoundOff1(inp, 1000);
        } else if (inp > 10000) {
            newval = RoundOff1(inp, 100);
        } else if (inp > 1000) {
            newval = RoundOff1(inp, 25);
        } else if (inp > 200) {
            newval = RoundOff1(inp, 10);
        } else if (inp > 100) {
            newval = RoundOff1(inp, 5);
        } else if (inp > 20) {
            newval = RoundOff1(inp, 1);
        }
    } else if (inp > 1) {
        if (inp > 10) {
            inp = inp * 100;
            newval = RoundOff1(inp, 50); // actually 0.5;
            newval = newval / 100;
        } else if (inp > 5) {
            inp = inp * 100;
            newval = RoundOff1(inp, 25); // actually 0.25;
            newval = newval / 100;
        } else if (inp > 1) {
            inp = inp * 100;
            newval = RoundOff1(inp, 10); // actually 0.1;
            newval = newval / 100;
        }
    } else if (inp > 0.5) {
        inp = inp * 1000;
        newval = RoundOff1(inp, 50); // actually 0.05;
        newval = newval / 1000;
    } else if (inp > 0.1) {
        inp = inp * 1000;
        newval = RoundOff1(inp, 10); // actually 0.01;
        newval = newval / 1000;
    } else if (inp > 0.01) {
        inp = inp * 1000;
        newval = RoundOff1(inp, 1); // actually 0.001;
        newval = newval / 1000;
    } else if (inp > 0) {
        inp = inp * 100000;
        newval = RoundOff1(inp, 10); // actually 0.0001;
        newval = newval / 100000;
    }

    return newval;
}

function __showText__(text) {
    if (text.length > 20) {
        alert(text);
    }
}

window.onload=__calculateNow__;

function __calculate__(text) {
    return true;
}
