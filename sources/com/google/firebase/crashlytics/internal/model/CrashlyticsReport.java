package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_RolloutsState;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User;
import com.google.firebase.encoders.annotations.Encodable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;
import java.util.List;

@AutoValue
@Encodable
public abstract class CrashlyticsReport {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f24183a = Charset.forName("UTF-8");

    @AutoValue
    public static abstract class ApplicationExitInfo {

        @AutoValue
        public static abstract class BuildIdMappingForArch {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract BuildIdMappingForArch a();

                @NonNull
                public abstract Builder b(@NonNull String str);

                @NonNull
                public abstract Builder c(@NonNull String str);

                @NonNull
                public abstract Builder d(@NonNull String str);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.Builder();
            }

            @NonNull
            public abstract String b();

            @NonNull
            public abstract String c();

            @NonNull
            public abstract String d();
        }

        @AutoValue.Builder
        public static abstract class Builder {
            @NonNull
            public abstract ApplicationExitInfo a();

            @NonNull
            public abstract Builder b(@Nullable List<BuildIdMappingForArch> list);

            @NonNull
            public abstract Builder c(@NonNull int i2);

            @NonNull
            public abstract Builder d(@NonNull int i2);

            @NonNull
            public abstract Builder e(@NonNull String str);

            @NonNull
            public abstract Builder f(@NonNull long j2);

            @NonNull
            public abstract Builder g(@NonNull int i2);

            @NonNull
            public abstract Builder h(@NonNull long j2);

            @NonNull
            public abstract Builder i(@NonNull long j2);

            @NonNull
            public abstract Builder j(@Nullable String str);
        }

        @NonNull
        public static Builder a() {
            return new AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder();
        }

        @Nullable
        public abstract List<BuildIdMappingForArch> b();

        @NonNull
        public abstract int c();

        @NonNull
        public abstract int d();

        @NonNull
        public abstract String e();

        @NonNull
        public abstract long f();

        @NonNull
        public abstract int g();

        @NonNull
        public abstract long h();

        @NonNull
        public abstract long i();

        @Nullable
        public abstract String j();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Architecture {
        public static final int E = 5;
        public static final int F = 6;
        public static final int G = 9;
        public static final int H = 0;
        public static final int I = 1;
        public static final int J = 7;
    }

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract CrashlyticsReport a();

        @NonNull
        public abstract Builder b(ApplicationExitInfo applicationExitInfo);

        @NonNull
        public abstract Builder c(@Nullable String str);

        @NonNull
        public abstract Builder d(@NonNull String str);

        @NonNull
        public abstract Builder e(@NonNull String str);

        @NonNull
        public abstract Builder f(@Nullable String str);

        @NonNull
        public abstract Builder g(@Nullable String str);

        @NonNull
        public abstract Builder h(@NonNull String str);

        @NonNull
        public abstract Builder i(@NonNull String str);

        @NonNull
        public abstract Builder j(FilesPayload filesPayload);

        @NonNull
        public abstract Builder k(int i2);

        @NonNull
        public abstract Builder l(@NonNull String str);

        @NonNull
        public abstract Builder m(@NonNull Session session);
    }

    @AutoValue
    public static abstract class CustomAttribute {

        @AutoValue.Builder
        public static abstract class Builder {
            @NonNull
            public abstract CustomAttribute a();

            @NonNull
            public abstract Builder b(@NonNull String str);

            @NonNull
            public abstract Builder c(@NonNull String str);
        }

        @NonNull
        public static Builder a() {
            return new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
        }

        @NonNull
        public abstract String b();

        @NonNull
        public abstract String c();
    }

    @AutoValue
    public static abstract class FilesPayload {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract FilesPayload a();

            public abstract Builder b(List<File> list);

            public abstract Builder c(String str);
        }

        @AutoValue
        public static abstract class File {

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract File a();

                public abstract Builder b(byte[] bArr);

                public abstract Builder c(String str);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_FilesPayload_File.Builder();
            }

            @NonNull
            public abstract byte[] b();

            @NonNull
            public abstract String c();
        }

        @NonNull
        public static Builder a() {
            return new AutoValue_CrashlyticsReport_FilesPayload.Builder();
        }

        @NonNull
        public abstract List<File> b();

        @Nullable
        public abstract String c();

        /* access modifiers changed from: package-private */
        public abstract Builder d();
    }

    @AutoValue
    public static abstract class Session {

        @AutoValue
        public static abstract class Application {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract Application a();

                @NonNull
                public abstract Builder b(@Nullable String str);

                @NonNull
                public abstract Builder c(@Nullable String str);

                @NonNull
                public abstract Builder d(@NonNull String str);

                @NonNull
                public abstract Builder e(@NonNull String str);

                @NonNull
                public abstract Builder f(@NonNull String str);

                @NonNull
                public abstract Builder g(@NonNull Organization organization);

                @NonNull
                public abstract Builder h(@NonNull String str);
            }

            @AutoValue
            public static abstract class Organization {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract Organization a();

                    @NonNull
                    public abstract Builder b(@NonNull String str);
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Application_Organization.Builder();
                }

                @NonNull
                public abstract String b();

                /* access modifiers changed from: protected */
                @NonNull
                public abstract Builder c();
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Application.Builder();
            }

            @Nullable
            public abstract String b();

            @Nullable
            public abstract String c();

            @Nullable
            public abstract String d();

            @NonNull
            public abstract String e();

            @Nullable
            public abstract String f();

            @Nullable
            public abstract Organization g();

            @NonNull
            public abstract String h();

            /* access modifiers changed from: protected */
            @NonNull
            public abstract Builder i();

            /* access modifiers changed from: package-private */
            @NonNull
            public Application j(@NonNull String str) {
                Organization g2 = g();
                return i().g((g2 != null ? g2.c() : Organization.a()).b(str).a()).a();
            }
        }

        @AutoValue.Builder
        public static abstract class Builder {
            @NonNull
            public abstract Session a();

            @NonNull
            public abstract Builder b(@NonNull Application application);

            @NonNull
            public abstract Builder c(@Nullable String str);

            @NonNull
            public abstract Builder d(boolean z);

            @NonNull
            public abstract Builder e(@NonNull Device device);

            @NonNull
            public abstract Builder f(@NonNull Long l2);

            @NonNull
            public abstract Builder g(@NonNull List<Event> list);

            @NonNull
            public abstract Builder h(@NonNull String str);

            @NonNull
            public abstract Builder i(int i2);

            @NonNull
            public abstract Builder j(@NonNull String str);

            @NonNull
            public Builder k(@NonNull byte[] bArr) {
                return j(new String(bArr, CrashlyticsReport.f24183a));
            }

            @NonNull
            public abstract Builder l(@NonNull OperatingSystem operatingSystem);

            @NonNull
            public abstract Builder m(long j2);

            @NonNull
            public abstract Builder n(@NonNull User user);
        }

        @AutoValue
        public static abstract class Device {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract Device a();

                @NonNull
                public abstract Builder b(int i2);

                @NonNull
                public abstract Builder c(int i2);

                @NonNull
                public abstract Builder d(long j2);

                @NonNull
                public abstract Builder e(@NonNull String str);

                @NonNull
                public abstract Builder f(@NonNull String str);

                @NonNull
                public abstract Builder g(@NonNull String str);

                @NonNull
                public abstract Builder h(long j2);

                @NonNull
                public abstract Builder i(boolean z);

                @NonNull
                public abstract Builder j(int i2);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Device.Builder();
            }

            @NonNull
            public abstract int b();

            public abstract int c();

            public abstract long d();

            @NonNull
            public abstract String e();

            @NonNull
            public abstract String f();

            @NonNull
            public abstract String g();

            public abstract long h();

            public abstract int i();

            public abstract boolean j();
        }

        @AutoValue
        public static abstract class Event {

            @AutoValue
            public static abstract class Application {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract Application a();

                    @NonNull
                    public abstract Builder b(@Nullable List<ProcessDetails> list);

                    @NonNull
                    public abstract Builder c(@Nullable Boolean bool);

                    @NonNull
                    public abstract Builder d(@Nullable ProcessDetails processDetails);

                    @NonNull
                    public abstract Builder e(@NonNull List<CustomAttribute> list);

                    @NonNull
                    public abstract Builder f(@NonNull Execution execution);

                    @NonNull
                    public abstract Builder g(@NonNull List<CustomAttribute> list);

                    @NonNull
                    public abstract Builder h(int i2);
                }

                @AutoValue
                public static abstract class Execution {

                    @AutoValue
                    public static abstract class BinaryImage {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            @NonNull
                            public abstract BinaryImage a();

                            @NonNull
                            public abstract Builder b(long j2);

                            @NonNull
                            public abstract Builder c(@NonNull String str);

                            @NonNull
                            public abstract Builder d(long j2);

                            @NonNull
                            public abstract Builder e(@Nullable String str);

                            @NonNull
                            public Builder f(@NonNull byte[] bArr) {
                                return e(new String(bArr, CrashlyticsReport.f24183a));
                            }
                        }

                        @NonNull
                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
                        }

                        @NonNull
                        public abstract long b();

                        @NonNull
                        public abstract String c();

                        public abstract long d();

                        @Encodable.Ignore
                        @Nullable
                        public abstract String e();

                        @Nullable
                        @Encodable.Field(name = "uuid")
                        public byte[] f() {
                            String e2 = e();
                            if (e2 != null) {
                                return e2.getBytes(CrashlyticsReport.f24183a);
                            }
                            return null;
                        }
                    }

                    @AutoValue.Builder
                    public static abstract class Builder {
                        @NonNull
                        public abstract Execution a();

                        @NonNull
                        public abstract Builder b(@NonNull ApplicationExitInfo applicationExitInfo);

                        @NonNull
                        public abstract Builder c(@NonNull List<BinaryImage> list);

                        @NonNull
                        public abstract Builder d(@NonNull Exception exception);

                        @NonNull
                        public abstract Builder e(@NonNull Signal signal);

                        @NonNull
                        public abstract Builder f(@NonNull List<Thread> list);
                    }

                    @AutoValue
                    public static abstract class Exception {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            @NonNull
                            public abstract Exception a();

                            @NonNull
                            public abstract Builder b(@NonNull Exception exception);

                            @NonNull
                            public abstract Builder c(@NonNull List<Thread.Frame> list);

                            @NonNull
                            public abstract Builder d(int i2);

                            @NonNull
                            public abstract Builder e(@NonNull String str);

                            @NonNull
                            public abstract Builder f(@NonNull String str);
                        }

                        @NonNull
                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.Builder();
                        }

                        @Nullable
                        public abstract Exception b();

                        @NonNull
                        public abstract List<Thread.Frame> c();

                        public abstract int d();

                        @Nullable
                        public abstract String e();

                        @NonNull
                        public abstract String f();
                    }

                    @AutoValue
                    public static abstract class Signal {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            @NonNull
                            public abstract Signal a();

                            @NonNull
                            public abstract Builder b(long j2);

                            @NonNull
                            public abstract Builder c(@NonNull String str);

                            @NonNull
                            public abstract Builder d(@NonNull String str);
                        }

                        @NonNull
                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.Builder();
                        }

                        @NonNull
                        public abstract long b();

                        @NonNull
                        public abstract String c();

                        @NonNull
                        public abstract String d();
                    }

                    @AutoValue
                    public static abstract class Thread {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            @NonNull
                            public abstract Thread a();

                            @NonNull
                            public abstract Builder b(@NonNull List<Frame> list);

                            @NonNull
                            public abstract Builder c(int i2);

                            @NonNull
                            public abstract Builder d(@NonNull String str);
                        }

                        @AutoValue
                        public static abstract class Frame {

                            @AutoValue.Builder
                            public static abstract class Builder {
                                @NonNull
                                public abstract Frame a();

                                @NonNull
                                public abstract Builder b(@NonNull String str);

                                @NonNull
                                public abstract Builder c(int i2);

                                @NonNull
                                public abstract Builder d(long j2);

                                @NonNull
                                public abstract Builder e(long j2);

                                @NonNull
                                public abstract Builder f(@NonNull String str);
                            }

                            @NonNull
                            public static Builder a() {
                                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
                            }

                            @Nullable
                            public abstract String b();

                            public abstract int c();

                            public abstract long d();

                            public abstract long e();

                            @NonNull
                            public abstract String f();
                        }

                        @NonNull
                        public static Builder a() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.Builder();
                        }

                        @NonNull
                        public abstract List<Frame> b();

                        public abstract int c();

                        @NonNull
                        public abstract String d();
                    }

                    @NonNull
                    public static Builder a() {
                        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution.Builder();
                    }

                    @Nullable
                    public abstract ApplicationExitInfo b();

                    @NonNull
                    public abstract List<BinaryImage> c();

                    @Nullable
                    public abstract Exception d();

                    @NonNull
                    public abstract Signal e();

                    @Nullable
                    public abstract List<Thread> f();
                }

                @AutoValue
                public static abstract class ProcessDetails {

                    @AutoValue.Builder
                    public static abstract class Builder {
                        @NonNull
                        public abstract ProcessDetails a();

                        @NonNull
                        public abstract Builder b(boolean z);

                        @NonNull
                        public abstract Builder c(int i2);

                        @NonNull
                        public abstract Builder d(int i2);

                        @NonNull
                        public abstract Builder e(@NonNull String str);
                    }

                    @NonNull
                    public static Builder a() {
                        return new AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.Builder();
                    }

                    public abstract int b();

                    public abstract int c();

                    @NonNull
                    public abstract String d();

                    public abstract boolean e();
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Application.Builder();
                }

                @Nullable
                public abstract List<ProcessDetails> b();

                @Nullable
                public abstract Boolean c();

                @Nullable
                public abstract ProcessDetails d();

                @Nullable
                public abstract List<CustomAttribute> e();

                @NonNull
                public abstract Execution f();

                @Nullable
                public abstract List<CustomAttribute> g();

                public abstract int h();

                @NonNull
                public abstract Builder i();
            }

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract Event a();

                @NonNull
                public abstract Builder b(@NonNull Application application);

                @NonNull
                public abstract Builder c(@NonNull Device device);

                @NonNull
                public abstract Builder d(@NonNull Log log);

                @NonNull
                public abstract Builder e(@NonNull RolloutsState rolloutsState);

                @NonNull
                public abstract Builder f(long j2);

                @NonNull
                public abstract Builder g(@NonNull String str);
            }

            @AutoValue
            public static abstract class Device {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract Device a();

                    @NonNull
                    public abstract Builder b(Double d2);

                    @NonNull
                    public abstract Builder c(int i2);

                    @NonNull
                    public abstract Builder d(long j2);

                    @NonNull
                    public abstract Builder e(int i2);

                    @NonNull
                    public abstract Builder f(boolean z);

                    @NonNull
                    public abstract Builder g(long j2);
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
                }

                @Nullable
                public abstract Double b();

                public abstract int c();

                public abstract long d();

                public abstract int e();

                public abstract long f();

                public abstract boolean g();
            }

            @AutoValue
            public static abstract class Log {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract Log a();

                    @NonNull
                    public abstract Builder b(@NonNull String str);
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Log.Builder();
                }

                @NonNull
                public abstract String b();
            }

            @AutoValue
            public static abstract class RolloutAssignment {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract RolloutAssignment a();

                    @NonNull
                    public abstract Builder b(@NonNull String str);

                    @NonNull
                    public abstract Builder c(@NonNull String str);

                    @NonNull
                    public abstract Builder d(@NonNull RolloutVariant rolloutVariant);

                    @NonNull
                    public abstract Builder e(@NonNull long j2);
                }

                @AutoValue
                public static abstract class RolloutVariant {

                    @AutoValue.Builder
                    public static abstract class Builder {
                        @NonNull
                        public abstract RolloutVariant a();

                        @NonNull
                        public abstract Builder b(@NonNull String str);

                        @NonNull
                        public abstract Builder c(@NonNull String str);
                    }

                    public static Builder a() {
                        return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.Builder();
                    }

                    @NonNull
                    public abstract String b();

                    @NonNull
                    public abstract String c();
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.Builder();
                }

                @NonNull
                public abstract String b();

                @NonNull
                public abstract String c();

                @NonNull
                public abstract RolloutVariant d();

                @NonNull
                public abstract long e();
            }

            @AutoValue
            public static abstract class RolloutsState {

                @AutoValue.Builder
                public static abstract class Builder {
                    @NonNull
                    public abstract RolloutsState a();

                    @NonNull
                    public abstract Builder b(@NonNull List<RolloutAssignment> list);
                }

                @NonNull
                public static Builder a() {
                    return new AutoValue_CrashlyticsReport_Session_Event_RolloutsState.Builder();
                }

                @NonNull
                @Encodable.Field(name = "assignments")
                public abstract List<RolloutAssignment> b();
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_Event.Builder();
            }

            @NonNull
            public abstract Application b();

            @NonNull
            public abstract Device c();

            @Nullable
            public abstract Log d();

            @Nullable
            public abstract RolloutsState e();

            public abstract long f();

            @NonNull
            public abstract String g();

            @NonNull
            public abstract Builder h();
        }

        @AutoValue
        public static abstract class OperatingSystem {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract OperatingSystem a();

                @NonNull
                public abstract Builder b(@NonNull String str);

                @NonNull
                public abstract Builder c(boolean z);

                @NonNull
                public abstract Builder d(int i2);

                @NonNull
                public abstract Builder e(@NonNull String str);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
            }

            @NonNull
            public abstract String b();

            public abstract int c();

            @NonNull
            public abstract String d();

            public abstract boolean e();
        }

        @AutoValue
        public static abstract class User {

            @AutoValue.Builder
            public static abstract class Builder {
                @NonNull
                public abstract User a();

                @NonNull
                public abstract Builder b(@NonNull String str);
            }

            @NonNull
            public static Builder a() {
                return new AutoValue_CrashlyticsReport_Session_User.Builder();
            }

            @NonNull
            public abstract String b();
        }

        @NonNull
        public static Builder a() {
            return new AutoValue_CrashlyticsReport_Session.Builder().d(false);
        }

        @NonNull
        public abstract Application b();

        @Nullable
        public abstract String c();

        @Nullable
        public abstract Device d();

        @Nullable
        public abstract Long e();

        @Nullable
        public abstract List<Event> f();

        @NonNull
        public abstract String g();

        public abstract int h();

        @NonNull
        @Encodable.Ignore
        public abstract String i();

        @NonNull
        @Encodable.Field(name = "identifier")
        public byte[] j() {
            return i().getBytes(CrashlyticsReport.f24183a);
        }

        @Nullable
        public abstract OperatingSystem k();

        public abstract long l();

        @Nullable
        public abstract User m();

        public abstract boolean n();

        @NonNull
        public abstract Builder o();

        /* access modifiers changed from: package-private */
        @NonNull
        public Session p(@Nullable String str) {
            return o().c(str).a();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Session q(@NonNull List<Event> list) {
            return o().g(list).a();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Session r(@NonNull String str) {
            return o().b(b().j(str)).a();
        }

        /* access modifiers changed from: package-private */
        @NonNull
        public Session s(long j2, boolean z, @Nullable String str) {
            Builder o = o();
            o.f(Long.valueOf(j2));
            o.d(z);
            if (str != null) {
                o.n(User.a().b(str).a());
            }
            return o.a();
        }
    }

    public enum Type {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    @NonNull
    public static Builder b() {
        return new AutoValue_CrashlyticsReport.Builder();
    }

    @Nullable
    public abstract ApplicationExitInfo c();

    @Nullable
    public abstract String d();

    @NonNull
    public abstract String e();

    @NonNull
    public abstract String f();

    @Nullable
    public abstract String g();

    @Nullable
    public abstract String h();

    @NonNull
    public abstract String i();

    @NonNull
    public abstract String j();

    @Nullable
    public abstract FilesPayload k();

    public abstract int l();

    @NonNull
    public abstract String m();

    @Nullable
    public abstract Session n();

    @Encodable.Ignore
    public Type o() {
        if (n() != null) {
            return Type.JAVA;
        }
        return k() != null ? Type.NATIVE : Type.INCOMPLETE;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract Builder p();

    @NonNull
    public CrashlyticsReport q(@Nullable String str) {
        Builder c2 = p().c(str);
        if (n() != null) {
            c2.m(n().p(str));
        }
        return c2.a();
    }

    @NonNull
    public CrashlyticsReport r(ApplicationExitInfo applicationExitInfo) {
        return applicationExitInfo == null ? this : p().b(applicationExitInfo).a();
    }

    @NonNull
    public CrashlyticsReport s(@NonNull List<Session.Event> list) {
        if (n() != null) {
            return p().m(n().q(list)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    @NonNull
    public CrashlyticsReport t(@Nullable String str) {
        return p().f(str).a();
    }

    @NonNull
    public CrashlyticsReport u(@Nullable String str) {
        return p().g(str).a();
    }

    @NonNull
    public CrashlyticsReport v(@NonNull FilesPayload filesPayload) {
        return p().m((Session) null).j(filesPayload).a();
    }

    @NonNull
    public CrashlyticsReport w(@NonNull String str) {
        Builder p = p();
        FilesPayload k2 = k();
        if (k2 != null) {
            p.j(k2.d().c(str).a());
        }
        Session n2 = n();
        if (n2 != null) {
            p.m(n2.r(str));
        }
        return p.a();
    }

    @NonNull
    public CrashlyticsReport x(long j2, boolean z, @Nullable String str) {
        Builder p = p();
        if (n() != null) {
            p.m(n().s(j2, z, str));
        }
        return p.a();
    }
}
