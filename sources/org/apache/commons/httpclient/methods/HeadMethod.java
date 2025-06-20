package org.apache.commons.httpclient.methods;

import java.io.IOException;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.ProtocolException;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeadMethod extends HttpMethodBase {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$HeadMethod;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$HeadMethod;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.HeadMethod");
            class$org$apache$commons$httpclient$methods$HeadMethod = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public HeadMethod() {
        setFollowRedirects(true);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public int getBodyCheckTimeout() {
        return getParams().getIntParameter(HttpMethodParams.HEAD_BODY_CHECK_TIMEOUT, -1);
    }

    public String getName() {
        return "HEAD";
    }

    /* access modifiers changed from: protected */
    public void readResponseBody(HttpState httpState, HttpConnection httpConnection) throws HttpException, IOException {
        boolean z;
        Log log = LOG;
        log.trace("enter HeadMethod.readResponseBody(HttpState, HttpConnection)");
        int intParameter = getParams().getIntParameter(HttpMethodParams.HEAD_BODY_CHECK_TIMEOUT, -1);
        if (intParameter < 0) {
            responseBodyConsumed();
            return;
        }
        if (log.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Check for non-compliant response body. Timeout in ");
            stringBuffer.append(intParameter);
            stringBuffer.append(" ms");
            log.debug(stringBuffer.toString());
        }
        try {
            z = httpConnection.isResponseAvailable(intParameter);
        } catch (IOException e2) {
            LOG.debug("An IOException occurred while testing if a response was available, we will assume one is not.", e2);
            z = false;
        }
        if (!z) {
            return;
        }
        if (!getParams().isParameterTrue(HttpMethodParams.REJECT_HEAD_BODY)) {
            LOG.warn("Body content returned in response to HTTP HEAD");
            super.readResponseBody(httpState, httpConnection);
            return;
        }
        throw new ProtocolException("Body content may not be sent in response to HTTP HEAD request");
    }

    public void recycle() {
        super.recycle();
        setFollowRedirects(true);
    }

    public void setBodyCheckTimeout(int i2) {
        getParams().setIntParameter(HttpMethodParams.HEAD_BODY_CHECK_TIMEOUT, i2);
    }

    public HeadMethod(String str) {
        super(str);
        setFollowRedirects(true);
    }
}
