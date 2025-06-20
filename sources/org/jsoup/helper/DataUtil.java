package org.jsoup.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

public final class DataUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f31562a = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");

    /* renamed from: b  reason: collision with root package name */
    static final String f31563b = "UTF-8";

    /* renamed from: c  reason: collision with root package name */
    private static final int f31564c = 60000;

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f31565d = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: e  reason: collision with root package name */
    static final int f31566e = 32;

    private DataUtil() {
    }

    static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[f31564c];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    private static String b(ByteBuffer byteBuffer, String str) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        byte b2 = bArr[0];
        if ((b2 == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (b2 == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return "UTF-32";
        }
        if ((b2 == -2 && bArr[1] == -1) || (b2 == -1 && bArr[1] == -2)) {
            return "UTF-16";
        }
        if (b2 != -17 || bArr[1] != -69 || bArr[2] != -65) {
            return str;
        }
        byteBuffer.position(3);
        return "UTF-8";
    }

    static ByteBuffer c() {
        return ByteBuffer.allocate(0);
    }

    static String d(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f31562a.matcher(str);
        if (matcher.find()) {
            return m(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    public static Document e(File file, String str, String str2) throws IOException {
        return i(j(file), str, str2, Parser.c());
    }

    public static Document f(InputStream inputStream, String str, String str2) throws IOException {
        return i(k(inputStream), str, str2, Parser.c());
    }

    public static Document g(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return i(k(inputStream), str, str2, parser);
    }

    static String h() {
        StringBuilder sb = new StringBuilder(32);
        Random random = new Random();
        for (int i2 = 0; i2 < 32; i2++) {
            char[] cArr = f31565d;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static org.jsoup.nodes.Document i(java.nio.ByteBuffer r9, java.lang.String r10, java.lang.String r11, org.jsoup.parser.Parser r12) {
        /*
            java.lang.String r10 = b(r9, r10)
            r0 = 0
            if (r10 != 0) goto L_0x0099
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r1)
            java.nio.CharBuffer r2 = r2.decode(r9)
            java.lang.String r2 = r2.toString()
            org.jsoup.nodes.Document r3 = r12.j(r2, r11)
            java.lang.String r4 = "meta[http-equiv=content-type], meta[charset]"
            org.jsoup.select.Elements r4 = r3.a3(r4)
            java.util.Iterator r4 = r4.iterator()
            r5 = r0
        L_0x0024:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0052
            java.lang.Object r6 = r4.next()
            org.jsoup.nodes.Element r6 = (org.jsoup.nodes.Element) r6
            java.lang.String r7 = "http-equiv"
            boolean r7 = r6.z(r7)
            if (r7 == 0) goto L_0x0042
            java.lang.String r5 = "content"
            java.lang.String r5 = r6.g(r5)
            java.lang.String r5 = d(r5)
        L_0x0042:
            if (r5 != 0) goto L_0x0050
            java.lang.String r7 = "charset"
            boolean r8 = r6.z(r7)
            if (r8 == 0) goto L_0x0050
            java.lang.String r5 = r6.g(r7)
        L_0x0050:
            if (r5 == 0) goto L_0x0024
        L_0x0052:
            if (r5 != 0) goto L_0x007b
            int r4 = r3.p()
            if (r4 <= 0) goto L_0x007b
            r4 = 0
            org.jsoup.nodes.Node r6 = r3.o(r4)
            boolean r6 = r6 instanceof org.jsoup.nodes.XmlDeclaration
            if (r6 == 0) goto L_0x007b
            org.jsoup.nodes.Node r4 = r3.o(r4)
            org.jsoup.nodes.XmlDeclaration r4 = (org.jsoup.nodes.XmlDeclaration) r4
            java.lang.String r6 = r4.w0()
            java.lang.String r7 = "xml"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x007b
            java.lang.String r5 = "encoding"
            java.lang.String r5 = r4.g(r5)
        L_0x007b:
            java.lang.String r4 = m(r5)
            if (r4 == 0) goto L_0x0097
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L_0x0097
            java.lang.String r10 = r4.trim()
            java.lang.String r1 = "[\"']"
            java.lang.String r2 = ""
            java.lang.String r10 = r10.replaceAll(r1, r2)
            r9.rewind()
            goto L_0x009e
        L_0x0097:
            r0 = r3
            goto L_0x00aa
        L_0x0099:
            java.lang.String r1 = "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML"
            org.jsoup.helper.Validate.i(r10, r1)
        L_0x009e:
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r10)
            java.nio.CharBuffer r9 = r1.decode(r9)
            java.lang.String r2 = r9.toString()
        L_0x00aa:
            if (r0 != 0) goto L_0x00b7
            org.jsoup.nodes.Document r0 = r12.j(r2, r11)
            org.jsoup.nodes.Document$OutputSettings r9 = r0.z3()
            r9.b(r10)
        L_0x00b7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.DataUtil.i(java.nio.ByteBuffer, java.lang.String, java.lang.String, org.jsoup.parser.Parser):org.jsoup.nodes.Document");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.nio.ByteBuffer j(java.io.File r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ all -> 0x001d }
            java.lang.String r2 = "r"
            r1.<init>(r4, r2)     // Catch:{ all -> 0x001d }
            long r2 = r1.length()     // Catch:{ all -> 0x001a }
            int r4 = (int) r2     // Catch:{ all -> 0x001a }
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x001a }
            r1.readFully(r4)     // Catch:{ all -> 0x001a }
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r4)     // Catch:{ all -> 0x001a }
            r1.close()
            return r4
        L_0x001a:
            r4 = move-exception
            r0 = r1
            goto L_0x001e
        L_0x001d:
            r4 = move-exception
        L_0x001e:
            if (r0 == 0) goto L_0x0023
            r0.close()
        L_0x0023:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.DataUtil.j(java.io.File):java.nio.ByteBuffer");
    }

    static ByteBuffer k(InputStream inputStream) throws IOException {
        return l(inputStream, 0);
    }

    public static ByteBuffer l(InputStream inputStream, int i2) throws IOException {
        int read;
        boolean z = true;
        Validate.e(i2 >= 0, "maxSize must be 0 (unlimited) or larger");
        if (i2 <= 0) {
            z = false;
        }
        int i3 = f31564c;
        byte[] bArr = new byte[((!z || i2 >= f31564c) ? f31564c : i2)];
        if (z) {
            i3 = i2;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        while (true) {
            if (Thread.interrupted() || (read = inputStream.read(bArr)) == -1) {
                break;
            }
            if (z) {
                if (read > i2) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                    break;
                }
                i2 -= read;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    private static String m(String str) {
        if (!(str == null || str.length() == 0)) {
            String replaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(replaceAll)) {
                    return replaceAll;
                }
                String upperCase = replaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }
}
