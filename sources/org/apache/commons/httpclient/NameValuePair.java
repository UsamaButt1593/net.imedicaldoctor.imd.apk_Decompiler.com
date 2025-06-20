package org.apache.commons.httpclient;

import java.io.Serializable;
import org.apache.commons.httpclient.util.LangUtils;

public class NameValuePair implements Serializable {
    private String name;
    private String value;

    public NameValuePair() {
        this((String) null, (String) null);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NameValuePair)) {
            return false;
        }
        NameValuePair nameValuePair = (NameValuePair) obj;
        return LangUtils.equals(this.name, nameValuePair.name) && LangUtils.equals(this.value, nameValuePair.value);
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.name), (Object) this.value);
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name=");
        stringBuffer.append(this.name);
        stringBuffer.append(", ");
        stringBuffer.append("value=");
        stringBuffer.append(this.value);
        return stringBuffer.toString();
    }

    public NameValuePair(String str, String str2) {
        this.name = str;
        this.value = str2;
    }
}
