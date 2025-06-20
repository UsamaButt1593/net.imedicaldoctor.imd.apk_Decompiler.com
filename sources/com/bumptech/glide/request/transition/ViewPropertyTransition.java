package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.Transition;

public class ViewPropertyTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Animator f18512a;

    public interface Animator {
        void a(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.f18512a = animator;
    }

    public boolean a(R r, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.g() == null) {
            return false;
        }
        this.f18512a.a(viewAdapter.g());
        return false;
    }
}
