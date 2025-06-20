package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Scene {

    /* renamed from: a  reason: collision with root package name */
    private Context f16026a;

    /* renamed from: b  reason: collision with root package name */
    private int f16027b;

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f16028c;

    /* renamed from: d  reason: collision with root package name */
    private View f16029d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f16030e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f16031f;

    public Scene(@NonNull ViewGroup viewGroup) {
        this.f16027b = -1;
        this.f16028c = viewGroup;
    }

    @Nullable
    public static Scene c(@NonNull ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R.id.f16018g);
    }

    @NonNull
    public static Scene d(@NonNull ViewGroup viewGroup, @LayoutRes int i2, @NonNull Context context) {
        int i3 = R.id.f16023l;
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(i3);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(i3, sparseArray);
        }
        Scene scene = (Scene) sparseArray.get(i2);
        if (scene != null) {
            return scene;
        }
        Scene scene2 = new Scene(viewGroup, i2, context);
        sparseArray.put(i2, scene2);
        return scene2;
    }

    static void g(@NonNull ViewGroup viewGroup, @Nullable Scene scene) {
        viewGroup.setTag(R.id.f16018g, scene);
    }

    public void a() {
        if (this.f16027b > 0 || this.f16029d != null) {
            e().removeAllViews();
            if (this.f16027b > 0) {
                LayoutInflater.from(this.f16026a).inflate(this.f16027b, this.f16028c);
            } else {
                this.f16028c.addView(this.f16029d);
            }
        }
        Runnable runnable = this.f16030e;
        if (runnable != null) {
            runnable.run();
        }
        g(this.f16028c, this);
    }

    public void b() {
        Runnable runnable;
        if (c(this.f16028c) == this && (runnable = this.f16031f) != null) {
            runnable.run();
        }
    }

    @NonNull
    public ViewGroup e() {
        return this.f16028c;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f16027b > 0;
    }

    public void h(@Nullable Runnable runnable) {
        this.f16030e = runnable;
    }

    public void i(@Nullable Runnable runnable) {
        this.f16031f = runnable;
    }

    private Scene(ViewGroup viewGroup, int i2, Context context) {
        this.f16026a = context;
        this.f16028c = viewGroup;
        this.f16027b = i2;
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view) {
        this.f16027b = -1;
        this.f16028c = viewGroup;
        this.f16029d = view;
    }
}
