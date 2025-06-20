package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

public class NestedScrollingParentHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f6460a;

    /* renamed from: b  reason: collision with root package name */
    private int f6461b;

    public NestedScrollingParentHelper(@NonNull ViewGroup viewGroup) {
    }

    public int a() {
        return this.f6460a | this.f6461b;
    }

    public void b(@NonNull View view, @NonNull View view2, int i2) {
        c(view, view2, i2, 0);
    }

    public void c(@NonNull View view, @NonNull View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f6461b = i2;
        } else {
            this.f6460a = i2;
        }
    }

    public void d(@NonNull View view) {
        e(view, 0);
    }

    public void e(@NonNull View view, int i2) {
        if (i2 == 1) {
            this.f6461b = 0;
        } else {
            this.f6460a = 0;
        }
    }
}
