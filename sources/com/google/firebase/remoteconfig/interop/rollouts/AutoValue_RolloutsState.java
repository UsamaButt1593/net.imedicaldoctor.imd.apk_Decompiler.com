package com.google.firebase.remoteconfig.interop.rollouts;

import androidx.annotation.NonNull;
import java.util.Set;

final class AutoValue_RolloutsState extends RolloutsState {

    /* renamed from: a  reason: collision with root package name */
    private final Set<RolloutAssignment> f24990a;

    AutoValue_RolloutsState(Set<RolloutAssignment> set) {
        if (set != null) {
            this.f24990a = set;
            return;
        }
        throw new NullPointerException("Null rolloutAssignments");
    }

    @NonNull
    public Set<RolloutAssignment> b() {
        return this.f24990a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RolloutsState) {
            return this.f24990a.equals(((RolloutsState) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f24990a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f24990a + "}";
    }
}
