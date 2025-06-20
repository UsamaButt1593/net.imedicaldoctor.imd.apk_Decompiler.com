package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.itextpdf.tool.xml.html.HTML;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0010\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0014\u0010\r\u001a)\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001aK\u0010\u001e\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001b2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001d\u0010 \u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b \u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lokio/FileSystem;", "Lokio/Path;", "path", "Lokio/FileMetadata;", "g", "(Lokio/FileSystem;Lokio/Path;)Lokio/FileMetadata;", "", "e", "(Lokio/FileSystem;Lokio/Path;)Z", "dir", "mustCreate", "", "c", "(Lokio/FileSystem;Lokio/Path;Z)V", "source", "target", "b", "(Lokio/FileSystem;Lokio/Path;Lokio/Path;)V", "fileOrDirectory", "mustExist", "d", "followSymlinks", "Lkotlin/sequences/Sequence;", "f", "(Lokio/FileSystem;Lokio/Path;Z)Lkotlin/sequences/Sequence;", "Lkotlin/sequences/SequenceScope;", "fileSystem", "Lkotlin/collections/ArrayDeque;", "stack", "postorder", "a", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "(Lokio/FileSystem;Lokio/Path;)Lokio/Path;", "okio"}, k = 2, mv = {1, 5, 1})
public final class _FileSystemKt {
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d2, code lost:
        if (r0 != false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d4, code lost:
        if (r7 != 0) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d6, code lost:
        r6.addLast(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00dd, code lost:
        r7 = r6;
        r10 = r11;
        r11 = r12;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011c, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x011d, code lost:
        r7.removeLast();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0120, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ea A[Catch:{ all -> 0x005d }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0114 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super okio.Path> r15, @org.jetbrains.annotations.NotNull okio.FileSystem r16, @org.jetbrains.annotations.NotNull kotlin.collections.ArrayDeque<okio.Path> r17, @org.jetbrains.annotations.NotNull okio.Path r18, boolean r19, boolean r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r0 = r15
            r1 = r18
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof okio.internal._FileSystemKt$collectRecursively$1
            if (r4 == 0) goto L_0x001a
            r4 = r3
            okio.internal._FileSystemKt$collectRecursively$1 r4 = (okio.internal._FileSystemKt$collectRecursively$1) r4
            int r5 = r4.e3
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001a
            int r5 = r5 - r6
            r4.e3 = r5
            goto L_0x001f
        L_0x001a:
            okio.internal._FileSystemKt$collectRecursively$1 r4 = new okio.internal._FileSystemKt$collectRecursively$1
            r4.<init>(r3)
        L_0x001f:
            java.lang.Object r3 = r4.d3
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r6 = r4.e3
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            if (r6 == 0) goto L_0x007c
            if (r6 == r10) goto L_0x0060
            if (r6 == r9) goto L_0x0040
            if (r6 != r8) goto L_0x0038
            kotlin.ResultKt.n(r3)
            goto L_0x013b
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            boolean r0 = r4.c3
            boolean r1 = r4.b3
            java.lang.Object r2 = r4.a3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r4.Z2
            okio.Path r6 = (okio.Path) r6
            java.lang.Object r7 = r4.Y2
            kotlin.collections.ArrayDeque r7 = (kotlin.collections.ArrayDeque) r7
            java.lang.Object r10 = r4.X2
            okio.FileSystem r10 = (okio.FileSystem) r10
            java.lang.Object r11 = r4.Z
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.n(r3)     // Catch:{ all -> 0x005d }
            goto L_0x00e4
        L_0x005d:
            r0 = move-exception
            goto L_0x011d
        L_0x0060:
            boolean r0 = r4.c3
            boolean r1 = r4.b3
            java.lang.Object r2 = r4.Z2
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r6 = r4.Y2
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r11 = r4.X2
            okio.FileSystem r11 = (okio.FileSystem) r11
            java.lang.Object r12 = r4.Z
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.n(r3)
            r14 = r2
            r2 = r0
            r0 = r1
            r1 = r14
            goto L_0x00a5
        L_0x007c:
            kotlin.ResultKt.n(r3)
            if (r2 != 0) goto L_0x009c
            r4.Z = r0
            r3 = r16
            r4.X2 = r3
            r6 = r17
            r4.Y2 = r6
            r4.Z2 = r1
            r11 = r19
            r4.b3 = r11
            r4.c3 = r2
            r4.e3 = r10
            java.lang.Object r12 = r15.a(r1, r4)
            if (r12 != r5) goto L_0x00a2
            return r5
        L_0x009c:
            r3 = r16
            r6 = r17
            r11 = r19
        L_0x00a2:
            r12 = r0
            r0 = r11
            r11 = r3
        L_0x00a5:
            java.util.List r3 = r11.y(r1)
            if (r3 != 0) goto L_0x00af
            java.util.List r3 = kotlin.collections.CollectionsKt.E()
        L_0x00af:
            boolean r13 = r3.isEmpty()
            r10 = r10 ^ r13
            if (r10 == 0) goto L_0x0125
            r10 = r1
        L_0x00b7:
            if (r0 == 0) goto L_0x00cc
            boolean r13 = r6.contains(r10)
            if (r13 != 0) goto L_0x00c0
            goto L_0x00cc
        L_0x00c0:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r2 = "symlink cycle at "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.C(r2, r1)
            r0.<init>(r1)
            throw r0
        L_0x00cc:
            okio.Path r13 = h(r11, r10)
            if (r13 != 0) goto L_0x0121
            if (r0 != 0) goto L_0x00d6
            if (r7 != 0) goto L_0x0125
        L_0x00d6:
            r6.addLast(r10)
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x011b }
            r7 = r6
            r10 = r11
            r11 = r12
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r3
        L_0x00e4:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005d }
            if (r3 == 0) goto L_0x0114
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005d }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x005d }
            r4.Z = r11     // Catch:{ all -> 0x005d }
            r4.X2 = r10     // Catch:{ all -> 0x005d }
            r4.Y2 = r7     // Catch:{ all -> 0x005d }
            r4.Z2 = r6     // Catch:{ all -> 0x005d }
            r4.a3 = r2     // Catch:{ all -> 0x005d }
            r4.b3 = r1     // Catch:{ all -> 0x005d }
            r4.c3 = r0     // Catch:{ all -> 0x005d }
            r4.e3 = r9     // Catch:{ all -> 0x005d }
            r15 = r11
            r16 = r10
            r17 = r7
            r18 = r3
            r19 = r1
            r20 = r0
            r21 = r4
            java.lang.Object r3 = a(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x005d }
            if (r3 != r5) goto L_0x00e4
            return r5
        L_0x0114:
            r7.removeLast()
            r2 = r0
            r1 = r6
            r12 = r11
            goto L_0x0125
        L_0x011b:
            r0 = move-exception
            r7 = r6
        L_0x011d:
            r7.removeLast()
            throw r0
        L_0x0121:
            int r7 = r7 + 1
            r10 = r13
            goto L_0x00b7
        L_0x0125:
            if (r2 == 0) goto L_0x013e
            r0 = 0
            r4.Z = r0
            r4.X2 = r0
            r4.Y2 = r0
            r4.Z2 = r0
            r4.a3 = r0
            r4.e3 = r8
            java.lang.Object r0 = r12.a(r1, r4)
            if (r0 != r5) goto L_0x013b
            return r5
        L_0x013b:
            kotlin.Unit r0 = kotlin.Unit.f28779a
            return r0
        L_0x013e:
            kotlin.Unit r0 = kotlin.Unit.f28779a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._FileSystemKt.a(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void b(@NotNull FileSystem fileSystem, @NotNull Path path, @NotNull Path path2) throws IOException {
        Long l2;
        Long l3;
        Intrinsics.p(fileSystem, "<this>");
        Intrinsics.p(path, "source");
        Intrinsics.p(path2, TypedValues.AttributesType.M);
        Source L = fileSystem.L(path);
        Throwable th = null;
        try {
            BufferedSink d2 = Okio.d(fileSystem.I(path2));
            try {
                l3 = Long.valueOf(d2.y1(L));
                th = null;
            } catch (Throwable th2) {
                th = th2;
                l3 = null;
            }
            if (d2 != null) {
                d2.close();
            }
        } catch (Throwable th3) {
            th = th3;
            l2 = null;
        }
        if (th == null) {
            Intrinsics.m(l3);
            l2 = Long.valueOf(l3.longValue());
            if (L != null) {
                try {
                    L.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        ExceptionsKt.a(th, th4);
                    }
                }
            }
            if (th == null) {
                Intrinsics.m(l2);
                return;
            }
            throw th;
        }
        throw th;
    }

    public static final void c(@NotNull FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(fileSystem, "<this>");
        Intrinsics.p(path, HTML.Attribute.u);
        ArrayDeque arrayDeque = new ArrayDeque();
        Path path2 = path;
        while (path2 != null && !fileSystem.w(path2)) {
            arrayDeque.addFirst(path2);
            path2 = path2.s();
        }
        if (!z || !arrayDeque.isEmpty()) {
            Iterator it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                fileSystem.m((Path) it2.next());
            }
            return;
        }
        throw new IOException(path + " already exist.");
    }

    public static final void d(@NotNull FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(fileSystem, "<this>");
        Intrinsics.p(path, "fileOrDirectory");
        Iterator it2 = SequencesKt.b(new _FileSystemKt$commonDeleteRecursively$sequence$1(fileSystem, path, (Continuation<? super _FileSystemKt$commonDeleteRecursively$sequence$1>) null)).iterator();
        while (it2.hasNext()) {
            fileSystem.r((Path) it2.next(), z && !it2.hasNext());
        }
    }

    public static final boolean e(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.p(fileSystem, "<this>");
        Intrinsics.p(path, Cookie2.PATH);
        return fileSystem.D(path) != null;
    }

    @NotNull
    public static final Sequence<Path> f(@NotNull FileSystem fileSystem, @NotNull Path path, boolean z) throws IOException {
        Intrinsics.p(fileSystem, "<this>");
        Intrinsics.p(path, HTML.Attribute.u);
        return SequencesKt.b(new _FileSystemKt$commonListRecursively$1(path, fileSystem, z, (Continuation<? super _FileSystemKt$commonListRecursively$1>) null));
    }

    @NotNull
    public static final FileMetadata g(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.p(fileSystem, "<this>");
        Intrinsics.p(path, Cookie2.PATH);
        FileMetadata D = fileSystem.D(path);
        if (D != null) {
            return D;
        }
        throw new FileNotFoundException(Intrinsics.C("no such file: ", path));
    }

    @Nullable
    public static final Path h(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.p(fileSystem, "<this>");
        Intrinsics.p(path, Cookie2.PATH);
        Path i2 = fileSystem.C(path).i();
        if (i2 == null) {
            return null;
        }
        Path s = path.s();
        Intrinsics.m(s);
        return s.z(i2);
    }
}
