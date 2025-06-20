package net.imedicaldoctor.imd;

import androidx.media3.common.MimeTypes;
import com.itextpdf.tool.xml.html.HTML;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.commons.httpclient.methods.multipart.FilePart;

public class LocalServer extends NanoHTTPD {
    private String t;
    private String u;

    public LocalServer(int i2, String str, String str2) {
        super(i2);
        this.t = str;
        this.u = str2;
    }

    private String R(String str) {
        if (str.endsWith(".css")) {
            return HTML.Attribute.Value.f27604a;
        }
        if (str.endsWith(".js")) {
            return "application/javascript";
        }
        if (str.endsWith(".png")) {
            return MimeTypes.R0;
        }
        if (str.endsWith(".jpg") || str.endsWith(".jpeg")) {
            return MimeTypes.Q0;
        }
        return str.endsWith(".gif") ? "image/gif" : FilePart.DEFAULT_CONTENT_TYPE;
    }

    public NanoHTTPD.Response G(NanoHTTPD.IHTTPSession iHTTPSession) {
        if ("/content".equals(iHTTPSession.c())) {
            return NanoHTTPD.D(NanoHTTPD.Response.Status.OK, NanoHTTPD.p, this.t);
        }
        File file = new File(this.u, iHTTPSession.c().substring(1));
        if (!file.exists()) {
            return NanoHTTPD.D(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "File not found");
        }
        file.setReadable(true, false);
        try {
            return NanoHTTPD.C(NanoHTTPD.Response.Status.OK, R(file.getName()), new FileInputStream(file), file.length());
        } catch (FileNotFoundException unused) {
            return NanoHTTPD.D(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "File not found");
        }
    }
}
