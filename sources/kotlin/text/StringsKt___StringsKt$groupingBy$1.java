package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.Grouping;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt$groupingBy$1\n*L\n1#1,2486:1\n*E\n"})
@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010(\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"kotlin/text/StringsKt___StringsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "", "", "b", "()Ljava/util/Iterator;", "element", "c", "(C)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
public final class StringsKt___StringsKt$groupingBy$1 implements Grouping<Character, K> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CharSequence f29110a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Function1<Character, K> f29111b;

    public StringsKt___StringsKt$groupingBy$1(CharSequence charSequence, Function1<? super Character, ? extends K> function1) {
        this.f29110a = charSequence;
        this.f29111b = function1;
    }

    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return c(((Character) obj).charValue());
    }

    @NotNull
    public Iterator<Character> b() {
        return StringsKt__StringsKt.z3(this.f29110a);
    }

    public K c(char c2) {
        return this.f29111b.f(Character.valueOf(c2));
    }
}
