package org.apache.commons.httpclient.auth;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfBoolean;
import com.itextpdf.text.pdf.PdfWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClientError;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.httpclient.util.ParameterFormatter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'a', 'b', Barcode128.F, Barcode128.G, Barcode128.H, Barcode128.I};
    private static final Log LOG;
    private static final String NC = "00000001";
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    static /* synthetic */ Class class$org$apache$commons$httpclient$auth$DigestScheme;
    private String cnonce;
    private boolean complete;
    private final ParameterFormatter formatter;
    private int qopVariant;

    static {
        Class cls = class$org$apache$commons$httpclient$auth$DigestScheme;
        if (cls == null) {
            cls = class$("org.apache.commons.httpclient.auth.DigestScheme");
            class$org$apache$commons$httpclient$auth$DigestScheme = cls;
        }
        LOG = LogFactory.getLog(cls);
    }

    public DigestScheme() {
        this.qopVariant = 0;
        this.complete = false;
        this.formatter = new ParameterFormatter();
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public static String createCnonce() {
        LOG.trace("enter DigestScheme.createCnonce()");
        try {
            return encode(MessageDigest.getInstance("MD5").digest(EncodingUtil.getAsciiBytes(Long.toString(System.currentTimeMillis()))));
        } catch (NoSuchAlgorithmException unused) {
            throw new HttpClientError("Unsupported algorithm in HTTP Digest authentication: MD5");
        }
    }

    private String createDigest(String str, String str2) throws AuthenticationException {
        String str3;
        String str4;
        Log log = LOG;
        log.trace("enter DigestScheme.createDigest(String, String, Map)");
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("qop");
        String parameter5 = getParameter("methodname");
        String parameter6 = getParameter("algorithm");
        if (parameter6 == null) {
            parameter6 = "MD5";
        }
        String parameter7 = getParameter("charset");
        if (parameter7 == null) {
            parameter7 = "ISO-8859-1";
        }
        if (this.qopVariant != 1) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                StringBuffer stringBuffer = new StringBuffer(str.length() + parameter2.length() + str2.length() + 2);
                stringBuffer.append(str);
                stringBuffer.append(ASCIIPropertyListParser.A);
                stringBuffer.append(parameter2);
                stringBuffer.append(ASCIIPropertyListParser.A);
                stringBuffer.append(str2);
                String stringBuffer2 = stringBuffer.toString();
                if (parameter6.equals("MD5-sess")) {
                    String encode = encode(instance.digest(EncodingUtil.getBytes(stringBuffer2, parameter7)));
                    StringBuffer stringBuffer3 = new StringBuffer(encode.length() + parameter3.length() + this.cnonce.length() + 2);
                    stringBuffer3.append(encode);
                    stringBuffer3.append(ASCIIPropertyListParser.A);
                    stringBuffer3.append(parameter3);
                    stringBuffer3.append(ASCIIPropertyListParser.A);
                    stringBuffer3.append(this.cnonce);
                    stringBuffer2 = stringBuffer3.toString();
                } else if (!parameter6.equals("MD5")) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Unhandled algorithm ");
                    stringBuffer4.append(parameter6);
                    stringBuffer4.append(" requested");
                    log.warn(stringBuffer4.toString());
                }
                String encode2 = encode(instance.digest(EncodingUtil.getBytes(stringBuffer2, parameter7)));
                if (this.qopVariant == 1) {
                    log.error("Unhandled qop auth-int");
                    str3 = null;
                } else {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(parameter5);
                    stringBuffer5.append(":");
                    stringBuffer5.append(parameter);
                    str3 = stringBuffer5.toString();
                }
                String encode3 = encode(instance.digest(EncodingUtil.getAsciiBytes(str3)));
                if (this.qopVariant == 0) {
                    log.debug("Using null qop method");
                    StringBuffer stringBuffer6 = new StringBuffer(encode2.length() + parameter3.length() + encode3.length());
                    stringBuffer6.append(encode2);
                    stringBuffer6.append(ASCIIPropertyListParser.A);
                    stringBuffer6.append(parameter3);
                    stringBuffer6.append(ASCIIPropertyListParser.A);
                    stringBuffer6.append(encode3);
                    str4 = stringBuffer6.toString();
                } else {
                    if (log.isDebugEnabled()) {
                        StringBuffer stringBuffer7 = new StringBuffer();
                        stringBuffer7.append("Using qop method ");
                        stringBuffer7.append(parameter4);
                        log.debug(stringBuffer7.toString());
                    }
                    String qopVariantString = getQopVariantString();
                    StringBuffer stringBuffer8 = new StringBuffer(encode2.length() + parameter3.length() + 8 + this.cnonce.length() + qopVariantString.length() + encode3.length() + 5);
                    stringBuffer8.append(encode2);
                    stringBuffer8.append(ASCIIPropertyListParser.A);
                    stringBuffer8.append(parameter3);
                    stringBuffer8.append(ASCIIPropertyListParser.A);
                    stringBuffer8.append(NC);
                    stringBuffer8.append(ASCIIPropertyListParser.A);
                    stringBuffer8.append(this.cnonce);
                    stringBuffer8.append(ASCIIPropertyListParser.A);
                    stringBuffer8.append(qopVariantString);
                    stringBuffer8.append(ASCIIPropertyListParser.A);
                    stringBuffer8.append(encode3);
                    str4 = stringBuffer8.toString();
                }
                return encode(instance.digest(EncodingUtil.getAsciiBytes(str4)));
            } catch (Exception unused) {
                throw new AuthenticationException("Unsupported algorithm in HTTP Digest authentication: MD5");
            }
        } else {
            log.warn("qop=auth-int is not supported");
            throw new AuthenticationException("Unsupported qop in HTTP Digest authentication");
        }
    }

    private String createDigestHeader(String str, String str2) throws AuthenticationException {
        LOG.trace("enter DigestScheme.createDigestHeader(String, Map, String)");
        String parameter = getParameter("uri");
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("algorithm");
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(new NameValuePair("username", str));
        arrayList.add(new NameValuePair("realm", parameter2));
        arrayList.add(new NameValuePair("nonce", parameter3));
        arrayList.add(new NameValuePair("uri", parameter));
        arrayList.add(new NameValuePair("response", str2));
        if (this.qopVariant != 0) {
            arrayList.add(new NameValuePair("qop", getQopVariantString()));
            arrayList.add(new NameValuePair("nc", NC));
            arrayList.add(new NameValuePair("cnonce", this.cnonce));
        }
        if (parameter5 != null) {
            arrayList.add(new NameValuePair("algorithm", parameter5));
        }
        if (parameter4 != null) {
            arrayList.add(new NameValuePair("opaque", parameter4));
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            NameValuePair nameValuePair = (NameValuePair) arrayList.get(i2);
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            this.formatter.setAlwaysUseQuotes(!("nc".equals(nameValuePair.getName()) || "qop".equals(nameValuePair.getName())));
            this.formatter.format(stringBuffer, nameValuePair);
        }
        return stringBuffer.toString();
    }

    private static String encode(byte[] bArr) {
        LOG.trace("enter DigestScheme.encode(byte[])");
        if (bArr.length != 16) {
            return null;
        }
        char[] cArr = new char[32];
        for (int i2 = 0; i2 < 16; i2++) {
            byte b2 = bArr[i2];
            int i3 = i2 * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i3] = cArr2[(b2 & 240) >> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    private String getQopVariantString() {
        return this.qopVariant == 1 ? "auth-int" : "auth";
    }

    public String authenticate(Credentials credentials, String str, String str2) throws AuthenticationException {
        LOG.trace("enter DigestScheme.authenticate(Credentials, String, String)");
        try {
            UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials) credentials;
            getParameters().put("methodname", str);
            getParameters().put("uri", str2);
            String createDigest = createDigest(usernamePasswordCredentials.getUserName(), usernamePasswordCredentials.getPassword());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Digest ");
            stringBuffer.append(createDigestHeader(usernamePasswordCredentials.getUserName(), createDigest));
            return stringBuffer.toString();
        } catch (ClassCastException unused) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Credentials cannot be used for digest authentication: ");
            stringBuffer2.append(credentials.getClass().getName());
            throw new InvalidCredentialsException(stringBuffer2.toString());
        }
    }

    public String getID() {
        String realm = getRealm();
        String parameter = getParameter("nonce");
        if (parameter == null) {
            return realm;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(realm);
        stringBuffer.append("-");
        stringBuffer.append(parameter);
        return stringBuffer.toString();
    }

    public String getSchemeName() {
        return "digest";
    }

    public boolean isComplete() {
        if (PdfBoolean.l3.equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    public boolean isConnectionBased() {
        return false;
    }

    public void processChallenge(String str) throws MalformedChallengeException {
        super.processChallenge(str);
        if (getParameter("realm") == null) {
            throw new MalformedChallengeException("missing realm in challange");
        } else if (getParameter("nonce") != null) {
            String parameter = getParameter("qop");
            boolean z = false;
            if (parameter != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(parameter, ",");
                while (true) {
                    if (!stringTokenizer.hasMoreTokens()) {
                        break;
                    }
                    String trim = stringTokenizer.nextToken().trim();
                    if (trim.equals("auth")) {
                        this.qopVariant = 2;
                        break;
                    } else if (trim.equals("auth-int")) {
                        this.qopVariant = 1;
                    } else {
                        Log log = LOG;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Unsupported qop detected: ");
                        stringBuffer.append(trim);
                        log.warn(stringBuffer.toString());
                        z = true;
                    }
                }
            }
            if (!z || this.qopVariant != 0) {
                this.cnonce = createCnonce();
                this.complete = true;
                return;
            }
            throw new MalformedChallengeException("None of the qop methods is supported");
        } else {
            throw new MalformedChallengeException("missing nonce in challange");
        }
    }

    public DigestScheme(String str) throws MalformedChallengeException {
        this();
        processChallenge(str);
    }

    public String authenticate(Credentials credentials, HttpMethod httpMethod) throws AuthenticationException {
        LOG.trace("enter DigestScheme.authenticate(Credentials, HttpMethod)");
        try {
            UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials) credentials;
            getParameters().put("methodname", httpMethod.getName());
            StringBuffer stringBuffer = new StringBuffer(httpMethod.getPath());
            String queryString = httpMethod.getQueryString();
            if (queryString != null) {
                if (queryString.indexOf("?") != 0) {
                    stringBuffer.append("?");
                }
                stringBuffer.append(httpMethod.getQueryString());
            }
            getParameters().put("uri", stringBuffer.toString());
            if (getParameter("charset") == null) {
                getParameters().put("charset", httpMethod.getParams().getCredentialCharset());
            }
            String createDigest = createDigest(usernamePasswordCredentials.getUserName(), usernamePasswordCredentials.getPassword());
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Digest ");
            stringBuffer2.append(createDigestHeader(usernamePasswordCredentials.getUserName(), createDigest));
            return stringBuffer2.toString();
        } catch (ClassCastException unused) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Credentials cannot be used for digest authentication: ");
            stringBuffer3.append(credentials.getClass().getName());
            throw new InvalidCredentialsException(stringBuffer3.toString());
        }
    }
}
