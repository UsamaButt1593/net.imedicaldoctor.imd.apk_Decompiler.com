package com.itextpdf.tool.xml;

import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.FontProvider;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.css.CSSFileWrapper;
import com.itextpdf.tool.xml.css.CssFile;
import com.itextpdf.tool.xml.css.CssFileProcessor;
import com.itextpdf.tool.xml.css.CssFilesImpl;
import com.itextpdf.tool.xml.css.StyleAttrCSSResolver;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import com.itextpdf.tool.xml.html.CssAppliers;
import com.itextpdf.tool.xml.html.CssAppliersImpl;
import com.itextpdf.tool.xml.html.TagProcessorFactory;
import com.itextpdf.tool.xml.html.Tags;
import com.itextpdf.tool.xml.parser.XMLParser;
import com.itextpdf.tool.xml.pipeline.css.CSSResolver;
import com.itextpdf.tool.xml.pipeline.css.CssResolverPipeline;
import com.itextpdf.tool.xml.pipeline.end.ElementHandlerPipeline;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipeline;
import com.itextpdf.tool.xml.pipeline.html.HtmlPipelineContext;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class XMLWorkerHelper {

    /* renamed from: c  reason: collision with root package name */
    private static XMLWorkerHelper f27453c = new XMLWorkerHelper();

    /* renamed from: a  reason: collision with root package name */
    private TagProcessorFactory f27454a;

    /* renamed from: b  reason: collision with root package name */
    private CssFile f27455b;

    private XMLWorkerHelper() {
    }

    public static synchronized CssFile a(InputStream inputStream) {
        CSSFileWrapper cSSFileWrapper;
        synchronized (XMLWorkerHelper.class) {
            if (inputStream != null) {
                CssFileProcessor cssFileProcessor = new CssFileProcessor();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                try {
                    char[] cArr = new char[8192];
                    while (true) {
                        int read = bufferedReader.read(cArr);
                        if (read <= 0) {
                            break;
                        }
                        for (int i2 = 0; i2 < read; i2++) {
                            cssFileProcessor.a(cArr[i2]);
                        }
                    }
                    cSSFileWrapper = new CSSFileWrapper(cssFileProcessor.b(), true);
                    inputStream.close();
                } catch (IOException e2) {
                    throw new RuntimeWorkerException((Throwable) e2);
                } catch (IOException e3) {
                    throw new RuntimeWorkerException((Throwable) e3);
                } catch (IOException e4) {
                    throw new RuntimeWorkerException((Throwable) e4);
                } catch (Throwable th) {
                    inputStream.close();
                    throw th;
                }
            } else {
                cSSFileWrapper = null;
            }
        }
        return cSSFileWrapper;
    }

    public static synchronized XMLWorkerHelper e() {
        XMLWorkerHelper xMLWorkerHelper;
        synchronized (XMLWorkerHelper.class) {
            xMLWorkerHelper = f27453c;
        }
        return xMLWorkerHelper;
    }

    public static ElementList f(String str, String str2) throws IOException {
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver();
        if (str2 != null) {
            styleAttrCSSResolver.a(a(new ByteArrayInputStream(str2.getBytes())));
        }
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(new CssAppliersImpl(FontFactory.p()));
        htmlPipelineContext.F(Tags.a());
        htmlPipelineContext.h(false);
        ElementList elementList = new ElementList();
        new XMLParser(new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new ElementHandlerPipeline(elementList, (Pipeline) null))), true)).s(new ByteArrayInputStream(str.getBytes()));
        return elementList;
    }

    public synchronized CssFile b() {
        try {
            if (this.f27455b == null) {
                this.f27455b = a(XMLWorkerHelper.class.getResourceAsStream("/default.css"));
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f27455b;
    }

    public CSSResolver c(boolean z) {
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver();
        if (z) {
            styleAttrCSSResolver.a(b());
        }
        return styleAttrCSSResolver;
    }

    /* access modifiers changed from: protected */
    public synchronized TagProcessorFactory d() {
        try {
            if (this.f27454a == null) {
                this.f27454a = Tags.a();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f27454a;
    }

    public void g(PdfWriter pdfWriter, Document document, InputStream inputStream) throws IOException {
        k(pdfWriter, document, inputStream, XMLWorkerHelper.class.getResourceAsStream("/default.css"), (Charset) null, new XMLWorkerFontProvider());
    }

    public void h(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2) throws IOException {
        k(pdfWriter, document, inputStream, inputStream2, (Charset) null, new XMLWorkerFontProvider());
    }

    public void i(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2, FontProvider fontProvider) throws IOException {
        k(pdfWriter, document, inputStream, inputStream2, (Charset) null, fontProvider);
    }

    public void j(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2, Charset charset) throws IOException {
        k(pdfWriter, document, inputStream, inputStream2, charset, new XMLWorkerFontProvider());
    }

    public void k(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2, Charset charset, FontProvider fontProvider) throws IOException {
        l(pdfWriter, document, inputStream, inputStream2, charset, fontProvider, (String) null);
    }

    public void l(PdfWriter pdfWriter, Document document, InputStream inputStream, InputStream inputStream2, Charset charset, FontProvider fontProvider, String str) throws IOException {
        CssFilesImpl cssFilesImpl = new CssFilesImpl();
        cssFilesImpl.a(inputStream2 != null ? a(inputStream2) : b());
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver(cssFilesImpl);
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext(new CssAppliersImpl(fontProvider));
        htmlPipelineContext.x(true).h(true).F(d()).D(str);
        XMLParser xMLParser = new XMLParser(true, new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new PdfWriterPipeline(document, pdfWriter))), true), charset);
        if (charset != null) {
            xMLParser.t(inputStream, charset);
        } else {
            xMLParser.s(inputStream);
        }
    }

    public void m(PdfWriter pdfWriter, Document document, InputStream inputStream, Charset charset) throws IOException {
        j(pdfWriter, document, inputStream, XMLWorkerHelper.class.getResourceAsStream("/default.css"), charset);
    }

    public void n(PdfWriter pdfWriter, Document document, InputStream inputStream, Charset charset, FontProvider fontProvider) throws IOException {
        k(pdfWriter, document, inputStream, XMLWorkerHelper.class.getResourceAsStream("/default.css"), charset, fontProvider);
    }

    public void o(PdfWriter pdfWriter, Document document, Reader reader) throws IOException {
        CssFilesImpl cssFilesImpl = new CssFilesImpl();
        cssFilesImpl.a(b());
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver(cssFilesImpl);
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext((CssAppliers) null);
        htmlPipelineContext.x(true).h(true).F(d());
        XMLWorker xMLWorker = new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new PdfWriterPipeline(document, pdfWriter))), true);
        XMLParser xMLParser = new XMLParser();
        xMLParser.a(xMLWorker);
        xMLParser.v(reader);
    }

    public void p(ElementHandler elementHandler, InputStream inputStream, Charset charset) throws IOException {
        CssFilesImpl cssFilesImpl = new CssFilesImpl();
        cssFilesImpl.a(b());
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver(cssFilesImpl);
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext((CssAppliers) null);
        htmlPipelineContext.x(true).h(true).F(d());
        XMLParser xMLParser = new XMLParser(true, new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new ElementHandlerPipeline(elementHandler, (Pipeline) null))), true), charset);
        if (charset != null) {
            xMLParser.t(inputStream, charset);
        } else {
            xMLParser.s(inputStream);
        }
    }

    public void q(ElementHandler elementHandler, Reader reader) throws IOException {
        CssFilesImpl cssFilesImpl = new CssFilesImpl();
        cssFilesImpl.a(b());
        StyleAttrCSSResolver styleAttrCSSResolver = new StyleAttrCSSResolver(cssFilesImpl);
        HtmlPipelineContext htmlPipelineContext = new HtmlPipelineContext((CssAppliers) null);
        htmlPipelineContext.x(true).h(true).F(d());
        XMLWorker xMLWorker = new XMLWorker(new CssResolverPipeline(styleAttrCSSResolver, new HtmlPipeline(htmlPipelineContext, new ElementHandlerPipeline(elementHandler, (Pipeline) null))), true);
        XMLParser xMLParser = new XMLParser();
        xMLParser.a(xMLWorker);
        xMLParser.v(reader);
    }
}
