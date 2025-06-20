package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"E", "", "capacity", "Lkotlinx/coroutines/channels/BroadcastChannel;", "a", "(I)Lkotlinx/coroutines/channels/BroadcastChannel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class BroadcastChannelKt {
    @NotNull
    @ObsoleteCoroutinesApi
    public static final <E> BroadcastChannel<E> a(int i2) {
        if (i2 == -2) {
            return new ArrayBroadcastChannel(Channel.Q2.a());
        }
        if (i2 == -1) {
            return new ConflatedBroadcastChannel();
        }
        if (i2 == 0) {
            throw new IllegalArgumentException("Unsupported 0 capacity for BroadcastChannel");
        } else if (i2 != Integer.MAX_VALUE) {
            return new ArrayBroadcastChannel(i2);
        } else {
            throw new IllegalArgumentException("Unsupported UNLIMITED capacity for BroadcastChannel");
        }
    }
}
