package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

@RequiresApi(19)
class ProfileTranscoder {

    /* renamed from: a  reason: collision with root package name */
    private static final int f15112a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f15113b = 2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f15114c = 4;

    /* renamed from: d  reason: collision with root package name */
    private static final int f15115d = 6;

    /* renamed from: e  reason: collision with root package name */
    private static final int f15116e = 7;

    /* renamed from: f  reason: collision with root package name */
    static final byte[] f15117f = {112, 114, 111, 0};

    /* renamed from: g  reason: collision with root package name */
    static final byte[] f15118g = {112, 114, 109, 0};

    private ProfileTranscoder() {
    }

    private static void A(@NonNull InputStream inputStream) throws IOException {
        Encoding.h(inputStream);
        int j2 = Encoding.j(inputStream);
        if (j2 != 6 && j2 != 7) {
            while (j2 > 0) {
                Encoding.j(inputStream);
                for (int j3 = Encoding.j(inputStream); j3 > 0; j3--) {
                    Encoding.h(inputStream);
                }
                j2--;
            }
        }
    }

    static boolean B(@NonNull OutputStream outputStream, @NonNull byte[] bArr, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f15144a)) {
            N(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.f15145b)) {
            M(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.f15147d)) {
            K(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.f15146c)) {
            L(outputStream, dexProfileDataArr);
            return true;
        } else if (!Arrays.equals(bArr, ProfileVersion.f15148e)) {
            return false;
        } else {
            J(outputStream, dexProfileDataArr);
            return true;
        }
    }

    private static void C(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int[] iArr = dexProfileData.f15080h;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            Encoding.p(outputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
    }

    private static WritableFileSection D(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Encoding.p(byteArrayOutputStream, dexProfileDataArr.length);
            int i2 = 2;
            for (DexProfileData dexProfileData : dexProfileDataArr) {
                Encoding.q(byteArrayOutputStream, dexProfileData.f15075c);
                Encoding.q(byteArrayOutputStream, dexProfileData.f15076d);
                Encoding.q(byteArrayOutputStream, (long) dexProfileData.f15079g);
                String j2 = j(dexProfileData.f15073a, dexProfileData.f15074b, ProfileVersion.f15144a);
                int k2 = Encoding.k(j2);
                Encoding.p(byteArrayOutputStream, k2);
                i2 = i2 + 14 + k2;
                Encoding.n(byteArrayOutputStream, j2);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i2 == byteArray.length) {
                WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, i2, byteArray, false);
                byteArrayOutputStream.close();
                return writableFileSection;
            }
            throw Encoding.c("Expected size " + i2 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static void E(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f15117f);
        outputStream.write(bArr);
    }

    private static void F(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        I(outputStream, dexProfileData);
        C(outputStream, dexProfileData);
        H(outputStream, dexProfileData);
    }

    private static void G(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData, @NonNull String str) throws IOException {
        Encoding.p(outputStream, Encoding.k(str));
        Encoding.p(outputStream, dexProfileData.f15077e);
        Encoding.q(outputStream, (long) dexProfileData.f15078f);
        Encoding.q(outputStream, dexProfileData.f15075c);
        Encoding.q(outputStream, (long) dexProfileData.f15079g);
        Encoding.n(outputStream, str);
    }

    private static void H(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[k(dexProfileData.f15079g)];
        for (Map.Entry next : dexProfileData.f15081i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                z(bArr, 2, intValue, dexProfileData);
            }
            if ((intValue2 & 4) != 0) {
                z(bArr, 4, intValue, dexProfileData);
            }
        }
        outputStream.write(bArr);
    }

    private static void I(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int i2 = 0;
        for (Map.Entry next : dexProfileData.f15081i.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if ((((Integer) next.getValue()).intValue() & 1) != 0) {
                Encoding.p(outputStream, intValue - i2);
                Encoding.p(outputStream, 0);
                i2 = intValue;
            }
        }
    }

    private static void J(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.p(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String j2 = j(dexProfileData.f15073a, dexProfileData.f15074b, ProfileVersion.f15148e);
            Encoding.p(outputStream, Encoding.k(j2));
            Encoding.p(outputStream, dexProfileData.f15081i.size());
            Encoding.p(outputStream, dexProfileData.f15080h.length);
            Encoding.q(outputStream, dexProfileData.f15075c);
            Encoding.n(outputStream, j2);
            for (Integer intValue : dexProfileData.f15081i.keySet()) {
                Encoding.p(outputStream, intValue.intValue());
            }
            for (int p : dexProfileData.f15080h) {
                Encoding.p(outputStream, p);
            }
        }
    }

    private static void K(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.r(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String j2 = j(dexProfileData.f15073a, dexProfileData.f15074b, ProfileVersion.f15147d);
            Encoding.p(outputStream, Encoding.k(j2));
            Encoding.p(outputStream, dexProfileData.f15080h.length);
            Encoding.q(outputStream, (long) (dexProfileData.f15081i.size() * 4));
            Encoding.q(outputStream, dexProfileData.f15075c);
            Encoding.n(outputStream, j2);
            for (Integer intValue : dexProfileData.f15081i.keySet()) {
                Encoding.p(outputStream, intValue.intValue());
                Encoding.p(outputStream, 0);
            }
            for (int p : dexProfileData.f15080h) {
                Encoding.p(outputStream, p);
            }
        }
    }

    private static void L(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] b2 = b(dexProfileDataArr, ProfileVersion.f15146c);
        Encoding.r(outputStream, dexProfileDataArr.length);
        Encoding.m(outputStream, b2);
    }

    private static void M(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] b2 = b(dexProfileDataArr, ProfileVersion.f15145b);
        Encoding.r(outputStream, dexProfileDataArr.length);
        Encoding.m(outputStream, b2);
    }

    private static void N(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        O(outputStream, dexProfileDataArr);
    }

    private static void O(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(D(dexProfileDataArr));
        arrayList.add(c(dexProfileDataArr));
        arrayList.add(d(dexProfileDataArr));
        long length2 = ((long) ProfileVersion.f15144a.length) + ((long) f15117f.length) + 4 + ((long) (arrayList.size() * 16));
        Encoding.q(outputStream, (long) arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            WritableFileSection writableFileSection = (WritableFileSection) arrayList.get(i2);
            Encoding.q(outputStream, writableFileSection.f15153a.c());
            Encoding.q(outputStream, length2);
            if (writableFileSection.f15156d) {
                byte[] bArr = writableFileSection.f15155c;
                byte[] b2 = Encoding.b(bArr);
                arrayList2.add(b2);
                Encoding.q(outputStream, (long) b2.length);
                Encoding.q(outputStream, (long) bArr.length);
                length = b2.length;
            } else {
                arrayList2.add(writableFileSection.f15155c);
                Encoding.q(outputStream, (long) writableFileSection.f15155c.length);
                Encoding.q(outputStream, 0);
                length = writableFileSection.f15155c.length;
            }
            length2 += (long) length;
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            outputStream.write((byte[]) arrayList2.get(i3));
        }
    }

    private static int a(@NonNull DexProfileData dexProfileData) {
        int i2 = 0;
        for (Map.Entry<Integer, Integer> value : dexProfileData.f15081i.entrySet()) {
            i2 |= ((Integer) value.getValue()).intValue();
        }
        return i2;
    }

    @NonNull
    private static byte[] b(@NonNull DexProfileData[] dexProfileDataArr, @NonNull byte[] bArr) throws IOException {
        int i2 = 0;
        int i3 = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            i3 += Encoding.k(j(dexProfileData.f15073a, dexProfileData.f15074b, bArr)) + 16 + (dexProfileData.f15077e * 2) + dexProfileData.f15078f + k(dexProfileData.f15079g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        if (Arrays.equals(bArr, ProfileVersion.f15146c)) {
            int length = dexProfileDataArr.length;
            while (i2 < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i2];
                G(byteArrayOutputStream, dexProfileData2, j(dexProfileData2.f15073a, dexProfileData2.f15074b, bArr));
                F(byteArrayOutputStream, dexProfileData2);
                i2++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                G(byteArrayOutputStream, dexProfileData3, j(dexProfileData3.f15073a, dexProfileData3.f15074b, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (i2 < length2) {
                F(byteArrayOutputStream, dexProfileDataArr[i2]);
                i2++;
            }
        }
        if (byteArrayOutputStream.size() == i3) {
            return byteArrayOutputStream.toByteArray();
        }
        throw Encoding.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i3);
    }

    private static WritableFileSection c(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        int i3 = 0;
        while (i2 < dexProfileDataArr.length) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i2];
                Encoding.p(byteArrayOutputStream, i2);
                Encoding.p(byteArrayOutputStream, dexProfileData.f15077e);
                i3 = i3 + 4 + (dexProfileData.f15077e * 2);
                C(byteArrayOutputStream, dexProfileData);
                i2++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.CLASSES, i3, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static WritableFileSection d(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        int i3 = 0;
        while (i2 < dexProfileDataArr.length) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i2];
                int a2 = a(dexProfileData);
                byte[] e2 = e(dexProfileData);
                byte[] f2 = f(dexProfileData);
                Encoding.p(byteArrayOutputStream, i2);
                int length = e2.length + 2 + f2.length;
                Encoding.q(byteArrayOutputStream, (long) length);
                Encoding.p(byteArrayOutputStream, a2);
                byteArrayOutputStream.write(e2);
                byteArrayOutputStream.write(f2);
                i3 = i3 + 6 + length;
                i2++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i3 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.METHODS, i3, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.c("Expected size " + i3 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static byte[] e(@NonNull DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            H(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static byte[] f(@NonNull DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            I(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    private static String g(@NonNull String str, @NonNull String str2) {
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        return ":".equals(str2) ? str.replace("!", ":") : str;
    }

    @NonNull
    private static String h(@NonNull String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        return indexOf > 0 ? str.substring(indexOf + 1) : str;
    }

    @Nullable
    private static DexProfileData i(@NonNull DexProfileData[] dexProfileDataArr, @NonNull String str) {
        if (dexProfileDataArr.length <= 0) {
            return null;
        }
        String h2 = h(str);
        for (int i2 = 0; i2 < dexProfileDataArr.length; i2++) {
            if (dexProfileDataArr[i2].f15074b.equals(h2)) {
                return dexProfileDataArr[i2];
            }
        }
        return null;
    }

    @NonNull
    private static String j(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        String a2 = ProfileVersion.a(bArr);
        if (str.length() <= 0) {
            return g(str2, a2);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, a2);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + ProfileVersion.a(bArr) + str2;
    }

    private static int k(int i2) {
        return y(i2 * 2) / 8;
    }

    private static int l(int i2, int i3, int i4) {
        if (i2 == 1) {
            throw Encoding.c("HOT methods are not stored in the bitmap");
        } else if (i2 == 2) {
            return i3;
        } else {
            if (i2 == 4) {
                return i3 + i4;
            }
            throw Encoding.c("Unexpected flag: " + i2);
        }
    }

    private static int[] m(@NonNull InputStream inputStream, int i2) throws IOException {
        int[] iArr = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += Encoding.h(inputStream);
            iArr[i4] = i3;
        }
        return iArr;
    }

    private static int n(@NonNull BitSet bitSet, int i2, int i3) {
        int i4 = 2;
        if (!bitSet.get(l(2, i2, i3))) {
            i4 = 0;
        }
        return bitSet.get(l(4, i2, i3)) ? i4 | 4 : i4;
    }

    static byte[] o(@NonNull InputStream inputStream, @NonNull byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, Encoding.d(inputStream, bArr.length))) {
            return Encoding.d(inputStream, ProfileVersion.f15145b.length);
        }
        throw Encoding.c("Invalid magic");
    }

    private static void p(@NonNull InputStream inputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int available = inputStream.available() - dexProfileData.f15078f;
        int i2 = 0;
        while (inputStream.available() > available) {
            i2 += Encoding.h(inputStream);
            dexProfileData.f15081i.put(Integer.valueOf(i2), 1);
            for (int h2 = Encoding.h(inputStream); h2 > 0; h2--) {
                A(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw Encoding.c("Read too much data during profile line parse");
        }
    }

    @NonNull
    static DexProfileData[] q(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f15149f)) {
            if (!Arrays.equals(ProfileVersion.f15144a, bArr2)) {
                return r(inputStream, bArr, dexProfileDataArr);
            }
            throw Encoding.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, ProfileVersion.f15150g)) {
            return t(inputStream, bArr2, dexProfileDataArr);
        } else {
            throw Encoding.c("Unsupported meta version");
        }
    }

    @NonNull
    static DexProfileData[] r(@NonNull InputStream inputStream, @NonNull byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f15149f)) {
            int j2 = Encoding.j(inputStream);
            byte[] e2 = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e2);
                try {
                    DexProfileData[] s = s(byteArrayInputStream, j2, dexProfileDataArr);
                    byteArrayInputStream.close();
                    return s;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw Encoding.c("Content found after the end of file");
            }
        } else {
            throw Encoding.c("Unsupported meta version");
        }
        throw th;
    }

    @NonNull
    private static DexProfileData[] s(@NonNull InputStream inputStream, int i2, DexProfileData[] dexProfileDataArr) throws IOException {
        int i3 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i2 == dexProfileDataArr.length) {
            String[] strArr = new String[i2];
            int[] iArr = new int[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                int h2 = Encoding.h(inputStream);
                iArr[i4] = Encoding.h(inputStream);
                strArr[i4] = Encoding.f(inputStream, h2);
            }
            while (i3 < i2) {
                DexProfileData dexProfileData = dexProfileDataArr[i3];
                if (dexProfileData.f15074b.equals(strArr[i3])) {
                    int i5 = iArr[i3];
                    dexProfileData.f15077e = i5;
                    dexProfileData.f15080h = m(inputStream, i5);
                    i3++;
                } else {
                    throw Encoding.c("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.c("Mismatched number of dex files found in metadata");
    }

    @NonNull
    static DexProfileData[] t(@NonNull InputStream inputStream, @NonNull byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        int h2 = Encoding.h(inputStream);
        byte[] e2 = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e2);
            try {
                DexProfileData[] u = u(byteArrayInputStream, bArr, h2, dexProfileDataArr);
                byteArrayInputStream.close();
                return u;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw Encoding.c("Content found after the end of file");
        }
        throw th;
    }

    @NonNull
    private static DexProfileData[] u(@NonNull InputStream inputStream, @NonNull byte[] bArr, int i2, DexProfileData[] dexProfileDataArr) throws IOException {
        int i3 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i2 == dexProfileDataArr.length) {
            while (i3 < i2) {
                Encoding.h(inputStream);
                String f2 = Encoding.f(inputStream, Encoding.h(inputStream));
                long i4 = Encoding.i(inputStream);
                int h2 = Encoding.h(inputStream);
                DexProfileData i5 = i(dexProfileDataArr, f2);
                if (i5 != null) {
                    i5.f15076d = i4;
                    int[] m2 = m(inputStream, h2);
                    if (Arrays.equals(bArr, ProfileVersion.f15148e)) {
                        i5.f15077e = h2;
                        i5.f15080h = m2;
                    }
                    i3++;
                } else {
                    throw Encoding.c("Missing profile key: " + f2);
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.c("Mismatched number of dex files found in metadata");
    }

    private static void v(@NonNull InputStream inputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        BitSet valueOf = BitSet.valueOf(Encoding.d(inputStream, Encoding.a(dexProfileData.f15079g * 2)));
        int i2 = 0;
        while (true) {
            int i3 = dexProfileData.f15079g;
            if (i2 < i3) {
                int n2 = n(valueOf, i2, i3);
                if (n2 != 0) {
                    Integer num = dexProfileData.f15081i.get(Integer.valueOf(i2));
                    if (num == null) {
                        num = 0;
                    }
                    dexProfileData.f15081i.put(Integer.valueOf(i2), Integer.valueOf(n2 | num.intValue()));
                }
                i2++;
            } else {
                return;
            }
        }
    }

    @NonNull
    static DexProfileData[] w(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull String str) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.f15145b)) {
            int j2 = Encoding.j(inputStream);
            byte[] e2 = Encoding.e(inputStream, (int) Encoding.i(inputStream), (int) Encoding.i(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(e2);
                try {
                    DexProfileData[] x = x(byteArrayInputStream, str, j2);
                    byteArrayInputStream.close();
                    return x;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw Encoding.c("Content found after the end of file");
            }
        } else {
            throw Encoding.c("Unsupported version");
        }
        throw th;
    }

    @NonNull
    private static DexProfileData[] x(@NonNull InputStream inputStream, @NonNull String str, int i2) throws IOException {
        InputStream inputStream2 = inputStream;
        int i3 = i2;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int h2 = Encoding.h(inputStream);
            int h3 = Encoding.h(inputStream);
            long i5 = Encoding.i(inputStream);
            String str2 = str;
            int[] iArr = new int[h3];
            dexProfileDataArr[i4] = new DexProfileData(str2, Encoding.f(inputStream2, h2), Encoding.i(inputStream), 0, h3, (int) i5, (int) Encoding.i(inputStream), iArr, new TreeMap());
        }
        for (int i6 = 0; i6 < i3; i6++) {
            DexProfileData dexProfileData = dexProfileDataArr[i6];
            p(inputStream2, dexProfileData);
            dexProfileData.f15080h = m(inputStream2, dexProfileData.f15077e);
            v(inputStream2, dexProfileData);
        }
        return dexProfileDataArr;
    }

    private static int y(int i2) {
        return (i2 + 7) & -8;
    }

    private static void z(@NonNull byte[] bArr, int i2, int i3, @NonNull DexProfileData dexProfileData) {
        int l2 = l(i2, i3, dexProfileData.f15079g);
        int i4 = l2 / 8;
        bArr[i4] = (byte) ((1 << (l2 % 8)) | bArr[i4]);
    }
}
