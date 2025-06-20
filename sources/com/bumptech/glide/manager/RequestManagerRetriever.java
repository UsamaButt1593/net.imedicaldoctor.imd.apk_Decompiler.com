package com.bumptech.glide.manager;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RequestManagerRetriever implements Handler.Callback {
    @VisibleForTesting
    static final String b3 = "com.bumptech.glide.manager";
    private static final String c3 = "RMRetriever";
    private static final int d3 = 1;
    private static final int e3 = 2;
    private static final String f3 = "key";
    private static final RequestManagerFactory g3 = new RequestManagerFactory() {
        @NonNull
        public RequestManager a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
            return new RequestManager(glide, lifecycle, requestManagerTreeNode, context);
        }
    };
    @VisibleForTesting
    final Map<FragmentManager, RequestManagerFragment> X = new HashMap();
    private final RequestManagerFactory X2;
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> Y = new HashMap();
    private final ArrayMap<View, Fragment> Y2 = new ArrayMap<>();
    private final Handler Z;
    private final ArrayMap<View, android.app.Fragment> Z2 = new ArrayMap<>();
    private final Bundle a3 = new Bundle();
    private volatile RequestManager s;

    public interface RequestManagerFactory {
        @NonNull
        RequestManager a(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context);
    }

    public RequestManagerRetriever(@Nullable RequestManagerFactory requestManagerFactory) {
        this.X2 = requestManagerFactory == null ? g3 : requestManagerFactory;
        this.Z = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Nullable
    private static Activity b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void c(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT >= 26) {
            for (android.app.Fragment fragment : fragmentManager.getFragments()) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    c(fragment.getChildFragmentManager(), arrayMap);
                }
            }
            return;
        }
        d(fragmentManager, arrayMap);
    }

    @Deprecated
    private void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        android.app.Fragment fragment;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            this.a3.putInt(f3, i2);
            try {
                fragment = fragmentManager.getFragment(this.a3, f3);
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment != null) {
                if (fragment.getView() != null) {
                    arrayMap.put(fragment.getView(), fragment);
                    c(fragment.getChildFragmentManager(), arrayMap);
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    private static void e(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection != null) {
            for (Fragment next : collection) {
                if (!(next == null || next.q0() == null)) {
                    map.put(next.q0(), next);
                    e(next.z().I0(), map);
                }
            }
        }
    }

    @Deprecated
    @Nullable
    private android.app.Fragment f(@NonNull View view, @NonNull Activity activity) {
        this.Z2.clear();
        c(activity.getFragmentManager(), this.Z2);
        View findViewById = activity.findViewById(16908290);
        android.app.Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.Z2.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.Z2.clear();
        return fragment;
    }

    @Nullable
    private Fragment g(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.Y2.clear();
        e(fragmentActivity.k0().I0(), this.Y2);
        View findViewById = fragmentActivity.findViewById(16908290);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = this.Y2.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.Y2.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private RequestManager h(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment q = q(fragmentManager, fragment, z);
        RequestManager e2 = q.e();
        if (e2 != null) {
            return e2;
        }
        RequestManager a2 = this.X2.a(Glide.d(context), q.c(), q.f(), context);
        q.k(a2);
        return a2;
    }

    @NonNull
    private RequestManager o(@NonNull Context context) {
        if (this.s == null) {
            synchronized (this) {
                try {
                    if (this.s == null) {
                        this.s = this.X2.a(Glide.d(context.getApplicationContext()), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.s;
    }

    @NonNull
    private RequestManagerFragment q(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(b3);
        if (requestManagerFragment == null && (requestManagerFragment = this.X.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            requestManagerFragment.j(fragment);
            if (z) {
                requestManagerFragment.c().d();
            }
            this.X.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, b3).commitAllowingStateLoss();
            this.Z.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }

    @NonNull
    private SupportRequestManagerFragment s(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.s0(b3);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.Y.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            supportRequestManagerFragment.T2(fragment);
            if (z) {
                supportRequestManagerFragment.L2().d();
            }
            this.Y.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.u().k(supportRequestManagerFragment, b3).r();
            this.Z.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }

    private static boolean t(Context context) {
        Activity b2 = b(context);
        return b2 == null || !b2.isFinishing();
    }

    @NonNull
    private RequestManager u(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z) {
        SupportRequestManagerFragment s2 = s(fragmentManager, fragment, z);
        RequestManager N2 = s2.N2();
        if (N2 != null) {
            return N2;
        }
        RequestManager a2 = this.X2.a(Glide.d(context), s2.L2(), s2.O2(), context);
        s2.U2(a2);
        return a2;
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        Map map;
        int i2 = message.what;
        boolean z = true;
        if (i2 == 1) {
            obj3 = (FragmentManager) message.obj;
            map = this.X;
        } else if (i2 != 2) {
            obj = null;
            z = false;
            obj2 = null;
            if (z && obj == null && Log.isLoggable(c3, 5)) {
                Log.w(c3, "Failed to remove expected request manager fragment, manager: " + obj2);
            }
            return z;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            map = this.Y;
        }
        Object remove = map.remove(obj3);
        obj2 = obj3;
        obj = remove;
        Log.w(c3, "Failed to remove expected request manager fragment, manager: " + obj2);
        return z;
    }

    @NonNull
    public RequestManager i(@NonNull Activity activity) {
        if (Util.s()) {
            return k(activity.getApplicationContext());
        }
        a(activity);
        return h(activity, activity.getFragmentManager(), (android.app.Fragment) null, t(activity));
    }

    @TargetApi(17)
    @NonNull
    @Deprecated
    public RequestManager j(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        } else if (Util.s()) {
            return k(fragment.getActivity().getApplicationContext());
        } else {
            return h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
        }
    }

    @NonNull
    public RequestManager k(@NonNull Context context) {
        if (context != null) {
            if (Util.t() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return n((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return i((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return k(contextWrapper.getBaseContext());
                    }
                }
            }
            return o(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    @NonNull
    public RequestManager l(@NonNull View view) {
        if (!Util.s()) {
            Preconditions.d(view);
            Preconditions.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
            Activity b2 = b(view.getContext());
            if (b2 != null) {
                if (b2 instanceof FragmentActivity) {
                    FragmentActivity fragmentActivity = (FragmentActivity) b2;
                    Fragment g2 = g(view, fragmentActivity);
                    return g2 != null ? m(g2) : n(fragmentActivity);
                }
                android.app.Fragment f2 = f(view, b2);
                return f2 == null ? i(b2) : j(f2);
            }
        }
        return k(view.getContext().getApplicationContext());
    }

    @NonNull
    public RequestManager m(@NonNull Fragment fragment) {
        Preconditions.e(fragment.B(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (Util.s()) {
            return k(fragment.B().getApplicationContext());
        }
        return u(fragment.B(), fragment.z(), fragment, fragment.I0());
    }

    @NonNull
    public RequestManager n(@NonNull FragmentActivity fragmentActivity) {
        if (Util.s()) {
            return k(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        return u(fragmentActivity, fragmentActivity.k0(), (Fragment) null, t(fragmentActivity));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    @Deprecated
    public RequestManagerFragment p(Activity activity) {
        return q(activity.getFragmentManager(), (android.app.Fragment) null, t(activity));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public SupportRequestManagerFragment r(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return s(fragmentManager, (Fragment) null, t(context));
    }
}
