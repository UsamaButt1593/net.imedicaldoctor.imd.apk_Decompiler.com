package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

@ElementTypesAreNonnullByDefault
@Immutable
final class MacHashFunction extends AbstractHashFunction {
    private final Key X;
    private final boolean X2;
    private final String Y;
    private final int Z;
    private final Mac s;

    private static final class MacHasher extends AbstractByteHasher {

        /* renamed from: b  reason: collision with root package name */
        private final Mac f22685b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f22686c;

        private MacHasher(Mac mac) {
            this.f22685b = mac;
        }

        private void u() {
            Preconditions.h0(!this.f22686c, "Cannot re-use a Hasher after calling hash() on it");
        }

        public HashCode o() {
            u();
            this.f22686c = true;
            return HashCode.h(this.f22685b.doFinal());
        }

        /* access modifiers changed from: protected */
        public void q(byte b2) {
            u();
            this.f22685b.update(b2);
        }

        /* access modifiers changed from: protected */
        public void r(ByteBuffer byteBuffer) {
            u();
            Preconditions.E(byteBuffer);
            this.f22685b.update(byteBuffer);
        }

        /* access modifiers changed from: protected */
        public void s(byte[] bArr) {
            u();
            this.f22685b.update(bArr);
        }

        /* access modifiers changed from: protected */
        public void t(byte[] bArr, int i2, int i3) {
            u();
            this.f22685b.update(bArr, i2, i3);
        }
    }

    MacHashFunction(String str, Key key, String str2) {
        Mac l2 = l(str, key);
        this.s = l2;
        this.X = (Key) Preconditions.E(key);
        this.Y = (String) Preconditions.E(str2);
        this.Z = l2.getMacLength() * 8;
        this.X2 = m(l2);
    }

    private static Mac l(String str, Key key) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(key);
            return instance;
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        } catch (InvalidKeyException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    private static boolean m(Mac mac) {
        try {
            mac.clone();
            return true;
        } catch (CloneNotSupportedException unused) {
            return false;
        }
    }

    public Hasher b() {
        if (this.X2) {
            try {
                return new MacHasher((Mac) this.s.clone());
            } catch (CloneNotSupportedException unused) {
            }
        }
        return new MacHasher(l(this.s.getAlgorithm(), this.X));
    }

    public int h() {
        return this.Z;
    }

    public String toString() {
        return this.Y;
    }
}
