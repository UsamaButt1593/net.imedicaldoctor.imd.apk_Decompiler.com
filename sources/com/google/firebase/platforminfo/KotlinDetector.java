package com.google.firebase.platforminfo;

import androidx.annotation.Nullable;
import kotlin.KotlinVersion;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    @Nullable
    public static String a() {
        try {
            return KotlinVersion.Z2.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
