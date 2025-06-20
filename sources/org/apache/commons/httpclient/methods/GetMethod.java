package org.apache.commons.httpclient.methods;

import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetMethod extends HttpMethodBase {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$GetMethod;

    static {
        Class cls = class$org$apache$commons$httpclient$methods$GetMethod;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.GetMethod");
            class$org$apache$commons$httpclient$methods$GetMethod = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public GetMethod() {
        setFollowRedirects(true);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public String getName() {
        return "GET";
    }

    public void recycle() {
        LOG.trace("enter GetMethod.recycle()");
        super.recycle();
        setFollowRedirects(true);
    }

    public GetMethod(String str) {
        super(str);
        LOG.trace("enter GetMethod(String)");
        setFollowRedirects(true);
    }
}
