package com.dd.plist;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class NSObject {
    static final String X = "\t";
    static final int Y = 80;
    static final String s = System.getProperty("line.separator");

    public static NSArray j(Object[] objArr) {
        NSArray nSArray = new NSArray(objArr.length);
        for (int i2 = 0; i2 < objArr.length; i2++) {
            nSArray.I(i2, s(objArr[i2]));
        }
        return nSArray;
    }

    public static NSData k(byte[] bArr) {
        return new NSData(bArr);
    }

    public static NSDate l(Date date) {
        return new NSDate(date);
    }

    public static NSDictionary m(Map<String, Object> map) {
        NSDictionary nSDictionary = new NSDictionary();
        for (String next : map.keySet()) {
            nSDictionary.put(next, s(map.get(next)));
        }
        return nSDictionary;
    }

    public static NSNumber n(double d2) {
        return new NSNumber(d2);
    }

    public static NSNumber o(long j2) {
        return new NSNumber(j2);
    }

    public static NSNumber p(boolean z) {
        return new NSNumber(z);
    }

    public static NSObject s(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof NSObject) {
            return (NSObject) obj;
        }
        Class<?> cls = obj.getClass();
        if (Boolean.class.isAssignableFrom(cls)) {
            return p(((Boolean) obj).booleanValue());
        }
        if (Integer.class.isAssignableFrom(cls)) {
            return o((long) ((Integer) obj).intValue());
        }
        if (Long.class.isAssignableFrom(cls)) {
            return o(((Long) obj).longValue());
        }
        if (Short.class.isAssignableFrom(cls)) {
            return o((long) ((Short) obj).shortValue());
        }
        if (Byte.class.isAssignableFrom(cls)) {
            return o((long) ((Byte) obj).byteValue());
        }
        if (Float.class.isAssignableFrom(cls)) {
            return n((double) ((Float) obj).floatValue());
        }
        if (Double.class.isAssignableFrom(cls)) {
            return n(((Double) obj).doubleValue());
        }
        if (String.class.equals(cls)) {
            return v((String) obj);
        }
        if (Date.class.equals(cls)) {
            return l((Date) obj);
        }
        if (byte[].class.equals(cls)) {
            return k((byte[]) obj);
        }
        if (Object[].class.isAssignableFrom(cls)) {
            return j((Object[]) obj);
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return Collection.class.isAssignableFrom(cls) ? j(((Collection) obj).toArray()) : w(obj);
        }
        Map map = (Map) obj;
        Set keySet = map.keySet();
        NSDictionary nSDictionary = new NSDictionary();
        for (Object next : keySet) {
            nSDictionary.put(String.valueOf(next), s(map.get(next)));
        }
        return nSDictionary;
    }

    public static NSSet u(Set<Object> set) {
        NSSet nSSet = new NSSet();
        for (Object s2 : set.toArray()) {
            nSSet.y(s(s2));
        }
        return nSSet;
    }

    public static NSString v(String str) {
        return new NSString(str);
    }

    public static NSData w(Object obj) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new NSData(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new RuntimeException("The given object of class " + obj.getClass().toString() + " could not be serialized and stored in a NSData object.");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.a(this);
    }

    /* access modifiers changed from: package-private */
    public void b(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(X);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c(StringBuilder sb, int i2);

    /* access modifiers changed from: protected */
    public abstract void e(StringBuilder sb, int i2);

    /* access modifiers changed from: package-private */
    public abstract void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException;

    public Object g() {
        if (this instanceof NSArray) {
            NSObject[] A = ((NSArray) this).A();
            Object[] objArr = new Object[A.length];
            for (int i2 = 0; i2 < A.length; i2++) {
                objArr[i2] = A[i2].g();
            }
            return objArr;
        } else if (this instanceof NSDictionary) {
            HashMap<String, NSObject> K = ((NSDictionary) this).K();
            HashMap hashMap = new HashMap(K.size());
            for (String next : K.keySet()) {
                hashMap.put(next, K.get(next).g());
            }
            return hashMap;
        } else if (this instanceof NSSet) {
            Set<NSObject> E = ((NSSet) this).E();
            Set linkedHashSet = E instanceof LinkedHashSet ? new LinkedHashSet(E.size()) : new TreeSet();
            for (NSObject g2 : E) {
                linkedHashSet.add(g2.g());
            }
            return linkedHashSet;
        } else if (this instanceof NSNumber) {
            NSNumber nSNumber = (NSNumber) this;
            int H = nSNumber.H();
            if (H == 0) {
                long G = nSNumber.G();
                return (G > 2147483647L || G < -2147483648L) ? Long.valueOf(G) : Integer.valueOf(nSNumber.C());
            } else if (H != 1) {
                return H != 2 ? Double.valueOf(nSNumber.z()) : Boolean.valueOf(nSNumber.y());
            } else {
                return Double.valueOf(nSNumber.z());
            }
        } else if (this instanceof NSString) {
            return ((NSString) this).C();
        } else {
            if (this instanceof NSData) {
                return ((NSData) this).y();
            }
            if (this instanceof NSDate) {
                return ((NSDate) this).y();
            }
            return this instanceof UID ? ((UID) this).y() : this;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void h(StringBuilder sb, int i2);

    public String i() {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        String str = s;
        sb.append(str);
        sb.append("<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">");
        sb.append(str);
        sb.append("<plist version=\"1.0\">");
        sb.append(str);
        h(sb, 0);
        sb.append(str);
        sb.append("</plist>");
        return sb.toString();
    }
}
