package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private FrameLayout X2;
    private Context Y2;
    private FragmentManager Z2;
    private int a3;
    private TabHost.OnTabChangeListener b3;
    private TabInfo c3;
    private boolean d3;
    private final ArrayList<TabInfo> s = new ArrayList<>();

    static class DummyTabFactory implements TabHost.TabContentFactory {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7989a;

        public DummyTabFactory(Context context) {
            this.f7989a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f7989a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        String s;

        SavedState(Parcel parcel) {
            super(parcel);
            this.s = parcel.readString();
        }

        @NonNull
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.s + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.s);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    static final class TabInfo {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final String f7990a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f7991b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        final Bundle f7992c;

        /* renamed from: d  reason: collision with root package name */
        Fragment f7993d;

        TabInfo(@NonNull String str, @NonNull Class<?> cls, @Nullable Bundle bundle) {
            this.f7990a = str;
            this.f7991b = cls;
            this.f7992c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context) {
        super(context, (AttributeSet) null);
        f(context, (AttributeSet) null);
    }

    @Nullable
    private FragmentTransaction b(@Nullable String str, @Nullable FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        TabInfo e2 = e(str);
        if (this.c3 != e2) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.Z2.u();
            }
            TabInfo tabInfo = this.c3;
            if (!(tabInfo == null || (fragment = tabInfo.f7993d) == null)) {
                fragmentTransaction.v(fragment);
            }
            if (e2 != null) {
                Fragment fragment2 = e2.f7993d;
                if (fragment2 == null) {
                    Fragment a2 = this.Z2.G0().a(this.Y2.getClassLoader(), e2.f7991b.getName());
                    e2.f7993d = a2;
                    a2.i2(e2.f7992c);
                    fragmentTransaction.g(this.a3, e2.f7993d, e2.f7990a);
                } else {
                    fragmentTransaction.p(fragment2);
                }
            }
            this.c3 = e2;
        }
        return fragmentTransaction;
    }

    private void c() {
        if (this.X2 == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.a3);
            this.X2 = frameLayout;
            if (frameLayout == null) {
                throw new IllegalStateException("No tab content FrameLayout found for id " + this.a3);
            }
        }
    }

    private void d(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.X2 = frameLayout2;
            frameLayout2.setId(this.a3);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @Nullable
    private TabInfo e(String str) {
        int size = this.s.size();
        for (int i2 = 0; i2 < size; i2++) {
            TabInfo tabInfo = this.s.get(i2);
            if (tabInfo.f7990a.equals(str)) {
                return tabInfo;
            }
        }
        return null;
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.a3 = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void a(@NonNull TabHost.TabSpec tabSpec, @NonNull Class<?> cls, @Nullable Bundle bundle) {
        tabSpec.setContent(new DummyTabFactory(this.Y2));
        String tag = tabSpec.getTag();
        TabInfo tabInfo = new TabInfo(tag, cls, bundle);
        if (this.d3) {
            Fragment s0 = this.Z2.s0(tag);
            tabInfo.f7993d = s0;
            if (s0 != null && !s0.z0()) {
                FragmentTransaction u = this.Z2.u();
                u.v(tabInfo.f7993d);
                u.q();
            }
        }
        this.s.add(tabInfo);
        addTab(tabSpec);
    }

    @Deprecated
    public void g(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        d(context);
        super.setup();
        this.Y2 = context;
        this.Z2 = fragmentManager;
        c();
    }

    @Deprecated
    public void h(@NonNull Context context, @NonNull FragmentManager fragmentManager, int i2) {
        d(context);
        super.setup();
        this.Y2 = context;
        this.Z2 = fragmentManager;
        this.a3 = i2;
        c();
        this.X2.setId(i2);
        if (getId() == -1) {
            setId(16908306);
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.s.size();
        FragmentTransaction fragmentTransaction = null;
        for (int i2 = 0; i2 < size; i2++) {
            TabInfo tabInfo = this.s.get(i2);
            Fragment s0 = this.Z2.s0(tabInfo.f7990a);
            tabInfo.f7993d = s0;
            if (s0 != null && !s0.z0()) {
                if (tabInfo.f7990a.equals(currentTabTag)) {
                    this.c3 = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.Z2.u();
                    }
                    fragmentTransaction.v(tabInfo.f7993d);
                }
            }
        }
        this.d3 = true;
        FragmentTransaction b2 = b(currentTabTag, fragmentTransaction);
        if (b2 != null) {
            b2.q();
            this.Z2.n0();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d3 = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.s);
    }

    /* access modifiers changed from: protected */
    @NonNull
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.s = getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public void onTabChanged(@Nullable String str) {
        FragmentTransaction b2;
        if (this.d3 && (b2 = b(str, (FragmentTransaction) null)) != null) {
            b2.q();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.b3;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(@Nullable TabHost.OnTabChangeListener onTabChangeListener) {
        this.b3 = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public FragmentTabHost(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        f(context, attributeSet);
    }
}
