package org.apache.commons.httpclient.methods;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.HeaderElement;
import org.apache.commons.httpclient.NameValuePair;

public class StringRequestEntity implements RequestEntity {
    private String charset;
    private byte[] content;
    private String contentType;

    public StringRequestEntity(String str) {
        if (str != null) {
            this.contentType = null;
            this.charset = null;
            this.content = str.getBytes();
            return;
        }
        throw new IllegalArgumentException("The content cannot be null");
    }

    public String getCharset() {
        return this.charset;
    }

    public String getContent() {
        String str = this.charset;
        if (str == null) {
            return new String(this.content);
        }
        try {
            return new String(this.content, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(this.content);
        }
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public String getContentType() {
        return this.contentType;
    }

    public boolean isRepeatable() {
        return true;
    }

    public void writeRequest(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.write(this.content);
            outputStream.flush();
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }

    public StringRequestEntity(String str, String str2, String str3) throws UnsupportedEncodingException {
        if (str != null) {
            this.contentType = str2;
            this.charset = str3;
            if (str2 != null) {
                HeaderElement[] parseElements = HeaderElement.parseElements(str2);
                NameValuePair nameValuePair = null;
                int i2 = 0;
                while (i2 < parseElements.length && (nameValuePair = parseElements[i2].getParameterByName("charset")) == null) {
                    i2++;
                }
                if (str3 == null && nameValuePair != null) {
                    this.charset = nameValuePair.getValue();
                } else if (str3 != null && nameValuePair == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(str2);
                    stringBuffer.append("; charset=");
                    stringBuffer.append(str3);
                    this.contentType = stringBuffer.toString();
                }
            }
            String str4 = this.charset;
            if (str4 != null) {
                this.content = str.getBytes(str4);
            } else {
                this.content = str.getBytes();
            }
        } else {
            throw new IllegalArgumentException("The content cannot be null");
        }
    }
}
