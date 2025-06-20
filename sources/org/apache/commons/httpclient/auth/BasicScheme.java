package org.apache.commons.httpclient.auth;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BasicScheme extends RFC2617Scheme {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$BasicScheme;
    private boolean complete = false;

    static {
        Class cls = class$org$apache$commons$httpclient$auth$BasicScheme;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.auth.BasicScheme");
            class$org$apache$commons$httpclient$auth$BasicScheme = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public BasicScheme() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public String authenticate(Credentials credentials, String str, String str2) throws AuthenticationException {
        LOG.trace("enter BasicScheme.authenticate(Credentials, String, String)");
        try {
            return authenticate((UsernamePasswordCredentials) credentials);
        } catch (ClassCastException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Credentials cannot be used for basic authentication: ");
            stringBuffer.append(credentials.getClass().getName());
            throw new InvalidCredentialsException(stringBuffer.toString());
        }
    }

    public String getSchemeName() {
        return AuthState.PREEMPTIVE_AUTH_SCHEME;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public boolean isConnectionBased() {
        return false;
    }

    public void processChallenge(String str) throws MalformedChallengeException {
        super.processChallenge(str);
        this.complete = true;
    }

    public BasicScheme(String str) throws MalformedChallengeException {
        super(str);
    }

    public String authenticate(Credentials credentials, HttpMethod httpMethod) throws AuthenticationException {
        LOG.trace("enter BasicScheme.authenticate(Credentials, HttpMethod)");
        if (httpMethod != null) {
            try {
                return authenticate((UsernamePasswordCredentials) credentials, httpMethod.getParams().getCredentialCharset());
            } catch (ClassCastException unused) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Credentials cannot be used for basic authentication: ");
                stringBuffer.append(credentials.getClass().getName());
                throw new InvalidCredentialsException(stringBuffer.toString());
            }
        } else {
            throw new IllegalArgumentException("Method may not be null");
        }
    }

    public static String authenticate(UsernamePasswordCredentials usernamePasswordCredentials) {
        return authenticate(usernamePasswordCredentials, "ISO-8859-1");
    }

    public static String authenticate(UsernamePasswordCredentials usernamePasswordCredentials, String str) {
        LOG.trace("enter BasicScheme.authenticate(UsernamePasswordCredentials, String)");
        if (usernamePasswordCredentials == null) {
            throw new IllegalArgumentException("Credentials may not be null");
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("charset may not be null or empty");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(usernamePasswordCredentials.getUserName());
            stringBuffer.append(":");
            stringBuffer.append(usernamePasswordCredentials.getPassword());
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Basic ");
            stringBuffer2.append(EncodingUtil.getAsciiString(Base64.encodeBase64(EncodingUtil.getBytes(stringBuffer.toString(), str))));
            return stringBuffer2.toString();
        }
    }
}
