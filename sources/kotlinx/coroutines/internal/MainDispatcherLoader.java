package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", "", "<init>", "()V", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "a", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "", "b", "Z", "FAST_SERVICE_LOADER_ENABLED", "c", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "dispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class MainDispatcherLoader {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final MainDispatcherLoader f29383a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f29384b = false;
    @NotNull
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final MainCoroutineDispatcher f29385c;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        f29383a = mainDispatcherLoader;
        SystemPropsKt.e("kotlinx.coroutines.fast.service.loader", true);
        f29385c = mainDispatcherLoader.a();
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher a() {
        T t;
        Class<MainDispatcherFactory> cls = MainDispatcherFactory.class;
        try {
            List<T> c3 = SequencesKt.c3(SequencesKt.e(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            Iterator<T> it2 = c3.iterator();
            if (!it2.hasNext()) {
                t = null;
            } else {
                t = it2.next();
                if (it2.hasNext()) {
                    int c2 = ((MainDispatcherFactory) t).c();
                    do {
                        T next = it2.next();
                        int c4 = ((MainDispatcherFactory) next).c();
                        if (c2 < c4) {
                            t = next;
                            c2 = c4;
                        }
                    } while (it2.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) t;
            if (mainDispatcherFactory != null) {
                MainCoroutineDispatcher f2 = MainDispatchersKt.f(mainDispatcherFactory, c3);
                if (f2 != null) {
                    return f2;
                }
            }
            return MainDispatchersKt.b((Throwable) null, (String) null, 3, (Object) null);
        } catch (Throwable th) {
            return MainDispatchersKt.b(th, (String) null, 2, (Object) null);
        }
    }
}
