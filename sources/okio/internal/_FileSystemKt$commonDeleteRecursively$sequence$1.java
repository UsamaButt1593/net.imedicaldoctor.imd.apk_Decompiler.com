package okio.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "okio.internal._FileSystemKt$commonDeleteRecursively$sequence$1", f = "-FileSystem.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
final class _FileSystemKt$commonDeleteRecursively$sequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    final /* synthetic */ FileSystem X2;
    int Y;
    final /* synthetic */ Path Y2;
    private /* synthetic */ Object Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    _FileSystemKt$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, Continuation<? super _FileSystemKt$commonDeleteRecursively$sequence$1> continuation) {
        super(2, continuation);
        this.X2 = fileSystem;
        this.Y2 = path;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.Y;
        if (i2 == 0) {
            ResultKt.n(obj);
            FileSystem fileSystem = this.X2;
            ArrayDeque arrayDeque = new ArrayDeque();
            Path path = this.Y2;
            this.Y = 1;
            if (_FileSystemKt.a((SequenceScope) this.Z, fileSystem, arrayDeque, path, false, true, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super Path> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((_FileSystemKt$commonDeleteRecursively$sequence$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        _FileSystemKt$commonDeleteRecursively$sequence$1 _filesystemkt_commondeleterecursively_sequence_1 = new _FileSystemKt$commonDeleteRecursively$sequence$1(this.X2, this.Y2, continuation);
        _filesystemkt_commondeleterecursively_sequence_1.Z = obj;
        return _filesystemkt_commondeleterecursively_sequence_1;
    }
}
