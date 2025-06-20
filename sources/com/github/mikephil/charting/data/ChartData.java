package com.github.mikephil.charting.data;

import android.graphics.Typeface;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.ArrayList;
import java.util.List;

public abstract class ChartData<T extends IDataSet<? extends Entry>> {

    /* renamed from: a  reason: collision with root package name */
    protected float f18980a;

    /* renamed from: b  reason: collision with root package name */
    protected float f18981b;

    /* renamed from: c  reason: collision with root package name */
    protected float f18982c;

    /* renamed from: d  reason: collision with root package name */
    protected float f18983d;

    /* renamed from: e  reason: collision with root package name */
    protected float f18984e;

    /* renamed from: f  reason: collision with root package name */
    protected float f18985f;

    /* renamed from: g  reason: collision with root package name */
    protected float f18986g;

    /* renamed from: h  reason: collision with root package name */
    protected float f18987h;

    /* renamed from: i  reason: collision with root package name */
    protected List<T> f18988i;

    public ChartData() {
        this.f18980a = -3.4028235E38f;
        this.f18981b = Float.MAX_VALUE;
        this.f18982c = -3.4028235E38f;
        this.f18983d = Float.MAX_VALUE;
        this.f18984e = -3.4028235E38f;
        this.f18985f = Float.MAX_VALUE;
        this.f18986g = -3.4028235E38f;
        this.f18987h = Float.MAX_VALUE;
        this.f18988i = new ArrayList();
    }

    private List<T> c(T[] tArr) {
        ArrayList arrayList = new ArrayList();
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public float A(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f2 = this.f18984e;
            return f2 == -3.4028235E38f ? this.f18986g : f2;
        }
        float f3 = this.f18986g;
        return f3 == -3.4028235E38f ? this.f18984e : f3;
    }

    public float B() {
        return this.f18981b;
    }

    public float C(YAxis.AxisDependency axisDependency) {
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            float f2 = this.f18985f;
            return f2 == Float.MAX_VALUE ? this.f18987h : f2;
        }
        float f3 = this.f18987h;
        return f3 == Float.MAX_VALUE ? this.f18985f : f3;
    }

    public boolean D() {
        for (T i1 : this.f18988i) {
            if (!i1.i1()) {
                return false;
            }
        }
        return true;
    }

    public void E() {
        d();
    }

    public boolean F(int i2) {
        if (i2 >= this.f18988i.size() || i2 < 0) {
            return false;
        }
        return G((IDataSet) this.f18988i.get(i2));
    }

    public boolean G(T t) {
        if (t == null) {
            return false;
        }
        boolean remove = this.f18988i.remove(t);
        if (remove) {
            d();
        }
        return remove;
    }

    public boolean H(float f2, int i2) {
        Entry x;
        if (i2 < this.f18988i.size() && (x = ((IDataSet) this.f18988i.get(i2)).x(f2, Float.NaN)) != null) {
            return I(x, i2);
        }
        return false;
    }

    public boolean I(Entry entry, int i2) {
        IDataSet iDataSet;
        if (entry == null || i2 >= this.f18988i.size() || (iDataSet = (IDataSet) this.f18988i.get(i2)) == null) {
            return false;
        }
        boolean n0 = iDataSet.n0(entry);
        if (n0) {
            d();
        }
        return n0;
    }

    public void J(boolean z) {
        for (T c1 : this.f18988i) {
            c1.c1(z);
        }
    }

    public void K(boolean z) {
        for (T b2 : this.f18988i) {
            b2.b(z);
        }
    }

    public void L(ValueFormatter valueFormatter) {
        if (valueFormatter != null) {
            for (T s0 : this.f18988i) {
                s0.s0(valueFormatter);
            }
        }
    }

    public void M(int i2) {
        for (T P : this.f18988i) {
            P.P(i2);
        }
    }

    public void N(List<Integer> list) {
        for (T G0 : this.f18988i) {
            G0.G0(list);
        }
    }

    public void O(float f2) {
        for (T z0 : this.f18988i) {
            z0.z0(f2);
        }
    }

    public void P(Typeface typeface) {
        for (T D : this.f18988i) {
            D.D(typeface);
        }
    }

    public void a(T t) {
        if (t != null) {
            f(t);
            this.f18988i.add(t);
        }
    }

    public void b(Entry entry, int i2) {
        if (this.f18988i.size() <= i2 || i2 < 0) {
            Log.e("addEntry", "Cannot add Entry because dataSetIndex too high or too low.");
            return;
        }
        IDataSet iDataSet = (IDataSet) this.f18988i.get(i2);
        if (iDataSet.r0(entry)) {
            e(entry, iDataSet.a1());
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        List<T> list = this.f18988i;
        if (list != null) {
            this.f18980a = -3.4028235E38f;
            this.f18981b = Float.MAX_VALUE;
            this.f18982c = -3.4028235E38f;
            this.f18983d = Float.MAX_VALUE;
            for (T f2 : list) {
                f(f2);
            }
            this.f18984e = -3.4028235E38f;
            this.f18985f = Float.MAX_VALUE;
            this.f18986g = -3.4028235E38f;
            this.f18987h = Float.MAX_VALUE;
            IDataSet t = t(this.f18988i);
            if (t != null) {
                this.f18984e = t.p();
                this.f18985f = t.J();
                for (T t2 : this.f18988i) {
                    if (t2.a1() == YAxis.AxisDependency.LEFT) {
                        if (t2.J() < this.f18985f) {
                            this.f18985f = t2.J();
                        }
                        if (t2.p() > this.f18984e) {
                            this.f18984e = t2.p();
                        }
                    }
                }
            }
            IDataSet u = u(this.f18988i);
            if (u != null) {
                this.f18986g = u.p();
                this.f18987h = u.J();
                for (T t3 : this.f18988i) {
                    if (t3.a1() == YAxis.AxisDependency.RIGHT) {
                        if (t3.J() < this.f18987h) {
                            this.f18987h = t3.J();
                        }
                        if (t3.p() > this.f18986g) {
                            this.f18986g = t3.p();
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e(Entry entry, YAxis.AxisDependency axisDependency) {
        if (this.f18980a < entry.c()) {
            this.f18980a = entry.c();
        }
        if (this.f18981b > entry.c()) {
            this.f18981b = entry.c();
        }
        if (this.f18982c < entry.m()) {
            this.f18982c = entry.m();
        }
        if (this.f18983d > entry.m()) {
            this.f18983d = entry.m();
        }
        if (axisDependency == YAxis.AxisDependency.LEFT) {
            if (this.f18984e < entry.c()) {
                this.f18984e = entry.c();
            }
            if (this.f18985f > entry.c()) {
                this.f18985f = entry.c();
                return;
            }
            return;
        }
        if (this.f18986g < entry.c()) {
            this.f18986g = entry.c();
        }
        if (this.f18987h > entry.c()) {
            this.f18987h = entry.c();
        }
    }

    /* access modifiers changed from: protected */
    public void f(T t) {
        if (this.f18980a < t.p()) {
            this.f18980a = t.p();
        }
        if (this.f18981b > t.J()) {
            this.f18981b = t.J();
        }
        if (this.f18982c < t.R0()) {
            this.f18982c = t.R0();
        }
        if (this.f18983d > t.n()) {
            this.f18983d = t.n();
        }
        if (t.a1() == YAxis.AxisDependency.LEFT) {
            if (this.f18984e < t.p()) {
                this.f18984e = t.p();
            }
            if (this.f18985f > t.J()) {
                this.f18985f = t.J();
                return;
            }
            return;
        }
        if (this.f18986g < t.p()) {
            this.f18986g = t.p();
        }
        if (this.f18987h > t.J()) {
            this.f18987h = t.J();
        }
    }

    public void g(float f2, float f3) {
        for (T E0 : this.f18988i) {
            E0.E0(f2, f3);
        }
        d();
    }

    public void h() {
        List<T> list = this.f18988i;
        if (list != null) {
            list.clear();
        }
        E();
    }

    public boolean i(T t) {
        for (T equals : this.f18988i) {
            if (equals.equals(t)) {
                return true;
            }
        }
        return false;
    }

    public int[] j() {
        if (this.f18988i == null) {
            return null;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f18988i.size(); i3++) {
            i2 += ((IDataSet) this.f18988i.get(i3)).B0().size();
        }
        int[] iArr = new int[i2];
        int i4 = 0;
        for (int i5 = 0; i5 < this.f18988i.size(); i5++) {
            for (Integer intValue : ((IDataSet) this.f18988i.get(i5)).B0()) {
                iArr[i4] = intValue.intValue();
                i4++;
            }
        }
        return iArr;
    }

    public T k(int i2) {
        List<T> list = this.f18988i;
        if (list == null || i2 < 0 || i2 >= list.size()) {
            return null;
        }
        return (IDataSet) this.f18988i.get(i2);
    }

    public T l(String str, boolean z) {
        int o = o(this.f18988i, str, z);
        if (o < 0 || o >= this.f18988i.size()) {
            return null;
        }
        return (IDataSet) this.f18988i.get(o);
    }

    public int m() {
        List<T> list = this.f18988i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public T n(Entry entry) {
        if (entry == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.f18988i.size(); i2++) {
            T t = (IDataSet) this.f18988i.get(i2);
            for (int i3 = 0; i3 < t.e1(); i3++) {
                if (entry.l(t.x(entry.m(), entry.c()))) {
                    return t;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public int o(List<T> list, String str, boolean z) {
        int i2 = 0;
        if (z) {
            while (i2 < list.size()) {
                if (str.equalsIgnoreCase(((IDataSet) list.get(i2)).H())) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < list.size()) {
            if (str.equals(((IDataSet) list.get(i2)).H())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public String[] p() {
        String[] strArr = new String[this.f18988i.size()];
        for (int i2 = 0; i2 < this.f18988i.size(); i2++) {
            strArr[i2] = ((IDataSet) this.f18988i.get(i2)).H();
        }
        return strArr;
    }

    public List<T> q() {
        return this.f18988i;
    }

    public int r() {
        int i2 = 0;
        for (T e1 : this.f18988i) {
            i2 += e1.e1();
        }
        return i2;
    }

    public Entry s(Highlight highlight) {
        if (highlight.d() >= this.f18988i.size()) {
            return null;
        }
        return ((IDataSet) this.f18988i.get(highlight.d())).x(highlight.h(), highlight.j());
    }

    /* access modifiers changed from: protected */
    public T t(List<T> list) {
        for (T t : list) {
            if (t.a1() == YAxis.AxisDependency.LEFT) {
                return t;
            }
        }
        return null;
    }

    public T u(List<T> list) {
        for (T t : list) {
            if (t.a1() == YAxis.AxisDependency.RIGHT) {
                return t;
            }
        }
        return null;
    }

    public int v(T t) {
        return this.f18988i.indexOf(t);
    }

    public T w() {
        List<T> list = this.f18988i;
        if (list == null || list.isEmpty()) {
            return null;
        }
        T t = (IDataSet) this.f18988i.get(0);
        for (T t2 : this.f18988i) {
            if (t2.e1() > t.e1()) {
                t = t2;
            }
        }
        return t;
    }

    public float x() {
        return this.f18982c;
    }

    public float y() {
        return this.f18983d;
    }

    public float z() {
        return this.f18980a;
    }

    public ChartData(List<T> list) {
        this.f18980a = -3.4028235E38f;
        this.f18981b = Float.MAX_VALUE;
        this.f18982c = -3.4028235E38f;
        this.f18983d = Float.MAX_VALUE;
        this.f18984e = -3.4028235E38f;
        this.f18985f = Float.MAX_VALUE;
        this.f18986g = -3.4028235E38f;
        this.f18987h = Float.MAX_VALUE;
        this.f18988i = list;
        E();
    }

    public ChartData(T... tArr) {
        this.f18980a = -3.4028235E38f;
        this.f18981b = Float.MAX_VALUE;
        this.f18982c = -3.4028235E38f;
        this.f18983d = Float.MAX_VALUE;
        this.f18984e = -3.4028235E38f;
        this.f18985f = Float.MAX_VALUE;
        this.f18986g = -3.4028235E38f;
        this.f18987h = Float.MAX_VALUE;
        this.f18988i = c(tArr);
        E();
    }
}
