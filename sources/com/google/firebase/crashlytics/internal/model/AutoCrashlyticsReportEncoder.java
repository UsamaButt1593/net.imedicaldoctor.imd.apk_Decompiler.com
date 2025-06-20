package com.google.firebase.crashlytics.internal.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;

public final class AutoCrashlyticsReportEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final int f23759a = 2;

    /* renamed from: b  reason: collision with root package name */
    public static final Configurator f23760b = new AutoCrashlyticsReportEncoder();

    private static final class CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder f23761a = new CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23762b = FieldDescriptor.d("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23763c = FieldDescriptor.d("libraryName");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23764d = FieldDescriptor.d("buildId");

        private CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch buildIdMappingForArch, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23762b, buildIdMappingForArch.b());
            objectEncoderContext.s(f23763c, buildIdMappingForArch.d());
            objectEncoderContext.s(f23764d, buildIdMappingForArch.c());
        }
    }

    private static final class CrashlyticsReportApplicationExitInfoEncoder implements ObjectEncoder<CrashlyticsReport.ApplicationExitInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportApplicationExitInfoEncoder f23765a = new CrashlyticsReportApplicationExitInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23766b = FieldDescriptor.d("pid");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23767c = FieldDescriptor.d("processName");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23768d = FieldDescriptor.d("reasonCode");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23769e = FieldDescriptor.d("importance");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23770f = FieldDescriptor.d("pss");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f23771g = FieldDescriptor.d("rss");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f23772h = FieldDescriptor.d("timestamp");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f23773i = FieldDescriptor.d("traceFile");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f23774j = FieldDescriptor.d("buildIdMappingForArch");

        private CrashlyticsReportApplicationExitInfoEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.ApplicationExitInfo applicationExitInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.d(f23766b, applicationExitInfo.d());
            objectEncoderContext.s(f23767c, applicationExitInfo.e());
            objectEncoderContext.d(f23768d, applicationExitInfo.g());
            objectEncoderContext.d(f23769e, applicationExitInfo.c());
            objectEncoderContext.c(f23770f, applicationExitInfo.f());
            objectEncoderContext.c(f23771g, applicationExitInfo.h());
            objectEncoderContext.c(f23772h, applicationExitInfo.i());
            objectEncoderContext.s(f23773i, applicationExitInfo.j());
            objectEncoderContext.s(f23774j, applicationExitInfo.b());
        }
    }

    private static final class CrashlyticsReportCustomAttributeEncoder implements ObjectEncoder<CrashlyticsReport.CustomAttribute> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportCustomAttributeEncoder f23775a = new CrashlyticsReportCustomAttributeEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23776b = FieldDescriptor.d("key");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23777c = FieldDescriptor.d("value");

        private CrashlyticsReportCustomAttributeEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.CustomAttribute customAttribute, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23776b, customAttribute.b());
            objectEncoderContext.s(f23777c, customAttribute.c());
        }
    }

    private static final class CrashlyticsReportEncoder implements ObjectEncoder<CrashlyticsReport> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportEncoder f23778a = new CrashlyticsReportEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23779b = FieldDescriptor.d("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23780c = FieldDescriptor.d("gmpAppId");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23781d = FieldDescriptor.d("platform");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23782e = FieldDescriptor.d("installationUuid");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23783f = FieldDescriptor.d("firebaseInstallationId");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f23784g = FieldDescriptor.d("firebaseAuthenticationToken");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f23785h = FieldDescriptor.d("appQualitySessionId");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f23786i = FieldDescriptor.d("buildVersion");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f23787j = FieldDescriptor.d("displayVersion");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f23788k = FieldDescriptor.d("session");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f23789l = FieldDescriptor.d("ndkPayload");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f23790m = FieldDescriptor.d("appExitInfo");

        private CrashlyticsReportEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport crashlyticsReport, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23779b, crashlyticsReport.m());
            objectEncoderContext.s(f23780c, crashlyticsReport.i());
            objectEncoderContext.d(f23781d, crashlyticsReport.l());
            objectEncoderContext.s(f23782e, crashlyticsReport.j());
            objectEncoderContext.s(f23783f, crashlyticsReport.h());
            objectEncoderContext.s(f23784g, crashlyticsReport.g());
            objectEncoderContext.s(f23785h, crashlyticsReport.d());
            objectEncoderContext.s(f23786i, crashlyticsReport.e());
            objectEncoderContext.s(f23787j, crashlyticsReport.f());
            objectEncoderContext.s(f23788k, crashlyticsReport.n());
            objectEncoderContext.s(f23789l, crashlyticsReport.k());
            objectEncoderContext.s(f23790m, crashlyticsReport.c());
        }
    }

    private static final class CrashlyticsReportFilesPayloadEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportFilesPayloadEncoder f23791a = new CrashlyticsReportFilesPayloadEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23792b = FieldDescriptor.d("files");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23793c = FieldDescriptor.d("orgId");

        private CrashlyticsReportFilesPayloadEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.FilesPayload filesPayload, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23792b, filesPayload.b());
            objectEncoderContext.s(f23793c, filesPayload.c());
        }
    }

    private static final class CrashlyticsReportFilesPayloadFileEncoder implements ObjectEncoder<CrashlyticsReport.FilesPayload.File> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportFilesPayloadFileEncoder f23794a = new CrashlyticsReportFilesPayloadFileEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23795b = FieldDescriptor.d("filename");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23796c = FieldDescriptor.d("contents");

        private CrashlyticsReportFilesPayloadFileEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.FilesPayload.File file, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23795b, file.c());
            objectEncoderContext.s(f23796c, file.b());
        }
    }

    private static final class CrashlyticsReportSessionApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionApplicationEncoder f23797a = new CrashlyticsReportSessionApplicationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23798b = FieldDescriptor.d(DublinCoreProperties.f27401g);

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23799c = FieldDescriptor.d("version");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23800d = FieldDescriptor.d("displayVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23801e = FieldDescriptor.d("organization");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23802f = FieldDescriptor.d("installationUuid");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f23803g = FieldDescriptor.d("developmentPlatform");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f23804h = FieldDescriptor.d("developmentPlatformVersion");

        private CrashlyticsReportSessionApplicationEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Application application, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23798b, application.e());
            objectEncoderContext.s(f23799c, application.h());
            objectEncoderContext.s(f23800d, application.d());
            objectEncoderContext.s(f23801e, application.g());
            objectEncoderContext.s(f23802f, application.f());
            objectEncoderContext.s(f23803g, application.b());
            objectEncoderContext.s(f23804h, application.c());
        }
    }

    private static final class CrashlyticsReportSessionApplicationOrganizationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Application.Organization> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionApplicationOrganizationEncoder f23805a = new CrashlyticsReportSessionApplicationOrganizationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23806b = FieldDescriptor.d("clsId");

        private CrashlyticsReportSessionApplicationOrganizationEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Application.Organization organization, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23806b, organization.b());
        }
    }

    private static final class CrashlyticsReportSessionDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Device> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionDeviceEncoder f23807a = new CrashlyticsReportSessionDeviceEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23808b = FieldDescriptor.d("arch");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23809c = FieldDescriptor.d("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23810d = FieldDescriptor.d("cores");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23811e = FieldDescriptor.d("ram");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23812f = FieldDescriptor.d("diskSpace");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f23813g = FieldDescriptor.d("simulator");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f23814h = FieldDescriptor.d("state");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f23815i = FieldDescriptor.d("manufacturer");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f23816j = FieldDescriptor.d("modelClass");

        private CrashlyticsReportSessionDeviceEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Device device, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.d(f23808b, device.b());
            objectEncoderContext.s(f23809c, device.f());
            objectEncoderContext.d(f23810d, device.c());
            objectEncoderContext.c(f23811e, device.h());
            objectEncoderContext.c(f23812f, device.d());
            objectEncoderContext.b(f23813g, device.j());
            objectEncoderContext.d(f23814h, device.i());
            objectEncoderContext.s(f23815i, device.e());
            objectEncoderContext.s(f23816j, device.g());
        }
    }

    private static final class CrashlyticsReportSessionEncoder implements ObjectEncoder<CrashlyticsReport.Session> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEncoder f23817a = new CrashlyticsReportSessionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23818b = FieldDescriptor.d("generator");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23819c = FieldDescriptor.d(DublinCoreProperties.f27401g);

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23820d = FieldDescriptor.d("appQualitySessionId");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23821e = FieldDescriptor.d("startedAt");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23822f = FieldDescriptor.d("endedAt");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f23823g = FieldDescriptor.d("crashed");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f23824h = FieldDescriptor.d("app");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f23825i = FieldDescriptor.d("user");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f23826j = FieldDescriptor.d("os");

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f23827k = FieldDescriptor.d("device");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f23828l = FieldDescriptor.d("events");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f23829m = FieldDescriptor.d("generatorType");

        private CrashlyticsReportSessionEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session session, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23818b, session.g());
            objectEncoderContext.s(f23819c, session.j());
            objectEncoderContext.s(f23820d, session.c());
            objectEncoderContext.c(f23821e, session.l());
            objectEncoderContext.s(f23822f, session.e());
            objectEncoderContext.b(f23823g, session.n());
            objectEncoderContext.s(f23824h, session.b());
            objectEncoderContext.s(f23825i, session.m());
            objectEncoderContext.s(f23826j, session.k());
            objectEncoderContext.s(f23827k, session.d());
            objectEncoderContext.s(f23828l, session.f());
            objectEncoderContext.d(f23829m, session.h());
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationEncoder f23830a = new CrashlyticsReportSessionEventApplicationEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23831b = FieldDescriptor.d("execution");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23832c = FieldDescriptor.d("customAttributes");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23833d = FieldDescriptor.d("internalKeys");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23834e = FieldDescriptor.d(CSS.Property.f27458a);

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23835f = FieldDescriptor.d("currentProcessDetails");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f23836g = FieldDescriptor.d("appProcessDetails");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f23837h = FieldDescriptor.d("uiOrientation");

        private CrashlyticsReportSessionEventApplicationEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application application, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23831b, application.f());
            objectEncoderContext.s(f23832c, application.e());
            objectEncoderContext.s(f23833d, application.g());
            objectEncoderContext.s(f23834e, application.c());
            objectEncoderContext.s(f23835f, application.d());
            objectEncoderContext.s(f23836g, application.b());
            objectEncoderContext.d(f23837h, application.h());
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder f23838a = new CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23839b = FieldDescriptor.d("baseAddress");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23840c = FieldDescriptor.d("size");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23841d = FieldDescriptor.d("name");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23842e = FieldDescriptor.d("uuid");

        private CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage binaryImage, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f23839b, binaryImage.b());
            objectEncoderContext.c(f23840c, binaryImage.d());
            objectEncoderContext.s(f23841d, binaryImage.c());
            objectEncoderContext.s(f23842e, binaryImage.f());
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionEncoder f23843a = new CrashlyticsReportSessionEventApplicationExecutionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23844b = FieldDescriptor.d("threads");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23845c = FieldDescriptor.d("exception");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23846d = FieldDescriptor.d("appExitInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23847e = FieldDescriptor.d("signal");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23848f = FieldDescriptor.d("binaries");

        private CrashlyticsReportSessionEventApplicationExecutionEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution execution, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23844b, execution.f());
            objectEncoderContext.s(f23845c, execution.d());
            objectEncoderContext.s(f23846d, execution.b());
            objectEncoderContext.s(f23847e, execution.e());
            objectEncoderContext.s(f23848f, execution.c());
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Exception> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder f23849a = new CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23850b = FieldDescriptor.d("type");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23851c = FieldDescriptor.d("reason");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23852d = FieldDescriptor.d("frames");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23853e = FieldDescriptor.d("causedBy");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23854f = FieldDescriptor.d("overflowCount");

        private CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Exception exception, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23850b, exception.f());
            objectEncoderContext.s(f23851c, exception.e());
            objectEncoderContext.s(f23852d, exception.c());
            objectEncoderContext.s(f23853e, exception.b());
            objectEncoderContext.d(f23854f, exception.d());
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionSignalEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Signal> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionSignalEncoder f23855a = new CrashlyticsReportSessionEventApplicationExecutionSignalEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23856b = FieldDescriptor.d("name");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23857c = FieldDescriptor.d(HTML.Tag.g0);

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23858d = FieldDescriptor.d(HTML.Tag.F);

        private CrashlyticsReportSessionEventApplicationExecutionSignalEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23856b, signal.d());
            objectEncoderContext.s(f23857c, signal.c());
            objectEncoderContext.c(f23858d, signal.b());
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionThreadEncoder f23859a = new CrashlyticsReportSessionEventApplicationExecutionThreadEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23860b = FieldDescriptor.d("name");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23861c = FieldDescriptor.d("importance");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23862d = FieldDescriptor.d("frames");

        private CrashlyticsReportSessionEventApplicationExecutionThreadEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Thread thread, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23860b, thread.d());
            objectEncoderContext.d(f23861c, thread.c());
            objectEncoderContext.s(f23862d, thread.b());
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder f23863a = new CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23864b = FieldDescriptor.d(CSS.Value.m0);

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23865c = FieldDescriptor.d("symbol");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23866d = FieldDescriptor.d(Annotation.k3);

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23867e = FieldDescriptor.d(TypedValues.CycleType.R);

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23868f = FieldDescriptor.d("importance");

        private CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f23864b, frame.e());
            objectEncoderContext.s(f23865c, frame.f());
            objectEncoderContext.s(f23866d, frame.b());
            objectEncoderContext.c(f23867e, frame.d());
            objectEncoderContext.d(f23868f, frame.c());
        }
    }

    private static final class CrashlyticsReportSessionEventApplicationProcessDetailsEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Application.ProcessDetails> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventApplicationProcessDetailsEncoder f23869a = new CrashlyticsReportSessionEventApplicationProcessDetailsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23870b = FieldDescriptor.d("processName");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23871c = FieldDescriptor.d("pid");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23872d = FieldDescriptor.d("importance");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23873e = FieldDescriptor.d("defaultProcess");

        private CrashlyticsReportSessionEventApplicationProcessDetailsEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23870b, processDetails.d());
            objectEncoderContext.d(f23871c, processDetails.c());
            objectEncoderContext.d(f23872d, processDetails.b());
            objectEncoderContext.b(f23873e, processDetails.e());
        }
    }

    private static final class CrashlyticsReportSessionEventDeviceEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Device> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventDeviceEncoder f23874a = new CrashlyticsReportSessionEventDeviceEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23875b = FieldDescriptor.d("batteryLevel");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23876c = FieldDescriptor.d("batteryVelocity");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23877d = FieldDescriptor.d("proximityOn");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23878e = FieldDescriptor.d("orientation");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23879f = FieldDescriptor.d("ramUsed");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f23880g = FieldDescriptor.d("diskUsed");

        private CrashlyticsReportSessionEventDeviceEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Device device, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23875b, device.b());
            objectEncoderContext.d(f23876c, device.c());
            objectEncoderContext.b(f23877d, device.g());
            objectEncoderContext.d(f23878e, device.e());
            objectEncoderContext.c(f23879f, device.f());
            objectEncoderContext.c(f23880g, device.d());
        }
    }

    private static final class CrashlyticsReportSessionEventEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventEncoder f23881a = new CrashlyticsReportSessionEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23882b = FieldDescriptor.d("timestamp");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23883c = FieldDescriptor.d("type");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23884d = FieldDescriptor.d("app");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23885e = FieldDescriptor.d("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f23886f = FieldDescriptor.d("log");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f23887g = FieldDescriptor.d("rollouts");

        private CrashlyticsReportSessionEventEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event event, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f23882b, event.f());
            objectEncoderContext.s(f23883c, event.g());
            objectEncoderContext.s(f23884d, event.b());
            objectEncoderContext.s(f23885e, event.c());
            objectEncoderContext.s(f23886f, event.d());
            objectEncoderContext.s(f23887g, event.e());
        }
    }

    private static final class CrashlyticsReportSessionEventLogEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.Log> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventLogEncoder f23888a = new CrashlyticsReportSessionEventLogEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23889b = FieldDescriptor.d(Annotation.i3);

        private CrashlyticsReportSessionEventLogEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.Log log, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23889b, log.b());
        }
    }

    private static final class CrashlyticsReportSessionEventRolloutAssignmentEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutAssignment> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventRolloutAssignmentEncoder f23890a = new CrashlyticsReportSessionEventRolloutAssignmentEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23891b = FieldDescriptor.d("rolloutVariant");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23892c = FieldDescriptor.d("parameterKey");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23893d = FieldDescriptor.d("parameterValue");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23894e = FieldDescriptor.d("templateVersion");

        private CrashlyticsReportSessionEventRolloutAssignmentEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.RolloutAssignment rolloutAssignment, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23891b, rolloutAssignment.d());
            objectEncoderContext.s(f23892c, rolloutAssignment.b());
            objectEncoderContext.s(f23893d, rolloutAssignment.c());
            objectEncoderContext.c(f23894e, rolloutAssignment.e());
        }
    }

    private static final class CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder f23895a = new CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23896b = FieldDescriptor.d("rolloutId");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23897c = FieldDescriptor.d("variantId");

        private CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant rolloutVariant, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23896b, rolloutVariant.b());
            objectEncoderContext.s(f23897c, rolloutVariant.c());
        }
    }

    private static final class CrashlyticsReportSessionEventRolloutsStateEncoder implements ObjectEncoder<CrashlyticsReport.Session.Event.RolloutsState> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionEventRolloutsStateEncoder f23898a = new CrashlyticsReportSessionEventRolloutsStateEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23899b = FieldDescriptor.d("assignments");

        private CrashlyticsReportSessionEventRolloutsStateEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.Event.RolloutsState rolloutsState, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23899b, rolloutsState.b());
        }
    }

    private static final class CrashlyticsReportSessionOperatingSystemEncoder implements ObjectEncoder<CrashlyticsReport.Session.OperatingSystem> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionOperatingSystemEncoder f23900a = new CrashlyticsReportSessionOperatingSystemEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23901b = FieldDescriptor.d("platform");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f23902c = FieldDescriptor.d("version");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f23903d = FieldDescriptor.d("buildVersion");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f23904e = FieldDescriptor.d("jailbroken");

        private CrashlyticsReportSessionOperatingSystemEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.OperatingSystem operatingSystem, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.d(f23901b, operatingSystem.c());
            objectEncoderContext.s(f23902c, operatingSystem.d());
            objectEncoderContext.s(f23903d, operatingSystem.b());
            objectEncoderContext.b(f23904e, operatingSystem.e());
        }
    }

    private static final class CrashlyticsReportSessionUserEncoder implements ObjectEncoder<CrashlyticsReport.Session.User> {

        /* renamed from: a  reason: collision with root package name */
        static final CrashlyticsReportSessionUserEncoder f23905a = new CrashlyticsReportSessionUserEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f23906b = FieldDescriptor.d(DublinCoreProperties.f27401g);

        private CrashlyticsReportSessionUserEncoder() {
        }

        /* renamed from: b */
        public void a(CrashlyticsReport.Session.User user, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.s(f23906b, user.b());
        }
    }

    private AutoCrashlyticsReportEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        CrashlyticsReportEncoder crashlyticsReportEncoder = CrashlyticsReportEncoder.f23778a;
        encoderConfig.b(CrashlyticsReport.class, crashlyticsReportEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport.class, crashlyticsReportEncoder);
        CrashlyticsReportSessionEncoder crashlyticsReportSessionEncoder = CrashlyticsReportSessionEncoder.f23817a;
        encoderConfig.b(CrashlyticsReport.Session.class, crashlyticsReportSessionEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session.class, crashlyticsReportSessionEncoder);
        CrashlyticsReportSessionApplicationEncoder crashlyticsReportSessionApplicationEncoder = CrashlyticsReportSessionApplicationEncoder.f23797a;
        encoderConfig.b(CrashlyticsReport.Session.Application.class, crashlyticsReportSessionApplicationEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Application.class, crashlyticsReportSessionApplicationEncoder);
        CrashlyticsReportSessionApplicationOrganizationEncoder crashlyticsReportSessionApplicationOrganizationEncoder = CrashlyticsReportSessionApplicationOrganizationEncoder.f23805a;
        encoderConfig.b(CrashlyticsReport.Session.Application.Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Application_Organization.class, crashlyticsReportSessionApplicationOrganizationEncoder);
        CrashlyticsReportSessionUserEncoder crashlyticsReportSessionUserEncoder = CrashlyticsReportSessionUserEncoder.f23905a;
        encoderConfig.b(CrashlyticsReport.Session.User.class, crashlyticsReportSessionUserEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_User.class, crashlyticsReportSessionUserEncoder);
        CrashlyticsReportSessionOperatingSystemEncoder crashlyticsReportSessionOperatingSystemEncoder = CrashlyticsReportSessionOperatingSystemEncoder.f23900a;
        encoderConfig.b(CrashlyticsReport.Session.OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_OperatingSystem.class, crashlyticsReportSessionOperatingSystemEncoder);
        CrashlyticsReportSessionDeviceEncoder crashlyticsReportSessionDeviceEncoder = CrashlyticsReportSessionDeviceEncoder.f23807a;
        encoderConfig.b(CrashlyticsReport.Session.Device.class, crashlyticsReportSessionDeviceEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Device.class, crashlyticsReportSessionDeviceEncoder);
        CrashlyticsReportSessionEventEncoder crashlyticsReportSessionEventEncoder = CrashlyticsReportSessionEventEncoder.f23881a;
        encoderConfig.b(CrashlyticsReport.Session.Event.class, crashlyticsReportSessionEventEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event.class, crashlyticsReportSessionEventEncoder);
        CrashlyticsReportSessionEventApplicationEncoder crashlyticsReportSessionEventApplicationEncoder = CrashlyticsReportSessionEventApplicationEncoder.f23830a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Application.class, crashlyticsReportSessionEventApplicationEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Application.class, crashlyticsReportSessionEventApplicationEncoder);
        CrashlyticsReportSessionEventApplicationExecutionEncoder crashlyticsReportSessionEventApplicationExecutionEncoder = CrashlyticsReportSessionEventApplicationExecutionEncoder.f23843a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Application.Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution.class, crashlyticsReportSessionEventApplicationExecutionEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadEncoder crashlyticsReportSessionEventApplicationExecutionThreadEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadEncoder.f23859a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Application.Execution.Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.class, crashlyticsReportSessionEventApplicationExecutionThreadEncoder);
        CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder = CrashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder.f23863a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.class, crashlyticsReportSessionEventApplicationExecutionThreadFrameEncoder);
        CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder crashlyticsReportSessionEventApplicationExecutionExceptionEncoder = CrashlyticsReportSessionEventApplicationExecutionExceptionEncoder.f23849a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Application.Execution.Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.class, crashlyticsReportSessionEventApplicationExecutionExceptionEncoder);
        CrashlyticsReportApplicationExitInfoEncoder crashlyticsReportApplicationExitInfoEncoder = CrashlyticsReportApplicationExitInfoEncoder.f23765a;
        encoderConfig.b(CrashlyticsReport.ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_ApplicationExitInfo.class, crashlyticsReportApplicationExitInfoEncoder);
        CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder = CrashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder.f23761a;
        encoderConfig.b(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.class, crashlyticsReportApplicationExitInfoBuildIdMappingForArchEncoder);
        CrashlyticsReportSessionEventApplicationExecutionSignalEncoder crashlyticsReportSessionEventApplicationExecutionSignalEncoder = CrashlyticsReportSessionEventApplicationExecutionSignalEncoder.f23855a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Application.Execution.Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.class, crashlyticsReportSessionEventApplicationExecutionSignalEncoder);
        CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder = CrashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder.f23838a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.class, crashlyticsReportSessionEventApplicationExecutionBinaryImageEncoder);
        CrashlyticsReportCustomAttributeEncoder crashlyticsReportCustomAttributeEncoder = CrashlyticsReportCustomAttributeEncoder.f23775a;
        encoderConfig.b(CrashlyticsReport.CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_CustomAttribute.class, crashlyticsReportCustomAttributeEncoder);
        CrashlyticsReportSessionEventApplicationProcessDetailsEncoder crashlyticsReportSessionEventApplicationProcessDetailsEncoder = CrashlyticsReportSessionEventApplicationProcessDetailsEncoder.f23869a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Application.ProcessDetails.class, crashlyticsReportSessionEventApplicationProcessDetailsEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Application_ProcessDetails.class, crashlyticsReportSessionEventApplicationProcessDetailsEncoder);
        CrashlyticsReportSessionEventDeviceEncoder crashlyticsReportSessionEventDeviceEncoder = CrashlyticsReportSessionEventDeviceEncoder.f23874a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Device.class, crashlyticsReportSessionEventDeviceEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Device.class, crashlyticsReportSessionEventDeviceEncoder);
        CrashlyticsReportSessionEventLogEncoder crashlyticsReportSessionEventLogEncoder = CrashlyticsReportSessionEventLogEncoder.f23888a;
        encoderConfig.b(CrashlyticsReport.Session.Event.Log.class, crashlyticsReportSessionEventLogEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_Log.class, crashlyticsReportSessionEventLogEncoder);
        CrashlyticsReportSessionEventRolloutsStateEncoder crashlyticsReportSessionEventRolloutsStateEncoder = CrashlyticsReportSessionEventRolloutsStateEncoder.f23898a;
        encoderConfig.b(CrashlyticsReport.Session.Event.RolloutsState.class, crashlyticsReportSessionEventRolloutsStateEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_RolloutsState.class, crashlyticsReportSessionEventRolloutsStateEncoder);
        CrashlyticsReportSessionEventRolloutAssignmentEncoder crashlyticsReportSessionEventRolloutAssignmentEncoder = CrashlyticsReportSessionEventRolloutAssignmentEncoder.f23890a;
        encoderConfig.b(CrashlyticsReport.Session.Event.RolloutAssignment.class, crashlyticsReportSessionEventRolloutAssignmentEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment.class, crashlyticsReportSessionEventRolloutAssignmentEncoder);
        CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder = CrashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder.f23895a;
        encoderConfig.b(CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.class, crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.class, crashlyticsReportSessionEventRolloutAssignmentRolloutVariantEncoder);
        CrashlyticsReportFilesPayloadEncoder crashlyticsReportFilesPayloadEncoder = CrashlyticsReportFilesPayloadEncoder.f23791a;
        encoderConfig.b(CrashlyticsReport.FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_FilesPayload.class, crashlyticsReportFilesPayloadEncoder);
        CrashlyticsReportFilesPayloadFileEncoder crashlyticsReportFilesPayloadFileEncoder = CrashlyticsReportFilesPayloadFileEncoder.f23794a;
        encoderConfig.b(CrashlyticsReport.FilesPayload.File.class, crashlyticsReportFilesPayloadFileEncoder);
        encoderConfig.b(AutoValue_CrashlyticsReport_FilesPayload_File.class, crashlyticsReportFilesPayloadFileEncoder);
    }
}
