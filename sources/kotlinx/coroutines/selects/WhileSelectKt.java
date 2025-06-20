package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.ExperimentalCoroutinesApi;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\u0006\u001a\u00020\u00032\u001f\b\u0004\u0010\u0005\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0000¢\u0006\u0002\b\u0004HHø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "", "Lkotlin/ExtensionFunctionType;", "builder", "a", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class WhileSelectKt {
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    @org.jetbrains.annotations.Nullable
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super java.lang.Boolean>, kotlin.Unit> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1 r0 = (kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1 r0 = new kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.Z
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            kotlin.ResultKt.n(r5)
            goto L_0x0059
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.n(r5)
        L_0x0038:
            r0.Z = r4
            r0.Y2 = r3
            kotlinx.coroutines.selects.SelectBuilderImpl r5 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r5.<init>(r0)
            r4.f(r5)     // Catch:{ all -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r2 = move-exception
            r5.g1(r2)
        L_0x0049:
            java.lang.Object r5 = r5.f1()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            if (r5 != r2) goto L_0x0056
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L_0x0056:
            if (r5 != r1) goto L_0x0059
            return r1
        L_0x0059:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0038
            kotlin.Unit r4 = kotlin.Unit.f28779a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.WhileSelectKt.a(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @ExperimentalCoroutinesApi
    private static final Object b(Function1<? super SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation) {
        Object f1;
        do {
            InlineMarker.e(0);
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
            try {
                function1.f(selectBuilderImpl);
            } catch (Throwable th) {
                selectBuilderImpl.g1(th);
            }
            f1 = selectBuilderImpl.f1();
            if (f1 == IntrinsicsKt.l()) {
                DebugProbesKt.c(continuation);
            }
            InlineMarker.e(1);
        } while (((Boolean) f1).booleanValue());
        return Unit.f28779a;
    }
}
