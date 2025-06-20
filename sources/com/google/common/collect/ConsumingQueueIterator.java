package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class ConsumingQueueIterator<T> extends AbstractIterator<T> {
    private final Queue<T> Y;

    ConsumingQueueIterator(Queue<T> queue) {
        this.Y = (Queue) Preconditions.E(queue);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public T a() {
        return this.Y.isEmpty() ? b() : this.Y.remove();
    }
}
