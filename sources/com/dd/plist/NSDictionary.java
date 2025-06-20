package com.dd.plist;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class NSDictionary extends NSObject implements Map<String, NSObject> {
    private HashMap<String, NSObject> Z = new LinkedHashMap();

    public boolean A(double d2) {
        for (NSObject next : this.Z.values()) {
            if (next.getClass().equals(NSNumber.class)) {
                NSNumber nSNumber = (NSNumber) next;
                if (nSNumber.F() && nSNumber.z() == d2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean C(long j2) {
        for (NSObject next : this.Z.values()) {
            if (next.getClass().equals(NSNumber.class)) {
                NSNumber nSNumber = (NSNumber) next;
                if (nSNumber.E() && ((long) nSNumber.C()) == j2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean D(NSObject nSObject) {
        return this.Z.containsValue(nSObject);
    }

    public boolean E(String str) {
        for (NSObject next : this.Z.values()) {
            if (next.getClass().equals(NSString.class) && ((NSString) next).C().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean F(Date date) {
        for (NSObject next : this.Z.values()) {
            if (next.getClass().equals(NSDate.class) && ((NSDate) next).y().equals(date)) {
                return true;
            }
        }
        return false;
    }

    public boolean G(boolean z) {
        for (NSObject next : this.Z.values()) {
            if (next.getClass().equals(NSNumber.class)) {
                NSNumber nSNumber = (NSNumber) next;
                if (nSNumber.D() && nSNumber.y() == z) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean H(byte[] bArr) {
        for (NSObject next : this.Z.values()) {
            if (next.getClass().equals(NSData.class) && Arrays.equals(((NSData) next).y(), bArr)) {
                return true;
            }
        }
        return false;
    }

    public int I() {
        return this.Z.size();
    }

    /* renamed from: J */
    public NSObject get(Object obj) {
        return this.Z.get(obj);
    }

    public HashMap<String, NSObject> K() {
        return this.Z;
    }

    public NSObject N(String str) {
        return this.Z.get(str);
    }

    public NSObject O(String str, double d2) {
        return put(str, new NSNumber(d2));
    }

    public NSObject P(String str, long j2) {
        return put(str, new NSNumber(j2));
    }

    /* renamed from: Q */
    public NSObject put(String str, NSObject nSObject) {
        return this.Z.put(str, nSObject);
    }

    public NSObject R(String str, String str2) {
        return put(str, new NSString(str2));
    }

    public NSObject S(String str, Date date) {
        return put(str, new NSDate(date));
    }

    public NSObject T(String str, boolean z) {
        return put(str, new NSNumber(z));
    }

    public NSObject U(String str, byte[] bArr) {
        return put(str, new NSData(bArr));
    }

    public void W(String str, Object obj) {
        this.Z.put(str, NSObject.s(obj));
    }

    /* renamed from: Z */
    public NSObject remove(Object obj) {
        return this.Z.remove(obj);
    }

    /* access modifiers changed from: package-private */
    public void a(BinaryPropertyListWriter binaryPropertyListWriter) {
        super.a(binaryPropertyListWriter);
        for (Map.Entry next : this.Z.entrySet()) {
            new NSString((String) next.getKey()).a(binaryPropertyListWriter);
            ((NSObject) next.getValue()).a(binaryPropertyListWriter);
        }
    }

    public NSObject a0(String str) {
        return this.Z.remove(str);
    }

    /* access modifiers changed from: protected */
    public void c(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append(ASCIIPropertyListParser.f18652j);
        sb.append(NSObject.s);
        String[] strArr = (String[]) this.Z.keySet().toArray(new String[0]);
        for (String str : strArr) {
            NSObject N = N(str);
            b(sb, i2 + 1);
            sb.append("\"");
            sb.append(NSString.A(str));
            sb.append("\" =");
            Class<?> cls = N.getClass();
            if (cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) {
                sb.append(NSObject.s);
                N.c(sb, i2 + 2);
            } else {
                sb.append(StringUtils.SPACE);
                N.c(sb, 0);
            }
            sb.append(ASCIIPropertyListParser.f18655m);
            sb.append(NSObject.s);
        }
        b(sb, i2);
        sb.append(ASCIIPropertyListParser.f18653k);
    }

    public String c0() {
        StringBuilder sb = new StringBuilder();
        c(sb, 0);
        sb.append(NSObject.s);
        return sb.toString();
    }

    public void clear() {
        this.Z.clear();
    }

    public boolean containsKey(Object obj) {
        return this.Z.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.Z.containsValue(NSObject.s(obj));
    }

    public String d0() {
        StringBuilder sb = new StringBuilder();
        e(sb, 0);
        sb.append(NSObject.s);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void e(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append(ASCIIPropertyListParser.f18652j);
        sb.append(NSObject.s);
        String[] strArr = (String[]) this.Z.keySet().toArray(new String[0]);
        for (String str : strArr) {
            NSObject N = N(str);
            b(sb, i2 + 1);
            sb.append("\"");
            sb.append(NSString.A(str));
            sb.append("\" =");
            Class<?> cls = N.getClass();
            if (cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) {
                sb.append(NSObject.s);
                N.e(sb, i2 + 2);
            } else {
                sb.append(StringUtils.SPACE);
                N.e(sb, 0);
            }
            sb.append(ASCIIPropertyListParser.f18655m);
            sb.append(NSObject.s);
        }
        b(sb, i2);
        sb.append(ASCIIPropertyListParser.f18653k);
    }

    public Set<Map.Entry<String, NSObject>> entrySet() {
        return this.Z.entrySet();
    }

    public boolean equals(Object obj) {
        return obj.getClass().equals(getClass()) && ((NSDictionary) obj).Z.equals(this.Z);
    }

    /* access modifiers changed from: package-private */
    public void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException {
        binaryPropertyListWriter.n(13, this.Z.size());
        Set<Map.Entry<String, NSObject>> entrySet = this.Z.entrySet();
        for (Map.Entry<String, NSObject> key : entrySet) {
            binaryPropertyListWriter.m(binaryPropertyListWriter.d(new NSString((String) key.getKey())));
        }
        for (Map.Entry<String, NSObject> value : entrySet) {
            binaryPropertyListWriter.m(binaryPropertyListWriter.d((NSObject) value.getValue()));
        }
    }

    /* access modifiers changed from: package-private */
    public void h(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("<dict>");
        sb.append(NSObject.s);
        for (String next : this.Z.keySet()) {
            NSObject N = N(next);
            int i3 = i2 + 1;
            b(sb, i3);
            sb.append("<key>");
            if (next.contains("&") || next.contains("<") || next.contains(">")) {
                sb.append("<![CDATA[");
                sb.append(next.replaceAll("]]>", "]]]]><![CDATA[>"));
                sb.append("]]>");
            } else {
                sb.append(next);
            }
            sb.append("</key>");
            String str = NSObject.s;
            sb.append(str);
            N.h(sb, i3);
            sb.append(str);
        }
        b(sb, i2);
        sb.append("</dict>");
    }

    public int hashCode() {
        HashMap<String, NSObject> hashMap = this.Z;
        return 581 + (hashMap != null ? hashMap.hashCode() : 0);
    }

    public boolean isEmpty() {
        return this.Z.isEmpty();
    }

    public Set<String> keySet() {
        return this.Z.keySet();
    }

    public void putAll(Map<? extends String, ? extends NSObject> map) {
        for (Map.Entry next : map.entrySet()) {
            put((String) next.getKey(), (NSObject) next.getValue());
        }
    }

    public int size() {
        return this.Z.size();
    }

    public Collection<NSObject> values() {
        return this.Z.values();
    }

    public String[] y() {
        return (String[]) this.Z.keySet().toArray(new String[0]);
    }

    public boolean z(String str) {
        return this.Z.containsKey(str);
    }
}
