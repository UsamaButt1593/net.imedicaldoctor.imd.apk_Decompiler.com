package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001#B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\fJ\r\u0010\r\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0003J\u001d\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0016\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001dR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0018\u0010 \u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001f¨\u0006$"}, d2 = {"Lokio/Segment;", "", "<init>", "()V", "", "data", "", "pos", "limit", "", "shared", "owner", "([BIIZZ)V", "d", "()Lokio/Segment;", "f", "b", "segment", "c", "(Lokio/Segment;)Lokio/Segment;", "byteCount", "e", "(I)Lokio/Segment;", "", "a", "sink", "g", "(Lokio/Segment;I)V", "[B", "I", "Z", "Lokio/Segment;", "next", "prev", "h", "Companion", "okio"}, k = 1, mv = {1, 5, 1})
public final class Segment {
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f31379h = new Companion((DefaultConstructorMarker) null);

    /* renamed from: i  reason: collision with root package name */
    public static final int f31380i = 8192;

    /* renamed from: j  reason: collision with root package name */
    public static final int f31381j = 1024;
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f31382a;
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public int f31383b;
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public int f31384c;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public boolean f31385d;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public boolean f31386e;
    @Nullable
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public Segment f31387f;
    @Nullable
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public Segment f31388g;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Segment() {
        this.f31382a = new byte[8192];
        this.f31386e = true;
        this.f31385d = false;
    }

    public final void a() {
        Segment segment = this.f31388g;
        int i2 = 0;
        if (segment != this) {
            Intrinsics.m(segment);
            if (segment.f31386e) {
                int i3 = this.f31384c - this.f31383b;
                Segment segment2 = this.f31388g;
                Intrinsics.m(segment2);
                int i4 = 8192 - segment2.f31384c;
                Segment segment3 = this.f31388g;
                Intrinsics.m(segment3);
                if (!segment3.f31385d) {
                    Segment segment4 = this.f31388g;
                    Intrinsics.m(segment4);
                    i2 = segment4.f31383b;
                }
                if (i3 <= i4 + i2) {
                    Segment segment5 = this.f31388g;
                    Intrinsics.m(segment5);
                    g(segment5, i3);
                    b();
                    SegmentPool.d(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    @Nullable
    public final Segment b() {
        Segment segment = this.f31387f;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.f31388g;
        Intrinsics.m(segment2);
        segment2.f31387f = this.f31387f;
        Segment segment3 = this.f31387f;
        Intrinsics.m(segment3);
        segment3.f31388g = this.f31388g;
        this.f31387f = null;
        this.f31388g = null;
        return segment;
    }

    @NotNull
    public final Segment c(@NotNull Segment segment) {
        Intrinsics.p(segment, "segment");
        segment.f31388g = this;
        segment.f31387f = this.f31387f;
        Segment segment2 = this.f31387f;
        Intrinsics.m(segment2);
        segment2.f31388g = segment;
        this.f31387f = segment;
        return segment;
    }

    @NotNull
    public final Segment d() {
        this.f31385d = true;
        return new Segment(this.f31382a, this.f31383b, this.f31384c, true, false);
    }

    @NotNull
    public final Segment e(int i2) {
        Segment segment;
        if (i2 > 0 && i2 <= this.f31384c - this.f31383b) {
            if (i2 >= 1024) {
                segment = d();
            } else {
                segment = SegmentPool.e();
                byte[] bArr = this.f31382a;
                byte[] bArr2 = segment.f31382a;
                int i3 = this.f31383b;
                ArraysKt.E0(bArr, bArr2, 0, i3, i3 + i2, 2, (Object) null);
            }
            segment.f31384c = segment.f31383b + i2;
            this.f31383b += i2;
            Segment segment2 = this.f31388g;
            Intrinsics.m(segment2);
            segment2.c(segment);
            return segment;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    @NotNull
    public final Segment f() {
        byte[] bArr = this.f31382a;
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(copyOf, this.f31383b, this.f31384c, false, true);
    }

    public final void g(@NotNull Segment segment, int i2) {
        Intrinsics.p(segment, "sink");
        if (segment.f31386e) {
            int i3 = segment.f31384c;
            if (i3 + i2 > 8192) {
                if (!segment.f31385d) {
                    int i4 = segment.f31383b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = segment.f31382a;
                        ArraysKt.E0(bArr, bArr, 0, i4, i3, 2, (Object) null);
                        segment.f31384c -= segment.f31383b;
                        segment.f31383b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f31382a;
            byte[] bArr3 = segment.f31382a;
            int i5 = segment.f31384c;
            int i6 = this.f31383b;
            ArraysKt.v0(bArr2, bArr3, i5, i6, i6 + i2);
            segment.f31384c += i2;
            this.f31383b += i2;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(@NotNull byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        Intrinsics.p(bArr, "data");
        this.f31382a = bArr;
        this.f31383b = i2;
        this.f31384c = i3;
        this.f31385d = z;
        this.f31386e = z2;
    }
}
