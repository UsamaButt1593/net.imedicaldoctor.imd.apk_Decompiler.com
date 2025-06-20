package org.apache.commons.httpclient.auth;

public abstract class AuthSchemeBase implements AuthScheme {
    private String challenge = null;

    public AuthSchemeBase(String str) throws MalformedChallengeException {
        if (str != null) {
            this.challenge = str;
            return;
        }
        throw new IllegalArgumentException("Challenge may not be null");
    }

    public boolean equals(Object obj) {
        return obj instanceof AuthSchemeBase ? this.challenge.equals(((AuthSchemeBase) obj).challenge) : super.equals(obj);
    }

    public int hashCode() {
        return this.challenge.hashCode();
    }

    public String toString() {
        return this.challenge;
    }
}
