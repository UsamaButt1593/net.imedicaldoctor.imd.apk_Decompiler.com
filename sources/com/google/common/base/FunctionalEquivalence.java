package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long Y = 0;
    private final Equivalence<T> X;
    private final Function<? super F, ? extends T> s;

    FunctionalEquivalence(Function<? super F, ? extends T> function, Equivalence<T> equivalence) {
        this.s = (Function) Preconditions.E(function);
        this.X = (Equivalence) Preconditions.E(equivalence);
    }

    /* access modifiers changed from: protected */
    public boolean a(F f2, F f3) {
        return this.X.d(this.s.apply(f2), this.s.apply(f3));
    }

    /* access modifiers changed from: protected */
    public int b(F f2) {
        return this.X.f(this.s.apply(f2));
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        return this.s.equals(functionalEquivalence.s) && this.X.equals(functionalEquivalence.X);
    }

    public int hashCode() {
        return Objects.b(this.s, this.X);
    }

    public String toString() {
        return this.X + ".onResultOf(" + this.s + ")";
    }
}
