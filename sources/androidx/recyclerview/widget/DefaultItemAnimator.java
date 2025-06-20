package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
    private static TimeInterpolator A = null;
    private static final boolean z = false;
    private ArrayList<RecyclerView.ViewHolder> o = new ArrayList<>();
    private ArrayList<RecyclerView.ViewHolder> p = new ArrayList<>();
    private ArrayList<MoveInfo> q = new ArrayList<>();
    private ArrayList<ChangeInfo> r = new ArrayList<>();
    ArrayList<ArrayList<RecyclerView.ViewHolder>> s = new ArrayList<>();
    ArrayList<ArrayList<MoveInfo>> t = new ArrayList<>();
    ArrayList<ArrayList<ChangeInfo>> u = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> v = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> w = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> x = new ArrayList<>();
    ArrayList<RecyclerView.ViewHolder> y = new ArrayList<>();

    private static class ChangeInfo {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f15282a;

        /* renamed from: b  reason: collision with root package name */
        public RecyclerView.ViewHolder f15283b;

        /* renamed from: c  reason: collision with root package name */
        public int f15284c;

        /* renamed from: d  reason: collision with root package name */
        public int f15285d;

        /* renamed from: e  reason: collision with root package name */
        public int f15286e;

        /* renamed from: f  reason: collision with root package name */
        public int f15287f;

        private ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.f15282a = viewHolder;
            this.f15283b = viewHolder2;
        }

        @SuppressLint({"UnknownNullness"})
        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f15282a + ", newHolder=" + this.f15283b + ", fromX=" + this.f15284c + ", fromY=" + this.f15285d + ", toX=" + this.f15286e + ", toY=" + this.f15287f + ASCIIPropertyListParser.f18653k;
        }

        ChangeInfo(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
            this(viewHolder, viewHolder2);
            this.f15284c = i2;
            this.f15285d = i3;
            this.f15286e = i4;
            this.f15287f = i5;
        }
    }

    private static class MoveInfo {

        /* renamed from: a  reason: collision with root package name */
        public RecyclerView.ViewHolder f15288a;

        /* renamed from: b  reason: collision with root package name */
        public int f15289b;

        /* renamed from: c  reason: collision with root package name */
        public int f15290c;

        /* renamed from: d  reason: collision with root package name */
        public int f15291d;

        /* renamed from: e  reason: collision with root package name */
        public int f15292e;

        MoveInfo(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
            this.f15288a = viewHolder;
            this.f15289b = i2;
            this.f15290c = i3;
            this.f15291d = i4;
            this.f15292e = i5;
        }
    }

    private void c0(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.f15587a;
        final ViewPropertyAnimator animate = view.animate();
        this.x.add(viewHolder);
        animate.setDuration(p()).alpha(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                view.setAlpha(1.0f);
                DefaultItemAnimator.this.N(viewHolder);
                DefaultItemAnimator.this.x.remove(viewHolder);
                DefaultItemAnimator.this.e0();
            }

            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.O(viewHolder);
            }
        }).start();
    }

    private void f0(List<ChangeInfo> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = list.get(size);
            if (h0(changeInfo, viewHolder) && changeInfo.f15282a == null && changeInfo.f15283b == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void g0(ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.f15282a;
        if (viewHolder != null) {
            h0(changeInfo, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f15283b;
        if (viewHolder2 != null) {
            h0(changeInfo, viewHolder2);
        }
    }

    private boolean h0(ChangeInfo changeInfo, RecyclerView.ViewHolder viewHolder) {
        boolean z2 = false;
        if (changeInfo.f15283b == viewHolder) {
            changeInfo.f15283b = null;
        } else if (changeInfo.f15282a != viewHolder) {
            return false;
        } else {
            changeInfo.f15282a = null;
            z2 = true;
        }
        viewHolder.f15587a.setAlpha(1.0f);
        viewHolder.f15587a.setTranslationX(0.0f);
        viewHolder.f15587a.setTranslationY(0.0f);
        J(viewHolder, z2);
        return true;
    }

    private void i0(RecyclerView.ViewHolder viewHolder) {
        if (A == null) {
            A = new ValueAnimator().getInterpolator();
        }
        viewHolder.f15587a.animate().setInterpolator(A);
        k(viewHolder);
    }

    @SuppressLint({"UnknownNullness"})
    public boolean D(RecyclerView.ViewHolder viewHolder) {
        i0(viewHolder);
        viewHolder.f15587a.setAlpha(0.0f);
        this.p.add(viewHolder);
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public boolean E(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        if (viewHolder == viewHolder2) {
            return F(viewHolder, i2, i3, i4, i5);
        }
        float translationX = viewHolder.f15587a.getTranslationX();
        float translationY = viewHolder.f15587a.getTranslationY();
        float alpha = viewHolder.f15587a.getAlpha();
        i0(viewHolder);
        int i6 = (int) (((float) (i4 - i2)) - translationX);
        int i7 = (int) (((float) (i5 - i3)) - translationY);
        viewHolder.f15587a.setTranslationX(translationX);
        viewHolder.f15587a.setTranslationY(translationY);
        viewHolder.f15587a.setAlpha(alpha);
        if (viewHolder2 != null) {
            i0(viewHolder2);
            viewHolder2.f15587a.setTranslationX((float) (-i6));
            viewHolder2.f15587a.setTranslationY((float) (-i7));
            viewHolder2.f15587a.setAlpha(0.0f);
        }
        this.r.add(new ChangeInfo(viewHolder, viewHolder2, i2, i3, i4, i5));
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public boolean F(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.f15587a;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) viewHolder.f15587a.getTranslationY());
        i0(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            L(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX((float) (-i6));
        }
        if (i7 != 0) {
            view.setTranslationY((float) (-i7));
        }
        this.q.add(new MoveInfo(viewHolder, translationX, translationY, i4, i5));
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public boolean G(RecyclerView.ViewHolder viewHolder) {
        i0(viewHolder);
        this.o.add(viewHolder);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void Z(final RecyclerView.ViewHolder viewHolder) {
        final View view = viewHolder.f15587a;
        final ViewPropertyAnimator animate = view.animate();
        this.v.add(viewHolder);
        animate.alpha(1.0f).setDuration(m()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                view.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                DefaultItemAnimator.this.H(viewHolder);
                DefaultItemAnimator.this.v.remove(viewHolder);
                DefaultItemAnimator.this.e0();
            }

            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.I(viewHolder);
            }
        }).start();
    }

    /* access modifiers changed from: package-private */
    public void a0(final ChangeInfo changeInfo) {
        RecyclerView.ViewHolder viewHolder = changeInfo.f15282a;
        final View view = null;
        final View view2 = viewHolder == null ? null : viewHolder.f15587a;
        RecyclerView.ViewHolder viewHolder2 = changeInfo.f15283b;
        if (viewHolder2 != null) {
            view = viewHolder2.f15587a;
        }
        if (view2 != null) {
            final ViewPropertyAnimator duration = view2.animate().setDuration(n());
            this.y.add(changeInfo.f15282a);
            duration.translationX((float) (changeInfo.f15286e - changeInfo.f15284c));
            duration.translationY((float) (changeInfo.f15287f - changeInfo.f15285d));
            duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    duration.setListener((Animator.AnimatorListener) null);
                    view2.setAlpha(1.0f);
                    view2.setTranslationX(0.0f);
                    view2.setTranslationY(0.0f);
                    DefaultItemAnimator.this.J(changeInfo.f15282a, true);
                    DefaultItemAnimator.this.y.remove(changeInfo.f15282a);
                    DefaultItemAnimator.this.e0();
                }

                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.K(changeInfo.f15282a, true);
                }
            }).start();
        }
        if (view != null) {
            final ViewPropertyAnimator animate = view.animate();
            this.y.add(changeInfo.f15283b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(n()).alpha(1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    animate.setListener((Animator.AnimatorListener) null);
                    view.setAlpha(1.0f);
                    view.setTranslationX(0.0f);
                    view.setTranslationY(0.0f);
                    DefaultItemAnimator.this.J(changeInfo.f15283b, false);
                    DefaultItemAnimator.this.y.remove(changeInfo.f15283b);
                    DefaultItemAnimator.this.e0();
                }

                public void onAnimationStart(Animator animator) {
                    DefaultItemAnimator.this.K(changeInfo.f15283b, false);
                }
            }).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void b0(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        final View view = viewHolder.f15587a;
        final int i6 = i4 - i2;
        final int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        final ViewPropertyAnimator animate = view.animate();
        this.w.add(viewHolder);
        final RecyclerView.ViewHolder viewHolder2 = viewHolder;
        animate.setDuration(o()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                if (i6 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (i7 != 0) {
                    view.setTranslationY(0.0f);
                }
            }

            public void onAnimationEnd(Animator animator) {
                animate.setListener((Animator.AnimatorListener) null);
                DefaultItemAnimator.this.L(viewHolder2);
                DefaultItemAnimator.this.w.remove(viewHolder2);
                DefaultItemAnimator.this.e0();
            }

            public void onAnimationStart(Animator animator) {
                DefaultItemAnimator.this.M(viewHolder2);
            }
        }).start();
    }

    /* access modifiers changed from: package-private */
    public void d0(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f15587a.animate().cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void e0() {
        if (!q()) {
            j();
        }
    }

    public boolean g(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        return !list.isEmpty() || super.g(viewHolder, list);
    }

    @SuppressLint({"UnknownNullness"})
    public void k(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.f15587a;
        view.animate().cancel();
        int size = this.q.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.q.get(size).f15288a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                L(viewHolder);
                this.q.remove(size);
            }
        }
        f0(this.r, viewHolder);
        if (this.o.remove(viewHolder)) {
            view.setAlpha(1.0f);
            N(viewHolder);
        }
        if (this.p.remove(viewHolder)) {
            view.setAlpha(1.0f);
            H(viewHolder);
        }
        for (int size2 = this.u.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = this.u.get(size2);
            f0(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.u.remove(size2);
            }
        }
        for (int size3 = this.t.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = this.t.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (((MoveInfo) arrayList2.get(size4)).f15288a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    L(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.t.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.s.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = this.s.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                H(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.s.remove(size5);
                }
            }
        }
        this.x.remove(viewHolder);
        this.v.remove(viewHolder);
        this.y.remove(viewHolder);
        this.w.remove(viewHolder);
        e0();
    }

    public void l() {
        int size = this.q.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            MoveInfo moveInfo = this.q.get(size);
            View view = moveInfo.f15288a.f15587a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            L(moveInfo.f15288a);
            this.q.remove(size);
        }
        for (int size2 = this.o.size() - 1; size2 >= 0; size2--) {
            N(this.o.get(size2));
            this.o.remove(size2);
        }
        int size3 = this.p.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.p.get(size3);
            viewHolder.f15587a.setAlpha(1.0f);
            H(viewHolder);
            this.p.remove(size3);
        }
        for (int size4 = this.r.size() - 1; size4 >= 0; size4--) {
            g0(this.r.get(size4));
        }
        this.r.clear();
        if (q()) {
            for (int size5 = this.t.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = this.t.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size6);
                    View view2 = moveInfo2.f15288a.f15587a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    L(moveInfo2.f15288a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.t.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.s.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = this.s.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) arrayList2.get(size8);
                    viewHolder2.f15587a.setAlpha(1.0f);
                    H(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.s.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.u.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = this.u.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    g0((ChangeInfo) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.u.remove(arrayList3);
                    }
                }
            }
            d0(this.x);
            d0(this.w);
            d0(this.v);
            d0(this.y);
            j();
        }
    }

    public boolean q() {
        return !this.p.isEmpty() || !this.r.isEmpty() || !this.q.isEmpty() || !this.o.isEmpty() || !this.w.isEmpty() || !this.x.isEmpty() || !this.v.isEmpty() || !this.y.isEmpty() || !this.t.isEmpty() || !this.s.isEmpty() || !this.u.isEmpty();
    }

    public void x() {
        boolean z2 = !this.o.isEmpty();
        boolean z3 = !this.q.isEmpty();
        boolean z4 = !this.r.isEmpty();
        boolean z5 = !this.p.isEmpty();
        if (z2 || z3 || z5 || z4) {
            Iterator<RecyclerView.ViewHolder> it2 = this.o.iterator();
            while (it2.hasNext()) {
                c0(it2.next());
            }
            this.o.clear();
            if (z3) {
                final ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.q);
                this.t.add(arrayList);
                this.q.clear();
                AnonymousClass1 r6 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            MoveInfo moveInfo = (MoveInfo) it2.next();
                            DefaultItemAnimator.this.b0(moveInfo.f15288a, moveInfo.f15289b, moveInfo.f15290c, moveInfo.f15291d, moveInfo.f15292e);
                        }
                        arrayList.clear();
                        DefaultItemAnimator.this.t.remove(arrayList);
                    }
                };
                if (z2) {
                    ViewCompat.w1(((MoveInfo) arrayList.get(0)).f15288a.f15587a, r6, p());
                } else {
                    r6.run();
                }
            }
            if (z4) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.r);
                this.u.add(arrayList2);
                this.r.clear();
                AnonymousClass2 r62 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.a0((ChangeInfo) it2.next());
                        }
                        arrayList2.clear();
                        DefaultItemAnimator.this.u.remove(arrayList2);
                    }
                };
                if (z2) {
                    ViewCompat.w1(((ChangeInfo) arrayList2.get(0)).f15282a.f15587a, r62, p());
                } else {
                    r62.run();
                }
            }
            if (z5) {
                final ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.p);
                this.s.add(arrayList3);
                this.p.clear();
                AnonymousClass3 r5 = new Runnable() {
                    public void run() {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            DefaultItemAnimator.this.Z((RecyclerView.ViewHolder) it2.next());
                        }
                        arrayList3.clear();
                        DefaultItemAnimator.this.s.remove(arrayList3);
                    }
                };
                if (z2 || z3 || z4) {
                    long j2 = 0;
                    long p2 = z2 ? p() : 0;
                    long o2 = z3 ? o() : 0;
                    if (z4) {
                        j2 = n();
                    }
                    ViewCompat.w1(((RecyclerView.ViewHolder) arrayList3.get(0)).f15587a, r5, p2 + Math.max(o2, j2));
                    return;
                }
                r5.run();
            }
        }
    }
}
