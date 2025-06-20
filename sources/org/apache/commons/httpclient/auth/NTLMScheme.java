package org.apache.commons.httpclient.auth;

import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NTCredentials;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class NTLMScheme implements AuthScheme {
    private static final int FAILED = Integer.MAX_VALUE;
    private static final int INITIATED = 1;
    private static final Log LOG;
    private static final int TYPE1_MSG_GENERATED = 2;
    private static final int TYPE2_MSG_RECEIVED = 3;
    private static final int TYPE3_MSG_GENERATED = 4;
    private static final int UNINITIATED = 0;
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$NTLMScheme;
    private String ntlmchallenge;
    private int state;

    static {
        Class cls = class$org$apache$commons$httpclient$auth$NTLMScheme;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.auth.NTLMScheme");
            class$org$apache$commons$httpclient$auth$NTLMScheme = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public NTLMScheme() {
        this.ntlmchallenge = null;
        this.state = 0;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public String authenticate(Credentials credentials, String str, String str2) throws AuthenticationException {
        LOG.trace("enter NTLMScheme.authenticate(Credentials, String, String)");
        try {
            return authenticate((NTCredentials) credentials, this.ntlmchallenge);
        } catch (ClassCastException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Credentials cannot be used for NTLM authentication: ");
            stringBuffer.append(credentials.getClass().getName());
            throw new InvalidCredentialsException(stringBuffer.toString());
        }
    }

    public String getID() {
        return this.ntlmchallenge;
    }

    public String getParameter(String str) {
        if (str != null) {
            return null;
        }
        throw new IllegalArgumentException("Parameter name may not be null");
    }

    public String getRealm() {
        return null;
    }

    public String getSchemeName() {
        return "ntlm";
    }

    public boolean isComplete() {
        int i2 = this.state;
        return i2 == 4 || i2 == Integer.MAX_VALUE;
    }

    public boolean isConnectionBased() {
        return true;
    }

    public void processChallenge(String str) throws MalformedChallengeException {
        int i2;
        if (AuthChallengeParser.extractScheme(str).equalsIgnoreCase(getSchemeName())) {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                this.ntlmchallenge = str.substring(indexOf, str.length()).trim();
                i2 = 3;
            } else {
                this.ntlmchallenge = "";
                i2 = this.state == 0 ? 1 : Integer.MAX_VALUE;
            }
            this.state = i2;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid NTLM challenge: ");
        stringBuffer.append(str);
        throw new MalformedChallengeException(stringBuffer.toString());
    }

    public NTLMScheme(String str) throws MalformedChallengeException {
        this.ntlmchallenge = null;
        processChallenge(str);
    }

    public String authenticate(Credentials credentials, HttpMethod httpMethod) throws AuthenticationException {
        String type1Message;
        int i2;
        LOG.trace("enter NTLMScheme.authenticate(Credentials, HttpMethod)");
        if (this.state != 0) {
            try {
                NTCredentials nTCredentials = (NTCredentials) credentials;
                NTLM ntlm = new NTLM();
                ntlm.setCredentialCharset(httpMethod.getParams().getCredentialCharset());
                int i3 = this.state;
                if (i3 == 1 || i3 == Integer.MAX_VALUE) {
                    type1Message = ntlm.getType1Message(nTCredentials.getHost(), nTCredentials.getDomain());
                    i2 = 2;
                } else {
                    type1Message = ntlm.getType3Message(nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getHost(), nTCredentials.getDomain(), ntlm.parseType2Message(this.ntlmchallenge));
                    i2 = 4;
                }
                this.state = i2;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("NTLM ");
                stringBuffer.append(type1Message);
                return stringBuffer.toString();
            } catch (ClassCastException unused) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Credentials cannot be used for NTLM authentication: ");
                stringBuffer2.append(credentials.getClass().getName());
                throw new InvalidCredentialsException(stringBuffer2.toString());
            }
        } else {
            throw new IllegalStateException("NTLM authentication process has not been initiated");
        }
    }

    public static String authenticate(NTCredentials nTCredentials, String str) throws AuthenticationException {
        LOG.trace("enter NTLMScheme.authenticate(NTCredentials, String)");
        if (nTCredentials != null) {
            String responseFor = new NTLM().getResponseFor(str, nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getHost(), nTCredentials.getDomain());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("NTLM ");
            stringBuffer.append(responseFor);
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("Credentials may not be null");
    }

    public static String authenticate(NTCredentials nTCredentials, String str, String str2) throws AuthenticationException {
        LOG.trace("enter NTLMScheme.authenticate(NTCredentials, String)");
        if (nTCredentials != null) {
            NTLM ntlm = new NTLM();
            ntlm.setCredentialCharset(str2);
            String responseFor = ntlm.getResponseFor(str, nTCredentials.getUserName(), nTCredentials.getPassword(), nTCredentials.getHost(), nTCredentials.getDomain());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("NTLM ");
            stringBuffer.append(responseFor);
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("Credentials may not be null");
    }
}
