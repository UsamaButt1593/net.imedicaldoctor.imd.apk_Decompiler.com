package androidx.datastore.core;

import androidx.core.app.NotificationCompat;
import androidx.datastore.core.SingleProcessDataStore;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableDeferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n"}, d2 = {"<anonymous>", "", "T", "msg", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "ex", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
final class SingleProcessDataStore$actor$2 extends Lambda implements Function2<SingleProcessDataStore.Message<T>, Throwable, Unit> {
    public static final SingleProcessDataStore$actor$2 X = new SingleProcessDataStore$actor$2();

    SingleProcessDataStore$actor$2() {
        super(2);
    }

    public final void b(@NotNull SingleProcessDataStore.Message<T> message, @Nullable Throwable th) {
        Intrinsics.p(message, NotificationCompat.G0);
        if (message instanceof SingleProcessDataStore.Message.Update) {
            CompletableDeferred b2 = ((SingleProcessDataStore.Message.Update) message).b();
            if (th == null) {
                th = new CancellationException("DataStore scope was cancelled before updateData could complete");
            }
            b2.k(th);
        }
    }

    public /* bridge */ /* synthetic */ Object d0(Object obj, Object obj2) {
        b((SingleProcessDataStore.Message) obj, (Throwable) obj2);
        return Unit.f28779a;
    }
}
