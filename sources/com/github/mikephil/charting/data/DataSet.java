package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> s;
    protected float t = -3.4028235E38f;
    protected float u = Float.MAX_VALUE;
    protected float v = -3.4028235E38f;
    protected float w = Float.MAX_VALUE;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.s = list;
        if (list == null) {
            this.s = new ArrayList();
        }
        K0();
    }

    public void E0(float f2, float f3) {
        List<T> list = this.s;
        if (list != null && !list.isEmpty()) {
            this.t = -3.4028235E38f;
            this.u = Float.MAX_VALUE;
            int o0 = o0(f3, Float.NaN, Rounding.UP);
            for (int o02 = o0(f2, Float.NaN, Rounding.DOWN); o02 <= o0; o02++) {
                M1((Entry) this.s.get(o02));
            }
        }
    }

    public float J() {
        return this.u;
    }

    public List<T> J0(float f2) {
        ArrayList arrayList = new ArrayList();
        int size = this.s.size() - 1;
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            }
            int i3 = (size + i2) / 2;
            Entry entry = (Entry) this.s.get(i3);
            if (f2 == entry.m()) {
                while (i3 > 0 && ((Entry) this.s.get(i3 - 1)).m() == f2) {
                    i3--;
                }
                int size2 = this.s.size();
                while (i3 < size2) {
                    Entry entry2 = (Entry) this.s.get(i3);
                    if (entry2.m() != f2) {
                        break;
                    }
                    arrayList.add(entry2);
                    i3++;
                }
            } else if (f2 > entry.m()) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        return arrayList;
    }

    public void K0() {
        List<T> list = this.s;
        if (list != null && !list.isEmpty()) {
            this.t = -3.4028235E38f;
            this.u = Float.MAX_VALUE;
            this.v = -3.4028235E38f;
            this.w = Float.MAX_VALUE;
            for (T K1 : this.s) {
                K1(K1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void K1(T t2) {
        if (t2 != null) {
            L1(t2);
            M1(t2);
        }
    }

    /* access modifiers changed from: protected */
    public void L1(T t2) {
        if (t2.m() < this.w) {
            this.w = t2.m();
        }
        if (t2.m() > this.v) {
            this.v = t2.m();
        }
    }

    /* access modifiers changed from: protected */
    public void M1(T t2) {
        if (t2.c() < this.u) {
            this.u = t2.c();
        }
        if (t2.c() > this.t) {
            this.t = t2.c();
        }
    }

    public abstract DataSet<T> N1();

    /* access modifiers changed from: protected */
    public void O1(DataSet dataSet) {
        super.u1(dataSet);
    }

    public List<T> P1() {
        return this.s;
    }

    public void Q1(List<T> list) {
        this.s = list;
        w1();
    }

    public float R0() {
        return this.v;
    }

    public String R1() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(H() == null ? "" : H());
        sb.append(", entries: ");
        sb.append(this.s.size());
        sb.append(StringUtils.LF);
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public T X(int i2) {
        return (Entry) this.s.get(i2);
    }

    public void clear() {
        this.s.clear();
        w1();
    }

    public int e1() {
        return this.s.size();
    }

    public void l1(T t2) {
        if (t2 != null) {
            if (this.s == null) {
                this.s = new ArrayList();
            }
            K1(t2);
            if (this.s.size() > 0) {
                List<T> list = this.s;
                if (((Entry) list.get(list.size() - 1)).m() > t2.m()) {
                    this.s.add(o0(t2.m(), t2.c(), Rounding.UP), t2);
                    return;
                }
            }
            this.s.add(t2);
        }
    }

    public float n() {
        return this.w;
    }

    public boolean n0(T t2) {
        List<T> list;
        if (t2 == null || (list = this.s) == null) {
            return false;
        }
        boolean remove = list.remove(t2);
        if (remove) {
            K0();
        }
        return remove;
    }

    public int o0(float f2, float f3, Rounding rounding) {
        int i2;
        Entry entry;
        List<T> list = this.s;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = this.s.size() - 1;
        int i3 = 0;
        while (i3 < size) {
            int i4 = (i3 + size) / 2;
            float m2 = ((Entry) this.s.get(i4)).m() - f2;
            int i5 = i4 + 1;
            float abs = Math.abs(m2);
            float abs2 = Math.abs(((Entry) this.s.get(i5)).m() - f2);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d2 = (double) m2;
                    if (d2 < 0.0d) {
                        if (d2 >= 0.0d) {
                        }
                    }
                }
                size = i4;
            }
            i3 = i5;
        }
        if (size == -1) {
            return size;
        }
        float m3 = ((Entry) this.s.get(size)).m();
        if (rounding == Rounding.UP) {
            if (m3 < f2 && size < this.s.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && m3 > f2 && size > 0) {
            size--;
        }
        if (Float.isNaN(f3)) {
            return size;
        }
        while (size > 0 && ((Entry) this.s.get(size - 1)).m() == m3) {
            size--;
        }
        float c2 = ((Entry) this.s.get(size)).c();
        loop2:
        while (true) {
            i2 = size;
            do {
                size++;
                if (size >= this.s.size()) {
                    break loop2;
                }
                entry = (Entry) this.s.get(size);
                if (entry.m() != m3) {
                    break loop2;
                }
            } while (Math.abs(entry.c() - f3) >= Math.abs(c2 - f3));
            c2 = f3;
        }
        return i2;
    }

    public float p() {
        return this.t;
    }

    public boolean r0(T t2) {
        if (t2 == null) {
            return false;
        }
        List P1 = P1();
        if (P1 == null) {
            P1 = new ArrayList();
        }
        K1(t2);
        return P1.add(t2);
    }

    public int s(Entry entry) {
        return this.s.indexOf(entry);
    }

    public T t0(float f2, float f3, Rounding rounding) {
        int o0 = o0(f2, f3, rounding);
        if (o0 > -1) {
            return (Entry) this.s.get(o0);
        }
        return null;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(R1());
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            stringBuffer.append(((Entry) this.s.get(i2)).toString() + StringUtils.SPACE);
        }
        return stringBuffer.toString();
    }

    public T x(float f2, float f3) {
        return t0(f2, f3, Rounding.CLOSEST);
    }
}
