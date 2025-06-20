package com.dd.plist;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class NSString extends NSObject implements Comparable<Object> {
    private static CharsetEncoder X2;
    private static CharsetEncoder Y2;
    private static CharsetEncoder Z2;
    private String Z;

    public NSString(String str) {
        this.Z = str;
    }

    static String A(String str) {
        StringBuilder sb;
        StringBuilder sb2;
        String str2;
        char[] charArray = str.toCharArray();
        String str3 = "";
        for (char c2 : charArray) {
            if (c2 > 127) {
                String str4 = str3 + "\\U";
                String hexString = Integer.toHexString(c2);
                while (hexString.length() < 4) {
                    hexString = "0" + hexString;
                }
                sb = new StringBuilder();
                sb.append(str4);
                sb.append(hexString);
            } else {
                if (c2 == '\\') {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    str2 = "\\\\";
                } else if (c2 == '\"') {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    str2 = "\\\"";
                } else if (c2 == 8) {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    str2 = "\\b";
                } else if (c2 == 10) {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    str2 = "\\n";
                } else if (c2 == 13) {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    str2 = "\\r";
                } else if (c2 == 9) {
                    sb2 = new StringBuilder();
                    sb2.append(str3);
                    str2 = "\\t";
                } else {
                    sb = new StringBuilder();
                    sb.append(str3);
                    sb.append(c2);
                }
                sb2.append(str2);
                str3 = sb2.toString();
            }
            str3 = sb.toString();
        }
        return str3;
    }

    public String C() {
        return this.Z;
    }

    public void D(NSString nSString) {
        E(nSString.C());
    }

    public void E(String str) {
        this.Z = str + this.Z;
    }

    public void F(String str) {
        this.Z = str;
    }

    /* access modifiers changed from: protected */
    public void c(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("\"");
        sb.append(A(this.Z));
        sb.append("\"");
    }

    public int compareTo(Object obj) {
        String C;
        String str;
        if (obj instanceof NSString) {
            C = C();
            str = ((NSString) obj).C();
        } else if (!(obj instanceof String)) {
            return -1;
        } else {
            C = C();
            str = (String) obj;
        }
        return C.compareTo(str);
    }

    /* access modifiers changed from: protected */
    public void e(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("\"");
        sb.append(A(this.Z));
        sb.append("\"");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NSString)) {
            return false;
        }
        return this.Z.equals(((NSString) obj).Z);
    }

    public void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException {
        int i2;
        ByteBuffer byteBuffer;
        CharBuffer wrap = CharBuffer.wrap(this.Z);
        synchronized (NSString.class) {
            try {
                CharsetEncoder charsetEncoder = X2;
                if (charsetEncoder == null) {
                    X2 = Charset.forName(NTLM.DEFAULT_CHARSET).newEncoder();
                } else {
                    charsetEncoder.reset();
                }
                if (X2.canEncode(wrap)) {
                    byteBuffer = X2.encode(wrap);
                    i2 = 5;
                } else {
                    CharsetEncoder charsetEncoder2 = Y2;
                    if (charsetEncoder2 == null) {
                        Y2 = Charset.forName("UTF-16BE").newEncoder();
                    } else {
                        charsetEncoder2.reset();
                    }
                    byteBuffer = Y2.encode(wrap);
                    i2 = 6;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        binaryPropertyListWriter.n(i2, this.Z.length());
        binaryPropertyListWriter.j(bArr);
    }

    /* access modifiers changed from: package-private */
    public void h(StringBuilder sb, int i2) {
        String str;
        String str2;
        b(sb, i2);
        sb.append("<string>");
        synchronized (NSString.class) {
            try {
                CharsetEncoder charsetEncoder = Z2;
                if (charsetEncoder == null) {
                    Z2 = Charset.forName("UTF-8").newEncoder();
                } else {
                    charsetEncoder.reset();
                }
                ByteBuffer encode = Z2.encode(CharBuffer.wrap(this.Z));
                byte[] bArr = new byte[encode.remaining()];
                encode.get(bArr);
                str = new String(bArr, "UTF-8");
                this.Z = str;
            } catch (Exception e2) {
                throw new RuntimeException("Could not encode the NSString into UTF-8: " + String.valueOf(e2.getMessage()));
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str.contains("&") || this.Z.contains("<") || this.Z.contains(">")) {
            sb.append("<![CDATA[");
            sb.append(this.Z.replaceAll("]]>", "]]]]><![CDATA[>"));
            str2 = "]]>";
        } else {
            str2 = this.Z;
        }
        sb.append(str2);
        sb.append("</string>");
    }

    public int hashCode() {
        return this.Z.hashCode();
    }

    public String toString() {
        return this.Z;
    }

    public void y(NSString nSString) {
        z(nSString.C());
    }

    public void z(String str) {
        this.Z += str;
    }

    public NSString(byte[] bArr, String str) throws UnsupportedEncodingException {
        this.Z = new String(bArr, str);
    }
}
