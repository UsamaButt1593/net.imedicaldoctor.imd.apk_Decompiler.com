package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lokio/PeekSource;", "Lokio/Source;", "Lokio/BufferedSource;", "upstream", "<init>", "(Lokio/BufferedSource;)V", "Lokio/Buffer;", "sink", "", "byteCount", "n2", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "j", "()Lokio/Timeout;", "", "close", "()V", "s", "Lokio/BufferedSource;", "X", "Lokio/Buffer;", "buffer", "Lokio/Segment;", "Y", "Lokio/Segment;", "expectedSegment", "", "Z", "I", "expectedPos", "", "X2", "closed", "Y2", "J", "pos", "okio"}, k = 1, mv = {1, 5, 1})
public final class PeekSource implements Source {
    @NotNull
    private final Buffer X;
    private boolean X2;
    @Nullable
    private Segment Y;
    private long Y2;
    private int Z;
    @NotNull
    private final BufferedSource s;

    public PeekSource(@NotNull BufferedSource bufferedSource) {
        Intrinsics.p(bufferedSource, "upstream");
        this.s = bufferedSource;
        Buffer m2 = bufferedSource.m();
        this.X = m2;
        Segment segment = m2.s;
        this.Y = segment;
        this.Z = segment == null ? -1 : segment.f31383b;
    }

    public void close() {
        this.X2 = true;
    }

    @NotNull
    public Timeout j() {
        return this.s.j();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r5 == r6.f31383b) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long n2(@org.jetbrains.annotations.NotNull okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.p(r9, r0)
            r0 = 0
            r1 = 1
            r2 = 0
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 < 0) goto L_0x000f
            r5 = 1
            goto L_0x0010
        L_0x000f:
            r5 = 0
        L_0x0010:
            if (r5 == 0) goto L_0x0087
            boolean r5 = r8.X2
            r5 = r5 ^ r1
            if (r5 == 0) goto L_0x007b
            okio.Segment r5 = r8.Y
            if (r5 == 0) goto L_0x002a
            okio.Buffer r6 = r8.X
            okio.Segment r6 = r6.s
            if (r5 != r6) goto L_0x002b
            int r5 = r8.Z
            kotlin.jvm.internal.Intrinsics.m(r6)
            int r6 = r6.f31383b
            if (r5 != r6) goto L_0x002b
        L_0x002a:
            r0 = 1
        L_0x002b:
            if (r0 == 0) goto L_0x006f
            if (r4 != 0) goto L_0x0030
            return r2
        L_0x0030:
            okio.BufferedSource r0 = r8.s
            long r1 = r8.Y2
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L_0x0040
            r9 = -1
            return r9
        L_0x0040:
            okio.Segment r0 = r8.Y
            if (r0 != 0) goto L_0x0053
            okio.Buffer r0 = r8.X
            okio.Segment r0 = r0.s
            if (r0 == 0) goto L_0x0053
            r8.Y = r0
            kotlin.jvm.internal.Intrinsics.m(r0)
            int r0 = r0.f31383b
            r8.Z = r0
        L_0x0053:
            okio.Buffer r0 = r8.X
            long r0 = r0.L0()
            long r2 = r8.Y2
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.X
            long r4 = r8.Y2
            r3 = r9
            r6 = r10
            r2.r(r3, r4, r6)
            long r0 = r8.Y2
            long r0 = r0 + r10
            r8.Y2 = r0
            return r10
        L_0x006f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x007b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0087:
            java.lang.Long r9 = java.lang.Long.valueOf(r10)
            java.lang.String r10 = "byteCount < 0: "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.C(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.n2(okio.Buffer, long):long");
    }
}
