package org.apache.commons.httpclient.methods.multipart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FilePart extends PartBase {
    public static final String DEFAULT_CHARSET = "ISO-8859-1";
    public static final String DEFAULT_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TRANSFER_ENCODING = "binary";
    protected static final String FILE_NAME = "; filename=";
    private static final byte[] FILE_NAME_BYTES = EncodingUtil.getAsciiBytes(FILE_NAME);
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$multipart$FilePart;
    private PartSource source;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$multipart$FilePart;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.multipart.FilePart");
            class$org$apache$commons$httpclient$methods$multipart$FilePart = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public FilePart(String str, File file) throws FileNotFoundException {
        this(str, (PartSource) new FilePartSource(file), (String) null, (String) null);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public PartSource getSource() {
        LOG.trace("enter getSource()");
        return this.source;
    }

    /* access modifiers changed from: protected */
    public long lengthOfData() throws IOException {
        LOG.trace("enter lengthOfData()");
        return this.source.getLength();
    }

    /* access modifiers changed from: protected */
    public void sendData(OutputStream outputStream) throws IOException {
        Log log = LOG;
        log.trace("enter sendData(OutputStream out)");
        if (lengthOfData() == 0) {
            log.debug("No data to send.");
            return;
        }
        byte[] bArr = new byte[4096];
        InputStream createInputStream = this.source.createInputStream();
        while (true) {
            try {
                int read = createInputStream.read(bArr);
                if (read >= 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            } finally {
                createInputStream.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void sendDispositionHeader(OutputStream outputStream) throws IOException {
        LOG.trace("enter sendDispositionHeader(OutputStream out)");
        super.sendDispositionHeader(outputStream);
        String fileName = this.source.getFileName();
        if (fileName != null) {
            outputStream.write(FILE_NAME_BYTES);
            byte[] bArr = Part.QUOTE_BYTES;
            outputStream.write(bArr);
            outputStream.write(EncodingUtil.getAsciiBytes(fileName));
            outputStream.write(bArr);
        }
    }

    public FilePart(String str, File file, String str2, String str3) throws FileNotFoundException {
        this(str, (PartSource) new FilePartSource(file), str2, str3);
    }

    public FilePart(String str, String str2, File file) throws FileNotFoundException {
        this(str, (PartSource) new FilePartSource(str2, file), (String) null, (String) null);
    }

    public FilePart(String str, String str2, File file, String str3, String str4) throws FileNotFoundException {
        this(str, (PartSource) new FilePartSource(str2, file), str3, str4);
    }

    public FilePart(String str, PartSource partSource) {
        this(str, partSource, (String) null, (String) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilePart(String str, PartSource partSource, String str2, String str3) {
        super(str, str2 == null ? DEFAULT_CONTENT_TYPE : str2, str3 == null ? "ISO-8859-1" : str3, DEFAULT_TRANSFER_ENCODING);
        if (partSource != null) {
            this.source = partSource;
            return;
        }
        throw new IllegalArgumentException("Source may not be null");
    }
}
