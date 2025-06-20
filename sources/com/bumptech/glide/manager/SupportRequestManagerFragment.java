package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    private static final String k4 = "SupportRMFragment";
    private final ActivityFragmentLifecycle e4;
    private final RequestManagerTreeNode f4;
    private final Set<SupportRequestManagerFragment> g4;
    @Nullable
    private SupportRequestManagerFragment h4;
    @Nullable
    private RequestManager i4;
    @Nullable
    private Fragment j4;

    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        SupportFragmentRequestManagerTreeNode() {
        }

        @NonNull
        public Set<RequestManager> a() {
            Set<SupportRequestManagerFragment> K2 = SupportRequestManagerFragment.this.K2();
            HashSet hashSet = new HashSet(K2.size());
            for (SupportRequestManagerFragment next : K2) {
                if (next.N2() != null) {
                    hashSet.add(next.N2());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void J2(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.g4.add(supportRequestManagerFragment);
    }

    @Nullable
    private Fragment M2() {
        Fragment U = U();
        return U != null ? U : this.j4;
    }

    @Nullable
    private static FragmentManager P2(@NonNull Fragment fragment) {
        while (fragment.U() != null) {
            fragment = fragment.U();
        }
        return fragment.M();
    }

    private boolean Q2(@NonNull Fragment fragment) {
        Fragment M2 = M2();
        while (true) {
            Fragment U = fragment.U();
            if (U == null) {
                return false;
            }
            if (U.equals(M2)) {
                return true;
            }
            fragment = fragment.U();
        }
    }

    private void R2(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        V2();
        SupportRequestManagerFragment r = Glide.d(context).n().r(context, fragmentManager);
        this.h4 = r;
        if (!equals(r)) {
            this.h4.J2(this);
        }
    }

    private void S2(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.g4.remove(supportRequestManagerFragment);
    }

    private void V2() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.h4;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.S2(this);
            this.h4 = null;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Set<SupportRequestManagerFragment> K2() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.h4;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.g4);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.h4.K2()) {
            if (Q2(next.M2())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ActivityFragmentLifecycle L2() {
        return this.e4;
    }

    public void N0(Context context) {
        super.N0(context);
        FragmentManager P2 = P2(this);
        if (P2 != null) {
            try {
                R2(B(), P2);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable(k4, 5)) {
                    Log.w(k4, "Unable to register fragment with root", e2);
                }
            }
        } else if (Log.isLoggable(k4, 5)) {
            Log.w(k4, "Unable to register fragment with root, ancestor detached");
        }
    }

    @Nullable
    public RequestManager N2() {
        return this.i4;
    }

    @NonNull
    public RequestManagerTreeNode O2() {
        return this.f4;
    }

    /* access modifiers changed from: package-private */
    public void T2(@Nullable Fragment fragment) {
        FragmentManager P2;
        this.j4 = fragment;
        if (fragment != null && fragment.B() != null && (P2 = P2(fragment)) != null) {
            R2(fragment.B(), P2);
        }
    }

    public void U2(@Nullable RequestManager requestManager) {
        this.i4 = requestManager;
    }

    public void V0() {
        super.V0();
        this.e4.c();
        V2();
    }

    public void Y0() {
        super.Y0();
        this.j4 = null;
        V2();
    }

    public void n1() {
        super.n1();
        this.e4.d();
    }

    public void o1() {
        super.o1();
        this.e4.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + M2() + "}";
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.f4 = new SupportFragmentRequestManagerTreeNode();
        this.g4 = new HashSet();
        this.e4 = activityFragmentLifecycle;
    }
}
