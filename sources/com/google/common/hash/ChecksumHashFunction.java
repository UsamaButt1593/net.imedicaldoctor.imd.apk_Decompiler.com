package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;

@ElementTypesAreNonnullByDefault
@Immutable
final class ChecksumHashFunction extends AbstractHashFunction implements Serializable {
    private static final long Z = 0;
    /* access modifiers changed from: private */
    public final int X;
    private final String Y;
    private final ImmutableSupplier<? extends Checksum> s;

    private final class ChecksumHasher extends AbstractByteHasher {

        /* renamed from: b  reason: collision with root package name */
        private final Checksum f22664b;

        private ChecksumHasher(Checksum checksum) {
            this.f22664b = (Checksum) Preconditions.E(checksum);
        }

        public HashCode o() {
            long value = this.f22664b.getValue();
            return ChecksumHashFunction.this.X == 32 ? HashCode.i((int) value) : HashCode.j(value);
        }

        /* access modifiers changed from: protected */
        public void q(byte b2) {
            this.f22664b.update(b2);
        }

        /* access modifiers changed from: protected */
        public void t(byte[] bArr, int i2, int i3) {
            this.f22664b.update(bArr, i2, i3);
        }
    }

    ChecksumHashFunction(ImmutableSupplier<? extends Checksum> immutableSupplier, int i2, String str) {
        this.s = (ImmutableSupplier) Preconditions.E(immutableSupplier);
        Preconditions.k(i2 == 32 || i2 == 64, "bits (%s) must be either 32 or 64", i2);
        this.X = i2;
        this.Y = (String) Preconditions.E(str);
    }

    public Hasher b() {
        return new ChecksumHasher((Checksum) this.s.get());
    }

    public int h() {
        return this.X;
    }

    public String toString() {
        return this.Y;
    }
}
