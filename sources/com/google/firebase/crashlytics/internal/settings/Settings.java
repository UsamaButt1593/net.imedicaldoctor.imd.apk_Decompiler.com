package com.google.firebase.crashlytics.internal.settings;

public class Settings {

    /* renamed from: a  reason: collision with root package name */
    public final SessionData f24263a;

    /* renamed from: b  reason: collision with root package name */
    public final FeatureFlagData f24264b;

    /* renamed from: c  reason: collision with root package name */
    public final long f24265c;

    /* renamed from: d  reason: collision with root package name */
    public final int f24266d;

    /* renamed from: e  reason: collision with root package name */
    public final int f24267e;

    /* renamed from: f  reason: collision with root package name */
    public final double f24268f;

    /* renamed from: g  reason: collision with root package name */
    public final double f24269g;

    /* renamed from: h  reason: collision with root package name */
    public final int f24270h;

    public static class FeatureFlagData {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f24271a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f24272b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f24273c;

        public FeatureFlagData(boolean z, boolean z2, boolean z3) {
            this.f24271a = z;
            this.f24272b = z2;
            this.f24273c = z3;
        }
    }

    public static class SessionData {

        /* renamed from: a  reason: collision with root package name */
        public final int f24274a;

        /* renamed from: b  reason: collision with root package name */
        public final int f24275b;

        public SessionData(int i2, int i3) {
            this.f24274a = i2;
            this.f24275b = i3;
        }
    }

    public Settings(long j2, SessionData sessionData, FeatureFlagData featureFlagData, int i2, int i3, double d2, double d3, int i4) {
        this.f24265c = j2;
        this.f24263a = sessionData;
        this.f24264b = featureFlagData;
        this.f24266d = i2;
        this.f24267e = i3;
        this.f24268f = d2;
        this.f24269g = d3;
        this.f24270h = i4;
    }

    public boolean a(long j2) {
        return this.f24265c < j2;
    }
}
