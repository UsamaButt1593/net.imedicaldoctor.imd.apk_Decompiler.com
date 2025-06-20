package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoBatchedLogRequestEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final int f19244a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final Configurator f19245b = new AutoBatchedLogRequestEncoder();

    private static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final AndroidClientInfoEncoder f19246a = new AndroidClientInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19247b = FieldDescriptor.d("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19248c = FieldDescriptor.d("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f19249d = FieldDescriptor.d("hardware");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f19250e = FieldDescriptor.d("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f19251f = FieldDescriptor.d("product");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f19252g = FieldDescriptor.d("osBuild");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f19253h = FieldDescriptor.d("manufacturer");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f19254i = FieldDescriptor.d("fingerprint");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f19255j = FieldDescriptor.d("locale");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f19256k = FieldDescriptor.d("country");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f19257l = FieldDescriptor.d("mccMnc");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f19258m = FieldDescriptor.d("applicationBuild");

        private AndroidClientInfoEncoder() {
        }

        /* renamed from: b */
        public void a(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19247b, androidClientInfo.m());
            objectEncoderContext.s(f19248c, androidClientInfo.j());
            objectEncoderContext.s(f19249d, androidClientInfo.f());
            objectEncoderContext.s(f19250e, androidClientInfo.d());
            objectEncoderContext.s(f19251f, androidClientInfo.l());
            objectEncoderContext.s(f19252g, androidClientInfo.k());
            objectEncoderContext.s(f19253h, androidClientInfo.h());
            objectEncoderContext.s(f19254i, androidClientInfo.e());
            objectEncoderContext.s(f19255j, androidClientInfo.g());
            objectEncoderContext.s(f19256k, androidClientInfo.c());
            objectEncoderContext.s(f19257l, androidClientInfo.i());
            objectEncoderContext.s(f19258m, androidClientInfo.b());
        }
    }

    private static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {

        /* renamed from: a  reason: collision with root package name */
        static final BatchedLogRequestEncoder f19259a = new BatchedLogRequestEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19260b = FieldDescriptor.d("logRequest");

        private BatchedLogRequestEncoder() {
        }

        /* renamed from: b */
        public void a(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19260b, batchedLogRequest.c());
        }
    }

    private static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final ClientInfoEncoder f19261a = new ClientInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19262b = FieldDescriptor.d("clientType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19263c = FieldDescriptor.d("androidClientInfo");

        private ClientInfoEncoder() {
        }

        /* renamed from: b */
        public void a(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19262b, clientInfo.c());
            objectEncoderContext.s(f19263c, clientInfo.b());
        }
    }

    private static final class ComplianceDataEncoder implements ObjectEncoder<ComplianceData> {

        /* renamed from: a  reason: collision with root package name */
        static final ComplianceDataEncoder f19264a = new ComplianceDataEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19265b = FieldDescriptor.d("privacyContext");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19266c = FieldDescriptor.d("productIdOrigin");

        private ComplianceDataEncoder() {
        }

        /* renamed from: b */
        public void a(ComplianceData complianceData, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19265b, complianceData.b());
            objectEncoderContext.s(f19266c, complianceData.c());
        }
    }

    private static final class ExperimentIdsEncoder implements ObjectEncoder<ExperimentIds> {

        /* renamed from: a  reason: collision with root package name */
        static final ExperimentIdsEncoder f19267a = new ExperimentIdsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19268b = FieldDescriptor.d("clearBlob");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19269c = FieldDescriptor.d("encryptedBlob");

        private ExperimentIdsEncoder() {
        }

        /* renamed from: b */
        public void a(ExperimentIds experimentIds, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19268b, experimentIds.b());
            objectEncoderContext.s(f19269c, experimentIds.c());
        }
    }

    private static final class ExternalPRequestContextEncoder implements ObjectEncoder<ExternalPRequestContext> {

        /* renamed from: a  reason: collision with root package name */
        static final ExternalPRequestContextEncoder f19270a = new ExternalPRequestContextEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19271b = FieldDescriptor.d("originAssociatedProductId");

        private ExternalPRequestContextEncoder() {
        }

        /* renamed from: b */
        public void a(ExternalPRequestContext externalPRequestContext, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19271b, externalPRequestContext.b());
        }
    }

    private static final class ExternalPrivacyContextEncoder implements ObjectEncoder<ExternalPrivacyContext> {

        /* renamed from: a  reason: collision with root package name */
        static final ExternalPrivacyContextEncoder f19272a = new ExternalPrivacyContextEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19273b = FieldDescriptor.d("prequest");

        private ExternalPrivacyContextEncoder() {
        }

        /* renamed from: b */
        public void a(ExternalPrivacyContext externalPrivacyContext, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19273b, externalPrivacyContext.b());
        }
    }

    private static final class LogEventEncoder implements ObjectEncoder<LogEvent> {

        /* renamed from: a  reason: collision with root package name */
        static final LogEventEncoder f19274a = new LogEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19275b = FieldDescriptor.d("eventTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19276c = FieldDescriptor.d("eventCode");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f19277d = FieldDescriptor.d("complianceData");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f19278e = FieldDescriptor.d("eventUptimeMs");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f19279f = FieldDescriptor.d("sourceExtension");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f19280g = FieldDescriptor.d("sourceExtensionJsonProto3");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f19281h = FieldDescriptor.d("timezoneOffsetSeconds");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f19282i = FieldDescriptor.d("networkConnectionInfo");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f19283j = FieldDescriptor.d("experimentIds");

        private LogEventEncoder() {
        }

        /* renamed from: b */
        public void a(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f19275b, logEvent.d());
            objectEncoderContext.s(f19276c, logEvent.c());
            objectEncoderContext.s(f19277d, logEvent.b());
            objectEncoderContext.c(f19278e, logEvent.e());
            objectEncoderContext.s(f19279f, logEvent.h());
            objectEncoderContext.s(f19280g, logEvent.i());
            objectEncoderContext.c(f19281h, logEvent.j());
            objectEncoderContext.s(f19282i, logEvent.g());
            objectEncoderContext.s(f19283j, logEvent.f());
        }
    }

    private static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {

        /* renamed from: a  reason: collision with root package name */
        static final LogRequestEncoder f19284a = new LogRequestEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19285b = FieldDescriptor.d("requestTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19286c = FieldDescriptor.d("requestUptimeMs");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f19287d = FieldDescriptor.d("clientInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f19288e = FieldDescriptor.d("logSource");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f19289f = FieldDescriptor.d("logSourceName");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f19290g = FieldDescriptor.d("logEvent");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f19291h = FieldDescriptor.d("qosTier");

        private LogRequestEncoder() {
        }

        /* renamed from: b */
        public void a(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f19285b, logRequest.g());
            objectEncoderContext.c(f19286c, logRequest.h());
            objectEncoderContext.s(f19287d, logRequest.b());
            objectEncoderContext.s(f19288e, logRequest.d());
            objectEncoderContext.s(f19289f, logRequest.e());
            objectEncoderContext.s(f19290g, logRequest.c());
            objectEncoderContext.s(f19291h, logRequest.f());
        }
    }

    private static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final NetworkConnectionInfoEncoder f19292a = new NetworkConnectionInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f19293b = FieldDescriptor.d("networkType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f19294c = FieldDescriptor.d("mobileSubtype");

        private NetworkConnectionInfoEncoder() {
        }

        /* renamed from: b */
        public void a(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f19293b, networkConnectionInfo.c());
            objectEncoderContext.s(f19294c, networkConnectionInfo.b());
        }
    }

    private AutoBatchedLogRequestEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.f19259a;
        encoderConfig.b(BatchedLogRequest.class, batchedLogRequestEncoder);
        encoderConfig.b(AutoValue_BatchedLogRequest.class, batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.f19284a;
        encoderConfig.b(LogRequest.class, logRequestEncoder);
        encoderConfig.b(AutoValue_LogRequest.class, logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.f19261a;
        encoderConfig.b(ClientInfo.class, clientInfoEncoder);
        encoderConfig.b(AutoValue_ClientInfo.class, clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.f19246a;
        encoderConfig.b(AndroidClientInfo.class, androidClientInfoEncoder);
        encoderConfig.b(AutoValue_AndroidClientInfo.class, androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.f19274a;
        encoderConfig.b(LogEvent.class, logEventEncoder);
        encoderConfig.b(AutoValue_LogEvent.class, logEventEncoder);
        ComplianceDataEncoder complianceDataEncoder = ComplianceDataEncoder.f19264a;
        encoderConfig.b(ComplianceData.class, complianceDataEncoder);
        encoderConfig.b(AutoValue_ComplianceData.class, complianceDataEncoder);
        ExternalPrivacyContextEncoder externalPrivacyContextEncoder = ExternalPrivacyContextEncoder.f19272a;
        encoderConfig.b(ExternalPrivacyContext.class, externalPrivacyContextEncoder);
        encoderConfig.b(AutoValue_ExternalPrivacyContext.class, externalPrivacyContextEncoder);
        ExternalPRequestContextEncoder externalPRequestContextEncoder = ExternalPRequestContextEncoder.f19270a;
        encoderConfig.b(ExternalPRequestContext.class, externalPRequestContextEncoder);
        encoderConfig.b(AutoValue_ExternalPRequestContext.class, externalPRequestContextEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.f19292a;
        encoderConfig.b(NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        encoderConfig.b(AutoValue_NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        ExperimentIdsEncoder experimentIdsEncoder = ExperimentIdsEncoder.f19267a;
        encoderConfig.b(ExperimentIds.class, experimentIdsEncoder);
        encoderConfig.b(AutoValue_ExperimentIds.class, experimentIdsEncoder);
    }
}
