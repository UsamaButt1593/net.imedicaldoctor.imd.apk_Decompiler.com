package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Deprecated
public class RequestManagerFragment extends Fragment {
    private static final String Z2 = "RMFragment";
    private final RequestManagerTreeNode X;
    @Nullable
    private RequestManagerFragment X2;
    private final Set<RequestManagerFragment> Y;
    @Nullable
    private Fragment Y2;
    @Nullable
    private RequestManager Z;
    private final ActivityFragmentLifecycle s;

    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        FragmentRequestManagerTreeNode() {
        }

        @NonNull
        public Set<RequestManager> a() {
            Set<RequestManagerFragment> b2 = RequestManagerFragment.this.b();
            HashSet hashSet = new HashSet(b2.size());
            for (RequestManagerFragment next : b2) {
                if (next.e() != null) {
                    hashSet.add(next.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + RequestManagerFragment.this + "}";
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void a(RequestManagerFragment requestManagerFragment) {
        this.Y.add(requestManagerFragment);
    }

    @TargetApi(17)
    @Nullable
    private Fragment d() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.Y2;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(@NonNull Activity activity) {
        l();
        RequestManagerFragment p = Glide.d(activity).n().p(activity);
        this.X2 = p;
        if (!equals(p)) {
            this.X2.a(this);
        }
    }

    private void i(RequestManagerFragment requestManagerFragment) {
        this.Y.remove(requestManagerFragment);
    }

    private void l() {
        RequestManagerFragment requestManagerFragment = this.X2;
        if (requestManagerFragment != null) {
            requestManagerFragment.i(this);
            this.X2 = null;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(17)
    @NonNull
    public Set<RequestManagerFragment> b() {
        if (equals(this.X2)) {
            return Collections.unmodifiableSet(this.Y);
        }
        if (this.X2 == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (RequestManagerFragment next : this.X2.b()) {
            if (g(next.getParentFragment())) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public ActivityFragmentLifecycle c() {
        return this.s;
    }

    @Nullable
    public RequestManager e() {
        return this.Z;
    }

    @NonNull
    public RequestManagerTreeNode f() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public void j(@Nullable Fragment fragment) {
        this.Y2 = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    public void k(@Nullable RequestManager requestManager) {
        this.Z = requestManager;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable(Z2, 5)) {
                Log.w(Z2, "Unable to register fragment with root", e2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.s.c();
        l();
    }

    public void onDetach() {
        super.onDetach();
        l();
    }

    public void onStart() {
        super.onStart();
        this.s.d();
    }

    public void onStop() {
        super.onStop();
        this.s.e();
    }

    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @VisibleForTesting
    @SuppressLint({"ValidFragment"})
    RequestManagerFragment(@NonNull ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.X = new FragmentRequestManagerTreeNode();
        this.Y = new HashSet();
        this.s = activityFragmentLifecycle;
    }
}
