package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public interface VisibilityAnimatorProvider {
    @Nullable
    Animator a(@NonNull ViewGroup viewGroup, @NonNull View view);

    @Nullable
    Animator b(@NonNull ViewGroup viewGroup, @NonNull View view);
}
