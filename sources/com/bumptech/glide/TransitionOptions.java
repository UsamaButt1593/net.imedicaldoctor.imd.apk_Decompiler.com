package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
import com.bumptech.glide.util.Preconditions;

public abstract class TransitionOptions<CHILD extends TransitionOptions<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    private TransitionFactory<? super TranscodeType> s = NoTransition.c();

    private CHILD d() {
        return this;
    }

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (TransitionOptions) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @NonNull
    public final CHILD b() {
        return f(NoTransition.c());
    }

    /* access modifiers changed from: package-private */
    public final TransitionFactory<? super TranscodeType> c() {
        return this.s;
    }

    @NonNull
    public final CHILD e(int i2) {
        return f(new ViewAnimationFactory(i2));
    }

    @NonNull
    public final CHILD f(@NonNull TransitionFactory<? super TranscodeType> transitionFactory) {
        this.s = (TransitionFactory) Preconditions.d(transitionFactory);
        return d();
    }

    @NonNull
    public final CHILD g(@NonNull ViewPropertyTransition.Animator animator) {
        return f(new ViewPropertyAnimationFactory(animator));
    }
}
