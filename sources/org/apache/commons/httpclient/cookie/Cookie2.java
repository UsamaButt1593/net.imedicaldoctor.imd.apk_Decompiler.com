package org.apache.commons.httpclient.cookie;

import java.util.Date;
import org.apache.commons.httpclient.Cookie;

public class Cookie2 extends Cookie {
    public static final String COMMENT = "comment";
    public static final String COMMENTURL = "commenturl";
    public static final String DISCARD = "discard";
    public static final String DOMAIN = "domain";
    public static final String MAXAGE = "max-age";
    public static final String PATH = "path";
    public static final String PORT = "port";
    public static final String SECURE = "secure";
    public static final String VERSION = "version";
    private String cookieCommentURL;
    private int[] cookiePorts;
    private boolean discard = false;
    private boolean hasPortAttribute = false;
    private boolean hasVersionAttribute = false;
    private boolean isPortAttributeBlank = false;

    public Cookie2() {
        super((String) null, "noname", (String) null, (String) null, (Date) null, false);
    }

    public String getCommentURL() {
        return this.cookieCommentURL;
    }

    public int[] getPorts() {
        return this.cookiePorts;
    }

    public boolean isPersistent() {
        return getExpiryDate() != null && !this.discard;
    }

    public boolean isPortAttributeBlank() {
        return this.isPortAttributeBlank;
    }

    public boolean isPortAttributeSpecified() {
        return this.hasPortAttribute;
    }

    public boolean isVersionAttributeSpecified() {
        return this.hasVersionAttribute;
    }

    public void setCommentURL(String str) {
        this.cookieCommentURL = str;
    }

    public void setDiscard(boolean z) {
        this.discard = z;
    }

    public void setPortAttributeBlank(boolean z) {
        this.isPortAttributeBlank = z;
    }

    public void setPortAttributeSpecified(boolean z) {
        this.hasPortAttribute = z;
    }

    public void setPorts(int[] iArr) {
        this.cookiePorts = iArr;
    }

    public void setVersionAttributeSpecified(boolean z) {
        this.hasVersionAttribute = z;
    }

    public String toExternalForm() {
        return CookiePolicy.getCookieSpec(CookiePolicy.RFC_2965).formatCookie(this);
    }

    public Cookie2(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public Cookie2(String str, String str2, String str3, String str4, Date date, boolean z) {
        super(str, str2, str3, str4, date, z);
    }

    public Cookie2(String str, String str2, String str3, String str4, Date date, boolean z, int[] iArr) {
        super(str, str2, str3, str4, date, z);
        setPorts(iArr);
    }
}
