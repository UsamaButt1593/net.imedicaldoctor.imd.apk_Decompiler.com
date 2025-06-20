package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.math.LongMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    /* access modifiers changed from: private */
    public final int X;
    /* access modifiers changed from: private */
    public final Funnel<? super T> Y;
    /* access modifiers changed from: private */
    public final Strategy Z;
    /* access modifiers changed from: private */
    public final BloomFilterStrategies.LockFreeBitArray s;

    private static class SerialForm<T> implements Serializable {
        private static final long X2 = 1;
        final int X;
        final Funnel<? super T> Y;
        final Strategy Z;
        final long[] s;

        SerialForm(BloomFilter<T> bloomFilter) {
            this.s = BloomFilterStrategies.LockFreeBitArray.i(bloomFilter.s.f22662a);
            this.X = bloomFilter.X;
            this.Y = bloomFilter.Y;
            this.Z = bloomFilter.Z;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.s), this.X, this.Y, this.Z);
        }
    }

    interface Strategy extends Serializable {
        <T> boolean G(@ParametricNullness T t, Funnel<? super T> funnel, int i2, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        <T> boolean g0(@ParametricNullness T t, Funnel<? super T> funnel, int i2, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i2, Funnel<? super T> funnel, Strategy strategy) {
        boolean z = false;
        Preconditions.k(i2 > 0, "numHashFunctions (%s) must be > 0", i2);
        Preconditions.k(i2 <= 255 ? true : z, "numHashFunctions (%s) must be <= 255", i2);
        this.s = (BloomFilterStrategies.LockFreeBitArray) Preconditions.E(lockFreeBitArray);
        this.X = i2;
        this.Y = (Funnel) Preconditions.E(funnel);
        this.Z = (Strategy) Preconditions.E(strategy);
    }

    public static <T> BloomFilter<T> h(Funnel<? super T> funnel, int i2) {
        return j(funnel, (long) i2);
    }

    public static <T> BloomFilter<T> i(Funnel<? super T> funnel, int i2, double d2) {
        return k(funnel, (long) i2, d2);
    }

    public static <T> BloomFilter<T> j(Funnel<? super T> funnel, long j2) {
        return k(funnel, j2, 0.03d);
    }

    public static <T> BloomFilter<T> k(Funnel<? super T> funnel, long j2, double d2) {
        return l(funnel, j2, d2, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    static <T> BloomFilter<T> l(Funnel<? super T> funnel, long j2, double d2, Strategy strategy) {
        Preconditions.E(funnel);
        boolean z = false;
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        Preconditions.p(i2 >= 0, "Expected insertions (%s) must be >= 0", j2);
        Preconditions.u(d2 > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d2));
        if (d2 < 1.0d) {
            z = true;
        }
        Preconditions.u(z, "False positive probability (%s) must be < 1.0", Double.valueOf(d2));
        Preconditions.E(strategy);
        if (i2 == 0) {
            j2 = 1;
        }
        long p = p(j2, d2);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(p), q(j2, p), funnel, strategy);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + p + " bits", e2);
        }
    }

    @VisibleForTesting
    static long p(long j2, double d2) {
        if (d2 == 0.0d) {
            d2 = Double.MIN_VALUE;
        }
        return (long) ((((double) (-j2)) * Math.log(d2)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @VisibleForTesting
    static int q(long j2, long j3) {
        return Math.max(1, (int) Math.round((((double) j3) / ((double) j2)) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> t(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i2;
        int i3;
        int readInt;
        Preconditions.F(inputStream, "InputStream");
        Preconditions.F(funnel, "Funnel");
        byte b2 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i3 = UnsignedBytes.p(dataInputStream.readByte());
            } catch (RuntimeException e2) {
                e = e2;
                i3 = -1;
                b2 = readByte;
                i2 = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + b2 + " numHashFunctions: " + i3 + " dataLength: " + i2, e);
            }
            try {
                readInt = dataInputStream.readInt();
            } catch (RuntimeException e3) {
                e = e3;
                b2 = readByte;
                i2 = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + b2 + " numHashFunctions: " + i3 + " dataLength: " + i2, e);
            }
            try {
                BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                BloomFilterStrategies.LockFreeBitArray lockFreeBitArray = new BloomFilterStrategies.LockFreeBitArray(LongMath.d((long) readInt, 64));
                for (int i4 = 0; i4 < readInt; i4++) {
                    lockFreeBitArray.g(i4, dataInputStream.readLong());
                }
                return new BloomFilter<>(lockFreeBitArray, i3, funnel, bloomFilterStrategies);
            } catch (RuntimeException e4) {
                e = e4;
                int i5 = readInt;
                b2 = readByte;
                i2 = i5;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + b2 + " numHashFunctions: " + i3 + " dataLength: " + i2, e);
            }
        } catch (RuntimeException e5) {
            e = e5;
            i2 = -1;
            i3 = -1;
            throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + b2 + " numHashFunctions: " + i3 + " dataLength: " + i2, e);
        }
    }

    private void u(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object v() {
        return new SerialForm(this);
    }

    @Deprecated
    public boolean apply(@ParametricNullness T t) {
        return o(t);
    }

    public long e() {
        double b2 = (double) this.s.b();
        return DoubleMath.q(((-Math.log1p(-(((double) this.s.a()) / b2))) * b2) / ((double) this.X), RoundingMode.HALF_UP);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.X == bloomFilter.X && this.Y.equals(bloomFilter.Y) && this.s.equals(bloomFilter.s) && this.Z.equals(bloomFilter.Z);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public long f() {
        return this.s.b();
    }

    public BloomFilter<T> g() {
        return new BloomFilter<>(this.s.c(), this.X, this.Y, this.Z);
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.X), this.Y, this.Z, this.s);
    }

    public double m() {
        return Math.pow(((double) this.s.a()) / ((double) f()), (double) this.X);
    }

    public boolean n(BloomFilter<T> bloomFilter) {
        Preconditions.E(bloomFilter);
        return this != bloomFilter && this.X == bloomFilter.X && f() == bloomFilter.f() && this.Z.equals(bloomFilter.Z) && this.Y.equals(bloomFilter.Y);
    }

    public boolean o(@ParametricNullness T t) {
        return this.Z.G(t, this.Y, this.X, this.s);
    }

    @CanIgnoreReturnValue
    public boolean r(@ParametricNullness T t) {
        return this.Z.g0(t, this.Y, this.X, this.s);
    }

    public void s(BloomFilter<T> bloomFilter) {
        Preconditions.E(bloomFilter);
        Preconditions.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i2 = this.X;
        int i3 = bloomFilter.X;
        Preconditions.m(i2 == i3, "BloomFilters must have the same number of hash functions (%s != %s)", i2, i3);
        Preconditions.s(f() == bloomFilter.f(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", f(), bloomFilter.f());
        Preconditions.y(this.Z.equals(bloomFilter.Z), "BloomFilters must have equal strategies (%s != %s)", this.Z, bloomFilter.Z);
        Preconditions.y(this.Y.equals(bloomFilter.Y), "BloomFilters must have equal funnels (%s != %s)", this.Y, bloomFilter.Y);
        this.s.f(bloomFilter.s);
    }

    public void w(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.a((long) this.Z.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.a((long) this.X));
        dataOutputStream.writeInt(this.s.f22662a.length());
        for (int i2 = 0; i2 < this.s.f22662a.length(); i2++) {
            dataOutputStream.writeLong(this.s.f22662a.get(i2));
        }
    }
}
