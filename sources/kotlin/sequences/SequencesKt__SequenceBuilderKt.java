package kotlin.sequences;

import com.itextpdf.tool.xml.css.CSS;
import java.util.Iterator;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\u001aO\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aO\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u00002/\b\u0001\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¢\u0006\u0002\b\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\"\u0018\u0010\u0011\u001a\u00060\u000ej\u0002`\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\u0010\"\u0018\u0010\u0012\u001a\u00060\u000ej\u0002`\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0010\"\u0018\u0010\u0014\u001a\u00060\u000ej\u0002`\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010\"\u0018\u0010\u0016\u001a\u00060\u000ej\u0002`\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010\"\u0018\u0010\u0018\u001a\u00060\u000ej\u0002`\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010\"\u0018\u0010\u001a\u001a\u00060\u000ej\u0002`\u000f8\u0002XT¢\u0006\u0006\n\u0004\b\u0019\u0010\u0010*\f\b\u0002\u0010\u001b\"\u00020\u000e2\u00020\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"T", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlin/sequences/Sequence;", "b", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "", "a", "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "", "Lkotlin/sequences/State;", "I", "State_NotReady", "State_ManyNotReady", "c", "State_ManyReady", "d", "State_Ready", "e", "State_Done", "f", "State_Failed", "State", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/sequences/SequencesKt")
class SequencesKt__SequenceBuilderKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f29014a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f29015b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f29016c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f29017d = 3;

    /* renamed from: e  reason: collision with root package name */
    private static final int f29018e = 4;

    /* renamed from: f  reason: collision with root package name */
    private static final int f29019f = 5;

    @NotNull
    @SinceKotlin(version = "1.3")
    public static <T> Iterator<T> a(@NotNull @BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.p(function2, CSS.Value.v0);
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.l(IntrinsicsKt.c(function2, sequenceBuilderIterator, sequenceBuilderIterator));
        return sequenceBuilderIterator;
    }

    @NotNull
    @SinceKotlin(version = "1.3")
    public static <T> Sequence<T> b(@NotNull @BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.p(function2, CSS.Value.v0);
        return new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(function2);
    }
}
