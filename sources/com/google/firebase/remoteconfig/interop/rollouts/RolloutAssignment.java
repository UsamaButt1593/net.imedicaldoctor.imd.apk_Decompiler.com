package com.google.firebase.remoteconfig.interop.rollouts;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.remoteconfig.interop.rollouts.AutoValue_RolloutAssignment;
import org.json.JSONException;
import org.json.JSONObject;

@AutoValue
@Encodable
public abstract class RolloutAssignment {

    /* renamed from: a  reason: collision with root package name */
    private static final String f24991a = "rolloutId";

    /* renamed from: b  reason: collision with root package name */
    private static final String f24992b = "variantId";

    /* renamed from: c  reason: collision with root package name */
    private static final String f24993c = "parameterKey";

    /* renamed from: d  reason: collision with root package name */
    private static final String f24994d = "parameterValue";

    /* renamed from: e  reason: collision with root package name */
    private static final String f24995e = "templateVersion";

    /* renamed from: f  reason: collision with root package name */
    public static final DataEncoder f24996f = new JsonDataEncoderBuilder().k(AutoRolloutAssignmentEncoder.f24972b).j();

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract RolloutAssignment a();

        @NonNull
        public abstract Builder b(@NonNull String str);

        @NonNull
        public abstract Builder c(@NonNull String str);

        @NonNull
        public abstract Builder d(@NonNull String str);

        @NonNull
        public abstract Builder e(long j2);

        @NonNull
        public abstract Builder f(@NonNull String str);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_RolloutAssignment.Builder();
    }

    @NonNull
    public static RolloutAssignment b(@NonNull String str) throws JSONException {
        return c(new JSONObject(str));
    }

    @NonNull
    public static RolloutAssignment c(@NonNull JSONObject jSONObject) throws JSONException {
        return a().d(jSONObject.getString(f24991a)).f(jSONObject.getString(f24992b)).b(jSONObject.getString(f24993c)).c(jSONObject.getString(f24994d)).e(jSONObject.getLong(f24995e)).a();
    }

    @NonNull
    public abstract String d();

    @NonNull
    public abstract String e();

    @NonNull
    public abstract String f();

    public abstract long g();

    @NonNull
    public abstract String h();
}
