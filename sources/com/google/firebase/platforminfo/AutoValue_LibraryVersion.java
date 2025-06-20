package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

final class AutoValue_LibraryVersion extends LibraryVersion {

    /* renamed from: a  reason: collision with root package name */
    private final String f24963a;

    /* renamed from: b  reason: collision with root package name */
    private final String f24964b;

    AutoValue_LibraryVersion(String str, String str2) {
        if (str != null) {
            this.f24963a = str;
            if (str2 != null) {
                this.f24964b = str2;
                return;
            }
            throw new NullPointerException("Null version");
        }
        throw new NullPointerException("Null libraryName");
    }

    @Nonnull
    public String b() {
        return this.f24963a;
    }

    @Nonnull
    public String c() {
        return this.f24964b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LibraryVersion)) {
            return false;
        }
        LibraryVersion libraryVersion = (LibraryVersion) obj;
        return this.f24963a.equals(libraryVersion.b()) && this.f24964b.equals(libraryVersion.c());
    }

    public int hashCode() {
        return ((this.f24963a.hashCode() ^ 1000003) * 1000003) ^ this.f24964b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f24963a + ", version=" + this.f24964b + "}";
    }
}
