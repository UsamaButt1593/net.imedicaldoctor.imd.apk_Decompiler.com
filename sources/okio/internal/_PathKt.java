package okio.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0005\n\u0002\b\u001a\u001a\u0016\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003*\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\u0006\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u000f\u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u0000H\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0004*\u00020\u0000H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0017\u0010\u0002\u001a\u0013\u0010\u0018\u001a\u00020\f*\u00020\u0000H\u0002¢\u0006\u0004\b\u0018\u0010\u000e\u001a\u0014\u0010\u0019\u001a\u00020\f*\u00020\u0000H\b¢\u0006\u0004\b\u0019\u0010\u000e\u001a$\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\fH\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a$\u0010\u001e\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\fH\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a$\u0010!\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001a\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\fH\b¢\u0006\u0004\b!\u0010\"\u001a#\u0010#\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0000¢\u0006\u0004\b#\u0010$\u001a\u001c\u0010&\u001a\u00020\u0000*\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\b¢\u0006\u0004\b&\u0010'\u001a\u0014\u0010(\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b(\u0010\u0002\u001a\u001c\u0010)\u001a\u00020\t*\u00020\u00002\u0006\u0010%\u001a\u00020\u0000H\b¢\u0006\u0004\b)\u0010*\u001a\u001e\u0010,\u001a\u00020\f*\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010+H\b¢\u0006\u0004\b,\u0010-\u001a\u0014\u0010.\u001a\u00020\t*\u00020\u0000H\b¢\u0006\u0004\b.\u0010\u000b\u001a\u0014\u0010/\u001a\u00020\u0004*\u00020\u0000H\b¢\u0006\u0004\b/\u0010\u0016\u001a\u0019\u00100\u001a\u00020\u0000*\u00020\u00042\u0006\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b0\u00101\u001a\u001b\u00102\u001a\u00020\u0000*\u00020 2\u0006\u0010\u001b\u001a\u00020\fH\u0000¢\u0006\u0004\b2\u00103\u001a\u0013\u00104\u001a\u00020\u0007*\u00020\u0004H\u0002¢\u0006\u0004\b4\u00105\u001a\u0013\u00107\u001a\u00020\u0007*\u000206H\u0002¢\u0006\u0004\b7\u00108\u001a\u001b\u0010:\u001a\u00020\f*\u00020 2\u0006\u00109\u001a\u00020\u0007H\u0002¢\u0006\u0004\b:\u0010;\"\u001a\u0010@\u001a\u00020\u00078\u0002X\u0004¢\u0006\f\n\u0004\b<\u0010=\u0012\u0004\b>\u0010?\"\u001a\u0010C\u001a\u00020\u00078\u0002X\u0004¢\u0006\f\n\u0004\bA\u0010=\u0012\u0004\bB\u0010?\"\u001a\u0010F\u001a\u00020\u00078\u0002X\u0004¢\u0006\f\n\u0004\bD\u0010=\u0012\u0004\bE\u0010?\"\u001a\u0010I\u001a\u00020\u00078\u0002X\u0004¢\u0006\f\n\u0004\bG\u0010=\u0012\u0004\bH\u0010?\"\u001a\u0010L\u001a\u00020\u00078\u0002X\u0004¢\u0006\f\n\u0004\bJ\u0010=\u0012\u0004\bK\u0010?\"\u0018\u0010N\u001a\u00020\t*\u00020\u00008BX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u000b\"\u001a\u00109\u001a\u0004\u0018\u00010\u0007*\u00020\u00008BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0014¨\u0006P"}, d2 = {"Lokio/Path;", "y", "(Lokio/Path;)Lokio/Path;", "", "", "z", "(Lokio/Path;)Ljava/util/List;", "Lokio/ByteString;", "A", "", "M", "(Lokio/Path;)I", "", "m", "(Lokio/Path;)Z", "n", "", "D", "(Lokio/Path;)Ljava/lang/Character;", "q", "(Lokio/Path;)Lokio/ByteString;", "p", "(Lokio/Path;)Ljava/lang/String;", "s", "L", "o", "child", "normalize", "u", "(Lokio/Path;Ljava/lang/String;Z)Lokio/Path;", "w", "(Lokio/Path;Lokio/ByteString;Z)Lokio/Path;", "Lokio/Buffer;", "v", "(Lokio/Path;Lokio/Buffer;Z)Lokio/Path;", "x", "(Lokio/Path;Lokio/Path;Z)Lokio/Path;", "other", "t", "(Lokio/Path;Lokio/Path;)Lokio/Path;", "r", "j", "(Lokio/Path;Lokio/Path;)I", "", "k", "(Lokio/Path;Ljava/lang/Object;)Z", "l", "C", "B", "(Ljava/lang/String;Z)Lokio/Path;", "O", "(Lokio/Buffer;Z)Lokio/Path;", "Q", "(Ljava/lang/String;)Lokio/ByteString;", "", "P", "(B)Lokio/ByteString;", "slash", "N", "(Lokio/Buffer;Lokio/ByteString;)Z", "a", "Lokio/ByteString;", "J", "()V", "SLASH", "b", "F", "BACKSLASH", "c", "E", "ANY_SLASH", "d", "G", "DOT", "e", "H", "DOT_DOT", "I", "indexOfLastSlash", "K", "okio"}, k = 2, mv = {1, 5, 1})
public final class _PathKt {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f31455a;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final ByteString f31456b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final ByteString f31457c;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f31458d;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f31459e;

    static {
        ByteString.Companion companion = ByteString.Z;
        f31455a = companion.l("/");
        f31456b = companion.l("\\");
        f31457c = companion.l("/\\");
        f31458d = companion.l(".");
        f31459e = companion.l("..");
    }

    @NotNull
    public static final List<ByteString> A(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        ArrayList arrayList = new ArrayList();
        int h2 = M(path);
        if (h2 == -1) {
            h2 = 0;
        } else if (h2 < path.i().m0() && path.i().q(h2) == ((byte) 92)) {
            h2++;
        }
        int m0 = path.i().m0();
        if (h2 < m0) {
            int i2 = h2;
            while (true) {
                int i3 = h2 + 1;
                if (path.i().q(h2) == ((byte) 47) || path.i().q(h2) == ((byte) 92)) {
                    arrayList.add(path.i().A0(i2, h2));
                    i2 = i3;
                }
                if (i3 >= m0) {
                    break;
                }
                h2 = i3;
            }
            h2 = i2;
        }
        if (h2 < path.i().m0()) {
            arrayList.add(path.i().A0(h2, path.i().m0()));
        }
        return arrayList;
    }

    @NotNull
    public static final Path B(@NotNull String str, boolean z) {
        Intrinsics.p(str, "<this>");
        return O(new Buffer().W0(str), z);
    }

    @NotNull
    public static final String C(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        return path.i().I0();
    }

    @Nullable
    public static final Character D(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        if (ByteString.H(path.i(), f31455a, 0, 2, (Object) null) != -1 || path.i().m0() < 2 || path.i().q(1) != ((byte) 58)) {
            return null;
        }
        char q = (char) path.i().q(0);
        if (('a' > q || q > 'z') && ('A' > q || q > 'Z')) {
            return null;
        }
        return Character.valueOf(q);
    }

    private static /* synthetic */ void E() {
    }

    private static /* synthetic */ void F() {
    }

    private static /* synthetic */ void G() {
    }

    private static /* synthetic */ void H() {
    }

    /* access modifiers changed from: private */
    public static final int I(Path path) {
        int Q = ByteString.Q(path.i(), f31455a, 0, 2, (Object) null);
        return Q != -1 ? Q : ByteString.Q(path.i(), f31456b, 0, 2, (Object) null);
    }

    private static /* synthetic */ void J() {
    }

    /* access modifiers changed from: private */
    public static final ByteString K(Path path) {
        ByteString i2 = path.i();
        ByteString byteString = f31455a;
        if (ByteString.H(i2, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString i3 = path.i();
        ByteString byteString2 = f31456b;
        if (ByteString.H(i3, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final boolean L(Path path) {
        return path.i().o(f31459e) && (path.i().m0() == 2 || path.i().Z(path.i().m0() + -3, f31455a, 0, 1) || path.i().Z(path.i().m0() + -3, f31456b, 0, 1));
    }

    /* access modifiers changed from: private */
    public static final int M(Path path) {
        if (path.i().m0() == 0) {
            return -1;
        }
        if (path.i().q(0) == ((byte) 47)) {
            return 1;
        }
        byte b2 = (byte) 92;
        if (path.i().q(0) != b2) {
            if (path.i().m0() > 2 && path.i().q(1) == ((byte) 58) && path.i().q(2) == b2) {
                char q = (char) path.i().q(0);
                if ('a' > q || q > 'z') {
                    return ('A' > q || q > 'Z') ? -1 : 3;
                }
                return 3;
            }
        } else if (path.i().m0() <= 2 || path.i().q(1) != b2) {
            return 1;
        } else {
            int D = path.i().D(f31456b, 2);
            return D == -1 ? path.i().m0() : D;
        }
    }

    private static final boolean N(Buffer buffer, ByteString byteString) {
        if (!Intrinsics.g(byteString, f31456b) || buffer.L0() < 2 || buffer.y(1) != ((byte) 58)) {
            return false;
        }
        char y = (char) buffer.y(0);
        return ('a' <= y && y <= 'z') || ('A' <= y && y <= 'Z');
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ee A[LOOP:2: B:62:0x00ee->B:67:0x0101, LOOP_START, PHI: r3 
      PHI: (r3v1 int) = (r3v0 int), (r3v4 int) binds: [B:61:0x00ec, B:67:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010b  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.Path O(@org.jetbrains.annotations.NotNull okio.Buffer r16, boolean r17) {
        /*
            r0 = r16
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r0, r1)
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x000f:
            okio.ByteString r5 = f31455a
            r6 = 0
            boolean r5 = r0.b1(r6, r5)
            if (r5 != 0) goto L_0x011a
            okio.ByteString r5 = f31456b
            boolean r8 = r0.b1(r6, r5)
            if (r8 == 0) goto L_0x0023
            goto L_0x011a
        L_0x0023:
            r8 = 2
            r9 = 1
            if (r4 < r8) goto L_0x002f
            boolean r5 = kotlin.jvm.internal.Intrinsics.g(r2, r5)
            if (r5 == 0) goto L_0x002f
            r5 = 1
            goto L_0x0030
        L_0x002f:
            r5 = 0
        L_0x0030:
            r10 = -1
            if (r5 == 0) goto L_0x003e
            kotlin.jvm.internal.Intrinsics.m(r2)
            r1.g2(r2)
        L_0x003a:
            r1.g2(r2)
            goto L_0x0074
        L_0x003e:
            if (r4 <= 0) goto L_0x0044
            kotlin.jvm.internal.Intrinsics.m(r2)
            goto L_0x003a
        L_0x0044:
            okio.ByteString r4 = f31457c
            long r12 = r0.z0(r4)
            if (r2 != 0) goto L_0x005f
            int r2 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x0057
            java.lang.String r2 = okio.Path.Y
            okio.ByteString r2 = Q(r2)
            goto L_0x005f
        L_0x0057:
            byte r2 = r0.y(r12)
            okio.ByteString r2 = P(r2)
        L_0x005f:
            boolean r4 = N(r0, r2)
            if (r4 == 0) goto L_0x0074
            r14 = 2
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x0071
            r12 = 3
            r1.u1(r0, r12)
            goto L_0x0074
        L_0x0071:
            r1.u1(r0, r14)
        L_0x0074:
            long r12 = r1.L0()
            int r4 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x007e
            r4 = 1
            goto L_0x007f
        L_0x007e:
            r4 = 0
        L_0x007f:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
        L_0x0084:
            boolean r12 = r16.o0()
            if (r12 != 0) goto L_0x00e8
            okio.ByteString r12 = f31457c
            long r12 = r0.z0(r12)
            int r14 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r14 != 0) goto L_0x0099
            okio.ByteString r12 = r16.A1()
            goto L_0x00a0
        L_0x0099:
            okio.ByteString r12 = r0.K(r12)
            r16.readByte()
        L_0x00a0:
            okio.ByteString r13 = f31459e
            boolean r14 = kotlin.jvm.internal.Intrinsics.g(r12, r13)
            if (r14 == 0) goto L_0x00d7
            if (r4 == 0) goto L_0x00b1
            boolean r14 = r8.isEmpty()
            if (r14 == 0) goto L_0x00b1
            goto L_0x0084
        L_0x00b1:
            if (r17 == 0) goto L_0x00d3
            if (r4 != 0) goto L_0x00c6
            boolean r14 = r8.isEmpty()
            if (r14 != 0) goto L_0x00d3
            java.lang.Object r14 = kotlin.collections.CollectionsKt.m3(r8)
            boolean r13 = kotlin.jvm.internal.Intrinsics.g(r14, r13)
            if (r13 == 0) goto L_0x00c6
            goto L_0x00d3
        L_0x00c6:
            if (r5 == 0) goto L_0x00cf
            int r12 = r8.size()
            if (r12 != r9) goto L_0x00cf
            goto L_0x0084
        L_0x00cf:
            kotlin.collections.CollectionsKt.M0(r8)
            goto L_0x0084
        L_0x00d3:
            r8.add(r12)
            goto L_0x0084
        L_0x00d7:
            okio.ByteString r13 = f31458d
            boolean r13 = kotlin.jvm.internal.Intrinsics.g(r12, r13)
            if (r13 != 0) goto L_0x0084
            okio.ByteString r13 = okio.ByteString.Y2
            boolean r13 = kotlin.jvm.internal.Intrinsics.g(r12, r13)
            if (r13 != 0) goto L_0x0084
            goto L_0x00d3
        L_0x00e8:
            int r0 = r8.size()
            if (r0 <= 0) goto L_0x0103
        L_0x00ee:
            int r4 = r3 + 1
            if (r3 <= 0) goto L_0x00f5
            r1.g2(r2)
        L_0x00f5:
            java.lang.Object r3 = r8.get(r3)
            okio.ByteString r3 = (okio.ByteString) r3
            r1.g2(r3)
            if (r4 < r0) goto L_0x0101
            goto L_0x0103
        L_0x0101:
            r3 = r4
            goto L_0x00ee
        L_0x0103:
            long r2 = r1.L0()
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0110
            okio.ByteString r0 = f31458d
            r1.g2(r0)
        L_0x0110:
            okio.Path r0 = new okio.Path
            okio.ByteString r1 = r1.A1()
            r0.<init>(r1)
            return r0
        L_0x011a:
            byte r5 = r16.readByte()
            if (r2 != 0) goto L_0x0124
            okio.ByteString r2 = P(r5)
        L_0x0124:
            int r4 = r4 + 1
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.O(okio.Buffer, boolean):okio.Path");
    }

    private static final ByteString P(byte b2) {
        if (b2 == 47) {
            return f31455a;
        }
        if (b2 == 92) {
            return f31456b;
        }
        throw new IllegalArgumentException(Intrinsics.C("not a directory separator: ", Byte.valueOf(b2)));
    }

    /* access modifiers changed from: private */
    public static final ByteString Q(String str) {
        if (Intrinsics.g(str, "/")) {
            return f31455a;
        }
        if (Intrinsics.g(str, "\\")) {
            return f31456b;
        }
        throw new IllegalArgumentException(Intrinsics.C("not a directory separator: ", str));
    }

    public static final int j(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, "other");
        return path.i().compareTo(path2.i());
    }

    public static final boolean k(@NotNull Path path, @Nullable Object obj) {
        Intrinsics.p(path, "<this>");
        return (obj instanceof Path) && Intrinsics.g(((Path) obj).i(), path.i());
    }

    public static final int l(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        return path.i().hashCode();
    }

    public static final boolean m(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        return M(path) != -1;
    }

    public static final boolean n(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        return M(path) == -1;
    }

    public static final boolean o(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        return M(path) == path.i().m0();
    }

    @NotNull
    public static final String p(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        return path.q().I0();
    }

    @NotNull
    public static final ByteString q(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        int d2 = I(path);
        if (d2 != -1) {
            return ByteString.B0(path.i(), d2 + 1, 0, 2, (Object) null);
        }
        return (path.H() == null || path.i().m0() != 2) ? path.i() : ByteString.Y2;
    }

    @NotNull
    public static final Path r(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        return Path.X.d(path.toString(), true);
    }

    @Nullable
    public static final Path s(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        if (Intrinsics.g(path.i(), f31458d) || Intrinsics.g(path.i(), f31455a) || Intrinsics.g(path.i(), f31456b) || L(path)) {
            return null;
        }
        int d2 = I(path);
        if (d2 != 2 || path.H() == null) {
            if (d2 == 1 && path.i().p0(f31456b)) {
                return null;
            }
            if (d2 != -1 || path.H() == null) {
                if (d2 == -1) {
                    return new Path(f31458d);
                }
                return d2 == 0 ? new Path(ByteString.B0(path.i(), 0, 1, 1, (Object) null)) : new Path(ByteString.B0(path.i(), 0, d2, 1, (Object) null));
            } else if (path.i().m0() == 2) {
                return null;
            } else {
                return new Path(ByteString.B0(path.i(), 0, 2, 1, (Object) null));
            }
        } else if (path.i().m0() == 3) {
            return null;
        } else {
            return new Path(ByteString.B0(path.i(), 0, 3, 1, (Object) null));
        }
    }

    @NotNull
    public static final Path t(@NotNull Path path, @NotNull Path path2) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, "other");
        if (Intrinsics.g(path.j(), path2.j())) {
            List<ByteString> l2 = path.l();
            List<ByteString> l3 = path2.l();
            int min = Math.min(l2.size(), l3.size());
            int i2 = 0;
            while (i2 < min && Intrinsics.g(l2.get(i2), l3.get(i2))) {
                i2++;
            }
            if (i2 == min && path.i().m0() == path2.i().m0()) {
                return Path.Companion.h(Path.X, ".", false, 1, (Object) null);
            }
            if (l3.subList(i2, l3.size()).indexOf(f31459e) == -1) {
                Buffer buffer = new Buffer();
                ByteString f2 = K(path2);
                if (f2 == null && (f2 = K(path)) == null) {
                    f2 = Q(Path.Y);
                }
                int size = l3.size();
                if (i2 < size) {
                    int i3 = i2;
                    do {
                        i3++;
                        buffer.g2(f31459e);
                        buffer.g2(f2);
                    } while (i3 < size);
                }
                int size2 = l2.size();
                if (i2 < size2) {
                    while (true) {
                        int i4 = i2 + 1;
                        buffer.g2(l2.get(i2));
                        buffer.g2(f2);
                        if (i4 >= size2) {
                            break;
                        }
                        i2 = i4;
                    }
                }
                return O(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + path + " and " + path2).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + path + " and " + path2).toString());
    }

    @NotNull
    public static final Path u(@NotNull Path path, @NotNull String str, boolean z) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(str, "child");
        return x(path, O(new Buffer().W0(str), false), z);
    }

    @NotNull
    public static final Path v(@NotNull Path path, @NotNull Buffer buffer, boolean z) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(buffer, "child");
        return x(path, O(buffer, false), z);
    }

    @NotNull
    public static final Path w(@NotNull Path path, @NotNull ByteString byteString, boolean z) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(byteString, "child");
        return x(path, O(new Buffer().g2(byteString), false), z);
    }

    @NotNull
    public static final Path x(@NotNull Path path, @NotNull Path path2, boolean z) {
        Intrinsics.p(path, "<this>");
        Intrinsics.p(path2, "child");
        if (path2.m() || path2.H() != null) {
            return path2;
        }
        ByteString K = K(path);
        if (K == null && (K = K(path2)) == null) {
            K = Q(Path.Y);
        }
        Buffer buffer = new Buffer();
        buffer.g2(path.i());
        if (buffer.L0() > 0) {
            buffer.g2(K);
        }
        buffer.g2(path2.i());
        return O(buffer, z);
    }

    @Nullable
    public static final Path y(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        int h2 = M(path);
        if (h2 == -1) {
            return null;
        }
        return new Path(path.i().A0(0, h2));
    }

    @NotNull
    public static final List<String> z(@NotNull Path path) {
        Intrinsics.p(path, "<this>");
        ArrayList<ByteString> arrayList = new ArrayList<>();
        int h2 = M(path);
        if (h2 == -1) {
            h2 = 0;
        } else if (h2 < path.i().m0() && path.i().q(h2) == ((byte) 92)) {
            h2++;
        }
        int m0 = path.i().m0();
        if (h2 < m0) {
            int i2 = h2;
            while (true) {
                int i3 = h2 + 1;
                if (path.i().q(h2) == ((byte) 47) || path.i().q(h2) == ((byte) 92)) {
                    arrayList.add(path.i().A0(i2, h2));
                    i2 = i3;
                }
                if (i3 >= m0) {
                    break;
                }
                h2 = i3;
            }
            h2 = i2;
        }
        if (h2 < path.i().m0()) {
            arrayList.add(path.i().A0(h2, path.i().m0()));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.Y(arrayList, 10));
        for (ByteString I0 : arrayList) {
            arrayList2.add(I0.I0());
        }
        return arrayList2;
    }
}
