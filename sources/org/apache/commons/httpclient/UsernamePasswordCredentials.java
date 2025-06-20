package org.apache.commons.httpclient;

import org.apache.commons.httpclient.util.LangUtils;

public class UsernamePasswordCredentials implements Credentials {
    private String password;
    private String userName;

    public UsernamePasswordCredentials() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass().equals(obj.getClass())) {
            UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials) obj;
            return LangUtils.equals(this.userName, usernamePasswordCredentials.userName) && LangUtils.equals(this.password, usernamePasswordCredentials.password);
        }
    }

    public String getPassword() {
        return this.password;
    }

    public String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.userName), (Object) this.password);
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setUserName(String str) {
        if (str != null) {
            this.userName = str;
            return;
        }
        throw new IllegalArgumentException("Username may not be null");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.userName);
        stringBuffer.append(":");
        String str = this.password;
        if (str == null) {
            str = "null";
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public UsernamePasswordCredentials(String str) {
        if (str != null) {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                this.userName = str.substring(0, indexOf);
                this.password = str.substring(indexOf + 1);
                return;
            }
            this.userName = str;
            return;
        }
        throw new IllegalArgumentException("Username:password string may not be null");
    }

    public UsernamePasswordCredentials(String str, String str2) {
        if (str != null) {
            this.userName = str;
            this.password = str2;
            return;
        }
        throw new IllegalArgumentException("Username may not be null");
    }
}
