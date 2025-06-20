package org.apache.commons.httpclient.auth;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.util.ParameterParser;

public final class AuthChallengeParser {
    public static Map extractParams(String str) throws MalformedChallengeException {
        if (str != null) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                HashMap hashMap = new HashMap();
                List parse = new ParameterParser().parse(str.substring(indexOf + 1, str.length()), (char) ASCIIPropertyListParser.f18651i);
                for (int i2 = 0; i2 < parse.size(); i2++) {
                    NameValuePair nameValuePair = (NameValuePair) parse.get(i2);
                    hashMap.put(nameValuePair.getName().toLowerCase(), nameValuePair.getValue());
                }
                return hashMap;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid challenge: ");
            stringBuffer.append(str);
            throw new MalformedChallengeException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("Challenge may not be null");
    }

    public static String extractScheme(String str) throws MalformedChallengeException {
        if (str != null) {
            int indexOf = str.indexOf(32);
            String substring = indexOf == -1 ? str : str.substring(0, indexOf);
            if (!substring.equals("")) {
                return substring.toLowerCase();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid challenge: ");
            stringBuffer.append(str);
            throw new MalformedChallengeException(stringBuffer.toString());
        }
        throw new IllegalArgumentException("Challenge may not be null");
    }

    public static Map parseChallenges(Header[] headerArr) throws MalformedChallengeException {
        if (headerArr != null) {
            HashMap hashMap = new HashMap(headerArr.length);
            for (Header value : headerArr) {
                String value2 = value.getValue();
                hashMap.put(extractScheme(value2), value2);
            }
            return hashMap;
        }
        throw new IllegalArgumentException("Array of challenges may not be null");
    }
}
