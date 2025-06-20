package org.apache.commons.httpclient.methods.multipart;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MultipartRequestEntity implements RequestEntity {
    private static byte[] MULTIPART_CHARS = EncodingUtil.getAsciiBytes("-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    private static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$multipart$MultipartRequestEntity;
    private static final Log log;
    private byte[] multipartBoundary;
    private HttpMethodParams params;
    protected Part[] parts;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$multipart$MultipartRequestEntity;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity");
            class$org$apache$commons$httpclient$methods$multipart$MultipartRequestEntity = cls;
        }
        log = LogFactory.getLog(cls);
    }

    public MultipartRequestEntity(Part[] partArr, HttpMethodParams httpMethodParams) {
        if (partArr == null) {
            throw new IllegalArgumentException("parts cannot be null");
        } else if (httpMethodParams != null) {
            this.parts = partArr;
            this.params = httpMethodParams;
        } else {
            throw new IllegalArgumentException("params cannot be null");
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    private static byte[] generateMultipartBoundary() {
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        byte[] bArr = new byte[nextInt];
        for (int i2 = 0; i2 < nextInt; i2++) {
            byte[] bArr2 = MULTIPART_CHARS;
            bArr[i2] = bArr2[random.nextInt(bArr2.length)];
        }
        return bArr;
    }

    public long getContentLength() {
        try {
            return Part.getLengthOfParts(this.parts, getMultipartBoundary());
        } catch (Exception e2) {
            log.error("An exception occurred while getting the length of the parts", e2);
            return 0;
        }
    }

    public String getContentType() {
        StringBuffer stringBuffer = new StringBuffer("multipart/form-data");
        stringBuffer.append("; boundary=");
        stringBuffer.append(EncodingUtil.getAsciiString(getMultipartBoundary()));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public byte[] getMultipartBoundary() {
        if (this.multipartBoundary == null) {
            String str = (String) this.params.getParameter(HttpMethodParams.MULTIPART_BOUNDARY);
            if (str != null) {
                this.multipartBoundary = EncodingUtil.getAsciiBytes(str);
            } else {
                this.multipartBoundary = generateMultipartBoundary();
            }
        }
        return this.multipartBoundary;
    }

    public boolean isRepeatable() {
        int i2 = 0;
        while (true) {
            Part[] partArr = this.parts;
            if (i2 >= partArr.length) {
                return true;
            }
            if (!partArr[i2].isRepeatable()) {
                return false;
            }
            i2++;
        }
    }

    public void writeRequest(OutputStream outputStream) throws IOException {
        Part.sendParts(outputStream, this.parts, getMultipartBoundary());
    }
}
