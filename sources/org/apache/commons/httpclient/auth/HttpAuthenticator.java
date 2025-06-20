package org.apache.commons.httpclient.auth;

import java.util.HashMap;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class HttpAuthenticator {
    private static final Log LOG;
    public static final String PROXY_AUTH = "Proxy-Authenticate";
    public static final String PROXY_AUTH_RESP = "Proxy-Authorization";
    public static final String WWW_AUTH = "WWW-Authenticate";
    public static final String WWW_AUTH_RESP = "Authorization";
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$HttpAuthenticator;

    static {
        Class cls = class$org$apache$commons$httpclient$auth$HttpAuthenticator;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.auth.HttpAuthenticator");
            class$org$apache$commons$httpclient$auth$HttpAuthenticator = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public static boolean authenticate(AuthScheme authScheme, HttpMethod httpMethod, HttpConnection httpConnection, HttpState httpState) throws AuthenticationException {
        LOG.trace("enter HttpAuthenticator.authenticate(AuthScheme, HttpMethod, HttpConnection, HttpState)");
        return doAuthenticate(authScheme, httpMethod, httpConnection, httpState, false);
    }

    public static boolean authenticateDefault(HttpMethod httpMethod, HttpConnection httpConnection, HttpState httpState) throws AuthenticationException {
        LOG.trace("enter HttpAuthenticator.authenticateDefault(HttpMethod, HttpConnection, HttpState)");
        return doAuthenticateDefault(httpMethod, httpConnection, httpState, false);
    }

    public static boolean authenticateProxy(AuthScheme authScheme, HttpMethod httpMethod, HttpConnection httpConnection, HttpState httpState) throws AuthenticationException {
        LOG.trace("enter HttpAuthenticator.authenticateProxy(AuthScheme, HttpMethod, HttpState)");
        return doAuthenticate(authScheme, httpMethod, httpConnection, httpState, true);
    }

    public static boolean authenticateProxyDefault(HttpMethod httpMethod, HttpConnection httpConnection, HttpState httpState) throws AuthenticationException {
        LOG.trace("enter HttpAuthenticator.authenticateProxyDefault(HttpMethod, HttpState)");
        return doAuthenticateDefault(httpMethod, httpConnection, httpState, true);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static boolean doAuthenticate(AuthScheme authScheme, HttpMethod httpMethod, HttpConnection httpConnection, HttpState httpState, boolean z) throws AuthenticationException {
        String str;
        if (authScheme == null) {
            throw new IllegalArgumentException("Authentication scheme may not be null");
        } else if (httpMethod == null) {
            throw new IllegalArgumentException("HTTP method may not be null");
        } else if (httpState != null) {
            if (httpConnection == null) {
                str = null;
            } else if (z) {
                str = httpConnection.getProxyHost();
            } else {
                String virtualHost = httpMethod.getParams().getVirtualHost();
                str = virtualHost == null ? httpConnection.getHost() : virtualHost;
            }
            String realm = authScheme.getRealm();
            Log log = LOG;
            if (log.isDebugEnabled()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Using credentials for ");
                if (realm == null) {
                    stringBuffer.append(CookiePolicy.DEFAULT);
                } else {
                    stringBuffer.append('\'');
                    stringBuffer.append(realm);
                    stringBuffer.append('\'');
                }
                stringBuffer.append(" authentication realm at ");
                stringBuffer.append(str);
                log.debug(stringBuffer.toString());
            }
            Credentials proxyCredentials = z ? httpState.getProxyCredentials(realm, str) : httpState.getCredentials(realm, str);
            if (proxyCredentials == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("No credentials available for the ");
                if (realm == null) {
                    stringBuffer2.append(CookiePolicy.DEFAULT);
                } else {
                    stringBuffer2.append('\'');
                    stringBuffer2.append(realm);
                    stringBuffer2.append('\'');
                }
                stringBuffer2.append(" authentication realm at ");
                stringBuffer2.append(str);
                throw new CredentialsNotAvailableException(stringBuffer2.toString());
            }
            String authenticate = authScheme.authenticate(proxyCredentials, httpMethod);
            if (authenticate == null) {
                return false;
            }
            httpMethod.addRequestHeader(new Header(z ? "Proxy-Authorization" : "Authorization", authenticate, true));
            return true;
        } else {
            throw new IllegalArgumentException("HTTP state may not be null");
        }
    }

    private static boolean doAuthenticateDefault(HttpMethod httpMethod, HttpConnection httpConnection, HttpState httpState, boolean z) throws AuthenticationException {
        if (httpMethod == null) {
            throw new IllegalArgumentException("HTTP method may not be null");
        } else if (httpState != null) {
            String proxyHost = httpConnection != null ? z ? httpConnection.getProxyHost() : httpConnection.getHost() : null;
            Credentials proxyCredentials = z ? httpState.getProxyCredentials((String) null, proxyHost) : httpState.getCredentials((String) null, proxyHost);
            if (proxyCredentials == null) {
                return false;
            }
            if (proxyCredentials instanceof UsernamePasswordCredentials) {
                String authenticate = BasicScheme.authenticate((UsernamePasswordCredentials) proxyCredentials, httpMethod.getParams().getCredentialCharset());
                if (authenticate == null) {
                    return false;
                }
                httpMethod.addRequestHeader(new Header(z ? "Proxy-Authorization" : "Authorization", authenticate, true));
                return true;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Credentials cannot be used for basic authentication: ");
            stringBuffer.append(proxyCredentials.toString());
            throw new InvalidCredentialsException(stringBuffer.toString());
        } else {
            throw new IllegalArgumentException("HTTP state may not be null");
        }
    }

    public static AuthScheme selectAuthScheme(Header[] headerArr) throws MalformedChallengeException {
        LOG.trace("enter HttpAuthenticator.selectAuthScheme(Header[])");
        if (headerArr == null) {
            throw new IllegalArgumentException("Array of challenges may not be null");
        } else if (headerArr.length != 0) {
            HashMap hashMap = new HashMap(headerArr.length);
            for (Header value : headerArr) {
                String value2 = value.getValue();
                hashMap.put(AuthChallengeParser.extractScheme(value2), value2);
            }
            String str = (String) hashMap.get("ntlm");
            if (str != null) {
                return new NTLMScheme(str);
            }
            String str2 = (String) hashMap.get("digest");
            if (str2 != null) {
                return new DigestScheme(str2);
            }
            String str3 = (String) hashMap.get(AuthState.PREEMPTIVE_AUTH_SCHEME);
            if (str3 != null) {
                return new BasicScheme(str3);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Authentication scheme(s) not supported: ");
            stringBuffer.append(hashMap.toString());
            throw new UnsupportedOperationException(stringBuffer.toString());
        } else {
            throw new IllegalArgumentException("Array of challenges may not be empty");
        }
    }
}
