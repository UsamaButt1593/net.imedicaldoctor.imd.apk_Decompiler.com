package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.EdgeToEdgeUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.shape.MaterialShapeDrawable;

public class BottomSheetDialog extends AppCompatDialog {
    /* access modifiers changed from: private */
    public BottomSheetBehavior<FrameLayout> Y2;
    private FrameLayout Z2;
    private CoordinatorLayout a3;
    /* access modifiers changed from: private */
    public FrameLayout b3;
    boolean c3;
    boolean d3;
    private boolean e3;
    private boolean f3;
    /* access modifiers changed from: private */
    public EdgeToEdgeCallback g3;
    private boolean h3;
    @Nullable
    private MaterialBackOrchestrator i3;
    @NonNull
    private BottomSheetBehavior.BottomSheetCallback j3;

    private static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Boolean f20867a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final WindowInsetsCompat f20868b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private Window f20869c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f20870d;

        private EdgeToEdgeCallback(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            Boolean bool;
            int intValue;
            this.f20868b = windowInsetsCompat;
            MaterialShapeDrawable E0 = BottomSheetBehavior.x0(view).E0();
            ColorStateList z = E0 != null ? E0.z() : ViewCompat.O(view);
            if (z != null) {
                intValue = z.getDefaultColor();
            } else {
                Integer j2 = ViewUtils.j(view);
                if (j2 != null) {
                    intValue = j2.intValue();
                } else {
                    bool = null;
                    this.f20867a = bool;
                }
            }
            bool = Boolean.valueOf(MaterialColors.q(intValue));
            this.f20867a = bool;
        }

        private void d(View view) {
            if (view.getTop() < this.f20868b.r()) {
                Window window = this.f20869c;
                if (window != null) {
                    Boolean bool = this.f20867a;
                    EdgeToEdgeUtils.g(window, bool == null ? this.f20870d : bool.booleanValue());
                }
                view.setPadding(view.getPaddingLeft(), this.f20868b.r() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                Window window2 = this.f20869c;
                if (window2 != null) {
                    EdgeToEdgeUtils.g(window2, this.f20870d);
                }
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        /* access modifiers changed from: package-private */
        public void a(@NonNull View view) {
            d(view);
        }

        public void b(@NonNull View view, float f2) {
            d(view);
        }

        public void c(@NonNull View view, int i2) {
            d(view);
        }

        /* access modifiers changed from: package-private */
        public void e(@Nullable Window window) {
            if (this.f20869c != window) {
                this.f20869c = window;
                if (window != null) {
                    this.f20870d = WindowCompat.a(window, window.getDecorView()).f();
                }
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
        this.h3 = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.A6}).getBoolean(0, false);
    }

    @Deprecated
    public static void B(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
        }
    }

    private void D() {
        MaterialBackOrchestrator materialBackOrchestrator = this.i3;
        if (materialBackOrchestrator != null) {
            if (this.d3) {
                materialBackOrchestrator.c();
            } else {
                materialBackOrchestrator.f();
            }
        }
    }

    private View E(int i2, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        t();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.Z2.findViewById(R.id.R0);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, coordinatorLayout, false);
        }
        if (this.h3) {
            ViewCompat.k2(this.b3, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                    if (BottomSheetDialog.this.g3 != null) {
                        BottomSheetDialog.this.Y2.Y0(BottomSheetDialog.this.g3);
                    }
                    if (windowInsetsCompat != null) {
                        BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                        EdgeToEdgeCallback unused = bottomSheetDialog.g3 = new EdgeToEdgeCallback(bottomSheetDialog.b3, windowInsetsCompat);
                        BottomSheetDialog.this.g3.e(BottomSheetDialog.this.getWindow());
                        BottomSheetDialog.this.Y2.h0(BottomSheetDialog.this.g3);
                    }
                    return windowInsetsCompat;
                }
            });
        }
        this.b3.removeAllViews();
        FrameLayout frameLayout = this.b3;
        if (layoutParams == null) {
            frameLayout.addView(view);
        } else {
            frameLayout.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.l6).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.d3 && bottomSheetDialog.isShowing() && BottomSheetDialog.this.C()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.H1(this.b3, new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                boolean z;
                super.g(view, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.d3) {
                    accessibilityNodeInfoCompat.a(1048576);
                    z = true;
                } else {
                    z = false;
                }
                accessibilityNodeInfoCompat.r1(z);
            }

            public boolean j(View view, int i2, Bundle bundle) {
                if (i2 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.d3) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.j(view, i2, bundle);
            }
        });
        this.b3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.Z2;
    }

    private static int l(@NonNull Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.l1, typedValue, true) ? typedValue.resourceId : R.style.Mb;
    }

    private FrameLayout t() {
        if (this.Z2 == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.E, (ViewGroup) null);
            this.Z2 = frameLayout;
            this.a3 = (CoordinatorLayout) frameLayout.findViewById(R.id.R0);
            FrameLayout frameLayout2 = (FrameLayout) this.Z2.findViewById(R.id.e1);
            this.b3 = frameLayout2;
            BottomSheetBehavior<FrameLayout> x0 = BottomSheetBehavior.x0(frameLayout2);
            this.Y2 = x0;
            x0.h0(this.j3);
            this.Y2.l1(this.d3);
            this.i3 = new MaterialBackOrchestrator(this.Y2, this.b3);
        }
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    public boolean C() {
        if (!this.f3) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.e3 = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f3 = true;
        }
        return this.e3;
    }

    public void cancel() {
        BottomSheetBehavior<FrameLayout> u = u();
        if (!this.c3 || u.getState() == 5) {
            super.cancel();
        } else {
            u.b(5);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            boolean z = this.h3 && Color.alpha(window.getNavigationBarColor()) < 255;
            FrameLayout frameLayout = this.Z2;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z);
            }
            CoordinatorLayout coordinatorLayout = this.a3;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z);
            }
            WindowCompat.c(window, !z);
            EdgeToEdgeCallback edgeToEdgeCallback = this.g3;
            if (edgeToEdgeCallback != null) {
                edgeToEdgeCallback.e(window);
            }
        }
        D();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i2 = Build.VERSION.SDK_INT;
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            if (i2 < 23) {
                window.addFlags(67108864);
            }
            window.setLayout(-1, -1);
        }
    }

    public void onDetachedFromWindow() {
        EdgeToEdgeCallback edgeToEdgeCallback = this.g3;
        if (edgeToEdgeCallback != null) {
            edgeToEdgeCallback.e((Window) null);
        }
        MaterialBackOrchestrator materialBackOrchestrator = this.i3;
        if (materialBackOrchestrator != null) {
            materialBackOrchestrator.f();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.Y2;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.Y2.b(4);
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.d3 != z) {
            this.d3 = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.Y2;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.l1(z);
            }
            if (getWindow() != null) {
                D();
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.d3) {
            this.d3 = true;
        }
        this.e3 = z;
        this.f3 = true;
    }

    public void setContentView(@LayoutRes int i2) {
        super.setContentView(E(i2, (View) null, (ViewGroup.LayoutParams) null));
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> u() {
        if (this.Y2 == null) {
            t();
        }
        return this.Y2;
    }

    public boolean v() {
        return this.c3;
    }

    public boolean w() {
        return this.h3;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        this.Y2.Y0(this.j3);
    }

    public void z(boolean z) {
        this.c3 = z;
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int i2) {
        super(context, l(context, i2));
        this.d3 = true;
        this.e3 = true;
        this.j3 = new BottomSheetBehavior.BottomSheetCallback() {
            public void b(@NonNull View view, float f2) {
            }

            public void c(@NonNull View view, int i2) {
                if (i2 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        o(1);
        this.h3 = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.A6}).getBoolean(0, false);
    }

    public void setContentView(View view) {
        super.setContentView(E(0, view, (ViewGroup.LayoutParams) null));
    }

    protected BottomSheetDialog(@NonNull Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.d3 = true;
        this.e3 = true;
        this.j3 = new BottomSheetBehavior.BottomSheetCallback() {
            public void b(@NonNull View view, float f2) {
            }

            public void c(@NonNull View view, int i2) {
                if (i2 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        o(1);
        this.d3 = z;
        this.h3 = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.A6}).getBoolean(0, false);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(E(0, view, layoutParams));
    }
}
