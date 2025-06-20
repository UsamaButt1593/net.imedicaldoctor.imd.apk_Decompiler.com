package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistedInstallation {

    /* renamed from: c  reason: collision with root package name */
    private static final String f24560c = "PersistedInstallation";

    /* renamed from: d  reason: collision with root package name */
    private static final String f24561d = "Fid";

    /* renamed from: e  reason: collision with root package name */
    private static final String f24562e = "AuthToken";

    /* renamed from: f  reason: collision with root package name */
    private static final String f24563f = "RefreshToken";

    /* renamed from: g  reason: collision with root package name */
    private static final String f24564g = "TokenCreationEpochInSecs";

    /* renamed from: h  reason: collision with root package name */
    private static final String f24565h = "ExpiresInSecs";

    /* renamed from: i  reason: collision with root package name */
    private static final String f24566i = "Status";

    /* renamed from: j  reason: collision with root package name */
    private static final String f24567j = "FisError";

    /* renamed from: a  reason: collision with root package name */
    private File f24568a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f24569b;

    public enum RegistrationStatus {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public PersistedInstallation(@NonNull FirebaseApp firebaseApp) {
        this.f24569b = firebaseApp;
    }

    private File b() {
        if (this.f24568a == null) {
            synchronized (this) {
                try {
                    if (this.f24568a == null) {
                        File filesDir = this.f24569b.n().getFilesDir();
                        this.f24568a = new File(filesDir, "PersistedInstallation." + this.f24569b.t() + ".json");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f24568a;
    }

    private JSONObject d() {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            fileInputStream = new FileInputStream(b());
            while (true) {
                int read = fileInputStream.read(bArr, 0, 16384);
                if (read < 0) {
                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                    fileInputStream.close();
                    return jSONObject;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void a() {
        b().delete();
    }

    @NonNull
    public PersistedInstallationEntry c(@NonNull PersistedInstallationEntry persistedInstallationEntry) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f24561d, persistedInstallationEntry.d());
            jSONObject.put(f24566i, persistedInstallationEntry.g().ordinal());
            jSONObject.put(f24562e, persistedInstallationEntry.b());
            jSONObject.put(f24563f, persistedInstallationEntry.f());
            jSONObject.put(f24564g, persistedInstallationEntry.h());
            jSONObject.put(f24565h, persistedInstallationEntry.c());
            jSONObject.put(f24567j, persistedInstallationEntry.e());
            File createTempFile = File.createTempFile(f24560c, "tmp", this.f24569b.n().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
            if (createTempFile.renameTo(b())) {
                return persistedInstallationEntry;
            }
            throw new IOException("unable to rename the tmpfile to PersistedInstallation");
        } catch (IOException | JSONException unused) {
        }
    }

    @NonNull
    public PersistedInstallationEntry e() {
        JSONObject d2 = d();
        String optString = d2.optString(f24561d, (String) null);
        int optInt = d2.optInt(f24566i, RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
        String optString2 = d2.optString(f24562e, (String) null);
        String optString3 = d2.optString(f24563f, (String) null);
        long optLong = d2.optLong(f24564g, 0);
        long optLong2 = d2.optLong(f24565h, 0);
        return PersistedInstallationEntry.a().d(optString).g(RegistrationStatus.values()[optInt]).b(optString2).f(optString3).h(optLong).c(optLong2).e(d2.optString(f24567j, (String) null)).a();
    }
}
