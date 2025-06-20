package org.apache.commons.httpclient;

import com.itextpdf.text.pdf.ByteBuffer;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.httpclient.util.EncodingUtil;

public class ChunkedOutputStream extends OutputStream {
    private static final byte[] CRLF;
    private static final byte[] ENDCHUNK;
    private static final byte[] ZERO = {ByteBuffer.X2};
    private byte[] cache;
    private int cachePosition;
    private OutputStream stream;
    private boolean wroteLastChunk;

    static {
        byte[] bArr = {13, 10};
        CRLF = bArr;
        ENDCHUNK = bArr;
    }

    public ChunkedOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 2048);
    }

    public void close() throws IOException {
        finish();
        super.close();
    }

    public void finish() throws IOException {
        if (!this.wroteLastChunk) {
            flushCache();
            writeClosingChunk();
            this.wroteLastChunk = true;
        }
    }

    public void flush() throws IOException {
        this.stream.flush();
    }

    /* access modifiers changed from: protected */
    public void flushCache() throws IOException {
        if (this.cachePosition > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(Integer.toHexString(this.cachePosition));
            stringBuffer.append("\r\n");
            byte[] asciiBytes = EncodingUtil.getAsciiBytes(stringBuffer.toString());
            this.stream.write(asciiBytes, 0, asciiBytes.length);
            this.stream.write(this.cache, 0, this.cachePosition);
            OutputStream outputStream = this.stream;
            byte[] bArr = ENDCHUNK;
            outputStream.write(bArr, 0, bArr.length);
            this.cachePosition = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void flushCacheWithAppend(byte[] bArr, int i2, int i3) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Integer.toHexString(this.cachePosition + i3));
        stringBuffer.append("\r\n");
        byte[] asciiBytes = EncodingUtil.getAsciiBytes(stringBuffer.toString());
        this.stream.write(asciiBytes, 0, asciiBytes.length);
        this.stream.write(this.cache, 0, this.cachePosition);
        this.stream.write(bArr, i2, i3);
        OutputStream outputStream = this.stream;
        byte[] bArr2 = ENDCHUNK;
        outputStream.write(bArr2, 0, bArr2.length);
        this.cachePosition = 0;
    }

    public void write(int i2) throws IOException {
        byte[] bArr = this.cache;
        int i3 = this.cachePosition;
        bArr[i3] = (byte) i2;
        int i4 = i3 + 1;
        this.cachePosition = i4;
        if (i4 == bArr.length) {
            flushCache();
        }
    }

    /* access modifiers changed from: protected */
    public void writeClosingChunk() throws IOException {
        OutputStream outputStream = this.stream;
        byte[] bArr = ZERO;
        outputStream.write(bArr, 0, bArr.length);
        OutputStream outputStream2 = this.stream;
        byte[] bArr2 = CRLF;
        outputStream2.write(bArr2, 0, bArr2.length);
        OutputStream outputStream3 = this.stream;
        byte[] bArr3 = ENDCHUNK;
        outputStream3.write(bArr3, 0, bArr3.length);
    }

    public ChunkedOutputStream(OutputStream outputStream, int i2) throws IOException {
        this.stream = null;
        this.cachePosition = 0;
        this.wroteLastChunk = false;
        this.cache = new byte[i2];
        this.stream = outputStream;
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        byte[] bArr2 = this.cache;
        int length = bArr2.length;
        int i4 = this.cachePosition;
        if (i3 >= length - i4) {
            flushCacheWithAppend(bArr, i2, i3);
            return;
        }
        System.arraycopy(bArr, i2, bArr2, i4, i3);
        this.cachePosition += i3;
    }
}
