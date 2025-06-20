package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    private static boolean B(Transition transition) {
        return !FragmentTransitionImpl.i(transition.k0()) || !FragmentTransitionImpl.i(transition.l0()) || !FragmentTransitionImpl.i(transition.n0());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void E(Runnable runnable, Transition transition, Runnable runnable2) {
        if (runnable == null) {
            transition.cancel();
            runnable2.run();
            return;
        }
        runnable.run();
    }

    @Nullable
    public Object A(@NonNull ViewGroup viewGroup, @NonNull Object obj) {
        return TransitionManager.d(viewGroup, (Transition) obj);
    }

    public boolean C() {
        return true;
    }

    public boolean D(@NonNull Object obj) {
        boolean u0 = ((Transition) obj).u0();
        if (!u0) {
            Log.v(FragmentManager.Y, "Predictive back not available for AndroidX Transition " + obj + ". Please enable seeking support for the designated transition by overriding isSeekingSupported().");
        }
        return u0;
    }

    public void F(@NonNull Object obj, float f2) {
        TransitionSeekController transitionSeekController = (TransitionSeekController) obj;
        if (transitionSeekController.d()) {
            long t = (long) (f2 * ((float) transitionSeekController.t()));
            if (t == 0) {
                t = 1;
            }
            if (t == transitionSeekController.t()) {
                t = transitionSeekController.t() - 1;
            }
            transitionSeekController.g(t);
        }
    }

    public void G(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @Nullable Runnable runnable, @NonNull final Runnable runnable2) {
        Transition transition = (Transition) obj;
        cancellationSignal.d(new a(runnable, transition, runnable2));
        transition.c(new Transition.TransitionListener() {
            public void b(@NonNull Transition transition) {
            }

            public void f(@NonNull Transition transition) {
            }

            public /* synthetic */ void h(Transition transition, boolean z) {
                e.a(this, transition, z);
            }

            public void k(@NonNull Transition transition) {
                runnable2.run();
            }

            public void p(@NonNull Transition transition) {
            }

            public /* synthetic */ void q(Transition transition, boolean z) {
                e.b(this, transition, z);
            }

            public void s(@NonNull Transition transition) {
            }
        });
    }

    public void a(@NonNull Object obj, @NonNull View view) {
        if (obj != null) {
            ((Transition) obj).e(view);
        }
    }

    public void b(@NonNull Object obj, @NonNull ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i2 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int a2 = transitionSet.a2();
                while (i2 < a2) {
                    b(transitionSet.U1(i2), arrayList);
                    i2++;
                }
            } else if (!B(transition) && FragmentTransitionImpl.i(transition.o0())) {
                int size = arrayList.size();
                while (i2 < size) {
                    transition.e(arrayList.get(i2));
                    i2++;
                }
            }
        }
    }

    public void c(@NonNull ViewGroup viewGroup, @Nullable Object obj) {
        TransitionManager.b(viewGroup, (Transition) obj);
    }

    public boolean e(@NonNull Object obj) {
        return obj instanceof Transition;
    }

    @Nullable
    public Object f(@Nullable Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Nullable
    public Object j(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().R1(transition).R1(transition2).p2(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.R1(transition);
        }
        transitionSet.R1(transition3);
        return transitionSet;
    }

    @NonNull
    public Object k(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.R1((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.R1((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.R1((Transition) obj3);
        }
        return transitionSet;
    }

    public void m(@NonNull Object obj, @NonNull View view) {
        if (obj != null) {
            ((Transition) obj).Y0(view);
        }
    }

    public void n(@NonNull Object obj, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList, @SuppressLint({"UnknownNullness"}) ArrayList<View> arrayList2) {
        Transition transition = (Transition) obj;
        int i2 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int a2 = transitionSet.a2();
            while (i2 < a2) {
                n(transitionSet.U1(i2), arrayList, arrayList2);
                i2++;
            }
        } else if (!B(transition)) {
            List<View> o0 = transition.o0();
            if (o0.size() == arrayList.size() && o0.containsAll(arrayList)) {
                int size = arrayList2 == null ? 0 : arrayList2.size();
                while (i2 < size) {
                    transition.e(arrayList2.get(i2));
                    i2++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.Y0(arrayList.get(size2));
                }
            }
        }
    }

    public void o(@NonNull Object obj, @NonNull final View view, @NonNull final ArrayList<View> arrayList) {
        ((Transition) obj).c(new Transition.TransitionListener() {
            public void b(@NonNull Transition transition) {
                transition.S0(this);
                transition.c(this);
            }

            public void f(@NonNull Transition transition) {
            }

            public /* synthetic */ void h(Transition transition, boolean z) {
                e.a(this, transition, z);
            }

            public void k(@NonNull Transition transition) {
                transition.S0(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((View) arrayList.get(i2)).setVisibility(0);
                }
            }

            public void p(@NonNull Transition transition) {
            }

            public /* synthetic */ void q(Transition transition, boolean z) {
                e.b(this, transition, z);
            }

            public void s(@NonNull Transition transition) {
            }
        });
    }

    public void p(@NonNull Object obj, @Nullable Object obj2, @Nullable ArrayList<View> arrayList, @Nullable Object obj3, @Nullable ArrayList<View> arrayList2, @Nullable Object obj4, @Nullable ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).c(new TransitionListenerAdapter() {
            public void b(@NonNull Transition transition) {
                Object obj = obj5;
                if (obj != null) {
                    FragmentTransitionSupport.this.n(obj, arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    FragmentTransitionSupport.this.n(obj2, arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    FragmentTransitionSupport.this.n(obj3, arrayList6, (ArrayList<View>) null);
                }
            }

            public void k(@NonNull Transition transition) {
                transition.S0(this);
            }
        });
    }

    public void q(@NonNull Object obj, @NonNull final Rect rect) {
        if (obj != null) {
            ((Transition) obj).l1(new Transition.EpicenterCallback() {
                public Rect a(@NonNull Transition transition) {
                    Rect rect = rect;
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }

    public void r(@NonNull Object obj, @Nullable View view) {
        if (view != null) {
            final Rect rect = new Rect();
            h(view, rect);
            ((Transition) obj).l1(new Transition.EpicenterCallback() {
                public Rect a(@NonNull Transition transition) {
                    return rect;
                }
            });
        }
    }

    public void s(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @NonNull Runnable runnable) {
        G(fragment, obj, cancellationSignal, (Runnable) null, runnable);
    }

    public void u(@NonNull Object obj, @NonNull View view, @NonNull ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> o0 = transitionSet.o0();
        o0.clear();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            FragmentTransitionImpl.d(o0, arrayList.get(i2));
        }
        o0.add(view);
        arrayList.add(view);
        b(transitionSet, arrayList);
    }

    public void v(@Nullable Object obj, @Nullable ArrayList<View> arrayList, @Nullable ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.o0().clear();
            transitionSet.o0().addAll(arrayList2);
            n(transitionSet, arrayList, arrayList2);
        }
    }

    @Nullable
    public Object w(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.R1((Transition) obj);
        return transitionSet;
    }

    public void y(@NonNull Object obj) {
        ((TransitionSeekController) obj).l();
    }

    public void z(@NonNull Object obj, @NonNull Runnable runnable) {
        ((TransitionSeekController) obj).o(runnable);
    }
}
