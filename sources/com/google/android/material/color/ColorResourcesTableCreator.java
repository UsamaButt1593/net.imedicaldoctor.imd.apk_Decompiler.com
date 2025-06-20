package com.google.android.material.color;

import android.content.Context;
import android.util.Pair;
import androidx.annotation.ColorInt;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.scheduling.WorkQueueKt;

final class ColorResourcesTableCreator {

    /* renamed from: a  reason: collision with root package name */
    private static final short f21021a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static final short f21022b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final short f21023c = 512;

    /* renamed from: d  reason: collision with root package name */
    private static final short f21024d = 513;

    /* renamed from: e  reason: collision with root package name */
    private static final short f21025e = 514;

    /* renamed from: f  reason: collision with root package name */
    private static final byte f21026f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final byte f21027g = Byte.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    private static final String f21028h = "color";
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static byte f21029i;

    /* renamed from: j  reason: collision with root package name */
    private static final PackageInfo f21030j = new PackageInfo(1, "android");
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final Comparator<ColorResource> f21031k = new Comparator<ColorResource>() {
        /* renamed from: a */
        public int compare(ColorResource colorResource, ColorResource colorResource2) {
            return colorResource.f21034c - colorResource2.f21034c;
        }
    };

    static class ColorResource {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final byte f21032a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final byte f21033b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final short f21034c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final String f21035d;
        /* access modifiers changed from: private */
        @ColorInt

        /* renamed from: e  reason: collision with root package name */
        public final int f21036e;

        ColorResource(int i2, String str, int i3) {
            this.f21035d = str;
            this.f21036e = i3;
            this.f21034c = (short) (65535 & i2);
            this.f21033b = (byte) ((i2 >> 16) & 255);
            this.f21032a = (byte) ((i2 >> 24) & 255);
        }
    }

    private static class PackageChunk {

        /* renamed from: f  reason: collision with root package name */
        private static final short f21037f = 288;

        /* renamed from: g  reason: collision with root package name */
        private static final int f21038g = 128;

        /* renamed from: a  reason: collision with root package name */
        private final ResChunkHeader f21039a;

        /* renamed from: b  reason: collision with root package name */
        private final PackageInfo f21040b;

        /* renamed from: c  reason: collision with root package name */
        private final StringPoolChunk f21041c = new StringPoolChunk(false, "?1", "?2", "?3", "?4", "?5", "color");

        /* renamed from: d  reason: collision with root package name */
        private final StringPoolChunk f21042d;

        /* renamed from: e  reason: collision with root package name */
        private final TypeSpecChunk f21043e;

        PackageChunk(PackageInfo packageInfo, List<ColorResource> list) {
            this.f21040b = packageInfo;
            String[] strArr = new String[list.size()];
            for (int i2 = 0; i2 < list.size(); i2++) {
                strArr[i2] = list.get(i2).f21035d;
            }
            this.f21042d = new StringPoolChunk(true, strArr);
            this.f21043e = new TypeSpecChunk(list);
            this.f21039a = new ResChunkHeader(ColorResourcesTableCreator.f21023c, f21037f, a());
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f21041c.a() + TIFFConstants.E0 + this.f21042d.a() + this.f21043e.b();
        }

        /* access modifiers changed from: package-private */
        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f21039a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21040b.f21044a));
            char[] charArray = this.f21040b.f21045b.toCharArray();
            for (int i2 = 0; i2 < 128; i2++) {
                if (i2 < charArray.length) {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.h(charArray[i2]));
                } else {
                    byteArrayOutputStream.write(ColorResourcesTableCreator.h(0));
                }
            }
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(TIFFConstants.E0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21041c.a() + TIFFConstants.E0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(0));
            this.f21041c.c(byteArrayOutputStream);
            this.f21042d.c(byteArrayOutputStream);
            this.f21043e.c(byteArrayOutputStream);
        }
    }

    static class PackageInfo {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f21044a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final String f21045b;

        PackageInfo(int i2, String str) {
            this.f21044a = i2;
            this.f21045b = str;
        }
    }

    private static class ResChunkHeader {

        /* renamed from: a  reason: collision with root package name */
        private final short f21046a;

        /* renamed from: b  reason: collision with root package name */
        private final short f21047b;

        /* renamed from: c  reason: collision with root package name */
        private final int f21048c;

        ResChunkHeader(short s, short s2, int i2) {
            this.f21046a = s;
            this.f21047b = s2;
            this.f21048c = i2;
        }

        /* access modifiers changed from: package-private */
        public void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(this.f21046a));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(this.f21047b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21048c));
        }
    }

    private static class ResEntry {

        /* renamed from: c  reason: collision with root package name */
        private static final short f21049c = 8;

        /* renamed from: d  reason: collision with root package name */
        private static final short f21050d = 2;

        /* renamed from: e  reason: collision with root package name */
        private static final short f21051e = 8;

        /* renamed from: f  reason: collision with root package name */
        private static final byte f21052f = 28;

        /* renamed from: g  reason: collision with root package name */
        private static final int f21053g = 16;

        /* renamed from: a  reason: collision with root package name */
        private final int f21054a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21055b;

        ResEntry(int i2, @ColorInt int i3) {
            this.f21054a = i2;
            this.f21055b = i3;
        }

        /* access modifiers changed from: package-private */
        public void a(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(8));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(2));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21054a));
            byteArrayOutputStream.write(ColorResourcesTableCreator.k(8));
            byteArrayOutputStream.write(new byte[]{0, 28});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21055b));
        }
    }

    private static class ResTable {

        /* renamed from: e  reason: collision with root package name */
        private static final short f21056e = 12;

        /* renamed from: a  reason: collision with root package name */
        private final ResChunkHeader f21057a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21058b;

        /* renamed from: c  reason: collision with root package name */
        private final StringPoolChunk f21059c;

        /* renamed from: d  reason: collision with root package name */
        private final List<PackageChunk> f21060d = new ArrayList();

        ResTable(Map<PackageInfo, List<ColorResource>> map) {
            this.f21058b = map.size();
            this.f21059c = new StringPoolChunk(new String[0]);
            for (Map.Entry next : map.entrySet()) {
                List list = (List) next.getValue();
                Collections.sort(list, ColorResourcesTableCreator.f21031k);
                this.f21060d.add(new PackageChunk((PackageInfo) next.getKey(), list));
            }
            this.f21057a = new ResChunkHeader(2, 12, a());
        }

        private int a() {
            int i2 = 0;
            for (PackageChunk a2 : this.f21060d) {
                i2 += a2.a();
            }
            return this.f21059c.a() + 12 + i2;
        }

        /* access modifiers changed from: package-private */
        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f21057a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21058b));
            this.f21059c.c(byteArrayOutputStream);
            for (PackageChunk b2 : this.f21060d) {
                b2.b(byteArrayOutputStream);
            }
        }
    }

    private static class StringPoolChunk {

        /* renamed from: m  reason: collision with root package name */
        private static final short f21061m = 28;

        /* renamed from: n  reason: collision with root package name */
        private static final int f21062n = 256;
        private static final int o = -1;

        /* renamed from: a  reason: collision with root package name */
        private final ResChunkHeader f21063a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21064b;

        /* renamed from: c  reason: collision with root package name */
        private final int f21065c;

        /* renamed from: d  reason: collision with root package name */
        private final int f21066d;

        /* renamed from: e  reason: collision with root package name */
        private final int f21067e;

        /* renamed from: f  reason: collision with root package name */
        private final List<Integer> f21068f;

        /* renamed from: g  reason: collision with root package name */
        private final List<Integer> f21069g;

        /* renamed from: h  reason: collision with root package name */
        private final List<byte[]> f21070h;

        /* renamed from: i  reason: collision with root package name */
        private final List<List<StringStyledSpan>> f21071i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f21072j;

        /* renamed from: k  reason: collision with root package name */
        private final int f21073k;

        /* renamed from: l  reason: collision with root package name */
        private final int f21074l;

        StringPoolChunk(boolean z, String... strArr) {
            this.f21068f = new ArrayList();
            this.f21069g = new ArrayList();
            this.f21070h = new ArrayList();
            this.f21071i = new ArrayList();
            this.f21072j = z;
            int i2 = 0;
            int i3 = 0;
            for (String b2 : strArr) {
                Pair<byte[], List<StringStyledSpan>> b3 = b(b2);
                this.f21068f.add(Integer.valueOf(i3));
                Object obj = b3.first;
                i3 += ((byte[]) obj).length;
                this.f21070h.add((byte[]) obj);
                this.f21071i.add((List) b3.second);
            }
            int i4 = 0;
            for (List<StringStyledSpan> next : this.f21071i) {
                for (StringStyledSpan stringStyledSpan : next) {
                    this.f21068f.add(Integer.valueOf(i3));
                    i3 += stringStyledSpan.f21075a.length;
                    this.f21070h.add(stringStyledSpan.f21075a);
                }
                this.f21069g.add(Integer.valueOf(i4));
                i4 += (next.size() * 12) + 4;
            }
            int i5 = i3 % 4;
            int i6 = i5 == 0 ? 0 : 4 - i5;
            this.f21073k = i6;
            int size = this.f21070h.size();
            this.f21064b = size;
            this.f21065c = this.f21070h.size() - strArr.length;
            boolean z2 = this.f21070h.size() - strArr.length > 0;
            if (!z2) {
                this.f21069g.clear();
                this.f21071i.clear();
            }
            int size2 = (size * 4) + 28 + (this.f21069g.size() * 4);
            this.f21066d = size2;
            int i7 = i3 + i6;
            this.f21067e = z2 ? size2 + i7 : 0;
            int i8 = size2 + i7 + (z2 ? i4 : i2);
            this.f21074l = i8;
            this.f21063a = new ResChunkHeader(1, f21061m, i8);
        }

        private Pair<byte[], List<StringStyledSpan>> b(String str) {
            return new Pair<>(this.f21072j ? ColorResourcesTableCreator.m(str) : ColorResourcesTableCreator.l(str), Collections.emptyList());
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f21074l;
        }

        /* access modifiers changed from: package-private */
        public void c(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f21063a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21064b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21065c));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21072j ? 256 : 0));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21066d));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21067e));
            for (Integer intValue : this.f21068f) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(intValue.intValue()));
            }
            for (Integer intValue2 : this.f21069g) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(intValue2.intValue()));
            }
            for (byte[] write : this.f21070h) {
                byteArrayOutputStream.write(write);
            }
            int i2 = this.f21073k;
            if (i2 > 0) {
                byteArrayOutputStream.write(new byte[i2]);
            }
            for (List<StringStyledSpan> it2 : this.f21071i) {
                for (StringStyledSpan b2 : it2) {
                    b2.b(byteArrayOutputStream);
                }
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(-1));
            }
        }

        StringPoolChunk(String... strArr) {
            this(false, strArr);
        }
    }

    private static class StringStyledSpan {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public byte[] f21075a;

        /* renamed from: b  reason: collision with root package name */
        private int f21076b;

        /* renamed from: c  reason: collision with root package name */
        private int f21077c;

        /* renamed from: d  reason: collision with root package name */
        private int f21078d;

        private StringStyledSpan() {
        }

        /* access modifiers changed from: package-private */
        public void b(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21076b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21077c));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21078d));
        }
    }

    private static class TypeChunk {

        /* renamed from: f  reason: collision with root package name */
        private static final int f21079f = -1;

        /* renamed from: g  reason: collision with root package name */
        private static final short f21080g = 84;

        /* renamed from: h  reason: collision with root package name */
        private static final byte f21081h = 64;

        /* renamed from: a  reason: collision with root package name */
        private final ResChunkHeader f21082a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21083b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f21084c;

        /* renamed from: d  reason: collision with root package name */
        private final int[] f21085d;

        /* renamed from: e  reason: collision with root package name */
        private final ResEntry[] f21086e;

        TypeChunk(List<ColorResource> list, Set<Short> set, int i2) {
            byte[] bArr = new byte[64];
            this.f21084c = bArr;
            this.f21083b = i2;
            bArr[0] = 64;
            this.f21086e = new ResEntry[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                this.f21086e[i3] = new ResEntry(i3, list.get(i3).f21036e);
            }
            this.f21085d = new int[i2];
            int i4 = 0;
            for (short s = 0; s < i2; s = (short) (s + 1)) {
                if (set.contains(Short.valueOf(s))) {
                    this.f21085d[s] = i4;
                    i4 += 16;
                } else {
                    this.f21085d[s] = -1;
                }
            }
            this.f21082a = new ResChunkHeader(ColorResourcesTableCreator.f21024d, f21080g, a());
        }

        private int b() {
            return c() + 84;
        }

        private int c() {
            return this.f21085d.length * 4;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return b() + (this.f21086e.length * 16);
        }

        /* access modifiers changed from: package-private */
        public void d(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f21082a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.f21029i, 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21083b));
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(b()));
            byteArrayOutputStream.write(this.f21084c);
            for (int d2 : this.f21085d) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(d2));
            }
            for (ResEntry a2 : this.f21086e) {
                a2.a(byteArrayOutputStream);
            }
        }
    }

    private static class TypeSpecChunk {

        /* renamed from: e  reason: collision with root package name */
        private static final short f21087e = 16;

        /* renamed from: f  reason: collision with root package name */
        private static final int f21088f = 1073741824;

        /* renamed from: a  reason: collision with root package name */
        private final ResChunkHeader f21089a;

        /* renamed from: b  reason: collision with root package name */
        private final int f21090b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f21091c;

        /* renamed from: d  reason: collision with root package name */
        private final TypeChunk f21092d;

        TypeSpecChunk(List<ColorResource> list) {
            this.f21090b = list.get(list.size() - 1).f21034c + 1;
            HashSet hashSet = new HashSet();
            for (ColorResource a2 : list) {
                hashSet.add(Short.valueOf(a2.f21034c));
            }
            this.f21091c = new int[this.f21090b];
            for (short s = 0; s < this.f21090b; s = (short) (s + 1)) {
                if (hashSet.contains(Short.valueOf(s))) {
                    this.f21091c[s] = 1073741824;
                }
            }
            this.f21089a = new ResChunkHeader(ColorResourcesTableCreator.f21025e, 16, a());
            this.f21092d = new TypeChunk(list, hashSet, this.f21090b);
        }

        private int a() {
            return (this.f21090b * 4) + 16;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return a() + this.f21092d.a();
        }

        /* access modifiers changed from: package-private */
        public void c(ByteArrayOutputStream byteArrayOutputStream) throws IOException {
            this.f21089a.a(byteArrayOutputStream);
            byteArrayOutputStream.write(new byte[]{ColorResourcesTableCreator.f21029i, 0, 0, 0});
            byteArrayOutputStream.write(ColorResourcesTableCreator.j(this.f21090b));
            for (int d2 : this.f21091c) {
                byteArrayOutputStream.write(ColorResourcesTableCreator.j(d2));
            }
            this.f21092d.d(byteArrayOutputStream);
        }
    }

    private ColorResourcesTableCreator() {
    }

    /* access modifiers changed from: private */
    public static byte[] h(char c2) {
        return new byte[]{(byte) (c2 & 255), (byte) ((c2 >> 8) & 255)};
    }

    static byte[] i(Context context, Map<Integer, Integer> map) throws IOException {
        PackageInfo packageInfo;
        if (!map.entrySet().isEmpty()) {
            PackageInfo packageInfo2 = new PackageInfo(WorkQueueKt.f29430c, context.getPackageName());
            HashMap hashMap = new HashMap();
            ColorResource colorResource = null;
            for (Map.Entry next : map.entrySet()) {
                ColorResource colorResource2 = new ColorResource(((Integer) next.getKey()).intValue(), context.getResources().getResourceName(((Integer) next.getKey()).intValue()), ((Integer) next.getValue()).intValue());
                if (context.getResources().getResourceTypeName(((Integer) next.getKey()).intValue()).equals("color")) {
                    if (colorResource2.f21032a == 1) {
                        packageInfo = f21030j;
                    } else if (colorResource2.f21032a == Byte.MAX_VALUE) {
                        packageInfo = packageInfo2;
                    } else {
                        throw new IllegalArgumentException("Not supported with unknown package id: " + colorResource2.f21032a);
                    }
                    if (!hashMap.containsKey(packageInfo)) {
                        hashMap.put(packageInfo, new ArrayList());
                    }
                    ((List) hashMap.get(packageInfo)).add(colorResource2);
                    colorResource = colorResource2;
                } else {
                    throw new IllegalArgumentException("Non color resource found: name=" + colorResource2.f21035d + ", typeId=" + Integer.toHexString(colorResource2.f21033b & 255));
                }
            }
            byte d2 = colorResource.f21033b;
            f21029i = d2;
            if (d2 != 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new ResTable(hashMap).b(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalArgumentException("No color resources found for harmonization.");
        }
        throw new IllegalArgumentException("No color resources provided for harmonization.");
    }

    /* access modifiers changed from: private */
    public static byte[] j(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)};
    }

    /* access modifiers changed from: private */
    public static byte[] k(short s) {
        return new byte[]{(byte) (s & 255), (byte) ((s >> 8) & 255)};
    }

    /* access modifiers changed from: private */
    public static byte[] l(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length * 2;
        byte[] bArr = new byte[(length + 4)];
        byte[] k2 = k((short) charArray.length);
        bArr[0] = k2[0];
        bArr[1] = k2[1];
        for (int i2 = 0; i2 < charArray.length; i2++) {
            byte[] h2 = h(charArray[i2]);
            int i3 = i2 * 2;
            bArr[i3 + 2] = h2[0];
            bArr[i3 + 3] = h2[1];
        }
        bArr[length + 2] = 0;
        bArr[length + 3] = 0;
        return bArr;
    }

    /* access modifiers changed from: private */
    public static byte[] m(String str) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        byte length = (byte) bytes.length;
        int length2 = bytes.length;
        byte[] bArr = new byte[(length2 + 3)];
        System.arraycopy(bytes, 0, bArr, 2, length);
        bArr[1] = length;
        bArr[0] = length;
        bArr[length2 + 2] = 0;
        return bArr;
    }
}
