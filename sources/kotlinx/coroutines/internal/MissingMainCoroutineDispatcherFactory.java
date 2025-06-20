package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "<init>", "()V", "", "allFactories", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "b", "(Ljava/util/List;)Lkotlinx/coroutines/MainCoroutineDispatcher;", "", "c", "()I", "loadPriority", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public final class MissingMainCoroutineDispatcherFactory implements MainDispatcherFactory {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final MissingMainCoroutineDispatcherFactory f29388a = new MissingMainCoroutineDispatcherFactory();

    private MissingMainCoroutineDispatcherFactory() {
    }

    @Nullable
    public String a() {
        return MainDispatcherFactory.DefaultImpls.a(this);
    }

    @NotNull
    public MainCoroutineDispatcher b(@NotNull List<? extends MainDispatcherFactory> list) {
        return new MissingMainCoroutineDispatcher((Throwable) null, (String) null, 2, (DefaultConstructorMarker) null);
    }

    public int c() {
        return -1;
    }
}
