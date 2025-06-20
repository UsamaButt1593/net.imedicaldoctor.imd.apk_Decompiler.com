package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

public class TransitionSet extends Transition {
    private static final int a4 = 1;
    private static final int b4 = 2;
    private static final int c4 = 4;
    private static final int d4 = 8;
    public static final int e4 = 0;
    public static final int f4 = 1;
    ArrayList<Transition> V3 = new ArrayList<>();
    private boolean W3 = true;
    int X3;
    boolean Y3 = false;
    private int Z3 = 0;

    static class TransitionSetListener extends TransitionListenerAdapter {
        TransitionSet s;

        TransitionSetListener(TransitionSet transitionSet) {
            this.s = transitionSet;
        }

        public void b(@NonNull Transition transition) {
            TransitionSet transitionSet = this.s;
            if (!transitionSet.Y3) {
                transitionSet.z1();
                this.s.Y3 = true;
            }
        }

        public void k(@NonNull Transition transition) {
            TransitionSet transitionSet = this.s;
            int i2 = transitionSet.X3 - 1;
            transitionSet.X3 = i2;
            if (i2 == 0) {
                transitionSet.Y3 = false;
                transitionSet.x();
            }
            transition.S0(this);
        }
    }

    public TransitionSet() {
    }

    private void S1(@NonNull Transition transition) {
        this.V3.add(transition);
        transition.k3 = this;
    }

    private int b2(long j2) {
        for (int i2 = 1; i2 < this.V3.size(); i2++) {
            if (this.V3.get(i2).E3 > j2) {
                return i2 - 1;
            }
        }
        return this.V3.size() - 1;
    }

    private void r2() {
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it2 = this.V3.iterator();
        while (it2.hasNext()) {
            it2.next().c(transitionSetListener);
        }
        this.X3 = this.V3.size();
    }

    /* access modifiers changed from: package-private */
    public String A1(String str) {
        String A1 = super.A1(str);
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(A1);
            sb.append(StringUtils.LF);
            sb.append(this.V3.get(i2).A1(str + "  "));
            A1 = sb.toString();
        }
        return A1;
    }

    @NonNull
    /* renamed from: C1 */
    public TransitionSet c(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.c(transitionListener);
    }

    @NonNull
    /* renamed from: D1 */
    public TransitionSet d(@IdRes int i2) {
        for (int i3 = 0; i3 < this.V3.size(); i3++) {
            this.V3.get(i3).d(i2);
        }
        return (TransitionSet) super.d(i2);
    }

    @NonNull
    public Transition E(int i2, boolean z) {
        for (int i3 = 0; i3 < this.V3.size(); i3++) {
            this.V3.get(i3).E(i2, z);
        }
        return super.E(i2, z);
    }

    @NonNull
    public Transition F(@NonNull View view, boolean z) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).F(view, z);
        }
        return super.F(view, z);
    }

    @NonNull
    /* renamed from: F1 */
    public TransitionSet e(@NonNull View view) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).e(view);
        }
        return (TransitionSet) super.e(view);
    }

    @NonNull
    public Transition G(@NonNull Class<?> cls, boolean z) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).G(cls, z);
        }
        return super.G(cls, z);
    }

    @NonNull
    /* renamed from: H1 */
    public TransitionSet f(@NonNull Class<?> cls) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).f(cls);
        }
        return (TransitionSet) super.f(cls);
    }

    @NonNull
    public Transition J(@NonNull String str, boolean z) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).J(str, z);
        }
        return super.J(str, z);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void M(ViewGroup viewGroup) {
        super.M(viewGroup);
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.V3.get(i2).M(viewGroup);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void M0(@Nullable View view) {
        super.M0(view);
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.V3.get(i2).M0(view);
        }
    }

    @NonNull
    /* renamed from: O1 */
    public TransitionSet g(@NonNull String str) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).g(str);
        }
        return (TransitionSet) super.g(str);
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    public void R0() {
        this.C3 = 0;
        AnonymousClass2 r0 = new TransitionListenerAdapter() {
            public void p(@NonNull Transition transition) {
                TransitionSet.this.V3.remove(transition);
                if (!TransitionSet.this.t0()) {
                    TransitionSet.this.K0(Transition.TransitionNotification.f16077c, false);
                    TransitionSet transitionSet = TransitionSet.this;
                    transitionSet.u3 = true;
                    transitionSet.K0(Transition.TransitionNotification.f16076b, false);
                }
            }
        };
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            Transition transition = this.V3.get(i2);
            transition.c(r0);
            transition.R0();
            long q0 = transition.q0();
            if (this.W3) {
                this.C3 = Math.max(this.C3, q0);
            } else {
                long j2 = this.C3;
                transition.E3 = j2;
                this.C3 = j2 + q0;
            }
        }
    }

    @NonNull
    public TransitionSet R1(@NonNull Transition transition) {
        S1(transition);
        long j2 = this.Y;
        if (j2 >= 0) {
            transition.k1(j2);
        }
        if ((this.Z3 & 1) != 0) {
            transition.r1(V());
        }
        if ((this.Z3 & 2) != 0) {
            transition.w1(c0());
        }
        if ((this.Z3 & 4) != 0) {
            transition.u1(b0());
        }
        if ((this.Z3 & 8) != 0) {
            transition.l1(U());
        }
        return this;
    }

    public int T1() {
        return this.W3 ^ true ? 1 : 0;
    }

    @Nullable
    public Transition U1(int i2) {
        if (i2 < 0 || i2 >= this.V3.size()) {
            return null;
        }
        return this.V3.get(i2);
    }

    public int a2() {
        return this.V3.size();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        super.cancel();
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.V3.get(i2).cancel();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void d1(@Nullable View view) {
        super.d1(view);
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.V3.get(i2).d1(view);
        }
    }

    @NonNull
    /* renamed from: d2 */
    public TransitionSet S0(@NonNull Transition.TransitionListener transitionListener) {
        return (TransitionSet) super.S0(transitionListener);
    }

    @NonNull
    /* renamed from: e2 */
    public TransitionSet W0(@IdRes int i2) {
        for (int i3 = 0; i3 < this.V3.size(); i3++) {
            this.V3.get(i3).W0(i2);
        }
        return (TransitionSet) super.W0(i2);
    }

    @NonNull
    /* renamed from: f2 */
    public TransitionSet Y0(@NonNull View view) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).Y0(view);
        }
        return (TransitionSet) super.Y0(view);
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void g1() {
        if (this.V3.isEmpty()) {
            z1();
            x();
            return;
        }
        r2();
        if (!this.W3) {
            for (int i2 = 1; i2 < this.V3.size(); i2++) {
                final Transition transition = this.V3.get(i2);
                this.V3.get(i2 - 1).c(new TransitionListenerAdapter() {
                    public void k(@NonNull Transition transition) {
                        transition.g1();
                        transition.S0(this);
                    }
                });
            }
            Transition transition2 = this.V3.get(0);
            if (transition2 != null) {
                transition2.g1();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.V3.iterator();
        while (it2.hasNext()) {
            it2.next().g1();
        }
    }

    @NonNull
    /* renamed from: g2 */
    public TransitionSet b1(@NonNull Class<?> cls) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).b1(cls);
        }
        return (TransitionSet) super.b1(cls);
    }

    /* access modifiers changed from: package-private */
    public void h1(boolean z) {
        super.h1(z);
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.V3.get(i2).h1(z);
        }
    }

    @NonNull
    /* renamed from: i2 */
    public TransitionSet c1(@NonNull String str) {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            this.V3.get(i2).c1(str);
        }
        return (TransitionSet) super.c1(str);
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    public void j1(long j2, long j3) {
        long j4 = j2;
        long j5 = j3;
        long q0 = q0();
        long j6 = 0;
        if (this.k3 != null) {
            if (j4 < 0 && j5 < 0) {
                return;
            }
            if (j4 > q0 && j5 > q0) {
                return;
            }
        }
        int i2 = (j4 > j5 ? 1 : (j4 == j5 ? 0 : -1));
        boolean z = i2 < 0;
        int i3 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if ((i3 >= 0 && j5 < 0) || (j4 <= q0 && j5 > q0)) {
            this.u3 = false;
            K0(Transition.TransitionNotification.f16075a, z);
        }
        if (this.W3) {
            for (int i4 = 0; i4 < this.V3.size(); i4++) {
                this.V3.get(i4).j1(j4, j5);
            }
        } else {
            int b2 = b2(j5);
            if (i2 >= 0) {
                while (b2 < this.V3.size()) {
                    Transition transition = this.V3.get(b2);
                    long j7 = transition.E3;
                    Transition transition2 = transition;
                    long j8 = j4 - j7;
                    if (j8 < j6) {
                        break;
                    }
                    transition2.j1(j8, j5 - j7);
                    b2++;
                    j6 = 0;
                }
            } else {
                while (b2 >= 0) {
                    Transition transition3 = this.V3.get(b2);
                    long j9 = transition3.E3;
                    long j10 = j4 - j9;
                    transition3.j1(j10, j5 - j9);
                    if (j10 >= 0) {
                        break;
                    }
                    b2--;
                }
            }
        }
        if (this.k3 != null) {
            int i5 = (j4 > q0 ? 1 : (j4 == q0 ? 0 : -1));
            if ((i5 > 0 && j5 <= q0) || (i3 < 0 && j5 >= 0)) {
                if (i5 > 0) {
                    this.u3 = true;
                }
                K0(Transition.TransitionNotification.f16076b, z);
            }
        }
    }

    @NonNull
    public TransitionSet j2(@NonNull Transition transition) {
        this.V3.remove(transition);
        transition.k3 = null;
        return this;
    }

    public void l1(@Nullable Transition.EpicenterCallback epicenterCallback) {
        super.l1(epicenterCallback);
        this.Z3 |= 8;
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.V3.get(i2).l1(epicenterCallback);
        }
    }

    @NonNull
    /* renamed from: m2 */
    public TransitionSet k1(long j2) {
        ArrayList<Transition> arrayList;
        super.k1(j2);
        if (this.Y >= 0 && (arrayList = this.V3) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.V3.get(i2).k1(j2);
            }
        }
        return this;
    }

    public void n(@NonNull TransitionValues transitionValues) {
        if (y0(transitionValues.f16095b)) {
            Iterator<Transition> it2 = this.V3.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.y0(transitionValues.f16095b)) {
                    next.n(transitionValues);
                    transitionValues.f16096c.add(next);
                }
            }
        }
    }

    @NonNull
    /* renamed from: n2 */
    public TransitionSet r1(@Nullable TimeInterpolator timeInterpolator) {
        this.Z3 |= 1;
        ArrayList<Transition> arrayList = this.V3;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.V3.get(i2).r1(timeInterpolator);
            }
        }
        return (TransitionSet) super.r1(timeInterpolator);
    }

    /* access modifiers changed from: package-private */
    public void p(TransitionValues transitionValues) {
        super.p(transitionValues);
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.V3.get(i2).p(transitionValues);
        }
    }

    @NonNull
    public TransitionSet p2(int i2) {
        if (i2 == 0) {
            this.W3 = true;
        } else if (i2 == 1) {
            this.W3 = false;
        } else {
            throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
        }
        return this;
    }

    public void q(@NonNull TransitionValues transitionValues) {
        if (y0(transitionValues.f16095b)) {
            Iterator<Transition> it2 = this.V3.iterator();
            while (it2.hasNext()) {
                Transition next = it2.next();
                if (next.y0(transitionValues.f16095b)) {
                    next.q(transitionValues);
                    transitionValues.f16096c.add(next);
                }
            }
        }
    }

    @NonNull
    /* renamed from: q2 */
    public TransitionSet y1(long j2) {
        return (TransitionSet) super.y1(j2);
    }

    @NonNull
    /* renamed from: t */
    public Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.V3 = new ArrayList<>();
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            transitionSet.S1(this.V3.get(i2).clone());
        }
        return transitionSet;
    }

    /* access modifiers changed from: package-private */
    public boolean t0() {
        for (int i2 = 0; i2 < this.V3.size(); i2++) {
            if (this.V3.get(i2).t0()) {
                return true;
            }
        }
        return false;
    }

    public boolean u0() {
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.V3.get(i2).u0()) {
                return false;
            }
        }
        return true;
    }

    public void u1(@Nullable PathMotion pathMotion) {
        super.u1(pathMotion);
        this.Z3 |= 4;
        if (this.V3 != null) {
            for (int i2 = 0; i2 < this.V3.size(); i2++) {
                this.V3.get(i2).u1(pathMotion);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(@NonNull ViewGroup viewGroup, @NonNull TransitionValuesMaps transitionValuesMaps, @NonNull TransitionValuesMaps transitionValuesMaps2, @NonNull ArrayList<TransitionValues> arrayList, @NonNull ArrayList<TransitionValues> arrayList2) {
        long h0 = h0();
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.V3.get(i2);
            if (h0 > 0 && (this.W3 || i2 == 0)) {
                long h02 = transition.h0();
                if (h02 > 0) {
                    transition.y1(h02 + h0);
                } else {
                    transition.y1(h0);
                }
            }
            transition.v(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    public void w1(@Nullable TransitionPropagation transitionPropagation) {
        super.w1(transitionPropagation);
        this.Z3 |= 2;
        int size = this.V3.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.V3.get(i2).w1(transitionPropagation);
        }
    }

    public TransitionSet(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16042i);
        p2(TypedArrayUtils.k(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }
}
