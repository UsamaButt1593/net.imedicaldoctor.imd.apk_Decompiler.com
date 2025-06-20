package org.apache.commons.httpclient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

class Wire {
    public static Wire CONTENT_WIRE = new Wire(LogFactory.getLog("httpclient.wire.content"));
    public static Wire HEADER_WIRE = new Wire(LogFactory.getLog("httpclient.wire.header"));
    private Log log;

    private Wire(Log log2) {
        this.log = log2;
    }

    private void wire(String str, InputStream inputStream) throws IOException {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                break;
            }
            if (read == 13) {
                str2 = "[\\r]";
            } else if (read == 10) {
                stringBuffer.append("[\\n]\"");
                stringBuffer.insert(0, "\"");
                stringBuffer.insert(0, str);
                this.log.debug(stringBuffer.toString());
                stringBuffer.setLength(0);
            } else if (read < 32 || read > 127) {
                stringBuffer.append("[0x");
                stringBuffer.append(Integer.toHexString(read));
                str2 = "]";
            } else {
                stringBuffer.append((char) read);
            }
            stringBuffer.append(str2);
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.append("\"");
            stringBuffer.insert(0, "\"");
            stringBuffer.insert(0, str);
            this.log.debug(stringBuffer.toString());
        }
    }

    public boolean enabled() {
        return this.log.isDebugEnabled();
    }

    public void input(int i2) throws IOException {
        input(new byte[]{(byte) i2});
    }

    public void output(int i2) throws IOException {
        output(new byte[]{(byte) i2});
    }

    public void input(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            wire("<< ", inputStream);
            return;
        }
        throw new IllegalArgumentException("Input may not be null");
    }

    public void output(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            wire(">> ", inputStream);
            return;
        }
        throw new IllegalArgumentException("Output may not be null");
    }

    public void input(String str) throws IOException {
        if (str != null) {
            input(str.getBytes());
            return;
        }
        throw new IllegalArgumentException("Input may not be null");
    }

    public void output(String str) throws IOException {
        if (str != null) {
            output(str.getBytes());
            return;
        }
        throw new IllegalArgumentException("Output may not be null");
    }

    public void input(byte[] bArr) throws IOException {
        if (bArr != null) {
            wire("<< ", new ByteArrayInputStream(bArr));
            return;
        }
        throw new IllegalArgumentException("Input may not be null");
    }

    public void output(byte[] bArr) throws IOException {
        if (bArr != null) {
            wire(">> ", new ByteArrayInputStream(bArr));
            return;
        }
        throw new IllegalArgumentException("Output may not be null");
    }

    public void input(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr != null) {
            wire("<< ", new ByteArrayInputStream(bArr, i2, i3));
            return;
        }
        throw new IllegalArgumentException("Input may not be null");
    }

    public void output(byte[] bArr, int i2, int i3) throws IOException {
        if (bArr != null) {
            wire(">> ", new ByteArrayInputStream(bArr, i2, i3));
            return;
        }
        throw new IllegalArgumentException("Output may not be null");
    }
}
