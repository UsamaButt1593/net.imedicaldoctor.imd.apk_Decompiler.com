package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Random.kt\nkotlin/random/Random\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,383:1\n1#2:384\n*E\n"})
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\r\b'\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J+\u0010'\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010%\u001a\u00020\u00042\b\b\u0002\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010,\u001a\u00020#2\u0006\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010-¨\u00060"}, d2 = {"Lkotlin/random/Random;", "", "<init>", "()V", "", "bitCount", "b", "(I)I", "l", "()I", "until", "m", "from", "n", "(II)I", "", "o", "()J", "p", "(J)J", "q", "(JJ)J", "", "c", "()Z", "", "h", "()D", "i", "(D)D", "j", "(DD)D", "", "k", "()F", "", "array", "fromIndex", "toIndex", "f", "([BII)[B", "e", "([B)[B", "size", "d", "(I)[B", "s", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public abstract class Random {
    /* access modifiers changed from: private */
    @NotNull
    public static final Random X = PlatformImplementationsKt.f28815a.b();
    @NotNull
    public static final Default s = new Default((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u00015B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\fJ\u001f\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010#\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020(2\u0006\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b-\u0010.J'\u00101\u001a\u00020(2\u0006\u0010)\u001a\u00020(2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "", "r", "()Ljava/lang/Object;", "", "bitCount", "b", "(I)I", "l", "()I", "until", "m", "from", "n", "(II)I", "", "o", "()J", "p", "(J)J", "q", "(JJ)J", "", "c", "()Z", "", "h", "()D", "i", "(D)D", "j", "(DD)D", "", "k", "()F", "", "array", "e", "([B)[B", "size", "d", "(I)[B", "fromIndex", "toIndex", "f", "([BII)[B", "defaultRandom", "Lkotlin/random/Random;", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
    public static final class Default extends Random implements Serializable {

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "", "a", "()Ljava/lang/Object;", "", "X", "J", "serialVersionUID", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
        private static final class Serialized implements Serializable {
            private static final long X = 0;
            @NotNull
            public static final Serialized s = new Serialized();

            private Serialized() {
            }

            private final Object a() {
                return Random.s;
            }
        }

        private Default() {
        }

        private final Object r() {
            return Serialized.s;
        }

        public int b(int i2) {
            return Random.X.b(i2);
        }

        public boolean c() {
            return Random.X.c();
        }

        @NotNull
        public byte[] d(int i2) {
            return Random.X.d(i2);
        }

        @NotNull
        public byte[] e(@NotNull byte[] bArr) {
            Intrinsics.p(bArr, "array");
            return Random.X.e(bArr);
        }

        @NotNull
        public byte[] f(@NotNull byte[] bArr, int i2, int i3) {
            Intrinsics.p(bArr, "array");
            return Random.X.f(bArr, i2, i3);
        }

        public double h() {
            return Random.X.h();
        }

        public double i(double d2) {
            return Random.X.i(d2);
        }

        public double j(double d2, double d3) {
            return Random.X.j(d2, d3);
        }

        public float k() {
            return Random.X.k();
        }

        public int l() {
            return Random.X.l();
        }

        public int m(int i2) {
            return Random.X.m(i2);
        }

        public int n(int i2, int i3) {
            return Random.X.n(i2, i3);
        }

        public long o() {
            return Random.X.o();
        }

        public long p(long j2) {
            return Random.X.p(j2);
        }

        public long q(long j2, long j3) {
            return Random.X.q(j2, j3);
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ byte[] g(Random random, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return random.f(bArr, i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int b(int i2);

    public boolean c() {
        return b(1) != 0;
    }

    @NotNull
    public byte[] d(int i2) {
        return e(new byte[i2]);
    }

    @NotNull
    public byte[] e(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "array");
        return f(bArr, 0, bArr.length);
    }

    @NotNull
    public byte[] f(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "array");
        if (!new IntRange(0, bArr.length).q(i2) || !new IntRange(0, bArr.length).q(i3)) {
            throw new IllegalArgumentException(("fromIndex (" + i2 + ") or toIndex (" + i3 + ") are out of range: 0.." + bArr.length + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
        } else if (i2 <= i3) {
            int i4 = (i3 - i2) / 4;
            for (int i5 = 0; i5 < i4; i5++) {
                int l2 = l();
                bArr[i2] = (byte) l2;
                bArr[i2 + 1] = (byte) (l2 >>> 8);
                bArr[i2 + 2] = (byte) (l2 >>> 16);
                bArr[i2 + 3] = (byte) (l2 >>> 24);
                i2 += 4;
            }
            int i6 = i3 - i2;
            int b2 = b(i6 * 8);
            for (int i7 = 0; i7 < i6; i7++) {
                bArr[i2 + i7] = (byte) (b2 >>> (i7 * 8));
            }
            return bArr;
        } else {
            throw new IllegalArgumentException(("fromIndex (" + i2 + ") must be not greater than toIndex (" + i3 + ").").toString());
        }
    }

    public double h() {
        return PlatformRandomKt.d(b(26), b(27));
    }

    public double i(double d2) {
        return j(0.0d, d2);
    }

    public double j(double d2, double d3) {
        double d4;
        RandomKt.d(d2, d3);
        double d5 = d3 - d2;
        if (!Double.isInfinite(d5) || Double.isInfinite(d2) || Double.isNaN(d2) || Double.isInfinite(d3) || Double.isNaN(d3)) {
            d4 = d2 + (h() * d5);
        } else {
            double d6 = (double) 2;
            double h2 = h() * ((d3 / d6) - (d2 / d6));
            d4 = d2 + h2 + h2;
        }
        return d4 >= d3 ? Math.nextAfter(d3, Double.NEGATIVE_INFINITY) : d4;
    }

    public float k() {
        return ((float) b(24)) / 1.6777216E7f;
    }

    public int l() {
        return b(32);
    }

    public int m(int i2) {
        return n(0, i2);
    }

    public int n(int i2, int i3) {
        int i4;
        int l2;
        int i5;
        RandomKt.e(i2, i3);
        int i6 = i3 - i2;
        if (i6 > 0 || i6 == Integer.MIN_VALUE) {
            if (((-i6) & i6) == i6) {
                i4 = b(RandomKt.g(i6));
            } else {
                do {
                    l2 = l() >>> 1;
                    i5 = l2 % i6;
                } while ((l2 - i5) + (i6 - 1) < 0);
                i4 = i5;
            }
            return i2 + i4;
        }
        while (true) {
            int l3 = l();
            if (i2 <= l3 && l3 < i3) {
                return l3;
            }
        }
    }

    public long o() {
        return (((long) l()) << 32) + ((long) l());
    }

    public long p(long j2) {
        return q(0, j2);
    }

    public long q(long j2, long j3) {
        long j4;
        long o;
        long j5;
        int l2;
        RandomKt.f(j2, j3);
        long j6 = j3 - j2;
        if (j6 > 0) {
            if (((-j6) & j6) == j6) {
                int i2 = (int) j6;
                int i3 = (int) (j6 >>> 32);
                if (i2 != 0) {
                    l2 = b(RandomKt.g(i2));
                } else if (i3 == 1) {
                    l2 = l();
                } else {
                    j4 = (((long) b(RandomKt.g(i3))) << 32) + (((long) l()) & InternalZipConstants.f30717k);
                }
                j4 = ((long) l2) & InternalZipConstants.f30717k;
            } else {
                do {
                    o = o() >>> 1;
                    j5 = o % j6;
                } while ((o - j5) + (j6 - 1) < 0);
                j4 = j5;
            }
            return j2 + j4;
        }
        while (true) {
            long o2 = o();
            if (j2 <= o2 && o2 < j3) {
                return o2;
            }
        }
    }
}
