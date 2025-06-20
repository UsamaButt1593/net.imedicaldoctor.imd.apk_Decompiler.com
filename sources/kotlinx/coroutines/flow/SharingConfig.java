package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/flow/SharingConfig;", "T", "", "Lkotlinx/coroutines/flow/Flow;", "upstream", "", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/coroutines/CoroutineContext;)V", "a", "Lkotlinx/coroutines/flow/Flow;", "b", "I", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "d", "Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class SharingConfig<T> {
    @NotNull
    @JvmField

    /* renamed from: a  reason: collision with root package name */
    public final Flow<T> f29309a;
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public final int f29310b;
    @NotNull
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public final BufferOverflow f29311c;
    @NotNull
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public final CoroutineContext f29312d;

    public SharingConfig(@NotNull Flow<? extends T> flow, int i2, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineContext coroutineContext) {
        this.f29309a = flow;
        this.f29310b = i2;
        this.f29311c = bufferOverflow;
        this.f29312d = coroutineContext;
    }
}
