package okio;

import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001!B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0018¨\u0006\""}, d2 = {"Lokio/HashingSource;", "Lokio/ForwardingSource;", "Lokio/Source;", "source", "Ljava/security/MessageDigest;", "digest", "<init>", "(Lokio/Source;Ljava/security/MessageDigest;)V", "", "algorithm", "(Lokio/Source;Ljava/lang/String;)V", "Ljavax/crypto/Mac;", "mac", "(Lokio/Source;Ljavax/crypto/Mac;)V", "Lokio/ByteString;", "key", "(Lokio/Source;Lokio/ByteString;Ljava/lang/String;)V", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "d", "()Lokio/ByteString;", "X", "Ljava/security/MessageDigest;", "messageDigest", "Y", "Ljavax/crypto/Mac;", "e", "hash", "Z", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public final class HashingSource extends ForwardingSource implements Source {
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final MessageDigest X;
    @Nullable
    private final Mac Y;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokio/HashingSource$Companion;", "", "<init>", "()V", "Lokio/Source;", "source", "Lokio/HashingSource;", "d", "(Lokio/Source;)Lokio/HashingSource;", "e", "f", "g", "Lokio/ByteString;", "key", "a", "(Lokio/Source;Lokio/ByteString;)Lokio/HashingSource;", "b", "c", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSource a(@NotNull Source source, @NotNull ByteString byteString) {
            Intrinsics.p(source, "source");
            Intrinsics.p(byteString, "key");
            return new HashingSource(source, byteString, InternalZipConstants.f30712f);
        }

        @JvmStatic
        @NotNull
        public final HashingSource b(@NotNull Source source, @NotNull ByteString byteString) {
            Intrinsics.p(source, "source");
            Intrinsics.p(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource c(@NotNull Source source, @NotNull ByteString byteString) {
            Intrinsics.p(source, "source");
            Intrinsics.p(byteString, "key");
            return new HashingSource(source, byteString, "HmacSHA512");
        }

        @JvmStatic
        @NotNull
        public final HashingSource d(@NotNull Source source) {
            Intrinsics.p(source, "source");
            return new HashingSource(source, "MD5");
        }

        @JvmStatic
        @NotNull
        public final HashingSource e(@NotNull Source source) {
            Intrinsics.p(source, "source");
            return new HashingSource(source, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSource f(@NotNull Source source) {
            Intrinsics.p(source, "source");
            return new HashingSource(source, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSource g(@NotNull Source source) {
            Intrinsics.p(source, "source");
            return new HashingSource(source, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HashingSource(@org.jetbrains.annotations.NotNull okio.Source r2, @org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "algorithm"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)
            java.lang.String r0 = "getInstance(algorithm)"
            kotlin.jvm.internal.Intrinsics.o(r3, r0)
            r1.<init>((okio.Source) r2, (java.security.MessageDigest) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, java.lang.String):void");
    }

    @JvmStatic
    @NotNull
    public static final HashingSource f(@NotNull Source source, @NotNull ByteString byteString) {
        return Z.a(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource h(@NotNull Source source, @NotNull ByteString byteString) {
        return Z.b(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource i(@NotNull Source source, @NotNull ByteString byteString) {
        return Z.c(source, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource k(@NotNull Source source) {
        return Z.d(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource n(@NotNull Source source) {
        return Z.e(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource p(@NotNull Source source) {
        return Z.f(source);
    }

    @JvmStatic
    @NotNull
    public static final HashingSource q(@NotNull Source source) {
        return Z.g(source);
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}))
    @JvmName(name = "-deprecated_hash")
    public final ByteString d() {
        return e();
    }

    @NotNull
    @JvmName(name = "hash")
    public final ByteString e() {
        byte[] bArr;
        MessageDigest messageDigest = this.X;
        if (messageDigest != null) {
            bArr = messageDigest.digest();
        } else {
            Mac mac = this.Y;
            Intrinsics.m(mac);
            bArr = mac.doFinal();
        }
        Intrinsics.o(bArr, "result");
        return new ByteString(bArr);
    }

    public long n2(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "sink");
        long n2 = super.n2(buffer, j2);
        if (n2 != -1) {
            long L0 = buffer.L0() - n2;
            long L02 = buffer.L0();
            Segment segment = buffer.s;
            Intrinsics.m(segment);
            while (L02 > L0) {
                segment = segment.f31388g;
                Intrinsics.m(segment);
                L02 -= (long) (segment.f31384c - segment.f31383b);
            }
            while (L02 < buffer.L0()) {
                int i2 = (int) ((((long) segment.f31383b) + L0) - L02);
                MessageDigest messageDigest = this.X;
                if (messageDigest != null) {
                    messageDigest.update(segment.f31382a, i2, segment.f31384c - i2);
                } else {
                    Mac mac = this.Y;
                    Intrinsics.m(mac);
                    mac.update(segment.f31382a, i2, segment.f31384c - i2);
                }
                L02 += (long) (segment.f31384c - segment.f31383b);
                segment = segment.f31387f;
                Intrinsics.m(segment);
                L0 = L02;
            }
        }
        return n2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull MessageDigest messageDigest) {
        super(source);
        Intrinsics.p(source, "source");
        Intrinsics.p(messageDigest, "digest");
        this.X = messageDigest;
        this.Y = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSource(@NotNull Source source, @NotNull Mac mac) {
        super(source);
        Intrinsics.p(source, "source");
        Intrinsics.p(mac, "mac");
        this.Y = mac;
        this.X = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HashingSource(@org.jetbrains.annotations.NotNull okio.Source r3, @org.jetbrains.annotations.NotNull okio.ByteString r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r0 = "source"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.p(r4, r0)
            java.lang.String r0 = "algorithm"
            kotlin.jvm.internal.Intrinsics.p(r5, r0)
            javax.crypto.Mac r0 = javax.crypto.Mac.getInstance(r5)     // Catch:{ InvalidKeyException -> 0x002a }
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch:{ InvalidKeyException -> 0x002a }
            byte[] r4 = r4.G0()     // Catch:{ InvalidKeyException -> 0x002a }
            r1.<init>(r4, r5)     // Catch:{ InvalidKeyException -> 0x002a }
            r0.init(r1)     // Catch:{ InvalidKeyException -> 0x002a }
            kotlin.Unit r4 = kotlin.Unit.f28779a     // Catch:{ InvalidKeyException -> 0x002a }
            java.lang.String r4 = "try {\n      Mac.getInsta…rgumentException(e)\n    }"
            kotlin.jvm.internal.Intrinsics.o(r0, r4)
            r2.<init>((okio.Source) r3, (javax.crypto.Mac) r0)
            return
        L_0x002a:
            r3 = move-exception
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSource.<init>(okio.Source, okio.ByteString, java.lang.String):void");
    }
}
