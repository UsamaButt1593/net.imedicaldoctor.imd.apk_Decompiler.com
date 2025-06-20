package com.itextpdf.tool.xml.net;

import com.itextpdf.text.Image;
import com.itextpdf.tool.xml.net.exc.NoImageException;
import com.itextpdf.tool.xml.pipeline.html.ImageProvider;
import com.itextpdf.tool.xml.pipeline.html.UrlLinkResolver;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageRetrieve {

    /* renamed from: a  reason: collision with root package name */
    private final ImageProvider f27653a;

    /* renamed from: b  reason: collision with root package name */
    private String f27654b;

    public ImageRetrieve() {
        this.f27653a = null;
        this.f27654b = null;
    }

    private URL a(String str) throws MalformedURLException {
        URL url;
        UrlLinkResolver urlLinkResolver = new UrlLinkResolver();
        ImageProvider imageProvider = this.f27653a;
        if (imageProvider != null) {
            urlLinkResolver.c(imageProvider.b());
            url = urlLinkResolver.b(str);
        } else {
            url = null;
        }
        if (url != null) {
            return url;
        }
        urlLinkResolver.c(this.f27654b);
        return urlLinkResolver.b(str);
    }

    private Image c(String str) {
        ImageProvider imageProvider = this.f27653a;
        if (imageProvider != null) {
            return imageProvider.c(str);
        }
        return null;
    }

    public Image b(String str) throws NoImageException {
        Image c2 = c(str);
        if (c2 == null) {
            try {
                c2 = Image.d1(a(str));
            } catch (Exception e2) {
                throw new NoImageException(str, e2);
            }
        }
        ImageProvider imageProvider = this.f27653a;
        if (!(imageProvider == null || c2 == null)) {
            imageProvider.a(str, c2);
        }
        return c2;
    }

    public ImageRetrieve(ImageProvider imageProvider) {
        this.f27653a = imageProvider;
        this.f27654b = null;
    }

    public ImageRetrieve(String str) {
        this.f27654b = str;
        this.f27653a = null;
    }

    public ImageRetrieve(String str, ImageProvider imageProvider) {
        this.f27653a = imageProvider;
        this.f27654b = str;
    }
}
