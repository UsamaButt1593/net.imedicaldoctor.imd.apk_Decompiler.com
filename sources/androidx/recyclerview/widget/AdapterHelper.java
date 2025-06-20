package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.OpReorderer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class AdapterHelper implements OpReorderer.Callback {

    /* renamed from: i  reason: collision with root package name */
    static final int f15187i = 0;

    /* renamed from: j  reason: collision with root package name */
    static final int f15188j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f15189k = false;

    /* renamed from: l  reason: collision with root package name */
    private static final String f15190l = "AHT";

    /* renamed from: a  reason: collision with root package name */
    private Pools.Pool<UpdateOp> f15191a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<UpdateOp> f15192b;

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<UpdateOp> f15193c;

    /* renamed from: d  reason: collision with root package name */
    final Callback f15194d;

    /* renamed from: e  reason: collision with root package name */
    Runnable f15195e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f15196f;

    /* renamed from: g  reason: collision with root package name */
    final OpReorderer f15197g;

    /* renamed from: h  reason: collision with root package name */
    private int f15198h;

    interface Callback {
        void a(int i2, int i3);

        void b(UpdateOp updateOp);

        void c(int i2, int i3, Object obj);

        void d(UpdateOp updateOp);

        RecyclerView.ViewHolder e(int i2);

        void f(int i2, int i3);

        void g(int i2, int i3);

        void h(int i2, int i3);
    }

    static final class UpdateOp {

        /* renamed from: e  reason: collision with root package name */
        static final int f15199e = 1;

        /* renamed from: f  reason: collision with root package name */
        static final int f15200f = 2;

        /* renamed from: g  reason: collision with root package name */
        static final int f15201g = 4;

        /* renamed from: h  reason: collision with root package name */
        static final int f15202h = 8;

        /* renamed from: i  reason: collision with root package name */
        static final int f15203i = 30;

        /* renamed from: a  reason: collision with root package name */
        int f15204a;

        /* renamed from: b  reason: collision with root package name */
        int f15205b;

        /* renamed from: c  reason: collision with root package name */
        Object f15206c;

        /* renamed from: d  reason: collision with root package name */
        int f15207d;

        UpdateOp(int i2, int i3, int i4, Object obj) {
            this.f15204a = i2;
            this.f15205b = i3;
            this.f15207d = i4;
            this.f15206c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i2 = this.f15204a;
            if (i2 == 1) {
                return "add";
            }
            if (i2 == 2) {
                return "rm";
            }
            if (i2 != 4) {
                return i2 != 8 ? "??" : "mv";
            }
            return "up";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateOp)) {
                return false;
            }
            UpdateOp updateOp = (UpdateOp) obj;
            int i2 = this.f15204a;
            if (i2 != updateOp.f15204a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f15207d - this.f15205b) == 1 && this.f15207d == updateOp.f15205b && this.f15205b == updateOp.f15207d) {
                return true;
            }
            if (this.f15207d != updateOp.f15207d || this.f15205b != updateOp.f15205b) {
                return false;
            }
            Object obj2 = this.f15206c;
            Object obj3 = updateOp.f15206c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f15204a * 31) + this.f15205b) * 31) + this.f15207d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f15205b + "c:" + this.f15207d + ",p:" + this.f15206c + "]";
        }
    }

    AdapterHelper(Callback callback) {
        this(callback, false);
    }

    private int A(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        for (int size = this.f15193c.size() - 1; size >= 0; size--) {
            UpdateOp updateOp = this.f15193c.get(size);
            int i10 = updateOp.f15204a;
            if (i10 == 8) {
                int i11 = updateOp.f15205b;
                int i12 = updateOp.f15207d;
                if (i11 < i12) {
                    i6 = i11;
                    i5 = i12;
                } else {
                    i5 = i11;
                    i6 = i12;
                }
                if (i2 < i6 || i2 > i5) {
                    if (i2 < i11) {
                        if (i3 == 1) {
                            updateOp.f15205b = i11 + 1;
                            i7 = i12 + 1;
                        } else if (i3 == 2) {
                            updateOp.f15205b = i11 - 1;
                            i7 = i12 - 1;
                        }
                        updateOp.f15207d = i7;
                    }
                } else if (i6 == i11) {
                    if (i3 == 1) {
                        i9 = i12 + 1;
                    } else {
                        if (i3 == 2) {
                            i9 = i12 - 1;
                        }
                        i2++;
                    }
                    updateOp.f15207d = i9;
                    i2++;
                } else {
                    if (i3 == 1) {
                        i8 = i11 + 1;
                    } else {
                        if (i3 == 2) {
                            i8 = i11 - 1;
                        }
                        i2--;
                    }
                    updateOp.f15205b = i8;
                    i2--;
                }
            } else {
                int i13 = updateOp.f15205b;
                if (i13 > i2) {
                    if (i3 == 1) {
                        i4 = i13 + 1;
                    } else if (i3 == 2) {
                        i4 = i13 - 1;
                    }
                    updateOp.f15205b = i4;
                } else if (i10 == 1) {
                    i2 -= updateOp.f15207d;
                } else if (i10 == 2) {
                    i2 += updateOp.f15207d;
                }
            }
        }
        for (int size2 = this.f15193c.size() - 1; size2 >= 0; size2--) {
            UpdateOp updateOp2 = this.f15193c.get(size2);
            if (updateOp2.f15204a == 8) {
                int i14 = updateOp2.f15207d;
                if (i14 != updateOp2.f15205b && i14 >= 0) {
                }
            } else if (updateOp2.f15207d > 0) {
            }
            this.f15193c.remove(size2);
            a(updateOp2);
        }
        return i2;
    }

    private void d(UpdateOp updateOp) {
        w(updateOp);
    }

    private void e(UpdateOp updateOp) {
        w(updateOp);
    }

    private void g(UpdateOp updateOp) {
        char c2;
        boolean z;
        boolean z2;
        int i2 = updateOp.f15205b;
        int i3 = updateOp.f15207d + i2;
        char c3 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f15194d.e(i4) != null || i(i4)) {
                if (c3 == 0) {
                    l(b(2, i2, i5, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    w(b(2, i2, i5, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != updateOp.f15207d) {
            a(updateOp);
            updateOp = b(2, i2, i5, (Object) null);
        }
        if (c3 == 0) {
            l(updateOp);
        } else {
            w(updateOp);
        }
    }

    private void h(UpdateOp updateOp) {
        int i2 = updateOp.f15205b;
        int i3 = updateOp.f15207d + i2;
        int i4 = i2;
        char c2 = 65535;
        int i5 = 0;
        while (i2 < i3) {
            if (this.f15194d.e(i2) != null || i(i2)) {
                if (c2 == 0) {
                    l(b(4, i4, i5, updateOp.f15206c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    w(b(4, i4, i5, updateOp.f15206c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != updateOp.f15207d) {
            Object obj = updateOp.f15206c;
            a(updateOp);
            updateOp = b(4, i4, i5, obj);
        }
        if (c2 == 0) {
            l(updateOp);
        } else {
            w(updateOp);
        }
    }

    private boolean i(int i2) {
        int size = this.f15193c.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.f15193c.get(i3);
            int i4 = updateOp.f15204a;
            if (i4 == 8) {
                if (o(updateOp.f15207d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = updateOp.f15205b;
                int i6 = updateOp.f15207d + i5;
                while (i5 < i6) {
                    if (o(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void l(UpdateOp updateOp) {
        int i2;
        int i3 = updateOp.f15204a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int A = A(updateOp.f15205b, i3);
        int i4 = updateOp.f15205b;
        int i5 = updateOp.f15204a;
        if (i5 == 2) {
            i2 = 0;
        } else if (i5 == 4) {
            i2 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + updateOp);
        }
        int i6 = 1;
        for (int i7 = 1; i7 < updateOp.f15207d; i7++) {
            int A2 = A(updateOp.f15205b + (i2 * i7), updateOp.f15204a);
            int i8 = updateOp.f15204a;
            if (i8 == 2 ? A2 != A : !(i8 == 4 && A2 == A + 1)) {
                UpdateOp b2 = b(i8, A, i6, updateOp.f15206c);
                m(b2, i4);
                a(b2);
                if (updateOp.f15204a == 4) {
                    i4 += i6;
                }
                A = A2;
                i6 = 1;
            } else {
                i6++;
            }
        }
        Object obj = updateOp.f15206c;
        a(updateOp);
        if (i6 > 0) {
            UpdateOp b3 = b(updateOp.f15204a, A, i6, obj);
            m(b3, i4);
            a(b3);
        }
    }

    private void w(UpdateOp updateOp) {
        this.f15193c.add(updateOp);
        int i2 = updateOp.f15204a;
        if (i2 == 1) {
            this.f15194d.g(updateOp.f15205b, updateOp.f15207d);
        } else if (i2 == 2) {
            this.f15194d.f(updateOp.f15205b, updateOp.f15207d);
        } else if (i2 == 4) {
            this.f15194d.c(updateOp.f15205b, updateOp.f15207d, updateOp.f15206c);
        } else if (i2 == 8) {
            this.f15194d.a(updateOp.f15205b, updateOp.f15207d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + updateOp);
        }
    }

    public void a(UpdateOp updateOp) {
        if (!this.f15196f) {
            updateOp.f15206c = null;
            this.f15191a.c(updateOp);
        }
    }

    public UpdateOp b(int i2, int i3, int i4, Object obj) {
        UpdateOp b2 = this.f15191a.b();
        if (b2 == null) {
            return new UpdateOp(i2, i3, i4, obj);
        }
        b2.f15204a = i2;
        b2.f15205b = i3;
        b2.f15207d = i4;
        b2.f15206c = obj;
        return b2;
    }

    /* access modifiers changed from: package-private */
    public AdapterHelper c(UpdateOp... updateOpArr) {
        Collections.addAll(this.f15192b, updateOpArr);
        return this;
    }

    public int f(int i2) {
        int size = this.f15192b.size();
        for (int i3 = 0; i3 < size; i3++) {
            UpdateOp updateOp = this.f15192b.get(i3);
            int i4 = updateOp.f15204a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = updateOp.f15205b;
                    if (i5 <= i2) {
                        int i6 = updateOp.f15207d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = updateOp.f15205b;
                    if (i7 == i2) {
                        i2 = updateOp.f15207d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (updateOp.f15207d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (updateOp.f15205b <= i2) {
                i2 += updateOp.f15207d;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        int size = this.f15193c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f15194d.d(this.f15193c.get(i2));
        }
        y(this.f15193c);
        this.f15198h = 0;
    }

    /* access modifiers changed from: package-private */
    public void k() {
        j();
        int size = this.f15192b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f15192b.get(i2);
            int i3 = updateOp.f15204a;
            if (i3 == 1) {
                this.f15194d.d(updateOp);
                this.f15194d.g(updateOp.f15205b, updateOp.f15207d);
            } else if (i3 == 2) {
                this.f15194d.d(updateOp);
                this.f15194d.h(updateOp.f15205b, updateOp.f15207d);
            } else if (i3 == 4) {
                this.f15194d.d(updateOp);
                this.f15194d.c(updateOp.f15205b, updateOp.f15207d, updateOp.f15206c);
            } else if (i3 == 8) {
                this.f15194d.d(updateOp);
                this.f15194d.a(updateOp.f15205b, updateOp.f15207d);
            }
            Runnable runnable = this.f15195e;
            if (runnable != null) {
                runnable.run();
            }
        }
        y(this.f15192b);
        this.f15198h = 0;
    }

    /* access modifiers changed from: package-private */
    public void m(UpdateOp updateOp, int i2) {
        this.f15194d.b(updateOp);
        int i3 = updateOp.f15204a;
        if (i3 == 2) {
            this.f15194d.h(i2, updateOp.f15207d);
        } else if (i3 == 4) {
            this.f15194d.c(i2, updateOp.f15207d, updateOp.f15206c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    public int n(int i2) {
        return o(i2, 0);
    }

    /* access modifiers changed from: package-private */
    public int o(int i2, int i3) {
        int size = this.f15193c.size();
        while (i3 < size) {
            UpdateOp updateOp = this.f15193c.get(i3);
            int i4 = updateOp.f15204a;
            if (i4 == 8) {
                int i5 = updateOp.f15205b;
                if (i5 == i2) {
                    i2 = updateOp.f15207d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (updateOp.f15207d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = updateOp.f15205b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = updateOp.f15207d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += updateOp.f15207d;
                }
            }
            i3++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean p(int i2) {
        return (i2 & this.f15198h) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.f15192b.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return !this.f15193c.isEmpty() && !this.f15192b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean s(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f15192b.add(b(4, i2, i3, obj));
        this.f15198h |= 4;
        return this.f15192b.size() == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean t(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f15192b.add(b(1, i2, i3, (Object) null));
        this.f15198h |= 1;
        return this.f15192b.size() == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean u(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f15192b.add(b(8, i2, i3, (Object) null));
            this.f15198h |= 8;
            return this.f15192b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    public boolean v(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f15192b.add(b(2, i2, i3, (Object) null));
        this.f15198h |= 2;
        return this.f15192b.size() == 1;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        this.f15197g.b(this.f15192b);
        int size = this.f15192b.size();
        for (int i2 = 0; i2 < size; i2++) {
            UpdateOp updateOp = this.f15192b.get(i2);
            int i3 = updateOp.f15204a;
            if (i3 == 1) {
                d(updateOp);
            } else if (i3 == 2) {
                g(updateOp);
            } else if (i3 == 4) {
                h(updateOp);
            } else if (i3 == 8) {
                e(updateOp);
            }
            Runnable runnable = this.f15195e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f15192b.clear();
    }

    /* access modifiers changed from: package-private */
    public void y(List<UpdateOp> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    public void z() {
        y(this.f15192b);
        y(this.f15193c);
        this.f15198h = 0;
    }

    AdapterHelper(Callback callback, boolean z) {
        this.f15191a = new Pools.SimplePool(30);
        this.f15192b = new ArrayList<>();
        this.f15193c = new ArrayList<>();
        this.f15198h = 0;
        this.f15194d = callback;
        this.f15196f = z;
        this.f15197g = new OpReorderer(this);
    }
}
