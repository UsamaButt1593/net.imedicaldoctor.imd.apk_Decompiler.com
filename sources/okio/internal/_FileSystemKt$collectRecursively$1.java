package okio.internal;

import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "okio.internal._FileSystemKt", f = "-FileSystem.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {113, 132, 142}, m = "collectRecursively", n = {"$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"})
final class _FileSystemKt$collectRecursively$1 extends ContinuationImpl {
    Object X2;
    Object Y2;
    Object Z;
    Object Z2;
    Object a3;
    boolean b3;
    boolean c3;
    /* synthetic */ Object d3;
    int e3;

    _FileSystemKt$collectRecursively$1(Continuation<? super _FileSystemKt$collectRecursively$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        this.d3 = obj;
        this.e3 |= Integer.MIN_VALUE;
        return _FileSystemKt.a((SequenceScope<? super Path>) null, (FileSystem) null, (ArrayDeque<Path>) null, (Path) null, false, false, this);
    }
}
