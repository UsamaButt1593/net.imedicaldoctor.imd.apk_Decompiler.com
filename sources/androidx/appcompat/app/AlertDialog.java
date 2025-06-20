package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

public class AlertDialog extends AppCompatDialog implements DialogInterface {
    static final int Z2 = 0;
    static final int a3 = 1;
    final AlertController Y2;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final AlertController.AlertParams f2751a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2752b;

        public Builder(@NonNull Context context) {
            this(context, AlertDialog.r(context, 0));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder A(boolean z) {
            this.f2751a.Q = z;
            return this;
        }

        public Builder B(@ArrayRes int i2, int i3, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.v = alertParams.f2735a.getResources().getTextArray(i2);
            AlertController.AlertParams alertParams2 = this.f2751a;
            alertParams2.x = onClickListener;
            alertParams2.I = i3;
            alertParams2.H = true;
            return this;
        }

        public Builder C(Cursor cursor, int i2, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.K = cursor;
            alertParams.x = onClickListener;
            alertParams.I = i2;
            alertParams.L = str;
            alertParams.H = true;
            return this;
        }

        public Builder D(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.w = listAdapter;
            alertParams.x = onClickListener;
            alertParams.I = i2;
            alertParams.H = true;
            return this;
        }

        public Builder E(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.v = charSequenceArr;
            alertParams.x = onClickListener;
            alertParams.I = i2;
            alertParams.H = true;
            return this;
        }

        public Builder F(@StringRes int i2) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.f2740f = alertParams.f2735a.getText(i2);
            return this;
        }

        public Builder G(int i2) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.z = null;
            alertParams.y = i2;
            alertParams.E = false;
            return this;
        }

        @Deprecated
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Builder H(View view, int i2, int i3, int i4, int i5) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.z = view;
            alertParams.y = 0;
            alertParams.E = true;
            alertParams.A = i2;
            alertParams.B = i3;
            alertParams.C = i4;
            alertParams.D = i5;
            return this;
        }

        public AlertDialog I() {
            AlertDialog create = create();
            create.show();
            return create;
        }

        public Builder a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.w = listAdapter;
            alertParams.x = onClickListener;
            return this;
        }

        public Builder b(boolean z) {
            this.f2751a.r = z;
            return this;
        }

        public Builder c(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.K = cursor;
            alertParams.L = str;
            alertParams.x = onClickListener;
            return this;
        }

        @NonNull
        public AlertDialog create() {
            AlertDialog alertDialog = new AlertDialog(this.f2751a.f2735a, this.f2752b);
            this.f2751a.a(alertDialog.Y2);
            alertDialog.setCancelable(this.f2751a.r);
            if (this.f2751a.r) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.f2751a.s);
            alertDialog.setOnDismissListener(this.f2751a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f2751a.u;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        public Builder d(@Nullable View view) {
            this.f2751a.f2741g = view;
            return this;
        }

        public Builder e(@DrawableRes int i2) {
            this.f2751a.f2737c = i2;
            return this;
        }

        public Builder f(@Nullable Drawable drawable) {
            this.f2751a.f2738d = drawable;
            return this;
        }

        public Builder g(@AttrRes int i2) {
            TypedValue typedValue = new TypedValue();
            this.f2751a.f2735a.getTheme().resolveAttribute(i2, typedValue, true);
            this.f2751a.f2737c = typedValue.resourceId;
            return this;
        }

        @NonNull
        public Context getContext() {
            return this.f2751a.f2735a;
        }

        @Deprecated
        public Builder h(boolean z) {
            this.f2751a.N = z;
            return this;
        }

        public Builder i(@ArrayRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.v = alertParams.f2735a.getResources().getTextArray(i2);
            this.f2751a.x = onClickListener;
            return this;
        }

        public Builder j(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.v = charSequenceArr;
            alertParams.x = onClickListener;
            return this;
        }

        public Builder k(@StringRes int i2) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.f2742h = alertParams.f2735a.getText(i2);
            return this;
        }

        public Builder l(@Nullable CharSequence charSequence) {
            this.f2751a.f2742h = charSequence;
            return this;
        }

        public Builder m(@ArrayRes int i2, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.v = alertParams.f2735a.getResources().getTextArray(i2);
            AlertController.AlertParams alertParams2 = this.f2751a;
            alertParams2.J = onMultiChoiceClickListener;
            alertParams2.F = zArr;
            alertParams2.G = true;
            return this;
        }

        public Builder n(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.K = cursor;
            alertParams.J = onMultiChoiceClickListener;
            alertParams.M = str;
            alertParams.L = str2;
            alertParams.G = true;
            return this;
        }

        public Builder o(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.v = charSequenceArr;
            alertParams.J = onMultiChoiceClickListener;
            alertParams.F = zArr;
            alertParams.G = true;
            return this;
        }

        public Builder p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.f2746l = charSequence;
            alertParams.f2748n = onClickListener;
            return this;
        }

        public Builder q(Drawable drawable) {
            this.f2751a.f2747m = drawable;
            return this;
        }

        public Builder r(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.o = alertParams.f2735a.getText(i2);
            this.f2751a.q = onClickListener;
            return this;
        }

        public Builder s(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.o = charSequence;
            alertParams.q = onClickListener;
            return this;
        }

        public Builder setNegativeButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.f2746l = alertParams.f2735a.getText(i2);
            this.f2751a.f2748n = onClickListener;
            return this;
        }

        public Builder setPositiveButton(@StringRes int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.f2743i = alertParams.f2735a.getText(i2);
            this.f2751a.f2745k = onClickListener;
            return this;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.f2751a.f2740f = charSequence;
            return this;
        }

        public Builder setView(View view) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.z = view;
            alertParams.y = 0;
            alertParams.E = false;
            return this;
        }

        public Builder t(Drawable drawable) {
            this.f2751a.p = drawable;
            return this;
        }

        public Builder u(DialogInterface.OnCancelListener onCancelListener) {
            this.f2751a.s = onCancelListener;
            return this;
        }

        public Builder v(DialogInterface.OnDismissListener onDismissListener) {
            this.f2751a.t = onDismissListener;
            return this;
        }

        public Builder w(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f2751a.O = onItemSelectedListener;
            return this;
        }

        public Builder x(DialogInterface.OnKeyListener onKeyListener) {
            this.f2751a.u = onKeyListener;
            return this;
        }

        public Builder y(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.AlertParams alertParams = this.f2751a;
            alertParams.f2743i = charSequence;
            alertParams.f2745k = onClickListener;
            return this;
        }

        public Builder z(Drawable drawable) {
            this.f2751a.f2744j = drawable;
            return this;
        }

        public Builder(@NonNull Context context, @StyleRes int i2) {
            this.f2751a = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.r(context, i2)));
            this.f2752b = i2;
        }
    }

    protected AlertDialog(@NonNull Context context) {
        this(context, 0);
    }

    static int r(@NonNull Context context, @StyleRes int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.N, typedValue, true);
        return typedValue.resourceId;
    }

    public void B(int i2) {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(i2, typedValue, true);
        this.Y2.o(typedValue.resourceId);
    }

    public void C(CharSequence charSequence) {
        this.Y2.q(charSequence);
    }

    public void D(View view) {
        this.Y2.u(view);
    }

    public void E(View view, int i2, int i3, int i4, int i5) {
        this.Y2.v(view, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Y2.f();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.Y2.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.Y2.i(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    public Button p(int i2) {
        return this.Y2.c(i2);
    }

    public ListView q() {
        return this.Y2.e();
    }

    public void s(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        this.Y2.l(i2, charSequence, onClickListener, (Message) null, (Drawable) null);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.Y2.s(charSequence);
    }

    public void t(int i2, CharSequence charSequence, Drawable drawable, DialogInterface.OnClickListener onClickListener) {
        this.Y2.l(i2, charSequence, onClickListener, (Message) null, drawable);
    }

    public void u(int i2, CharSequence charSequence, Message message) {
        this.Y2.l(i2, charSequence, (DialogInterface.OnClickListener) null, message, (Drawable) null);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void v(int i2) {
        this.Y2.m(i2);
    }

    public void w(View view) {
        this.Y2.n(view);
    }

    public void x(int i2) {
        this.Y2.o(i2);
    }

    public void z(Drawable drawable) {
        this.Y2.p(drawable);
    }

    protected AlertDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, r(context, i2));
        this.Y2 = new AlertController(getContext(), this, getWindow());
    }

    protected AlertDialog(@NonNull Context context, boolean z, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }
}
