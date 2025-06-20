package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public abstract class Transition implements Cloneable {
    private static final String F3 = "Transition";
    private static final Animator[] G3 = new Animator[0];
    static final boolean H3 = false;
    public static final int I3 = 1;
    private static final int J3 = 1;
    public static final int K3 = 2;
    public static final int L3 = 3;
    public static final int M3 = 4;
    private static final int N3 = 4;
    private static final String O3 = "instance";
    private static final String P3 = "name";
    private static final String Q3 = "id";
    private static final String R3 = "itemId";
    private static final int[] S3 = {2, 1, 3, 4};
    private static final PathMotion T3 = new PathMotion() {
        @NonNull
        public Path a(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> U3 = new ThreadLocal<>();
    private ArrayMap<String, String> A3;
    private PathMotion B3 = T3;
    long C3;
    SeekController D3;
    long E3;
    private long X = -1;
    ArrayList<Integer> X2 = new ArrayList<>();
    long Y = -1;
    ArrayList<View> Y2 = new ArrayList<>();
    private TimeInterpolator Z = null;
    private ArrayList<String> Z2 = null;
    private ArrayList<Class<?>> a3 = null;
    private ArrayList<Integer> b3 = null;
    private ArrayList<View> c3 = null;
    private ArrayList<Class<?>> d3 = null;
    private ArrayList<String> e3 = null;
    private ArrayList<Integer> f3 = null;
    private ArrayList<View> g3 = null;
    private ArrayList<Class<?>> h3 = null;
    private TransitionValuesMaps i3 = new TransitionValuesMaps();
    private TransitionValuesMaps j3 = new TransitionValuesMaps();
    TransitionSet k3 = null;
    private int[] l3 = S3;
    private ArrayList<TransitionValues> m3;
    private ArrayList<TransitionValues> n3;
    private TransitionListener[] o3;
    boolean p3 = false;
    ArrayList<Animator> q3 = new ArrayList<>();
    private Animator[] r3 = G3;
    private String s = getClass().getName();
    int s3 = 0;
    private boolean t3 = false;
    boolean u3 = false;
    /* access modifiers changed from: private */
    public Transition v3 = null;
    private ArrayList<TransitionListener> w3 = null;
    ArrayList<Animator> x3 = new ArrayList<>();
    TransitionPropagation y3;
    private EpicenterCallback z3;

    private static class AnimationInfo {

        /* renamed from: a  reason: collision with root package name */
        View f16069a;

        /* renamed from: b  reason: collision with root package name */
        String f16070b;

        /* renamed from: c  reason: collision with root package name */
        TransitionValues f16071c;

        /* renamed from: d  reason: collision with root package name */
        WindowId f16072d;

        /* renamed from: e  reason: collision with root package name */
        Transition f16073e;

        /* renamed from: f  reason: collision with root package name */
        Animator f16074f;

        AnimationInfo(View view, String str, Transition transition, WindowId windowId, TransitionValues transitionValues, Animator animator) {
            this.f16069a = view;
            this.f16070b = str;
            this.f16071c = transitionValues;
            this.f16072d = windowId;
            this.f16073e = transition;
            this.f16074f = animator;
        }
    }

    private static class ArrayListManager {
        private ArrayListManager() {
        }

        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public static abstract class EpicenterCallback {
        @Nullable
        public abstract Rect a(@NonNull Transition transition);
    }

    @RequiresApi(26)
    private static class Impl26 {
        private Impl26() {
        }

        @DoNotInline
        static long a(Animator animator) {
            return animator.getTotalDuration();
        }

        @DoNotInline
        static void b(Animator animator, long j2) {
            ((AnimatorSet) animator).setCurrentPlayTime(j2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MatchOrder {
    }

    @RequiresApi(34)
    class SeekController extends TransitionListenerAdapter implements TransitionSeekController, DynamicAnimation.OnAnimationUpdateListener {
        private ArrayList<Consumer<TransitionSeekController>> X = null;
        private boolean X2;
        private ArrayList<Consumer<TransitionSeekController>> Y = null;
        private SpringAnimation Y2;
        private boolean Z;
        private Consumer<TransitionSeekController>[] Z2 = null;
        private final VelocityTracker1D a3 = new VelocityTracker1D();
        private Runnable b3;
        private long s = -1;

        SeekController() {
        }

        private void v() {
            ArrayList<Consumer<TransitionSeekController>> arrayList = this.Y;
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = this.Y.size();
                if (this.Z2 == null) {
                    this.Z2 = new Consumer[size];
                }
                Consumer<TransitionSeekController>[] consumerArr = (Consumer[]) this.Y.toArray(this.Z2);
                this.Z2 = null;
                for (int i2 = 0; i2 < size; i2++) {
                    consumerArr[i2].accept(this);
                    consumerArr[i2] = null;
                }
                this.Z2 = consumerArr;
            }
        }

        private void w() {
            if (this.Y2 == null) {
                this.a3.a(AnimationUtils.currentAnimationTimeMillis(), (float) this.s);
                this.Y2 = new SpringAnimation(new FloatValueHolder());
                SpringForce springForce = new SpringForce();
                springForce.g(1.0f);
                springForce.i(200.0f);
                this.Y2.D(springForce);
                this.Y2.t((float) this.s);
                this.Y2.c(this);
                this.Y2.u(this.a3.b());
                this.Y2.p((float) (t() + 1));
                this.Y2.q(-1.0f);
                this.Y2.r(4.0f);
                this.Y2.b(new d(this));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void y(DynamicAnimation dynamicAnimation, boolean z, float f2, float f3) {
            if (z) {
                return;
            }
            if (f2 < 1.0f) {
                long t = t();
                Transition U1 = ((TransitionSet) Transition.this).U1(0);
                Transition a2 = U1.v3;
                Transition unused = U1.v3 = null;
                Transition.this.j1(-1, this.s);
                Transition.this.j1(t, -1);
                this.s = t;
                Runnable runnable = this.b3;
                if (runnable != null) {
                    runnable.run();
                }
                Transition.this.x3.clear();
                if (a2 != null) {
                    a2.K0(TransitionNotification.f16076b, true);
                    return;
                }
                return;
            }
            Transition.this.K0(TransitionNotification.f16076b, false);
        }

        public void a(@NonNull Consumer<TransitionSeekController> consumer) {
            ArrayList<Consumer<TransitionSeekController>> arrayList = this.X;
            if (arrayList != null) {
                arrayList.remove(consumer);
                if (this.X.isEmpty()) {
                    this.X = null;
                }
            }
        }

        public void c(float f2) {
            if (this.Y2 == null) {
                g((long) (f2 * ((float) t())));
                return;
            }
            throw new IllegalStateException("setCurrentFraction() called after animation has been started");
        }

        public boolean d() {
            return this.Z;
        }

        public long e() {
            return Math.min(t(), Math.max(0, this.s));
        }

        public void g(long j2) {
            if (this.Y2 != null) {
                throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
            } else if (j2 != this.s && d()) {
                if (!this.X2) {
                    if (j2 != 0 || this.s <= 0) {
                        long t = t();
                        if (j2 == t && this.s < t) {
                            j2 = 1 + t;
                        }
                    } else {
                        j2 = -1;
                    }
                    long j3 = this.s;
                    if (j2 != j3) {
                        Transition.this.j1(j2, j3);
                        this.s = j2;
                    }
                }
                v();
                this.a3.a(AnimationUtils.currentAnimationTimeMillis(), (float) j2);
            }
        }

        public void i(@NonNull Consumer<TransitionSeekController> consumer) {
            if (this.Y == null) {
                this.Y = new ArrayList<>();
            }
            this.Y.add(consumer);
        }

        public void j(@NonNull Consumer<TransitionSeekController> consumer) {
            ArrayList<Consumer<TransitionSeekController>> arrayList = this.Y;
            if (arrayList != null) {
                arrayList.remove(consumer);
            }
        }

        public void l() {
            w();
            this.Y2.z((float) (t() + 1));
        }

        public void m(DynamicAnimation dynamicAnimation, float f2, float f3) {
            long max = Math.max(-1, Math.min(t() + 1, Math.round((double) f2)));
            Transition.this.j1(max, this.s);
            this.s = max;
            v();
        }

        public void n(@NonNull Consumer<TransitionSeekController> consumer) {
            if (d()) {
                consumer.accept(this);
                return;
            }
            if (this.X == null) {
                this.X = new ArrayList<>();
            }
            this.X.add(consumer);
        }

        public void o(@NonNull Runnable runnable) {
            this.b3 = runnable;
            w();
            this.Y2.z(0.0f);
        }

        public void p(@NonNull Transition transition) {
            this.X2 = true;
        }

        public float r() {
            return ((float) e()) / ((float) t());
        }

        public long t() {
            return Transition.this.q0();
        }

        /* access modifiers changed from: package-private */
        public void x() {
            long j2 = 0;
            if (t() == 0) {
                j2 = 1;
            }
            Transition.this.j1(j2, this.s);
            this.s = j2;
        }

        public void z() {
            this.Z = true;
            ArrayList<Consumer<TransitionSeekController>> arrayList = this.X;
            if (arrayList != null) {
                this.X = null;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList.get(i2).accept(this);
                }
            }
            v();
        }
    }

    public interface TransitionListener {
        void b(@NonNull Transition transition);

        void f(@NonNull Transition transition);

        void h(@NonNull Transition transition, boolean z);

        void k(@NonNull Transition transition);

        void p(@NonNull Transition transition);

        void q(@NonNull Transition transition, boolean z);

        void s(@NonNull Transition transition);
    }

    interface TransitionNotification {

        /* renamed from: a  reason: collision with root package name */
        public static final TransitionNotification f16075a = new f();

        /* renamed from: b  reason: collision with root package name */
        public static final TransitionNotification f16076b = new g();

        /* renamed from: c  reason: collision with root package name */
        public static final TransitionNotification f16077c = new h();

        /* renamed from: d  reason: collision with root package name */
        public static final TransitionNotification f16078d = new i();

        /* renamed from: e  reason: collision with root package name */
        public static final TransitionNotification f16079e = new j();

        void a(@NonNull TransitionListener transitionListener, @NonNull Transition transition, boolean z);
    }

    public Transition() {
    }

    private ArrayList<Integer> B(ArrayList<Integer> arrayList, int i2, boolean z) {
        if (i2 <= 0) {
            return arrayList;
        }
        Integer valueOf = Integer.valueOf(i2);
        return z ? ArrayListManager.a(arrayList, valueOf) : ArrayListManager.b(arrayList, valueOf);
    }

    private void C0(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            View valueAt = sparseArray.valueAt(i2);
            if (valueAt != null && y0(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i2))) != null && y0(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.m3.add(transitionValues);
                    this.n3.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private static <T> ArrayList<T> D(ArrayList<T> arrayList, T t, boolean z) {
        if (t != null) {
            return z ? ArrayListManager.a(arrayList, t) : ArrayListManager.b(arrayList, t);
        }
        return arrayList;
    }

    private void D0(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View i2 = arrayMap.i(size);
            if (i2 != null && y0(i2) && (remove = arrayMap2.remove(i2)) != null && y0(remove.f16095b)) {
                this.m3.add(arrayMap.k(size));
                this.n3.add(remove);
            }
        }
    }

    private void E0(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View h2;
        int y = longSparseArray.y();
        for (int i2 = 0; i2 < y; i2++) {
            View z = longSparseArray.z(i2);
            if (z != null && y0(z) && (h2 = longSparseArray2.h(longSparseArray.o(i2))) != null && y0(h2)) {
                TransitionValues transitionValues = arrayMap.get(z);
                TransitionValues transitionValues2 = arrayMap2.get(h2);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.m3.add(transitionValues);
                    this.n3.add(transitionValues2);
                    arrayMap.remove(z);
                    arrayMap2.remove(h2);
                }
            }
        }
    }

    private void F0(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i2 = 0; i2 < size; i2++) {
            View m2 = arrayMap3.m(i2);
            if (m2 != null && y0(m2) && (view = arrayMap4.get(arrayMap3.i(i2))) != null && y0(view)) {
                TransitionValues transitionValues = arrayMap.get(m2);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.m3.add(transitionValues);
                    this.n3.add(transitionValues2);
                    arrayMap.remove(m2);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void G0(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) transitionValuesMaps.f16097a);
        ArrayMap arrayMap2 = new ArrayMap((SimpleArrayMap) transitionValuesMaps2.f16097a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.l3;
            if (i2 < iArr.length) {
                int i4 = iArr[i2];
                if (i4 == 1) {
                    D0(arrayMap, arrayMap2);
                } else if (i4 == 2) {
                    F0(arrayMap, arrayMap2, transitionValuesMaps.f16100d, transitionValuesMaps2.f16100d);
                } else if (i4 == 3) {
                    C0(arrayMap, arrayMap2, transitionValuesMaps.f16098b, transitionValuesMaps2.f16098b);
                } else if (i4 == 4) {
                    E0(arrayMap, arrayMap2, transitionValuesMaps.f16099c, transitionValuesMaps2.f16099c);
                }
                i2++;
            } else {
                h(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private void H0(Transition transition, TransitionNotification transitionNotification, boolean z) {
        Transition transition2 = this.v3;
        if (transition2 != null) {
            transition2.H0(transition, transitionNotification, z);
        }
        ArrayList<TransitionListener> arrayList = this.w3;
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.w3.size();
            TransitionListener[] transitionListenerArr = this.o3;
            if (transitionListenerArr == null) {
                transitionListenerArr = new TransitionListener[size];
            }
            this.o3 = null;
            TransitionListener[] transitionListenerArr2 = (TransitionListener[]) this.w3.toArray(transitionListenerArr);
            for (int i2 = 0; i2 < size; i2++) {
                transitionNotification.a(transitionListenerArr2[i2], transition, z);
                transitionListenerArr2[i2] = null;
            }
            this.o3 = transitionListenerArr2;
        }
    }

    private ArrayList<Class<?>> K(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls != null) {
            return z ? ArrayListManager.a(arrayList, cls) : ArrayListManager.b(arrayList, cls);
        }
        return arrayList;
    }

    private ArrayList<View> L(ArrayList<View> arrayList, View view, boolean z) {
        if (view != null) {
            return z ? ArrayListManager.a(arrayList, view) : ArrayListManager.b(arrayList, view);
        }
        return arrayList;
    }

    private static int[] L0(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if (O3.equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if (R3.equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i2++;
        }
        return iArr;
    }

    private void e1(Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    arrayMap.remove(animator);
                    Transition.this.q3.remove(animator);
                }

                public void onAnimationStart(Animator animator) {
                    Transition.this.q3.add(animator);
                }
            });
            m(animator);
        }
    }

    private static ArrayMap<Animator, AnimationInfo> g0() {
        ArrayMap<Animator, AnimationInfo> arrayMap = U3.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
        U3.set(arrayMap2);
        return arrayMap2;
    }

    private void h(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i2 = 0; i2 < arrayMap.size(); i2++) {
            TransitionValues m2 = arrayMap.m(i2);
            if (y0(m2.f16095b)) {
                this.m3.add(m2);
                this.n3.add((Object) null);
            }
        }
        for (int i4 = 0; i4 < arrayMap2.size(); i4++) {
            TransitionValues m4 = arrayMap2.m(i4);
            if (y0(m4.f16095b)) {
                this.n3.add(m4);
                this.m3.add((Object) null);
            }
        }
    }

    private static void i(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.f16097a.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            if (transitionValuesMaps.f16098b.indexOfKey(id) >= 0) {
                transitionValuesMaps.f16098b.put(id, (Object) null);
            } else {
                transitionValuesMaps.f16098b.put(id, view);
            }
        }
        String A0 = ViewCompat.A0(view);
        if (A0 != null) {
            if (transitionValuesMaps.f16100d.containsKey(A0)) {
                transitionValuesMaps.f16100d.put(A0, null);
            } else {
                transitionValuesMaps.f16100d.put(A0, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (transitionValuesMaps.f16099c.l(itemIdAtPosition) >= 0) {
                    View h2 = transitionValuesMaps.f16099c.h(itemIdAtPosition);
                    if (h2 != null) {
                        h2.setHasTransientState(false);
                        transitionValuesMaps.f16099c.p(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                transitionValuesMaps.f16099c.p(itemIdAtPosition, view);
            }
        }
    }

    private static boolean l(int[] iArr, int i2) {
        int i4 = iArr[i2];
        for (int i5 = 0; i5 < i2; i5++) {
            if (iArr[i5] == i4) {
                return true;
            }
        }
        return false;
    }

    private void o(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            ArrayList<Integer> arrayList = this.b3;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
                ArrayList<View> arrayList2 = this.c3;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.d3;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            if (!this.d3.get(i2).isInstance(view)) {
                                i2++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues(view);
                        if (z) {
                            q(transitionValues);
                        } else {
                            n(transitionValues);
                        }
                        transitionValues.f16096c.add(this);
                        p(transitionValues);
                        i(z ? this.i3 : this.j3, view, transitionValues);
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.f3;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                            ArrayList<View> arrayList5 = this.g3;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.h3;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i4 = 0;
                                    while (i4 < size2) {
                                        if (!this.h3.get(i4).isInstance(view)) {
                                            i4++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                                    o(viewGroup.getChildAt(i5), z);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static boolean w0(int i2) {
        return i2 >= 1 && i2 <= 4;
    }

    private static boolean z0(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.f16094a.get(str);
        Object obj2 = transitionValues2.f16094a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    @NonNull
    public Transition A(@NonNull Class<?> cls, boolean z) {
        this.h3 = K(this.h3, cls, z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public String A1(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.Y != -1) {
            sb.append("dur(");
            sb.append(this.Y);
            sb.append(") ");
        }
        if (this.X != -1) {
            sb.append("dly(");
            sb.append(this.X);
            sb.append(") ");
        }
        if (this.Z != null) {
            sb.append("interp(");
            sb.append(this.Z);
            sb.append(") ");
        }
        if (this.X2.size() > 0 || this.Y2.size() > 0) {
            sb.append("tgts(");
            if (this.X2.size() > 0) {
                for (int i2 = 0; i2 < this.X2.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.X2.get(i2));
                }
            }
            if (this.Y2.size() > 0) {
                for (int i4 = 0; i4 < this.Y2.size(); i4++) {
                    if (i4 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.Y2.get(i4));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    @NonNull
    public Transition E(@IdRes int i2, boolean z) {
        this.b3 = B(this.b3, i2, z);
        return this;
    }

    @NonNull
    public Transition F(@NonNull View view, boolean z) {
        this.c3 = L(this.c3, view, z);
        return this;
    }

    @NonNull
    public Transition G(@NonNull Class<?> cls, boolean z) {
        this.d3 = K(this.d3, cls, z);
        return this;
    }

    @NonNull
    public Transition J(@NonNull String str, boolean z) {
        this.e3 = D(this.e3, str, z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void K0(TransitionNotification transitionNotification, boolean z) {
        H0(this, transitionNotification, z);
    }

    /* access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void M(@Nullable ViewGroup viewGroup) {
        ArrayMap<Animator, AnimationInfo> g0 = g0();
        int size = g0.size();
        if (viewGroup != null && size != 0) {
            WindowId windowId = viewGroup.getWindowId();
            ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) g0);
            g0.clear();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                AnimationInfo animationInfo = (AnimationInfo) arrayMap.m(i2);
                if (animationInfo.f16069a != null && windowId.equals(animationInfo.f16072d)) {
                    ((Animator) arrayMap.i(i2)).end();
                }
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void M0(@Nullable View view) {
        if (!this.u3) {
            int size = this.q3.size();
            Animator[] animatorArr = (Animator[]) this.q3.toArray(this.r3);
            this.r3 = G3;
            for (int i2 = size - 1; i2 >= 0; i2--) {
                Animator animator = animatorArr[i2];
                animatorArr[i2] = null;
                animator.pause();
            }
            this.r3 = animatorArr;
            K0(TransitionNotification.f16078d, false);
            this.t3 = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void O0(@NonNull ViewGroup viewGroup) {
        AnimationInfo animationInfo;
        this.m3 = new ArrayList<>();
        this.n3 = new ArrayList<>();
        G0(this.i3, this.j3);
        ArrayMap<Animator, AnimationInfo> g0 = g0();
        int size = g0.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator i4 = g0.i(i2);
            if (!(i4 == null || (animationInfo = g0.get(i4)) == null || animationInfo.f16069a == null || !windowId.equals(animationInfo.f16072d))) {
                TransitionValues transitionValues = animationInfo.f16071c;
                View view = animationInfo.f16069a;
                TransitionValues s0 = s0(view, true);
                TransitionValues X3 = X(view, true);
                if (s0 == null && X3 == null) {
                    X3 = this.j3.f16097a.get(view);
                }
                if (!(s0 == null && X3 == null) && animationInfo.f16073e.v0(transitionValues, X3)) {
                    Transition transition = animationInfo.f16073e;
                    if (transition.f0().D3 != null) {
                        i4.cancel();
                        transition.q3.remove(i4);
                        g0.remove(i4);
                        if (transition.q3.size() == 0) {
                            transition.K0(TransitionNotification.f16077c, false);
                            if (!transition.u3) {
                                transition.u3 = true;
                                transition.K0(TransitionNotification.f16076b, false);
                            }
                        }
                    } else if (i4.isRunning() || i4.isStarted()) {
                        i4.cancel();
                    } else {
                        g0.remove(i4);
                    }
                }
            }
        }
        v(viewGroup, this.i3, this.j3, this.m3, this.n3);
        if (this.D3 == null) {
            g1();
        } else if (Build.VERSION.SDK_INT >= 34) {
            R0();
            this.D3.x();
            this.D3.z();
        }
    }

    public long Q() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    public void R0() {
        ArrayMap<Animator, AnimationInfo> g0 = g0();
        this.C3 = 0;
        for (int i2 = 0; i2 < this.x3.size(); i2++) {
            Animator animator = this.x3.get(i2);
            AnimationInfo animationInfo = g0.get(animator);
            if (!(animator == null || animationInfo == null)) {
                if (Q() >= 0) {
                    animationInfo.f16074f.setDuration(Q());
                }
                if (h0() >= 0) {
                    animationInfo.f16074f.setStartDelay(h0() + animationInfo.f16074f.getStartDelay());
                }
                if (V() != null) {
                    animationInfo.f16074f.setInterpolator(V());
                }
                this.q3.add(animator);
                this.C3 = Math.max(this.C3, Impl26.a(animator));
            }
        }
        this.x3.clear();
    }

    @Nullable
    public Rect S() {
        EpicenterCallback epicenterCallback = this.z3;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.a(this);
    }

    @NonNull
    public Transition S0(@NonNull TransitionListener transitionListener) {
        Transition transition;
        ArrayList<TransitionListener> arrayList = this.w3;
        if (arrayList == null) {
            return this;
        }
        if (!arrayList.remove(transitionListener) && (transition = this.v3) != null) {
            transition.S0(transitionListener);
        }
        if (this.w3.size() == 0) {
            this.w3 = null;
        }
        return this;
    }

    @Nullable
    public EpicenterCallback U() {
        return this.z3;
    }

    @Nullable
    public TimeInterpolator V() {
        return this.Z;
    }

    @NonNull
    public Transition W0(@IdRes int i2) {
        if (i2 != 0) {
            this.X2.remove(Integer.valueOf(i2));
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public TransitionValues X(View view, boolean z) {
        TransitionSet transitionSet = this.k3;
        if (transitionSet != null) {
            return transitionSet.X(view, z);
        }
        ArrayList<TransitionValues> arrayList = z ? this.m3 : this.n3;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            }
            TransitionValues transitionValues = arrayList.get(i2);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.f16095b == view) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            return null;
        }
        return (z ? this.n3 : this.m3).get(i2);
    }

    @NonNull
    public String Y() {
        return this.s;
    }

    @NonNull
    public Transition Y0(@NonNull View view) {
        this.Y2.remove(view);
        return this;
    }

    @NonNull
    public PathMotion b0() {
        return this.B3;
    }

    @NonNull
    public Transition b1(@NonNull Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.a3;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    @NonNull
    public Transition c(@NonNull TransitionListener transitionListener) {
        if (this.w3 == null) {
            this.w3 = new ArrayList<>();
        }
        this.w3.add(transitionListener);
        return this;
    }

    @Nullable
    public TransitionPropagation c0() {
        return this.y3;
    }

    @NonNull
    public Transition c1(@NonNull String str) {
        ArrayList<String> arrayList = this.Z2;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void cancel() {
        int size = this.q3.size();
        Animator[] animatorArr = (Animator[]) this.q3.toArray(this.r3);
        this.r3 = G3;
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator animator = animatorArr[i2];
            animatorArr[i2] = null;
            animator.cancel();
        }
        this.r3 = animatorArr;
        K0(TransitionNotification.f16077c, false);
    }

    @NonNull
    public Transition d(@IdRes int i2) {
        if (i2 != 0) {
            this.X2.add(Integer.valueOf(i2));
        }
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void d1(@Nullable View view) {
        if (this.t3) {
            if (!this.u3) {
                int size = this.q3.size();
                Animator[] animatorArr = (Animator[]) this.q3.toArray(this.r3);
                this.r3 = G3;
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    Animator animator = animatorArr[i2];
                    animatorArr[i2] = null;
                    animator.resume();
                }
                this.r3 = animatorArr;
                K0(TransitionNotification.f16079e, false);
            }
            this.t3 = false;
        }
    }

    @NonNull
    public Transition e(@NonNull View view) {
        this.Y2.add(view);
        return this;
    }

    @NonNull
    public Transition f(@NonNull Class<?> cls) {
        if (this.a3 == null) {
            this.a3 = new ArrayList<>();
        }
        this.a3.add(cls);
        return this;
    }

    @NonNull
    public final Transition f0() {
        TransitionSet transitionSet = this.k3;
        return transitionSet != null ? transitionSet.f0() : this;
    }

    @NonNull
    public Transition g(@NonNull String str) {
        if (this.Z2 == null) {
            this.Z2 = new ArrayList<>();
        }
        this.Z2.add(str);
        return this;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void g1() {
        z1();
        ArrayMap<Animator, AnimationInfo> g0 = g0();
        Iterator<Animator> it2 = this.x3.iterator();
        while (it2.hasNext()) {
            Animator next = it2.next();
            if (g0.containsKey(next)) {
                z1();
                e1(next, g0);
            }
        }
        this.x3.clear();
        x();
    }

    public long h0() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public void h1(boolean z) {
        this.p3 = z;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    public void j1(long j2, long j4) {
        long j5 = j2;
        long q0 = q0();
        int i2 = 0;
        boolean z = j5 < j4;
        int i4 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
        if ((i4 < 0 && j5 >= 0) || (j4 > q0 && j5 <= q0)) {
            this.u3 = false;
            K0(TransitionNotification.f16075a, z);
        }
        int size = this.q3.size();
        Animator[] animatorArr = (Animator[]) this.q3.toArray(this.r3);
        this.r3 = G3;
        while (i2 < size) {
            Animator animator = animatorArr[i2];
            animatorArr[i2] = null;
            Impl26.b(animator, Math.min(Math.max(0, j5), Impl26.a(animator)));
            i2++;
            z = z;
        }
        boolean z2 = z;
        this.r3 = animatorArr;
        int i5 = (j5 > q0 ? 1 : (j5 == q0 ? 0 : -1));
        if ((i5 > 0 && j4 <= q0) || (j5 < 0 && i4 >= 0)) {
            if (i5 > 0) {
                this.u3 = true;
            }
            K0(TransitionNotification.f16076b, z2);
        }
    }

    @NonNull
    public List<Integer> k0() {
        return this.X2;
    }

    @NonNull
    public Transition k1(long j2) {
        this.Y = j2;
        return this;
    }

    @Nullable
    public List<String> l0() {
        return this.Z2;
    }

    public void l1(@Nullable EpicenterCallback epicenterCallback) {
        this.z3 = epicenterCallback;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void m(@Nullable Animator animator) {
        if (animator == null) {
            x();
            return;
        }
        if (Q() >= 0) {
            animator.setDuration(Q());
        }
        if (h0() >= 0) {
            animator.setStartDelay(h0() + animator.getStartDelay());
        }
        if (V() != null) {
            animator.setInterpolator(V());
        }
        animator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                Transition.this.x();
                animator.removeListener(this);
            }
        });
        animator.start();
    }

    public abstract void n(@NonNull TransitionValues transitionValues);

    @Nullable
    public List<Class<?>> n0() {
        return this.a3;
    }

    @NonNull
    public List<View> o0() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public void p(TransitionValues transitionValues) {
        String[] b2;
        if (this.y3 != null && !transitionValues.f16094a.isEmpty() && (b2 = this.y3.b()) != null) {
            for (String containsKey : b2) {
                if (!transitionValues.f16094a.containsKey(containsKey)) {
                    this.y3.a(transitionValues);
                    return;
                }
            }
        }
    }

    public abstract void q(@NonNull TransitionValues transitionValues);

    /* access modifiers changed from: package-private */
    public final long q0() {
        return this.C3;
    }

    /* access modifiers changed from: package-private */
    public void r(@NonNull ViewGroup viewGroup, boolean z) {
        ArrayMap<String, String> arrayMap;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        s(z);
        if ((this.X2.size() > 0 || this.Y2.size() > 0) && (((arrayList = this.Z2) == null || arrayList.isEmpty()) && ((arrayList2 = this.a3) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.X2.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.X2.get(i2).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z) {
                        q(transitionValues);
                    } else {
                        n(transitionValues);
                    }
                    transitionValues.f16096c.add(this);
                    p(transitionValues);
                    i(z ? this.i3 : this.j3, findViewById, transitionValues);
                }
            }
            for (int i4 = 0; i4 < this.Y2.size(); i4++) {
                View view = this.Y2.get(i4);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z) {
                    q(transitionValues2);
                } else {
                    n(transitionValues2);
                }
                transitionValues2.f16096c.add(this);
                p(transitionValues2);
                i(z ? this.i3 : this.j3, view, transitionValues2);
            }
        } else {
            o(viewGroup, z);
        }
        if (!z && (arrayMap = this.A3) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i5 = 0; i5 < size; i5++) {
                arrayList3.add(this.i3.f16100d.remove(this.A3.i(i5)));
            }
            for (int i6 = 0; i6 < size; i6++) {
                View view2 = (View) arrayList3.get(i6);
                if (view2 != null) {
                    this.i3.f16100d.put(this.A3.m(i6), view2);
                }
            }
        }
    }

    @Nullable
    public String[] r0() {
        return null;
    }

    @NonNull
    public Transition r1(@Nullable TimeInterpolator timeInterpolator) {
        this.Z = timeInterpolator;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void s(boolean z) {
        TransitionValuesMaps transitionValuesMaps;
        if (z) {
            this.i3.f16097a.clear();
            this.i3.f16098b.clear();
            transitionValuesMaps = this.i3;
        } else {
            this.j3.f16097a.clear();
            this.j3.f16098b.clear();
            transitionValuesMaps = this.j3;
        }
        transitionValuesMaps.f16099c.b();
    }

    @Nullable
    public TransitionValues s0(@NonNull View view, boolean z) {
        TransitionSet transitionSet = this.k3;
        if (transitionSet != null) {
            return transitionSet.s0(view, z);
        }
        return (z ? this.i3 : this.j3).f16097a.get(view);
    }

    @NonNull
    /* renamed from: t */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.x3 = new ArrayList<>();
            transition.i3 = new TransitionValuesMaps();
            transition.j3 = new TransitionValuesMaps();
            transition.m3 = null;
            transition.n3 = null;
            transition.D3 = null;
            transition.v3 = this;
            transition.w3 = null;
            return transition;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean t0() {
        return !this.q3.isEmpty();
    }

    public void t1(@Nullable int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.l3 = S3;
            return;
        }
        int i2 = 0;
        while (i2 < iArr.length) {
            if (!w0(iArr[i2])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!l(iArr, i2)) {
                i2++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.l3 = (int[]) iArr.clone();
    }

    @NonNull
    public String toString() {
        return A1("");
    }

    @Nullable
    public Animator u(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        return null;
    }

    public boolean u0() {
        return false;
    }

    public void u1(@Nullable PathMotion pathMotion) {
        if (pathMotion == null) {
            pathMotion = T3;
        }
        this.B3 = pathMotion;
    }

    /* access modifiers changed from: package-private */
    public void v(@NonNull ViewGroup viewGroup, @NonNull TransitionValuesMaps transitionValuesMaps, @NonNull TransitionValuesMaps transitionValuesMaps2, @NonNull ArrayList<TransitionValues> arrayList, @NonNull ArrayList<TransitionValues> arrayList2) {
        int i2;
        int i4;
        Animator u;
        AnimatorSet animatorSet;
        TransitionValues transitionValues;
        View view;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, AnimationInfo> g0 = g0();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        boolean z = f0().D3 != null;
        long j2 = Long.MAX_VALUE;
        int i5 = 0;
        while (i5 < size) {
            TransitionValues transitionValues2 = arrayList.get(i5);
            TransitionValues transitionValues3 = arrayList2.get(i5);
            if (transitionValues2 != null && !transitionValues2.f16096c.contains(this)) {
                transitionValues2 = null;
            }
            if (transitionValues3 != null && !transitionValues3.f16096c.contains(this)) {
                transitionValues3 = null;
            }
            if (!(transitionValues2 == null && transitionValues3 == null) && ((transitionValues2 == null || transitionValues3 == null || v0(transitionValues2, transitionValues3)) && (u = u(viewGroup2, transitionValues2, transitionValues3)) != null)) {
                if (transitionValues3 != null) {
                    view = transitionValues3.f16095b;
                    String[] r0 = r0();
                    Animator animator = u;
                    if (r0 != null && r0.length > 0) {
                        transitionValues = new TransitionValues(view);
                        i4 = size;
                        TransitionValues transitionValues4 = transitionValuesMaps2.f16097a.get(view);
                        if (transitionValues4 != null) {
                            int i6 = 0;
                            while (i6 < r0.length) {
                                Map<String, Object> map = transitionValues.f16094a;
                                int i7 = i5;
                                String str = r0[i6];
                                map.put(str, transitionValues4.f16094a.get(str));
                                i6++;
                                i5 = i7;
                                r0 = r0;
                            }
                        }
                        i2 = i5;
                        int size2 = g0.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size2) {
                                break;
                            }
                            AnimationInfo animationInfo = g0.get(g0.i(i8));
                            if (animationInfo.f16071c != null && animationInfo.f16069a == view && animationInfo.f16070b.equals(Y()) && animationInfo.f16071c.equals(transitionValues)) {
                                animator = null;
                                break;
                            }
                            i8++;
                        }
                    } else {
                        i4 = size;
                        i2 = i5;
                        transitionValues = null;
                    }
                    animatorSet = animator;
                } else {
                    i4 = size;
                    i2 = i5;
                    view = transitionValues2.f16095b;
                    animatorSet = u;
                    transitionValues = null;
                }
                if (animatorSet != null) {
                    TransitionPropagation transitionPropagation = this.y3;
                    if (transitionPropagation != null) {
                        long c2 = transitionPropagation.c(viewGroup2, this, transitionValues2, transitionValues3);
                        sparseIntArray.put(this.x3.size(), (int) c2);
                        j2 = Math.min(c2, j2);
                    }
                    long j4 = j2;
                    AnimationInfo animationInfo2 = new AnimationInfo(view, Y(), this, viewGroup.getWindowId(), transitionValues, animatorSet);
                    if (z) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.play(animatorSet);
                        animatorSet = animatorSet2;
                    }
                    g0.put(animatorSet, animationInfo2);
                    this.x3.add(animatorSet);
                    j2 = j4;
                }
            } else {
                i4 = size;
                i2 = i5;
            }
            i5 = i2 + 1;
            size = i4;
        }
        if (sparseIntArray.size() != 0) {
            for (int i9 = 0; i9 < sparseIntArray.size(); i9++) {
                AnimationInfo animationInfo3 = g0.get(this.x3.get(sparseIntArray.keyAt(i9)));
                animationInfo3.f16074f.setStartDelay((((long) sparseIntArray.valueAt(i9)) - j2) + animationInfo3.f16074f.getStartDelay());
            }
        }
    }

    public boolean v0(@Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] r0 = r0();
        if (r0 != null) {
            int length = r0.length;
            int i2 = 0;
            while (i2 < length) {
                if (!z0(transitionValues, transitionValues2, r0[i2])) {
                    i2++;
                }
            }
            return false;
        }
        for (String z0 : transitionValues.f16094a.keySet()) {
            if (z0(transitionValues, transitionValues2, z0)) {
            }
        }
        return false;
        return true;
    }

    /* access modifiers changed from: package-private */
    @RequiresApi(34)
    @NonNull
    public TransitionSeekController w() {
        SeekController seekController = new SeekController();
        this.D3 = seekController;
        c(seekController);
        return this.D3;
    }

    public void w1(@Nullable TransitionPropagation transitionPropagation) {
        this.y3 = transitionPropagation;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void x() {
        int i2 = this.s3 - 1;
        this.s3 = i2;
        if (i2 == 0) {
            K0(TransitionNotification.f16076b, false);
            for (int i4 = 0; i4 < this.i3.f16099c.y(); i4++) {
                View z = this.i3.f16099c.z(i4);
                if (z != null) {
                    z.setHasTransientState(false);
                }
            }
            for (int i5 = 0; i5 < this.j3.f16099c.y(); i5++) {
                View z2 = this.j3.f16099c.z(i5);
                if (z2 != null) {
                    z2.setHasTransientState(false);
                }
            }
            this.u3 = true;
        }
    }

    @NonNull
    public Transition y(@IdRes int i2, boolean z) {
        this.f3 = B(this.f3, i2, z);
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean y0(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.b3;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.c3;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.d3;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.d3.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.e3 != null && ViewCompat.A0(view) != null && this.e3.contains(ViewCompat.A0(view))) {
            return false;
        }
        if ((this.X2.size() == 0 && this.Y2.size() == 0 && (((arrayList = this.a3) == null || arrayList.isEmpty()) && ((arrayList2 = this.Z2) == null || arrayList2.isEmpty()))) || this.X2.contains(Integer.valueOf(id)) || this.Y2.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.Z2;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.A0(view))) {
            return true;
        }
        if (this.a3 != null) {
            for (int i4 = 0; i4 < this.a3.size(); i4++) {
                if (this.a3.get(i4).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NonNull
    public Transition y1(long j2) {
        this.X = j2;
        return this;
    }

    @NonNull
    public Transition z(@NonNull View view, boolean z) {
        this.g3 = L(this.g3, view, z);
        return this;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void z1() {
        if (this.s3 == 0) {
            K0(TransitionNotification.f16075a, false);
            this.u3 = false;
        }
        this.s3++;
    }

    public Transition(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f16036c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long k2 = (long) TypedArrayUtils.k(obtainStyledAttributes, xmlResourceParser, TypedValues.TransitionType.f4025b, 1, -1);
        if (k2 >= 0) {
            k1(k2);
        }
        long k4 = (long) TypedArrayUtils.k(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (k4 > 0) {
            y1(k4);
        }
        int l2 = TypedArrayUtils.l(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (l2 > 0) {
            r1(AnimationUtils.loadInterpolator(context, l2));
        }
        String m2 = TypedArrayUtils.m(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (m2 != null) {
            t1(L0(m2));
        }
        obtainStyledAttributes.recycle();
    }
}
