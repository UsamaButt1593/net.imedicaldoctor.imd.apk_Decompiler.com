package org.apache.commons.httpclient;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.util.LangUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Cookie extends NameValuePair implements Serializable, Comparator {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$Cookie;
    private String cookieComment;
    private String cookieDomain;
    private Date cookieExpiryDate;
    private String cookiePath;
    private int cookieVersion;
    private boolean hasDomainAttribute;
    private boolean hasPathAttribute;
    private boolean isSecure;

    static {
        Class cls = class$org$apache$commons$httpclient$Cookie;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.Cookie");
            class$org$apache$commons$httpclient$Cookie = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public Cookie() {
        this((String) null, "noname", (String) null, (String) null, (Date) null, false);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public int compare(Object obj, Object obj2) {
        LOG.trace("enter Cookie.compare(Object, Object)");
        if (!(obj instanceof Cookie)) {
            throw new ClassCastException(obj.getClass().getName());
        } else if (obj2 instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            Cookie cookie2 = (Cookie) obj2;
            if (cookie.getPath() == null && cookie2.getPath() == null) {
                return 0;
            }
            if (cookie.getPath() == null) {
                return cookie2.getPath().equals("/") ? 0 : -1;
            }
            String path = cookie2.getPath();
            String path2 = cookie.getPath();
            return path == null ? path2.equals("/") ? 0 : 1 : path2.compareTo(cookie2.getPath());
        } else {
            throw new ClassCastException(obj2.getClass().getName());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return LangUtils.equals(getName(), cookie.getName()) && LangUtils.equals(this.cookieDomain, cookie.cookieDomain) && LangUtils.equals(this.cookiePath, cookie.cookiePath);
    }

    public String getComment() {
        return this.cookieComment;
    }

    public String getDomain() {
        return this.cookieDomain;
    }

    public Date getExpiryDate() {
        return this.cookieExpiryDate;
    }

    public String getPath() {
        return this.cookiePath;
    }

    public boolean getSecure() {
        return this.isSecure;
    }

    public int getVersion() {
        return this.cookieVersion;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, (Object) getName()), (Object) this.cookieDomain), (Object) this.cookiePath);
    }

    public boolean isDomainAttributeSpecified() {
        return this.hasDomainAttribute;
    }

    public boolean isExpired() {
        Date date = this.cookieExpiryDate;
        return date != null && date.getTime() <= System.currentTimeMillis();
    }

    public boolean isPathAttributeSpecified() {
        return this.hasPathAttribute;
    }

    public boolean isPersistent() {
        return this.cookieExpiryDate != null;
    }

    public void setComment(String str) {
        this.cookieComment = str;
    }

    public void setDomain(String str) {
        if (str != null) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            this.cookieDomain = str.toLowerCase();
        }
    }

    public void setDomainAttributeSpecified(boolean z) {
        this.hasDomainAttribute = z;
    }

    public void setExpiryDate(Date date) {
        this.cookieExpiryDate = date;
    }

    public void setPath(String str) {
        this.cookiePath = str;
    }

    public void setPathAttributeSpecified(boolean z) {
        this.hasPathAttribute = z;
    }

    public void setSecure(boolean z) {
        this.isSecure = z;
    }

    public void setVersion(int i2) {
        this.cookieVersion = i2;
    }

    public String toExternalForm() {
        return (getVersion() > 0 ? CookiePolicy.getDefaultSpec() : CookiePolicy.getCookieSpec(CookiePolicy.NETSCAPE)).formatCookie(this);
    }

    public String toString() {
        return toExternalForm();
    }

    public Cookie(String str, String str2, String str3) {
        this(str, str2, str3, (String) null, (Date) null, false);
    }

    public boolean isExpired(Date date) {
        Date date2 = this.cookieExpiryDate;
        return date2 != null && date2.getTime() <= date.getTime();
    }

    public Cookie(String str, String str2, String str3, String str4, int i2, boolean z) {
        this(str, str2, str3, str4, (Date) null, z);
        if (i2 < -1) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Invalid max age:  ");
            stringBuffer.append(Integer.toString(i2));
            throw new IllegalArgumentException(stringBuffer.toString());
        } else if (i2 >= 0) {
            setExpiryDate(new Date(System.currentTimeMillis() + (((long) i2) * 1000)));
        }
    }

    public Cookie(String str, String str2, String str3, String str4, Date date, boolean z) {
        super(str2, str3);
        this.hasPathAttribute = false;
        this.hasDomainAttribute = false;
        this.cookieVersion = 0;
        LOG.trace("enter Cookie(String, String, String, String, Date, boolean)");
        if (str2 == null) {
            throw new IllegalArgumentException("Cookie name may not be null");
        } else if (!str2.trim().equals("")) {
            setPath(str4);
            setDomain(str);
            setExpiryDate(date);
            setSecure(z);
        } else {
            throw new IllegalArgumentException("Cookie name may not be blank");
        }
    }
}
