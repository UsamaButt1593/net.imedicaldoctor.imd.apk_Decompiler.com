package org.apache.commons.httpclient.auth;

import java.util.Map;

public abstract class RFC2617Scheme implements AuthScheme {
    private Map params = null;

    public RFC2617Scheme() {
    }

    public String getID() {
        return getRealm();
    }

    public String getParameter(String str) {
        if (str != null) {
            Map map = this.params;
            if (map == null) {
                return null;
            }
            return (String) map.get(str.toLowerCase());
        }
        throw new IllegalArgumentException("Parameter name may not be null");
    }

    /* access modifiers changed from: protected */
    public Map getParameters() {
        return this.params;
    }

    public String getRealm() {
        return getParameter("realm");
    }

    public void processChallenge(String str) throws MalformedChallengeException {
        if (AuthChallengeParser.extractScheme(str).equalsIgnoreCase(getSchemeName())) {
            this.params = AuthChallengeParser.extractParams(str);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid ");
        stringBuffer.append(getSchemeName());
        stringBuffer.append(" challenge: ");
        stringBuffer.append(str);
        throw new MalformedChallengeException(stringBuffer.toString());
    }

    public RFC2617Scheme(String str) throws MalformedChallengeException {
        processChallenge(str);
    }
}
