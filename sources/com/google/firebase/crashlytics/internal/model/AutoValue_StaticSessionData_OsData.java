package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;

final class AutoValue_StaticSessionData_OsData extends StaticSessionData.OsData {

    /* renamed from: a  reason: collision with root package name */
    private final String f24180a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24181b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f24182c;

    AutoValue_StaticSessionData_OsData(String str, String str2, boolean z) {
        if (str != null) {
            this.f24180a = str;
            if (str2 != null) {
                this.f24181b = str2;
                this.f24182c = z;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    public boolean b() {
        return this.f24182c;
    }

    public String c() {
        return this.f24181b;
    }

    public String d() {
        return this.f24180a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData.OsData)) {
            return false;
        }
        StaticSessionData.OsData osData = (StaticSessionData.OsData) obj;
        return this.f24180a.equals(osData.d()) && this.f24181b.equals(osData.c()) && this.f24182c == osData.b();
    }

    public int hashCode() {
        return ((((this.f24180a.hashCode() ^ 1000003) * 1000003) ^ this.f24181b.hashCode()) * 1000003) ^ (this.f24182c ? 1231 : 1237);
    }

    public String toString() {
        return "OsData{osRelease=" + this.f24180a + ", osCodeName=" + this.f24181b + ", isRooted=" + this.f24182c + "}";
    }
}
