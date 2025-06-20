package org.apache.commons.httpclient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.cookie.CookieSpec;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpState {
    private static final Log LOG;
    public static final String PREEMPTIVE_DEFAULT = "false";
    public static final String PREEMPTIVE_PROPERTY = "httpclient.authentication.preemptive";
    static /* synthetic */ Class class$org$apache$commons$httpclient$HttpState;
    private int cookiePolicy = -1;
    protected ArrayList cookies = new ArrayList();
    protected HashMap credMap = new HashMap();
    private boolean preemptive = false;
    protected HashMap proxyCred = new HashMap();

    static {
        Class cls = class$org$apache$commons$httpclient$HttpState;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.HttpState");
            class$org$apache$commons$httpclient$HttpState = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static String getCookiesStringRepresentation(List list) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Cookie cookie = (Cookie) it2.next();
            if (stringBuffer.length() > 0) {
                stringBuffer.append("#");
            }
            stringBuffer.append(cookie.toExternalForm());
        }
        return stringBuffer.toString();
    }

    private static String getCredentialsStringRepresentation(Map map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Object next : map.keySet()) {
            Credentials credentials = (Credentials) map.get(next);
            if (stringBuffer.length() > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(next);
            stringBuffer.append("#");
            stringBuffer.append(credentials.toString());
        }
        return stringBuffer.toString();
    }

    private static Credentials matchCredentials(HashMap hashMap, AuthScope authScope) {
        Credentials credentials = (Credentials) hashMap.get(authScope);
        if (credentials != null) {
            return credentials;
        }
        int i2 = -1;
        AuthScope authScope2 = null;
        for (AuthScope authScope3 : hashMap.keySet()) {
            int match = authScope.match(authScope3);
            if (match > i2) {
                authScope2 = authScope3;
                i2 = match;
            }
        }
        return authScope2 != null ? (Credentials) hashMap.get(authScope2) : credentials;
    }

    public synchronized void addCookie(Cookie cookie) {
        try {
            LOG.trace("enter HttpState.addCookie(Cookie)");
            if (cookie != null) {
                Iterator it2 = this.cookies.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (cookie.equals((Cookie) it2.next())) {
                            it2.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!cookie.isExpired()) {
                    this.cookies.add(cookie);
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void addCookies(Cookie[] cookieArr) {
        LOG.trace("enter HttpState.addCookies(Cookie[])");
        if (cookieArr != null) {
            for (Cookie addCookie : cookieArr) {
                addCookie(addCookie);
            }
        }
    }

    public void clear() {
        clearCookies();
        clearCredentials();
        clearProxyCredentials();
    }

    public synchronized void clearCookies() {
        this.cookies.clear();
    }

    public void clearCredentials() {
        this.credMap.clear();
    }

    public void clearProxyCredentials() {
        this.proxyCred.clear();
    }

    public int getCookiePolicy() {
        return this.cookiePolicy;
    }

    public synchronized Cookie[] getCookies() {
        ArrayList arrayList;
        LOG.trace("enter HttpState.getCookies()");
        arrayList = this.cookies;
        return (Cookie[]) arrayList.toArray(new Cookie[arrayList.size()]);
    }

    public synchronized Credentials getCredentials(String str, String str2) {
        LOG.trace("enter HttpState.getCredentials(String, String");
        return matchCredentials(this.credMap, new AuthScope(str2, -1, str, AuthScope.ANY_SCHEME));
    }

    public synchronized Credentials getProxyCredentials(String str, String str2) {
        LOG.trace("enter HttpState.getCredentials(String, String");
        return matchCredentials(this.proxyCred, new AuthScope(str2, -1, str, AuthScope.ANY_SCHEME));
    }

    public boolean isAuthenticationPreemptive() {
        return this.preemptive;
    }

    public synchronized boolean purgeExpiredCookies() {
        LOG.trace("enter HttpState.purgeExpiredCookies()");
        return purgeExpiredCookies(new Date());
    }

    public void setAuthenticationPreemptive(boolean z) {
        this.preemptive = z;
    }

    public void setCookiePolicy(int i2) {
        this.cookiePolicy = i2;
    }

    public synchronized void setCredentials(String str, String str2, Credentials credentials) {
        LOG.trace("enter HttpState.setCredentials(String, String, Credentials)");
        this.credMap.put(new AuthScope(str2, -1, str, AuthScope.ANY_SCHEME), credentials);
    }

    public synchronized void setProxyCredentials(String str, String str2, Credentials credentials) {
        LOG.trace("enter HttpState.setProxyCredentials(String, String, Credentials");
        this.proxyCred.put(new AuthScope(str2, -1, str, AuthScope.ANY_SCHEME), credentials);
    }

    public synchronized String toString() {
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(getCredentialsStringRepresentation(this.proxyCred));
        stringBuffer.append(" | ");
        stringBuffer.append(getCredentialsStringRepresentation(this.credMap));
        stringBuffer.append(" | ");
        stringBuffer.append(getCookiesStringRepresentation(this.cookies));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public synchronized Cookie[] getCookies(String str, int i2, String str2, boolean z) {
        ArrayList arrayList;
        try {
            LOG.trace("enter HttpState.getCookies(String, int, String, boolean)");
            CookieSpec defaultSpec = CookiePolicy.getDefaultSpec();
            arrayList = new ArrayList(this.cookies.size());
            int size = this.cookies.size();
            for (int i3 = 0; i3 < size; i3++) {
                Cookie cookie = (Cookie) this.cookies.get(i3);
                if (defaultSpec.match(str, i2, str2, z, cookie)) {
                    arrayList.add(cookie);
                }
            }
        } finally {
            while (true) {
            }
        }
        return (Cookie[]) arrayList.toArray(new Cookie[arrayList.size()]);
    }

    public synchronized Credentials getCredentials(AuthScope authScope) {
        if (authScope != null) {
            LOG.trace("enter HttpState.getCredentials(AuthScope)");
        } else {
            throw new IllegalArgumentException("Authentication scope may not be null");
        }
        return matchCredentials(this.credMap, authScope);
    }

    public synchronized Credentials getProxyCredentials(AuthScope authScope) {
        if (authScope != null) {
            LOG.trace("enter HttpState.getProxyCredentials(AuthScope)");
        } else {
            throw new IllegalArgumentException("Authentication scope may not be null");
        }
        return matchCredentials(this.proxyCred, authScope);
    }

    public synchronized boolean purgeExpiredCookies(Date date) {
        boolean z;
        LOG.trace("enter HttpState.purgeExpiredCookies(Date)");
        Iterator it2 = this.cookies.iterator();
        z = false;
        while (it2.hasNext()) {
            if (((Cookie) it2.next()).isExpired(date)) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public synchronized void setCredentials(AuthScope authScope, Credentials credentials) {
        if (authScope != null) {
            LOG.trace("enter HttpState.setCredentials(AuthScope, Credentials)");
            this.credMap.put(authScope, credentials);
        } else {
            throw new IllegalArgumentException("Authentication scope may not be null");
        }
    }

    public synchronized void setProxyCredentials(AuthScope authScope, Credentials credentials) {
        if (authScope != null) {
            LOG.trace("enter HttpState.setProxyCredentials(AuthScope, Credentials)");
            this.proxyCred.put(authScope, credentials);
        } else {
            throw new IllegalArgumentException("Authentication scope may not be null");
        }
    }
}
