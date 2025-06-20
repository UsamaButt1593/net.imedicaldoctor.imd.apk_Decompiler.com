package kotlin.io.path;

import java.nio.file.Path;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n45#2,15:193\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n67#1:178,15\n78#1:193,15\n*E\n"})
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Ljava/nio/file/Path;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, 190, 199, 205}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    Object X2;
    Object Y;
    Object Y2;
    Object Z;
    Object Z2;
    int a3;
    private /* synthetic */ Object b3;
    final /* synthetic */ PathTreeWalk c3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PathTreeWalk$dfsIterator$1(PathTreeWalk pathTreeWalk, Continuation<? super PathTreeWalk$dfsIterator$1> continuation) {
        super(2, continuation);
        this.c3 = pathTreeWalk;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: kotlin.sequences.SequenceScope} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d3  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x021d A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x0070
            if (r2 == r8) goto L_0x0051
            if (r2 == r6) goto L_0x0040
            if (r2 == r5) goto L_0x0021
            if (r2 != r4) goto L_0x0019
            goto L_0x0040
        L_0x0019:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0021:
            java.lang.Object r2 = r0.Z2
            java.nio.file.Path r2 = kotlin.io.path.C0507e.a(r2)
            java.lang.Object r6 = r0.Y2
            kotlin.io.path.PathTreeWalk r6 = (kotlin.io.path.PathTreeWalk) r6
            java.lang.Object r9 = r0.X2
            kotlin.io.path.PathNode r9 = (kotlin.io.path.PathNode) r9
            java.lang.Object r10 = r0.Z
            kotlin.io.path.DirectoryEntriesReader r10 = (kotlin.io.path.DirectoryEntriesReader) r10
            java.lang.Object r11 = r0.Y
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r0.b3
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.n(r19)
            goto L_0x01af
        L_0x0040:
            java.lang.Object r2 = r0.Z
            kotlin.io.path.DirectoryEntriesReader r2 = (kotlin.io.path.DirectoryEntriesReader) r2
            java.lang.Object r6 = r0.Y
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r9 = r0.b3
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.ResultKt.n(r19)
            goto L_0x0144
        L_0x0051:
            java.lang.Object r2 = r0.Z2
            java.nio.file.Path r2 = kotlin.io.path.C0507e.a(r2)
            java.lang.Object r6 = r0.Y2
            kotlin.io.path.PathTreeWalk r6 = (kotlin.io.path.PathTreeWalk) r6
            java.lang.Object r9 = r0.X2
            kotlin.io.path.PathNode r9 = (kotlin.io.path.PathNode) r9
            java.lang.Object r10 = r0.Z
            kotlin.io.path.DirectoryEntriesReader r10 = (kotlin.io.path.DirectoryEntriesReader) r10
            java.lang.Object r11 = r0.Y
            kotlin.collections.ArrayDeque r11 = (kotlin.collections.ArrayDeque) r11
            java.lang.Object r12 = r0.b3
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            kotlin.ResultKt.n(r19)
            goto L_0x00e7
        L_0x0070:
            kotlin.ResultKt.n(r19)
            java.lang.Object r2 = r0.b3
            r9 = r2
            kotlin.sequences.SequenceScope r9 = (kotlin.sequences.SequenceScope) r9
            kotlin.collections.ArrayDeque r2 = new kotlin.collections.ArrayDeque
            r2.<init>()
            kotlin.io.path.DirectoryEntriesReader r10 = new kotlin.io.path.DirectoryEntriesReader
            kotlin.io.path.PathTreeWalk r11 = r0.c3
            boolean r11 = r11.i()
            r10.<init>(r11)
            kotlin.io.path.PathNode r11 = new kotlin.io.path.PathNode
            kotlin.io.path.PathTreeWalk r12 = r0.c3
            java.nio.file.Path r12 = r12.f28900a
            kotlin.io.path.PathTreeWalk r13 = r0.c3
            java.nio.file.Path r13 = r13.f28900a
            kotlin.io.path.PathTreeWalk r14 = r0.c3
            java.nio.file.LinkOption[] r14 = r14.k()
            java.lang.Object r13 = kotlin.io.path.PathTreeWalkKt.d(r13, r14)
            r11.<init>(r12, r13, r7)
            kotlin.io.path.PathTreeWalk r12 = r0.c3
            java.nio.file.Path r13 = r11.d()
            java.nio.file.LinkOption[] r14 = r12.k()
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            int r15 = r14.length
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r15)
            java.nio.file.LinkOption[] r14 = (java.nio.file.LinkOption[]) r14
            boolean r14 = java.nio.file.Files.isDirectory(r13, r14)
            if (r14 == 0) goto L_0x0121
            boolean r6 = kotlin.io.path.PathTreeWalkKt.c(r11)
            if (r6 != 0) goto L_0x0115
            boolean r6 = r12.j()
            if (r6 == 0) goto L_0x00ec
            r0.b3 = r9
            r0.Y = r2
            r0.Z = r10
            r0.X2 = r11
            r0.Y2 = r12
            r0.Z2 = r13
            r0.a3 = r8
            java.lang.Object r6 = r9.a(r13, r0)
            if (r6 != r1) goto L_0x00e2
            return r1
        L_0x00e2:
            r6 = r12
            r12 = r9
            r9 = r11
            r11 = r2
            r2 = r13
        L_0x00e7:
            r13 = r2
            r2 = r11
            r11 = r9
            r9 = r12
            r12 = r6
        L_0x00ec:
            java.nio.file.LinkOption[] r6 = r12.k()
            int r12 = r6.length
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r12)
            java.nio.file.LinkOption[] r6 = (java.nio.file.LinkOption[]) r6
            int r12 = r6.length
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r12)
            java.nio.file.LinkOption[] r6 = (java.nio.file.LinkOption[]) r6
            boolean r6 = java.nio.file.Files.isDirectory(r13, r6)
            if (r6 == 0) goto L_0x0112
            java.util.List r6 = r10.c(r11)
            java.util.Iterator r6 = r6.iterator()
            r11.e(r6)
            r2.addLast(r11)
        L_0x0112:
            r6 = r2
            r2 = r10
            goto L_0x0144
        L_0x0115:
            kotlin.io.path.C0543z.a()
            java.lang.String r1 = r13.toString()
            java.nio.file.FileSystemLoopException r1 = kotlin.io.path.C0542y.a(r1)
            throw r1
        L_0x0121:
            java.nio.file.LinkOption[] r11 = new java.nio.file.LinkOption[r8]
            java.nio.file.LinkOption r12 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r11[r3] = r12
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r8)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            boolean r11 = java.nio.file.Files.exists(r13, r11)
            if (r11 == 0) goto L_0x0112
            r0.b3 = r9
            r0.Y = r2
            r0.Z = r10
            r0.a3 = r6
            java.lang.Object r6 = r9.a(r13, r0)
            if (r6 != r1) goto L_0x0112
            return r1
        L_0x0144:
            boolean r10 = r6.isEmpty()
            r10 = r10 ^ r8
            if (r10 == 0) goto L_0x021d
            java.lang.Object r10 = r6.last()
            kotlin.io.path.PathNode r10 = (kotlin.io.path.PathNode) r10
            java.util.Iterator r10 = r10.a()
            kotlin.jvm.internal.Intrinsics.m(r10)
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0218
            java.lang.Object r10 = r10.next()
            kotlin.io.path.PathNode r10 = (kotlin.io.path.PathNode) r10
            kotlin.io.path.PathTreeWalk r11 = r0.c3
            java.nio.file.Path r12 = r10.d()
            java.nio.file.LinkOption[] r13 = r11.k()
            int r14 = r13.length
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r14)
            java.nio.file.LinkOption[] r13 = (java.nio.file.LinkOption[]) r13
            int r14 = r13.length
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r13, r14)
            java.nio.file.LinkOption[] r13 = (java.nio.file.LinkOption[]) r13
            boolean r13 = java.nio.file.Files.isDirectory(r12, r13)
            if (r13 == 0) goto L_0x01ef
            boolean r13 = kotlin.io.path.PathTreeWalkKt.c(r10)
            if (r13 != 0) goto L_0x01e3
            boolean r13 = r11.j()
            if (r13 == 0) goto L_0x01bb
            r0.b3 = r9
            r0.Y = r6
            r0.Z = r2
            r0.X2 = r10
            r0.Y2 = r11
            r0.Z2 = r12
            r0.a3 = r5
            java.lang.Object r13 = r9.a(r12, r0)
            if (r13 != r1) goto L_0x01a3
            return r1
        L_0x01a3:
            r16 = r10
            r10 = r2
            r2 = r12
            r12 = r9
            r9 = r16
            r17 = r11
            r11 = r6
            r6 = r17
        L_0x01af:
            r16 = r12
            r12 = r2
            r2 = r10
            r10 = r9
            r9 = r16
            r17 = r11
            r11 = r6
            r6 = r17
        L_0x01bb:
            java.nio.file.LinkOption[] r11 = r11.k()
            int r13 = r11.length
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r13)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            int r13 = r11.length
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r13)
            java.nio.file.LinkOption[] r11 = (java.nio.file.LinkOption[]) r11
            boolean r11 = java.nio.file.Files.isDirectory(r12, r11)
            if (r11 == 0) goto L_0x0144
            java.util.List r11 = r2.c(r10)
            java.util.Iterator r11 = r11.iterator()
            r10.e(r11)
            r6.addLast(r10)
            goto L_0x0144
        L_0x01e3:
            kotlin.io.path.C0543z.a()
            java.lang.String r1 = r12.toString()
            java.nio.file.FileSystemLoopException r1 = kotlin.io.path.C0542y.a(r1)
            throw r1
        L_0x01ef:
            java.nio.file.LinkOption[] r10 = new java.nio.file.LinkOption[r8]
            java.nio.file.LinkOption r11 = java.nio.file.LinkOption.NOFOLLOW_LINKS
            r10[r3] = r11
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r10, r8)
            java.nio.file.LinkOption[] r10 = (java.nio.file.LinkOption[]) r10
            boolean r10 = java.nio.file.Files.exists(r12, r10)
            if (r10 == 0) goto L_0x0144
            r0.b3 = r9
            r0.Y = r6
            r0.Z = r2
            r0.X2 = r7
            r0.Y2 = r7
            r0.Z2 = r7
            r0.a3 = r4
            java.lang.Object r10 = r9.a(r12, r0)
            if (r10 != r1) goto L_0x0144
            return r1
        L_0x0218:
            r6.removeLast()
            goto L_0x0144
        L_0x021d:
            kotlin.Unit r1 = kotlin.Unit.f28779a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.path.PathTreeWalk$dfsIterator$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super Path> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((PathTreeWalk$dfsIterator$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PathTreeWalk$dfsIterator$1 pathTreeWalk$dfsIterator$1 = new PathTreeWalk$dfsIterator$1(this.c3, continuation);
        pathTreeWalk$dfsIterator$1.b3 = obj;
        return pathTreeWalk$dfsIterator$1;
    }
}
