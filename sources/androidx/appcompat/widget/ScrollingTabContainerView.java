package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.widget.LinearLayoutCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ScrollingTabContainerView extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final String h3 = "ScrollingTabContainerView";
    private static final Interpolator i3 = new DecelerateInterpolator();
    private static final int j3 = 200;
    private TabClickListener X2;
    LinearLayoutCompat Y2;
    private Spinner Z2;
    private boolean a3;
    int b3;
    int c3;
    private int d3;
    private int e3;
    protected ViewPropertyAnimator f3;
    protected final VisibilityAnimListener g3 = new VisibilityAnimListener();
    Runnable s;

    private class TabAdapter extends BaseAdapter {
        TabAdapter() {
        }

        public int getCount() {
            return ScrollingTabContainerView.this.Y2.getChildCount();
        }

        public Object getItem(int i2) {
            return ((TabView) ScrollingTabContainerView.this.Y2.getChildAt(i2)).b();
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ScrollingTabContainerView.this.g((ActionBar.Tab) getItem(i2), true);
            }
            ((TabView) view).a((ActionBar.Tab) getItem(i2));
            return view;
        }
    }

    private class TabClickListener implements View.OnClickListener {
        TabClickListener() {
        }

        public void onClick(View view) {
            ((TabView) view).b().g();
            int childCount = ScrollingTabContainerView.this.Y2.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = ScrollingTabContainerView.this.Y2.getChildAt(i2);
                childAt.setSelected(childAt == view);
            }
        }
    }

    private class TabView extends LinearLayout {
        private static final String c3 = "androidx.appcompat.app.ActionBar$Tab";
        private ActionBar.Tab X2;
        private TextView Y2;
        private ImageView Z2;
        private View a3;
        private final int[] s;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public TabView(android.content.Context r4, androidx.appcompat.app.ActionBar.Tab r5, boolean r6) {
            /*
                r2 = this;
                androidx.appcompat.widget.ScrollingTabContainerView.this = r3
                int r3 = androidx.appcompat.R.attr.f2558h
                r0 = 0
                r2.<init>(r4, r0, r3)
                r1 = 16842964(0x10100d4, float:2.3694152E-38)
                int[] r1 = new int[]{r1}
                r2.s = r1
                r2.X2 = r5
                r5 = 0
                androidx.appcompat.widget.TintTypedArray r3 = androidx.appcompat.widget.TintTypedArray.G(r4, r0, r1, r3, r5)
                boolean r4 = r3.C(r5)
                if (r4 == 0) goto L_0x0025
                android.graphics.drawable.Drawable r4 = r3.h(r5)
                r2.setBackgroundDrawable(r4)
            L_0x0025:
                r3.I()
                if (r6 == 0) goto L_0x0030
                r3 = 8388627(0x800013, float:1.175497E-38)
                r2.setGravity(r3)
            L_0x0030:
                r2.c()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ScrollingTabContainerView.TabView.<init>(androidx.appcompat.widget.ScrollingTabContainerView, android.content.Context, androidx.appcompat.app.ActionBar$Tab, boolean):void");
        }

        public void a(ActionBar.Tab tab) {
            this.X2 = tab;
            c();
        }

        public ActionBar.Tab b() {
            return this.X2;
        }

        public void c() {
            ActionBar.Tab tab = this.X2;
            View b2 = tab.b();
            CharSequence charSequence = null;
            if (b2 != null) {
                ViewParent parent = b2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b2);
                    }
                    addView(b2);
                }
                this.a3 = b2;
                TextView textView = this.Y2;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.Z2;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.Z2.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.a3;
            if (view != null) {
                removeView(view);
                this.a3 = null;
            }
            Drawable c2 = tab.c();
            CharSequence f2 = tab.f();
            if (c2 != null) {
                if (this.Z2 == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.Z2 = appCompatImageView;
                }
                this.Z2.setImageDrawable(c2);
                this.Z2.setVisibility(0);
            } else {
                ImageView imageView2 = this.Z2;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.Z2.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(f2);
            if (z) {
                if (this.Y2 == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), (AttributeSet) null, R.attr.f2559i);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.Y2 = appCompatTextView;
                }
                this.Y2.setText(f2);
                this.Y2.setVisibility(0);
            } else {
                TextView textView2 = this.Y2;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.Y2.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.Z2;
            if (imageView3 != null) {
                imageView3.setContentDescription(tab.a());
            }
            if (!z) {
                charSequence = tab.a();
            }
            TooltipCompat.a(this, charSequence);
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(c3);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(c3);
        }

        public void onMeasure(int i2, int i3) {
            int i4;
            super.onMeasure(i2, i3);
            if (ScrollingTabContainerView.this.b3 > 0 && getMeasuredWidth() > (i4 = ScrollingTabContainerView.this.b3)) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    protected class VisibilityAnimListener extends AnimatorListenerAdapter {
        private int X;
        private boolean s = false;

        protected VisibilityAnimListener() {
        }

        public VisibilityAnimListener a(ViewPropertyAnimator viewPropertyAnimator, int i2) {
            this.X = i2;
            ScrollingTabContainerView.this.f3 = viewPropertyAnimator;
            return this;
        }

        public void onAnimationCancel(Animator animator) {
            this.s = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.s) {
                ScrollingTabContainerView scrollingTabContainerView = ScrollingTabContainerView.this;
                scrollingTabContainerView.f3 = null;
                scrollingTabContainerView.setVisibility(this.X);
            }
        }

        public void onAnimationStart(Animator animator) {
            ScrollingTabContainerView.this.setVisibility(0);
            this.s = false;
        }
    }

    public ScrollingTabContainerView(@NonNull Context context) {
        super(context);
        setHorizontalScrollBarEnabled(false);
        ActionBarPolicy b2 = ActionBarPolicy.b(context);
        setContentHeight(b2.f());
        this.c3 = b2.e();
        LinearLayoutCompat f2 = f();
        this.Y2 = f2;
        addView(f2, new ViewGroup.LayoutParams(-2, -1));
    }

    private Spinner e() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), (AttributeSet) null, R.attr.f2563m);
        appCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    private LinearLayoutCompat f() {
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(getContext(), (AttributeSet) null, R.attr.f2557g);
        linearLayoutCompat.setMeasureWithLargestChildEnabled(true);
        linearLayoutCompat.setGravity(17);
        linearLayoutCompat.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
        return linearLayoutCompat;
    }

    private boolean h() {
        Spinner spinner = this.Z2;
        return spinner != null && spinner.getParent() == this;
    }

    private void i() {
        if (!h()) {
            if (this.Z2 == null) {
                this.Z2 = e();
            }
            removeView(this.Y2);
            addView(this.Z2, new ViewGroup.LayoutParams(-2, -1));
            if (this.Z2.getAdapter() == null) {
                this.Z2.setAdapter(new TabAdapter());
            }
            Runnable runnable = this.s;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.s = null;
            }
            this.Z2.setSelection(this.e3);
        }
    }

    private boolean j() {
        if (!h()) {
            return false;
        }
        removeView(this.Z2);
        addView(this.Y2, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.Z2.getSelectedItemPosition());
        return false;
    }

    public void a(ActionBar.Tab tab, int i2, boolean z) {
        TabView g2 = g(tab, false);
        this.Y2.addView(g2, i2, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.Z2;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            g2.setSelected(true);
        }
        if (this.a3) {
            requestLayout();
        }
    }

    public void b(ActionBar.Tab tab, boolean z) {
        TabView g2 = g(tab, false);
        this.Y2.addView(g2, new LinearLayoutCompat.LayoutParams(0, -1, 1.0f));
        Spinner spinner = this.Z2;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z) {
            g2.setSelected(true);
        }
        if (this.a3) {
            requestLayout();
        }
    }

    public void c(int i2) {
        final View childAt = this.Y2.getChildAt(i2);
        Runnable runnable = this.s;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                ScrollingTabContainerView.this.smoothScrollTo(childAt.getLeft() - ((ScrollingTabContainerView.this.getWidth() - childAt.getWidth()) / 2), 0);
                ScrollingTabContainerView.this.s = null;
            }
        };
        this.s = r0;
        post(r0);
    }

    public void d(int i2) {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator viewPropertyAnimator = this.f3;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i2 == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            alpha = animate().alpha(1.0f);
        } else {
            alpha = animate().alpha(0.0f);
        }
        alpha.setDuration(200);
        alpha.setInterpolator(i3);
        alpha.setListener(this.g3.a(alpha, i2));
        alpha.start();
    }

    /* access modifiers changed from: package-private */
    public TabView g(ActionBar.Tab tab, boolean z) {
        TabView tabView = new TabView(getContext(), tab, z);
        if (z) {
            tabView.setBackgroundDrawable((Drawable) null);
            tabView.setLayoutParams(new AbsListView.LayoutParams(-1, this.d3));
        } else {
            tabView.setFocusable(true);
            if (this.X2 == null) {
                this.X2 = new TabClickListener();
            }
            tabView.setOnClickListener(this.X2);
        }
        return tabView;
    }

    public void k() {
        this.Y2.removeAllViews();
        Spinner spinner = this.Z2;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.a3) {
            requestLayout();
        }
    }

    public void l(int i2) {
        this.Y2.removeViewAt(i2);
        Spinner spinner = this.Z2;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.a3) {
            requestLayout();
        }
    }

    public void m(int i2) {
        ((TabView) this.Y2.getChildAt(i2)).c();
        Spinner spinner = this.Z2;
        if (spinner != null) {
            ((TabAdapter) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.a3) {
            requestLayout();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.s;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionBarPolicy b2 = ActionBarPolicy.b(getContext());
        setContentHeight(b2.f());
        this.c3 = b2.e();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.s;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        ((TabView) view).b().g();
    }

    public void onMeasure(int i2, int i4) {
        int i5;
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.Y2.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i5 = -1;
        } else {
            if (childCount > 2) {
                this.b3 = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
            } else {
                this.b3 = View.MeasureSpec.getSize(i2) / 2;
            }
            i5 = Math.min(this.b3, this.c3);
        }
        this.b3 = i5;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.d3, 1073741824);
        if (!z && this.a3) {
            this.Y2.measure(0, makeMeasureSpec);
            if (this.Y2.getMeasuredWidth() > View.MeasureSpec.getSize(i2)) {
                i();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i2, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z && measuredWidth != measuredWidth2) {
                    setTabSelected(this.e3);
                    return;
                }
            }
        }
        j();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i2, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z) {
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.a3 = z;
    }

    public void setContentHeight(int i2) {
        this.d3 = i2;
        requestLayout();
    }

    public void setTabSelected(int i2) {
        this.e3 = i2;
        int childCount = this.Y2.getChildCount();
        int i4 = 0;
        while (i4 < childCount) {
            View childAt = this.Y2.getChildAt(i4);
            boolean z = i4 == i2;
            childAt.setSelected(z);
            if (z) {
                c(i2);
            }
            i4++;
        }
        Spinner spinner = this.Z2;
        if (spinner != null && i2 >= 0) {
            spinner.setSelection(i2);
        }
    }
}
