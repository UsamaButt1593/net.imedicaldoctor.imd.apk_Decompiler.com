package okhttp3.internal.http2;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.ByteArrayOutputStream;
import okio.ByteString;

class Huffman {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f31206b = {8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, 1016, 1017, 4090, 8185, 21, 248, 2042, 1018, 1019, 249, 2043, ItemTouchHelper.Callback.f15380c, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, 1020, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, TIFFConstants.t, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f31207c = {13, Ascii.A, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.B, Ascii.H, Ascii.F, Ascii.F, Ascii.H, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.H, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, Ascii.F, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, Ascii.F, Ascii.x, Ascii.z, Ascii.x, Ascii.x, Ascii.z, Ascii.z, Ascii.z, Ascii.A, Ascii.z, Ascii.A, Ascii.A, Ascii.A, Ascii.A, Ascii.A, Ascii.B, Ascii.A, Ascii.B, Ascii.B, Ascii.z, Ascii.A, Ascii.B, Ascii.A, Ascii.A, Ascii.A, Ascii.A, Ascii.y, Ascii.z, Ascii.A, Ascii.z, Ascii.A, Ascii.A, Ascii.B, Ascii.z, Ascii.y, Ascii.x, Ascii.z, Ascii.z, Ascii.A, Ascii.A, Ascii.y, Ascii.A, Ascii.z, Ascii.z, Ascii.B, Ascii.y, Ascii.z, Ascii.A, Ascii.A, Ascii.y, Ascii.y, Ascii.z, Ascii.y, Ascii.A, Ascii.z, Ascii.A, Ascii.A, Ascii.x, Ascii.z, Ascii.z, Ascii.z, Ascii.A, Ascii.z, Ascii.z, Ascii.A, Ascii.D, Ascii.D, Ascii.x, 19, Ascii.z, Ascii.A, Ascii.z, Ascii.C, Ascii.D, Ascii.D, Ascii.D, Ascii.E, Ascii.E, Ascii.D, Ascii.B, Ascii.C, 19, Ascii.y, Ascii.D, Ascii.E, Ascii.E, Ascii.D, Ascii.E, Ascii.B, Ascii.y, Ascii.y, Ascii.D, Ascii.D, Ascii.F, Ascii.E, Ascii.E, Ascii.E, Ascii.x, Ascii.B, Ascii.x, Ascii.y, Ascii.z, Ascii.y, Ascii.y, Ascii.A, Ascii.z, Ascii.z, Ascii.C, Ascii.C, Ascii.B, Ascii.B, Ascii.D, Ascii.A, Ascii.D, Ascii.E, Ascii.D, Ascii.D, Ascii.E, Ascii.E, Ascii.E, Ascii.E, Ascii.E, Ascii.F, Ascii.E, Ascii.E, Ascii.E, Ascii.E, Ascii.E, Ascii.D};

    /* renamed from: d  reason: collision with root package name */
    private static final Huffman f31208d = new Huffman();

    /* renamed from: a  reason: collision with root package name */
    private final Node f31209a = new Node();

    private static final class Node {

        /* renamed from: a  reason: collision with root package name */
        final Node[] f31210a;

        /* renamed from: b  reason: collision with root package name */
        final int f31211b;

        /* renamed from: c  reason: collision with root package name */
        final int f31212c;

        Node() {
            this.f31210a = new Node[256];
            this.f31211b = 0;
            this.f31212c = 0;
        }

        Node(int i2, int i3) {
            this.f31210a = null;
            this.f31211b = i2;
            int i4 = i3 & 7;
            this.f31212c = i4 == 0 ? 8 : i4;
        }
    }

    private Huffman() {
        b();
    }

    private void a(int i2, int i3, byte b2) {
        Node node = new Node(i2, b2);
        Node node2 = this.f31209a;
        while (b2 > 8) {
            b2 = (byte) (b2 - 8);
            int i4 = (i3 >>> b2) & 255;
            Node[] nodeArr = node2.f31210a;
            if (nodeArr != null) {
                if (nodeArr[i4] == null) {
                    nodeArr[i4] = new Node();
                }
                node2 = node2.f31210a[i4];
            } else {
                throw new IllegalStateException("invalid dictionary: prefix not unique");
            }
        }
        int i5 = 8 - b2;
        int i6 = (i3 << i5) & 255;
        int i7 = 1 << i5;
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            node2.f31210a[i8] = node;
        }
    }

    private void b() {
        int i2 = 0;
        while (true) {
            byte[] bArr = f31207c;
            if (i2 < bArr.length) {
                a(i2, f31206b[i2], bArr[i2]);
                i2++;
            } else {
                return;
            }
        }
    }

    public static Huffman f() {
        return f31208d;
    }

    /* access modifiers changed from: package-private */
    public byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Node node = this.f31209a;
        byte b2 = 0;
        int i2 = 0;
        for (byte b3 : bArr) {
            b2 = (b2 << 8) | (b3 & 255);
            i2 += 8;
            while (i2 >= 8) {
                node = node.f31210a[(b2 >>> (i2 - 8)) & 255];
                if (node.f31210a == null) {
                    byteArrayOutputStream.write(node.f31211b);
                    i2 -= node.f31212c;
                    node = this.f31209a;
                } else {
                    i2 -= 8;
                }
            }
        }
        while (i2 > 0) {
            Node node2 = node.f31210a[(b2 << (8 - i2)) & 255];
            if (node2.f31210a != null || node2.f31212c > i2) {
                break;
            }
            byteArrayOutputStream.write(node2.f31211b);
            i2 -= node2.f31212c;
            node = this.f31209a;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(okio.ByteString r8, okio.BufferedSink r9) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x0004:
            int r4 = r8.m0()
            r5 = 255(0xff, float:3.57E-43)
            if (r2 >= r4) goto L_0x002d
            byte r4 = r8.q(r2)
            r4 = r4 & r5
            int[] r5 = f31206b
            r5 = r5[r4]
            byte[] r6 = f31207c
            byte r4 = r6[r4]
            long r0 = r0 << r4
            long r5 = (long) r5
            long r0 = r0 | r5
            int r3 = r3 + r4
        L_0x001d:
            r4 = 8
            if (r3 < r4) goto L_0x002a
            int r3 = r3 + -8
            long r4 = r0 >> r3
            int r5 = (int) r4
            r9.writeByte(r5)
            goto L_0x001d
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x0004
        L_0x002d:
            if (r3 <= 0) goto L_0x003a
            int r8 = 8 - r3
            long r0 = r0 << r8
            int r8 = r5 >>> r3
            long r2 = (long) r8
            long r0 = r0 | r2
            int r8 = (int) r0
            r9.writeByte(r8)
        L_0x003a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Huffman.d(okio.ByteString, okio.BufferedSink):void");
    }

    /* access modifiers changed from: package-private */
    public int e(ByteString byteString) {
        long j2 = 0;
        for (int i2 = 0; i2 < byteString.m0(); i2++) {
            j2 += (long) f31207c[byteString.q(i2) & 255];
        }
        return (int) ((j2 + 7) >> 3);
    }
}
