package org.apache.commons.httpclient.methods;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ExpectContinueMethod extends HttpMethodBase {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$ExpectContinueMethod;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$ExpectContinueMethod;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.ExpectContinueMethod");
            class$org$apache$commons$httpclient$methods$ExpectContinueMethod = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public ExpectContinueMethod() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void addRequestHeaders(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter ExpectContinueMethod.addRequestHeaders(HttpState, HttpConnection)");
        super.addRequestHeaders(httpState, httpConnection);
        boolean z = getRequestHeader(HttpHeaders.s) != null;
        if (!getParams().isParameterTrue(HttpMethodParams.USE_EXPECT_CONTINUE) || !getEffectiveVersion().greaterEquals(HttpVersion.HTTP_1_1) || !hasRequestContent()) {
            if (z) {
                removeRequestHeader(HttpHeaders.s);
            }
        } else if (!z) {
            setRequestHeader(HttpHeaders.s, "100-continue");
        }
    }

    public boolean getUseExpectHeader() {
        return getParams().getBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE, false);
    }

    /* access modifiers changed from: protected */
    public abstract boolean hasRequestContent();

    public void setUseExpectHeader(boolean z) {
        getParams().setBooleanParameter(HttpMethodParams.USE_EXPECT_CONTINUE, z);
    }

    public ExpectContinueMethod(String str) {
        super(str);
    }
}
