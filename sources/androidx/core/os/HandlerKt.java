package androidx.core.os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a8\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b¢\u0006\u0004\b\t\u0010\n\u001a8\u0010\f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b¢\u0006\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Landroid/os/Handler;", "", "delayInMillis", "", "token", "Lkotlin/Function0;", "", "action", "Ljava/lang/Runnable;", "c", "(Landroid/os/Handler;JLjava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Runnable;", "uptimeMillis", "a", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class HandlerKt {
    @NotNull
    public static final Runnable a(@NotNull Handler handler, long j2, @Nullable Object obj, @NotNull Function0<Unit> function0) {
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(function0);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j2);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ Runnable b(Handler handler, long j2, Object obj, Function0 function0, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(function0);
        handler.postAtTime(handlerKt$postAtTime$runnable$1, obj, j2);
        return handlerKt$postAtTime$runnable$1;
    }

    @NotNull
    public static final Runnable c(@NotNull Handler handler, long j2, @Nullable Object obj, @NotNull Function0<Unit> function0) {
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(function0);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j2);
        } else {
            HandlerCompat.d(handler, handlerKt$postDelayed$runnable$1, obj, j2);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable d(Handler handler, long j2, Object obj, Function0 function0, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            obj = null;
        }
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(function0);
        if (obj == null) {
            handler.postDelayed(handlerKt$postDelayed$runnable$1, j2);
        } else {
            HandlerCompat.d(handler, handlerKt$postDelayed$runnable$1, obj, j2);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
