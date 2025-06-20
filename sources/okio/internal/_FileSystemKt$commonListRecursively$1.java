package okio.internal;

import java.util.Iterator;
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
@DebugMetadata(c = "okio.internal._FileSystemKt$commonListRecursively$1", f = "-FileSystem.kt", i = {0, 0}, l = {93}, m = "invokeSuspend", n = {"$this$sequence", "stack"}, s = {"L$0", "L$1"})
final class _FileSystemKt$commonListRecursively$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    int X2;
    Object Y;
    private /* synthetic */ Object Y2;
    Object Z;
    final /* synthetic */ Path Z2;
    final /* synthetic */ FileSystem a3;
    final /* synthetic */ boolean b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    _FileSystemKt$commonListRecursively$1(Path path, FileSystem fileSystem, boolean z, Continuation<? super _FileSystemKt$commonListRecursively$1> continuation) {
        super(2, continuation);
        this.Z2 = path;
        this.a3 = fileSystem;
        this.b3 = z;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        ArrayDeque arrayDeque;
        SequenceScope sequenceScope;
        Iterator<Path> it2;
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.addLast(this.Z2);
            sequenceScope = (SequenceScope) this.Y2;
            arrayDeque = arrayDeque2;
            it2 = this.a3.x(this.Z2).iterator();
        } else if (i2 == 1) {
            it2 = (Iterator) this.Z;
            ResultKt.n(obj);
            arrayDeque = (ArrayDeque) this.Y;
            sequenceScope = (SequenceScope) this.Y2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it2.hasNext()) {
            FileSystem fileSystem = this.a3;
            boolean z = this.b3;
            this.Y2 = sequenceScope;
            this.Y = arrayDeque;
            this.Z = it2;
            this.X2 = 1;
            if (_FileSystemKt.a(sequenceScope, fileSystem, arrayDeque, it2.next(), z, false, this) == l2) {
                return l2;
            }
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super Path> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((_FileSystemKt$commonListRecursively$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        _FileSystemKt$commonListRecursively$1 _filesystemkt_commonlistrecursively_1 = new _FileSystemKt$commonListRecursively$1(this.Z2, this.a3, this.b3, continuation);
        _filesystemkt_commonlistrecursively_1.Y2 = obj;
        return _filesystemkt_commonlistrecursively_1;
    }
}
