package org.apache.commons.httpclient.methods;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OptionsMethod extends HttpMethodBase {
    private static final Log LOG;
    static /* synthetic */ Class class$org$apache$commons$httpclient$methods$OptionsMethod;
    private Vector methodsAllowed = new Vector();

    static {
        Class cls = class$org$apache$commons$httpclient$methods$OptionsMethod;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.methods.OptionsMethod");
            class$org$apache$commons$httpclient$methods$OptionsMethod = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public OptionsMethod() {
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public Enumeration getAllowedMethods() {
        checkUsed();
        return this.methodsAllowed.elements();
    }

    public String getName() {
        return "OPTIONS";
    }

    public boolean isAllowed(String str) {
        checkUsed();
        return this.methodsAllowed.contains(str);
    }

    public boolean needContentLength() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void processResponseHeaders(HttpState httpState, HttpConnection httpConnection) {
        LOG.trace("enter OptionsMethod.processResponseHeaders(HttpState, HttpConnection)");
        Header responseHeader = getResponseHeader("allow");
        if (responseHeader != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(responseHeader.getValue(), ",");
            while (stringTokenizer.hasMoreElements()) {
                this.methodsAllowed.addElement(stringTokenizer.nextToken().trim().toUpperCase());
            }
        }
    }

    public OptionsMethod(String str) {
        super(str);
    }
}
