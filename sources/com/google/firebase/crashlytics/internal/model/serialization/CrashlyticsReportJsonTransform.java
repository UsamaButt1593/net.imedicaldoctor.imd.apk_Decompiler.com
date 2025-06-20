package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.itextpdf.text.Annotation;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import com.itextpdf.tool.xml.css.CSS;
import com.itextpdf.tool.xml.html.HTML;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrashlyticsReportJsonTransform {

    /* renamed from: a  reason: collision with root package name */
    private static final DataEncoder f24184a = new JsonDataEncoderBuilder().k(AutoCrashlyticsReportEncoder.f23760b).l(true).j();

    private interface ObjectParser<T> {
        T a(@NonNull JsonReader jsonReader) throws IOException;
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Log A(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Log.Builder a2 = CrashlyticsReport.Session.Event.Log.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals(Annotation.i3)) {
                a2.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.Session.Event.RolloutAssignment B(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.RolloutAssignment.Builder a2 = CrashlyticsReport.Session.Event.RolloutAssignment.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1536268810:
                    if (nextName.equals("parameterKey")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1027290370:
                    if (nextName.equals("templateVersion")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1098747284:
                    if (nextName.equals("rolloutVariant")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1124454216:
                    if (nextName.equals("parameterValue")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(jsonReader.nextString());
                    break;
                case 1:
                    a2.e(jsonReader.nextLong());
                    break;
                case 2:
                    a2.d(K(jsonReader));
                    break;
                case 3:
                    a2.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.RolloutsState C(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.RolloutsState.Builder a2 = CrashlyticsReport.Session.Event.RolloutsState.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("assignments")) {
                jsonReader.skipValue();
            } else {
                a2.b(p(jsonReader, new i()));
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Application.Execution.Signal D(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder a2 = CrashlyticsReport.Session.Event.Application.Execution.Signal.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1147692044:
                    if (nextName.equals(HTML.Tag.F)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3059181:
                    if (nextName.equals(HTML.Tag.g0)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(jsonReader.nextLong());
                    break;
                case 1:
                    a2.c(jsonReader.nextString());
                    break;
                case 2:
                    a2.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread E(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder a2 = CrashlyticsReport.Session.Event.Application.Execution.Thread.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(p(jsonReader, new a()));
                    break;
                case 1:
                    a2.d(jsonReader.nextString());
                    break;
                case 2:
                    a2.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.FilesPayload.File F(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.FilesPayload.File.Builder a2 = CrashlyticsReport.FilesPayload.File.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("filename")) {
                a2.c(jsonReader.nextString());
            } else if (!nextName.equals("contents")) {
                jsonReader.skipValue();
            } else {
                a2.b(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.FilesPayload G(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.FilesPayload.Builder a2 = CrashlyticsReport.FilesPayload.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("files")) {
                a2.b(p(jsonReader, new h()));
            } else if (!nextName.equals("orgId")) {
                jsonReader.skipValue();
            } else {
                a2.c(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.OperatingSystem H(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.OperatingSystem.Builder a2 = CrashlyticsReport.Session.OperatingSystem.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(jsonReader.nextString());
                    break;
                case 1:
                    a2.c(jsonReader.nextBoolean());
                    break;
                case 2:
                    a2.e(jsonReader.nextString());
                    break;
                case 3:
                    a2.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.Session.Event.Application.ProcessDetails I(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.ProcessDetails.Builder a2 = CrashlyticsReport.Session.Event.Application.ProcessDetails.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 110987:
                    if (nextName.equals("pid")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1694598382:
                    if (nextName.equals("defaultProcess")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.d(jsonReader.nextInt());
                    break;
                case 1:
                    a2.e(jsonReader.nextString());
                    break;
                case 2:
                    a2.b(jsonReader.nextBoolean());
                    break;
                case 3:
                    a2.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport J(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Builder b2 = CrashlyticsReport.b();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -401988390:
                    if (nextName.equals("firebaseAuthenticationToken")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 1047652060:
                    if (nextName.equals("firebaseInstallationId")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c2 = 11;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    b2.j(G(jsonReader));
                    break;
                case 1:
                    b2.l(jsonReader.nextString());
                    break;
                case 2:
                    b2.c(jsonReader.nextString());
                    break;
                case 3:
                    b2.b(o(jsonReader));
                    break;
                case 4:
                    b2.d(jsonReader.nextString());
                    break;
                case 5:
                    b2.f(jsonReader.nextString());
                    break;
                case 6:
                    b2.h(jsonReader.nextString());
                    break;
                case 7:
                    b2.i(jsonReader.nextString());
                    break;
                case 8:
                    b2.g(jsonReader.nextString());
                    break;
                case 9:
                    b2.k(jsonReader.nextInt());
                    break;
                case 10:
                    b2.e(jsonReader.nextString());
                    break;
                case 11:
                    b2.m(L(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return b2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant K(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.Builder a2 = CrashlyticsReport.Session.Event.RolloutAssignment.RolloutVariant.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("variantId")) {
                a2.c(jsonReader.nextString());
            } else if (!nextName.equals("rolloutId")) {
                jsonReader.skipValue();
            } else {
                a2.b(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session L(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Builder a2 = CrashlyticsReport.Session.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals(DublinCoreProperties.f27401g)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c2 = 11;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.m(jsonReader.nextLong());
                    break;
                case 1:
                    a2.c(jsonReader.nextString());
                    break;
                case 2:
                    a2.k(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    a2.f(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 4:
                    a2.e(s(jsonReader));
                    break;
                case 5:
                    a2.g(p(jsonReader, new e()));
                    break;
                case 6:
                    a2.l(H(jsonReader));
                    break;
                case 7:
                    a2.b(n(jsonReader));
                    break;
                case 8:
                    a2.n(M(jsonReader));
                    break;
                case 9:
                    a2.h(jsonReader.nextString());
                    break;
                case 10:
                    a2.d(jsonReader.nextBoolean());
                    break;
                case 11:
                    a2.i(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.User M(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.User.Builder a2 = CrashlyticsReport.Session.User.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            if (jsonReader.nextName().equals(DublinCoreProperties.f27401g)) {
                a2.b(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Application n(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Application.Builder a2 = CrashlyticsReport.Session.Application.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals(DublinCoreProperties.f27401g)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -519438642:
                    if (nextName.equals("developmentPlatform")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 213652010:
                    if (nextName.equals("developmentPlatformVersion")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.e(jsonReader.nextString());
                    break;
                case 1:
                    a2.b(jsonReader.nextString());
                    break;
                case 2:
                    a2.c(jsonReader.nextString());
                    break;
                case 3:
                    a2.h(jsonReader.nextString());
                    break;
                case 4:
                    a2.f(jsonReader.nextString());
                    break;
                case 5:
                    a2.d(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.ApplicationExitInfo o(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.ApplicationExitInfo.Builder a2 = CrashlyticsReport.ApplicationExitInfo.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1516200806:
                    if (nextName.equals("buildIdMappingForArch")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 110987:
                    if (nextName.equals("pid")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 111312:
                    if (nextName.equals("pss")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 113234:
                    if (nextName.equals("rss")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 722137681:
                    if (nextName.equals("reasonCode")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 723857505:
                    if (nextName.equals("traceFile")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 8;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(p(jsonReader, new b()));
                    break;
                case 1:
                    a2.d(jsonReader.nextInt());
                    break;
                case 2:
                    a2.f(jsonReader.nextLong());
                    break;
                case 3:
                    a2.h(jsonReader.nextLong());
                    break;
                case 4:
                    a2.i(jsonReader.nextLong());
                    break;
                case 5:
                    a2.e(jsonReader.nextString());
                    break;
                case 6:
                    a2.g(jsonReader.nextInt());
                    break;
                case 7:
                    a2.j(jsonReader.nextString());
                    break;
                case 8:
                    a2.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static <T> List<T> p(@NonNull JsonReader jsonReader, @NonNull ObjectParser<T> objectParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.a(jsonReader));
        }
        jsonReader.endArray();
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch q(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder a2 = CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -609862170:
                    if (nextName.equals("libraryName")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 230943785:
                    if (nextName.equals("buildId")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.d(jsonReader.nextString());
                    break;
                case 1:
                    a2.b(jsonReader.nextString());
                    break;
                case 2:
                    a2.c(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.CustomAttribute r(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.CustomAttribute.Builder a2 = CrashlyticsReport.CustomAttribute.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("key")) {
                a2.b(jsonReader.nextString());
            } else if (!nextName.equals("value")) {
                jsonReader.skipValue();
            } else {
                a2.c(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Device s(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Device.Builder a2 = CrashlyticsReport.Session.Device.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c2 = 8;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.i(jsonReader.nextBoolean());
                    break;
                case 1:
                    a2.e(jsonReader.nextString());
                    break;
                case 2:
                    a2.h(jsonReader.nextLong());
                    break;
                case 3:
                    a2.b(jsonReader.nextInt());
                    break;
                case 4:
                    a2.d(jsonReader.nextLong());
                    break;
                case 5:
                    a2.c(jsonReader.nextInt());
                    break;
                case 6:
                    a2.f(jsonReader.nextString());
                    break;
                case 7:
                    a2.j(jsonReader.nextInt());
                    break;
                case 8:
                    a2.g(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.Session.Event t(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Builder a2 = CrashlyticsReport.Session.Event.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -259312414:
                    if (nextName.equals("rollouts")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.c(w(jsonReader));
                    break;
                case 1:
                    a2.e(C(jsonReader));
                    break;
                case 2:
                    a2.b(u(jsonReader));
                    break;
                case 3:
                    a2.d(A(jsonReader));
                    break;
                case 4:
                    a2.g(jsonReader.nextString());
                    break;
                case 5:
                    a2.f(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Application u(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Builder a2 = CrashlyticsReport.Session.Event.Application.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1405314732:
                    if (nextName.equals("appProcessDetails")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1332194002:
                    if (nextName.equals(CSS.Property.f27458a)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -80231855:
                    if (nextName.equals("internalKeys")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1847730860:
                    if (nextName.equals("currentProcessDetails")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(p(jsonReader, new d()));
                    break;
                case 1:
                    a2.c(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 2:
                    a2.f(x(jsonReader));
                    break;
                case 3:
                    a2.g(p(jsonReader, new c()));
                    break;
                case 4:
                    a2.e(p(jsonReader, new c()));
                    break;
                case 5:
                    a2.h(jsonReader.nextInt());
                    break;
                case 6:
                    a2.d(I(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage v(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder a2 = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals("name")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals("uuid")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.c(jsonReader.nextString());
                    break;
                case 1:
                    a2.d(jsonReader.nextLong());
                    break;
                case 2:
                    a2.f(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    a2.b(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Device w(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Device.Builder a2 = CrashlyticsReport.Session.Event.Device.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    a2.c(jsonReader.nextInt());
                    break;
                case 2:
                    a2.e(jsonReader.nextInt());
                    break;
                case 3:
                    a2.d(jsonReader.nextLong());
                    break;
                case 4:
                    a2.g(jsonReader.nextLong());
                    break;
                case 5:
                    a2.f(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Application.Execution x(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Builder a2 = CrashlyticsReport.Session.Event.Application.Execution.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals("exception")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.b(o(jsonReader));
                    break;
                case 1:
                    a2.f(p(jsonReader, new f()));
                    break;
                case 2:
                    a2.e(D(jsonReader));
                    break;
                case 3:
                    a2.c(p(jsonReader, new g()));
                    break;
                case 4:
                    a2.d(y(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    private static CrashlyticsReport.Session.Event.Application.Execution.Exception y(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder a2 = CrashlyticsReport.Session.Event.Application.Execution.Exception.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.c(p(jsonReader, new a()));
                    break;
                case 1:
                    a2.e(jsonReader.nextString());
                    break;
                case 2:
                    a2.f(jsonReader.nextString());
                    break;
                case 3:
                    a2.b(y(jsonReader));
                    break;
                case 4:
                    a2.d(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame z(@NonNull JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder a2 = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals(TypedValues.CycleType.R)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals(CSS.Value.m0)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals(Annotation.k3)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    a2.d(jsonReader.nextLong());
                    break;
                case 1:
                    a2.f(jsonReader.nextString());
                    break;
                case 2:
                    a2.e(jsonReader.nextLong());
                    break;
                case 3:
                    a2.b(jsonReader.nextString());
                    break;
                case 4:
                    a2.c(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return a2.a();
    }

    @NonNull
    public CrashlyticsReport N(@NonNull String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport J = J(jsonReader);
            jsonReader.close();
            return J;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    public String O(@NonNull CrashlyticsReport crashlyticsReport) {
        return f24184a.encode(crashlyticsReport);
    }

    @NonNull
    public CrashlyticsReport.ApplicationExitInfo j(@NonNull String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport.ApplicationExitInfo o = o(jsonReader);
            jsonReader.close();
            return o;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    public String k(@NonNull CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return f24184a.encode(applicationExitInfo);
    }

    @NonNull
    public CrashlyticsReport.Session.Event l(@NonNull String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport.Session.Event t = t(jsonReader);
            jsonReader.close();
            return t;
        } catch (IllegalStateException e2) {
            throw new IOException(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    public String m(@NonNull CrashlyticsReport.Session.Event event) {
        return f24184a.encode(event);
    }
}
