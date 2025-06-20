package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActivityChooserView extends ViewGroup implements ActivityChooserModel.ActivityChooserModelClient {
    private final Callbacks X2;
    private final View Y2;
    private final Drawable Z2;
    final FrameLayout a3;
    private final ImageView b3;
    final FrameLayout c3;
    private final ImageView d3;
    private final int e3;
    ActionProvider f3;
    final DataSetObserver g3;
    private final ViewTreeObserver.OnGlobalLayoutListener h3;
    private ListPopupWindow i3;
    PopupWindow.OnDismissListener j3;
    boolean k3;
    int l3;
    private boolean m3;
    private int n3;
    final ActivityChooserViewAdapter s;

    private class ActivityChooserViewAdapter extends BaseAdapter {
        public static final int Z2 = Integer.MAX_VALUE;
        public static final int a3 = 4;
        private static final int b3 = 0;
        private static final int c3 = 1;
        private static final int d3 = 3;
        private int X = 4;
        private boolean X2;
        private boolean Y;
        private boolean Z;
        private ActivityChooserModel s;

        ActivityChooserViewAdapter() {
        }

        public int a() {
            return this.s.f();
        }

        public ActivityChooserModel b() {
            return this.s;
        }

        public ResolveInfo c() {
            return this.s.h();
        }

        public int d() {
            return this.s.j();
        }

        public boolean e() {
            return this.Y;
        }

        public int f() {
            int i2 = this.X;
            this.X = Integer.MAX_VALUE;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            for (int i4 = 0; i4 < count; i4++) {
                view = getView(i4, view, (ViewGroup) null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
            }
            this.X = i2;
            return i3;
        }

        public void g(ActivityChooserModel activityChooserModel) {
            ActivityChooserModel b2 = ActivityChooserView.this.s.b();
            if (b2 != null && ActivityChooserView.this.isShown()) {
                b2.unregisterObserver(ActivityChooserView.this.g3);
            }
            this.s = activityChooserModel;
            if (activityChooserModel != null && ActivityChooserView.this.isShown()) {
                activityChooserModel.registerObserver(ActivityChooserView.this.g3);
            }
            notifyDataSetChanged();
        }

        public int getCount() {
            int f2 = this.s.f();
            if (!this.Y && this.s.h() != null) {
                f2--;
            }
            int min = Math.min(f2, this.X);
            return this.X2 ? min + 1 : min;
        }

        public Object getItem(int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (!this.Y && this.s.h() != null) {
                    i2++;
                }
                return this.s.e(i2);
            } else if (itemViewType == 1) {
                return null;
            } else {
                throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public int getItemViewType(int i2) {
            return (!this.X2 || i2 != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R.id.H) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.f2641h, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i2);
                ((ImageView) view.findViewById(R.id.E)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R.id.s0)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.Y || i2 != 0 || !this.Z) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R.layout.f2641h, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R.id.s0)).setText(ActivityChooserView.this.getContext().getString(R.string.f2652e));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }

        public void h(int i2) {
            if (this.X != i2) {
                this.X = i2;
                notifyDataSetChanged();
            }
        }

        public void i(boolean z, boolean z2) {
            if (this.Y != z || this.Z != z2) {
                this.Y = z;
                this.Z = z2;
                notifyDataSetChanged();
            }
        }

        public void j(boolean z) {
            if (this.X2 != z) {
                this.X2 = z;
                notifyDataSetChanged();
            }
        }
    }

    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        Callbacks() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.j3;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.c3) {
                activityChooserView.a();
                Intent b2 = ActivityChooserView.this.s.b().b(ActivityChooserView.this.s.b().g(ActivityChooserView.this.s.c()));
                if (b2 != null) {
                    b2.addFlags(524288);
                    ActivityChooserView.this.getContext().startActivity(b2);
                }
            } else if (view == activityChooserView.a3) {
                activityChooserView.k3 = false;
                activityChooserView.d(activityChooserView.l3);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            ActionProvider actionProvider = ActivityChooserView.this.f3;
            if (actionProvider != null) {
                actionProvider.m(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i2);
            if (itemViewType == 0) {
                ActivityChooserView.this.a();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.k3) {
                    if (!activityChooserView.s.e()) {
                        i2++;
                    }
                    Intent b2 = ActivityChooserView.this.s.b().b(i2);
                    if (b2 != null) {
                        b2.addFlags(524288);
                        ActivityChooserView.this.getContext().startActivity(b2);
                    }
                } else if (i2 > 0) {
                    activityChooserView.s.b().r(i2);
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.d(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.c3) {
                if (activityChooserView.s.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.k3 = true;
                    activityChooserView2.d(activityChooserView2.l3);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class InnerLayout extends LinearLayout {
        private static final int[] s = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray F = TintTypedArray.F(context, attributeSet, s);
            setBackgroundDrawable(F.h(0));
            F.I();
        }
    }

    public ActivityChooserView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.h3);
        return true;
    }

    public boolean b() {
        return getListPopupWindow().b();
    }

    public boolean c() {
        if (b() || !this.m3) {
            return false;
        }
        this.k3 = false;
        d(this.l3);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        ActivityChooserViewAdapter activityChooserViewAdapter;
        if (this.s.b() != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.h3);
            boolean z = this.c3.getVisibility() == 0;
            int a2 = this.s.a();
            if (i2 == Integer.MAX_VALUE || a2 <= i2 + (z ? 1 : 0)) {
                this.s.j(false);
                activityChooserViewAdapter = this.s;
            } else {
                this.s.j(true);
                activityChooserViewAdapter = this.s;
                i2--;
            }
            activityChooserViewAdapter.h(i2);
            ListPopupWindow listPopupWindow = getListPopupWindow();
            if (!listPopupWindow.b()) {
                if (this.k3 || !z) {
                    this.s.i(true, z);
                } else {
                    this.s.i(false, false);
                }
                listPopupWindow.U(Math.min(this.s.f(), this.e3));
                listPopupWindow.a();
                ActionProvider actionProvider = this.f3;
                if (actionProvider != null) {
                    actionProvider.m(true);
                }
                listPopupWindow.k().setContentDescription(getContext().getString(R.string.f2653f));
                listPopupWindow.k().setSelector(new ColorDrawable(0));
                return;
            }
            return;
        }
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        View view;
        Drawable drawable;
        if (this.s.getCount() > 0) {
            this.a3.setEnabled(true);
        } else {
            this.a3.setEnabled(false);
        }
        int a2 = this.s.a();
        int d2 = this.s.d();
        if (a2 == 1 || (a2 > 1 && d2 > 0)) {
            this.c3.setVisibility(0);
            ResolveInfo c2 = this.s.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.d3.setImageDrawable(c2.loadIcon(packageManager));
            if (this.n3 != 0) {
                CharSequence loadLabel = c2.loadLabel(packageManager);
                this.c3.setContentDescription(getContext().getString(this.n3, new Object[]{loadLabel}));
            }
        } else {
            this.c3.setVisibility(8);
        }
        if (this.c3.getVisibility() == 0) {
            view = this.Y2;
            drawable = this.Z2;
        } else {
            view = this.Y2;
            drawable = null;
        }
        view.setBackgroundDrawable(drawable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ActivityChooserModel getDataModel() {
        return this.s.b();
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.i3 == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.i3 = listPopupWindow;
            listPopupWindow.q(this.s);
            this.i3.S(this);
            this.i3.d0(true);
            this.i3.f0(this.X2);
            this.i3.e0(this.X2);
        }
        return this.i3;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel b2 = this.s.b();
        if (b2 != null) {
            b2.registerObserver(this.g3);
        }
        this.m3 = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActivityChooserModel b2 = this.s.b();
        if (b2 != null) {
            b2.unregisterObserver(this.g3);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.h3);
        }
        if (b()) {
            a();
        }
        this.m3 = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        this.Y2.layout(0, 0, i5 - i2, i6 - i4);
        if (!b()) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        View view = this.Y2;
        if (this.c3.getVisibility() != 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4), 1073741824);
        }
        measureChild(view, i2, i4);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.s.g(activityChooserModel);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.n3 = i2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.b3.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.b3.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.l3 = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.j3 = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(ActionProvider actionProvider) {
        this.f3 = actionProvider;
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.g3 = new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.s.notifyDataSetChanged();
            }

            public void onInvalidated() {
                super.onInvalidated();
                ActivityChooserView.this.s.notifyDataSetInvalidated();
            }
        };
        this.h3 = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (!ActivityChooserView.this.b()) {
                    return;
                }
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().a();
                ActionProvider actionProvider = ActivityChooserView.this.f3;
                if (actionProvider != null) {
                    actionProvider.m(true);
                }
            }
        };
        this.l3 = 4;
        int[] iArr = R.styleable.Q;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        ViewCompat.F1(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        this.l3 = obtainStyledAttributes.getInt(R.styleable.S, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.R);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R.layout.f2640g, this, true);
        Callbacks callbacks = new Callbacks();
        this.X2 = callbacks;
        View findViewById = findViewById(R.id.f2622n);
        this.Y2 = findViewById;
        this.Z2 = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.y);
        this.c3 = frameLayout;
        frameLayout.setOnClickListener(callbacks);
        frameLayout.setOnLongClickListener(callbacks);
        int i4 = R.id.F;
        this.d3 = (ImageView) frameLayout.findViewById(i4);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.A);
        frameLayout2.setOnClickListener(callbacks);
        frameLayout2.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo).g1(true);
            }
        });
        frameLayout2.setOnTouchListener(new ForwardingListener(frameLayout2) {
            public ShowableListMenu b() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* access modifiers changed from: protected */
            public boolean c() {
                ActivityChooserView.this.c();
                return true;
            }

            /* access modifiers changed from: protected */
            public boolean d() {
                ActivityChooserView.this.a();
                return true;
            }
        });
        this.a3 = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i4);
        this.b3 = imageView;
        imageView.setImageDrawable(drawable);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter();
        this.s = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.e();
            }
        });
        Resources resources = context.getResources();
        this.e3 = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.x));
    }
}
