package org.apache.commons.httpclient;

import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConnectMethod extends HttpMethodBase {
    private static final Log LOG;
    public static final String NAME = "CONNECT";
    static /* synthetic */ Class class$org$apache$commons$httpclient$ConnectMethod;
    private final HostConfiguration targethost;

    static {
        Class cls = class$org$apache$commons$httpclient$ConnectMethod;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.ConnectMethod");
            class$org$apache$commons$httpclient$ConnectMethod = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public ConnectMethod() {
        this.targethost = null;
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void addCookieRequestHeader(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
    }

    /* access modifiers changed from: protected */
    public void addRequestHeaders(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        LOG.trace("enter ConnectMethod.addRequestHeaders(HttpState, HttpConnection)");
        addUserAgentRequestHeader(httpState, httpConnection);
        addHostRequestHeader(httpState, httpConnection);
        addProxyConnectionHeader(httpState, httpConnection);
    }

    public int execute(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        Log log = LOG;
        log.trace("enter ConnectMethod.execute(HttpState, HttpConnection)");
        int execute = super.execute(httpState, httpConnection);
        if (log.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CONNECT status code ");
            stringBuffer.append(execute);
            log.debug(stringBuffer.toString());
        }
        return execute;
    }

    public String getName() {
        return NAME;
    }

    public String getPath() {
        if (this.targethost == null) {
            return "/";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.targethost.getHost());
        int port = this.targethost.getPort();
        if (port == -1) {
            port = this.targethost.getProtocol().getDefaultPort();
        }
        stringBuffer.append(ASCIIPropertyListParser.A);
        stringBuffer.append(port);
        return stringBuffer.toString();
    }

    public URI getURI() throws URIException {
        return new URI(getPath(), true, getParams().getUriCharset());
    }

    /* access modifiers changed from: protected */
    public boolean shouldCloseConnection(HttpConnection httpConnection) {
        if (getStatusCode() != 200) {
            return super.shouldCloseConnection(httpConnection);
        }
        Header responseHeader = !httpConnection.isTransparent() ? getResponseHeader("proxy-connection") : null;
        if (responseHeader == null) {
            responseHeader = getResponseHeader("connection");
        }
        if (responseHeader == null || !responseHeader.getValue().equalsIgnoreCase("close")) {
            return false;
        }
        Log log = LOG;
        if (!log.isWarnEnabled()) {
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Invalid header encountered '");
        stringBuffer.append(responseHeader.toExternalForm());
        stringBuffer.append("' in response ");
        stringBuffer.append(getStatusLine().toString());
        log.warn(stringBuffer.toString());
        return false;
    }

    /* access modifiers changed from: protected */
    public void writeRequestLine(HttpState httpState, HttpConnection httpConnection) throws IOException, HttpException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getName());
        stringBuffer.append(' ');
        if (this.targethost != null) {
            stringBuffer.append(getPath());
        } else {
            int port = httpConnection.getPort();
            if (port == -1) {
                port = httpConnection.getProtocol().getDefaultPort();
            }
            stringBuffer.append(httpConnection.getHost());
            stringBuffer.append(ASCIIPropertyListParser.A);
            stringBuffer.append(port);
        }
        stringBuffer.append(StringUtils.SPACE);
        stringBuffer.append(getEffectiveVersion());
        String stringBuffer2 = stringBuffer.toString();
        httpConnection.printLine(stringBuffer2, getParams().getHttpElementCharset());
        if (Wire.HEADER_WIRE.enabled()) {
            Wire.HEADER_WIRE.output(stringBuffer2);
        }
    }

    public ConnectMethod(HostConfiguration hostConfiguration) {
        if (hostConfiguration != null) {
            this.targethost = hostConfiguration;
            return;
        }
        throw new IllegalArgumentException("Target host may not be null");
    }

    public ConnectMethod(HttpMethod httpMethod) {
        this.targethost = null;
    }
}
