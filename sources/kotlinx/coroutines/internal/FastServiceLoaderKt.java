package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0000X\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003¨\u0006\u0005"}, d2 = {"", "a", "Z", "()Z", "ANDROID_DETECTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class FastServiceLoaderKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f29347a = false;

    static {
        Object obj;
        try {
            Result.Companion companion = Result.X;
            obj = Result.b(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th));
        }
        Result.j(obj);
    }

    public static final boolean a() {
        return true;
    }
}
