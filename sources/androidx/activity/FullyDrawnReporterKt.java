package androidx.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a5\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001HHø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Landroidx/activity/FullyDrawnReporter;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "reporter", "a", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity_release"}, k = 2, mv = {1, 8, 0})
public final class FullyDrawnReporterKt {
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull androidx.activity.FullyDrawnReporter r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = (androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1 r0 = new androidx.activity.FullyDrawnReporterKt$reportWhenComplete$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r4 = r0.Z
            androidx.activity.FullyDrawnReporter r4 = (androidx.activity.FullyDrawnReporter) r4
            kotlin.ResultKt.n(r6)     // Catch:{ all -> 0x002d }
            goto L_0x0051
        L_0x002d:
            r5 = move-exception
            goto L_0x005d
        L_0x002f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0037:
            kotlin.ResultKt.n(r6)
            r4.c()
            boolean r6 = r4.e()
            if (r6 == 0) goto L_0x0046
            kotlin.Unit r4 = kotlin.Unit.f28779a
            return r4
        L_0x0046:
            r0.Z = r4     // Catch:{ all -> 0x002d }
            r0.Y2 = r3     // Catch:{ all -> 0x002d }
            java.lang.Object r5 = r5.f(r0)     // Catch:{ all -> 0x002d }
            if (r5 != r1) goto L_0x0051
            return r1
        L_0x0051:
            kotlin.jvm.internal.InlineMarker.d(r3)
            r4.h()
            kotlin.jvm.internal.InlineMarker.c(r3)
            kotlin.Unit r4 = kotlin.Unit.f28779a
            return r4
        L_0x005d:
            kotlin.jvm.internal.InlineMarker.d(r3)
            r4.h()
            kotlin.jvm.internal.InlineMarker.c(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.FullyDrawnReporterKt.a(androidx.activity.FullyDrawnReporter, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    private static final Object b(FullyDrawnReporter fullyDrawnReporter, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        fullyDrawnReporter.c();
        if (fullyDrawnReporter.e()) {
            return Unit.f28779a;
        }
        try {
            function1.f(continuation);
            InlineMarker.d(1);
            fullyDrawnReporter.h();
            InlineMarker.c(1);
            return Unit.f28779a;
        } catch (Throwable th) {
            InlineMarker.d(1);
            fullyDrawnReporter.h();
            InlineMarker.c(1);
            throw th;
        }
    }
}
