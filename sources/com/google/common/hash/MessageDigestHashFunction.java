package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
@Immutable
final class MessageDigestHashFunction extends AbstractHashFunction implements Serializable {
    private final int X;
    private final boolean Y;
    private final String Z;
    private final MessageDigest s;

    private static final class MessageDigestHasher extends AbstractByteHasher {

        /* renamed from: b  reason: collision with root package name */
        private final MessageDigest f22687b;

        /* renamed from: c  reason: collision with root package name */
        private final int f22688c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f22689d;

        private MessageDigestHasher(MessageDigest messageDigest, int i2) {
            this.f22687b = messageDigest;
            this.f22688c = i2;
        }

        private void u() {
            Preconditions.h0(!this.f22689d, "Cannot re-use a Hasher after calling hash() on it");
        }

        public HashCode o() {
            u();
            this.f22689d = true;
            return this.f22688c == this.f22687b.getDigestLength() ? HashCode.h(this.f22687b.digest()) : HashCode.h(Arrays.copyOf(this.f22687b.digest(), this.f22688c));
        }

        /* access modifiers changed from: protected */
        public void q(byte b2) {
            u();
            this.f22687b.update(b2);
        }

        /* access modifiers changed from: protected */
        public void r(ByteBuffer byteBuffer) {
            u();
            this.f22687b.update(byteBuffer);
        }

        /* access modifiers changed from: protected */
        public void t(byte[] bArr, int i2, int i3) {
            u();
            this.f22687b.update(bArr, i2, i3);
        }
    }

    private static final class SerializedForm implements Serializable {
        private static final long Z = 0;
        private final int X;
        private final String Y;
        private final String s;

        private SerializedForm(String str, int i2, String str2) {
            this.s = str;
            this.X = i2;
            this.Y = str2;
        }

        private Object a() {
            return new MessageDigestHashFunction(this.s, this.X, this.Y);
        }
    }

    MessageDigestHashFunction(String str, int i2, String str2) {
        this.Z = (String) Preconditions.E(str2);
        MessageDigest l2 = l(str);
        this.s = l2;
        int digestLength = l2.getDigestLength();
        Preconditions.m(i2 >= 4 && i2 <= digestLength, "bytes (%s) must be >= 4 and < %s", i2, digestLength);
        this.X = i2;
        this.Y = n(l2);
    }

    private static MessageDigest l(String str) {
        try {
            return MessageDigest.getInstance(str);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private static boolean n(MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public Hasher b() {
        if (this.Y) {
            try {
                return new MessageDigestHasher((MessageDigest) this.s.clone(), this.X);
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MessageDigestHasher(l(this.s.getAlgorithm()), this.X);
    }

    public int h() {
        return this.X * 8;
    }

    /* access modifiers changed from: package-private */
    public Object o() {
        return new SerializedForm(this.s.getAlgorithm(), this.X, this.Z);
    }

    public String toString() {
        return this.Z;
    }

    MessageDigestHashFunction(String str, String str2) {
        MessageDigest l2 = l(str);
        this.s = l2;
        this.X = l2.getDigestLength();
        this.Z = (String) Preconditions.E(str2);
        this.Y = n(l2);
    }
}
