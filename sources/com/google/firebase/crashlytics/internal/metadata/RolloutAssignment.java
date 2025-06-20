package com.google.firebase.crashlytics.internal.metadata;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import org.json.JSONException;
import org.json.JSONObject;

@AutoValue
@Encodable
public abstract class RolloutAssignment {

    /* renamed from: a  reason: collision with root package name */
    private static final int f23736a = 256;

    /* renamed from: b  reason: collision with root package name */
    public static final DataEncoder f23737b = new JsonDataEncoderBuilder().k(AutoRolloutAssignmentEncoder.f23696b).j();

    static RolloutAssignment a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static RolloutAssignment b(String str, String str2, String str3, String str4, long j2) {
        return new AutoValue_RolloutAssignment(str, str2, i(str3), str4, j2);
    }

    private static String i(String str) {
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public CrashlyticsReport.Session.Event.RolloutAssignment h() {
        return CrashlyticsReport.Session.Event.RolloutAssignment.a().d(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
