package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7849a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.fragment.app.SpecialEffectsController$Operation$State[] r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7849a = r0
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7849a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.INVISIBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7849a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.REMOVED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7849a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.AnonymousClass10.<clinit>():void");
        }
    }

    private static class AnimationInfo extends SpecialEffectsInfo {

        /* renamed from: c  reason: collision with root package name */
        private boolean f7863c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f7864d = false;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private FragmentAnim.AnimationOrAnimator f7865e;

        AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.f7863c = z;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public FragmentAnim.AnimationOrAnimator e(@NonNull Context context) {
            if (this.f7864d) {
                return this.f7865e;
            }
            FragmentAnim.AnimationOrAnimator b2 = FragmentAnim.b(context, b().f(), b().e() == SpecialEffectsController.Operation.State.VISIBLE, this.f7863c);
            this.f7865e = b2;
            this.f7864d = true;
            return b2;
        }
    }

    private static class SpecialEffectsInfo {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final SpecialEffectsController.Operation f7866a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final CancellationSignal f7867b;

        SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.f7866a = operation;
            this.f7867b = cancellationSignal;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f7866a.d(this.f7867b);
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public SpecialEffectsController.Operation b() {
            return this.f7866a;
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public CancellationSignal c() {
            return this.f7867b;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
            r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.X;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d() {
            /*
                r3 = this;
                androidx.fragment.app.SpecialEffectsController$Operation r0 = r3.f7866a
                androidx.fragment.app.Fragment r0 = r0.f()
                android.view.View r0 = r0.B3
                androidx.fragment.app.SpecialEffectsController$Operation$State r0 = androidx.fragment.app.SpecialEffectsController.Operation.State.c(r0)
                androidx.fragment.app.SpecialEffectsController$Operation r1 = r3.f7866a
                androidx.fragment.app.SpecialEffectsController$Operation$State r1 = r1.e()
                if (r0 == r1) goto L_0x001d
                androidx.fragment.app.SpecialEffectsController$Operation$State r2 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
                if (r0 == r2) goto L_0x001b
                if (r1 == r2) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                r0 = 0
                goto L_0x001e
            L_0x001d:
                r0 = 1
            L_0x001e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.SpecialEffectsInfo.d():boolean");
        }
    }

    private static class TransitionInfo extends SpecialEffectsInfo {
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final Object f7868c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f7869d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private final Object f7870e;

        TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            boolean z3;
            Object obj;
            if (operation.e() == SpecialEffectsController.Operation.State.VISIBLE) {
                Fragment f2 = operation.f();
                this.f7868c = z ? f2.a0() : f2.E();
                Fragment f3 = operation.f();
                z3 = z ? f3.v() : f3.u();
            } else {
                Fragment f4 = operation.f();
                this.f7868c = z ? f4.d0() : f4.J();
                z3 = true;
            }
            this.f7869d = z3;
            if (z2) {
                Fragment f5 = operation.f();
                obj = z ? f5.f0() : f5.e0();
            } else {
                obj = null;
            }
            this.f7870e = obj;
        }

        @Nullable
        private FragmentTransitionImpl f(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.f8017a;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.e(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.f8018b;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.e(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public FragmentTransitionImpl e() {
            FragmentTransitionImpl f2 = f(this.f7868c);
            FragmentTransitionImpl f3 = f(this.f7870e);
            if (f2 == null || f3 == null || f2 == f3) {
                return f2 != null ? f2 : f3;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f7868c + " which uses a different Transition  type than its shared element transition " + this.f7870e);
        }

        @Nullable
        public Object g() {
            return this.f7870e;
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public Object h() {
            return this.f7868c;
        }

        public boolean i() {
            return this.f7870e != null;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.f7869d;
        }
    }

    DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        int i2;
        Context context;
        boolean z2;
        View view;
        StringBuilder sb;
        String str;
        FragmentAnim.AnimationOrAnimator e2;
        final SpecialEffectsController.Operation operation;
        ViewGroup m2 = m();
        Context context2 = m2.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<AnimationInfo> it2 = list.iterator();
        boolean z3 = false;
        while (true) {
            i2 = 2;
            if (!it2.hasNext()) {
                break;
            }
            AnimationInfo next = it2.next();
            if (!next.d() && (e2 = next.e(context2)) != null) {
                Animator animator = e2.f7899b;
                if (animator == null) {
                    arrayList.add(next);
                } else {
                    SpecialEffectsController.Operation b2 = next.b();
                    Fragment f2 = b2.f();
                    if (Boolean.TRUE.equals(map.get(b2))) {
                        if (FragmentManager.W0(2)) {
                            Log.v(FragmentManager.Y, "Ignoring Animator set on " + f2 + " as this Fragment was involved in a Transition.");
                        }
                        next.a();
                    } else {
                        boolean z4 = b2.e() == SpecialEffectsController.Operation.State.GONE;
                        List<SpecialEffectsController.Operation> list3 = list2;
                        if (z4) {
                            list3.remove(b2);
                        }
                        View view2 = f2.B3;
                        m2.startViewTransition(view2);
                        AnonymousClass2 r20 = r0;
                        View view3 = view2;
                        final ViewGroup viewGroup = m2;
                        final View view4 = view3;
                        SpecialEffectsController.Operation operation2 = b2;
                        final boolean z5 = z4;
                        Animator animator2 = animator;
                        final SpecialEffectsController.Operation operation3 = operation2;
                        final Animator animator3 = animator2;
                        final AnimationInfo animationInfo = next;
                        AnonymousClass2 r0 = new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                viewGroup.endViewTransition(view4);
                                if (z5) {
                                    operation3.e().a(view4);
                                }
                                animationInfo.a();
                                if (FragmentManager.W0(2)) {
                                    Log.v(FragmentManager.Y, "Animator from operation " + operation3 + " has ended.");
                                }
                            }
                        };
                        animator3.addListener(r0);
                        animator3.setTarget(view3);
                        animator3.start();
                        if (FragmentManager.W0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Animator from operation ");
                            operation = operation2;
                            sb2.append(operation);
                            sb2.append(" has started.");
                            Log.v(FragmentManager.Y, sb2.toString());
                        } else {
                            operation = operation2;
                        }
                        next.c().d(new CancellationSignal.OnCancelListener() {
                            public void onCancel() {
                                animator3.end();
                                if (FragmentManager.W0(2)) {
                                    Log.v(FragmentManager.Y, "Animator from operation " + operation + " has been canceled.");
                                }
                            }
                        });
                        z3 = true;
                    }
                }
            } else {
                next.a();
            }
            Map<SpecialEffectsController.Operation, Boolean> map2 = map;
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            AnimationInfo animationInfo2 = (AnimationInfo) it3.next();
            SpecialEffectsController.Operation b3 = animationInfo2.b();
            Fragment f3 = b3.f();
            if (z) {
                if (FragmentManager.W0(i2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(f3);
                    str = " as Animations cannot run alongside Transitions.";
                }
                animationInfo2.a();
            } else if (z3) {
                if (FragmentManager.W0(i2)) {
                    sb = new StringBuilder();
                    sb.append("Ignoring Animation set on ");
                    sb.append(f3);
                    str = " as Animations cannot run alongside Animators.";
                }
                animationInfo2.a();
            } else {
                View view5 = f3.B3;
                Animation animation = (Animation) Preconditions.l(((FragmentAnim.AnimationOrAnimator) Preconditions.l(animationInfo2.e(context2))).f7898a);
                if (b3.e() != SpecialEffectsController.Operation.State.REMOVED) {
                    view5.startAnimation(animation);
                    animationInfo2.a();
                    z2 = z3;
                    context = context2;
                    view = view5;
                } else {
                    m2.startViewTransition(view5);
                    final SpecialEffectsController.Operation operation4 = b3;
                    AnonymousClass4 r14 = r0;
                    final ViewGroup viewGroup2 = m2;
                    z2 = z3;
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation, m2, view5);
                    final View view6 = view5;
                    context = context2;
                    view = view5;
                    final AnimationInfo animationInfo3 = animationInfo2;
                    AnonymousClass4 r02 = new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            viewGroup2.post(new Runnable() {
                                public void run() {
                                    AnonymousClass4 r0 = AnonymousClass4.this;
                                    viewGroup2.endViewTransition(view6);
                                    animationInfo3.a();
                                }
                            });
                            if (FragmentManager.W0(2)) {
                                Log.v(FragmentManager.Y, "Animation from operation " + operation4 + " has ended.");
                            }
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                            if (FragmentManager.W0(2)) {
                                Log.v(FragmentManager.Y, "Animation from operation " + operation4 + " has reached onAnimationStart.");
                            }
                        }
                    };
                    endViewTransitionAnimation.setAnimationListener(r14);
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.W0(2)) {
                        Log.v(FragmentManager.Y, "Animation from operation " + b3 + " has started.");
                    }
                }
                CancellationSignal c2 = animationInfo2.c();
                final View view7 = view;
                final ViewGroup viewGroup3 = m2;
                final AnimationInfo animationInfo4 = animationInfo2;
                AnonymousClass5 r8 = r0;
                final SpecialEffectsController.Operation operation5 = b3;
                AnonymousClass5 r03 = new CancellationSignal.OnCancelListener() {
                    public void onCancel() {
                        view7.clearAnimation();
                        viewGroup3.endViewTransition(view7);
                        animationInfo4.a();
                        if (FragmentManager.W0(2)) {
                            Log.v(FragmentManager.Y, "Animation from operation " + operation5 + " has been cancelled.");
                        }
                    }
                };
                c2.d(r8);
                z3 = z2;
                context2 = context;
                i2 = 2;
            }
            sb.append(str);
            Log.v(FragmentManager.Y, sb.toString());
            animationInfo2.a();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: android.view.View} */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0336, code lost:
        r1 = (android.view.View) r13.get(r10.get(r0));
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<androidx.fragment.app.SpecialEffectsController.Operation, java.lang.Boolean> x(@androidx.annotation.NonNull java.util.List<androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo> r34, @androidx.annotation.NonNull java.util.List<androidx.fragment.app.SpecialEffectsController.Operation> r35, boolean r36, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation r37, @androidx.annotation.Nullable androidx.fragment.app.SpecialEffectsController.Operation r38) {
        /*
            r33 = this;
            r6 = r33
            r7 = r36
            r8 = r37
            r9 = r38
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.Iterator r0 = r34.iterator()
            r15 = 0
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            boolean r2 = r1.d()
            if (r2 == 0) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            androidx.fragment.app.FragmentTransitionImpl r2 = r1.e()
            if (r15 != 0) goto L_0x002d
            r15 = r2
            goto L_0x0012
        L_0x002d:
            if (r2 == 0) goto L_0x0012
            if (r15 != r2) goto L_0x0032
            goto L_0x0012
        L_0x0032:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Mixing framework transitions and AndroidX transitions is not allowed. Fragment "
            r2.append(r3)
            androidx.fragment.app.SpecialEffectsController$Operation r3 = r1.b()
            androidx.fragment.app.Fragment r3 = r3.f()
            r2.append(r3)
            java.lang.String r3 = " returned Transition "
            r2.append(r3)
            java.lang.Object r1 = r1.h()
            r2.append(r1)
            java.lang.String r1 = " which uses a different Transition  type than other Fragments."
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x0062:
            if (r15 != 0) goto L_0x0082
            java.util.Iterator r0 = r34.iterator()
        L_0x0068:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0081
            java.lang.Object r1 = r0.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            androidx.fragment.app.SpecialEffectsController$Operation r2 = r1.b()
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r10.put(r2, r3)
            r1.a()
            goto L_0x0068
        L_0x0081:
            return r10
        L_0x0082:
            android.view.View r14 = new android.view.View
            android.view.ViewGroup r0 = r33.m()
            android.content.Context r0 = r0.getContext()
            r14.<init>(r0)
            android.graphics.Rect r13 = new android.graphics.Rect
            r13.<init>()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            java.util.Iterator r20 = r34.iterator()
            r0 = 0
            r2 = 0
            r21 = 0
        L_0x00ab:
            boolean r1 = r20.hasNext()
            r22 = 2
            java.lang.String r3 = "FragmentManager"
            if (r1 == 0) goto L_0x03a1
            java.lang.Object r1 = r20.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r1 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r1
            boolean r17 = r1.i()
            if (r17 == 0) goto L_0x0384
            if (r8 == 0) goto L_0x0384
            if (r9 == 0) goto L_0x0384
            java.lang.Object r0 = r1.g()
            java.lang.Object r0 = r15.f(r0)
            java.lang.Object r1 = r15.w(r0)
            androidx.fragment.app.Fragment r0 = r38.f()
            java.util.ArrayList r0 = r0.g0()
            androidx.fragment.app.Fragment r17 = r37.f()
            java.util.ArrayList r11 = r17.g0()
            androidx.fragment.app.Fragment r17 = r37.f()
            r18 = r1
            java.util.ArrayList r1 = r17.h0()
            r17 = r2
            r24 = r10
            r2 = 0
        L_0x00f0:
            int r10 = r1.size()
            if (r2 >= r10) goto L_0x0111
            java.lang.Object r10 = r1.get(r2)
            int r10 = r0.indexOf(r10)
            r19 = r1
            r1 = -1
            if (r10 == r1) goto L_0x010c
            java.lang.Object r1 = r11.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            r0.set(r10, r1)
        L_0x010c:
            int r2 = r2 + 1
            r1 = r19
            goto L_0x00f0
        L_0x0111:
            androidx.fragment.app.Fragment r1 = r38.f()
            java.util.ArrayList r10 = r1.h0()
            androidx.fragment.app.Fragment r1 = r37.f()
            if (r7 != 0) goto L_0x012c
            androidx.core.app.SharedElementCallback r1 = r1.K()
            androidx.fragment.app.Fragment r2 = r38.f()
            androidx.core.app.SharedElementCallback r2 = r2.F()
            goto L_0x0138
        L_0x012c:
            androidx.core.app.SharedElementCallback r1 = r1.F()
            androidx.fragment.app.Fragment r2 = r38.f()
            androidx.core.app.SharedElementCallback r2 = r2.K()
        L_0x0138:
            int r11 = r0.size()
            r19 = r14
            r14 = 0
        L_0x013f:
            if (r14 >= r11) goto L_0x015f
            java.lang.Object r25 = r0.get(r14)
            r26 = r11
            r11 = r25
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r25 = r10.get(r14)
            r27 = r13
            r13 = r25
            java.lang.String r13 = (java.lang.String) r13
            r4.put(r11, r13)
            int r14 = r14 + 1
            r11 = r26
            r13 = r27
            goto L_0x013f
        L_0x015f:
            r27 = r13
            boolean r11 = androidx.fragment.app.FragmentManager.W0(r22)
            if (r11 == 0) goto L_0x01c1
            java.lang.String r11 = ">>> entering view names <<<"
            android.util.Log.v(r3, r11)
            java.util.Iterator r11 = r10.iterator()
        L_0x0170:
            boolean r13 = r11.hasNext()
            java.lang.String r14 = "Name: "
            if (r13 == 0) goto L_0x0195
            java.lang.Object r13 = r11.next()
            java.lang.String r13 = (java.lang.String) r13
            r25 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r14)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            android.util.Log.v(r3, r11)
            r11 = r25
            goto L_0x0170
        L_0x0195:
            java.lang.String r11 = ">>> exiting view names <<<"
            android.util.Log.v(r3, r11)
            java.util.Iterator r11 = r0.iterator()
        L_0x019e:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x01c1
            java.lang.Object r13 = r11.next()
            java.lang.String r13 = (java.lang.String) r13
            r25 = r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r14)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            android.util.Log.v(r3, r11)
            r11 = r25
            goto L_0x019e
        L_0x01c1:
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap
            r11.<init>()
            androidx.fragment.app.Fragment r13 = r37.f()
            android.view.View r13 = r13.B3
            r6.u(r11, r13)
            r11.s(r0)
            if (r1 == 0) goto L_0x022e
            boolean r13 = androidx.fragment.app.FragmentManager.W0(r22)
            if (r13 == 0) goto L_0x01ee
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Executing exit callback for operation "
            r13.append(r14)
            r13.append(r8)
            java.lang.String r13 = r13.toString()
            android.util.Log.v(r3, r13)
        L_0x01ee:
            r1.d(r0, r11)
            int r1 = r0.size()
            r13 = 1
            int r1 = r1 - r13
        L_0x01f7:
            if (r1 < 0) goto L_0x022b
            java.lang.Object r13 = r0.get(r1)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r11.get(r13)
            android.view.View r14 = (android.view.View) r14
            if (r14 != 0) goto L_0x020d
            r4.remove(r13)
            r25 = r0
            goto L_0x0226
        L_0x020d:
            r25 = r0
            java.lang.String r0 = androidx.core.view.ViewCompat.A0(r14)
            boolean r0 = r13.equals(r0)
            if (r0 != 0) goto L_0x0226
            java.lang.Object r0 = r4.remove(r13)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r13 = androidx.core.view.ViewCompat.A0(r14)
            r4.put(r13, r0)
        L_0x0226:
            int r1 = r1 + -1
            r0 = r25
            goto L_0x01f7
        L_0x022b:
            r25 = r0
            goto L_0x0237
        L_0x022e:
            r25 = r0
            java.util.Set r0 = r11.keySet()
            r4.s(r0)
        L_0x0237:
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            androidx.fragment.app.Fragment r0 = r38.f()
            android.view.View r0 = r0.B3
            r6.u(r13, r0)
            r13.s(r10)
            java.util.Collection r0 = r4.values()
            r13.s(r0)
            if (r2 == 0) goto L_0x02a8
            boolean r0 = androidx.fragment.app.FragmentManager.W0(r22)
            if (r0 == 0) goto L_0x026b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Executing enter callback for operation "
            r0.append(r1)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            android.util.Log.v(r3, r0)
        L_0x026b:
            r2.d(r10, r13)
            int r0 = r10.size()
            r1 = 1
            int r0 = r0 - r1
        L_0x0274:
            if (r0 < 0) goto L_0x02ab
            java.lang.Object r1 = r10.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r13.get(r1)
            android.view.View r2 = (android.view.View) r2
            if (r2 != 0) goto L_0x028e
            java.lang.String r1 = androidx.fragment.app.FragmentTransition.b(r4, r1)
            if (r1 == 0) goto L_0x02a5
            r4.remove(r1)
            goto L_0x02a5
        L_0x028e:
            java.lang.String r3 = androidx.core.view.ViewCompat.A0(r2)
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x02a5
            java.lang.String r1 = androidx.fragment.app.FragmentTransition.b(r4, r1)
            if (r1 == 0) goto L_0x02a5
            java.lang.String r2 = androidx.core.view.ViewCompat.A0(r2)
            r4.put(r1, r2)
        L_0x02a5:
            int r0 = r0 + -1
            goto L_0x0274
        L_0x02a8:
            androidx.fragment.app.FragmentTransition.d(r4, r13)
        L_0x02ab:
            java.util.Set r0 = r4.keySet()
            r6.v(r11, r0)
            java.util.Collection r0 = r4.values()
            r6.v(r13, r0)
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L_0x02d8
            r12.clear()
            r5.clear()
            r28 = r4
            r10 = r5
            r4 = r8
            r7 = r12
            r11 = r15
            r2 = r17
            r1 = r19
            r8 = r24
            r5 = r27
            r0 = 0
            r14 = 0
            r15 = r9
            goto L_0x0393
        L_0x02d8:
            androidx.fragment.app.Fragment r0 = r38.f()
            androidx.fragment.app.Fragment r1 = r37.f()
            r14 = 1
            androidx.fragment.app.FragmentTransition.a(r0, r1, r7, r11, r14)
            android.view.ViewGroup r3 = r33.m()
            androidx.fragment.app.DefaultSpecialEffectsController$6 r2 = new androidx.fragment.app.DefaultSpecialEffectsController$6
            r1 = r25
            r0 = r2
            r14 = r18
            r1 = r33
            r7 = r2
            r26 = r17
            r2 = r38
            r9 = r3
            r3 = r37
            r28 = r4
            r4 = r36
            r8 = r5
            r5 = r13
            r0.<init>(r2, r3, r4, r5)
            androidx.core.view.OneShotPreDrawListener.a(r9, r7)
            java.util.Collection r0 = r11.values()
            r12.addAll(r0)
            boolean r0 = r25.isEmpty()
            if (r0 != 0) goto L_0x0326
            r1 = r25
            r0 = 0
            java.lang.Object r1 = r1.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r11.get(r1)
            r2 = r1
            android.view.View r2 = (android.view.View) r2
            r15.r(r14, r2)
            goto L_0x0329
        L_0x0326:
            r0 = 0
            r2 = r26
        L_0x0329:
            java.util.Collection r1 = r13.values()
            r8.addAll(r1)
            boolean r1 = r10.isEmpty()
            if (r1 != 0) goto L_0x0357
            java.lang.Object r1 = r10.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r13.get(r1)
            android.view.View r1 = (android.view.View) r1
            if (r1 == 0) goto L_0x0357
            android.view.ViewGroup r3 = r33.m()
            androidx.fragment.app.DefaultSpecialEffectsController$7 r4 = new androidx.fragment.app.DefaultSpecialEffectsController$7
            r5 = r27
            r4.<init>(r15, r1, r5)
            androidx.core.view.OneShotPreDrawListener.a(r3, r4)
            r1 = r19
            r21 = 1
            goto L_0x035b
        L_0x0357:
            r5 = r27
            r1 = r19
        L_0x035b:
            r15.u(r14, r1, r12)
            r16 = 0
            r17 = 0
            r3 = 0
            r4 = 0
            r7 = r12
            r12 = r15
            r13 = r14
            r9 = r14
            r14 = r3
            r11 = r15
            r15 = r4
            r18 = r9
            r19 = r8
            r12.p(r13, r14, r15, r16, r17, r18, r19)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r4 = r37
            r10 = r8
            r8 = r24
            r8.put(r4, r3)
            r15 = r38
            r14 = 0
            r8.put(r15, r3)
            r0 = r9
            goto L_0x0393
        L_0x0384:
            r26 = r2
            r28 = r4
            r4 = r8
            r8 = r10
            r7 = r12
            r1 = r14
            r11 = r15
            r14 = 0
            r10 = r5
            r15 = r9
            r5 = r13
            r2 = r26
        L_0x0393:
            r14 = r1
            r13 = r5
            r12 = r7
            r5 = r10
            r9 = r15
            r7 = r36
            r10 = r8
            r15 = r11
            r8 = r4
            r4 = r28
            goto L_0x00ab
        L_0x03a1:
            r26 = r2
            r28 = r4
            r4 = r8
            r8 = r10
            r7 = r12
            r1 = r14
            r11 = r15
            r14 = 0
            r10 = r5
            r15 = r9
            r5 = r13
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r9 = r34.iterator()
            r12 = 0
            r13 = 0
        L_0x03b9:
            boolean r16 = r9.hasNext()
            if (r16 == 0) goto L_0x04ec
            java.lang.Object r16 = r9.next()
            r20 = r16
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r20 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r20
            boolean r16 = r20.d()
            if (r16 == 0) goto L_0x03df
            androidx.fragment.app.SpecialEffectsController$Operation r14 = r20.b()
            r36 = r9
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            r8.put(r14, r9)
            r20.a()
            r9 = r36
        L_0x03dd:
            r14 = 0
            goto L_0x03b9
        L_0x03df:
            r36 = r9
            java.lang.Object r9 = r20.h()
            java.lang.Object r9 = r11.f(r9)
            androidx.fragment.app.SpecialEffectsController$Operation r14 = r20.b()
            if (r0 == 0) goto L_0x03f6
            if (r14 == r4) goto L_0x03f3
            if (r14 != r15) goto L_0x03f6
        L_0x03f3:
            r17 = 1
            goto L_0x03f8
        L_0x03f6:
            r17 = 0
        L_0x03f8:
            if (r9 != 0) goto L_0x0418
            if (r17 != 0) goto L_0x0404
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            r8.put(r14, r9)
            r20.a()
        L_0x0404:
            r29 = r1
            r24 = r3
            r30 = r7
            r32 = r10
            r1 = r12
            r7 = r13
            r10 = r15
            r3 = r26
            r13 = 0
            r23 = 1
            r12 = r35
            goto L_0x04db
        L_0x0418:
            r24 = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r18 = r12
            androidx.fragment.app.Fragment r12 = r14.f()
            android.view.View r12 = r12.B3
            r6.t(r3, r12)
            if (r17 == 0) goto L_0x0435
            if (r14 != r4) goto L_0x0432
            r3.removeAll(r7)
            goto L_0x0435
        L_0x0432:
            r3.removeAll(r10)
        L_0x0435:
            boolean r12 = r3.isEmpty()
            if (r12 == 0) goto L_0x044e
            r11.a(r9, r1)
            r12 = r35
            r29 = r1
            r30 = r7
            r32 = r10
            r7 = r13
            r13 = r14
            r10 = r15
            r1 = r18
            r23 = 1
            goto L_0x04ad
        L_0x044e:
            r11.b(r9, r3)
            r19 = 0
            r25 = 0
            r17 = 0
            r27 = 0
            r29 = r1
            r1 = r18
            r12 = r11
            r30 = r7
            r7 = r13
            r13 = r9
            r31 = r14
            r23 = 1
            r14 = r9
            r32 = r10
            r10 = r15
            r15 = r3
            r16 = r17
            r17 = r27
            r18 = r19
            r19 = r25
            r12.p(r13, r14, r15, r16, r17, r18, r19)
            androidx.fragment.app.SpecialEffectsController$Operation$State r12 = r31.e()
            androidx.fragment.app.SpecialEffectsController$Operation$State r13 = androidx.fragment.app.SpecialEffectsController.Operation.State.GONE
            if (r12 != r13) goto L_0x04a9
            r12 = r35
            r13 = r31
            r12.remove(r13)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>(r3)
            androidx.fragment.app.Fragment r15 = r13.f()
            android.view.View r15 = r15.B3
            r14.remove(r15)
            androidx.fragment.app.Fragment r15 = r13.f()
            android.view.View r15 = r15.B3
            r11.o(r9, r15, r14)
            android.view.ViewGroup r14 = r33.m()
            androidx.fragment.app.DefaultSpecialEffectsController$8 r15 = new androidx.fragment.app.DefaultSpecialEffectsController$8
            r15.<init>(r3)
            androidx.core.view.OneShotPreDrawListener.a(r14, r15)
            goto L_0x04ad
        L_0x04a9:
            r12 = r35
            r13 = r31
        L_0x04ad:
            androidx.fragment.app.SpecialEffectsController$Operation$State r14 = r13.e()
            androidx.fragment.app.SpecialEffectsController$Operation$State r15 = androidx.fragment.app.SpecialEffectsController.Operation.State.VISIBLE
            if (r14 != r15) goto L_0x04c0
            r2.addAll(r3)
            if (r21 == 0) goto L_0x04bd
            r11.q(r9, r5)
        L_0x04bd:
            r3 = r26
            goto L_0x04c5
        L_0x04c0:
            r3 = r26
            r11.r(r9, r3)
        L_0x04c5:
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            r8.put(r13, r14)
            boolean r13 = r20.j()
            if (r13 == 0) goto L_0x04d6
            r13 = 0
            java.lang.Object r7 = r11.k(r7, r9, r13)
            goto L_0x04db
        L_0x04d6:
            r13 = 0
            java.lang.Object r1 = r11.k(r1, r9, r13)
        L_0x04db:
            r9 = r36
            r12 = r1
            r26 = r3
            r13 = r7
            r15 = r10
            r3 = r24
            r1 = r29
            r7 = r30
            r10 = r32
            goto L_0x03dd
        L_0x04ec:
            r24 = r3
            r30 = r7
            r32 = r10
            r1 = r12
            r7 = r13
            r10 = r15
            r23 = 1
            java.lang.Object r1 = r11.j(r7, r1, r0)
            if (r1 != 0) goto L_0x04fe
            return r8
        L_0x04fe:
            java.util.Iterator r3 = r34.iterator()
        L_0x0502:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0580
            java.lang.Object r5 = r3.next()
            androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo r5 = (androidx.fragment.app.DefaultSpecialEffectsController.TransitionInfo) r5
            boolean r7 = r5.d()
            if (r7 == 0) goto L_0x0515
            goto L_0x0502
        L_0x0515:
            java.lang.Object r7 = r5.h()
            androidx.fragment.app.SpecialEffectsController$Operation r9 = r5.b()
            if (r0 == 0) goto L_0x0525
            if (r9 == r4) goto L_0x0523
            if (r9 != r10) goto L_0x0525
        L_0x0523:
            r12 = 1
            goto L_0x0526
        L_0x0525:
            r12 = 0
        L_0x0526:
            if (r7 != 0) goto L_0x052e
            if (r12 == 0) goto L_0x052b
            goto L_0x052e
        L_0x052b:
            r12 = r24
            goto L_0x057d
        L_0x052e:
            android.view.ViewGroup r7 = r33.m()
            boolean r7 = androidx.core.view.ViewCompat.Y0(r7)
            if (r7 != 0) goto L_0x0567
            boolean r7 = androidx.fragment.app.FragmentManager.W0(r22)
            if (r7 == 0) goto L_0x0561
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r12 = "SpecialEffectsController: Container "
            r7.append(r12)
            android.view.ViewGroup r12 = r33.m()
            r7.append(r12)
            java.lang.String r12 = " has not been laid out. Completing operation "
            r7.append(r12)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r12 = r24
            android.util.Log.v(r12, r7)
            goto L_0x0563
        L_0x0561:
            r12 = r24
        L_0x0563:
            r5.a()
            goto L_0x057d
        L_0x0567:
            r12 = r24
            androidx.fragment.app.SpecialEffectsController$Operation r7 = r5.b()
            androidx.fragment.app.Fragment r7 = r7.f()
            androidx.core.os.CancellationSignal r13 = r5.c()
            androidx.fragment.app.DefaultSpecialEffectsController$9 r14 = new androidx.fragment.app.DefaultSpecialEffectsController$9
            r14.<init>(r5, r9)
            r11.s(r7, r1, r13, r14)
        L_0x057d:
            r24 = r12
            goto L_0x0502
        L_0x0580:
            r12 = r24
            android.view.ViewGroup r3 = r33.m()
            boolean r3 = androidx.core.view.ViewCompat.Y0(r3)
            if (r3 != 0) goto L_0x058d
            return r8
        L_0x058d:
            r3 = 4
            androidx.fragment.app.FragmentTransition.e(r2, r3)
            r3 = r32
            java.util.ArrayList r16 = r11.l(r3)
            boolean r4 = androidx.fragment.app.FragmentManager.W0(r22)
            if (r4 == 0) goto L_0x060a
            java.lang.String r4 = ">>>>> Beginning transition <<<<<"
            android.util.Log.v(r12, r4)
            java.lang.String r4 = ">>>>> SharedElementFirstOutViews <<<<<"
            android.util.Log.v(r12, r4)
            java.util.Iterator r4 = r30.iterator()
        L_0x05ab:
            boolean r5 = r4.hasNext()
            java.lang.String r7 = " Name: "
            java.lang.String r9 = "View: "
            if (r5 == 0) goto L_0x05d8
            java.lang.Object r5 = r4.next()
            android.view.View r5 = (android.view.View) r5
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            r10.append(r5)
            r10.append(r7)
            java.lang.String r5 = androidx.core.view.ViewCompat.A0(r5)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            android.util.Log.v(r12, r5)
            goto L_0x05ab
        L_0x05d8:
            java.lang.String r4 = ">>>>> SharedElementLastInViews <<<<<"
            android.util.Log.v(r12, r4)
            java.util.Iterator r4 = r3.iterator()
        L_0x05e1:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x060a
            java.lang.Object r5 = r4.next()
            android.view.View r5 = (android.view.View) r5
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r9)
            r10.append(r5)
            r10.append(r7)
            java.lang.String r5 = androidx.core.view.ViewCompat.A0(r5)
            r10.append(r5)
            java.lang.String r5 = r10.toString()
            android.util.Log.v(r12, r5)
            goto L_0x05e1
        L_0x060a:
            android.view.ViewGroup r4 = r33.m()
            r11.c(r4, r1)
            android.view.ViewGroup r13 = r33.m()
            r12 = r11
            r14 = r30
            r15 = r3
            r17 = r28
            r12.t(r13, r14, r15, r16, r17)
            r1 = 0
            androidx.fragment.app.FragmentTransition.e(r2, r1)
            r1 = r30
            r11.v(r0, r1, r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.x(java.util.List, java.util.List, boolean, androidx.fragment.app.SpecialEffectsController$Operation, androidx.fragment.app.SpecialEffectsController$Operation):java.util.Map");
    }

    private void y(@NonNull List<SpecialEffectsController.Operation> list) {
        Fragment f2 = list.get(list.size() - 1).f();
        for (SpecialEffectsController.Operation next : list) {
            next.f().E3.f7886c = f2.E3.f7886c;
            next.f().E3.f7887d = f2.E3.f7887d;
            next.f().E3.f7888e = f2.E3.f7888e;
            next.f().E3.f7889f = f2.E3.f7889f;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(@NonNull List<SpecialEffectsController.Operation> list, boolean z) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation next : list) {
            SpecialEffectsController.Operation.State c2 = SpecialEffectsController.Operation.State.c(next.f().B3);
            int i2 = AnonymousClass10.f7849a[next.e().ordinal()];
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                if (c2 == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = next;
                }
            } else if (i2 == 4 && c2 != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = next;
            }
        }
        if (FragmentManager.W0(2)) {
            Log.v(FragmentManager.Y, "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList<SpecialEffectsController.Operation> arrayList3 = new ArrayList<>(list);
        y(list);
        for (final SpecialEffectsController.Operation next2 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            next2.j(cancellationSignal);
            arrayList.add(new AnimationInfo(next2, cancellationSignal, z));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            next2.j(cancellationSignal2);
            boolean z2 = false;
            if (z) {
                if (next2 != operation) {
                    arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
                    next2.a(new Runnable() {
                        public void run() {
                            if (arrayList3.contains(next2)) {
                                arrayList3.remove(next2);
                                DefaultSpecialEffectsController.this.s(next2);
                            }
                        }
                    });
                }
            } else if (next2 != operation2) {
                arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
                next2.a(new Runnable() {
                    public void run() {
                        if (arrayList3.contains(next2)) {
                            arrayList3.remove(next2);
                            DefaultSpecialEffectsController.this.s(next2);
                        }
                    }
                });
            }
            z2 = true;
            arrayList2.add(new TransitionInfo(next2, cancellationSignal2, z, z2));
            next2.a(new Runnable() {
                public void run() {
                    if (arrayList3.contains(next2)) {
                        arrayList3.remove(next2);
                        DefaultSpecialEffectsController.this.s(next2);
                    }
                }
            });
        }
        Map<SpecialEffectsController.Operation, Boolean> x = x(arrayList2, arrayList3, z, operation, operation2);
        w(arrayList, arrayList3, x.containsValue(Boolean.TRUE), x);
        for (SpecialEffectsController.Operation s : arrayList3) {
            s(s);
        }
        arrayList3.clear();
        if (FragmentManager.W0(2)) {
            Log.v(FragmentManager.Y, "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    /* access modifiers changed from: package-private */
    public void s(@NonNull SpecialEffectsController.Operation operation) {
        operation.e().a(operation.f().B3);
    }

    /* access modifiers changed from: package-private */
    public void t(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!ViewGroupCompat.c(viewGroup)) {
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt.getVisibility() == 0) {
                        t(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void u(Map<String, View> map, @NonNull View view) {
        String A0 = ViewCompat.A0(view);
        if (A0 != null) {
            map.put(A0, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void v(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it2 = arrayMap.entrySet().iterator();
        while (it2.hasNext()) {
            if (!collection.contains(ViewCompat.A0((View) it2.next().getValue()))) {
                it2.remove();
            }
        }
    }
}
