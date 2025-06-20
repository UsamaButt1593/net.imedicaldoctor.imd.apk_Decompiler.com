package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6425a = "LayoutInflaterCompatHC";

    /* renamed from: b  reason: collision with root package name */
    private static Field f6426b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f6427c;

    static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory s;

        Factory2Wrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.s = layoutInflaterFactory;
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.s.onCreateView(view, str, context, attributeSet);
        }

        @NonNull
        public String toString() {
            return getClass().getName() + "{" + this.s + "}";
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.s.onCreateView((View) null, str, context, attributeSet);
        }
    }

    private LayoutInflaterCompat() {
    }

    private static void a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        Class<LayoutInflater> cls = LayoutInflater.class;
        if (!f6427c) {
            try {
                Field declaredField = cls.getDeclaredField("mFactory2");
                f6426b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(f6425a, "forceSetFactory2 Could not find field 'mFactory2' on class " + cls.getName() + "; inflation may have unexpected results.", e2);
            }
            f6427c = true;
        }
        Field field = f6426b;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.e(f6425a, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e3);
            }
        }
    }

    @Deprecated
    public static LayoutInflaterFactory b(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2Wrapper) {
            return ((Factory2Wrapper) factory).s;
        }
        return null;
    }

    @Deprecated
    public static void c(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(new Factory2Wrapper(layoutInflaterFactory));
    }

    public static void d(@NonNull LayoutInflater layoutInflater, @NonNull LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
    }
}
