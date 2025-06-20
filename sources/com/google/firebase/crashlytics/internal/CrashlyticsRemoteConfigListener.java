package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutAssignment;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/firebase/crashlytics/internal/CrashlyticsRemoteConfigListener;", "Lcom/google/firebase/remoteconfig/interop/rollouts/RolloutsStateSubscriber;", "Lcom/google/firebase/crashlytics/internal/metadata/UserMetadata;", "userMetadata", "<init>", "(Lcom/google/firebase/crashlytics/internal/metadata/UserMetadata;)V", "Lcom/google/firebase/remoteconfig/interop/rollouts/RolloutsState;", "rolloutsState", "", "a", "(Lcom/google/firebase/remoteconfig/interop/rollouts/RolloutsState;)V", "Lcom/google/firebase/crashlytics/internal/metadata/UserMetadata;", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCrashlyticsRemoteConfigListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CrashlyticsRemoteConfigListener.kt\ncom/google/firebase/crashlytics/internal/CrashlyticsRemoteConfigListener\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n1549#2:41\n1620#2,3:42\n*S KotlinDebug\n*F\n+ 1 CrashlyticsRemoteConfigListener.kt\ncom/google/firebase/crashlytics/internal/CrashlyticsRemoteConfigListener\n*L\n27#1:41\n27#1:42,3\n*E\n"})
public final class CrashlyticsRemoteConfigListener implements RolloutsStateSubscriber {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final UserMetadata f23494a;

    public CrashlyticsRemoteConfigListener(@NotNull UserMetadata userMetadata) {
        Intrinsics.p(userMetadata, "userMetadata");
        this.f23494a = userMetadata;
    }

    public void a(@NotNull RolloutsState rolloutsState) {
        Intrinsics.p(rolloutsState, "rolloutsState");
        UserMetadata userMetadata = this.f23494a;
        Set<RolloutAssignment> b2 = rolloutsState.b();
        Intrinsics.o(b2, "rolloutsState.rolloutAssignments");
        ArrayList arrayList = new ArrayList(CollectionsKt.Y(b2, 10));
        for (RolloutAssignment rolloutAssignment : b2) {
            arrayList.add(com.google.firebase.crashlytics.internal.metadata.RolloutAssignment.b(rolloutAssignment.f(), rolloutAssignment.d(), rolloutAssignment.e(), rolloutAssignment.h(), rolloutAssignment.g()));
        }
        userMetadata.t(arrayList);
        Logger.f().b("Updated Crashlytics Rollout State");
    }
}
