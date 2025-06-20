package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import javax.annotation.CheckForNull;
import javax.crypto.spec.SecretKeySpec;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import net.lingala.zip4j.util.InternalZipConstants;

@ElementTypesAreNonnullByDefault
public final class Hashing {

    /* renamed from: a  reason: collision with root package name */
    static final int f22675a = ((int) System.currentTimeMillis());

    @Immutable
    enum ChecksumType implements ImmutableSupplier<Checksum> {
        CRC_32("Hashing.crc32()") {
            /* renamed from: b */
            public Checksum get() {
                return new CRC32();
            }
        },
        ADLER_32("Hashing.adler32()") {
            /* renamed from: b */
            public Checksum get() {
                return new Adler32();
            }
        };
        
        public final HashFunction s;

        private ChecksumType(String str) {
            this.s = new ChecksumHashFunction(this, 32, str);
        }
    }

    private static final class ConcatenatedHashFunction extends AbstractCompositeHashFunction {
        private ConcatenatedHashFunction(HashFunction... hashFunctionArr) {
            super(hashFunctionArr);
            for (HashFunction hashFunction : hashFunctionArr) {
                Preconditions.o(hashFunction.h() % 8 == 0, "the number of bits (%s) in hashFunction (%s) must be divisible by 8", hashFunction.h(), hashFunction);
            }
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConcatenatedHashFunction) {
                return Arrays.equals(this.s, ((ConcatenatedHashFunction) obj).s);
            }
            return false;
        }

        public int h() {
            int i2 = 0;
            for (HashFunction h2 : this.s) {
                i2 += h2.h();
            }
            return i2;
        }

        public int hashCode() {
            return Arrays.hashCode(this.s);
        }

        /* access modifiers changed from: package-private */
        public HashCode m(Hasher[] hasherArr) {
            byte[] bArr = new byte[(h() / 8)];
            int i2 = 0;
            for (Hasher o : hasherArr) {
                HashCode o2 = o.o();
                i2 += o2.n(bArr, i2, o2.d() / 8);
            }
            return HashCode.h(bArr);
        }
    }

    private static final class LinearCongruentialGenerator {

        /* renamed from: a  reason: collision with root package name */
        private long f22676a;

        public LinearCongruentialGenerator(long j2) {
            this.f22676a = j2;
        }

        public double a() {
            long j2 = (this.f22676a * 2862933555777941757L) + 1;
            this.f22676a = j2;
            return ((double) (((int) (j2 >>> 33)) + 1)) / 2.147483648E9d;
        }
    }

    private static class Md5Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f22677a = new MessageDigestHashFunction("MD5", "Hashing.md5()");

        private Md5Holder() {
        }
    }

    private static class Sha1Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f22678a = new MessageDigestHashFunction("SHA-1", "Hashing.sha1()");

        private Sha1Holder() {
        }
    }

    private static class Sha256Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f22679a = new MessageDigestHashFunction("SHA-256", "Hashing.sha256()");

        private Sha256Holder() {
        }
    }

    private static class Sha384Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f22680a = new MessageDigestHashFunction("SHA-384", "Hashing.sha384()");

        private Sha384Holder() {
        }
    }

    private static class Sha512Holder {

        /* renamed from: a  reason: collision with root package name */
        static final HashFunction f22681a = new MessageDigestHashFunction("SHA-512", "Hashing.sha512()");

        private Sha512Holder() {
        }
    }

    private Hashing() {
    }

    @Deprecated
    public static HashFunction A(int i2) {
        return new Murmur3_32HashFunction(i2, false);
    }

    public static HashFunction B() {
        return Murmur3_32HashFunction.Z;
    }

    public static HashFunction C(int i2) {
        return new Murmur3_32HashFunction(i2, true);
    }

    @Deprecated
    public static HashFunction D() {
        return Sha1Holder.f22678a;
    }

    public static HashFunction E() {
        return Sha256Holder.f22679a;
    }

    public static HashFunction F() {
        return Sha384Holder.f22680a;
    }

    public static HashFunction G() {
        return Sha512Holder.f22681a;
    }

    public static HashFunction H() {
        return SipHashFunction.X2;
    }

    public static HashFunction I(long j2, long j3) {
        return new SipHashFunction(2, 4, j2, j3);
    }

    public static HashFunction a() {
        return ChecksumType.ADLER_32.s;
    }

    static int b(int i2) {
        Preconditions.e(i2 > 0, "Number of bits must be positive");
        return (i2 + 31) & -32;
    }

    public static HashCode c(Iterable<HashCode> iterable) {
        Iterator<HashCode> it2 = iterable.iterator();
        Preconditions.e(it2.hasNext(), "Must be at least 1 hash code to combine.");
        int d2 = it2.next().d() / 8;
        byte[] bArr = new byte[d2];
        for (HashCode a2 : iterable) {
            byte[] a3 = a2.a();
            Preconditions.e(a3.length == d2, "All hashcodes must have the same bit length.");
            for (int i2 = 0; i2 < a3.length; i2++) {
                bArr[i2] = (byte) ((bArr[i2] * 37) ^ a3[i2]);
            }
        }
        return HashCode.h(bArr);
    }

    public static HashCode d(Iterable<HashCode> iterable) {
        Iterator<HashCode> it2 = iterable.iterator();
        Preconditions.e(it2.hasNext(), "Must be at least 1 hash code to combine.");
        int d2 = it2.next().d() / 8;
        byte[] bArr = new byte[d2];
        for (HashCode a2 : iterable) {
            byte[] a3 = a2.a();
            Preconditions.e(a3.length == d2, "All hashcodes must have the same bit length.");
            for (int i2 = 0; i2 < a3.length; i2++) {
                bArr[i2] = (byte) (bArr[i2] + a3[i2]);
            }
        }
        return HashCode.h(bArr);
    }

    public static HashFunction e(HashFunction hashFunction, HashFunction hashFunction2, HashFunction... hashFunctionArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashFunction);
        arrayList.add(hashFunction2);
        Collections.addAll(arrayList, hashFunctionArr);
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static HashFunction f(Iterable<HashFunction> iterable) {
        Preconditions.E(iterable);
        ArrayList arrayList = new ArrayList();
        for (HashFunction add : iterable) {
            arrayList.add(add);
        }
        Preconditions.k(!arrayList.isEmpty(), "number of hash functions (%s) must be > 0", arrayList.size());
        return new ConcatenatedHashFunction((HashFunction[]) arrayList.toArray(new HashFunction[0]));
    }

    public static int g(long j2, int i2) {
        int i3 = 0;
        Preconditions.k(i2 > 0, "buckets must be positive: %s", i2);
        LinearCongruentialGenerator linearCongruentialGenerator = new LinearCongruentialGenerator(j2);
        while (true) {
            int a2 = (int) (((double) (i3 + 1)) / linearCongruentialGenerator.a());
            if (a2 < 0 || a2 >= i2) {
                return i3;
            }
            i3 = a2;
        }
        return i3;
    }

    public static int h(HashCode hashCode, int i2) {
        return g(hashCode.m(), i2);
    }

    public static HashFunction i() {
        return ChecksumType.CRC_32.s;
    }

    public static HashFunction j() {
        return Crc32cHashFunction.s;
    }

    public static HashFunction k() {
        return FarmHashFingerprint64.s;
    }

    public static HashFunction l() {
        return Fingerprint2011.s;
    }

    public static HashFunction m(int i2) {
        int b2 = b(i2);
        if (b2 == 32) {
            return Murmur3_32HashFunction.X2;
        }
        if (b2 <= 128) {
            return Murmur3_128HashFunction.Y;
        }
        int i3 = (b2 + WorkQueueKt.f29430c) / 128;
        HashFunction[] hashFunctionArr = new HashFunction[i3];
        hashFunctionArr[0] = Murmur3_128HashFunction.Y;
        int i4 = f22675a;
        for (int i5 = 1; i5 < i3; i5++) {
            i4 += 1500450271;
            hashFunctionArr[i5] = y(i4);
        }
        return new ConcatenatedHashFunction(hashFunctionArr);
    }

    public static HashFunction n(Key key) {
        return new MacHashFunction("HmacMD5", key, v("hmacMd5", key));
    }

    public static HashFunction o(byte[] bArr) {
        return n(new SecretKeySpec((byte[]) Preconditions.E(bArr), "HmacMD5"));
    }

    public static HashFunction p(Key key) {
        return new MacHashFunction(InternalZipConstants.f30712f, key, v("hmacSha1", key));
    }

    public static HashFunction q(byte[] bArr) {
        return p(new SecretKeySpec((byte[]) Preconditions.E(bArr), InternalZipConstants.f30712f));
    }

    public static HashFunction r(Key key) {
        return new MacHashFunction("HmacSHA256", key, v("hmacSha256", key));
    }

    public static HashFunction s(byte[] bArr) {
        return r(new SecretKeySpec((byte[]) Preconditions.E(bArr), "HmacSHA256"));
    }

    public static HashFunction t(Key key) {
        return new MacHashFunction("HmacSHA512", key, v("hmacSha512", key));
    }

    public static HashFunction u(byte[] bArr) {
        return t(new SecretKeySpec((byte[]) Preconditions.E(bArr), "HmacSHA512"));
    }

    private static String v(String str, Key key) {
        return "Hashing." + str + "(Key[algorithm=" + key.getAlgorithm() + ", format=" + key.getFormat() + "])";
    }

    @Deprecated
    public static HashFunction w() {
        return Md5Holder.f22677a;
    }

    public static HashFunction x() {
        return Murmur3_128HashFunction.X;
    }

    public static HashFunction y(int i2) {
        return new Murmur3_128HashFunction(i2);
    }

    @Deprecated
    public static HashFunction z() {
        return Murmur3_32HashFunction.Y;
    }
}
