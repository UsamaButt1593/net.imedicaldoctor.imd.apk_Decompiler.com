package org.apache.commons.httpclient.cookie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.NameValuePair;

public class NetscapeDraftSpec extends CookieSpecBase {
    private static boolean isSpecialDomain(String str) {
        String upperCase = str.toUpperCase();
        return upperCase.endsWith(".COM") || upperCase.endsWith(".EDU") || upperCase.endsWith(".NET") || upperCase.endsWith(".GOV") || upperCase.endsWith(".MIL") || upperCase.endsWith(".ORG") || upperCase.endsWith(".INT");
    }

    public boolean domainMatch(String str, String str2) {
        return str.endsWith(str2);
    }

    public Cookie[] parse(String str, int i2, String str2, boolean z, String str3) throws MalformedCookieException {
        CookieSpecBase.LOG.trace("enter NetscapeDraftSpec.parse(String, port, path, boolean, Header)");
        if (str == null) {
            throw new IllegalArgumentException("Host of origin may not be null");
        } else if (str.trim().equals("")) {
            throw new IllegalArgumentException("Host of origin may not be blank");
        } else if (i2 < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid port: ");
            stringBuffer.append(i2);
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (str2 == null) {
            throw new IllegalArgumentException("Path of origin may not be null.");
        } else if (str3 != null) {
            if (str2.trim().equals("")) {
                str2 = "/";
            }
            String lowerCase = str.toLowerCase();
            int lastIndexOf = str2.lastIndexOf("/");
            if (lastIndexOf >= 0) {
                if (lastIndexOf == 0) {
                    lastIndexOf = 1;
                }
                str2 = str2.substring(0, lastIndexOf);
            }
            HeaderElement headerElement = new HeaderElement(str3.toCharArray());
            Cookie cookie = new Cookie(lowerCase, headerElement.getName(), headerElement.getValue(), str2, (Date) null, false);
            NameValuePair[] parameters = headerElement.getParameters();
            if (parameters != null) {
                for (NameValuePair parseAttribute : parameters) {
                    parseAttribute(parseAttribute, cookie);
                }
            }
            return new Cookie[]{cookie};
        } else {
            throw new IllegalArgumentException("Header may not be null.");
        }
    }

    public void parseAttribute(NameValuePair nameValuePair, Cookie cookie) throws MalformedCookieException {
        if (nameValuePair == null) {
            throw new IllegalArgumentException("Attribute may not be null.");
        } else if (cookie != null) {
            String lowerCase = nameValuePair.getName().toLowerCase();
            String value = nameValuePair.getValue();
            if (!lowerCase.equals("expires")) {
                super.parseAttribute(nameValuePair, cookie);
            } else if (value != null) {
                try {
                    cookie.setExpiryDate(new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss z", Locale.US).parse(value));
                } catch (ParseException e2) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Invalid expires attribute: ");
                    stringBuffer.append(e2.getMessage());
                    throw new MalformedCookieException(stringBuffer.toString());
                }
            } else {
                throw new MalformedCookieException("Missing value for expires attribute");
            }
        } else {
            throw new IllegalArgumentException("Cookie may not be null.");
        }
    }

    public void validate(String str, int i2, String str2, boolean z, Cookie cookie) throws MalformedCookieException {
        CookieSpecBase.LOG.trace("enterNetscapeDraftCookieProcessor RCF2109CookieProcessor.validate(Cookie)");
        super.validate(str, i2, str2, z, cookie);
        if (str.indexOf(".") >= 0) {
            int countTokens = new StringTokenizer(cookie.getDomain(), ".").countTokens();
            if (isSpecialDomain(cookie.getDomain())) {
                if (countTokens < 2) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Domain attribute \"");
                    stringBuffer.append(cookie.getDomain());
                    stringBuffer.append("\" violates the Netscape cookie specification for ");
                    stringBuffer.append("special domains");
                    throw new MalformedCookieException(stringBuffer.toString());
                }
            } else if (countTokens < 3) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Domain attribute \"");
                stringBuffer2.append(cookie.getDomain());
                stringBuffer2.append("\" violates the Netscape cookie specification");
                throw new MalformedCookieException(stringBuffer2.toString());
            }
        }
    }
}
