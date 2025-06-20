package androidx.transition;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f16083c = "TransitionManager";

    /* renamed from: d  reason: collision with root package name */
    private static Transition f16084d = new AutoTransition();

    /* renamed from: e  reason: collision with root package name */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> f16085e = new ThreadLocal<>();

    /* renamed from: f  reason: collision with root package name */
    static ArrayList<ViewGroup> f16086f = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private ArrayMap<Scene, Transition> f16087a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> f16088b = new ArrayMap<>();

    private static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        ViewGroup X;
        Transition s;

        MultiListener(Transition transition, ViewGroup viewGroup) {
            this.s = transition;
            this.X = viewGroup;
        }

        private void a() {
            this.X.getViewTreeObserver().removeOnPreDrawListener(this);
            this.X.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            a();
            if (!TransitionManager.f16086f.remove(this.X)) {
                return true;
            }
            final ArrayMap<ViewGroup, ArrayList<Transition>> g2 = TransitionManager.g();
            ArrayList arrayList = g2.get(this.X);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                g2.put(this.X, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.s);
            this.s.c(new TransitionListenerAdapter() {
                public void k(@NonNull Transition transition) {
                    ((ArrayList) g2.get(MultiListener.this.X)).remove(transition);
                    transition.S0(this);
                }
            });
            this.s.r(this.X, false);
            if (arrayList2 != null) {
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).d1(this.X);
                }
            }
            this.s.O0(this.X);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            a();
            TransitionManager.f16086f.remove(this.X);
            ArrayList arrayList = TransitionManager.g().get(this.X);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Transition) it2.next()).d1(this.X);
                }
            }
            this.s.s(true);
        }
    }

    public static void a(@NonNull ViewGroup viewGroup) {
        b(viewGroup, (Transition) null);
    }

    public static void b(@NonNull ViewGroup viewGroup, @Nullable Transition transition) {
        if (!f16086f.contains(viewGroup) && viewGroup.isLaidOut()) {
            f16086f.add(viewGroup);
            if (transition == null) {
                transition = f16084d;
            }
            Transition t = transition.clone();
            l(viewGroup, t);
            Scene.g(viewGroup, (Scene) null);
            k(viewGroup, t);
        }
    }

    private static void c(Scene scene, Transition transition) {
        ViewGroup e2 = scene.e();
        if (!f16086f.contains(e2)) {
            Scene c2 = Scene.c(e2);
            if (transition == null) {
                if (c2 != null) {
                    c2.b();
                }
                scene.a();
                return;
            }
            f16086f.add(e2);
            Transition t = transition.clone();
            if (c2 != null && c2.f()) {
                t.h1(true);
            }
            l(e2, t);
            scene.a();
            k(e2, t);
        }
    }

    @Nullable
    public static TransitionSeekController d(@NonNull ViewGroup viewGroup, @NonNull Transition transition) {
        if (f16086f.contains(viewGroup) || !viewGroup.isLaidOut() || Build.VERSION.SDK_INT < 34) {
            return null;
        }
        if (transition.u0()) {
            f16086f.add(viewGroup);
            Transition t = transition.clone();
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.R1(t);
            l(viewGroup, transitionSet);
            Scene.g(viewGroup, (Scene) null);
            k(viewGroup, transitionSet);
            viewGroup.invalidate();
            return transitionSet.w();
        }
        throw new IllegalArgumentException("The Transition must support seeking.");
    }

    @Nullable
    public static TransitionSeekController e(@NonNull Scene scene, @NonNull Transition transition) {
        ViewGroup e2 = scene.e();
        if (!transition.u0()) {
            throw new IllegalArgumentException("The Transition must support seeking.");
        } else if (f16086f.contains(e2)) {
            return null;
        } else {
            Scene c2 = Scene.c(e2);
            if (!e2.isLaidOut() || Build.VERSION.SDK_INT < 34) {
                if (c2 != null) {
                    c2.b();
                }
                scene.a();
                return null;
            }
            f16086f.add(e2);
            Transition t = transition.clone();
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.R1(t);
            if (c2 != null && c2.f()) {
                transitionSet.h1(true);
            }
            l(e2, transitionSet);
            scene.a();
            k(e2, transitionSet);
            return transitionSet.w();
        }
    }

    public static void f(@Nullable ViewGroup viewGroup) {
        f16086f.remove(viewGroup);
        ArrayList arrayList = g().get(viewGroup);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((Transition) arrayList2.get(size)).M(viewGroup);
            }
        }
    }

    @VisibleForTesting
    static ArrayMap<ViewGroup, ArrayList<Transition>> g() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference weakReference = f16085e.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        f16085e.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    private Transition h(Scene scene) {
        ArrayMap arrayMap;
        Transition transition;
        Scene c2 = Scene.c(scene.e());
        if (c2 != null && (arrayMap = this.f16088b.get(scene)) != null && (transition = (Transition) arrayMap.get(c2)) != null) {
            return transition;
        }
        Transition transition2 = this.f16087a.get(scene);
        return transition2 != null ? transition2 : f16084d;
    }

    public static void i(@NonNull Scene scene) {
        c(scene, f16084d);
    }

    public static void j(@NonNull Scene scene, @Nullable Transition transition) {
        c(scene, transition);
    }

    private static void k(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static void l(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = g().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Transition) it2.next()).M0(viewGroup);
            }
        }
        if (transition != null) {
            transition.r(viewGroup, true);
        }
        Scene c2 = Scene.c(viewGroup);
        if (c2 != null) {
            c2.b();
        }
    }

    public void m(@NonNull Scene scene, @NonNull Scene scene2, @Nullable Transition transition) {
        ArrayMap arrayMap = this.f16088b.get(scene2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.f16088b.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }

    public void n(@NonNull Scene scene, @Nullable Transition transition) {
        this.f16087a.put(scene, transition);
    }

    public void o(@NonNull Scene scene) {
        c(scene, h(scene));
    }
}
