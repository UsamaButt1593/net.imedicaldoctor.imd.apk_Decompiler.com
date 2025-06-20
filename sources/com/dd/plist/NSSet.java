package com.dd.plist;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

public class NSSet extends NSObject {
    private boolean X2;
    private Set<NSObject> Z;

    public NSSet() {
        this.X2 = false;
        this.Z = new LinkedHashSet();
    }

    public synchronized NSObject A() {
        if (this.Z.isEmpty()) {
            return null;
        }
        return this.Z.iterator().next();
    }

    public boolean C(NSObject nSObject) {
        return this.Z.contains(nSObject);
    }

    public synchronized int D() {
        return this.Z.size();
    }

    /* access modifiers changed from: package-private */
    public Set<NSObject> E() {
        return this.Z;
    }

    public synchronized boolean F(NSSet nSSet) {
        for (NSObject C : this.Z) {
            if (nSSet.C(C)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean G(NSSet nSSet) {
        for (NSObject C : this.Z) {
            if (!nSSet.C(C)) {
                return false;
            }
        }
        return true;
    }

    public synchronized NSObject H(NSObject nSObject) {
        for (NSObject next : this.Z) {
            if (next.equals(nSObject)) {
                return next;
            }
        }
        return null;
    }

    public synchronized Iterator<NSObject> I() {
        return this.Z.iterator();
    }

    public synchronized void J(NSObject nSObject) {
        this.Z.remove(nSObject);
    }

    /* access modifiers changed from: package-private */
    public void a(BinaryPropertyListWriter binaryPropertyListWriter) {
        super.a(binaryPropertyListWriter);
        for (NSObject a2 : this.Z) {
            a2.a(binaryPropertyListWriter);
        }
    }

    /* access modifiers changed from: protected */
    public void c(StringBuilder sb, int i2) {
        b(sb, i2);
        NSObject[] z = z();
        sb.append(ASCIIPropertyListParser.f18649g);
        int lastIndexOf = sb.lastIndexOf(NSObject.s);
        for (int i3 = 0; i3 < z.length; i3++) {
            Class<?> cls = z[i3].getClass();
            if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                sb.append(NSObject.s);
                lastIndexOf = sb.length();
                z[i3].c(sb, i2 + 1);
            } else {
                if (i3 != 0) {
                    sb.append(StringUtils.SPACE);
                }
                z[i3].c(sb, 0);
            }
            if (i3 != z.length - 1) {
                sb.append(ASCIIPropertyListParser.f18651i);
            }
            if (sb.length() - lastIndexOf > 80) {
                sb.append(NSObject.s);
                lastIndexOf = sb.length();
            }
        }
        sb.append(ASCIIPropertyListParser.f18650h);
    }

    /* access modifiers changed from: protected */
    public void e(StringBuilder sb, int i2) {
        b(sb, i2);
        NSObject[] z = z();
        sb.append(ASCIIPropertyListParser.f18649g);
        int lastIndexOf = sb.lastIndexOf(NSObject.s);
        for (int i3 = 0; i3 < z.length; i3++) {
            Class<?> cls = z[i3].getClass();
            if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                sb.append(NSObject.s);
                lastIndexOf = sb.length();
                z[i3].e(sb, i2 + 1);
            } else {
                if (i3 != 0) {
                    sb.append(StringUtils.SPACE);
                }
                z[i3].e(sb, 0);
            }
            if (i3 != z.length - 1) {
                sb.append(ASCIIPropertyListParser.f18651i);
            }
            if (sb.length() - lastIndexOf > 80) {
                sb.append(NSObject.s);
                lastIndexOf = sb.length();
            }
        }
        sb.append(ASCIIPropertyListParser.f18650h);
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Set<NSObject> set = this.Z;
        Set<NSObject> set2 = ((NSSet) obj).Z;
        if (set != set2) {
            return set != null && set.equals(set2);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f(BinaryPropertyListWriter binaryPropertyListWriter) throws IOException {
        int size;
        int i2;
        if (this.X2) {
            size = this.Z.size();
            i2 = 11;
        } else {
            size = this.Z.size();
            i2 = 12;
        }
        binaryPropertyListWriter.n(i2, size);
        for (NSObject d2 : this.Z) {
            binaryPropertyListWriter.m(binaryPropertyListWriter.d(d2));
        }
    }

    /* access modifiers changed from: package-private */
    public void h(StringBuilder sb, int i2) {
        b(sb, i2);
        sb.append("<array>");
        sb.append(NSObject.s);
        for (NSObject h2 : this.Z) {
            h2.h(sb, i2 + 1);
            sb.append(NSObject.s);
        }
        b(sb, i2);
        sb.append("</array>");
    }

    public int hashCode() {
        Set<NSObject> set = this.Z;
        return 203 + (set != null ? set.hashCode() : 0);
    }

    public synchronized void y(NSObject nSObject) {
        this.Z.add(nSObject);
    }

    public synchronized NSObject[] z() {
        return (NSObject[]) this.Z.toArray(new NSObject[D()]);
    }

    public NSSet(boolean z) {
        this.X2 = z;
        this.Z = !z ? new LinkedHashSet<>() : new TreeSet<>();
    }

    public NSSet(boolean z, NSObject... nSObjectArr) {
        this.X2 = z;
        this.Z = !z ? new LinkedHashSet<>() : new TreeSet<>();
        this.Z.addAll(Arrays.asList(nSObjectArr));
    }

    public NSSet(NSObject... nSObjectArr) {
        this.X2 = false;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.Z = linkedHashSet;
        linkedHashSet.addAll(Arrays.asList(nSObjectArr));
    }
}
