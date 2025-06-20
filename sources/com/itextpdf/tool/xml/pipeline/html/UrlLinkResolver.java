package com.itextpdf.tool.xml.pipeline.html;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlLinkResolver {

    /* renamed from: a  reason: collision with root package name */
    private String f27734a;

    public UrlLinkResolver() {
    }

    public URL a(String str) throws MalformedURLException {
        String str2;
        String str3 = this.f27734a;
        if (str3 != null) {
            boolean endsWith = str3.endsWith("/");
            boolean startsWith = str.startsWith("/");
            if (!endsWith || !startsWith) {
                if (!endsWith && !startsWith) {
                    str2 = this.f27734a + "/";
                }
                str = this.f27734a + str;
            } else {
                String str4 = this.f27734a;
                str2 = str4.substring(0, str4.length() - 1);
            }
            this.f27734a = str2;
            str = this.f27734a + str;
        }
        File file = new File(str);
        if (file.exists()) {
            return file.toURI().toURL();
        }
        return null;
    }

    public URL b(String str) throws MalformedURLException {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return a(str);
        }
    }

    public void c(String str) {
        this.f27734a = str;
    }

    public UrlLinkResolver(String str) {
        this.f27734a = str;
    }
}
