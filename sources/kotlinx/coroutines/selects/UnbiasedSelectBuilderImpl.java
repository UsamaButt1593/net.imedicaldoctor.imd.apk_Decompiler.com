package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@PublishedApi
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0001¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0012\u001a\u00020\t*\u00020\u000f2\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013JG\u0010\u0017\u001a\u00020\t\"\u0004\b\u0001\u0010\u0014*\b\u0012\u0004\u0012\u00028\u00010\u00152\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J[\u0010\u001c\u001a\u00020\t\"\u0004\b\u0001\u0010\u0019\"\u0004\b\u0002\u0010\u0014*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001a2\u0006\u0010\u001b\u001a\u00028\u00012\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ8\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\"8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R3\u0010/\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0)0(j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0)`*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "e", "", "c", "(Ljava/lang/Throwable;)V", "", "d", "()Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectClause0;", "Lkotlin/Function1;", "block", "h", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "q0", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "G", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "timeMillis", "U", "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "s", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "b", "()Lkotlinx/coroutines/selects/SelectBuilderImpl;", "instance", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "X", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "clauses", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class UnbiasedSelectBuilderImpl<R> implements SelectBuilder<R> {
    @NotNull
    private final ArrayList<Function0<Unit>> X = new ArrayList<>();
    @NotNull
    private final SelectBuilderImpl<R> s;

    public UnbiasedSelectBuilderImpl(@NotNull Continuation<? super R> continuation) {
        this.s = new SelectBuilderImpl<>(continuation);
    }

    public <P, Q> void G(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, P p, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.X.add(new UnbiasedSelectBuilderImpl$invoke$3(selectClause2, this, p, function2));
    }

    public void U(long j2, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.X.add(new UnbiasedSelectBuilderImpl$onTimeout$1(this, j2, function1));
    }

    @NotNull
    public final ArrayList<Function0<Unit>> a() {
        return this.X;
    }

    @NotNull
    public final SelectBuilderImpl<R> b() {
        return this.s;
    }

    @PublishedApi
    public final void c(@NotNull Throwable th) {
        this.s.g1(th);
    }

    @Nullable
    @PublishedApi
    public final Object d() {
        if (!this.s.I()) {
            try {
                Collections.shuffle(this.X);
                for (Function0 o : this.X) {
                    o.o();
                }
            } catch (Throwable th) {
                this.s.g1(th);
            }
        }
        return this.s.f1();
    }

    public void h(@NotNull SelectClause0 selectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> function1) {
        this.X.add(new UnbiasedSelectBuilderImpl$invoke$1(selectClause0, this, function1));
    }

    public <P, Q> void l(@NotNull SelectClause2<? super P, ? extends Q> selectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        SelectBuilder.DefaultImpls.a(this, selectClause2, function2);
    }

    public <Q> void q0(@NotNull SelectClause1<? extends Q> selectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        this.X.add(new UnbiasedSelectBuilderImpl$invoke$2(selectClause1, this, function2));
    }
}
