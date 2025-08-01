package org.apache.commons.httpclient.methods.multipart;

public abstract class PartBase extends Part {
    private String charSet;
    private String contentType;
    private String name;
    private String transferEncoding;

    public PartBase(String str, String str2, String str3, String str4) {
        if (str != null) {
            this.name = str;
            this.contentType = str2;
            this.charSet = str3;
            this.transferEncoding = str4;
            return;
        }
        throw new IllegalArgumentException("Name must not be null");
    }

    public String getCharSet() {
        return this.charSet;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getName() {
        return this.name;
    }

    public String getTransferEncoding() {
        return this.transferEncoding;
    }

    public void setCharSet(String str) {
        this.charSet = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setName(String str) {
        if (str != null) {
            this.name = str;
            return;
        }
        throw new IllegalArgumentException("Name must not be null");
    }

    public void setTransferEncoding(String str) {
        this.transferEncoding = str;
    }
}
