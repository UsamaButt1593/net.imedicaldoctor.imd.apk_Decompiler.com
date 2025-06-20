package org.apache.commons.httpclient.methods;

import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MultipartPostMethod extends ExpectContinueMethod {
    private static final Log LOG;
    public static final String MULTIPART_FORM_CONTENT_TYPE = "multipart/form-data";
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$MultipartPostMethod;
    private final List parameters = new ArrayList();

    static {
        Class cls = class$org$apache$commons$httpclient$methods$MultipartPostMethod;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.MultipartPostMethod");
            class$org$apache$commons$httpclient$methods$MultipartPostMethod = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public MultipartPostMethod() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void addContentLengthRequestHeader(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter EntityEnclosingMethod.addContentLengthRequestHeader(HttpState, HttpConnection)");
        if (getRequestHeader(HttpHeaders.f22874b) == null) {
            addRequestHeader(HttpHeaders.f22874b, String.valueOf(getRequestContentLength()));
        }
        removeRequestHeader(HttpHeaders.M0);
    }

    /* access modifiers changed from: protected */
    public void addContentTypeRequestHeader(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter EntityEnclosingMethod.addContentTypeRequestHeader(HttpState, HttpConnection)");
        if (!this.parameters.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer(MULTIPART_FORM_CONTENT_TYPE);
            if (Part.getBoundary() != null) {
                stringBuffer.append("; boundary=");
                stringBuffer.append(Part.getBoundary());
            }
            setRequestHeader(HttpHeaders.f22875c, stringBuffer.toString());
        }
    }

    public void addParameter(String str, File file) throws FileNotFoundException {
        LOG.trace("enter MultipartPostMethod.addParameter(String parameterName, File parameterFile)");
        this.parameters.add(new FilePart(str, file));
    }

    public void addPart(Part part) {
        LOG.trace("enter addPart(Part part)");
        this.parameters.add(part);
    }

    /* access modifiers changed from: protected */
    public void addRequestHeaders(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter MultipartPostMethod.addRequestHeaders(HttpState state, HttpConnection conn)");
        super.addRequestHeaders(httpState, httpConnection);
        addContentLengthRequestHeader(httpState, httpConnection);
        addContentTypeRequestHeader(httpState, httpConnection);
    }

    public String getName() {
        return "POST";
    }

    public Part[] getParts() {
        List list = this.parameters;
        return (Part[]) list.toArray(new Part[list.size()]);
    }

    /* access modifiers changed from: protected */
    public long getRequestContentLength() throws IOException {
        LOG.trace("enter MultipartPostMethod.getRequestContentLength()");
        return Part.getLengthOfParts(getParts());
    }

    /* access modifiers changed from: protected */
    public boolean hasRequestContent() {
        return true;
    }

    public void recycle() {
        LOG.trace("enter MultipartPostMethod.recycle()");
        super.recycle();
        this.parameters.clear();
    }

    /* access modifiers changed from: protected */
    public boolean writeRequestBody(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter MultipartPostMethod.writeRequestBody(HttpState state, HttpConnection conn)");
        Part.sendParts(httpConnection.getRequestOutputStream(), getParts());
        return true;
    }

    public MultipartPostMethod(String str) {
        super(str);
    }

    public void addParameter(String str, String str2) {
        LOG.trace("enter addParameter(String parameterName, String parameterValue)");
        this.parameters.add(new StringPart(str, str2));
    }

    public void addParameter(String str, String str2, File file) throws FileNotFoundException {
        LOG.trace("enter MultipartPostMethod.addParameter(String parameterName, String fileName, File parameterFile)");
        this.parameters.add(new FilePart(str, str2, file));
    }
}
