package org.apache.commons.httpclient.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AuthPolicy {
    public static final String AUTH_SCHEME_PRIORITY = "http.auth.scheme-priority";
    public static final String BASIC = "Basic";
    public static final String DIGEST = "Digest";
    protected static final Log LOG;
    public static final String NTLM = "NTLM";
    private static final HashMap SCHEMES = new HashMap();
    private static final ArrayList SCHEME_LIST = new ArrayList();
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$AuthPolicy;
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$BasicScheme;
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$DigestScheme;
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$NTLMScheme;

    static {
        Class cls = class$org$apache$commons$httpclient$auth$NTLMScheme;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.auth.NTLMScheme");
            class$org$apache$commons$httpclient$auth$NTLMScheme = cls;
        }
        registerAuthScheme(NTLM, cls);
        Class cls2 = class$org$apache$commons$httpclient$auth$DigestScheme;
        if (cls2 == null) {
            cls2 = class$("org.apache.commons.httpclient.auth.DigestScheme");
            class$org$apache$commons$httpclient$auth$DigestScheme = cls2;
        }
        registerAuthScheme(DIGEST, cls2);
        Class cls3 = class$org$apache$commons$httpclient$auth$BasicScheme;
        if (cls3 == null) {
            cls3 = class$("org.apache.commons.httpclient.auth.BasicScheme");
            class$org$apache$commons$httpclient$auth$BasicScheme = cls3;
        }
        registerAuthScheme(BASIC, cls3);
        Class cls4 = class$org$apache$commons$httpclient$auth$AuthPolicy;
        if (cls4 == null) {
            cls4 = class$("org.apache.commons.httpclient.auth.AuthPolicy");
            class$org$apache$commons$httpclient$auth$AuthPolicy = cls4;
        }
        LOG = LogFactory.getLog(cls4);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static synchronized AuthScheme getAuthScheme(String str) throws IllegalStateException {
        AuthScheme authScheme;
        synchronized (AuthPolicy.class) {
            if (str != null) {
                Class cls = (Class) SCHEMES.get(str.toLowerCase());
                if (cls != null) {
                    try {
                        authScheme = (AuthScheme) cls.newInstance();
                    } catch (Exception e2) {
                        Log log = LOG;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Error initializing authentication scheme: ");
                        stringBuffer.append(str);
                        log.error(stringBuffer.toString(), e2);
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(str);
                        stringBuffer2.append(" authentication scheme implemented by ");
                        stringBuffer2.append(cls.getName());
                        stringBuffer2.append(" could not be initialized");
                        throw new IllegalStateException(stringBuffer2.toString());
                    }
                } else {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Unsupported authentication scheme ");
                    stringBuffer3.append(str);
                    throw new IllegalStateException(stringBuffer3.toString());
                }
            } else {
                throw new IllegalArgumentException("Id may not be null");
            }
        }
        return authScheme;
    }

    public static synchronized List getDefaultAuthPrefs() {
        List list;
        synchronized (AuthPolicy.class) {
            list = (List) SCHEME_LIST.clone();
        }
        return list;
    }

    public static synchronized void registerAuthScheme(String str, Class cls) {
        synchronized (AuthPolicy.class) {
            if (str == null) {
                throw new IllegalArgumentException("Id may not be null");
            } else if (cls != null) {
                SCHEMES.put(str.toLowerCase(), cls);
                SCHEME_LIST.add(str.toLowerCase());
            } else {
                throw new IllegalArgumentException("Authentication scheme class may not be null");
            }
        }
    }

    public static synchronized void unregisterAuthScheme(String str) {
        synchronized (AuthPolicy.class) {
            if (str != null) {
                SCHEMES.remove(str.toLowerCase());
                SCHEME_LIST.remove(str.toLowerCase());
            } else {
                throw new IllegalArgumentException("Id may not be null");
            }
        }
    }
}
