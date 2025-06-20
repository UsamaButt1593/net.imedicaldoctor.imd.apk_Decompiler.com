package com.bumptech.glide;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

public final class GenericTransitionOptions<TranscodeType> extends TransitionOptions<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    @NonNull
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> h(int i2) {
        return (GenericTransitionOptions) new GenericTransitionOptions().e(i2);
    }

    @NonNull
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> i(@NonNull TransitionFactory<? super TranscodeType> transitionFactory) {
        return (GenericTransitionOptions) new GenericTransitionOptions().f(transitionFactory);
    }

    @NonNull
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> l(@NonNull ViewPropertyTransition.Animator animator) {
        return (GenericTransitionOptions) new GenericTransitionOptions().g(animator);
    }

    @NonNull
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> m() {
        return (GenericTransitionOptions) new GenericTransitionOptions().b();
    }
}
