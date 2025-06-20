package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
public final class JsonUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f20391a = Pattern.compile("\\\\.");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f20392b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    private JsonUtils() {
    }

    @KeepForSdk
    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject2.has(next)) {
                    return false;
                }
                try {
                    Preconditions.r(next);
                    if (!a(jSONObject.get(next), jSONObject2.get(next))) {
                        return false;
                    }
                } catch (JSONException unused) {
                }
            }
            return true;
        } else if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray)) {
            return obj.equals(obj2);
        } else {
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (jSONArray.length() != jSONArray2.length()) {
                return false;
            }
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                try {
                    if (!a(jSONArray.get(i2), jSONArray2.get(i2))) {
                        return false;
                    }
                    i2++;
                } catch (JSONException unused2) {
                }
            }
            return true;
        }
    }

    @KeepForSdk
    @Nullable
    public static String b(@Nullable String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = f20392b.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char charAt = matcher.group().charAt(0);
            if (charAt == 12) {
                str2 = "\\\\f";
            } else if (charAt == 13) {
                str2 = "\\\\r";
            } else if (charAt == '\"') {
                str2 = "\\\\\\\"";
            } else if (charAt == '/') {
                str2 = "\\\\/";
            } else if (charAt != '\\') {
                switch (charAt) {
                    case 8:
                        str2 = "\\\\b";
                        break;
                    case 9:
                        str2 = "\\\\t";
                        break;
                    case 10:
                        str2 = "\\\\n";
                        break;
                }
            } else {
                str2 = "\\\\\\\\";
            }
            matcher.appendReplacement(stringBuffer, str2);
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    @NonNull
    @KeepForSdk
    public static String c(@NonNull String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = zzc.a(str);
        Matcher matcher = f20391a.matcher(a2);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char charAt = matcher.group().charAt(1);
            if (charAt == '\"') {
                str2 = "\"";
            } else if (charAt == '/') {
                str2 = "/";
            } else if (charAt == '\\') {
                str2 = "\\\\";
            } else if (charAt == 'b') {
                str2 = "\b";
            } else if (charAt == 'f') {
                str2 = "\f";
            } else if (charAt == 'n') {
                str2 = StringUtils.LF;
            } else if (charAt == 'r') {
                str2 = StringUtils.CR;
            } else if (charAt == 't') {
                str2 = "\t";
            } else {
                throw new IllegalStateException("Found an escaped character that should never be.");
            }
            matcher.appendReplacement(stringBuffer, str2);
        }
        if (stringBuffer == null) {
            return a2;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
