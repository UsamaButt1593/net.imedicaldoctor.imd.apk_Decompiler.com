package org.apache.commons.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpParser {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$HttpParser;

    static {
        Class cls = class$org$apache$commons$httpclient$HttpParser;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.HttpParser");
            class$org$apache$commons$httpclient$HttpParser = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    private HttpParser() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static Header[] parseHeaders(InputStream inputStream) throws IOException, HttpException {
        LOG.trace("enter HeaderParser.parseHeaders(InputStream, String)");
        return parseHeaders(inputStream, "US-ASCII");
    }

    public static String readLine(InputStream inputStream) throws IOException {
        LOG.trace("enter HttpParser.readLine(InputStream)");
        return readLine(inputStream, "US-ASCII");
    }

    public static byte[] readRawLine(InputStream inputStream) throws IOException {
        int read;
        LOG.trace("enter HttpParser.readRawLine()");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        do {
            read = inputStream.read();
            if (read < 0) {
                break;
            }
            byteArrayOutputStream.write(read);
        } while (read != 10);
        if (byteArrayOutputStream.size() == 0) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.commons.httpclient.Header[] parseHeaders(java.io.InputStream r8, java.lang.String r9) throws java.io.IOException, org.apache.commons.httpclient.HttpException {
        /*
            org.apache.commons.logging.Log r0 = LOG
            java.lang.String r1 = "enter HeaderParser.parseHeaders(InputStream, String)"
            r0.trace(r1)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
        L_0x000e:
            java.lang.String r3 = readLine(r8, r9)
            if (r3 == 0) goto L_0x0086
            java.lang.String r4 = r3.trim()
            int r4 = r4.length()
            r5 = 1
            if (r4 >= r5) goto L_0x0020
            goto L_0x0086
        L_0x0020:
            r4 = 0
            char r5 = r3.charAt(r4)
            r6 = 32
            if (r5 == r6) goto L_0x0079
            char r5 = r3.charAt(r4)
            r7 = 9
            if (r5 != r7) goto L_0x0032
            goto L_0x0079
        L_0x0032:
            if (r1 == 0) goto L_0x0040
            org.apache.commons.httpclient.Header r5 = new org.apache.commons.httpclient.Header
            java.lang.String r2 = r2.toString()
            r5.<init>(r1, r2)
            r0.add(r5)
        L_0x0040:
            java.lang.String r1 = ":"
            int r1 = r3.indexOf(r1)
            if (r1 < 0) goto L_0x0062
            java.lang.String r2 = r3.substring(r4, r1)
            java.lang.String r2 = r2.trim()
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            int r1 = r1 + 1
            java.lang.String r1 = r3.substring(r1)
            java.lang.String r1 = r1.trim()
            r4.<init>(r1)
            r1 = r2
            r2 = r4
            goto L_0x000e
        L_0x0062:
            org.apache.commons.httpclient.ProtocolException r8 = new org.apache.commons.httpclient.ProtocolException
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            java.lang.String r0 = "Unable to parse header: "
            r9.append(r0)
            r9.append(r3)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x0079:
            if (r2 == 0) goto L_0x000e
            r2.append(r6)
            java.lang.String r3 = r3.trim()
            r2.append(r3)
            goto L_0x000e
        L_0x0086:
            if (r1 == 0) goto L_0x0094
            org.apache.commons.httpclient.Header r8 = new org.apache.commons.httpclient.Header
            java.lang.String r9 = r2.toString()
            r8.<init>(r1, r9)
            r0.add(r8)
        L_0x0094:
            int r8 = r0.size()
            org.apache.commons.httpclient.Header[] r8 = new org.apache.commons.httpclient.Header[r8]
            java.lang.Object[] r8 = r0.toArray(r8)
            org.apache.commons.httpclient.Header[] r8 = (org.apache.commons.httpclient.Header[]) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.HttpParser.parseHeaders(java.io.InputStream, java.lang.String):org.apache.commons.httpclient.Header[]");
    }

    public static String readLine(InputStream inputStream, String str) throws IOException {
        String str2;
        StringBuffer stringBuffer;
        String str3;
        LOG.trace("enter HttpParser.readLine(InputStream, String)");
        byte[] readRawLine = readRawLine(inputStream);
        if (readRawLine == null) {
            return null;
        }
        int length = readRawLine.length;
        int i2 = (length <= 0 || readRawLine[length + -1] != 10) ? 0 : (length <= 1 || readRawLine[length + -2] != 13) ? 1 : 2;
        String string = EncodingUtil.getString(readRawLine, 0, length - i2, str);
        if (Wire.HEADER_WIRE.enabled()) {
            if (i2 == 2) {
                stringBuffer = new StringBuffer();
                stringBuffer.append(string);
                str3 = "\r\n";
            } else if (i2 == 1) {
                stringBuffer = new StringBuffer();
                stringBuffer.append(string);
                str3 = StringUtils.LF;
            } else {
                str2 = string;
                Wire.HEADER_WIRE.input(str2);
            }
            stringBuffer.append(str3);
            str2 = stringBuffer.toString();
            Wire.HEADER_WIRE.input(str2);
        }
        return string;
    }
}
