package kotlin.text;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {274, 282, 286}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
final class Regex$splitToSequence$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
    int X2;
    Object Y;
    private /* synthetic */ Object Y2;
    int Z;
    final /* synthetic */ Regex Z2;
    final /* synthetic */ CharSequence a3;
    final /* synthetic */ int b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Regex$splitToSequence$1(Regex regex, CharSequence charSequence, int i2, Continuation<? super Regex$splitToSequence$1> continuation) {
        super(2, continuation);
        this.Z2 = regex;
        this.a3 = charSequence;
        this.b3 = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x009c A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r9.X2
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r4) goto L_0x002d
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.n(r10)
            goto L_0x009d
        L_0x0016:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001e:
            int r1 = r9.Z
            java.lang.Object r5 = r9.Y
            java.util.regex.Matcher r5 = (java.util.regex.Matcher) r5
            java.lang.Object r6 = r9.Y2
            kotlin.sequences.SequenceScope r6 = (kotlin.sequences.SequenceScope) r6
            kotlin.ResultKt.n(r10)
            r10 = r5
            goto L_0x0071
        L_0x002d:
            kotlin.ResultKt.n(r10)
            goto L_0x00af
        L_0x0032:
            kotlin.ResultKt.n(r10)
            java.lang.Object r10 = r9.Y2
            kotlin.sequences.SequenceScope r10 = (kotlin.sequences.SequenceScope) r10
            kotlin.text.Regex r1 = r9.Z2
            java.util.regex.Pattern r1 = r1.s
            java.lang.CharSequence r5 = r9.a3
            java.util.regex.Matcher r1 = r1.matcher(r5)
            int r5 = r9.b3
            if (r5 == r4) goto L_0x00a0
            boolean r5 = r1.find()
            if (r5 != 0) goto L_0x0050
            goto L_0x00a0
        L_0x0050:
            r5 = 0
            r6 = r10
            r10 = r1
            r1 = 0
        L_0x0054:
            java.lang.CharSequence r7 = r9.a3
            int r8 = r10.start()
            java.lang.CharSequence r5 = r7.subSequence(r5, r8)
            java.lang.String r5 = r5.toString()
            r9.Y2 = r6
            r9.Y = r10
            r9.Z = r1
            r9.X2 = r3
            java.lang.Object r5 = r6.a(r5, r9)
            if (r5 != r0) goto L_0x0071
            return r0
        L_0x0071:
            int r5 = r10.end()
            int r1 = r1 + r4
            int r7 = r9.b3
            int r7 = r7 - r4
            if (r1 == r7) goto L_0x0081
            boolean r7 = r10.find()
            if (r7 != 0) goto L_0x0054
        L_0x0081:
            java.lang.CharSequence r10 = r9.a3
            int r1 = r10.length()
            java.lang.CharSequence r10 = r10.subSequence(r5, r1)
            java.lang.String r10 = r10.toString()
            r1 = 0
            r9.Y2 = r1
            r9.Y = r1
            r9.X2 = r2
            java.lang.Object r10 = r6.a(r10, r9)
            if (r10 != r0) goto L_0x009d
            return r0
        L_0x009d:
            kotlin.Unit r10 = kotlin.Unit.f28779a
            return r10
        L_0x00a0:
            java.lang.CharSequence r1 = r9.a3
            java.lang.String r1 = r1.toString()
            r9.X2 = r4
            java.lang.Object r10 = r10.a(r1, r9)
            if (r10 != r0) goto L_0x00af
            return r0
        L_0x00af:
            kotlin.Unit r10 = kotlin.Unit.f28779a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex$splitToSequence$1.D(java.lang.Object):java.lang.Object");
    }

    @Nullable
    /* renamed from: J */
    public final Object d0(@NotNull SequenceScope<? super String> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Regex$splitToSequence$1) v(sequenceScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Regex$splitToSequence$1 regex$splitToSequence$1 = new Regex$splitToSequence$1(this.Z2, this.a3, this.b3, continuation);
        regex$splitToSequence$1.Y2 = obj;
        return regex$splitToSequence$1;
    }
}
