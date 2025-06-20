package kotlin.concurrent;

import com.itextpdf.tool.xml.html.HTML;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u001a:\u0010\b\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a:\u0010\f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aB\u0010\u000f\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aB\u0010\u0011\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aB\u0010\u0013\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0010\u001aB\u0010\u0014\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0012\u001a!\u0010\u0019\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001aT\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aV\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b!\u0010\u001d\u001aT\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b\"\u0010 \u001a.\u0010#\u001a\u00020\u00042\u0019\b\u0004\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u0002\u0007\n\u0005\b20\u0001¨\u0006%"}, d2 = {"Ljava/util/Timer;", "", "delay", "Lkotlin/Function1;", "Ljava/util/TimerTask;", "", "Lkotlin/ExtensionFunctionType;", "action", "f", "(Ljava/util/Timer;JLkotlin/jvm/functions/Function1;)Ljava/util/TimerTask;", "Ljava/util/Date;", "time", "h", "(Ljava/util/Timer;Ljava/util/Date;Lkotlin/jvm/functions/Function1;)Ljava/util/TimerTask;", "period", "e", "(Ljava/util/Timer;JJLkotlin/jvm/functions/Function1;)Ljava/util/TimerTask;", "g", "(Ljava/util/Timer;Ljava/util/Date;JLkotlin/jvm/functions/Function1;)Ljava/util/TimerTask;", "i", "j", "", "name", "", "daemon", "k", "(Ljava/lang/String;Z)Ljava/util/Timer;", "initialDelay", "l", "(Ljava/lang/String;ZJJLkotlin/jvm/functions/Function1;)Ljava/util/Timer;", "startAt", "m", "(Ljava/lang/String;ZLjava/util/Date;JLkotlin/jvm/functions/Function1;)Ljava/util/Timer;", "a", "b", "p", "(Lkotlin/jvm/functions/Function1;)Ljava/util/TimerTask;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "TimersKt")
public final class TimersKt {
    @InlineOnly
    private static final Timer a(String str, boolean z, long j2, long j3, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(function1, "action");
        Timer k2 = k(str, z);
        k2.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), j2, j3);
        return k2;
    }

    @InlineOnly
    private static final Timer b(String str, boolean z, Date date, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(date, "startAt");
        Intrinsics.p(function1, "action");
        Timer k2 = k(str, z);
        k2.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), date, j2);
        return k2;
    }

    static /* synthetic */ Timer c(String str, boolean z, long j2, long j3, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        Intrinsics.p(function1, "action");
        Timer k2 = k(str, z);
        Timer timer = k2;
        timer.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), j2, j3);
        return k2;
    }

    static /* synthetic */ Timer d(String str, boolean z, Date date, long j2, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.p(date, "startAt");
        Intrinsics.p(function1, "action");
        Timer k2 = k(str, z);
        k2.scheduleAtFixedRate(new TimersKt$timerTask$1(function1), date, j2);
        return k2;
    }

    @InlineOnly
    private static final TimerTask e(Timer timer, long j2, long j3, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(timer, "<this>");
        Intrinsics.p(function1, "action");
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.schedule(timersKt$timerTask$1, j2, j3);
        return timersKt$timerTask$1;
    }

    @InlineOnly
    private static final TimerTask f(Timer timer, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(timer, "<this>");
        Intrinsics.p(function1, "action");
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.schedule(timersKt$timerTask$1, j2);
        return timersKt$timerTask$1;
    }

    @InlineOnly
    private static final TimerTask g(Timer timer, Date date, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(timer, "<this>");
        Intrinsics.p(date, HTML.Tag.P0);
        Intrinsics.p(function1, "action");
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.schedule(timersKt$timerTask$1, date, j2);
        return timersKt$timerTask$1;
    }

    @InlineOnly
    private static final TimerTask h(Timer timer, Date date, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(timer, "<this>");
        Intrinsics.p(date, HTML.Tag.P0);
        Intrinsics.p(function1, "action");
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.schedule(timersKt$timerTask$1, date);
        return timersKt$timerTask$1;
    }

    @InlineOnly
    private static final TimerTask i(Timer timer, long j2, long j3, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(timer, "<this>");
        Intrinsics.p(function1, "action");
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.scheduleAtFixedRate(timersKt$timerTask$1, j2, j3);
        return timersKt$timerTask$1;
    }

    @InlineOnly
    private static final TimerTask j(Timer timer, Date date, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(timer, "<this>");
        Intrinsics.p(date, HTML.Tag.P0);
        Intrinsics.p(function1, "action");
        TimersKt$timerTask$1 timersKt$timerTask$1 = new TimersKt$timerTask$1(function1);
        timer.scheduleAtFixedRate(timersKt$timerTask$1, date, j2);
        return timersKt$timerTask$1;
    }

    @NotNull
    @PublishedApi
    public static final Timer k(@Nullable String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }

    @InlineOnly
    private static final Timer l(String str, boolean z, long j2, long j3, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(function1, "action");
        Timer k2 = k(str, z);
        k2.schedule(new TimersKt$timerTask$1(function1), j2, j3);
        return k2;
    }

    @InlineOnly
    private static final Timer m(String str, boolean z, Date date, long j2, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(date, "startAt");
        Intrinsics.p(function1, "action");
        Timer k2 = k(str, z);
        k2.schedule(new TimersKt$timerTask$1(function1), date, j2);
        return k2;
    }

    static /* synthetic */ Timer n(String str, boolean z, long j2, long j3, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            j2 = 0;
        }
        Intrinsics.p(function1, "action");
        Timer k2 = k(str, z);
        Timer timer = k2;
        timer.schedule(new TimersKt$timerTask$1(function1), j2, j3);
        return k2;
    }

    static /* synthetic */ Timer o(String str, boolean z, Date date, long j2, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        Intrinsics.p(date, "startAt");
        Intrinsics.p(function1, "action");
        Timer k2 = k(str, z);
        k2.schedule(new TimersKt$timerTask$1(function1), date, j2);
        return k2;
    }

    @InlineOnly
    private static final TimerTask p(Function1<? super TimerTask, Unit> function1) {
        Intrinsics.p(function1, "action");
        return new TimersKt$timerTask$1(function1);
    }
}
