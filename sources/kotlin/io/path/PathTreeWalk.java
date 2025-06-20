package kotlin.io.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJG\u0010\u0012\u001a\u00020\u0010*\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0018\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000f\u0012\u0004\u0012\u00020\u00100\u000eHHø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0014\u0010(\u001a\u00020\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u001f\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlin/io/path/PathTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/nio/file/Path;", "start", "", "Lkotlin/io/path/PathWalkOption;", "options", "<init>", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)V", "Lkotlin/sequences/SequenceScope;", "Lkotlin/io/path/PathNode;", "node", "Lkotlin/io/path/DirectoryEntriesReader;", "entriesReader", "Lkotlin/Function1;", "", "", "entriesAction", "m", "(Lkotlin/sequences/SequenceScope;Lkotlin/io/path/PathNode;Lkotlin/io/path/DirectoryEntriesReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "h", "()Ljava/util/Iterator;", "g", "iterator", "a", "Ljava/nio/file/Path;", "b", "[Lkotlin/io/path/PathWalkOption;", "", "i", "()Z", "followLinks", "Ljava/nio/file/LinkOption;", "k", "()[Ljava/nio/file/LinkOption;", "linkOptions", "j", "includeDirectories", "l", "isBFS", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0})
@ExperimentalPathApi
public final class PathTreeWalk implements Sequence<Path> {
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Path f28900a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final PathWalkOption[] f28901b;

    public PathTreeWalk(@NotNull Path path, @NotNull PathWalkOption[] pathWalkOptionArr) {
        Intrinsics.p(path, "start");
        Intrinsics.p(pathWalkOptionArr, "options");
        this.f28900a = path;
        this.f28901b = pathWalkOptionArr;
    }

    private final Iterator<Path> g() {
        return SequencesKt.a(new PathTreeWalk$bfsIterator$1(this, (Continuation<? super PathTreeWalk$bfsIterator$1>) null));
    }

    private final Iterator<Path> h() {
        return SequencesKt.a(new PathTreeWalk$dfsIterator$1(this, (Continuation<? super PathTreeWalk$dfsIterator$1>) null));
    }

    /* access modifiers changed from: private */
    public final boolean i() {
        return ArraysKt.s8(this.f28901b, PathWalkOption.FOLLOW_LINKS);
    }

    /* access modifiers changed from: private */
    public final boolean j() {
        return ArraysKt.s8(this.f28901b, PathWalkOption.INCLUDE_DIRECTORIES);
    }

    /* access modifiers changed from: private */
    public final LinkOption[] k() {
        return LinkFollowing.f28888a.a(i());
    }

    private final boolean l() {
        return ArraysKt.s8(this.f28901b, PathWalkOption.BREADTH_FIRST);
    }

    private final Object m(SequenceScope<? super Path> sequenceScope, PathNode pathNode, DirectoryEntriesReader directoryEntriesReader, Function1<? super List<PathNode>, Unit> function1, Continuation<? super Unit> continuation) {
        Path d2 = pathNode.d();
        LinkOption[] e2 = k();
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(e2, e2.length);
        if (!Files.isDirectory(d2, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            if (Files.exists(d2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
                InlineMarker.e(0);
                sequenceScope.a(d2, continuation);
                InlineMarker.e(1);
                return Unit.f28779a;
            }
        } else if (!PathTreeWalkKt.c(pathNode)) {
            if (j()) {
                InlineMarker.e(0);
                sequenceScope.a(d2, continuation);
                InlineMarker.e(1);
            }
            LinkOption[] e3 = k();
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(e3, e3.length);
            if (Files.isDirectory(d2, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length))) {
                function1.f(directoryEntriesReader.c(pathNode));
            }
        } else {
            C0543z.a();
            throw C0542y.a(d2.toString());
        }
        return Unit.f28779a;
    }

    @NotNull
    public Iterator<Path> iterator() {
        return l() ? g() : h();
    }
}
