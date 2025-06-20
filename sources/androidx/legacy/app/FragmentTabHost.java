package androidx.legacy.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
        private final Context f8101a;

        public DummyTabFactory(Context context) {
            this.f8101a = context;
        }

        public View createTabContent(String str) {
            View view = new View(this.f8101a);
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

        /* renamed from: a  reason: collision with root package name */
        final String f8102a;

        /* renamed from: b  reason: collision with root package name */
        final Class<?> f8103b;

        /* renamed from: c  reason: collision with root package name */
        final Bundle f8104c;

        /* renamed from: d  reason: collision with root package name */
        Fragment f8105d;

        TabInfo(String str, Class<?> cls, Bundle bundle) {
            this.f8102a = str;
            this.f8103b = cls;
            this.f8104c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, (AttributeSet) null);
        e(context, (AttributeSet) null);
    }

    private FragmentTransaction b(String str, FragmentTransaction fragmentTransaction) {
        Fragment fragment;
        TabInfo tabInfo = null;
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            TabInfo tabInfo2 = this.s.get(i2);
            if (tabInfo2.f8102a.equals(str)) {
                tabInfo = tabInfo2;
            }
        }
        if (tabInfo != null) {
            if (this.c3 != tabInfo) {
                if (fragmentTransaction == null) {
                    fragmentTransaction = this.Z2.beginTransaction();
                }
                TabInfo tabInfo3 = this.c3;
                if (!(tabInfo3 == null || (fragment = tabInfo3.f8105d) == null)) {
                    fragmentTransaction.detach(fragment);
                }
                Fragment fragment2 = tabInfo.f8105d;
                if (fragment2 == null) {
                    Fragment instantiate = Fragment.instantiate(this.Y2, tabInfo.f8103b.getName(), tabInfo.f8104c);
                    tabInfo.f8105d = instantiate;
                    fragmentTransaction.add(this.a3, instantiate, tabInfo.f8102a);
                } else {
                    fragmentTransaction.attach(fragment2);
                }
                this.c3 = tabInfo;
            }
            return fragmentTransaction;
        }
        throw new IllegalStateException("No tab known for tag " + str);
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

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.a3 = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void a(TabHost.TabSpec tabSpec, Class<?> cls, Bundle bundle) {
        tabSpec.setContent(new DummyTabFactory(this.Y2));
        String tag = tabSpec.getTag();
        TabInfo tabInfo = new TabInfo(tag, cls, bundle);
        if (this.d3) {
            Fragment findFragmentByTag = this.Z2.findFragmentByTag(tag);
            tabInfo.f8105d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                FragmentTransaction beginTransaction = this.Z2.beginTransaction();
                beginTransaction.detach(tabInfo.f8105d);
                beginTransaction.commit();
            }
        }
        this.s.add(tabInfo);
        addTab(tabSpec);
    }

    @Deprecated
    public void f(Context context, FragmentManager fragmentManager) {
        d(context);
        super.setup();
        this.Y2 = context;
        this.Z2 = fragmentManager;
        c();
    }

    @Deprecated
    public void g(Context context, FragmentManager fragmentManager, int i2) {
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
        FragmentTransaction fragmentTransaction = null;
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            TabInfo tabInfo = this.s.get(i2);
            Fragment findFragmentByTag = this.Z2.findFragmentByTag(tabInfo.f8102a);
            tabInfo.f8105d = findFragmentByTag;
            if (findFragmentByTag != null && !findFragmentByTag.isDetached()) {
                if (tabInfo.f8102a.equals(currentTabTag)) {
                    this.c3 = tabInfo;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.Z2.beginTransaction();
                    }
                    fragmentTransaction.detach(tabInfo.f8105d);
                }
            }
        }
        this.d3 = true;
        FragmentTransaction b2 = b(currentTabTag, fragmentTransaction);
        if (b2 != null) {
            b2.commit();
            this.Z2.executePendingTransactions();
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
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.s);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.s = getCurrentTabTag();
        return savedState;
    }

    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction b2;
        if (this.d3 && (b2 = b(str, (FragmentTransaction) null)) != null) {
            b2.commit();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.b3;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.b3 = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context, attributeSet);
    }
}
