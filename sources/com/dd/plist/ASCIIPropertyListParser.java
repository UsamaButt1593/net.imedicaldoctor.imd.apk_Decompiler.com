package com.dd.plist;

import com.itextpdf.text.DocWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.text.ParseException;
import java.text.StringCharacterIterator;
import java.util.LinkedList;

public class ASCIIPropertyListParser {
    public static final char A = ':';
    public static final char B = ' ';
    public static final char C = 'T';
    public static final char D = 'Z';
    public static final char E = '/';
    public static final char F = '*';
    public static final char G = '/';
    public static final char H = '/';
    private static CharsetEncoder I = null;

    /* renamed from: c  reason: collision with root package name */
    public static final char f18645c = ' ';

    /* renamed from: d  reason: collision with root package name */
    public static final char f18646d = '\t';

    /* renamed from: e  reason: collision with root package name */
    public static final char f18647e = '\n';

    /* renamed from: f  reason: collision with root package name */
    public static final char f18648f = '\r';

    /* renamed from: g  reason: collision with root package name */
    public static final char f18649g = '(';

    /* renamed from: h  reason: collision with root package name */
    public static final char f18650h = ')';

    /* renamed from: i  reason: collision with root package name */
    public static final char f18651i = ',';

    /* renamed from: j  reason: collision with root package name */
    public static final char f18652j = '{';

    /* renamed from: k  reason: collision with root package name */
    public static final char f18653k = '}';

    /* renamed from: l  reason: collision with root package name */
    public static final char f18654l = '=';

    /* renamed from: m  reason: collision with root package name */
    public static final char f18655m = ';';

    /* renamed from: n  reason: collision with root package name */
    public static final char f18656n = '\"';
    public static final char o = '\"';
    public static final char p = '\\';
    public static final char q = '<';
    public static final char r = '>';
    public static final char s = '*';
    public static final char t = 'D';
    public static final char u = 'B';
    public static final char v = 'Y';
    public static final char w = 'N';
    public static final char x = 'I';
    public static final char y = 'R';
    public static final char z = '-';

    /* renamed from: a  reason: collision with root package name */
    private byte[] f18657a;

    /* renamed from: b  reason: collision with root package name */
    private int f18658b;

    protected ASCIIPropertyListParser() {
    }

    private boolean a(char c2) {
        return this.f18657a[this.f18658b] == c2;
    }

    private boolean b(char... cArr) {
        boolean z2 = false;
        for (char c2 : cArr) {
            if (this.f18657a[this.f18658b] == c2) {
                z2 = true;
            }
        }
        return z2;
    }

    private boolean c(char... cArr) {
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (this.f18657a[this.f18658b + i2] != cArr[i2]) {
                return false;
            }
        }
        return true;
    }

    private void d(char c2) throws ParseException {
        if (!a(c2)) {
            throw new ParseException("Expected '" + c2 + "' but found '" + ((char) this.f18657a[this.f18658b]) + "'", this.f18658b);
        }
    }

    private void e(char... cArr) throws ParseException {
        if (!b(cArr)) {
            String str = "Expected '" + cArr[0] + "'";
            for (int i2 = 1; i2 < cArr.length; i2++) {
                str = str + " or '" + cArr[i2] + "'";
            }
            throw new ParseException(str + " but found '" + ((char) this.f18657a[this.f18658b]) + "'", this.f18658b);
        }
    }

    public static NSObject g(File file) throws Exception {
        return h(new FileInputStream(file));
    }

    public static NSObject h(InputStream inputStream) throws Exception {
        byte[] i2 = PropertyListParser.i(inputStream, Integer.MAX_VALUE);
        inputStream.close();
        return i(i2);
    }

    public static NSObject i(byte[] bArr) throws Exception {
        return new ASCIIPropertyListParser(bArr).f();
    }

    private NSArray j() throws ParseException {
        v();
        x();
        LinkedList linkedList = new LinkedList();
        while (!a(f18650h)) {
            linkedList.add(o());
            x();
            if (!a(f18651i)) {
                break;
            }
            v();
            x();
        }
        s(f18650h);
        return new NSArray((NSObject[]) linkedList.toArray(new NSObject[linkedList.size()]));
    }

    private NSObject k() throws ParseException {
        NSObject nSObject;
        v();
        if (a('*')) {
            v();
            e(u, t, x, y);
            if (a(u)) {
                v();
                e(v, w);
                nSObject = a(v) ? new NSNumber(true) : new NSNumber(false);
                v();
            } else if (a(t)) {
                v();
                nSObject = new NSDate(t('>'));
            } else if (b(x, y)) {
                v();
                nSObject = new NSNumber(t('>'));
            } else {
                nSObject = null;
            }
            s('>');
            return nSObject;
        }
        String replaceAll = t('>').replaceAll("\\s+", "");
        int length = replaceAll.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) Integer.parseInt(replaceAll.substring(i3, i3 + 2), 16);
        }
        NSData nSData = new NSData(bArr);
        v();
        return nSData;
    }

    private NSDictionary l() throws ParseException {
        v();
        x();
        NSDictionary nSDictionary = new NSDictionary();
        while (!a(f18653k)) {
            String p2 = a('\"') ? p() : r();
            x();
            s(f18654l);
            x();
            nSDictionary.put(p2, o());
            x();
            s(f18655m);
            x();
        }
        v();
        return nSDictionary;
    }

    private static String m(StringCharacterIterator stringCharacterIterator) throws UnsupportedEncodingException {
        char next = stringCharacterIterator.next();
        if (next == '\\') {
            return new String("\u0000\\".getBytes(), "UTF-8");
        }
        if (next == '\"') {
            return new String(new byte[]{0, DocWriter.e3}, "UTF-8");
        }
        if (next == 'b') {
            return new String(new byte[]{0, 8}, "UTF-8");
        }
        if (next == 'n') {
            return new String(new byte[]{0, 10}, "UTF-8");
        }
        if (next == 'r') {
            return new String(new byte[]{0, 13}, "UTF-8");
        }
        if (next == 't') {
            return new String(new byte[]{0, 9}, "UTF-8");
        }
        if (next == 'U' || next == 'u') {
            return new String(new byte[]{(byte) Integer.parseInt(("" + stringCharacterIterator.next()) + stringCharacterIterator.next(), 16), (byte) Integer.parseInt(("" + stringCharacterIterator.next()) + stringCharacterIterator.next(), 16)}, "UTF-8");
        }
        return new String(new byte[]{0, (byte) Integer.parseInt((("" + next) + stringCharacterIterator.next()) + stringCharacterIterator.next(), 8)}, "UTF-8");
    }

    private NSObject n() {
        String r2 = r();
        try {
            return (r2.length() <= 4 || r2.charAt(4) != '-') ? new NSNumber(r2) : new NSDate(r2);
        } catch (Exception unused) {
            return new NSString(r2);
        }
    }

    private NSObject o() throws ParseException {
        byte b2 = this.f18657a[this.f18658b];
        if (b2 == 34) {
            String p2 = p();
            if (p2.length() != 20 || p2.charAt(4) != '-') {
                return new NSString(p2);
            }
            try {
                return new NSDate(p2);
            } catch (Exception unused) {
                return new NSString(p2);
            }
        } else if (b2 == 40) {
            return j();
        } else {
            if (b2 == 60) {
                return k();
            }
            if (b2 == 123) {
                return l();
            }
            if (b2 > 47 && b2 < 58) {
                return n();
            }
            String r2 = r();
            if (r2.equals("YES")) {
                return new NSNumber(true);
            }
            return r2.equals("NO") ? new NSNumber(false) : new NSString(r2);
        }
    }

    private String p() throws ParseException {
        v();
        String str = "";
        boolean z2 = true;
        while (true) {
            byte[] bArr = this.f18657a;
            int i2 = this.f18658b;
            if (bArr[i2] != 34 || (bArr[i2 - 1] == 92 && z2)) {
                str = str + ((char) this.f18657a[this.f18658b]);
                if (a(p)) {
                    z2 = this.f18657a[this.f18658b - 1] != 92 || !z2;
                }
                v();
            } else {
                try {
                    String q2 = q(str);
                    v();
                    return q2;
                } catch (Exception unused) {
                    throw new ParseException("The quoted string could not be parsed.", this.f18658b);
                }
            }
        }
    }

    public static synchronized String q(String str) throws Exception {
        int i2;
        synchronized (ASCIIPropertyListParser.class) {
            try {
                LinkedList<Byte> linkedList = new LinkedList<>();
                StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
                char current = stringCharacterIterator.current();
                while (true) {
                    i2 = 0;
                    if (stringCharacterIterator.getIndex() >= stringCharacterIterator.getEndIndex()) {
                        break;
                    }
                    if (current != '\\') {
                        linkedList.add((byte) 0);
                        linkedList.add(Byte.valueOf((byte) current));
                    } else {
                        byte[] bytes = m(stringCharacterIterator).getBytes("UTF-8");
                        int length = bytes.length;
                        while (i2 < length) {
                            linkedList.add(Byte.valueOf(bytes[i2]));
                            i2++;
                        }
                    }
                    current = stringCharacterIterator.next();
                }
                byte[] bArr = new byte[linkedList.size()];
                for (Byte byteValue : linkedList) {
                    bArr[i2] = byteValue.byteValue();
                    i2++;
                }
                String str2 = new String(bArr, "UTF-8");
                CharBuffer wrap = CharBuffer.wrap(str2);
                if (I == null) {
                    I = Charset.forName(NTLM.DEFAULT_CHARSET).newEncoder();
                }
                if (!I.canEncode(wrap)) {
                    return str2;
                }
                String charBuffer = I.encode(wrap).asCharBuffer().toString();
                return charBuffer;
            } finally {
                while (true) {
                }
            }
        }
    }

    private String r() {
        return u(' ', 9, 10, 13, f18651i, f18655m, f18654l, f18650h);
    }

    private void s(char c2) throws ParseException {
        d(c2);
        this.f18658b++;
    }

    private String t(char c2) {
        String str = "";
        while (!a(c2)) {
            str = str + ((char) this.f18657a[this.f18658b]);
            v();
        }
        return str;
    }

    private String u(char... cArr) {
        String str = "";
        while (!b(cArr)) {
            str = str + ((char) this.f18657a[this.f18658b]);
            v();
        }
        return str;
    }

    private void v() {
        this.f18658b++;
    }

    private void w(int i2) {
        this.f18658b += i2;
    }

    private void x() {
        while (true) {
            if (b(13, 10, ' ', 9)) {
                v();
            } else if (c('/', '/')) {
                w(2);
                u(13, 10);
            } else if (c('/', '*')) {
                w(2);
                while (!c('*', '/')) {
                    v();
                }
                w(2);
            } else {
                return;
            }
        }
    }

    public NSObject f() throws ParseException {
        this.f18658b = 0;
        x();
        e(f18652j, f18649g, '/');
        try {
            return o();
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ParseException("Reached end of input unexpectedly.", this.f18658b);
        }
    }

    private ASCIIPropertyListParser(byte[] bArr) {
        this.f18657a = bArr;
    }
}
