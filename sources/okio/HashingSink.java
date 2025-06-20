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

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001\"B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rB!\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0011\u0010 \u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019¨\u0006#"}, d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", "Ljava/security/MessageDigest;", "digest", "<init>", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "", "algorithm", "(Lokio/Sink;Ljava/lang/String;)V", "Ljavax/crypto/Mac;", "mac", "(Lokio/Sink;Ljavax/crypto/Mac;)V", "Lokio/ByteString;", "key", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "Lokio/Buffer;", "source", "", "byteCount", "", "u1", "(Lokio/Buffer;J)V", "d", "()Lokio/ByteString;", "X", "Ljava/security/MessageDigest;", "messageDigest", "Y", "Ljavax/crypto/Mac;", "e", "hash", "Z", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public final class HashingSink extends ForwardingSink implements Sink {
    @NotNull
    public static final Companion Z = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final MessageDigest X;
    @Nullable
    private final Mac Y;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\bJ\u001f\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokio/HashingSink$Companion;", "", "<init>", "()V", "Lokio/Sink;", "sink", "Lokio/HashingSink;", "d", "(Lokio/Sink;)Lokio/HashingSink;", "e", "f", "g", "Lokio/ByteString;", "key", "a", "(Lokio/Sink;Lokio/ByteString;)Lokio/HashingSink;", "b", "c", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSink a(@NotNull Sink sink, @NotNull ByteString byteString) {
            Intrinsics.p(sink, "sink");
            Intrinsics.p(byteString, "key");
            return new HashingSink(sink, byteString, InternalZipConstants.f30712f);
        }

        @JvmStatic
        @NotNull
        public final HashingSink b(@NotNull Sink sink, @NotNull ByteString byteString) {
            Intrinsics.p(sink, "sink");
            Intrinsics.p(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink c(@NotNull Sink sink, @NotNull ByteString byteString) {
            Intrinsics.p(sink, "sink");
            Intrinsics.p(byteString, "key");
            return new HashingSink(sink, byteString, "HmacSHA512");
        }

        @JvmStatic
        @NotNull
        public final HashingSink d(@NotNull Sink sink) {
            Intrinsics.p(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        @NotNull
        public final HashingSink e(@NotNull Sink sink) {
            Intrinsics.p(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink f(@NotNull Sink sink) {
            Intrinsics.p(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink g(@NotNull Sink sink) {
            Intrinsics.p(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HashingSink(@org.jetbrains.annotations.NotNull okio.Sink r2, @org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.p(r2, r0)
            java.lang.String r0 = "algorithm"
            kotlin.jvm.internal.Intrinsics.p(r3, r0)
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)
            java.lang.String r0 = "getInstance(algorithm)"
            kotlin.jvm.internal.Intrinsics.o(r3, r0)
            r1.<init>((okio.Sink) r2, (java.security.MessageDigest) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, java.lang.String):void");
    }

    @JvmStatic
    @NotNull
    public static final HashingSink f(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Z.a(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink h(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Z.b(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink i(@NotNull Sink sink, @NotNull ByteString byteString) {
        return Z.c(sink, byteString);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink k(@NotNull Sink sink) {
        return Z.d(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink n(@NotNull Sink sink) {
        return Z.e(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink p(@NotNull Sink sink) {
        return Z.f(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink q(@NotNull Sink sink) {
        return Z.g(sink);
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

    public void u1(@NotNull Buffer buffer, long j2) throws IOException {
        Intrinsics.p(buffer, "source");
        _UtilKt.e(buffer.L0(), 0, j2);
        Segment segment = buffer.s;
        Intrinsics.m(segment);
        long j3 = 0;
        while (j3 < j2) {
            int min = (int) Math.min(j2 - j3, (long) (segment.f31384c - segment.f31383b));
            MessageDigest messageDigest = this.X;
            if (messageDigest != null) {
                messageDigest.update(segment.f31382a, segment.f31383b, min);
            } else {
                Mac mac = this.Y;
                Intrinsics.m(mac);
                mac.update(segment.f31382a, segment.f31383b, min);
            }
            j3 += (long) min;
            segment = segment.f31387f;
            Intrinsics.m(segment);
        }
        super.u1(buffer, j2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull MessageDigest messageDigest) {
        super(sink);
        Intrinsics.p(sink, "sink");
        Intrinsics.p(messageDigest, "digest");
        this.X = messageDigest;
        this.Y = null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull Mac mac) {
        super(sink);
        Intrinsics.p(sink, "sink");
        Intrinsics.p(mac, "mac");
        this.Y = mac;
        this.X = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HashingSink(@org.jetbrains.annotations.NotNull okio.Sink r3, @org.jetbrains.annotations.NotNull okio.ByteString r4, @org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r0 = "sink"
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
            r2.<init>((okio.Sink) r3, (javax.crypto.Mac) r0)
            return
        L_0x002a:
            r3 = move-exception
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r4.<init>(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, okio.ByteString, java.lang.String):void");
    }
}
