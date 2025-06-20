package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.annotation.LayoutRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private static final String A4 = "android:theme";
    private static final String B4 = "android:cancelable";
    private static final String C4 = "android:showsDialog";
    private static final String D4 = "android:backStackId";
    private static final String E4 = "android:dialogShowing";
    public static final int u4 = 0;
    public static final int v4 = 1;
    public static final int w4 = 2;
    public static final int x4 = 3;
    private static final String y4 = "android:savedDialogState";
    private static final String z4 = "android:style";
    private Handler e4;
    private Runnable f4 = new Runnable() {
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            DialogFragment.this.h4.onDismiss(DialogFragment.this.p4);
        }
    };
    private DialogInterface.OnCancelListener g4 = new DialogInterface.OnCancelListener() {
        @SuppressLint({"SyntheticAccessor"})
        public void onCancel(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.p4 != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onCancel(dialogFragment.p4);
            }
        }
    };
    /* access modifiers changed from: private */
    public DialogInterface.OnDismissListener h4 = new DialogInterface.OnDismissListener() {
        @SuppressLint({"SyntheticAccessor"})
        public void onDismiss(@Nullable DialogInterface dialogInterface) {
            if (DialogFragment.this.p4 != null) {
                DialogFragment dialogFragment = DialogFragment.this;
                dialogFragment.onDismiss(dialogFragment.p4);
            }
        }
    };
    private int i4 = 0;
    private int j4 = 0;
    private boolean k4 = true;
    /* access modifiers changed from: private */
    public boolean l4 = true;
    private int m4 = -1;
    private boolean n4;
    private Observer<LifecycleOwner> o4 = new Observer<LifecycleOwner>() {
        @SuppressLint({"SyntheticAccessor"})
        /* renamed from: a */
        public void b(LifecycleOwner lifecycleOwner) {
            if (lifecycleOwner != null && DialogFragment.this.l4) {
                View b2 = DialogFragment.this.b2();
                if (b2.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                } else if (DialogFragment.this.p4 != null) {
                    if (FragmentManager.W0(3)) {
                        Log.d(FragmentManager.Y, "DialogFragment " + this + " setting the content view on " + DialogFragment.this.p4);
                    }
                    DialogFragment.this.p4.setContentView(b2);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    @Nullable
    public Dialog p4;
    private boolean q4;
    private boolean r4;
    private boolean s4;
    private boolean t4 = false;

    public DialogFragment() {
    }

    private void O2(boolean z, boolean z2, boolean z3) {
        if (!this.r4) {
            this.r4 = true;
            this.s4 = false;
            Dialog dialog = this.p4;
            if (dialog != null) {
                dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
                this.p4.dismiss();
                if (!z2) {
                    if (Looper.myLooper() == this.e4.getLooper()) {
                        onDismiss(this.p4);
                    } else {
                        this.e4.post(this.f4);
                    }
                }
            }
            this.q4 = true;
            if (this.m4 >= 0) {
                if (z3) {
                    V().w1(this.m4, 1);
                } else {
                    V().t1(this.m4, 1, z);
                }
                this.m4 = -1;
                return;
            }
            FragmentTransaction u = V().u();
            u.Q(true);
            u.B(this);
            if (z3) {
                u.s();
            } else if (z) {
                u.r();
            } else {
                u.q();
            }
        }
    }

    private void X2(@Nullable Bundle bundle) {
        if (this.l4 && !this.t4) {
            try {
                this.n4 = true;
                Dialog U2 = U2(bundle);
                this.p4 = U2;
                if (this.l4) {
                    c3(U2, this.i4);
                    Context B = B();
                    if (B instanceof Activity) {
                        this.p4.setOwnerActivity((Activity) B);
                    }
                    this.p4.setCancelable(this.k4);
                    this.p4.setOnCancelListener(this.g4);
                    this.p4.setOnDismissListener(this.h4);
                    this.t4 = true;
                } else {
                    this.p4 = null;
                }
            } finally {
                this.n4 = false;
            }
        }
    }

    @MainThread
    @Deprecated
    public void K0(@Nullable Bundle bundle) {
        super.K0(bundle);
    }

    public void M2() {
        O2(false, false, false);
    }

    @MainThread
    public void N0(@NonNull Context context) {
        super.N0(context);
        s0().l(this.o4);
        if (!this.s4) {
            this.r4 = false;
        }
    }

    public void N2() {
        O2(true, false, false);
    }

    @MainThread
    public void P2() {
        O2(false, false, true);
    }

    @MainThread
    public void Q0(@Nullable Bundle bundle) {
        super.Q0(bundle);
        this.e4 = new Handler();
        this.l4 = this.r3 == 0;
        if (bundle != null) {
            this.i4 = bundle.getInt(z4, 0);
            this.j4 = bundle.getInt(A4, 0);
            this.k4 = bundle.getBoolean(B4, true);
            this.l4 = bundle.getBoolean(C4, this.l4);
            this.m4 = bundle.getInt(D4, -1);
        }
    }

    @Nullable
    public Dialog Q2() {
        return this.p4;
    }

    public boolean R2() {
        return this.l4;
    }

    @StyleRes
    public int S2() {
        return this.j4;
    }

    public boolean T2() {
        return this.k4;
    }

    @MainThread
    @NonNull
    public Dialog U2(@Nullable Bundle bundle) {
        if (FragmentManager.W0(3)) {
            Log.d(FragmentManager.Y, "onCreateDialog called for DialogFragment " + this);
        }
        return new ComponentDialog(X1(), S2());
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public View V2(int i2) {
        Dialog dialog = this.p4;
        if (dialog != null) {
            return dialog.findViewById(i2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean W2() {
        return this.t4;
    }

    @MainThread
    public void X0() {
        super.X0();
        Dialog dialog = this.p4;
        if (dialog != null) {
            this.q4 = true;
            dialog.setOnDismissListener((DialogInterface.OnDismissListener) null);
            this.p4.dismiss();
            if (!this.r4) {
                onDismiss(this.p4);
            }
            this.p4 = null;
            this.t4 = false;
        }
    }

    @MainThread
    public void Y0() {
        super.Y0();
        if (!this.s4 && !this.r4) {
            this.r4 = true;
        }
        s0().p(this.o4);
    }

    @NonNull
    public final Dialog Y2() {
        Dialog Q2 = Q2();
        if (Q2 != null) {
            return Q2;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    @NonNull
    public LayoutInflater Z0(@Nullable Bundle bundle) {
        StringBuilder sb;
        String str;
        LayoutInflater Z0 = super.Z0(bundle);
        if (!this.l4 || this.n4) {
            if (FragmentManager.W0(2)) {
                String str2 = "getting layout inflater for DialogFragment " + this;
                if (!this.l4) {
                    sb = new StringBuilder();
                    str = "mShowsDialog = false: ";
                } else {
                    sb = new StringBuilder();
                    str = "mCreatingDialog = true: ";
                }
                sb.append(str);
                sb.append(str2);
                Log.d(FragmentManager.Y, sb.toString());
            }
            return Z0;
        }
        X2(bundle);
        if (FragmentManager.W0(2)) {
            Log.d(FragmentManager.Y, "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.p4;
        return dialog != null ? Z0.cloneInContext(dialog.getContext()) : Z0;
    }

    public void Z2(boolean z) {
        this.k4 = z;
        Dialog dialog = this.p4;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void a3(boolean z) {
        this.l4 = z;
    }

    public void b3(int i2, @StyleRes int i3) {
        if (FragmentManager.W0(2)) {
            Log.d(FragmentManager.Y, "Setting style and theme for DialogFragment " + this + " to " + i2 + ", " + i3);
        }
        this.i4 = i2;
        if (i2 == 2 || i2 == 3) {
            this.j4 = 16973913;
        }
        if (i3 != 0) {
            this.j4 = i3;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c3(@NonNull Dialog dialog, int i2) {
        if (!(i2 == 1 || i2 == 2)) {
            if (i2 == 3) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.addFlags(24);
                }
            } else {
                return;
            }
        }
        dialog.requestWindowFeature(1);
    }

    public int d3(@NonNull FragmentTransaction fragmentTransaction, @Nullable String str) {
        this.r4 = false;
        this.s4 = true;
        fragmentTransaction.k(this, str);
        this.q4 = false;
        int q = fragmentTransaction.q();
        this.m4 = q;
        return q;
    }

    public void e3(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.r4 = false;
        this.s4 = true;
        FragmentTransaction u = fragmentManager.u();
        u.Q(true);
        u.k(this, str);
        u.q();
    }

    public void f3(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        this.r4 = false;
        this.s4 = true;
        FragmentTransaction u = fragmentManager.u();
        u.Q(true);
        u.k(this, str);
        u.s();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public FragmentContainer k() {
        final FragmentContainer k2 = super.k();
        return new FragmentContainer() {
            @Nullable
            public View g(int i2) {
                return k2.i() ? k2.g(i2) : DialogFragment.this.V2(i2);
            }

            public boolean i() {
                return k2.i() || DialogFragment.this.W2();
            }
        };
    }

    @MainThread
    public void m1(@NonNull Bundle bundle) {
        super.m1(bundle);
        Dialog dialog = this.p4;
        if (dialog != null) {
            Bundle onSaveInstanceState = dialog.onSaveInstanceState();
            onSaveInstanceState.putBoolean(E4, false);
            bundle.putBundle(y4, onSaveInstanceState);
        }
        int i2 = this.i4;
        if (i2 != 0) {
            bundle.putInt(z4, i2);
        }
        int i3 = this.j4;
        if (i3 != 0) {
            bundle.putInt(A4, i3);
        }
        boolean z = this.k4;
        if (!z) {
            bundle.putBoolean(B4, z);
        }
        boolean z2 = this.l4;
        if (!z2) {
            bundle.putBoolean(C4, z2);
        }
        int i5 = this.m4;
        if (i5 != -1) {
            bundle.putInt(D4, i5);
        }
    }

    @MainThread
    public void n1() {
        super.n1();
        Dialog dialog = this.p4;
        if (dialog != null) {
            this.q4 = false;
            dialog.show();
            View decorView = this.p4.getWindow().getDecorView();
            ViewTreeLifecycleOwner.b(decorView, this);
            ViewTreeViewModelStoreOwner.b(decorView, this);
            ViewTreeSavedStateRegistryOwner.b(decorView, this);
        }
    }

    @MainThread
    public void o1() {
        super.o1();
        Dialog dialog = this.p4;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void onCancel(@NonNull DialogInterface dialogInterface) {
    }

    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        if (!this.q4) {
            if (FragmentManager.W0(3)) {
                Log.d(FragmentManager.Y, "onDismiss called for DialogFragment " + this);
            }
            O2(true, true, false);
        }
    }

    @MainThread
    public void q1(@Nullable Bundle bundle) {
        Bundle bundle2;
        super.q1(bundle);
        if (this.p4 != null && bundle != null && (bundle2 = bundle.getBundle(y4)) != null) {
            this.p4.onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    public void x1(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle bundle2;
        super.x1(layoutInflater, viewGroup, bundle);
        if (this.B3 == null && this.p4 != null && bundle != null && (bundle2 = bundle.getBundle(y4)) != null) {
            this.p4.onRestoreInstanceState(bundle2);
        }
    }

    public DialogFragment(@LayoutRes int i2) {
        super(i2);
    }
}
