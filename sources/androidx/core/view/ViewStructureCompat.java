package androidx.core.view;

import android.os.Build;
import android.view.ViewStructure;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public class ViewStructureCompat {

    /* renamed from: a  reason: collision with root package name */
    private final Object f6528a;

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static void a(ViewStructure viewStructure, String str) {
            viewStructure.setClassName(str);
        }

        @DoNotInline
        static void b(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        @DoNotInline
        static void c(ViewStructure viewStructure, int i2, int i3, int i4, int i5, int i6, int i7) {
            viewStructure.setDimens(i2, i3, i4, i5, i6, i7);
        }

        @DoNotInline
        static void d(ViewStructure viewStructure, CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }

    private ViewStructureCompat(@NonNull ViewStructure viewStructure) {
        this.f6528a = viewStructure;
    }

    @RequiresApi(23)
    @NonNull
    public static ViewStructureCompat f(@NonNull ViewStructure viewStructure) {
        return new ViewStructureCompat(viewStructure);
    }

    public void a(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.a(N.a(this.f6528a), str);
        }
    }

    public void b(@NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.b(N.a(this.f6528a), charSequence);
        }
    }

    public void c(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.c(N.a(this.f6528a), i2, i3, i4, i5, i6, i7);
        }
    }

    public void d(@NonNull CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.d(N.a(this.f6528a), charSequence);
        }
    }

    @RequiresApi(23)
    @NonNull
    public ViewStructure e() {
        return N.a(this.f6528a);
    }
}
