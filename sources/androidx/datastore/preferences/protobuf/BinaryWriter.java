package androidx.datastore.preferences.protobuf;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Utf8;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlinx.coroutines.scheduling.WorkQueueKt;

abstract class BinaryWriter extends ByteOutput implements Writer {

    /* renamed from: e  reason: collision with root package name */
    public static final int f6990e = 4096;

    /* renamed from: f  reason: collision with root package name */
    private static final int f6991f = 1;

    /* renamed from: g  reason: collision with root package name */
    private static final int f6992g = 2;

    /* renamed from: a  reason: collision with root package name */
    private final BufferAllocator f6993a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6994b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayDeque<AllocatedBuffer> f6995c;

    /* renamed from: d  reason: collision with root package name */
    int f6996d;

    /* renamed from: androidx.datastore.preferences.protobuf.BinaryWriter$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6997a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6997a = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = f6997a     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryWriter.AnonymousClass1.<clinit>():void");
        }
    }

    private static final class SafeDirectWriter extends BinaryWriter {

        /* renamed from: h  reason: collision with root package name */
        private ByteBuffer f6998h;

        /* renamed from: i  reason: collision with root package name */
        private int f6999i;

        /* renamed from: j  reason: collision with root package name */
        private int f7000j;

        SafeDirectWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, (AnonymousClass1) null);
            Z0();
        }

        private int Y0() {
            return this.f6999i - this.f7000j;
        }

        private void Z0() {
            b1(f0());
        }

        private void a1(int i2) {
            b1(g0(i2));
        }

        private void b1(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.d()) {
                ByteBuffer f2 = allocatedBuffer.f();
                if (f2.isDirect()) {
                    b0();
                    this.f6995c.addFirst(allocatedBuffer);
                    this.f6998h = f2;
                    f2.limit(f2.capacity());
                    this.f6998h.position(0);
                    this.f6998h.order(ByteOrder.LITTLE_ENDIAN);
                    int limit = this.f6998h.limit() - 1;
                    this.f6999i = limit;
                    this.f7000j = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private int c1() {
            return this.f7000j + 1;
        }

        private void d1(int i2) {
            ByteBuffer byteBuffer = this.f6998h;
            int i3 = this.f7000j;
            this.f7000j = i3 - 1;
            byteBuffer.put(i3, (byte) (i2 >>> 28));
            int i4 = this.f7000j;
            this.f7000j = i4 - 4;
            this.f6998h.putInt(i4 - 3, (i2 & WorkQueueKt.f29430c) | 128 | ((((i2 >>> 21) & WorkQueueKt.f29430c) | 128) << 24) | ((((i2 >>> 14) & WorkQueueKt.f29430c) | 128) << 16) | ((((i2 >>> 7) & WorkQueueKt.f29430c) | 128) << 8));
        }

        private void e1(int i2) {
            int i3 = this.f7000j;
            this.f7000j = i3 - 4;
            this.f6998h.putInt(i3 - 3, (i2 & WorkQueueKt.f29430c) | 128 | ((266338304 & i2) << 3) | (((2080768 & i2) | 2097152) << 2) | (((i2 & 16256) | 16384) << 1));
        }

        private void f1(int i2) {
            ByteBuffer byteBuffer = this.f6998h;
            int i3 = this.f7000j;
            this.f7000j = i3 - 1;
            byteBuffer.put(i3, (byte) i2);
        }

        private void g1(int i2) {
            int i3 = this.f7000j - 3;
            this.f7000j = i3;
            this.f6998h.putInt(i3, (((i2 & WorkQueueKt.f29430c) | 128) << 8) | ((2080768 & i2) << 10) | (((i2 & 16256) | 16384) << 9));
        }

        private void h1(int i2) {
            int i3 = this.f7000j;
            this.f7000j = i3 - 2;
            this.f6998h.putShort(i3 - 1, (short) ((i2 & WorkQueueKt.f29430c) | 128 | ((i2 & 16256) << 1)));
        }

        private void i1(long j2) {
            int i2 = this.f7000j;
            this.f7000j = i2 - 8;
            this.f6998h.putLong(i2 - 7, (j2 & 127) | 128 | ((71494644084506624L & j2) << 7) | (((558551906910208L & j2) | 562949953421312L) << 6) | (((4363686772736L & j2) | 4398046511104L) << 5) | (((34091302912L & j2) | 34359738368L) << 4) | (((266338304 & j2) | 268435456) << 3) | (((2080768 & j2) | PlaybackStateCompat.A3) << 2) | (((16256 & j2) | PlaybackStateCompat.t3) << 1));
        }

        private void j1(long j2) {
            int i2 = this.f7000j;
            this.f7000j = i2 - 8;
            this.f6998h.putLong(i2 - 7, (j2 & 127) | 128 | (((71494644084506624L & j2) | 72057594037927936L) << 7) | (((558551906910208L & j2) | 562949953421312L) << 6) | (((4363686772736L & j2) | 4398046511104L) << 5) | (((34091302912L & j2) | 34359738368L) << 4) | (((266338304 & j2) | 268435456) << 3) | (((2080768 & j2) | PlaybackStateCompat.A3) << 2) | (((16256 & j2) | PlaybackStateCompat.t3) << 1));
        }

        private void k1(long j2) {
            int i2 = this.f7000j;
            this.f7000j = i2 - 5;
            this.f6998h.putLong(i2 - 7, (((j2 & 127) | 128) << 24) | ((34091302912L & j2) << 28) | (((266338304 & j2) | 268435456) << 27) | (((2080768 & j2) | PlaybackStateCompat.A3) << 26) | (((16256 & j2) | PlaybackStateCompat.t3) << 25));
        }

        private void l1(long j2) {
            e1((int) j2);
        }

        private void m1(long j2) {
            ByteBuffer byteBuffer = this.f6998h;
            int i2 = this.f7000j;
            this.f7000j = i2 - 1;
            byteBuffer.put(i2, (byte) ((int) (j2 >>> 56)));
            j1(j2 & 72057594037927935L);
        }

        private void n1(long j2) {
            f1((int) j2);
        }

        private void o1(long j2) {
            int i2 = this.f7000j - 7;
            this.f7000j = i2;
            this.f6998h.putLong(i2, (((j2 & 127) | 128) << 8) | ((558551906910208L & j2) << 14) | (((4363686772736L & j2) | 4398046511104L) << 13) | (((34091302912L & j2) | 34359738368L) << 12) | (((266338304 & j2) | 268435456) << 11) | (((2080768 & j2) | PlaybackStateCompat.A3) << 10) | (((16256 & j2) | PlaybackStateCompat.t3) << 9));
        }

        private void p1(long j2) {
            int i2 = this.f7000j;
            this.f7000j = i2 - 6;
            this.f6998h.putLong(i2 - 7, (((j2 & 127) | 128) << 16) | ((4363686772736L & j2) << 21) | (((34091302912L & j2) | 34359738368L) << 20) | (((266338304 & j2) | 268435456) << 19) | (((2080768 & j2) | PlaybackStateCompat.A3) << 18) | (((16256 & j2) | PlaybackStateCompat.t3) << 17));
        }

        private void q1(long j2) {
            ByteBuffer byteBuffer = this.f6998h;
            int i2 = this.f7000j;
            this.f7000j = i2 - 1;
            byteBuffer.put(i2, (byte) ((int) (j2 >>> 63)));
            ByteBuffer byteBuffer2 = this.f6998h;
            int i3 = this.f7000j;
            this.f7000j = i3 - 1;
            byteBuffer2.put(i3, (byte) ((int) (((j2 >>> 56) & 127) | 128)));
            j1(j2 & 72057594037927935L);
        }

        private void r1(long j2) {
            g1((int) j2);
        }

        private void s1(long j2) {
            h1((int) j2);
        }

        /* access modifiers changed from: package-private */
        public void A0(long j2) {
            int i2 = this.f7000j;
            this.f7000j = i2 - 8;
            this.f6998h.putLong(i2 - 7, j2);
        }

        public void C(int i2, Object obj, Schema schema) throws IOException {
            int c0 = c0();
            schema.e(obj, this);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        public void E(int i2, Object obj) throws IOException {
            R0(i2, 4);
            Protobuf.a().k(obj, this);
            R0(i2, 3);
        }

        /* access modifiers changed from: package-private */
        public void F0(int i2) {
            if (i2 >= 0) {
                W0(i2);
            } else {
                X0((long) i2);
            }
        }

        public void H(int i2, long j2) {
            r0(15);
            N0(j2);
            R0(i2, 0);
        }

        public void J(int i2) {
            R0(i2, 4);
        }

        /* access modifiers changed from: package-private */
        public void K0(int i2) {
            W0(CodedOutputStream.c1(i2));
        }

        /* access modifiers changed from: package-private */
        public void N0(long j2) {
            X0(CodedOutputStream.d1(j2));
        }

        public void Q(int i2, int i3) {
            r0(10);
            K0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void Q0(String str) {
            int i2;
            ByteBuffer byteBuffer;
            int i3;
            int i4;
            int i5;
            int i6;
            char charAt;
            r0(str.length());
            int length = str.length() - 1;
            this.f7000j -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.f6998h.put(this.f7000j + length, (byte) charAt);
                length--;
            }
            if (length == -1) {
                this.f7000j--;
                return;
            }
            this.f7000j += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 >= 128 || (i6 = this.f7000j) < 0) {
                    if (charAt2 < 2048 && (i5 = this.f7000j) > 0) {
                        ByteBuffer byteBuffer2 = this.f6998h;
                        this.f7000j = i5 - 1;
                        byteBuffer2.put(i5, (byte) ((charAt2 & '?') | 128));
                        byteBuffer = this.f6998h;
                        i2 = this.f7000j;
                        this.f7000j = i2 - 1;
                        i3 = (charAt2 >>> 6) | 960;
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && (i4 = this.f7000j) > 1) {
                        ByteBuffer byteBuffer3 = this.f6998h;
                        this.f7000j = i4 - 1;
                        byteBuffer3.put(i4, (byte) ((charAt2 & '?') | 128));
                        ByteBuffer byteBuffer4 = this.f6998h;
                        int i7 = this.f7000j;
                        this.f7000j = i7 - 1;
                        byteBuffer4.put(i7, (byte) (((charAt2 >>> 6) & 63) | 128));
                        byteBuffer = this.f6998h;
                        i2 = this.f7000j;
                        this.f7000j = i2 - 1;
                        i3 = (charAt2 >>> 12) | 480;
                    } else if (this.f7000j > 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                ByteBuffer byteBuffer5 = this.f6998h;
                                int i8 = this.f7000j;
                                this.f7000j = i8 - 1;
                                byteBuffer5.put(i8, (byte) ((codePoint & 63) | 128));
                                ByteBuffer byteBuffer6 = this.f6998h;
                                int i9 = this.f7000j;
                                this.f7000j = i9 - 1;
                                byteBuffer6.put(i9, (byte) (((codePoint >>> 6) & 63) | 128));
                                ByteBuffer byteBuffer7 = this.f6998h;
                                int i10 = this.f7000j;
                                this.f7000j = i10 - 1;
                                byteBuffer7.put(i10, (byte) (((codePoint >>> 12) & 63) | 128));
                                byteBuffer = this.f6998h;
                                i2 = this.f7000j;
                                this.f7000j = i2 - 1;
                                i3 = (codePoint >>> 18) | PsExtractor.A;
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    } else {
                        r0(length);
                        length++;
                    }
                    byteBuffer.put(i2, (byte) i3);
                } else {
                    ByteBuffer byteBuffer8 = this.f6998h;
                    this.f7000j = i6 - 1;
                    byteBuffer8.put(i6, (byte) charAt2);
                }
                length--;
            }
        }

        /* access modifiers changed from: package-private */
        public void R0(int i2, int i3) {
            W0(WireFormat.c(i2, i3));
        }

        public void S(int i2, Object obj, Schema schema) throws IOException {
            R0(i2, 4);
            schema.e(obj, this);
            R0(i2, 3);
        }

        public void T(byte b2) {
            ByteBuffer byteBuffer = this.f6998h;
            int i2 = this.f7000j;
            this.f7000j = i2 - 1;
            byteBuffer.put(i2, b2);
        }

        public void U(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (c1() < remaining) {
                a1(remaining);
            }
            int i2 = this.f7000j - remaining;
            this.f7000j = i2;
            this.f6998h.position(i2 + 1);
            this.f6998h.put(byteBuffer);
        }

        public void V(byte[] bArr, int i2, int i3) {
            if (c1() < i3) {
                a1(i3);
            }
            int i4 = this.f7000j - i3;
            this.f7000j = i4;
            this.f6998h.position(i4 + 1);
            this.f6998h.put(bArr, i2, i3);
        }

        public void W(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (c1() < remaining) {
                this.f6996d += remaining;
                this.f6995c.addFirst(AllocatedBuffer.j(byteBuffer));
                Z0();
                return;
            }
            int i2 = this.f7000j - remaining;
            this.f7000j = i2;
            this.f6998h.position(i2 + 1);
            this.f6998h.put(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public void W0(int i2) {
            if ((i2 & -128) == 0) {
                f1(i2);
            } else if ((i2 & -16384) == 0) {
                h1(i2);
            } else if ((-2097152 & i2) == 0) {
                g1(i2);
            } else if ((-268435456 & i2) == 0) {
                e1(i2);
            } else {
                d1(i2);
            }
        }

        public void X(byte[] bArr, int i2, int i3) {
            if (c1() < i3) {
                this.f6996d += i3;
                this.f6995c.addFirst(AllocatedBuffer.l(bArr, i2, i3));
                Z0();
                return;
            }
            int i4 = this.f7000j - i3;
            this.f7000j = i4;
            this.f6998h.position(i4 + 1);
            this.f6998h.put(bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public void X0(long j2) {
            switch (BinaryWriter.a0(j2)) {
                case 1:
                    n1(j2);
                    return;
                case 2:
                    s1(j2);
                    return;
                case 3:
                    r1(j2);
                    return;
                case 4:
                    l1(j2);
                    return;
                case 5:
                    k1(j2);
                    return;
                case 6:
                    p1(j2);
                    return;
                case 7:
                    o1(j2);
                    return;
                case 8:
                    i1(j2);
                    return;
                case 9:
                    m1(j2);
                    return;
                case 10:
                    q1(j2);
                    return;
                default:
                    return;
            }
        }

        public void b(int i2, int i3) {
            r0(10);
            W0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void b0() {
            if (this.f6998h != null) {
                this.f6996d += Y0();
                this.f6998h.position(this.f7000j + 1);
                this.f6998h = null;
                this.f7000j = 0;
                this.f6999i = 0;
            }
        }

        public int c0() {
            return this.f6996d + Y0();
        }

        public void d(int i2, int i3) {
            r0(9);
            x0(i3);
            R0(i2, 5);
        }

        public void i(int i2, long j2) {
            r0(13);
            A0(j2);
            R0(i2, 1);
        }

        public void o(int i2, String str) {
            int c0 = c0();
            Q0(str);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        public void p(int i2, long j2) {
            r0(15);
            X0(j2);
            R0(i2, 0);
        }

        public void q(int i2, Object obj) throws IOException {
            int c0 = c0();
            Protobuf.a().k(obj, this);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        /* access modifiers changed from: package-private */
        public void r0(int i2) {
            if (c1() < i2) {
                a1(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void s0(boolean z) {
            T(z ? (byte) 1 : 0);
        }

        public void t(int i2, boolean z) {
            r0(6);
            T(z ? (byte) 1 : 0);
            R0(i2, 0);
        }

        public void v(int i2) {
            R0(i2, 3);
        }

        public void w(int i2, int i3) {
            r0(15);
            F0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void x0(int i2) {
            int i3 = this.f7000j;
            this.f7000j = i3 - 4;
            this.f6998h.putInt(i3 - 3, i2);
        }

        public void z(int i2, ByteString byteString) {
            try {
                byteString.A0(this);
                r0(10);
                W0(byteString.size());
                R0(i2, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static final class SafeHeapWriter extends BinaryWriter {

        /* renamed from: h  reason: collision with root package name */
        private AllocatedBuffer f7001h;

        /* renamed from: i  reason: collision with root package name */
        private byte[] f7002i;

        /* renamed from: j  reason: collision with root package name */
        private int f7003j;

        /* renamed from: k  reason: collision with root package name */
        private int f7004k;

        /* renamed from: l  reason: collision with root package name */
        private int f7005l;

        /* renamed from: m  reason: collision with root package name */
        private int f7006m;

        /* renamed from: n  reason: collision with root package name */
        private int f7007n;

        SafeHeapWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, (AnonymousClass1) null);
            Z0();
        }

        private void Z0() {
            b1(j0());
        }

        private void a1(int i2) {
            b1(k0(i2));
        }

        private void b1(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.c()) {
                b0();
                this.f6995c.addFirst(allocatedBuffer);
                this.f7001h = allocatedBuffer;
                this.f7002i = allocatedBuffer.a();
                int b2 = allocatedBuffer.b();
                this.f7004k = allocatedBuffer.e() + b2;
                int g2 = b2 + allocatedBuffer.g();
                this.f7003j = g2;
                this.f7005l = g2 - 1;
                int i2 = this.f7004k - 1;
                this.f7006m = i2;
                this.f7007n = i2;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void d1(int i2) {
            byte[] bArr = this.f7002i;
            int i3 = this.f7007n;
            int i4 = i3 - 1;
            this.f7007n = i4;
            bArr[i3] = (byte) (i2 >>> 28);
            int i5 = i3 - 2;
            this.f7007n = i5;
            bArr[i4] = (byte) (((i2 >>> 21) & WorkQueueKt.f29430c) | 128);
            int i6 = i3 - 3;
            this.f7007n = i6;
            bArr[i5] = (byte) (((i2 >>> 14) & WorkQueueKt.f29430c) | 128);
            int i7 = i3 - 4;
            this.f7007n = i7;
            bArr[i6] = (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128);
            this.f7007n = i3 - 5;
            bArr[i7] = (byte) ((i2 & WorkQueueKt.f29430c) | 128);
        }

        private void e1(int i2) {
            byte[] bArr = this.f7002i;
            int i3 = this.f7007n;
            int i4 = i3 - 1;
            this.f7007n = i4;
            bArr[i3] = (byte) (i2 >>> 21);
            int i5 = i3 - 2;
            this.f7007n = i5;
            bArr[i4] = (byte) (((i2 >>> 14) & WorkQueueKt.f29430c) | 128);
            int i6 = i3 - 3;
            this.f7007n = i6;
            bArr[i5] = (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128);
            this.f7007n = i3 - 4;
            bArr[i6] = (byte) ((i2 & WorkQueueKt.f29430c) | 128);
        }

        private void f1(int i2) {
            byte[] bArr = this.f7002i;
            int i3 = this.f7007n;
            this.f7007n = i3 - 1;
            bArr[i3] = (byte) i2;
        }

        private void g1(int i2) {
            byte[] bArr = this.f7002i;
            int i3 = this.f7007n;
            int i4 = i3 - 1;
            this.f7007n = i4;
            bArr[i3] = (byte) (i2 >>> 14);
            int i5 = i3 - 2;
            this.f7007n = i5;
            bArr[i4] = (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128);
            this.f7007n = i3 - 3;
            bArr[i5] = (byte) ((i2 & WorkQueueKt.f29430c) | 128);
        }

        private void h1(int i2) {
            byte[] bArr = this.f7002i;
            int i3 = this.f7007n;
            int i4 = i3 - 1;
            this.f7007n = i4;
            bArr[i3] = (byte) (i2 >>> 7);
            this.f7007n = i3 - 2;
            bArr[i4] = (byte) ((i2 & WorkQueueKt.f29430c) | 128);
        }

        private void i1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) ((int) (j2 >>> 49));
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) ((int) (((j2 >>> 42) & 127) | 128));
            int i5 = i2 - 3;
            this.f7007n = i5;
            bArr[i4] = (byte) ((int) (((j2 >>> 35) & 127) | 128));
            int i6 = i2 - 4;
            this.f7007n = i6;
            bArr[i5] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            int i7 = i2 - 5;
            this.f7007n = i7;
            bArr[i6] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            int i8 = i2 - 6;
            this.f7007n = i8;
            bArr[i7] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            int i9 = i2 - 7;
            this.f7007n = i9;
            bArr[i8] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.f7007n = i2 - 8;
            bArr[i9] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void j1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) ((int) (j2 >>> 28));
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            int i5 = i2 - 3;
            this.f7007n = i5;
            bArr[i4] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            int i6 = i2 - 4;
            this.f7007n = i6;
            bArr[i5] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.f7007n = i2 - 5;
            bArr[i6] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void k1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) ((int) (j2 >>> 21));
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            int i5 = i2 - 3;
            this.f7007n = i5;
            bArr[i4] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.f7007n = i2 - 4;
            bArr[i5] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void l1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) ((int) (j2 >>> 56));
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) ((int) (((j2 >>> 49) & 127) | 128));
            int i5 = i2 - 3;
            this.f7007n = i5;
            bArr[i4] = (byte) ((int) (((j2 >>> 42) & 127) | 128));
            int i6 = i2 - 4;
            this.f7007n = i6;
            bArr[i5] = (byte) ((int) (((j2 >>> 35) & 127) | 128));
            int i7 = i2 - 5;
            this.f7007n = i7;
            bArr[i6] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            int i8 = i2 - 6;
            this.f7007n = i8;
            bArr[i7] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            int i9 = i2 - 7;
            this.f7007n = i9;
            bArr[i8] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            int i10 = i2 - 8;
            this.f7007n = i10;
            bArr[i9] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.f7007n = i2 - 9;
            bArr[i10] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void m1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            this.f7007n = i2 - 1;
            bArr[i2] = (byte) ((int) j2);
        }

        private void n1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) ((int) (j2 >>> 42));
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) ((int) (((j2 >>> 35) & 127) | 128));
            int i5 = i2 - 3;
            this.f7007n = i5;
            bArr[i4] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            int i6 = i2 - 4;
            this.f7007n = i6;
            bArr[i5] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            int i7 = i2 - 5;
            this.f7007n = i7;
            bArr[i6] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            int i8 = i2 - 6;
            this.f7007n = i8;
            bArr[i7] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.f7007n = i2 - 7;
            bArr[i8] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void o1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) ((int) (j2 >>> 35));
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            int i5 = i2 - 3;
            this.f7007n = i5;
            bArr[i4] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            int i6 = i2 - 4;
            this.f7007n = i6;
            bArr[i5] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            int i7 = i2 - 5;
            this.f7007n = i7;
            bArr[i6] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.f7007n = i2 - 6;
            bArr[i7] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void p1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) ((int) (j2 >>> 63));
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) ((int) (((j2 >>> 56) & 127) | 128));
            int i5 = i2 - 3;
            this.f7007n = i5;
            bArr[i4] = (byte) ((int) (((j2 >>> 49) & 127) | 128));
            int i6 = i2 - 4;
            this.f7007n = i6;
            bArr[i5] = (byte) ((int) (((j2 >>> 42) & 127) | 128));
            int i7 = i2 - 5;
            this.f7007n = i7;
            bArr[i6] = (byte) ((int) (((j2 >>> 35) & 127) | 128));
            int i8 = i2 - 6;
            this.f7007n = i8;
            bArr[i7] = (byte) ((int) (((j2 >>> 28) & 127) | 128));
            int i9 = i2 - 7;
            this.f7007n = i9;
            bArr[i8] = (byte) ((int) (((j2 >>> 21) & 127) | 128));
            int i10 = i2 - 8;
            this.f7007n = i10;
            bArr[i9] = (byte) ((int) (((j2 >>> 14) & 127) | 128));
            int i11 = i2 - 9;
            this.f7007n = i11;
            bArr[i10] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.f7007n = i2 - 10;
            bArr[i11] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void q1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) (((int) j2) >>> 14);
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) ((int) (((j2 >>> 7) & 127) | 128));
            this.f7007n = i2 - 3;
            bArr[i4] = (byte) ((int) ((j2 & 127) | 128));
        }

        private void r1(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) ((int) (j2 >>> 7));
            this.f7007n = i2 - 2;
            bArr[i3] = (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128);
        }

        /* access modifiers changed from: package-private */
        public void A0(long j2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            int i3 = i2 - 1;
            this.f7007n = i3;
            bArr[i2] = (byte) (((int) (j2 >> 56)) & 255);
            int i4 = i2 - 2;
            this.f7007n = i4;
            bArr[i3] = (byte) (((int) (j2 >> 48)) & 255);
            int i5 = i2 - 3;
            this.f7007n = i5;
            bArr[i4] = (byte) (((int) (j2 >> 40)) & 255);
            int i6 = i2 - 4;
            this.f7007n = i6;
            bArr[i5] = (byte) (((int) (j2 >> 32)) & 255);
            int i7 = i2 - 5;
            this.f7007n = i7;
            bArr[i6] = (byte) (((int) (j2 >> 24)) & 255);
            int i8 = i2 - 6;
            this.f7007n = i8;
            bArr[i7] = (byte) (((int) (j2 >> 16)) & 255);
            int i9 = i2 - 7;
            this.f7007n = i9;
            bArr[i8] = (byte) (((int) (j2 >> 8)) & 255);
            this.f7007n = i2 - 8;
            bArr[i9] = (byte) (((int) j2) & 255);
        }

        public void C(int i2, Object obj, Schema schema) throws IOException {
            int c0 = c0();
            schema.e(obj, this);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        public void E(int i2, Object obj) throws IOException {
            R0(i2, 4);
            Protobuf.a().k(obj, this);
            R0(i2, 3);
        }

        /* access modifiers changed from: package-private */
        public void F0(int i2) {
            if (i2 >= 0) {
                W0(i2);
            } else {
                X0((long) i2);
            }
        }

        public void H(int i2, long j2) throws IOException {
            r0(15);
            N0(j2);
            R0(i2, 0);
        }

        public void J(int i2) {
            R0(i2, 4);
        }

        /* access modifiers changed from: package-private */
        public void K0(int i2) {
            W0(CodedOutputStream.c1(i2));
        }

        /* access modifiers changed from: package-private */
        public void N0(long j2) {
            X0(CodedOutputStream.d1(j2));
        }

        public void Q(int i2, int i3) throws IOException {
            r0(10);
            K0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void Q0(String str) {
            int i2;
            int i3;
            int i4;
            char charAt;
            r0(str.length());
            int length = str.length() - 1;
            this.f7007n -= length;
            while (length >= 0 && (charAt = str.charAt(length)) < 128) {
                this.f7002i[this.f7007n + length] = (byte) charAt;
                length--;
            }
            if (length == -1) {
                this.f7007n--;
                return;
            }
            this.f7007n += length;
            while (length >= 0) {
                char charAt2 = str.charAt(length);
                if (charAt2 < 128 && (i4 = this.f7007n) > this.f7005l) {
                    byte[] bArr = this.f7002i;
                    this.f7007n = i4 - 1;
                    bArr[i4] = (byte) charAt2;
                } else if (charAt2 < 2048 && (i3 = this.f7007n) > this.f7003j) {
                    byte[] bArr2 = this.f7002i;
                    int i5 = i3 - 1;
                    this.f7007n = i5;
                    bArr2[i3] = (byte) ((charAt2 & '?') | 128);
                    this.f7007n = i3 - 2;
                    bArr2[i5] = (byte) ((charAt2 >>> 6) | 960);
                } else if ((charAt2 < 55296 || 57343 < charAt2) && (i2 = this.f7007n) > this.f7003j + 1) {
                    byte[] bArr3 = this.f7002i;
                    int i6 = i2 - 1;
                    this.f7007n = i6;
                    bArr3[i2] = (byte) ((charAt2 & '?') | 128);
                    int i7 = i2 - 2;
                    this.f7007n = i7;
                    bArr3[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    this.f7007n = i2 - 3;
                    bArr3[i7] = (byte) ((charAt2 >>> 12) | 480);
                } else if (this.f7007n > this.f7003j + 2) {
                    if (length != 0) {
                        char charAt3 = str.charAt(length - 1);
                        if (Character.isSurrogatePair(charAt3, charAt2)) {
                            length--;
                            int codePoint = Character.toCodePoint(charAt3, charAt2);
                            byte[] bArr4 = this.f7002i;
                            int i8 = this.f7007n;
                            int i9 = i8 - 1;
                            this.f7007n = i9;
                            bArr4[i8] = (byte) ((codePoint & 63) | 128);
                            int i10 = i8 - 2;
                            this.f7007n = i10;
                            bArr4[i9] = (byte) (((codePoint >>> 6) & 63) | 128);
                            int i11 = i8 - 3;
                            this.f7007n = i11;
                            bArr4[i10] = (byte) (((codePoint >>> 12) & 63) | 128);
                            this.f7007n = i8 - 4;
                            bArr4[i11] = (byte) ((codePoint >>> 18) | PsExtractor.A);
                        }
                    }
                    throw new Utf8.UnpairedSurrogateException(length - 1, length);
                } else {
                    r0(length);
                    length++;
                }
                length--;
            }
        }

        /* access modifiers changed from: package-private */
        public void R0(int i2, int i3) {
            W0(WireFormat.c(i2, i3));
        }

        public void S(int i2, Object obj, Schema schema) throws IOException {
            R0(i2, 4);
            schema.e(obj, this);
            R0(i2, 3);
        }

        public void T(byte b2) {
            byte[] bArr = this.f7002i;
            int i2 = this.f7007n;
            this.f7007n = i2 - 1;
            bArr[i2] = b2;
        }

        public void U(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (c1() < remaining) {
                a1(remaining);
            }
            int i2 = this.f7007n - remaining;
            this.f7007n = i2;
            byteBuffer.get(this.f7002i, i2 + 1, remaining);
        }

        public void V(byte[] bArr, int i2, int i3) {
            if (c1() < i3) {
                a1(i3);
            }
            int i4 = this.f7007n - i3;
            this.f7007n = i4;
            System.arraycopy(bArr, i2, this.f7002i, i4 + 1, i3);
        }

        public void W(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (c1() < remaining) {
                this.f6996d += remaining;
                this.f6995c.addFirst(AllocatedBuffer.j(byteBuffer));
                Z0();
            }
            int i2 = this.f7007n - remaining;
            this.f7007n = i2;
            byteBuffer.get(this.f7002i, i2 + 1, remaining);
        }

        /* access modifiers changed from: package-private */
        public void W0(int i2) {
            if ((i2 & -128) == 0) {
                f1(i2);
            } else if ((i2 & -16384) == 0) {
                h1(i2);
            } else if ((-2097152 & i2) == 0) {
                g1(i2);
            } else if ((-268435456 & i2) == 0) {
                e1(i2);
            } else {
                d1(i2);
            }
        }

        public void X(byte[] bArr, int i2, int i3) {
            if (c1() < i3) {
                this.f6996d += i3;
                this.f6995c.addFirst(AllocatedBuffer.l(bArr, i2, i3));
                Z0();
                return;
            }
            int i4 = this.f7007n - i3;
            this.f7007n = i4;
            System.arraycopy(bArr, i2, this.f7002i, i4 + 1, i3);
        }

        /* access modifiers changed from: package-private */
        public void X0(long j2) {
            switch (BinaryWriter.a0(j2)) {
                case 1:
                    m1(j2);
                    return;
                case 2:
                    r1(j2);
                    return;
                case 3:
                    q1(j2);
                    return;
                case 4:
                    k1(j2);
                    return;
                case 5:
                    j1(j2);
                    return;
                case 6:
                    o1(j2);
                    return;
                case 7:
                    n1(j2);
                    return;
                case 8:
                    i1(j2);
                    return;
                case 9:
                    l1(j2);
                    return;
                case 10:
                    p1(j2);
                    return;
                default:
                    return;
            }
        }

        /* access modifiers changed from: package-private */
        public int Y0() {
            return this.f7006m - this.f7007n;
        }

        public void b(int i2, int i3) throws IOException {
            r0(10);
            W0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void b0() {
            if (this.f7001h != null) {
                this.f6996d += Y0();
                AllocatedBuffer allocatedBuffer = this.f7001h;
                allocatedBuffer.h((this.f7007n - allocatedBuffer.b()) + 1);
                this.f7001h = null;
                this.f7007n = 0;
                this.f7006m = 0;
            }
        }

        public int c0() {
            return this.f6996d + Y0();
        }

        /* access modifiers changed from: package-private */
        public int c1() {
            return this.f7007n - this.f7005l;
        }

        public void d(int i2, int i3) throws IOException {
            r0(9);
            x0(i3);
            R0(i2, 5);
        }

        public void i(int i2, long j2) throws IOException {
            r0(13);
            A0(j2);
            R0(i2, 1);
        }

        public void o(int i2, String str) throws IOException {
            int c0 = c0();
            Q0(str);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        public void p(int i2, long j2) throws IOException {
            r0(15);
            X0(j2);
            R0(i2, 0);
        }

        public void q(int i2, Object obj) throws IOException {
            int c0 = c0();
            Protobuf.a().k(obj, this);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        /* access modifiers changed from: package-private */
        public void r0(int i2) {
            if (c1() < i2) {
                a1(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void s0(boolean z) {
            T(z ? (byte) 1 : 0);
        }

        public void t(int i2, boolean z) throws IOException {
            r0(6);
            T(z ? (byte) 1 : 0);
            R0(i2, 0);
        }

        public void v(int i2) {
            R0(i2, 3);
        }

        public void w(int i2, int i3) throws IOException {
            r0(15);
            F0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void x0(int i2) {
            byte[] bArr = this.f7002i;
            int i3 = this.f7007n;
            int i4 = i3 - 1;
            this.f7007n = i4;
            bArr[i3] = (byte) ((i2 >> 24) & 255);
            int i5 = i3 - 2;
            this.f7007n = i5;
            bArr[i4] = (byte) ((i2 >> 16) & 255);
            int i6 = i3 - 3;
            this.f7007n = i6;
            bArr[i5] = (byte) ((i2 >> 8) & 255);
            this.f7007n = i3 - 4;
            bArr[i6] = (byte) (i2 & 255);
        }

        public void z(int i2, ByteString byteString) throws IOException {
            try {
                byteString.A0(this);
                r0(10);
                W0(byteString.size());
                R0(i2, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static final class UnsafeDirectWriter extends BinaryWriter {

        /* renamed from: h  reason: collision with root package name */
        private ByteBuffer f7008h;

        /* renamed from: i  reason: collision with root package name */
        private long f7009i;

        /* renamed from: j  reason: collision with root package name */
        private long f7010j;

        /* renamed from: k  reason: collision with root package name */
        private long f7011k;

        UnsafeDirectWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, (AnonymousClass1) null);
            c1();
        }

        private int Z0() {
            return (int) (this.f7011k - this.f7009i);
        }

        private int a1() {
            return (int) (this.f7010j - this.f7011k);
        }

        /* access modifiers changed from: private */
        public static boolean b1() {
            return UnsafeUtil.T();
        }

        private void c1() {
            e1(f0());
        }

        private void d1(int i2) {
            e1(g0(i2));
        }

        private void e1(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.d()) {
                ByteBuffer f2 = allocatedBuffer.f();
                if (f2.isDirect()) {
                    b0();
                    this.f6995c.addFirst(allocatedBuffer);
                    this.f7008h = f2;
                    f2.limit(f2.capacity());
                    this.f7008h.position(0);
                    long i2 = UnsafeUtil.i(this.f7008h);
                    this.f7009i = i2;
                    long limit = i2 + ((long) (this.f7008h.limit() - 1));
                    this.f7010j = limit;
                    this.f7011k = limit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        private int f1() {
            return Z0() + 1;
        }

        private void g1(int i2) {
            long j2 = this.f7011k;
            this.f7011k = j2 - 1;
            UnsafeUtil.b0(j2, (byte) (i2 >>> 28));
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) (((i2 >>> 21) & WorkQueueKt.f29430c) | 128));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) (((i2 >>> 14) & WorkQueueKt.f29430c) | 128));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
        }

        private void h1(int i2) {
            long j2 = this.f7011k;
            this.f7011k = j2 - 1;
            UnsafeUtil.b0(j2, (byte) (i2 >>> 21));
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) (((i2 >>> 14) & WorkQueueKt.f29430c) | 128));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
        }

        private void i1(int i2) {
            long j2 = this.f7011k;
            this.f7011k = j2 - 1;
            UnsafeUtil.b0(j2, (byte) i2);
        }

        private void j1(int i2) {
            long j2 = this.f7011k;
            this.f7011k = j2 - 1;
            UnsafeUtil.b0(j2, (byte) (i2 >>> 14));
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
        }

        private void k1(int i2) {
            long j2 = this.f7011k;
            this.f7011k = j2 - 1;
            UnsafeUtil.b0(j2, (byte) (i2 >>> 7));
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
        }

        private void l1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) (j2 >>> 49)));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            long j7 = this.f7011k;
            this.f7011k = j7 - 1;
            UnsafeUtil.b0(j7, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            long j8 = this.f7011k;
            this.f7011k = j8 - 1;
            UnsafeUtil.b0(j8, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            long j9 = this.f7011k;
            this.f7011k = j9 - 1;
            UnsafeUtil.b0(j9, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            long j10 = this.f7011k;
            this.f7011k = j10 - 1;
            UnsafeUtil.b0(j10, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void m1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) (j2 >>> 28)));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            long j7 = this.f7011k;
            this.f7011k = j7 - 1;
            UnsafeUtil.b0(j7, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void n1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) (j2 >>> 21)));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void o1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) (j2 >>> 56)));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((int) (((j2 >>> 49) & 127) | 128)));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            long j7 = this.f7011k;
            this.f7011k = j7 - 1;
            UnsafeUtil.b0(j7, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            long j8 = this.f7011k;
            this.f7011k = j8 - 1;
            UnsafeUtil.b0(j8, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            long j9 = this.f7011k;
            this.f7011k = j9 - 1;
            UnsafeUtil.b0(j9, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            long j10 = this.f7011k;
            this.f7011k = j10 - 1;
            UnsafeUtil.b0(j10, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            long j11 = this.f7011k;
            this.f7011k = j11 - 1;
            UnsafeUtil.b0(j11, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void p1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) j2));
        }

        private void q1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) (j2 >>> 42)));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            long j7 = this.f7011k;
            this.f7011k = j7 - 1;
            UnsafeUtil.b0(j7, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            long j8 = this.f7011k;
            this.f7011k = j8 - 1;
            UnsafeUtil.b0(j8, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            long j9 = this.f7011k;
            this.f7011k = j9 - 1;
            UnsafeUtil.b0(j9, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void r1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) (j2 >>> 35)));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            long j7 = this.f7011k;
            this.f7011k = j7 - 1;
            UnsafeUtil.b0(j7, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            long j8 = this.f7011k;
            this.f7011k = j8 - 1;
            UnsafeUtil.b0(j8, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void s1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) (j2 >>> 63)));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((int) (((j2 >>> 56) & 127) | 128)));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((int) (((j2 >>> 49) & 127) | 128)));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            long j7 = this.f7011k;
            this.f7011k = j7 - 1;
            UnsafeUtil.b0(j7, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            long j8 = this.f7011k;
            this.f7011k = j8 - 1;
            UnsafeUtil.b0(j8, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            long j9 = this.f7011k;
            this.f7011k = j9 - 1;
            UnsafeUtil.b0(j9, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            long j10 = this.f7011k;
            this.f7011k = j10 - 1;
            UnsafeUtil.b0(j10, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            long j11 = this.f7011k;
            this.f7011k = j11 - 1;
            UnsafeUtil.b0(j11, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            long j12 = this.f7011k;
            this.f7011k = j12 - 1;
            UnsafeUtil.b0(j12, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void t1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) (((int) j2) >>> 14));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void u1(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((int) (j2 >>> 7)));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128));
        }

        /* access modifiers changed from: package-private */
        public void A0(long j2) {
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) (((int) (j2 >> 56)) & 255));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) (((int) (j2 >> 48)) & 255));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) (((int) (j2 >> 40)) & 255));
            long j6 = this.f7011k;
            this.f7011k = j6 - 1;
            UnsafeUtil.b0(j6, (byte) (((int) (j2 >> 32)) & 255));
            long j7 = this.f7011k;
            this.f7011k = j7 - 1;
            UnsafeUtil.b0(j7, (byte) (((int) (j2 >> 24)) & 255));
            long j8 = this.f7011k;
            this.f7011k = j8 - 1;
            UnsafeUtil.b0(j8, (byte) (((int) (j2 >> 16)) & 255));
            long j9 = this.f7011k;
            this.f7011k = j9 - 1;
            UnsafeUtil.b0(j9, (byte) (((int) (j2 >> 8)) & 255));
            long j10 = this.f7011k;
            this.f7011k = j10 - 1;
            UnsafeUtil.b0(j10, (byte) (((int) j2) & 255));
        }

        public void C(int i2, Object obj, Schema schema) throws IOException {
            int c0 = c0();
            schema.e(obj, this);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        public void E(int i2, Object obj) throws IOException {
            R0(i2, 4);
            Protobuf.a().k(obj, this);
            R0(i2, 3);
        }

        /* access modifiers changed from: package-private */
        public void F0(int i2) {
            if (i2 >= 0) {
                W0(i2);
            } else {
                X0((long) i2);
            }
        }

        public void H(int i2, long j2) {
            r0(15);
            N0(j2);
            R0(i2, 0);
        }

        public void J(int i2) {
            R0(i2, 4);
        }

        /* access modifiers changed from: package-private */
        public void K0(int i2) {
            W0(CodedOutputStream.c1(i2));
        }

        /* access modifiers changed from: package-private */
        public void N0(long j2) {
            X0(CodedOutputStream.d1(j2));
        }

        public void Q(int i2, int i3) {
            r0(10);
            K0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void Q0(String str) {
            long j2;
            char charAt;
            r0(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    long j3 = this.f7011k;
                    this.f7011k = j3 - 1;
                    UnsafeUtil.b0(j3, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        j2 = this.f7011k;
                        if (j2 >= this.f7009i) {
                            this.f7011k = j2 - 1;
                            UnsafeUtil.b0(j2, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j4 = this.f7011k;
                        if (j4 > this.f7009i) {
                            this.f7011k = j4 - 1;
                            UnsafeUtil.b0(j4, (byte) ((charAt2 & '?') | 128));
                            j2 = this.f7011k;
                            this.f7011k = j2 - 1;
                            charAt2 = (charAt2 >>> 6) | 960;
                            UnsafeUtil.b0(j2, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j5 = this.f7011k;
                        if (j5 > this.f7009i + 1) {
                            this.f7011k = j5 - 1;
                            UnsafeUtil.b0(j5, (byte) ((charAt2 & '?') | 128));
                            long j6 = this.f7011k;
                            this.f7011k = j6 - 1;
                            UnsafeUtil.b0(j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                            j2 = this.f7011k;
                            this.f7011k = j2 - 1;
                            charAt2 = (charAt2 >>> 12) | 480;
                            UnsafeUtil.b0(j2, (byte) charAt2);
                            length--;
                        }
                    }
                    if (this.f7011k > this.f7009i + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                long j7 = this.f7011k;
                                this.f7011k = j7 - 1;
                                UnsafeUtil.b0(j7, (byte) ((codePoint & 63) | 128));
                                long j8 = this.f7011k;
                                this.f7011k = j8 - 1;
                                UnsafeUtil.b0(j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                long j9 = this.f7011k;
                                this.f7011k = j9 - 1;
                                UnsafeUtil.b0(j9, (byte) (((codePoint >>> 12) & 63) | 128));
                                j2 = this.f7011k;
                                this.f7011k = j2 - 1;
                                charAt2 = (codePoint >>> 18) | 240;
                                UnsafeUtil.b0(j2, (byte) charAt2);
                                length--;
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    r0(length);
                    length++;
                    length--;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void R0(int i2, int i3) {
            W0(WireFormat.c(i2, i3));
        }

        public void S(int i2, Object obj, Schema schema) throws IOException {
            R0(i2, 4);
            schema.e(obj, this);
            R0(i2, 3);
        }

        public void T(byte b2) {
            long j2 = this.f7011k;
            this.f7011k = j2 - 1;
            UnsafeUtil.b0(j2, b2);
        }

        public void U(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (f1() < remaining) {
                d1(remaining);
            }
            this.f7011k -= (long) remaining;
            this.f7008h.position(Z0() + 1);
            this.f7008h.put(byteBuffer);
        }

        public void V(byte[] bArr, int i2, int i3) {
            if (f1() < i3) {
                d1(i3);
            }
            this.f7011k -= (long) i3;
            this.f7008h.position(Z0() + 1);
            this.f7008h.put(bArr, i2, i3);
        }

        public void W(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (f1() < remaining) {
                this.f6996d += remaining;
                this.f6995c.addFirst(AllocatedBuffer.j(byteBuffer));
                c1();
                return;
            }
            this.f7011k -= (long) remaining;
            this.f7008h.position(Z0() + 1);
            this.f7008h.put(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public void W0(int i2) {
            if ((i2 & -128) == 0) {
                i1(i2);
            } else if ((i2 & -16384) == 0) {
                k1(i2);
            } else if ((-2097152 & i2) == 0) {
                j1(i2);
            } else if ((-268435456 & i2) == 0) {
                h1(i2);
            } else {
                g1(i2);
            }
        }

        public void X(byte[] bArr, int i2, int i3) {
            if (f1() < i3) {
                this.f6996d += i3;
                this.f6995c.addFirst(AllocatedBuffer.l(bArr, i2, i3));
                c1();
                return;
            }
            this.f7011k -= (long) i3;
            this.f7008h.position(Z0() + 1);
            this.f7008h.put(bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public void X0(long j2) {
            switch (BinaryWriter.a0(j2)) {
                case 1:
                    p1(j2);
                    return;
                case 2:
                    u1(j2);
                    return;
                case 3:
                    t1(j2);
                    return;
                case 4:
                    n1(j2);
                    return;
                case 5:
                    m1(j2);
                    return;
                case 6:
                    r1(j2);
                    return;
                case 7:
                    q1(j2);
                    return;
                case 8:
                    l1(j2);
                    return;
                case 9:
                    o1(j2);
                    return;
                case 10:
                    s1(j2);
                    return;
                default:
                    return;
            }
        }

        public void b(int i2, int i3) {
            r0(10);
            W0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void b0() {
            if (this.f7008h != null) {
                this.f6996d += a1();
                this.f7008h.position(Z0() + 1);
                this.f7008h = null;
                this.f7011k = 0;
                this.f7010j = 0;
            }
        }

        public int c0() {
            return this.f6996d + a1();
        }

        public void d(int i2, int i3) {
            r0(9);
            x0(i3);
            R0(i2, 5);
        }

        public void i(int i2, long j2) {
            r0(13);
            A0(j2);
            R0(i2, 1);
        }

        public void o(int i2, String str) {
            int c0 = c0();
            Q0(str);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        public void p(int i2, long j2) {
            r0(15);
            X0(j2);
            R0(i2, 0);
        }

        public void q(int i2, Object obj) throws IOException {
            int c0 = c0();
            Protobuf.a().k(obj, this);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        /* access modifiers changed from: package-private */
        public void r0(int i2) {
            if (f1() < i2) {
                d1(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void s0(boolean z) {
            T(z ? (byte) 1 : 0);
        }

        public void t(int i2, boolean z) {
            r0(6);
            T(z ? (byte) 1 : 0);
            R0(i2, 0);
        }

        public void v(int i2) {
            R0(i2, 3);
        }

        public void w(int i2, int i3) {
            r0(15);
            F0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void x0(int i2) {
            long j2 = this.f7011k;
            this.f7011k = j2 - 1;
            UnsafeUtil.b0(j2, (byte) ((i2 >> 24) & 255));
            long j3 = this.f7011k;
            this.f7011k = j3 - 1;
            UnsafeUtil.b0(j3, (byte) ((i2 >> 16) & 255));
            long j4 = this.f7011k;
            this.f7011k = j4 - 1;
            UnsafeUtil.b0(j4, (byte) ((i2 >> 8) & 255));
            long j5 = this.f7011k;
            this.f7011k = j5 - 1;
            UnsafeUtil.b0(j5, (byte) (i2 & 255));
        }

        public void z(int i2, ByteString byteString) {
            try {
                byteString.A0(this);
                r0(10);
                W0(byteString.size());
                R0(i2, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private static final class UnsafeHeapWriter extends BinaryWriter {

        /* renamed from: h  reason: collision with root package name */
        private AllocatedBuffer f7012h;

        /* renamed from: i  reason: collision with root package name */
        private byte[] f7013i;

        /* renamed from: j  reason: collision with root package name */
        private long f7014j;

        /* renamed from: k  reason: collision with root package name */
        private long f7015k;

        /* renamed from: l  reason: collision with root package name */
        private long f7016l;

        /* renamed from: m  reason: collision with root package name */
        private long f7017m;

        /* renamed from: n  reason: collision with root package name */
        private long f7018n;

        UnsafeHeapWriter(BufferAllocator bufferAllocator, int i2) {
            super(bufferAllocator, i2, (AnonymousClass1) null);
            b1();
        }

        private int Y0() {
            return (int) this.f7018n;
        }

        static boolean a1() {
            return UnsafeUtil.S();
        }

        private void b1() {
            d1(j0());
        }

        private void c1(int i2) {
            d1(k0(i2));
        }

        private void d1(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.c()) {
                b0();
                this.f6995c.addFirst(allocatedBuffer);
                this.f7012h = allocatedBuffer;
                this.f7013i = allocatedBuffer.a();
                int b2 = allocatedBuffer.b();
                this.f7015k = (long) (allocatedBuffer.e() + b2);
                long g2 = (long) (b2 + allocatedBuffer.g());
                this.f7014j = g2;
                this.f7016l = g2 - 1;
                long j2 = this.f7015k - 1;
                this.f7017m = j2;
                this.f7018n = j2;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        private void f1(int i2) {
            byte[] bArr = this.f7013i;
            long j2 = this.f7018n;
            this.f7018n = j2 - 1;
            UnsafeUtil.d0(bArr, j2, (byte) (i2 >>> 28));
            byte[] bArr2 = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr2, j3, (byte) (((i2 >>> 21) & WorkQueueKt.f29430c) | 128));
            byte[] bArr3 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr3, j4, (byte) (((i2 >>> 14) & WorkQueueKt.f29430c) | 128));
            byte[] bArr4 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr4, j5, (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128));
            byte[] bArr5 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr5, j6, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
        }

        private void g1(int i2) {
            byte[] bArr = this.f7013i;
            long j2 = this.f7018n;
            this.f7018n = j2 - 1;
            UnsafeUtil.d0(bArr, j2, (byte) (i2 >>> 21));
            byte[] bArr2 = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr2, j3, (byte) (((i2 >>> 14) & WorkQueueKt.f29430c) | 128));
            byte[] bArr3 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr3, j4, (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128));
            byte[] bArr4 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr4, j5, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
        }

        private void h1(int i2) {
            byte[] bArr = this.f7013i;
            long j2 = this.f7018n;
            this.f7018n = j2 - 1;
            UnsafeUtil.d0(bArr, j2, (byte) i2);
        }

        private void i1(int i2) {
            byte[] bArr = this.f7013i;
            long j2 = this.f7018n;
            this.f7018n = j2 - 1;
            UnsafeUtil.d0(bArr, j2, (byte) (i2 >>> 14));
            byte[] bArr2 = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr2, j3, (byte) (((i2 >>> 7) & WorkQueueKt.f29430c) | 128));
            byte[] bArr3 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr3, j4, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
        }

        private void j1(int i2) {
            byte[] bArr = this.f7013i;
            long j2 = this.f7018n;
            this.f7018n = j2 - 1;
            UnsafeUtil.d0(bArr, j2, (byte) (i2 >>> 7));
            byte[] bArr2 = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr2, j3, (byte) ((i2 & WorkQueueKt.f29430c) | 128));
        }

        private void k1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) (j2 >>> 49)));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            byte[] bArr4 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr4, j6, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr5 = this.f7013i;
            long j7 = this.f7018n;
            this.f7018n = j7 - 1;
            UnsafeUtil.d0(bArr5, j7, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr6 = this.f7013i;
            long j8 = this.f7018n;
            this.f7018n = j8 - 1;
            UnsafeUtil.d0(bArr6, j8, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr7 = this.f7013i;
            long j9 = this.f7018n;
            this.f7018n = j9 - 1;
            UnsafeUtil.d0(bArr7, j9, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr8 = this.f7013i;
            long j10 = this.f7018n;
            this.f7018n = j10 - 1;
            UnsafeUtil.d0(bArr8, j10, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void l1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) (j2 >>> 28)));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr4 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr4, j6, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr5 = this.f7013i;
            long j7 = this.f7018n;
            this.f7018n = j7 - 1;
            UnsafeUtil.d0(bArr5, j7, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void m1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) (j2 >>> 21)));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr4 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr4, j6, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void n1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) (j2 >>> 56)));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((int) (((j2 >>> 49) & 127) | 128)));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            byte[] bArr4 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr4, j6, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            byte[] bArr5 = this.f7013i;
            long j7 = this.f7018n;
            this.f7018n = j7 - 1;
            UnsafeUtil.d0(bArr5, j7, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr6 = this.f7013i;
            long j8 = this.f7018n;
            this.f7018n = j8 - 1;
            UnsafeUtil.d0(bArr6, j8, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr7 = this.f7013i;
            long j9 = this.f7018n;
            this.f7018n = j9 - 1;
            UnsafeUtil.d0(bArr7, j9, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr8 = this.f7013i;
            long j10 = this.f7018n;
            this.f7018n = j10 - 1;
            UnsafeUtil.d0(bArr8, j10, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr9 = this.f7013i;
            long j11 = this.f7018n;
            this.f7018n = j11 - 1;
            UnsafeUtil.d0(bArr9, j11, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void o1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) j2));
        }

        private void p1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) (j2 >>> 42)));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr4 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr4, j6, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr5 = this.f7013i;
            long j7 = this.f7018n;
            this.f7018n = j7 - 1;
            UnsafeUtil.d0(bArr5, j7, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr6 = this.f7013i;
            long j8 = this.f7018n;
            this.f7018n = j8 - 1;
            UnsafeUtil.d0(bArr6, j8, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr7 = this.f7013i;
            long j9 = this.f7018n;
            this.f7018n = j9 - 1;
            UnsafeUtil.d0(bArr7, j9, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void q1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) (j2 >>> 35)));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr4 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr4, j6, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr5 = this.f7013i;
            long j7 = this.f7018n;
            this.f7018n = j7 - 1;
            UnsafeUtil.d0(bArr5, j7, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr6 = this.f7013i;
            long j8 = this.f7018n;
            this.f7018n = j8 - 1;
            UnsafeUtil.d0(bArr6, j8, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void r1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) (j2 >>> 63)));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((int) (((j2 >>> 56) & 127) | 128)));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) ((int) (((j2 >>> 49) & 127) | 128)));
            byte[] bArr4 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr4, j6, (byte) ((int) (((j2 >>> 42) & 127) | 128)));
            byte[] bArr5 = this.f7013i;
            long j7 = this.f7018n;
            this.f7018n = j7 - 1;
            UnsafeUtil.d0(bArr5, j7, (byte) ((int) (((j2 >>> 35) & 127) | 128)));
            byte[] bArr6 = this.f7013i;
            long j8 = this.f7018n;
            this.f7018n = j8 - 1;
            UnsafeUtil.d0(bArr6, j8, (byte) ((int) (((j2 >>> 28) & 127) | 128)));
            byte[] bArr7 = this.f7013i;
            long j9 = this.f7018n;
            this.f7018n = j9 - 1;
            UnsafeUtil.d0(bArr7, j9, (byte) ((int) (((j2 >>> 21) & 127) | 128)));
            byte[] bArr8 = this.f7013i;
            long j10 = this.f7018n;
            this.f7018n = j10 - 1;
            UnsafeUtil.d0(bArr8, j10, (byte) ((int) (((j2 >>> 14) & 127) | 128)));
            byte[] bArr9 = this.f7013i;
            long j11 = this.f7018n;
            this.f7018n = j11 - 1;
            UnsafeUtil.d0(bArr9, j11, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr10 = this.f7013i;
            long j12 = this.f7018n;
            this.f7018n = j12 - 1;
            UnsafeUtil.d0(bArr10, j12, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void s1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) (((int) j2) >>> 14));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((int) (((j2 >>> 7) & 127) | 128)));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) ((int) ((j2 & 127) | 128)));
        }

        private void t1(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) ((int) (j2 >>> 7)));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) ((((int) j2) & WorkQueueKt.f29430c) | 128));
        }

        /* access modifiers changed from: package-private */
        public void A0(long j2) {
            byte[] bArr = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr, j3, (byte) (((int) (j2 >> 56)) & 255));
            byte[] bArr2 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr2, j4, (byte) (((int) (j2 >> 48)) & 255));
            byte[] bArr3 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr3, j5, (byte) (((int) (j2 >> 40)) & 255));
            byte[] bArr4 = this.f7013i;
            long j6 = this.f7018n;
            this.f7018n = j6 - 1;
            UnsafeUtil.d0(bArr4, j6, (byte) (((int) (j2 >> 32)) & 255));
            byte[] bArr5 = this.f7013i;
            long j7 = this.f7018n;
            this.f7018n = j7 - 1;
            UnsafeUtil.d0(bArr5, j7, (byte) (((int) (j2 >> 24)) & 255));
            byte[] bArr6 = this.f7013i;
            long j8 = this.f7018n;
            this.f7018n = j8 - 1;
            UnsafeUtil.d0(bArr6, j8, (byte) (((int) (j2 >> 16)) & 255));
            byte[] bArr7 = this.f7013i;
            long j9 = this.f7018n;
            this.f7018n = j9 - 1;
            UnsafeUtil.d0(bArr7, j9, (byte) (((int) (j2 >> 8)) & 255));
            byte[] bArr8 = this.f7013i;
            long j10 = this.f7018n;
            this.f7018n = j10 - 1;
            UnsafeUtil.d0(bArr8, j10, (byte) (((int) j2) & 255));
        }

        public void C(int i2, Object obj, Schema schema) throws IOException {
            int c0 = c0();
            schema.e(obj, this);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        public void E(int i2, Object obj) throws IOException {
            R0(i2, 4);
            Protobuf.a().k(obj, this);
            R0(i2, 3);
        }

        /* access modifiers changed from: package-private */
        public void F0(int i2) {
            if (i2 >= 0) {
                W0(i2);
            } else {
                X0((long) i2);
            }
        }

        public void H(int i2, long j2) {
            r0(15);
            N0(j2);
            R0(i2, 0);
        }

        public void J(int i2) {
            R0(i2, 4);
        }

        /* access modifiers changed from: package-private */
        public void K0(int i2) {
            W0(CodedOutputStream.c1(i2));
        }

        /* access modifiers changed from: package-private */
        public void N0(long j2) {
            X0(CodedOutputStream.d1(j2));
        }

        public void Q(int i2, int i3) {
            r0(10);
            K0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void Q0(String str) {
            char charAt;
            r0(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length >= 0 && (charAt = str.charAt(length)) < 128) {
                    byte[] bArr = this.f7013i;
                    long j2 = this.f7018n;
                    this.f7018n = j2 - 1;
                    UnsafeUtil.d0(bArr, j2, (byte) charAt);
                }
            }
            if (length != -1) {
                while (length >= 0) {
                    char charAt2 = str.charAt(length);
                    if (charAt2 < 128) {
                        long j3 = this.f7018n;
                        if (j3 > this.f7016l) {
                            byte[] bArr2 = this.f7013i;
                            this.f7018n = j3 - 1;
                            UnsafeUtil.d0(bArr2, j3, (byte) charAt2);
                            length--;
                        }
                    }
                    if (charAt2 < 2048) {
                        long j4 = this.f7018n;
                        if (j4 > this.f7014j) {
                            byte[] bArr3 = this.f7013i;
                            this.f7018n = j4 - 1;
                            UnsafeUtil.d0(bArr3, j4, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr4 = this.f7013i;
                            long j5 = this.f7018n;
                            this.f7018n = j5 - 1;
                            UnsafeUtil.d0(bArr4, j5, (byte) ((charAt2 >>> 6) | 960));
                            length--;
                        }
                    }
                    if (charAt2 < 55296 || 57343 < charAt2) {
                        long j6 = this.f7018n;
                        if (j6 > this.f7014j + 1) {
                            byte[] bArr5 = this.f7013i;
                            this.f7018n = j6 - 1;
                            UnsafeUtil.d0(bArr5, j6, (byte) ((charAt2 & '?') | 128));
                            byte[] bArr6 = this.f7013i;
                            long j7 = this.f7018n;
                            this.f7018n = j7 - 1;
                            UnsafeUtil.d0(bArr6, j7, (byte) (((charAt2 >>> 6) & 63) | 128));
                            byte[] bArr7 = this.f7013i;
                            long j8 = this.f7018n;
                            this.f7018n = j8 - 1;
                            UnsafeUtil.d0(bArr7, j8, (byte) ((charAt2 >>> 12) | 480));
                            length--;
                        }
                    }
                    if (this.f7018n > this.f7014j + 2) {
                        if (length != 0) {
                            char charAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(charAt3, charAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(charAt3, charAt2);
                                byte[] bArr8 = this.f7013i;
                                long j9 = this.f7018n;
                                this.f7018n = j9 - 1;
                                UnsafeUtil.d0(bArr8, j9, (byte) ((codePoint & 63) | 128));
                                byte[] bArr9 = this.f7013i;
                                long j10 = this.f7018n;
                                this.f7018n = j10 - 1;
                                UnsafeUtil.d0(bArr9, j10, (byte) (((codePoint >>> 6) & 63) | 128));
                                byte[] bArr10 = this.f7013i;
                                long j11 = this.f7018n;
                                this.f7018n = j11 - 1;
                                UnsafeUtil.d0(bArr10, j11, (byte) (((codePoint >>> 12) & 63) | 128));
                                byte[] bArr11 = this.f7013i;
                                long j12 = this.f7018n;
                                this.f7018n = j12 - 1;
                                UnsafeUtil.d0(bArr11, j12, (byte) ((codePoint >>> 18) | PsExtractor.A));
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    r0(length);
                    length++;
                    length--;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void R0(int i2, int i3) {
            W0(WireFormat.c(i2, i3));
        }

        public void S(int i2, Object obj, Schema schema) throws IOException {
            R0(i2, 4);
            schema.e(obj, this);
            R0(i2, 3);
        }

        public void T(byte b2) {
            byte[] bArr = this.f7013i;
            long j2 = this.f7018n;
            this.f7018n = j2 - 1;
            UnsafeUtil.d0(bArr, j2, b2);
        }

        public void U(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            r0(remaining);
            this.f7018n -= (long) remaining;
            byteBuffer.get(this.f7013i, Y0() + 1, remaining);
        }

        public void V(byte[] bArr, int i2, int i3) {
            if (i2 < 0 || i2 + i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            }
            r0(i3);
            this.f7018n -= (long) i3;
            System.arraycopy(bArr, i2, this.f7013i, Y0() + 1, i3);
        }

        public void W(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            if (e1() < remaining) {
                this.f6996d += remaining;
                this.f6995c.addFirst(AllocatedBuffer.j(byteBuffer));
                b1();
            }
            this.f7018n -= (long) remaining;
            byteBuffer.get(this.f7013i, Y0() + 1, remaining);
        }

        /* access modifiers changed from: package-private */
        public void W0(int i2) {
            if ((i2 & -128) == 0) {
                h1(i2);
            } else if ((i2 & -16384) == 0) {
                j1(i2);
            } else if ((-2097152 & i2) == 0) {
                i1(i2);
            } else if ((-268435456 & i2) == 0) {
                g1(i2);
            } else {
                f1(i2);
            }
        }

        public void X(byte[] bArr, int i2, int i3) {
            if (i2 < 0 || i2 + i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
            } else if (e1() < i3) {
                this.f6996d += i3;
                this.f6995c.addFirst(AllocatedBuffer.l(bArr, i2, i3));
                b1();
            } else {
                this.f7018n -= (long) i3;
                System.arraycopy(bArr, i2, this.f7013i, Y0() + 1, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void X0(long j2) {
            switch (BinaryWriter.a0(j2)) {
                case 1:
                    o1(j2);
                    return;
                case 2:
                    t1(j2);
                    return;
                case 3:
                    s1(j2);
                    return;
                case 4:
                    m1(j2);
                    return;
                case 5:
                    l1(j2);
                    return;
                case 6:
                    q1(j2);
                    return;
                case 7:
                    p1(j2);
                    return;
                case 8:
                    k1(j2);
                    return;
                case 9:
                    n1(j2);
                    return;
                case 10:
                    r1(j2);
                    return;
                default:
                    return;
            }
        }

        /* access modifiers changed from: package-private */
        public int Z0() {
            return (int) (this.f7017m - this.f7018n);
        }

        public void b(int i2, int i3) {
            r0(10);
            W0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void b0() {
            if (this.f7012h != null) {
                this.f6996d += Z0();
                this.f7012h.h((Y0() - this.f7012h.b()) + 1);
                this.f7012h = null;
                this.f7018n = 0;
                this.f7017m = 0;
            }
        }

        public int c0() {
            return this.f6996d + Z0();
        }

        public void d(int i2, int i3) {
            r0(9);
            x0(i3);
            R0(i2, 5);
        }

        /* access modifiers changed from: package-private */
        public int e1() {
            return (int) (this.f7018n - this.f7016l);
        }

        public void i(int i2, long j2) {
            r0(13);
            A0(j2);
            R0(i2, 1);
        }

        public void o(int i2, String str) {
            int c0 = c0();
            Q0(str);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        public void p(int i2, long j2) {
            r0(15);
            X0(j2);
            R0(i2, 0);
        }

        public void q(int i2, Object obj) throws IOException {
            int c0 = c0();
            Protobuf.a().k(obj, this);
            r0(10);
            W0(c0() - c0);
            R0(i2, 2);
        }

        /* access modifiers changed from: package-private */
        public void r0(int i2) {
            if (e1() < i2) {
                c1(i2);
            }
        }

        /* access modifiers changed from: package-private */
        public void s0(boolean z) {
            T(z ? (byte) 1 : 0);
        }

        public void t(int i2, boolean z) {
            r0(6);
            T(z ? (byte) 1 : 0);
            R0(i2, 0);
        }

        public void v(int i2) {
            R0(i2, 3);
        }

        public void w(int i2, int i3) {
            r0(15);
            F0(i3);
            R0(i2, 0);
        }

        /* access modifiers changed from: package-private */
        public void x0(int i2) {
            byte[] bArr = this.f7013i;
            long j2 = this.f7018n;
            this.f7018n = j2 - 1;
            UnsafeUtil.d0(bArr, j2, (byte) ((i2 >> 24) & 255));
            byte[] bArr2 = this.f7013i;
            long j3 = this.f7018n;
            this.f7018n = j3 - 1;
            UnsafeUtil.d0(bArr2, j3, (byte) ((i2 >> 16) & 255));
            byte[] bArr3 = this.f7013i;
            long j4 = this.f7018n;
            this.f7018n = j4 - 1;
            UnsafeUtil.d0(bArr3, j4, (byte) ((i2 >> 8) & 255));
            byte[] bArr4 = this.f7013i;
            long j5 = this.f7018n;
            this.f7018n = j5 - 1;
            UnsafeUtil.d0(bArr4, j5, (byte) (i2 & 255));
        }

        public void z(int i2, ByteString byteString) {
            try {
                byteString.A0(this);
                r0(10);
                W0(byteString.size());
                R0(i2, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private BinaryWriter(BufferAllocator bufferAllocator, int i2) {
        this.f6995c = new ArrayDeque<>(4);
        if (i2 > 0) {
            this.f6993a = (BufferAllocator) Internal.e(bufferAllocator, "alloc");
            this.f6994b = i2;
            return;
        }
        throw new IllegalArgumentException("chunkSize must be > 0");
    }

    private final void B0(int i2, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            r0((longArrayList.size() * 8) + 10);
            int c0 = c0();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                A0(longArrayList.getLong(size));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            i(i2, longArrayList.getLong(size2));
        }
    }

    private final void C0(int i2, List<Long> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 8) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                A0(list.get(size).longValue());
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            i(i2, list.get(size2).longValue());
        }
    }

    private final void D0(int i2, FloatArrayList floatArrayList, boolean z) throws IOException {
        if (z) {
            r0((floatArrayList.size() * 4) + 10);
            int c0 = c0();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                x0(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            I(i2, floatArrayList.getFloat(size2));
        }
    }

    private final void E0(int i2, List<Float> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 4) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                x0(Float.floatToRawIntBits(list.get(size).floatValue()));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            I(i2, list.get(size2).floatValue());
        }
    }

    private final void G0(int i2, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            r0((intArrayList.size() * 10) + 10);
            int c0 = c0();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                F0(intArrayList.getInt(size));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            w(i2, intArrayList.getInt(size2));
        }
    }

    private final void H0(int i2, List<Integer> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 10) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                F0(list.get(size).intValue());
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            w(i2, list.get(size2).intValue());
        }
    }

    private void I0(int i2, Object obj) throws IOException {
        if (obj instanceof String) {
            o(i2, (String) obj);
        } else {
            z(i2, (ByteString) obj);
        }
    }

    static final void J0(Writer writer, int i2, WireFormat.FieldType fieldType, Object obj) throws IOException {
        int intValue;
        switch (AnonymousClass1.f6997a[fieldType.ordinal()]) {
            case 1:
                writer.t(i2, ((Boolean) obj).booleanValue());
                return;
            case 2:
                writer.d(i2, ((Integer) obj).intValue());
                return;
            case 3:
                writer.i(i2, ((Long) obj).longValue());
                return;
            case 4:
                writer.w(i2, ((Integer) obj).intValue());
                return;
            case 5:
                writer.s(i2, ((Long) obj).longValue());
                return;
            case 6:
                writer.u(i2, ((Integer) obj).intValue());
                return;
            case 7:
                writer.A(i2, ((Long) obj).longValue());
                return;
            case 8:
                writer.Q(i2, ((Integer) obj).intValue());
                return;
            case 9:
                writer.H(i2, ((Long) obj).longValue());
                return;
            case 10:
                writer.o(i2, (String) obj);
                return;
            case 11:
                writer.b(i2, ((Integer) obj).intValue());
                return;
            case 12:
                writer.p(i2, ((Long) obj).longValue());
                return;
            case 13:
                writer.I(i2, ((Float) obj).floatValue());
                return;
            case 14:
                writer.e(i2, ((Double) obj).doubleValue());
                return;
            case 15:
                writer.q(i2, obj);
                return;
            case 16:
                writer.z(i2, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    intValue = ((Internal.EnumLite) obj).d();
                } else if (obj instanceof Integer) {
                    intValue = ((Integer) obj).intValue();
                } else {
                    throw new IllegalArgumentException("Unexpected type for enum in map.");
                }
                writer.L(i2, intValue);
                return;
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private final void L0(int i2, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            r0((intArrayList.size() * 5) + 10);
            int c0 = c0();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                K0(intArrayList.getInt(size));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            Q(i2, intArrayList.getInt(size2));
        }
    }

    private final void M0(int i2, List<Integer> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 5) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                K0(list.get(size).intValue());
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Q(i2, list.get(size2).intValue());
        }
    }

    private final void O0(int i2, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            r0((longArrayList.size() * 10) + 10);
            int c0 = c0();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                N0(longArrayList.getLong(size));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            H(i2, longArrayList.getLong(size2));
        }
    }

    private final void P0(int i2, List<Long> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 10) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                N0(list.get(size).longValue());
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            H(i2, list.get(size2).longValue());
        }
    }

    private final void S0(int i2, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            r0((intArrayList.size() * 5) + 10);
            int c0 = c0();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                W0(intArrayList.getInt(size));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            b(i2, intArrayList.getInt(size2));
        }
    }

    private final void T0(int i2, List<Integer> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 5) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                W0(list.get(size).intValue());
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            b(i2, list.get(size2).intValue());
        }
    }

    private final void U0(int i2, LongArrayList longArrayList, boolean z) throws IOException {
        if (z) {
            r0((longArrayList.size() * 10) + 10);
            int c0 = c0();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                X0(longArrayList.getLong(size));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            p(i2, longArrayList.getLong(size2));
        }
    }

    private final void V0(int i2, List<Long> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 10) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                X0(list.get(size).longValue());
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            p(i2, list.get(size2).longValue());
        }
    }

    /* access modifiers changed from: private */
    public static byte a0(long j2) {
        byte b2;
        if ((-128 & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if ((-34359738368L & j2) != 0) {
            b2 = (byte) 6;
            j2 >>>= 28;
        } else {
            b2 = 2;
        }
        if ((-2097152 & j2) != 0) {
            b2 = (byte) (b2 + 2);
            j2 >>>= 14;
        }
        return (j2 & -16384) != 0 ? (byte) (b2 + 1) : b2;
    }

    static boolean d0() {
        return UnsafeDirectWriter.b1();
    }

    static boolean e0() {
        return UnsafeHeapWriter.a1();
    }

    public static BinaryWriter h0(BufferAllocator bufferAllocator) {
        return i0(bufferAllocator, 4096);
    }

    public static BinaryWriter i0(BufferAllocator bufferAllocator, int i2) {
        return d0() ? p0(bufferAllocator, i2) : n0(bufferAllocator, i2);
    }

    public static BinaryWriter l0(BufferAllocator bufferAllocator) {
        return m0(bufferAllocator, 4096);
    }

    public static BinaryWriter m0(BufferAllocator bufferAllocator, int i2) {
        return e0() ? q0(bufferAllocator, i2) : o0(bufferAllocator, i2);
    }

    static BinaryWriter n0(BufferAllocator bufferAllocator, int i2) {
        return new SafeDirectWriter(bufferAllocator, i2);
    }

    static BinaryWriter o0(BufferAllocator bufferAllocator, int i2) {
        return new SafeHeapWriter(bufferAllocator, i2);
    }

    static BinaryWriter p0(BufferAllocator bufferAllocator, int i2) {
        if (d0()) {
            return new UnsafeDirectWriter(bufferAllocator, i2);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    static BinaryWriter q0(BufferAllocator bufferAllocator, int i2) {
        if (e0()) {
            return new UnsafeHeapWriter(bufferAllocator, i2);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private final void t0(int i2, BooleanArrayList booleanArrayList, boolean z) throws IOException {
        if (z) {
            r0(booleanArrayList.size() + 10);
            int c0 = c0();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                s0(booleanArrayList.v(size));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            t(i2, booleanArrayList.v(size2));
        }
    }

    private final void u0(int i2, List<Boolean> list, boolean z) throws IOException {
        if (z) {
            r0(list.size() + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                s0(list.get(size).booleanValue());
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            t(i2, list.get(size2).booleanValue());
        }
    }

    private final void v0(int i2, DoubleArrayList doubleArrayList, boolean z) throws IOException {
        if (z) {
            r0((doubleArrayList.size() * 8) + 10);
            int c0 = c0();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                A0(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            e(i2, doubleArrayList.getDouble(size2));
        }
    }

    private final void w0(int i2, List<Double> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 8) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                A0(Double.doubleToRawLongBits(list.get(size).doubleValue()));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            e(i2, list.get(size2).doubleValue());
        }
    }

    private final void y0(int i2, IntArrayList intArrayList, boolean z) throws IOException {
        if (z) {
            r0((intArrayList.size() * 4) + 10);
            int c0 = c0();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                x0(intArrayList.getInt(size));
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            d(i2, intArrayList.getInt(size2));
        }
    }

    private final void z0(int i2, List<Integer> list, boolean z) throws IOException {
        if (z) {
            r0((list.size() * 4) + 10);
            int c0 = c0();
            for (int size = list.size() - 1; size >= 0; size--) {
                x0(list.get(size).intValue());
            }
            W0(c0() - c0);
            R0(i2, 2);
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            d(i2, list.get(size2).intValue());
        }
    }

    public final void A(int i2, long j2) throws IOException {
        i(i2, j2);
    }

    /* access modifiers changed from: package-private */
    public abstract void A0(long j2);

    public final void B(int i2, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            y0(i2, (IntArrayList) list, z);
        } else {
            z0(i2, list, z);
        }
    }

    public final void D(int i2, List<Boolean> list, boolean z) throws IOException {
        if (list instanceof BooleanArrayList) {
            t0(i2, (BooleanArrayList) list, z);
        } else {
            u0(i2, list, z);
        }
    }

    public final void F(int i2, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            S0(i2, (IntArrayList) list, z);
        } else {
            T0(i2, list, z);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void F0(int i2);

    public final void G(int i2, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            O0(i2, (LongArrayList) list, z);
        } else {
            P0(i2, list, z);
        }
    }

    public final void I(int i2, float f2) throws IOException {
        d(i2, Float.floatToRawIntBits(f2));
    }

    public final void K(int i2, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            L0(i2, (IntArrayList) list, z);
        } else {
            M0(i2, list, z);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void K0(int i2);

    public final void L(int i2, int i3) throws IOException {
        w(i2, i3);
    }

    public final void M(int i2, List<Long> list, boolean z) throws IOException {
        g(i2, list, z);
    }

    public final void N(int i2, List<Integer> list, boolean z) throws IOException {
        r(i2, list, z);
    }

    /* access modifiers changed from: package-private */
    public abstract void N0(long j2);

    public final void O(int i2, List<Double> list, boolean z) throws IOException {
        if (list instanceof DoubleArrayList) {
            v0(i2, (DoubleArrayList) list, z);
        } else {
            w0(i2, list, z);
        }
    }

    public <K, V> void P(int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            int c0 = c0();
            J0(this, 2, metadata.f7195c, next.getValue());
            J0(this, 1, metadata.f7193a, next.getKey());
            W0(c0() - c0);
            R0(i2, 2);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void Q0(String str);

    public final void R(int i2, List<ByteString> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            z(i2, list.get(size));
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void R0(int i2, int i3);

    /* access modifiers changed from: package-private */
    public abstract void W0(int i2);

    /* access modifiers changed from: package-private */
    public abstract void X0(long j2);

    public final Queue<AllocatedBuffer> Z() {
        b0();
        return this.f6995c;
    }

    public final void a(int i2, List<Float> list, boolean z) throws IOException {
        if (list instanceof FloatArrayList) {
            D0(i2, (FloatArrayList) list, z);
        } else {
            E0(i2, list, z);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void b0();

    public final void c(int i2, Object obj) throws IOException {
        R0(1, 4);
        if (obj instanceof ByteString) {
            z(3, (ByteString) obj);
        } else {
            q(3, obj);
        }
        b(2, i2);
        R0(1, 3);
    }

    public abstract int c0();

    public final void e(int i2, double d2) throws IOException {
        i(i2, Double.doubleToRawLongBits(d2));
    }

    public final void f(int i2, List<Long> list, boolean z) throws IOException {
        x(i2, list, z);
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer f0() {
        return this.f6993a.a(this.f6994b);
    }

    public final void g(int i2, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            U0(i2, (LongArrayList) list, z);
        } else {
            V0(i2, list, z);
        }
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer g0(int i2) {
        return this.f6993a.a(Math.max(i2, this.f6994b));
    }

    public final void h(int i2, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            E(i2, list.get(size));
        }
    }

    public final Writer.FieldOrder j() {
        return Writer.FieldOrder.DESCENDING;
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer j0() {
        return this.f6993a.b(this.f6994b);
    }

    public final void k(int i2, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            C(i2, list.get(size), schema);
        }
    }

    /* access modifiers changed from: package-private */
    public final AllocatedBuffer k0(int i2) {
        return this.f6993a.b(Math.max(i2, this.f6994b));
    }

    public final void l(int i2, List<String> list) throws IOException {
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            for (int size = list.size() - 1; size >= 0; size--) {
                I0(i2, lazyStringList.w2(size));
            }
            return;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            o(i2, list.get(size2));
        }
    }

    public final void m(int i2, List<?> list, Schema schema) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            S(i2, list.get(size), schema);
        }
    }

    public final void n(int i2, List<?> list) throws IOException {
        for (int size = list.size() - 1; size >= 0; size--) {
            q(i2, list.get(size));
        }
    }

    public final void r(int i2, List<Integer> list, boolean z) throws IOException {
        if (list instanceof IntArrayList) {
            G0(i2, (IntArrayList) list, z);
        } else {
            H0(i2, list, z);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void r0(int i2);

    public final void s(int i2, long j2) throws IOException {
        p(i2, j2);
    }

    /* access modifiers changed from: package-private */
    public abstract void s0(boolean z);

    public final void u(int i2, int i3) throws IOException {
        d(i2, i3);
    }

    public final void x(int i2, List<Long> list, boolean z) throws IOException {
        if (list instanceof LongArrayList) {
            B0(i2, (LongArrayList) list, z);
        } else {
            C0(i2, list, z);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void x0(int i2);

    public final void y(int i2, List<Integer> list, boolean z) throws IOException {
        B(i2, list, z);
    }

    /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i2, AnonymousClass1 r3) {
        this(bufferAllocator, i2);
    }
}
