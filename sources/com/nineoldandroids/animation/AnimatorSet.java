package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet extends Animator {
    /* access modifiers changed from: private */
    public ArrayList<Animator> X = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Node> X2 = new ArrayList<>();
    /* access modifiers changed from: private */
    public HashMap<Animator, Node> Y = new HashMap<>();
    private boolean Y2 = true;
    /* access modifiers changed from: private */
    public ArrayList<Node> Z = new ArrayList<>();
    private AnimatorSetListener Z2 = null;
    boolean a3 = false;
    /* access modifiers changed from: private */
    public boolean b3 = false;
    private long c3 = 0;
    private ValueAnimator d3 = null;
    private long e3 = -1;

    private class AnimatorSetListener implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private AnimatorSet f27862a;

        AnimatorSetListener(AnimatorSet animatorSet) {
            this.f27862a = animatorSet;
        }

        public void a(Animator animator) {
            ArrayList<Animator.AnimatorListener> arrayList;
            AnimatorSet animatorSet = AnimatorSet.this;
            if (!animatorSet.a3 && animatorSet.X.size() == 0 && (arrayList = AnimatorSet.this.s) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AnimatorSet.this.s.get(i2).a(this.f27862a);
                }
            }
        }

        public void b(Animator animator) {
        }

        public void c(Animator animator) {
        }

        public void d(Animator animator) {
            animator.l(this);
            AnimatorSet.this.X.remove(animator);
            ((Node) this.f27862a.Y.get(animator)).Y2 = true;
            if (!AnimatorSet.this.a3) {
                ArrayList v = this.f27862a.X2;
                int size = v.size();
                int i2 = 0;
                while (i2 < size) {
                    if (((Node) v.get(i2)).Y2) {
                        i2++;
                    } else {
                        return;
                    }
                }
                ArrayList<Animator.AnimatorListener> arrayList = AnimatorSet.this.s;
                if (arrayList != null) {
                    ArrayList arrayList2 = (ArrayList) arrayList.clone();
                    int size2 = arrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((Animator.AnimatorListener) arrayList2.get(i3)).d(this.f27862a);
                    }
                }
                boolean unused = this.f27862a.b3 = false;
            }
        }
    }

    public class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Node f27864a;

        Builder(Animator animator) {
            Node node = (Node) AnimatorSet.this.Y.get(animator);
            this.f27864a = node;
            if (node == null) {
                this.f27864a = new Node(animator);
                AnimatorSet.this.Y.put(animator, this.f27864a);
                AnimatorSet.this.Z.add(this.f27864a);
            }
        }

        public Builder a(long j2) {
            ValueAnimator l0 = ValueAnimator.l0(0.0f, 1.0f);
            l0.m(j2);
            b(l0);
            return this;
        }

        public Builder b(Animator animator) {
            Node node = (Node) AnimatorSet.this.Y.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.Y.put(animator, node);
                AnimatorSet.this.Z.add(node);
            }
            this.f27864a.a(new Dependency(node, 1));
            return this;
        }

        public Builder c(Animator animator) {
            Node node = (Node) AnimatorSet.this.Y.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.Y.put(animator, node);
                AnimatorSet.this.Z.add(node);
            }
            node.a(new Dependency(this.f27864a, 1));
            return this;
        }

        public Builder d(Animator animator) {
            Node node = (Node) AnimatorSet.this.Y.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.Y.put(animator, node);
                AnimatorSet.this.Z.add(node);
            }
            node.a(new Dependency(this.f27864a, 0));
            return this;
        }
    }

    private static class Dependency {

        /* renamed from: c  reason: collision with root package name */
        static final int f27866c = 0;

        /* renamed from: d  reason: collision with root package name */
        static final int f27867d = 1;

        /* renamed from: a  reason: collision with root package name */
        public Node f27868a;

        /* renamed from: b  reason: collision with root package name */
        public int f27869b;

        public Dependency(Node node, int i2) {
            this.f27868a = node;
            this.f27869b = i2;
        }
    }

    private static class DependencyListener implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private AnimatorSet f27870a;

        /* renamed from: b  reason: collision with root package name */
        private Node f27871b;

        /* renamed from: c  reason: collision with root package name */
        private int f27872c;

        public DependencyListener(AnimatorSet animatorSet, Node node, int i2) {
            this.f27870a = animatorSet;
            this.f27871b = node;
            this.f27872c = i2;
        }

        private void e(Animator animator) {
            Dependency dependency;
            if (!this.f27870a.a3) {
                int size = this.f27871b.Y.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        dependency = null;
                        break;
                    }
                    dependency = this.f27871b.Y.get(i2);
                    if (dependency.f27869b == this.f27872c && dependency.f27868a.s == animator) {
                        animator.l(this);
                        break;
                    }
                    i2++;
                }
                this.f27871b.Y.remove(dependency);
                if (this.f27871b.Y.size() == 0) {
                    this.f27871b.s.s();
                    this.f27870a.X.add(this.f27871b.s);
                }
            }
        }

        public void a(Animator animator) {
        }

        public void b(Animator animator) {
        }

        public void c(Animator animator) {
            if (this.f27872c == 0) {
                e(animator);
            }
        }

        public void d(Animator animator) {
            if (this.f27872c == 1) {
                e(animator);
            }
        }
    }

    private static class Node implements Cloneable {
        public ArrayList<Dependency> X = null;
        public ArrayList<Node> X2 = null;
        public ArrayList<Dependency> Y = null;
        public boolean Y2 = false;
        public ArrayList<Node> Z = null;
        public Animator s;

        public Node(Animator animator) {
            this.s = animator;
        }

        public void a(Dependency dependency) {
            if (this.X == null) {
                this.X = new ArrayList<>();
                this.Z = new ArrayList<>();
            }
            this.X.add(dependency);
            if (!this.Z.contains(dependency.f27868a)) {
                this.Z.add(dependency.f27868a);
            }
            Node node = dependency.f27868a;
            if (node.X2 == null) {
                node.X2 = new ArrayList<>();
            }
            node.X2.add(this);
        }

        /* renamed from: b */
        public Node clone() {
            try {
                Node node = (Node) super.clone();
                node.s = this.s.clone();
                return node;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    private void J() {
        if (this.Y2) {
            this.X2.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.Z.size();
            for (int i2 = 0; i2 < size; i2++) {
                Node node = this.Z.get(i2);
                ArrayList<Dependency> arrayList2 = node.X;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList.add(node);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Node node2 = (Node) arrayList.get(i3);
                    this.X2.add(node2);
                    ArrayList<Node> arrayList4 = node2.X2;
                    if (arrayList4 != null) {
                        int size3 = arrayList4.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            Node node3 = node2.X2.get(i4);
                            node3.Z.remove(node2);
                            if (node3.Z.size() == 0) {
                                arrayList3.add(node3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList3);
                arrayList3.clear();
            }
            this.Y2 = false;
            if (this.X2.size() != this.Z.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.Z.size();
        for (int i5 = 0; i5 < size4; i5++) {
            Node node4 = this.Z.get(i5);
            ArrayList<Dependency> arrayList5 = node4.X;
            if (arrayList5 != null && arrayList5.size() > 0) {
                int size5 = node4.X.size();
                for (int i6 = 0; i6 < size5; i6++) {
                    Dependency dependency = node4.X.get(i6);
                    if (node4.Z == null) {
                        node4.Z = new ArrayList<>();
                    }
                    if (!node4.Z.contains(dependency.f27868a)) {
                        node4.Z.add(dependency.f27868a);
                    }
                }
            }
            node4.Y2 = false;
        }
    }

    public Builder A(Animator animator) {
        if (animator == null) {
            return null;
        }
        this.Y2 = true;
        return new Builder(animator);
    }

    public void B(List<Animator> list) {
        if (list != null && list.size() > 0) {
            this.Y2 = true;
            int i2 = 0;
            if (list.size() == 1) {
                A(list.get(0));
                return;
            }
            while (i2 < list.size() - 1) {
                i2++;
                A(list.get(i2)).c(list.get(i2));
            }
        }
    }

    public void D(Animator... animatorArr) {
        if (animatorArr != null) {
            this.Y2 = true;
            int i2 = 0;
            if (animatorArr.length == 1) {
                A(animatorArr[0]);
                return;
            }
            while (i2 < animatorArr.length - 1) {
                i2++;
                A(animatorArr[i2]).c(animatorArr[i2]);
            }
        }
    }

    public void E(Collection<Animator> collection) {
        if (collection != null && collection.size() > 0) {
            this.Y2 = true;
            Builder builder = null;
            for (Animator next : collection) {
                if (builder == null) {
                    builder = A(next);
                } else {
                    builder.d(next);
                }
            }
        }
    }

    public void F(Animator... animatorArr) {
        if (animatorArr != null) {
            this.Y2 = true;
            Builder A = A(animatorArr[0]);
            for (int i2 = 1; i2 < animatorArr.length; i2++) {
                A.d(animatorArr[i2]);
            }
        }
    }

    /* renamed from: G */
    public AnimatorSet m(long j2) {
        if (j2 >= 0) {
            Iterator<Node> it2 = this.Z.iterator();
            while (it2.hasNext()) {
                it2.next().s.m(j2);
            }
            this.e3 = j2;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    public void c() {
        this.a3 = true;
        if (h()) {
            if (this.X2.size() != this.Z.size()) {
                J();
                Iterator<Node> it2 = this.X2.iterator();
                while (it2.hasNext()) {
                    Node next = it2.next();
                    if (this.Z2 == null) {
                        this.Z2 = new AnimatorSetListener(this);
                    }
                    next.s.a(this.Z2);
                }
            }
            ValueAnimator valueAnimator = this.d3;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.X2.size() > 0) {
                Iterator<Node> it3 = this.X2.iterator();
                while (it3.hasNext()) {
                    it3.next().s.c();
                }
            }
            ArrayList<Animator.AnimatorListener> arrayList = this.s;
            if (arrayList != null) {
                Iterator it4 = ((ArrayList) arrayList.clone()).iterator();
                while (it4.hasNext()) {
                    ((Animator.AnimatorListener) it4.next()).d(this);
                }
            }
            this.b3 = false;
        }
    }

    public void cancel() {
        ArrayList arrayList;
        this.a3 = true;
        if (h()) {
            ArrayList<Animator.AnimatorListener> arrayList2 = this.s;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Animator.AnimatorListener) it2.next()).a(this);
                }
            } else {
                arrayList = null;
            }
            ValueAnimator valueAnimator = this.d3;
            if (valueAnimator != null && valueAnimator.g()) {
                this.d3.cancel();
            } else if (this.X2.size() > 0) {
                Iterator<Node> it3 = this.X2.iterator();
                while (it3.hasNext()) {
                    it3.next().s.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it4 = arrayList.iterator();
                while (it4.hasNext()) {
                    ((Animator.AnimatorListener) it4.next()).d(this);
                }
            }
            this.b3 = false;
        }
    }

    public long d() {
        return this.e3;
    }

    public long f() {
        return this.c3;
    }

    public boolean g() {
        Iterator<Node> it2 = this.Z.iterator();
        while (it2.hasNext()) {
            if (it2.next().s.g()) {
                return true;
            }
        }
        return false;
    }

    public boolean h() {
        return this.b3;
    }

    public void n(Interpolator interpolator) {
        Iterator<Node> it2 = this.Z.iterator();
        while (it2.hasNext()) {
            it2.next().s.n(interpolator);
        }
    }

    public void o(long j2) {
        this.c3 = j2;
    }

    public void p(Object obj) {
        Iterator<Node> it2 = this.Z.iterator();
        while (it2.hasNext()) {
            Animator animator = it2.next().s;
            if (animator instanceof AnimatorSet) {
                ((AnimatorSet) animator).p(obj);
            } else if (animator instanceof ObjectAnimator) {
                ((ObjectAnimator) animator).p(obj);
            }
        }
    }

    public void q() {
        Iterator<Node> it2 = this.Z.iterator();
        while (it2.hasNext()) {
            it2.next().s.q();
        }
    }

    public void r() {
        Iterator<Node> it2 = this.Z.iterator();
        while (it2.hasNext()) {
            it2.next().s.r();
        }
    }

    public void s() {
        this.a3 = false;
        this.b3 = true;
        J();
        int size = this.X2.size();
        for (int i2 = 0; i2 < size; i2++) {
            Node node = this.X2.get(i2);
            ArrayList<Animator.AnimatorListener> e2 = node.s.e();
            if (e2 != null && e2.size() > 0) {
                Iterator it2 = new ArrayList(e2).iterator();
                while (it2.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener) it2.next();
                    if ((animatorListener instanceof DependencyListener) || (animatorListener instanceof AnimatorSetListener)) {
                        node.s.l(animatorListener);
                    }
                }
            }
        }
        final ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            Node node2 = this.X2.get(i3);
            if (this.Z2 == null) {
                this.Z2 = new AnimatorSetListener(this);
            }
            ArrayList<Dependency> arrayList2 = node2.X;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList.add(node2);
            } else {
                int size2 = node2.X.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Dependency dependency = node2.X.get(i4);
                    dependency.f27868a.s.a(new DependencyListener(this, node2, dependency.f27869b));
                }
                node2.Y = (ArrayList) node2.X.clone();
            }
            node2.s.a(this.Z2);
        }
        if (this.c3 <= 0) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                Node node3 = (Node) it3.next();
                node3.s.s();
                this.X.add(node3.s);
            }
        } else {
            ValueAnimator l0 = ValueAnimator.l0(0.0f, 1.0f);
            this.d3 = l0;
            l0.m(this.c3);
            this.d3.a(new AnimatorListenerAdapter() {

                /* renamed from: a  reason: collision with root package name */
                boolean f27859a = false;

                public void a(Animator animator) {
                    this.f27859a = true;
                }

                public void d(Animator animator) {
                    if (!this.f27859a) {
                        int size = arrayList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            Node node = (Node) arrayList.get(i2);
                            node.s.s();
                            AnimatorSet.this.X.add(node.s);
                        }
                    }
                }
            });
            this.d3.s();
        }
        ArrayList<Animator.AnimatorListener> arrayList3 = this.s;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i5 = 0; i5 < size3; i5++) {
                ((Animator.AnimatorListener) arrayList4.get(i5)).c(this);
            }
        }
        if (this.Z.size() == 0 && this.c3 == 0) {
            this.b3 = false;
            ArrayList<Animator.AnimatorListener> arrayList5 = this.s;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i6 = 0; i6 < size4; i6++) {
                    ((Animator.AnimatorListener) arrayList6.get(i6)).d(this);
                }
            }
        }
    }

    /* renamed from: y */
    public AnimatorSet clone() {
        AnimatorSet animatorSet = (AnimatorSet) super.clone();
        animatorSet.Y2 = true;
        animatorSet.a3 = false;
        animatorSet.b3 = false;
        animatorSet.X = new ArrayList<>();
        animatorSet.Y = new HashMap<>();
        animatorSet.Z = new ArrayList<>();
        animatorSet.X2 = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<Node> it2 = this.Z.iterator();
        while (it2.hasNext()) {
            Node next = it2.next();
            Node b2 = next.clone();
            hashMap.put(next, b2);
            animatorSet.Z.add(b2);
            animatorSet.Y.put(b2.s, b2);
            ArrayList arrayList = null;
            b2.X = null;
            b2.Y = null;
            b2.X2 = null;
            b2.Z = null;
            ArrayList<Animator.AnimatorListener> e2 = b2.s.e();
            if (e2 != null) {
                Iterator<Animator.AnimatorListener> it3 = e2.iterator();
                while (it3.hasNext()) {
                    Animator.AnimatorListener next2 = it3.next();
                    if (next2 instanceof AnimatorSetListener) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        e2.remove((Animator.AnimatorListener) it4.next());
                    }
                }
            }
        }
        Iterator<Node> it5 = this.Z.iterator();
        while (it5.hasNext()) {
            Node next3 = it5.next();
            Node node = (Node) hashMap.get(next3);
            ArrayList<Dependency> arrayList2 = next3.X;
            if (arrayList2 != null) {
                Iterator<Dependency> it6 = arrayList2.iterator();
                while (it6.hasNext()) {
                    Dependency next4 = it6.next();
                    node.a(new Dependency((Node) hashMap.get(next4.f27868a), next4.f27869b));
                }
            }
        }
        return animatorSet;
    }

    public ArrayList<Animator> z() {
        ArrayList<Animator> arrayList = new ArrayList<>();
        Iterator<Node> it2 = this.Z.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().s);
        }
        return arrayList;
    }
}
