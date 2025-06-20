package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import java.util.Arrays;

public final class UnknownFieldSetLite {

    /* renamed from: f  reason: collision with root package name */
    private static final int f7271f = 8;

    /* renamed from: g  reason: collision with root package name */
    private static final UnknownFieldSetLite f7272g = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f7273a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f7274b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f7275c;

    /* renamed from: d  reason: collision with root package name */
    private int f7276d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7277e;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i2 = this.f7273a;
        int[] iArr = this.f7274b;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.f7274b = Arrays.copyOf(iArr, i3);
            this.f7275c = Arrays.copyOf(this.f7275c, i3);
        }
    }

    private static boolean c(int[] iArr, int[] iArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] != iArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Object[] objArr, Object[] objArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (!objArr[i3].equals(objArr2[i3])) {
                return false;
            }
        }
        return true;
    }

    public static UnknownFieldSetLite e() {
        return f7272g;
    }

    private static int h(int[] iArr, int i2) {
        int i3 = 17;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        return i3;
    }

    private static int i(Object[] objArr, int i2) {
        int i3 = 17;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + objArr[i4].hashCode();
        }
        return i3;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private androidx.datastore.preferences.protobuf.UnknownFieldSetLite l(androidx.datastore.preferences.protobuf.CodedInputStream r2) throws java.io.IOException {
        /*
            r1 = this;
        L_0x0000:
            int r0 = r2.Y()
            if (r0 == 0) goto L_0x000c
            boolean r0 = r1.k(r0, r2)
            if (r0 != 0) goto L_0x0000
        L_0x000c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.UnknownFieldSetLite.l(androidx.datastore.preferences.protobuf.CodedInputStream):androidx.datastore.preferences.protobuf.UnknownFieldSetLite");
    }

    static UnknownFieldSetLite o(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i2 = unknownFieldSetLite.f7273a + unknownFieldSetLite2.f7273a;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.f7274b, i2);
        System.arraycopy(unknownFieldSetLite2.f7274b, 0, copyOf, unknownFieldSetLite.f7273a, unknownFieldSetLite2.f7273a);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.f7275c, i2);
        System.arraycopy(unknownFieldSetLite2.f7275c, 0, copyOf2, unknownFieldSetLite.f7273a, unknownFieldSetLite2.f7273a);
        return new UnknownFieldSetLite(i2, copyOf, copyOf2, true);
    }

    static UnknownFieldSetLite p() {
        return new UnknownFieldSetLite();
    }

    private static void u(int i2, Object obj, Writer writer) throws IOException {
        int a2 = WireFormat.a(i2);
        int b2 = WireFormat.b(i2);
        if (b2 == 0) {
            writer.s(a2, ((Long) obj).longValue());
        } else if (b2 == 1) {
            writer.i(a2, ((Long) obj).longValue());
        } else if (b2 == 2) {
            writer.z(a2, (ByteString) obj);
        } else if (b2 != 3) {
            if (b2 == 5) {
                writer.d(a2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.e());
        } else if (writer.j() == Writer.FieldOrder.ASCENDING) {
            writer.v(a2);
            ((UnknownFieldSetLite) obj).w(writer);
            writer.J(a2);
        } else {
            writer.J(a2);
            ((UnknownFieldSetLite) obj).w(writer);
            writer.v(a2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (!this.f7277e) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i2 = this.f7273a;
        return i2 == unknownFieldSetLite.f7273a && c(this.f7274b, unknownFieldSetLite.f7274b, i2) && d(this.f7275c, unknownFieldSetLite.f7275c, this.f7273a);
    }

    public int f() {
        int a1;
        int i2 = this.f7276d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f7273a; i4++) {
            int i5 = this.f7274b[i4];
            int a2 = WireFormat.a(i5);
            int b2 = WireFormat.b(i5);
            if (b2 == 0) {
                a1 = CodedOutputStream.a1(a2, ((Long) this.f7275c[i4]).longValue());
            } else if (b2 == 1) {
                a1 = CodedOutputStream.o0(a2, ((Long) this.f7275c[i4]).longValue());
            } else if (b2 == 2) {
                a1 = CodedOutputStream.g0(a2, (ByteString) this.f7275c[i4]);
            } else if (b2 == 3) {
                a1 = (CodedOutputStream.X0(a2) * 2) + ((UnknownFieldSetLite) this.f7275c[i4]).f();
            } else if (b2 == 5) {
                a1 = CodedOutputStream.m0(a2, ((Integer) this.f7275c[i4]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.e());
            }
            i3 += a1;
        }
        this.f7276d = i3;
        return i3;
    }

    public int g() {
        int i2 = this.f7276d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f7273a; i4++) {
            i3 += CodedOutputStream.K0(WireFormat.a(this.f7274b[i4]), (ByteString) this.f7275c[i4]);
        }
        this.f7276d = i3;
        return i3;
    }

    public int hashCode() {
        int i2 = this.f7273a;
        return ((((MetaDo.w + i2) * 31) + h(this.f7274b, i2)) * 31) + i(this.f7275c, this.f7273a);
    }

    public void j() {
        this.f7277e = false;
    }

    /* access modifiers changed from: package-private */
    public boolean k(int i2, CodedInputStream codedInputStream) throws IOException {
        a();
        int a2 = WireFormat.a(i2);
        int b2 = WireFormat.b(i2);
        if (b2 == 0) {
            r(i2, Long.valueOf(codedInputStream.G()));
            return true;
        } else if (b2 == 1) {
            r(i2, Long.valueOf(codedInputStream.B()));
            return true;
        } else if (b2 == 2) {
            r(i2, codedInputStream.x());
            return true;
        } else if (b2 == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
            unknownFieldSetLite.l(codedInputStream);
            codedInputStream.a(WireFormat.c(a2, 4));
            r(i2, unknownFieldSetLite);
            return true;
        } else if (b2 == 4) {
            return false;
        } else {
            if (b2 == 5) {
                r(i2, Integer.valueOf(codedInputStream.A()));
                return true;
            }
            throw InvalidProtocolBufferException.e();
        }
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite m(int i2, ByteString byteString) {
        a();
        if (i2 != 0) {
            r(WireFormat.c(i2, 2), byteString);
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public UnknownFieldSetLite n(int i2, int i3) {
        a();
        if (i2 != 0) {
            r(WireFormat.c(i2, 0), Long.valueOf((long) i3));
            return this;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    /* access modifiers changed from: package-private */
    public final void q(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f7273a; i3++) {
            MessageLiteToString.c(sb, i2, String.valueOf(WireFormat.a(this.f7274b[i3])), this.f7275c[i3]);
        }
    }

    /* access modifiers changed from: package-private */
    public void r(int i2, Object obj) {
        a();
        b();
        int[] iArr = this.f7274b;
        int i3 = this.f7273a;
        iArr[i3] = i2;
        this.f7275c[i3] = obj;
        this.f7273a = i3 + 1;
    }

    public void s(CodedOutputStream codedOutputStream) throws IOException {
        for (int i2 = 0; i2 < this.f7273a; i2++) {
            codedOutputStream.Y1(WireFormat.a(this.f7274b[i2]), (ByteString) this.f7275c[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(Writer writer) throws IOException {
        if (writer.j() == Writer.FieldOrder.DESCENDING) {
            for (int i2 = this.f7273a - 1; i2 >= 0; i2--) {
                writer.c(WireFormat.a(this.f7274b[i2]), this.f7275c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f7273a; i3++) {
            writer.c(WireFormat.a(this.f7274b[i3]), this.f7275c[i3]);
        }
    }

    public void v(CodedOutputStream codedOutputStream) throws IOException {
        for (int i2 = 0; i2 < this.f7273a; i2++) {
            int i3 = this.f7274b[i2];
            int a2 = WireFormat.a(i3);
            int b2 = WireFormat.b(i3);
            if (b2 == 0) {
                codedOutputStream.p(a2, ((Long) this.f7275c[i2]).longValue());
            } else if (b2 == 1) {
                codedOutputStream.i(a2, ((Long) this.f7275c[i2]).longValue());
            } else if (b2 == 2) {
                codedOutputStream.z(a2, (ByteString) this.f7275c[i2]);
            } else if (b2 == 3) {
                codedOutputStream.g2(a2, 3);
                ((UnknownFieldSetLite) this.f7275c[i2]).v(codedOutputStream);
                codedOutputStream.g2(a2, 4);
            } else if (b2 == 5) {
                codedOutputStream.d(a2, ((Integer) this.f7275c[i2]).intValue());
            } else {
                throw InvalidProtocolBufferException.e();
            }
        }
    }

    public void w(Writer writer) throws IOException {
        if (this.f7273a != 0) {
            if (writer.j() == Writer.FieldOrder.ASCENDING) {
                for (int i2 = 0; i2 < this.f7273a; i2++) {
                    u(this.f7274b[i2], this.f7275c[i2], writer);
                }
                return;
            }
            for (int i3 = this.f7273a - 1; i3 >= 0; i3--) {
                u(this.f7274b[i3], this.f7275c[i3], writer);
            }
        }
    }

    private UnknownFieldSetLite(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f7276d = -1;
        this.f7273a = i2;
        this.f7274b = iArr;
        this.f7275c = objArr;
        this.f7277e = z;
    }
}
