package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.dd.plist.ASCIIPropertyListParser;

class LayoutState {

    /* renamed from: j  reason: collision with root package name */
    static final int f15390j = -1;

    /* renamed from: k  reason: collision with root package name */
    static final int f15391k = 1;

    /* renamed from: l  reason: collision with root package name */
    static final int f15392l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    static final int f15393m = -1;

    /* renamed from: n  reason: collision with root package name */
    static final int f15394n = 1;

    /* renamed from: a  reason: collision with root package name */
    boolean f15395a = true;

    /* renamed from: b  reason: collision with root package name */
    int f15396b;

    /* renamed from: c  reason: collision with root package name */
    int f15397c;

    /* renamed from: d  reason: collision with root package name */
    int f15398d;

    /* renamed from: e  reason: collision with root package name */
    int f15399e;

    /* renamed from: f  reason: collision with root package name */
    int f15400f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f15401g = 0;

    /* renamed from: h  reason: collision with root package name */
    boolean f15402h;

    /* renamed from: i  reason: collision with root package name */
    boolean f15403i;

    LayoutState() {
    }

    /* access modifiers changed from: package-private */
    public boolean a(RecyclerView.State state) {
        int i2 = this.f15397c;
        return i2 >= 0 && i2 < state.d();
    }

    /* access modifiers changed from: package-private */
    public View b(RecyclerView.Recycler recycler) {
        View p = recycler.p(this.f15397c);
        this.f15397c += this.f15398d;
        return p;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f15396b + ", mCurrentPosition=" + this.f15397c + ", mItemDirection=" + this.f15398d + ", mLayoutDirection=" + this.f15399e + ", mStartLine=" + this.f15400f + ", mEndLine=" + this.f15401g + ASCIIPropertyListParser.f18653k;
    }
}
