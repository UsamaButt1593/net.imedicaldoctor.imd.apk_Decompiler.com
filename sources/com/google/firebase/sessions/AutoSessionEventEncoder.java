package com.google.firebase.sessions;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoSessionEventEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final int f25013a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final Configurator f25014b = new AutoSessionEventEncoder();

    private static final class AndroidApplicationInfoEncoder implements ObjectEncoder<AndroidApplicationInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final AndroidApplicationInfoEncoder f25015a = new AndroidApplicationInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f25016b = FieldDescriptor.d("packageName");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f25017c = FieldDescriptor.d("versionName");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f25018d = FieldDescriptor.d("appBuildVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f25019e = FieldDescriptor.d("deviceManufacturer");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f25020f = FieldDescriptor.d("currentProcessDetails");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f25021g = FieldDescriptor.d("appProcessDetails");

        private AndroidApplicationInfoEncoder() {
        }

        /* renamed from: b */
        public void a(AndroidApplicationInfo androidApplicationInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f25016b, androidApplicationInfo.m());
            objectEncoderContext.s(f25017c, androidApplicationInfo.n());
            objectEncoderContext.s(f25018d, androidApplicationInfo.i());
            objectEncoderContext.s(f25019e, androidApplicationInfo.l());
            objectEncoderContext.s(f25020f, androidApplicationInfo.k());
            objectEncoderContext.s(f25021g, androidApplicationInfo.j());
        }
    }

    private static final class ApplicationInfoEncoder implements ObjectEncoder<ApplicationInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final ApplicationInfoEncoder f25022a = new ApplicationInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f25023b = FieldDescriptor.d("appId");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f25024c = FieldDescriptor.d("deviceModel");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f25025d = FieldDescriptor.d("sessionSdkVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f25026e = FieldDescriptor.d("osVersion");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f25027f = FieldDescriptor.d("logEnvironment");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f25028g = FieldDescriptor.d("androidAppInfo");

        private ApplicationInfoEncoder() {
        }

        /* renamed from: b */
        public void a(ApplicationInfo applicationInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f25023b, applicationInfo.j());
            objectEncoderContext.s(f25024c, applicationInfo.k());
            objectEncoderContext.s(f25025d, applicationInfo.n());
            objectEncoderContext.s(f25026e, applicationInfo.m());
            objectEncoderContext.s(f25027f, applicationInfo.l());
            objectEncoderContext.s(f25028g, applicationInfo.i());
        }
    }

    private static final class DataCollectionStatusEncoder implements ObjectEncoder<DataCollectionStatus> {

        /* renamed from: a  reason: collision with root package name */
        static final DataCollectionStatusEncoder f25029a = new DataCollectionStatusEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f25030b = FieldDescriptor.d("performance");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f25031c = FieldDescriptor.d("crashlytics");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f25032d = FieldDescriptor.d("sessionSamplingRate");

        private DataCollectionStatusEncoder() {
        }

        /* renamed from: b */
        public void a(DataCollectionStatus dataCollectionStatus, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f25030b, dataCollectionStatus.g());
            objectEncoderContext.s(f25031c, dataCollectionStatus.f());
            objectEncoderContext.g(f25032d, dataCollectionStatus.h());
        }
    }

    private static final class ProcessDetailsEncoder implements ObjectEncoder<ProcessDetails> {

        /* renamed from: a  reason: collision with root package name */
        static final ProcessDetailsEncoder f25033a = new ProcessDetailsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f25034b = FieldDescriptor.d("processName");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f25035c = FieldDescriptor.d("pid");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f25036d = FieldDescriptor.d("importance");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f25037e = FieldDescriptor.d("defaultProcess");

        private ProcessDetailsEncoder() {
        }

        /* renamed from: b */
        public void a(ProcessDetails processDetails, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f25034b, processDetails.i());
            objectEncoderContext.d(f25035c, processDetails.h());
            objectEncoderContext.d(f25036d, processDetails.g());
            objectEncoderContext.b(f25037e, processDetails.j());
        }
    }

    private static final class SessionEventEncoder implements ObjectEncoder<SessionEvent> {

        /* renamed from: a  reason: collision with root package name */
        static final SessionEventEncoder f25038a = new SessionEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f25039b = FieldDescriptor.d("eventType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f25040c = FieldDescriptor.d("sessionData");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f25041d = FieldDescriptor.d("applicationInfo");

        private SessionEventEncoder() {
        }

        /* renamed from: b */
        public void a(SessionEvent sessionEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f25039b, sessionEvent.g());
            objectEncoderContext.s(f25040c, sessionEvent.h());
            objectEncoderContext.s(f25041d, sessionEvent.f());
        }
    }

    private static final class SessionInfoEncoder implements ObjectEncoder<SessionInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final SessionInfoEncoder f25042a = new SessionInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f25043b = FieldDescriptor.d("sessionId");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f25044c = FieldDescriptor.d("firstSessionId");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f25045d = FieldDescriptor.d("sessionIndex");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f25046e = FieldDescriptor.d("eventTimestampUs");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f25047f = FieldDescriptor.d("dataCollectionStatus");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f25048g = FieldDescriptor.d("firebaseInstallationId");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f25049h = FieldDescriptor.d("firebaseAuthenticationToken");

        private SessionInfoEncoder() {
        }

        /* renamed from: b */
        public void a(SessionInfo sessionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f25043b, sessionInfo.o());
            objectEncoderContext.s(f25044c, sessionInfo.n());
            objectEncoderContext.d(f25045d, sessionInfo.p());
            objectEncoderContext.c(f25046e, sessionInfo.k());
            objectEncoderContext.s(f25047f, sessionInfo.j());
            objectEncoderContext.s(f25048g, sessionInfo.m());
            objectEncoderContext.s(f25049h, sessionInfo.l());
        }
    }

    private AutoSessionEventEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        encoderConfig.b(SessionEvent.class, SessionEventEncoder.f25038a);
        encoderConfig.b(SessionInfo.class, SessionInfoEncoder.f25042a);
        encoderConfig.b(DataCollectionStatus.class, DataCollectionStatusEncoder.f25029a);
        encoderConfig.b(ApplicationInfo.class, ApplicationInfoEncoder.f25022a);
        encoderConfig.b(AndroidApplicationInfo.class, AndroidApplicationInfoEncoder.f25015a);
        encoderConfig.b(ProcessDetails.class, ProcessDetailsEncoder.f25033a);
    }
}
