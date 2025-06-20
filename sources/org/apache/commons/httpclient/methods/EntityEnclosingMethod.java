package org.apache.commons.httpclient.methods;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.ChunkedOutputStream;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.ProtocolException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class EntityEnclosingMethod extends ExpectContinueMethod {
    public static final long CONTENT_LENGTH_AUTO = -2;
    public static final long CONTENT_LENGTH_CHUNKED = -1;
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$EntityEnclosingMethod;
    private boolean chunked = false;
    private int repeatCount = 0;
    private long requestContentLength = -2;
    private RequestEntity requestEntity;
    private InputStream requestStream = null;
    private String requestString = null;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$EntityEnclosingMethod;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.EntityEnclosingMethod");
            class$org$apache$commons$httpclient$methods$EntityEnclosingMethod = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public EntityEnclosingMethod() {
        setFollowRedirects(false);
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
        String valueOf;
        LOG.trace("enter EntityEnclosingMethod.addContentLengthRequestHeader(HttpState, HttpConnection)");
        if (getRequestHeader("content-length") == null) {
            String str = HttpHeaders.M0;
            if (getRequestHeader(str) == null) {
                long requestContentLength2 = getRequestContentLength();
                if (requestContentLength2 >= 0) {
                    str = HttpHeaders.f22874b;
                    valueOf = String.valueOf(requestContentLength2);
                } else if (getEffectiveVersion().greaterEquals(HttpVersion.HTTP_1_1)) {
                    valueOf = "chunked";
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(getEffectiveVersion());
                    stringBuffer.append(" does not support chunk encoding");
                    throw new ProtocolException(stringBuffer.toString());
                }
                addRequestHeader(str, valueOf);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addRequestHeaders(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        RequestEntity requestEntity2;
        LOG.trace("enter EntityEnclosingMethod.addRequestHeaders(HttpState, HttpConnection)");
        super.addRequestHeaders(httpState, httpConnection);
        addContentLengthRequestHeader(httpState, httpConnection);
        if (getRequestHeader(HttpHeaders.f22875c) == null && (requestEntity2 = getRequestEntity()) != null && requestEntity2.getContentType() != null) {
            setRequestHeader(HttpHeaders.f22875c, requestEntity2.getContentType());
        }
    }

    /* access modifiers changed from: protected */
    public void clearRequestBody() {
        LOG.trace("enter EntityEnclosingMethod.clearRequestBody()");
        this.requestStream = null;
        this.requestString = null;
        this.requestEntity = null;
    }

    /* access modifiers changed from: protected */
    public byte[] generateRequestBody() {
        LOG.trace("enter EntityEnclosingMethod.renerateRequestBody()");
        return null;
    }

    /* access modifiers changed from: protected */
    public RequestEntity generateRequestEntity() {
        byte[] generateRequestBody = generateRequestBody();
        if (generateRequestBody != null) {
            this.requestEntity = new ByteArrayRequestEntity(generateRequestBody);
        } else if (this.requestStream != null) {
            this.requestEntity = new InputStreamRequestEntity(this.requestStream, this.requestContentLength);
            this.requestStream = null;
        } else if (this.requestString != null) {
            String requestCharSet = getRequestCharSet();
            try {
                this.requestEntity = new StringRequestEntity(this.requestString, (String) null, requestCharSet);
            } catch (UnsupportedEncodingException unused) {
                Log log = LOG;
                if (log.isWarnEnabled()) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(requestCharSet);
                    stringBuffer.append(" not supported");
                    log.warn(stringBuffer.toString());
                }
                try {
                    this.requestEntity = new StringRequestEntity(this.requestString, (String) null, (String) null);
                } catch (UnsupportedEncodingException unused2) {
                }
            }
        }
        return this.requestEntity;
    }

    public boolean getFollowRedirects() {
        return false;
    }

    public String getRequestCharSet() {
        if (getRequestHeader(HttpHeaders.f22875c) != null) {
            return super.getRequestCharSet();
        }
        RequestEntity requestEntity2 = this.requestEntity;
        return requestEntity2 != null ? getContentCharSet(new Header(HttpHeaders.f22875c, requestEntity2.getContentType())) : super.getRequestCharSet();
    }

    /* access modifiers changed from: protected */
    public long getRequestContentLength() {
        LOG.trace("enter EntityEnclosingMethod.getRequestContentLength()");
        if (!hasRequestContent()) {
            return 0;
        }
        if (this.chunked) {
            return -1;
        }
        if (this.requestEntity == null) {
            this.requestEntity = generateRequestEntity();
        }
        RequestEntity requestEntity2 = this.requestEntity;
        if (requestEntity2 == null) {
            return 0;
        }
        return requestEntity2.getContentLength();
    }

    public RequestEntity getRequestEntity() {
        return generateRequestEntity();
    }

    /* access modifiers changed from: protected */
    public boolean hasRequestContent() {
        LOG.trace("enter EntityEnclosingMethod.hasRequestContent()");
        return (this.requestEntity == null && this.requestStream == null && this.requestString == null) ? false : true;
    }

    public void recycle() {
        LOG.trace("enter EntityEnclosingMethod.recycle()");
        clearRequestBody();
        this.requestContentLength = -2;
        this.repeatCount = 0;
        this.chunked = false;
        super.recycle();
    }

    public void setContentChunked(boolean z) {
        this.chunked = z;
    }

    public void setFollowRedirects(boolean z) {
        if (!z) {
            super.setFollowRedirects(false);
            return;
        }
        throw new IllegalArgumentException("Entity enclosing requests cannot be redirected without user intervention");
    }

    public void setRequestBody(InputStream inputStream) {
        LOG.trace("enter EntityEnclosingMethod.setRequestBody(InputStream)");
        clearRequestBody();
        this.requestStream = inputStream;
    }

    public void setRequestContentLength(int i2) {
        LOG.trace("enter EntityEnclosingMethod.setRequestContentLength(int)");
        this.requestContentLength = (long) i2;
    }

    public void setRequestEntity(RequestEntity requestEntity2) {
        clearRequestBody();
        this.requestEntity = requestEntity2;
    }

    /* access modifiers changed from: protected */
    public boolean writeRequestBody(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        String str;
        Log log = LOG;
        log.trace("enter EntityEnclosingMethod.writeRequestBody(HttpState, HttpConnection)");
        if (!hasRequestContent()) {
            str = "Request body has not been specified";
        } else {
            if (this.requestEntity == null) {
                this.requestEntity = generateRequestEntity();
            }
            if (this.requestEntity == null) {
                str = "Request body is empty";
            } else {
                long requestContentLength2 = getRequestContentLength();
                if (this.repeatCount <= 0 || this.requestEntity.isRepeatable()) {
                    this.repeatCount++;
                    OutputStream requestOutputStream = httpConnection.getRequestOutputStream();
                    if (requestContentLength2 < 0) {
                        requestOutputStream = new ChunkedOutputStream(requestOutputStream);
                    }
                    this.requestEntity.writeRequest(requestOutputStream);
                    if (requestOutputStream instanceof ChunkedOutputStream) {
                        ((ChunkedOutputStream) requestOutputStream).finish();
                    }
                    requestOutputStream.flush();
                    str = "Request body sent";
                } else {
                    throw new ProtocolException("Unbuffered entity enclosing request can not be repeated.");
                }
            }
        }
        log.debug(str);
        return true;
    }

    public EntityEnclosingMethod(String str) {
        super(str);
        setFollowRedirects(false);
    }

    public void setRequestBody(String str) {
        LOG.trace("enter EntityEnclosingMethod.setRequestBody(String)");
        clearRequestBody();
        this.requestString = str;
    }

    public void setRequestContentLength(long j2) {
        LOG.trace("enter EntityEnclosingMethod.setRequestContentLength(int)");
        this.requestContentLength = j2;
    }
}
