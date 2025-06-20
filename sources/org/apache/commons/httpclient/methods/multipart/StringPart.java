package org.apache.commons.httpclient.methods.multipart;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringPart extends PartBase {
    public static final String DEFAULT_CHARSET = "US-ASCII";
    public static final String DEFAULT_CONTENT_TYPE = "text/plain";
    public static final String DEFAULT_TRANSFER_ENCODING = "8bit";
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$multipart$StringPart;
    private byte[] content;
    private String value;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$multipart$StringPart;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.multipart.StringPart");
            class$org$apache$commons$httpclient$methods$multipart$StringPart = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public StringPart(String str, String str2) {
        this(str, str2, (String) null);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private byte[] getContent() {
        if (this.content == null) {
            this.content = EncodingUtil.getBytes(this.value, getCharSet());
        }
        return this.content;
    }

    /* access modifiers changed from: protected */
    public long lengthOfData() throws IOException {
        LOG.trace("enter lengthOfData()");
        return (long) getContent().length;
    }

    /* access modifiers changed from: protected */
    public void sendData(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendData(OutputStream)");
        outputStream.write(getContent());
    }

    public void setCharSet(String str) {
        super.setCharSet(str);
        this.content = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringPart(String str, String str2, String str3) {
        super(str, "text/plain", str3 == null ? "US-ASCII" : str3, DEFAULT_TRANSFER_ENCODING);
        if (str2 == null) {
            throw new IllegalArgumentException("Value may not be null");
        } else if (str2.indexOf(0) == -1) {
            this.value = str2;
        } else {
            throw new IllegalArgumentException("NULs may not be present in string parts");
        }
    }
}
