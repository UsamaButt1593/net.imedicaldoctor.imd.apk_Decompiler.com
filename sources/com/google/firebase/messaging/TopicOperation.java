package com.google.firebase.messaging;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Objects;
import java.util.regex.Pattern;

final class TopicOperation {
    @VisibleForTesting

    /* renamed from: d  reason: collision with root package name */
    static final String f24873d = "!";

    /* renamed from: e  reason: collision with root package name */
    private static final String f24874e = "/topics/";

    /* renamed from: f  reason: collision with root package name */
    private static final String f24875f = "[a-zA-Z0-9-_.~%]{1,900}";

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f24876g = Pattern.compile(f24875f);

    /* renamed from: a  reason: collision with root package name */
    private final String f24877a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24878b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24879c;

    private TopicOperation(String str, String str2) {
        this.f24877a = d(str2, str);
        this.f24878b = str;
        this.f24879c = str + f24873d + str2;
    }

    @Nullable
    static TopicOperation a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(f24873d, -1);
        if (split.length != 2) {
            return null;
        }
        return new TopicOperation(split[0], split[1]);
    }

    @NonNull
    private static String d(String str, String str2) {
        if (str != null && str.startsWith(f24874e)) {
            Log.w(Constants.f24670a, String.format("Format /topics/topic-name is deprecated. Only 'topic-name' should be used in %s.", new Object[]{str2}));
            str = str.substring(8);
        }
        if (str != null && f24876g.matcher(str).matches()) {
            return str;
        }
        throw new IllegalArgumentException(String.format("Invalid topic name: %s does not match the allowed format %s.", new Object[]{str, f24875f}));
    }

    public static TopicOperation f(@NonNull String str) {
        return new TopicOperation(ExifInterface.R4, str);
    }

    public static TopicOperation g(@NonNull String str) {
        return new TopicOperation("U", str);
    }

    public String b() {
        return this.f24878b;
    }

    public String c() {
        return this.f24877a;
    }

    public String e() {
        return this.f24879c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof TopicOperation)) {
            return false;
        }
        TopicOperation topicOperation = (TopicOperation) obj;
        return this.f24877a.equals(topicOperation.f24877a) && this.f24878b.equals(topicOperation.f24878b);
    }

    public int hashCode() {
        return Objects.c(this.f24878b, this.f24877a);
    }
}
