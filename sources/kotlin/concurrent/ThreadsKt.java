package kotlin.concurrent;

import com.itextpdf.tool.xml.css.CSS;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Thread.kt\nkotlin/concurrent/ThreadsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
@Metadata(d1 = {"\u0000:\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aQ\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000e\u001a5\u0010\u0013\u001a\u00028\u0000\"\b\b\u0000\u0010\u0010*\u00020\u000f*\b\u0012\u0004\u0012\u00028\u00000\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0015"}, d2 = {"", "start", "isDaemon", "Ljava/lang/ClassLoader;", "contextClassLoader", "", "name", "", "priority", "Lkotlin/Function0;", "", "block", "Ljava/lang/Thread;", "b", "(ZZLjava/lang/ClassLoader;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)Ljava/lang/Thread;", "", "T", "Ljava/lang/ThreadLocal;", "default", "a", "(Ljava/lang/ThreadLocal;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "ThreadsKt")
public final class ThreadsKt {
    @InlineOnly
    private static final <T> T a(ThreadLocal<T> threadLocal, Function0<? extends T> function0) {
        Intrinsics.p(threadLocal, "<this>");
        Intrinsics.p(function0, CookiePolicy.DEFAULT);
        T t = threadLocal.get();
        if (t != null) {
            return t;
        }
        T o = function0.o();
        threadLocal.set(o);
        return o;
    }

    @NotNull
    public static final Thread b(boolean z, boolean z2, @Nullable ClassLoader classLoader, @Nullable String str, int i2, @NotNull Function0<Unit> function0) {
        Intrinsics.p(function0, CSS.Value.v0);
        ThreadsKt$thread$thread$1 threadsKt$thread$thread$1 = new ThreadsKt$thread$thread$1(function0);
        if (z2) {
            threadsKt$thread$thread$1.setDaemon(true);
        }
        if (i2 > 0) {
            threadsKt$thread$thread$1.setPriority(i2);
        }
        if (str != null) {
            threadsKt$thread$thread$1.setName(str);
        }
        if (classLoader != null) {
            threadsKt$thread$thread$1.setContextClassLoader(classLoader);
        }
        if (z) {
            threadsKt$thread$thread$1.start();
        }
        return threadsKt$thread$thread$1;
    }

    public static /* synthetic */ Thread c(boolean z, boolean z2, ClassLoader classLoader, String str, int i2, Function0 function0, int i3, Object obj) {
        return b((i3 & 1) != 0 ? true : z, (i3 & 2) != 0 ? false : z2, (i3 & 4) != 0 ? null : classLoader, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? -1 : i2, function0);
    }
}
