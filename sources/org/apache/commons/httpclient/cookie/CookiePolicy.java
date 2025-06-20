package org.apache.commons.httpclient.cookie;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class CookiePolicy {
    public static final String BROWSER_COMPATIBILITY = "compatibility";
    public static final int COMPATIBILITY = 0;
    public static final String DEFAULT = "default";
    public static final String IGNORE_COOKIES = "ignoreCookies";
    protected static final Log LOG;
    public static final String NETSCAPE = "netscape";
    public static final int NETSCAPE_DRAFT = 1;
    public static final int RFC2109 = 2;
    public static final int RFC2965 = 3;
    public static final String RFC_2109 = "rfc2109";
    public static final String RFC_2965 = "rfc2965";
    private static Map SPECS = Collections.synchronizedMap(new HashMap());
    static /* synthetic */ Class class$org$apache$commons$httpclient$cookie$CookiePolicy;
    static /* synthetic */ Class class$org$apache$commons$httpclient$cookie$CookieSpecBase;
    static /* synthetic */ Class class$org$apache$commons$httpclient$cookie$IgnoreCookiesSpec;
    static /* synthetic */ Class class$org$apache$commons$httpclient$cookie$NetscapeDraftSpec;
    static /* synthetic */ Class class$org$apache$commons$httpclient$cookie$RFC2109Spec;
    static /* synthetic */ Class class$org$apache$commons$httpclient$cookie$RFC2965Spec;
    private static int defaultPolicy = 2;

    static {
        Class cls = class$org$apache$commons$httpclient$cookie$RFC2109Spec;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.cookie.RFC2109Spec");
            class$org$apache$commons$httpclient$cookie$RFC2109Spec = cls;
        }
        registerCookieSpec(DEFAULT, cls);
        Class cls2 = class$org$apache$commons$httpclient$cookie$RFC2109Spec;
        if (cls2 == null) {
            cls2 = class$("org.apache.commons.httpclient.cookie.RFC2109Spec");
            class$org$apache$commons$httpclient$cookie$RFC2109Spec = cls2;
        }
        registerCookieSpec(RFC_2109, cls2);
        Class cls3 = class$org$apache$commons$httpclient$cookie$RFC2965Spec;
        if (cls3 == null) {
            cls3 = class$("org.apache.commons.httpclient.cookie.RFC2965Spec");
            class$org$apache$commons$httpclient$cookie$RFC2965Spec = cls3;
        }
        registerCookieSpec(RFC_2965, cls3);
        Class cls4 = class$org$apache$commons$httpclient$cookie$CookieSpecBase;
        if (cls4 == null) {
            cls4 = class$("org.apache.commons.httpclient.cookie.CookieSpecBase");
            class$org$apache$commons$httpclient$cookie$CookieSpecBase = cls4;
        }
        registerCookieSpec(BROWSER_COMPATIBILITY, cls4);
        Class cls5 = class$org$apache$commons$httpclient$cookie$NetscapeDraftSpec;
        if (cls5 == null) {
            cls5 = class$("org.apache.commons.httpclient.cookie.NetscapeDraftSpec");
            class$org$apache$commons$httpclient$cookie$NetscapeDraftSpec = cls5;
        }
        registerCookieSpec(NETSCAPE, cls5);
        Class cls6 = class$org$apache$commons$httpclient$cookie$IgnoreCookiesSpec;
        if (cls6 == null) {
            cls6 = class$("org.apache.commons.httpclient.cookie.IgnoreCookiesSpec");
            class$org$apache$commons$httpclient$cookie$IgnoreCookiesSpec = cls6;
        }
        registerCookieSpec(IGNORE_COOKIES, cls6);
        Class cls7 = class$org$apache$commons$httpclient$cookie$CookiePolicy;
        if (cls7 == null) {
            cls7 = class$("org.apache.commons.httpclient.cookie.CookiePolicy");
            class$org$apache$commons$httpclient$cookie$CookiePolicy = cls7;
        }
        LOG = LogFactory.getLog(cls7);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static CookieSpec getCompatibilitySpec() {
        return getSpecByPolicy(0);
    }

    public static CookieSpec getCookieSpec(String str) throws IllegalStateException {
        if (str != null) {
            Class cls = (Class) SPECS.get(str.toLowerCase());
            if (cls != null) {
                try {
                    return (CookieSpec) cls.newInstance();
                } catch (Exception e2) {
                    Log log = LOG;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Error initializing cookie spec: ");
                    stringBuffer.append(str);
                    log.error(stringBuffer.toString(), e2);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str);
                    stringBuffer2.append(" cookie spec implemented by ");
                    stringBuffer2.append(cls.getName());
                    stringBuffer2.append(" could not be initialized");
                    throw new IllegalStateException(stringBuffer2.toString());
                }
            } else {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Unsupported cookie spec ");
                stringBuffer3.append(str);
                throw new IllegalStateException(stringBuffer3.toString());
            }
        } else {
            throw new IllegalArgumentException("Id may not be null");
        }
    }

    public static int getDefaultPolicy() {
        return defaultPolicy;
    }

    public static CookieSpec getDefaultSpec() {
        try {
            return getCookieSpec(DEFAULT);
        } catch (IllegalStateException unused) {
            LOG.warn("Default cookie policy is not registered");
            return new RFC2109Spec();
        }
    }

    public static String[] getRegisteredCookieSpecs() {
        return (String[]) SPECS.keySet().toArray(new String[SPECS.size()]);
    }

    public static CookieSpec getSpecByPolicy(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? getDefaultSpec() : new RFC2965Spec() : new RFC2109Spec() : new NetscapeDraftSpec() : new CookieSpecBase();
    }

    public static CookieSpec getSpecByVersion(int i2) {
        return i2 != 0 ? i2 != 1 ? getDefaultSpec() : new RFC2109Spec() : new NetscapeDraftSpec();
    }

    public static void registerCookieSpec(String str, Class cls) {
        if (str == null) {
            throw new IllegalArgumentException("Id may not be null");
        } else if (cls != null) {
            SPECS.put(str.toLowerCase(), cls);
        } else {
            throw new IllegalArgumentException("Cookie spec class may not be null");
        }
    }

    public static void setDefaultPolicy(int i2) {
        defaultPolicy = i2;
    }

    public static void unregisterCookieSpec(String str) {
        if (str != null) {
            SPECS.remove(str.toLowerCase());
            return;
        }
        throw new IllegalArgumentException("Id may not be null");
    }
}
