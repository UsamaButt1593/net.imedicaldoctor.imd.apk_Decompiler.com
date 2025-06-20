package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ClearKeyUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11234a = "ClearKeyUtil";

    private ClearKeyUtil() {
    }

    public static byte[] a(byte[] bArr) {
        return Util.f9646a >= 27 ? bArr : Util.R0(c(Util.T(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (Util.f9646a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(Util.T(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray(UserMetadata.f23742i);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return Util.R0(sb.toString());
        } catch (JSONException e2) {
            Log.e(f11234a, "Failed to adjust response data: " + Util.T(bArr), e2);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
