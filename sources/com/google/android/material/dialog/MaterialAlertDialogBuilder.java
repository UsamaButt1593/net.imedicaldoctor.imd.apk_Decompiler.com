package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
    @AttrRes

    /* renamed from: e  reason: collision with root package name */
    private static final int f21392e = R.attr.P;
    @StyleRes

    /* renamed from: f  reason: collision with root package name */
    private static final int f21393f = R.style.O4;
    @AttrRes

    /* renamed from: g  reason: collision with root package name */
    private static final int f21394g = R.attr.hc;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Drawable f21395c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Rect f21396d;

    public MaterialAlertDialogBuilder(@NonNull Context context) {
        this(context, 0);
    }

    private static Context J(@NonNull Context context) {
        int L = L(context);
        Context c2 = MaterialThemeOverlay.c(context, (AttributeSet) null, f21392e, f21393f);
        return L == 0 ? c2 : new ContextThemeWrapper(c2, L);
    }

    private static int L(@NonNull Context context) {
        TypedValue a2 = MaterialAttributes.a(context, f21394g);
        if (a2 == null) {
            return 0;
        }
        return a2.data;
    }

    private static int M(@NonNull Context context, int i2) {
        return i2 == 0 ? L(context) : i2;
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: A0 */
    public MaterialAlertDialogBuilder setView(@Nullable View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }

    @Nullable
    public Drawable K() {
        return this.f21395c;
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: N */
    public MaterialAlertDialogBuilder a(@Nullable ListAdapter listAdapter, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.a(listAdapter, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder O(@Nullable Drawable drawable) {
        this.f21395c = drawable;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder P(@Px int i2) {
        this.f21396d.bottom = i2;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder Q(@Px int i2) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.f21396d.left = i2;
        } else {
            this.f21396d.right = i2;
        }
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder R(@Px int i2) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.f21396d.right = i2;
        } else {
            this.f21396d.left = i2;
        }
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public MaterialAlertDialogBuilder S(@Px int i2) {
        this.f21396d.top = i2;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: T */
    public MaterialAlertDialogBuilder b(boolean z) {
        return (MaterialAlertDialogBuilder) super.b(z);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: U */
    public MaterialAlertDialogBuilder c(@Nullable Cursor cursor, @Nullable DialogInterface.OnClickListener onClickListener, @NonNull String str) {
        return (MaterialAlertDialogBuilder) super.c(cursor, onClickListener, str);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: V */
    public MaterialAlertDialogBuilder d(@Nullable View view) {
        return (MaterialAlertDialogBuilder) super.d(view);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: W */
    public MaterialAlertDialogBuilder e(@DrawableRes int i2) {
        return (MaterialAlertDialogBuilder) super.e(i2);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: X */
    public MaterialAlertDialogBuilder f(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.f(drawable);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: Y */
    public MaterialAlertDialogBuilder g(@AttrRes int i2) {
        return (MaterialAlertDialogBuilder) super.g(i2);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: Z */
    public MaterialAlertDialogBuilder i(@ArrayRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.i(i2, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: a0 */
    public MaterialAlertDialogBuilder j(@Nullable CharSequence[] charSequenceArr, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.j(charSequenceArr, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: b0 */
    public MaterialAlertDialogBuilder k(@StringRes int i2) {
        return (MaterialAlertDialogBuilder) super.k(i2);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: c0 */
    public MaterialAlertDialogBuilder l(@Nullable CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.l(charSequence);
    }

    @NonNull
    public AlertDialog create() {
        AlertDialog create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.f21395c;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).o0(ViewCompat.T(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.b(this.f21395c, this.f21396d));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(create, this.f21396d));
        return create;
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: d0 */
    public MaterialAlertDialogBuilder m(@ArrayRes int i2, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.m(i2, zArr, onMultiChoiceClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: e0 */
    public MaterialAlertDialogBuilder n(@Nullable Cursor cursor, @NonNull String str, @NonNull String str2, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.n(cursor, str, str2, onMultiChoiceClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: f0 */
    public MaterialAlertDialogBuilder o(@Nullable CharSequence[] charSequenceArr, @Nullable boolean[] zArr, @Nullable DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.o(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: g0 */
    public MaterialAlertDialogBuilder setNegativeButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i2, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: h0 */
    public MaterialAlertDialogBuilder p(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.p(charSequence, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: i0 */
    public MaterialAlertDialogBuilder q(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.q(drawable);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: j0 */
    public MaterialAlertDialogBuilder r(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.r(i2, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: k0 */
    public MaterialAlertDialogBuilder s(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.s(charSequence, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: l0 */
    public MaterialAlertDialogBuilder t(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.t(drawable);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: m0 */
    public MaterialAlertDialogBuilder u(@Nullable DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.u(onCancelListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: n0 */
    public MaterialAlertDialogBuilder v(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.v(onDismissListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: o0 */
    public MaterialAlertDialogBuilder w(@Nullable AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.w(onItemSelectedListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: p0 */
    public MaterialAlertDialogBuilder x(@Nullable DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.x(onKeyListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: q0 */
    public MaterialAlertDialogBuilder setPositiveButton(@StringRes int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i2, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: r0 */
    public MaterialAlertDialogBuilder y(@Nullable CharSequence charSequence, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.y(charSequence, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: s0 */
    public MaterialAlertDialogBuilder z(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.z(drawable);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: t0 */
    public MaterialAlertDialogBuilder B(@ArrayRes int i2, int i3, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.B(i2, i3, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: u0 */
    public MaterialAlertDialogBuilder C(@Nullable Cursor cursor, int i2, @NonNull String str, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.C(cursor, i2, str, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: v0 */
    public MaterialAlertDialogBuilder D(@Nullable ListAdapter listAdapter, int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.D(listAdapter, i2, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: w0 */
    public MaterialAlertDialogBuilder E(@Nullable CharSequence[] charSequenceArr, int i2, @Nullable DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.E(charSequenceArr, i2, onClickListener);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: x0 */
    public MaterialAlertDialogBuilder F(@StringRes int i2) {
        return (MaterialAlertDialogBuilder) super.F(i2);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: y0 */
    public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    @NonNull
    @CanIgnoreReturnValue
    /* renamed from: z0 */
    public MaterialAlertDialogBuilder G(int i2) {
        return (MaterialAlertDialogBuilder) super.G(i2);
    }

    public MaterialAlertDialogBuilder(@NonNull Context context, int i2) {
        super(J(context), M(context, i2));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i3 = f21392e;
        int i4 = f21393f;
        this.f21396d = MaterialDialogs.a(context2, i3, i4);
        int c2 = MaterialColors.c(context2, R.attr.e4, getClass().getCanonicalName());
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes((AttributeSet) null, R.styleable.Il, i3, i4);
        int color = obtainStyledAttributes.getColor(R.styleable.Nl, c2);
        obtainStyledAttributes.recycle();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, (AttributeSet) null, i3, i4);
        materialShapeDrawable.a0(context2);
        materialShapeDrawable.p0(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.l0(dimension);
            }
        }
        this.f21395c = materialShapeDrawable;
    }
}
