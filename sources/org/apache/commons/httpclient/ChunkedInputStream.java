package org.apache.commons.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ExceptionUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChunkedInputStream extends InputStream {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$ChunkedInputStream;
    private boolean bof;
    private int chunkSize;
    private boolean closed;
    private boolean eof;
    private InputStream in;
    private HttpMethod method;
    private int pos;

    static {
        Class cls = class$org$apache$commons$httpclient$ChunkedInputStream;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.ChunkedInputStream");
            class$org$apache$commons$httpclient$ChunkedInputStream = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public ChunkedInputStream(InputStream inputStream) throws IOException {
        this(inputStream, (HttpMethod) null);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    static void exhaustInputStream(InputStream inputStream) throws IOException {
        do {
        } while (inputStream.read(new byte[1024]) >= 0);
    }

    private static int getChunkSizeFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        char c2 = 0;
        while (c2 != 65535) {
            int read = inputStream.read();
            if (read != -1) {
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            throw new RuntimeException("assertion failed");
                        } else if (read == 34) {
                            c2 = 0;
                        } else if (read == 92) {
                            byteArrayOutputStream.write(inputStream.read());
                        }
                    } else if (read == 10) {
                        c2 = 65535;
                    } else {
                        throw new IOException("Protocol violation: Unexpected single newline character in chunk size");
                    }
                } else if (read == 13) {
                    c2 = 1;
                } else if (read == 34) {
                    c2 = 2;
                }
                byteArrayOutputStream.write(read);
            } else {
                throw new IOException("chunked stream ended unexpectedly");
            }
        }
        String asciiString = EncodingUtil.getAsciiString(byteArrayOutputStream.toByteArray());
        int indexOf = asciiString.indexOf(59);
        if (indexOf > 0) {
            asciiString = asciiString.substring(0, indexOf);
        }
        String trim = asciiString.trim();
        try {
            return Integer.parseInt(trim.trim(), 16);
        } catch (NumberFormatException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Bad chunk size: ");
            stringBuffer.append(trim);
            throw new IOException(stringBuffer.toString());
        }
    }

    private void nextChunk() throws IOException {
        if (!this.bof) {
            readCRLF();
        }
        int chunkSizeFromInputStream = getChunkSizeFromInputStream(this.in);
        this.chunkSize = chunkSizeFromInputStream;
        this.bof = false;
        this.pos = 0;
        if (chunkSizeFromInputStream == 0) {
            this.eof = true;
            parseTrailerHeaders();
        }
    }

    private void parseTrailerHeaders() throws IOException {
        String str = "US-ASCII";
        try {
            HttpMethod httpMethod = this.method;
            if (httpMethod != null) {
                str = httpMethod.getParams().getHttpElementCharset();
            }
            Header[] parseHeaders = HttpParser.parseHeaders(this.in, str);
            if (this.method != null) {
                for (Header addResponseFooter : parseHeaders) {
                    this.method.addResponseFooter(addResponseFooter);
                }
            }
        } catch (HttpException e2) {
            LOG.error("Error parsing trailer headers", e2);
            IOException iOException = new IOException(e2.getMessage());
            ExceptionUtil.initCause(iOException, e2);
            throw iOException;
        }
    }

    private void readCRLF() throws IOException {
        int read = this.in.read();
        int read2 = this.in.read();
        if (read != 13 || read2 != 10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CRLF expected at end of chunk: ");
            stringBuffer.append(read);
            stringBuffer.append("/");
            stringBuffer.append(read2);
            throw new IOException(stringBuffer.toString());
        }
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (!this.eof) {
                    exhaustInputStream(this);
                }
            } finally {
                this.eof = true;
                this.closed = true;
            }
        }
    }

    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.eof) {
            return -1;
        } else {
            if (this.pos >= this.chunkSize) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            this.pos++;
            return this.in.read();
        }
    }

    public ChunkedInputStream(InputStream inputStream, HttpMethod httpMethod) throws IOException {
        this.bof = true;
        this.eof = false;
        this.closed = false;
        this.method = null;
        if (inputStream != null) {
            this.in = inputStream;
            this.method = httpMethod;
            this.pos = 0;
            return;
        }
        throw new IllegalArgumentException("InputStream parameter may not be null");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.eof) {
            return -1;
        } else {
            if (this.pos >= this.chunkSize) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.in.read(bArr, i2, Math.min(i3, this.chunkSize - this.pos));
            this.pos += read;
            return read;
        }
    }
}
