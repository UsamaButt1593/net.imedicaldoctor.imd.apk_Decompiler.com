package com.dd.plist;

import android.support.v4.media.session.PlaybackStateCompat;
import com.itextpdf.text.pdf.ByteBuffer;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BinaryPropertyListWriter {

    /* renamed from: f  reason: collision with root package name */
    public static final int f18682f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f18683g = 10;

    /* renamed from: h  reason: collision with root package name */
    public static final int f18684h = 15;

    /* renamed from: i  reason: collision with root package name */
    public static final int f18685i = 20;

    /* renamed from: j  reason: collision with root package name */
    static final /* synthetic */ boolean f18686j = false;

    /* renamed from: a  reason: collision with root package name */
    private int f18687a = 0;

    /* renamed from: b  reason: collision with root package name */
    private OutputStream f18688b;

    /* renamed from: c  reason: collision with root package name */
    private long f18689c;

    /* renamed from: d  reason: collision with root package name */
    private Map<NSObject, Integer> f18690d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private int f18691e;

    BinaryPropertyListWriter(OutputStream outputStream) throws IOException {
        this.f18688b = new BufferedOutputStream(outputStream);
    }

    private static int b(int i2) {
        if (i2 < 256) {
            return 1;
        }
        return i2 < 65536 ? 2 : 4;
    }

    private int c(long j2) {
        if (j2 < 256) {
            return 1;
        }
        if (j2 < PlaybackStateCompat.v3) {
            return 2;
        }
        return j2 < 4294967296L ? 4 : 8;
    }

    private static int e(NSObject nSObject) {
        int i2 = 10;
        int i3 = 0;
        int i4 = nSObject == null ? 10 : 0;
        if (nSObject instanceof NSDictionary) {
            for (NSObject e2 : ((NSDictionary) nSObject).K().values()) {
                int e3 = e(e2);
                if (e3 > i4) {
                    i4 = e3;
                }
            }
            return i4;
        } else if (nSObject instanceof NSArray) {
            NSObject[] A = ((NSArray) nSObject).A();
            int length = A.length;
            while (i3 < length) {
                int e4 = e(A[i3]);
                if (e4 > i4) {
                    i4 = e4;
                }
                i3++;
            }
            return i4;
        } else if (!(nSObject instanceof NSSet)) {
            return i4;
        } else {
            NSObject[] z = ((NSSet) nSObject).z();
            int length2 = z.length;
            while (i3 < length2) {
                int e5 = e(z[i3]);
                if (e5 > i2) {
                    i2 = e5;
                }
                i3++;
            }
            return i2;
        }
    }

    public static void h(File file, NSObject nSObject) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        i(fileOutputStream, nSObject);
        fileOutputStream.close();
    }

    public static void i(OutputStream outputStream, NSObject nSObject) throws IOException {
        int e2 = e(nSObject);
        if (e2 > 0) {
            String str = e2 != 10 ? e2 != 15 ? e2 == 20 ? "v2.0" : "v0.0" : "v1.5" : "v1.0";
            throw new IOException("The given property list structure cannot be saved. The required version of the binary format (" + str + ") is not yet supported.");
        }
        new BinaryPropertyListWriter(outputStream, e2).g(nSObject);
    }

    public static byte[] p(NSObject nSObject) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        i(byteArrayOutputStream, nSObject);
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public void a(NSObject nSObject) {
        if (!this.f18690d.containsKey(nSObject)) {
            Map<NSObject, Integer> map = this.f18690d;
            map.put(nSObject, Integer.valueOf(map.size()));
        }
    }

    /* access modifiers changed from: package-private */
    public int d(NSObject nSObject) {
        return this.f18690d.get(nSObject).intValue();
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) throws IOException {
        this.f18688b.write(i2);
        this.f18689c++;
    }

    /* access modifiers changed from: package-private */
    public void g(NSObject nSObject) throws IOException {
        int i2;
        j(new byte[]{98, 112, 108, 105, 115, 116});
        int i3 = this.f18687a;
        if (i3 == 0) {
            j(new byte[]{ByteBuffer.X2, ByteBuffer.X2});
        } else if (i3 == 10) {
            j(new byte[]{49, ByteBuffer.X2});
        } else if (i3 == 15) {
            j(new byte[]{49, 53});
        } else if (i3 == 20) {
            j(new byte[]{50, ByteBuffer.X2});
        }
        nSObject.a(this);
        this.f18691e = b(this.f18690d.size());
        int size = this.f18690d.size();
        long[] jArr = new long[size];
        Iterator<Map.Entry<NSObject, Integer>> it2 = this.f18690d.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry next = it2.next();
            NSObject nSObject2 = (NSObject) next.getKey();
            jArr[((Integer) next.getValue()).intValue()] = this.f18689c;
            if (nSObject2 == null) {
                f(0);
            } else {
                nSObject2.f(this);
            }
        }
        long j2 = this.f18689c;
        int c2 = c(j2);
        for (i2 = 0; i2 < size; i2++) {
            k(jArr[i2], c2);
        }
        if (this.f18687a != 15) {
            j(new byte[6]);
            f(c2);
            f(this.f18691e);
            o((long) this.f18690d.size());
            o((long) this.f18690d.get(nSObject).intValue());
            o(j2);
        }
        this.f18688b.flush();
    }

    /* access modifiers changed from: package-private */
    public void j(byte[] bArr) throws IOException {
        this.f18688b.write(bArr);
        this.f18689c += (long) bArr.length;
    }

    /* access modifiers changed from: package-private */
    public void k(long j2, int i2) throws IOException {
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            f((int) (j2 >> (i3 * 8)));
        }
    }

    /* access modifiers changed from: package-private */
    public void l(double d2) throws IOException {
        o(Double.doubleToRawLongBits(d2));
    }

    /* access modifiers changed from: package-private */
    public void m(int i2) throws IOException {
        k((long) i2, this.f18691e);
    }

    /* access modifiers changed from: package-private */
    public void n(int i2, int i3) throws IOException {
        long j2;
        int i4;
        if (i3 < 15) {
            f((i2 << 4) + i3);
            return;
        }
        if (i3 < 256) {
            f((i2 << 4) + 15);
            f(16);
            j2 = (long) i3;
            i4 = 1;
        } else {
            f((i2 << 4) + 15);
            if (i3 < 65536) {
                f(17);
                j2 = (long) i3;
                i4 = 2;
            } else {
                f(18);
                k((long) i3, 4);
                return;
            }
        }
        k(j2, i4);
    }

    /* access modifiers changed from: package-private */
    public void o(long j2) throws IOException {
        k(j2, 8);
    }

    BinaryPropertyListWriter(OutputStream outputStream, int i2) throws IOException {
        this.f18687a = i2;
        this.f18688b = new BufferedOutputStream(outputStream);
    }
}
