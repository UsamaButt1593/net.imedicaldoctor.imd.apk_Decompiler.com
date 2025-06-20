package org.apache.commons.httpclient.methods.multipart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class Part {
    protected static final String BOUNDARY = "----------------314159265358979323846";
    protected static final byte[] BOUNDARY_BYTES;
    protected static final String CHARSET = "; charset=";
    protected static final byte[] CHARSET_BYTES = EncodingUtil.getAsciiBytes(CHARSET);
    protected static final String CONTENT_DISPOSITION = "Content-Disposition: form-data; name=";
    protected static final byte[] CONTENT_DISPOSITION_BYTES = EncodingUtil.getAsciiBytes(CONTENT_DISPOSITION);
    protected static final String CONTENT_TRANSFER_ENCODING = "Content-Transfer-Encoding: ";
    protected static final byte[] CONTENT_TRANSFER_ENCODING_BYTES = EncodingUtil.getAsciiBytes(CONTENT_TRANSFER_ENCODING);
    protected static final String CONTENT_TYPE = "Content-Type: ";
    protected static final byte[] CONTENT_TYPE_BYTES = EncodingUtil.getAsciiBytes(CONTENT_TYPE);
    protected static final String CRLF = "\r\n";
    protected static final byte[] CRLF_BYTES = EncodingUtil.getAsciiBytes(CRLF);
    private static final byte[] DEFAULT_BOUNDARY_BYTES;
    protected static final String EXTRA = "--";
    protected static final byte[] EXTRA_BYTES = EncodingUtil.getAsciiBytes(EXTRA);
    private static final Log LOG;
    protected static final String QUOTE = "\"";
    protected static final byte[] QUOTE_BYTES = EncodingUtil.getAsciiBytes(QUOTE);
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$multipart$Part;
    private byte[] boundaryBytes;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$multipart$Part;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.multipart.Part");
            class$org$apache$commons$httpclient$methods$multipart$Part = cls;
        }
        LOG = LogFactory.getLog(cls);
        byte[] asciiBytes = EncodingUtil.getAsciiBytes(BOUNDARY);
        BOUNDARY_BYTES = asciiBytes;
        DEFAULT_BOUNDARY_BYTES = asciiBytes;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static String getBoundary() {
        return BOUNDARY;
    }

    public static long getLengthOfParts(Part[] partArr) throws IOException {
        return getLengthOfParts(partArr, DEFAULT_BOUNDARY_BYTES);
    }

    public static void sendParts(OutputStream outputStream, Part[] partArr) throws IOException {
        sendParts(outputStream, partArr, DEFAULT_BOUNDARY_BYTES);
    }

    public abstract String getCharSet();

    public abstract String getContentType();

    public abstract String getName();

    /* access modifiers changed from: protected */
    public byte[] getPartBoundary() {
        byte[] bArr = this.boundaryBytes;
        return bArr == null ? DEFAULT_BOUNDARY_BYTES : bArr;
    }

    public abstract String getTransferEncoding();

    public boolean isRepeatable() {
        return true;
    }

    public long length() throws IOException {
        LOG.trace("enter length()");
        if (lengthOfData() < 0) {
            return -1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sendStart(byteArrayOutputStream);
        sendDispositionHeader(byteArrayOutputStream);
        sendContentTypeHeader(byteArrayOutputStream);
        sendTransferEncodingHeader(byteArrayOutputStream);
        sendEndOfHeader(byteArrayOutputStream);
        sendEnd(byteArrayOutputStream);
        return ((long) byteArrayOutputStream.size()) + lengthOfData();
    }

    /* access modifiers changed from: protected */
    public abstract long lengthOfData() throws IOException;

    public void send(OutputStream outputStream) throws IOException {
        LOG.trace("enter send(OutputStream out)");
        sendStart(outputStream);
        sendDispositionHeader(outputStream);
        sendContentTypeHeader(outputStream);
        sendTransferEncodingHeader(outputStream);
        sendEndOfHeader(outputStream);
        sendData(outputStream);
        sendEnd(outputStream);
    }

    /* access modifiers changed from: protected */
    public void sendContentTypeHeader(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendContentTypeHeader(OutputStream out)");
        String contentType = getContentType();
        if (contentType != null) {
            outputStream.write(CRLF_BYTES);
            outputStream.write(CONTENT_TYPE_BYTES);
            outputStream.write(EncodingUtil.getAsciiBytes(contentType));
            String charSet = getCharSet();
            if (charSet != null) {
                outputStream.write(CHARSET_BYTES);
                outputStream.write(EncodingUtil.getAsciiBytes(charSet));
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void sendData(OutputStream outputStream) throws IOException;

    /* access modifiers changed from: protected */
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendDispositionHeader(OutputStream out)");
        outputStream.write(CONTENT_DISPOSITION_BYTES);
        byte[] bArr = QUOTE_BYTES;
        outputStream.write(bArr);
        outputStream.write(EncodingUtil.getAsciiBytes(getName()));
        outputStream.write(bArr);
    }

    /* access modifiers changed from: protected */
    public void sendEnd(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendEnd(OutputStream out)");
        outputStream.write(CRLF_BYTES);
    }

    /* access modifiers changed from: protected */
    public void sendEndOfHeader(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendEndOfHeader(OutputStream out)");
        byte[] bArr = CRLF_BYTES;
        outputStream.write(bArr);
        outputStream.write(bArr);
    }

    /* access modifiers changed from: protected */
    public void sendStart(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendStart(OutputStream out)");
        outputStream.write(EXTRA_BYTES);
        outputStream.write(getPartBoundary());
        outputStream.write(CRLF_BYTES);
    }

    /* access modifiers changed from: protected */
    public void sendTransferEncodingHeader(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendTransferEncodingHeader(OutputStream out)");
        String transferEncoding = getTransferEncoding();
        if (transferEncoding != null) {
            outputStream.write(CRLF_BYTES);
            outputStream.write(CONTENT_TRANSFER_ENCODING_BYTES);
            outputStream.write(EncodingUtil.getAsciiBytes(transferEncoding));
        }
    }

    /* access modifiers changed from: package-private */
    public void setPartBoundary(byte[] bArr) {
        this.boundaryBytes = bArr;
    }

    public String toString() {
        return getName();
    }

    public static long getLengthOfParts(Part[] partArr, byte[] bArr) throws IOException {
        LOG.trace("getLengthOfParts(Parts[])");
        if (partArr != null) {
            long j2 = 0;
            for (int i2 = 0; i2 < partArr.length; i2++) {
                partArr[i2].setPartBoundary(bArr);
                long length = partArr[i2].length();
                if (length < 0) {
                    return -1;
                }
                j2 += length;
            }
            byte[] bArr2 = EXTRA_BYTES;
            return j2 + ((long) bArr2.length) + ((long) bArr.length) + ((long) bArr2.length) + ((long) CRLF_BYTES.length);
        }
        throw new IllegalArgumentException("Parts may not be null");
    }

    public static void sendParts(OutputStream outputStream, Part[] partArr, byte[] bArr) throws IOException {
        if (partArr == null) {
            throw new IllegalArgumentException("Parts may not be null");
        } else if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("partBoundary may not be empty");
        } else {
            for (int i2 = 0; i2 < partArr.length; i2++) {
                partArr[i2].setPartBoundary(bArr);
                partArr[i2].send(outputStream);
            }
            byte[] bArr2 = EXTRA_BYTES;
            outputStream.write(bArr2);
            outputStream.write(bArr);
            outputStream.write(bArr2);
            outputStream.write(CRLF_BYTES);
        }
    }
}
