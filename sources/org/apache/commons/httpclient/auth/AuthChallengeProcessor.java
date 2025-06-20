package org.apache.commons.httpclient.auth;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.httpclient.params.HttpParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class AuthChallengeProcessor {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$AuthChallengeProcessor;
    private HttpParams params = null;

    static {
        Class cls = class$org$apache$commons$httpclient$auth$AuthChallengeProcessor;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.auth.AuthChallengeProcessor");
            class$org$apache$commons$httpclient$auth$AuthChallengeProcessor = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public AuthChallengeProcessor(HttpParams httpParams) {
        if (httpParams != null) {
            this.params = httpParams;
            return;
        }
        throw new IllegalArgumentException("Parameter collection may not be null");
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public AuthScheme processChallenge(AuthState authState, Map map) throws MalformedChallengeException, AuthenticationException {
        if (authState == null) {
            throw new IllegalArgumentException("Authentication state may not be null");
        } else if (map != null) {
            if (authState.isPreemptive() || authState.getAuthScheme() == null) {
                authState.setAuthScheme(selectAuthScheme(map));
            }
            AuthScheme authScheme = authState.getAuthScheme();
            String schemeName = authScheme.getSchemeName();
            Log log = LOG;
            if (log.isDebugEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Using authentication scheme: ");
                stringBuffer.append(schemeName);
                log.debug(stringBuffer.toString());
            }
            String str = (String) map.get(schemeName.toLowerCase());
            if (str != null) {
                authScheme.processChallenge(str);
                log.debug("Authorization challenge processed");
                return authScheme;
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(schemeName);
            stringBuffer2.append(" authorization challenge expected, but not found");
            throw new AuthenticationException(stringBuffer2.toString());
        } else {
            throw new IllegalArgumentException("Challenge map may not be null");
        }
    }

    public AuthScheme selectAuthScheme(Map map) throws AuthChallengeException {
        AuthScheme authScheme;
        if (map != null) {
            Collection collection = (Collection) this.params.getParameter(AuthPolicy.AUTH_SCHEME_PRIORITY);
            if (collection == null || collection.isEmpty()) {
                collection = AuthPolicy.getDefaultAuthPrefs();
            }
            Log log = LOG;
            if (log.isDebugEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Supported authentication schemes in the order of preference: ");
                stringBuffer.append(collection);
                log.debug(stringBuffer.toString());
            }
            Iterator it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    authScheme = null;
                    break;
                }
                String str = (String) it2.next();
                if (((String) map.get(str.toLowerCase())) != null) {
                    Log log2 = LOG;
                    if (log2.isInfoEnabled()) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(str);
                        stringBuffer2.append(" authentication scheme selected");
                        log2.info(stringBuffer2.toString());
                    }
                    try {
                        authScheme = AuthPolicy.getAuthScheme(str);
                    } catch (IllegalStateException e2) {
                        throw new AuthChallengeException(e2.getMessage());
                    }
                } else {
                    Log log3 = LOG;
                    if (log3.isDebugEnabled()) {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append("Challenge for ");
                        stringBuffer3.append(str);
                        stringBuffer3.append(" authentication scheme not available");
                        log3.debug(stringBuffer3.toString());
                    }
                }
            }
            if (authScheme != null) {
                return authScheme;
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Unable to respond to any of these challenges: ");
            stringBuffer4.append(map);
            throw new AuthChallengeException(stringBuffer4.toString());
        }
        throw new IllegalArgumentException("Challenge map may not be null");
    }
}
