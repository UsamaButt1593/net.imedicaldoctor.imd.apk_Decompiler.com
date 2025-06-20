package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import java.io.IOException;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final int f19374a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final Configurator f19375b = new AutoProtoEncoderDoNotUseEncoder();

    private static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final ClientMetricsEncoder f19376a = new ClientMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19377b = FieldDescriptor.a("window").b(AtProtobuf.b().d(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19378c = FieldDescriptor.a("logSourceMetrics").b(AtProtobuf.b().d(2).a()).a();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f19379d = FieldDescriptor.a("globalMetrics").b(AtProtobuf.b().d(3).a()).a();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f19380e = FieldDescriptor.a("appNamespace").b(AtProtobuf.b().d(4).a()).a();

        private ClientMetricsEncoder() {
        }

        /* renamed from: b */
        public void a(ClientMetrics clientMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19377b, clientMetrics.g());
            objectEncoderContext.s(f19378c, clientMetrics.e());
            objectEncoderContext.s(f19379d, clientMetrics.d());
            objectEncoderContext.s(f19380e, clientMetrics.a());
        }
    }

    private static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final GlobalMetricsEncoder f19381a = new GlobalMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19382b = FieldDescriptor.a("storageMetrics").b(AtProtobuf.b().d(1).a()).a();

        private GlobalMetricsEncoder() {
        }

        /* renamed from: b */
        public void a(GlobalMetrics globalMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19382b, globalMetrics.c());
        }
    }

    private static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {

        /* renamed from: a  reason: collision with root package name */
        static final LogEventDroppedEncoder f19383a = new LogEventDroppedEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19384b = FieldDescriptor.a("eventsDroppedCount").b(AtProtobuf.b().d(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19385c = FieldDescriptor.a("reason").b(AtProtobuf.b().d(3).a()).a();

        private LogEventDroppedEncoder() {
        }

        /* renamed from: b */
        public void a(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f19384b, logEventDropped.b());
            objectEncoderContext.s(f19385c, logEventDropped.c());
        }
    }

    private static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final LogSourceMetricsEncoder f19386a = new LogSourceMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19387b = FieldDescriptor.a("logSource").b(AtProtobuf.b().d(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19388c = FieldDescriptor.a("logEventDropped").b(AtProtobuf.b().d(2).a()).a();

        private LogSourceMetricsEncoder() {
        }

        /* renamed from: b */
        public void a(LogSourceMetrics logSourceMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19387b, logSourceMetrics.c());
            objectEncoderContext.s(f19388c, logSourceMetrics.b());
        }
    }

    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* renamed from: a  reason: collision with root package name */
        static final ProtoEncoderDoNotUseEncoder f19389a = new ProtoEncoderDoNotUseEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19390b = FieldDescriptor.d("clientMetrics");

        private ProtoEncoderDoNotUseEncoder() {
        }

        /* renamed from: b */
        public void a(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19390b, protoEncoderDoNotUse.c());
        }
    }

    private static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final StorageMetricsEncoder f19391a = new StorageMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19392b = FieldDescriptor.a("currentCacheSizeBytes").b(AtProtobuf.b().d(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19393c = FieldDescriptor.a("maxCacheSizeBytes").b(AtProtobuf.b().d(2).a()).a();

        private StorageMetricsEncoder() {
        }

        /* renamed from: b */
        public void a(StorageMetrics storageMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f19392b, storageMetrics.a());
            objectEncoderContext.c(f19393c, storageMetrics.c());
        }
    }

    private static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {

        /* renamed from: a  reason: collision with root package name */
        static final TimeWindowEncoder f19394a = new TimeWindowEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19395b = FieldDescriptor.a("startMs").b(AtProtobuf.b().d(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19396c = FieldDescriptor.a("endMs").b(AtProtobuf.b().d(2).a()).a();

        private TimeWindowEncoder() {
        }

        /* renamed from: b */
        public void a(TimeWindow timeWindow, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f19395b, timeWindow.c());
            objectEncoderContext.c(f19396c, timeWindow.b());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        encoderConfig.b(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.f19389a);
        encoderConfig.b(ClientMetrics.class, ClientMetricsEncoder.f19376a);
        encoderConfig.b(TimeWindow.class, TimeWindowEncoder.f19394a);
        encoderConfig.b(LogSourceMetrics.class, LogSourceMetricsEncoder.f19386a);
        encoderConfig.b(LogEventDropped.class, LogEventDroppedEncoder.f19383a);
        encoderConfig.b(GlobalMetrics.class, GlobalMetricsEncoder.f19381a);
        encoderConfig.b(StorageMetrics.class, StorageMetricsEncoder.f19391a);
    }
}
