package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010!\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001c\u0010\u001fR\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010$R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b\"\u0010'R\u0017\u0010\u000f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b%\u0010\u001fR\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b\u0015\u0010*¨\u0006,"}, d2 = {"Lokio/internal/ZipEntry;", "", "Lokio/Path;", "canonicalPath", "", "isDirectory", "", "comment", "", "crc", "compressedSize", "size", "", "compressionMethod", "lastModifiedAtMillis", "offset", "<init>", "(Lokio/Path;ZLjava/lang/String;JJJILjava/lang/Long;J)V", "a", "Lokio/Path;", "()Lokio/Path;", "b", "Z", "j", "()Z", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "d", "J", "f", "()J", "e", "i", "g", "I", "()I", "h", "Ljava/lang/Long;", "()Ljava/lang/Long;", "", "Ljava/util/List;", "()Ljava/util/List;", "children", "okio"}, k = 1, mv = {1, 5, 1})
public final class ZipEntry {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Path f31428a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f31429b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f31430c;

    /* renamed from: d  reason: collision with root package name */
    private final long f31431d;

    /* renamed from: e  reason: collision with root package name */
    private final long f31432e;

    /* renamed from: f  reason: collision with root package name */
    private final long f31433f;

    /* renamed from: g  reason: collision with root package name */
    private final int f31434g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Long f31435h;

    /* renamed from: i  reason: collision with root package name */
    private final long f31436i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final List<Path> f31437j;

    public ZipEntry(@NotNull Path path, boolean z, @NotNull String str, long j2, long j3, long j4, int i2, @Nullable Long l2, long j5) {
        Intrinsics.p(path, "canonicalPath");
        Intrinsics.p(str, Cookie2.COMMENT);
        this.f31428a = path;
        this.f31429b = z;
        this.f31430c = str;
        this.f31431d = j2;
        this.f31432e = j3;
        this.f31433f = j4;
        this.f31434g = i2;
        this.f31435h = l2;
        this.f31436i = j5;
        this.f31437j = new ArrayList();
    }

    @NotNull
    public final Path a() {
        return this.f31428a;
    }

    @NotNull
    public final List<Path> b() {
        return this.f31437j;
    }

    @NotNull
    public final String c() {
        return this.f31430c;
    }

    public final long d() {
        return this.f31432e;
    }

    public final int e() {
        return this.f31434g;
    }

    public final long f() {
        return this.f31431d;
    }

    @Nullable
    public final Long g() {
        return this.f31435h;
    }

    public final long h() {
        return this.f31436i;
    }

    public final long i() {
        return this.f31433f;
    }

    public final boolean j() {
        return this.f31429b;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ZipEntry(okio.Path r14, boolean r15, java.lang.String r16, long r17, long r19, long r21, int r23, java.lang.Long r24, long r25, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r13 = this;
            r0 = r27
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x0009
        L_0x0008:
            r1 = r15
        L_0x0009:
            r2 = r0 & 4
            if (r2 == 0) goto L_0x0010
            java.lang.String r2 = ""
            goto L_0x0012
        L_0x0010:
            r2 = r16
        L_0x0012:
            r3 = r0 & 8
            r4 = -1
            if (r3 == 0) goto L_0x001a
            r6 = r4
            goto L_0x001c
        L_0x001a:
            r6 = r17
        L_0x001c:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0022
            r8 = r4
            goto L_0x0024
        L_0x0022:
            r8 = r19
        L_0x0024:
            r3 = r0 & 32
            if (r3 == 0) goto L_0x002a
            r10 = r4
            goto L_0x002c
        L_0x002a:
            r10 = r21
        L_0x002c:
            r3 = r0 & 64
            if (r3 == 0) goto L_0x0032
            r3 = -1
            goto L_0x0034
        L_0x0032:
            r3 = r23
        L_0x0034:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x003a
            r12 = 0
            goto L_0x003c
        L_0x003a:
            r12 = r24
        L_0x003c:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r4 = r25
        L_0x0043:
            r15 = r13
            r16 = r14
            r17 = r1
            r18 = r2
            r19 = r6
            r21 = r8
            r23 = r10
            r25 = r3
            r26 = r12
            r27 = r4
            r15.<init>(r16, r17, r18, r19, r21, r23, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipEntry.<init>(okio.Path, boolean, java.lang.String, long, long, long, int, java.lang.Long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
