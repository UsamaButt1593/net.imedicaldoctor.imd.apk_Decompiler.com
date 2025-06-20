package net.imedicaldoctor.imd.Fragments;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;
import android.util.Log;
import androidx.media3.common.MimeTypes;
import com.google.common.net.HttpHeaders;
import com.itextpdf.text.Annotation;
import com.itextpdf.tool.xml.html.HTML;
import fi.iki.elonen.NanoHTTPD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.apache.commons.httpclient.cookie.Cookie2;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileWebServer extends NanoHTTPD {
    private final Context t;
    private final File u;
    private boolean v = false;

    public FileWebServer(Context context, int i2, File file) {
        super(i2);
        this.t = context;
        this.u = file;
    }

    private String R() {
        return Formatter.formatIpAddress(((WifiManager) this.t.getSystemService("wifi")).getConnectionInfo().getIpAddress());
    }

    private String S(String str) {
        if (str.endsWith(".html")) {
            return NanoHTTPD.p;
        }
        if (str.endsWith(".css")) {
            return HTML.Attribute.Value.f27604a;
        }
        if (str.endsWith(".js")) {
            return "application/javascript";
        }
        if (str.endsWith(".png")) {
            return MimeTypes.R0;
        }
        return (str.endsWith(".jpg") || str.endsWith(".jpeg")) ? MimeTypes.Q0 : FilePart.DEFAULT_CONTENT_TYPE;
    }

    private NanoHTTPD.Response T(String str) {
        NanoHTTPD.Response.Status status;
        String str2;
        File file = new File(this.u, str);
        if (!file.exists() || !file.delete()) {
            status = NanoHTTPD.Response.Status.NOT_FOUND;
            str2 = "{\"error\":\"File not found or deletion failed\"}";
        } else {
            status = NanoHTTPD.Response.Status.OK;
            str2 = "{\"status\":\"File deleted successfully\"}";
        }
        return NanoHTTPD.D(status, "application/json", str2);
    }

    private NanoHTTPD.Response U(NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        FileOutputStream fileOutputStream;
        try {
            Map<String, String> j2 = iHTTPSession.j();
            iHTTPSession.k(j2);
            String str2 = j2.get(Annotation.k3);
            if (str2 == null) {
                return NanoHTTPD.D(NanoHTTPD.Response.Status.BAD_REQUEST, "application/json", "{\"error\":\"No file uploaded\"}");
            }
            String str3 = (String) iHTTPSession.g().get(Annotation.k3).get(0);
            Log.d("UploadFileName", "Filename extracted: " + str3);
            File file = new File(str2);
            File file2 = new File(this.u, str);
            if (!file2.exists() && !file2.mkdirs()) {
                return NanoHTTPD.D(NanoHTTPD.Response.Status.INTERNAL_ERROR, "application/json", "{\"error\":\"Failed to create directory\"}");
            }
            File file3 = new File(file2, str3);
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file3);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        fileInputStream.close();
                        return NanoHTTPD.D(NanoHTTPD.Response.Status.OK, "application/json", "{\"status\":\"File uploaded successfully\"}");
                    }
                }
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
            throw th;
        } catch (NanoHTTPD.ResponseException | IOException unused) {
            return NanoHTTPD.D(NanoHTTPD.Response.Status.INTERNAL_ERROR, "application/json", "{\"error\":\"File upload failed\"}");
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }

    private NanoHTTPD.Response V(String str) {
        File file = new File(this.u, str);
        if (file.isDirectory()) {
            return Y(file);
        }
        return file.exists() ? Z(file) : NanoHTTPD.D(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "File Not Found");
    }

    private NanoHTTPD.Response X(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.t.getAssets().open(str), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(StringUtils.LF);
                } else {
                    bufferedReader.close();
                    return NanoHTTPD.D(NanoHTTPD.Response.Status.OK, S(str), sb.toString());
                }
            }
        } catch (IOException unused) {
            return NanoHTTPD.D(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "Asset Not Found");
        }
    }

    private NanoHTTPD.Response Y(File file) {
        NanoHTTPD.Response.Status status;
        String jSONArray;
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            status = NanoHTTPD.Response.Status.INTERNAL_ERROR;
            jSONArray = "{\"error\":\"Failed to list files\"}";
        } else {
            JSONArray jSONArray2 = new JSONArray();
            int length = listFiles.length;
            int i2 = 0;
            while (i2 < length) {
                File file2 = listFiles[i2];
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("name", file2.getName());
                    String path = file2.getPath();
                    jSONObject.put(Cookie2.PATH, path.replace(this.u.getPath() + "/", ""));
                    jSONObject.put("isDirectory", file2.isDirectory());
                    jSONObject.put("size", file2.length());
                    jSONArray2.put(jSONObject);
                    i2++;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    status = NanoHTTPD.Response.Status.INTERNAL_ERROR;
                    jSONArray = "{\"error\":\"Failed to create file object\"}";
                }
            }
            status = NanoHTTPD.Response.Status.OK;
            jSONArray = jSONArray2.toString();
        }
        return NanoHTTPD.D(status, "application/json", jSONArray);
    }

    private NanoHTTPD.Response Z(File file) {
        try {
            NanoHTTPD.Response B = NanoHTTPD.B(NanoHTTPD.Response.Status.OK, S(file.getName()), new FileInputStream(file));
            B.c(HttpHeaders.a0, "attachment; filename=\"" + file.getName() + "\"");
            return B;
        } catch (IOException unused) {
            return NanoHTTPD.D(NanoHTTPD.Response.Status.INTERNAL_ERROR, "text/plain", "Internal Server Error");
        }
    }

    public NanoHTTPD.Response G(NanoHTTPD.IHTTPSession iHTTPSession) {
        String c2 = iHTTPSession.c();
        NanoHTTPD.Method l2 = iHTTPSession.l();
        if (c2.equals("/")) {
            return X("index.html");
        }
        if (c2.startsWith("/files/")) {
            String replaceFirst = c2.replaceFirst("/files/", "");
            if (l2 == NanoHTTPD.Method.GET) {
                return V(replaceFirst);
            }
            if (l2 == NanoHTTPD.Method.POST) {
                return U(iHTTPSession, replaceFirst);
            }
            if (l2 == NanoHTTPD.Method.DELETE) {
                return T(replaceFirst);
            }
        }
        return NanoHTTPD.D(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "Not Found");
    }

    public void L() throws IOException {
        super.L();
        this.v = true;
    }

    public void O() {
        super.O();
        this.v = false;
    }

    public boolean W() {
        return this.v;
    }
}
