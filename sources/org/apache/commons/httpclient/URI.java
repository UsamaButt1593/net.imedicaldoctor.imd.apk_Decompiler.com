package org.apache.commons.httpclient;

import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.tool.xml.css.CSS;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Hashtable;
import java.util.Locale;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.util.EncodingUtil;

public class URI implements Cloneable, Comparable, Serializable {
    protected static final BitSet IPv4address;
    protected static final BitSet IPv6address;
    protected static final BitSet IPv6reference;
    protected static final BitSet URI_reference;
    protected static final BitSet abs_path;
    protected static final BitSet absoluteURI;
    public static final BitSet allowed_IPv6reference;
    public static final BitSet allowed_abs_path;
    public static final BitSet allowed_authority;
    public static final BitSet allowed_fragment;
    public static final BitSet allowed_host;
    public static final BitSet allowed_opaque_part;
    public static final BitSet allowed_query;
    public static final BitSet allowed_reg_name;
    public static final BitSet allowed_rel_path;
    public static final BitSet allowed_userinfo;
    public static final BitSet allowed_within_authority;
    public static final BitSet allowed_within_path;
    public static final BitSet allowed_within_query;
    public static final BitSet allowed_within_userinfo;
    protected static final BitSet alpha = new BitSet(256);
    protected static final BitSet alphanum;
    protected static final BitSet authority;
    public static final BitSet control = new BitSet(256);
    protected static String defaultDocumentCharset = null;
    protected static String defaultDocumentCharsetByLocale = null;
    protected static String defaultDocumentCharsetByPlatform = null;
    protected static String defaultProtocolCharset = "UTF-8";
    public static final BitSet delims;
    protected static final BitSet digit = new BitSet(256);
    public static final BitSet disallowed_opaque_part;
    public static final BitSet disallowed_rel_path;
    protected static final BitSet domainlabel;
    protected static final BitSet escaped;
    protected static final BitSet fragment;
    protected static final BitSet hex;
    protected static final BitSet hier_part;
    protected static final BitSet host;
    protected static final BitSet hostname;
    protected static final BitSet hostport;
    protected static final BitSet mark;
    protected static final BitSet net_path;
    protected static final BitSet opaque_part;
    protected static final BitSet param;
    protected static final BitSet path;
    protected static final BitSet path_segments;
    protected static final BitSet pchar;
    protected static final BitSet percent;
    protected static final BitSet port;
    protected static final BitSet query;
    protected static final BitSet reg_name;
    protected static final BitSet rel_path;
    protected static final BitSet rel_segment;
    protected static final BitSet relativeURI;
    protected static final BitSet reserved;
    protected static final char[] rootPath = {'/'};
    protected static final BitSet scheme;
    protected static final BitSet segment;
    static final long serialVersionUID = 604752400577948726L;
    protected static final BitSet server;
    public static final BitSet space;
    protected static final BitSet toplabel;
    protected static final BitSet unreserved;
    public static final BitSet unwise;
    protected static final BitSet uric;
    protected static final BitSet uric_no_slash;
    protected static final BitSet userinfo;
    public static final BitSet within_userinfo;
    protected char[] _authority;
    protected char[] _fragment;
    protected char[] _host;
    protected boolean _is_IPv4address;
    protected boolean _is_IPv6reference;
    protected boolean _is_abs_path;
    protected boolean _is_hier_part;
    protected boolean _is_hostname;
    protected boolean _is_net_path;
    protected boolean _is_opaque_part;
    protected boolean _is_reg_name;
    protected boolean _is_rel_path;
    protected boolean _is_server;
    protected char[] _opaque;
    protected char[] _path;
    protected int _port;
    protected char[] _query;
    protected char[] _scheme;
    protected char[] _uri;
    protected char[] _userinfo;
    protected int hash;
    protected String protocolCharset;

    public static class DefaultCharsetChanged extends RuntimeException {
        public static final int DOCUMENT_CHARSET = 2;
        public static final int PROTOCOL_CHARSET = 1;
        public static final int UNKNOWN = 0;
        private String reason;
        private int reasonCode;

        public DefaultCharsetChanged(int i2, String str) {
            super(str);
            this.reason = str;
            this.reasonCode = i2;
        }

        public String getReason() {
            return this.reason;
        }

        public int getReasonCode() {
            return this.reasonCode;
        }
    }

    public static class LocaleToCharsetMap {
        private static final Hashtable LOCALE_TO_CHARSET_MAP;

        static {
            Hashtable hashtable = new Hashtable();
            LOCALE_TO_CHARSET_MAP = hashtable;
            hashtable.put("ar", "ISO-8859-6");
            hashtable.put("be", "ISO-8859-5");
            hashtable.put("bg", "ISO-8859-5");
            hashtable.put("ca", "ISO-8859-1");
            hashtable.put("cs", "ISO-8859-2");
            hashtable.put("da", "ISO-8859-1");
            hashtable.put("de", "ISO-8859-1");
            hashtable.put("el", "ISO-8859-7");
            hashtable.put("en", "ISO-8859-1");
            hashtable.put("es", "ISO-8859-1");
            hashtable.put("et", "ISO-8859-1");
            hashtable.put("fi", "ISO-8859-1");
            hashtable.put("fr", "ISO-8859-1");
            hashtable.put("hr", "ISO-8859-2");
            hashtable.put("hu", "ISO-8859-2");
            hashtable.put("is", "ISO-8859-1");
            hashtable.put("it", "ISO-8859-1");
            hashtable.put("iw", "ISO-8859-8");
            hashtable.put("ja", "Shift_JIS");
            hashtable.put("ko", "EUC-KR");
            hashtable.put("lt", "ISO-8859-2");
            hashtable.put("lv", "ISO-8859-2");
            hashtable.put("mk", "ISO-8859-5");
            hashtable.put("nl", "ISO-8859-1");
            hashtable.put("no", "ISO-8859-1");
            hashtable.put("pl", "ISO-8859-2");
            hashtable.put(CSS.Value.l0, "ISO-8859-1");
            hashtable.put("ro", "ISO-8859-2");
            hashtable.put("ru", "ISO-8859-5");
            hashtable.put("sh", "ISO-8859-5");
            hashtable.put("sk", "ISO-8859-2");
            hashtable.put("sl", "ISO-8859-2");
            hashtable.put("sq", "ISO-8859-2");
            hashtable.put("sr", "ISO-8859-5");
            hashtable.put("sv", "ISO-8859-1");
            hashtable.put("tr", "ISO-8859-9");
            hashtable.put("uk", "ISO-8859-5");
            hashtable.put("zh", "GB2312");
            hashtable.put("zh_TW", "Big5");
        }

        public static String getCharset(Locale locale) {
            Hashtable hashtable = LOCALE_TO_CHARSET_MAP;
            String str = (String) hashtable.get(locale.toString());
            return str != null ? str : (String) hashtable.get(locale.getLanguage());
        }
    }

    static {
        Locale locale = Locale.getDefault();
        if (locale != null) {
            String charset = LocaleToCharsetMap.getCharset(locale);
            defaultDocumentCharsetByLocale = charset;
            defaultDocumentCharset = charset;
        }
        try {
            defaultDocumentCharsetByPlatform = System.getProperty("file.encoding");
        } catch (SecurityException unused) {
        }
        if (defaultDocumentCharset == null) {
            defaultDocumentCharset = defaultDocumentCharsetByPlatform;
        }
        BitSet bitSet = new BitSet(256);
        percent = bitSet;
        bitSet.set(37);
        for (int i2 = 48; i2 <= 57; i2++) {
            digit.set(i2);
        }
        for (int i3 = 97; i3 <= 122; i3++) {
            alpha.set(i3);
        }
        for (int i4 = 65; i4 <= 90; i4++) {
            alpha.set(i4);
        }
        BitSet bitSet2 = new BitSet(256);
        alphanum = bitSet2;
        bitSet2.or(alpha);
        BitSet bitSet3 = digit;
        bitSet2.or(bitSet3);
        BitSet bitSet4 = new BitSet(256);
        hex = bitSet4;
        bitSet4.or(bitSet3);
        for (int i5 = 97; i5 <= 102; i5++) {
            hex.set(i5);
        }
        for (int i6 = 65; i6 <= 70; i6++) {
            hex.set(i6);
        }
        BitSet bitSet5 = new BitSet(256);
        escaped = bitSet5;
        bitSet5.or(percent);
        BitSet bitSet6 = hex;
        bitSet5.or(bitSet6);
        BitSet bitSet7 = new BitSet(256);
        mark = bitSet7;
        bitSet7.set(45);
        bitSet7.set(95);
        bitSet7.set(46);
        bitSet7.set(33);
        bitSet7.set(126);
        bitSet7.set(42);
        bitSet7.set(39);
        bitSet7.set(40);
        bitSet7.set(41);
        BitSet bitSet8 = new BitSet(256);
        unreserved = bitSet8;
        BitSet bitSet9 = alphanum;
        bitSet8.or(bitSet9);
        bitSet8.or(bitSet7);
        BitSet bitSet10 = new BitSet(256);
        reserved = bitSet10;
        bitSet10.set(59);
        bitSet10.set(47);
        bitSet10.set(63);
        bitSet10.set(58);
        bitSet10.set(64);
        bitSet10.set(38);
        bitSet10.set(61);
        bitSet10.set(43);
        bitSet10.set(36);
        bitSet10.set(44);
        BitSet bitSet11 = new BitSet(256);
        uric = bitSet11;
        bitSet11.or(bitSet10);
        bitSet11.or(bitSet8);
        bitSet11.or(bitSet5);
        fragment = bitSet11;
        query = bitSet11;
        BitSet bitSet12 = new BitSet(256);
        pchar = bitSet12;
        bitSet12.or(bitSet8);
        bitSet12.or(bitSet5);
        bitSet12.set(58);
        bitSet12.set(64);
        bitSet12.set(38);
        bitSet12.set(61);
        bitSet12.set(43);
        bitSet12.set(36);
        bitSet12.set(44);
        param = bitSet12;
        BitSet bitSet13 = new BitSet(256);
        segment = bitSet13;
        bitSet13.or(bitSet12);
        bitSet13.set(59);
        bitSet13.or(bitSet12);
        BitSet bitSet14 = new BitSet(256);
        path_segments = bitSet14;
        bitSet14.set(47);
        bitSet14.or(bitSet13);
        BitSet bitSet15 = new BitSet(256);
        abs_path = bitSet15;
        bitSet15.set(47);
        bitSet15.or(bitSet14);
        BitSet bitSet16 = new BitSet(256);
        uric_no_slash = bitSet16;
        bitSet16.or(bitSet8);
        bitSet16.or(bitSet5);
        bitSet16.set(59);
        bitSet16.set(63);
        bitSet16.set(59);
        bitSet16.set(64);
        bitSet16.set(38);
        bitSet16.set(61);
        bitSet16.set(43);
        bitSet16.set(36);
        bitSet16.set(44);
        BitSet bitSet17 = new BitSet(256);
        opaque_part = bitSet17;
        bitSet17.or(bitSet16);
        bitSet17.or(bitSet11);
        BitSet bitSet18 = new BitSet(256);
        path = bitSet18;
        bitSet18.or(bitSet15);
        bitSet18.or(bitSet17);
        BitSet bitSet19 = digit;
        port = bitSet19;
        BitSet bitSet20 = new BitSet(256);
        IPv4address = bitSet20;
        bitSet20.or(bitSet19);
        bitSet20.set(46);
        BitSet bitSet21 = new BitSet(256);
        IPv6address = bitSet21;
        bitSet21.or(bitSet6);
        bitSet21.set(58);
        bitSet21.or(bitSet20);
        BitSet bitSet22 = new BitSet(256);
        IPv6reference = bitSet22;
        bitSet22.set(91);
        bitSet22.or(bitSet21);
        bitSet22.set(93);
        BitSet bitSet23 = new BitSet(256);
        toplabel = bitSet23;
        bitSet23.or(bitSet9);
        bitSet23.set(45);
        domainlabel = bitSet23;
        BitSet bitSet24 = new BitSet(256);
        hostname = bitSet24;
        bitSet24.or(bitSet23);
        bitSet24.set(46);
        BitSet bitSet25 = new BitSet(256);
        host = bitSet25;
        bitSet25.or(bitSet24);
        bitSet25.or(bitSet22);
        BitSet bitSet26 = new BitSet(256);
        hostport = bitSet26;
        bitSet26.or(bitSet25);
        bitSet26.set(58);
        bitSet26.or(bitSet19);
        BitSet bitSet27 = new BitSet(256);
        userinfo = bitSet27;
        bitSet27.or(bitSet8);
        bitSet27.or(bitSet5);
        bitSet27.set(59);
        bitSet27.set(58);
        bitSet27.set(38);
        bitSet27.set(61);
        bitSet27.set(43);
        bitSet27.set(36);
        bitSet27.set(44);
        BitSet bitSet28 = new BitSet(256);
        within_userinfo = bitSet28;
        bitSet28.or(bitSet27);
        bitSet28.clear(59);
        bitSet28.clear(58);
        bitSet28.clear(64);
        bitSet28.clear(63);
        bitSet28.clear(47);
        BitSet bitSet29 = new BitSet(256);
        server = bitSet29;
        bitSet29.or(bitSet27);
        bitSet29.set(64);
        bitSet29.or(bitSet26);
        BitSet bitSet30 = new BitSet(256);
        reg_name = bitSet30;
        bitSet30.or(bitSet8);
        bitSet30.or(bitSet5);
        bitSet30.set(36);
        bitSet30.set(44);
        bitSet30.set(59);
        bitSet30.set(58);
        bitSet30.set(64);
        bitSet30.set(38);
        bitSet30.set(61);
        bitSet30.set(43);
        BitSet bitSet31 = new BitSet(256);
        authority = bitSet31;
        bitSet31.or(bitSet29);
        bitSet31.or(bitSet30);
        BitSet bitSet32 = new BitSet(256);
        scheme = bitSet32;
        bitSet32.or(alpha);
        bitSet32.or(bitSet19);
        bitSet32.set(43);
        bitSet32.set(45);
        bitSet32.set(46);
        BitSet bitSet33 = new BitSet(256);
        rel_segment = bitSet33;
        bitSet33.or(bitSet8);
        bitSet33.or(bitSet5);
        bitSet33.set(59);
        bitSet33.set(64);
        bitSet33.set(38);
        bitSet33.set(61);
        bitSet33.set(43);
        bitSet33.set(36);
        bitSet33.set(44);
        BitSet bitSet34 = new BitSet(256);
        rel_path = bitSet34;
        bitSet34.or(bitSet33);
        bitSet34.or(bitSet15);
        BitSet bitSet35 = new BitSet(256);
        net_path = bitSet35;
        bitSet35.set(47);
        bitSet35.or(bitSet31);
        bitSet35.or(bitSet15);
        BitSet bitSet36 = new BitSet(256);
        hier_part = bitSet36;
        bitSet36.or(bitSet35);
        bitSet36.or(bitSet15);
        bitSet36.or(bitSet11);
        BitSet bitSet37 = new BitSet(256);
        relativeURI = bitSet37;
        bitSet37.or(bitSet35);
        bitSet37.or(bitSet15);
        bitSet37.or(bitSet34);
        bitSet37.or(bitSet11);
        BitSet bitSet38 = new BitSet(256);
        absoluteURI = bitSet38;
        bitSet38.or(bitSet32);
        bitSet38.set(58);
        bitSet38.or(bitSet36);
        bitSet38.or(bitSet17);
        BitSet bitSet39 = new BitSet(256);
        URI_reference = bitSet39;
        bitSet39.or(bitSet38);
        bitSet39.or(bitSet37);
        bitSet39.set(35);
        bitSet39.or(bitSet11);
        for (int i7 = 0; i7 <= 31; i7++) {
            control.set(i7);
        }
        control.set(WorkQueueKt.f29430c);
        BitSet bitSet40 = new BitSet(256);
        space = bitSet40;
        bitSet40.set(32);
        BitSet bitSet41 = new BitSet(256);
        delims = bitSet41;
        bitSet41.set(60);
        bitSet41.set(62);
        bitSet41.set(35);
        bitSet41.set(37);
        bitSet41.set(34);
        BitSet bitSet42 = new BitSet(256);
        unwise = bitSet42;
        bitSet42.set(123);
        bitSet42.set(125);
        bitSet42.set(124);
        bitSet42.set(92);
        bitSet42.set(94);
        bitSet42.set(91);
        bitSet42.set(93);
        bitSet42.set(96);
        BitSet bitSet43 = new BitSet(256);
        disallowed_rel_path = bitSet43;
        BitSet bitSet44 = uric;
        bitSet43.or(bitSet44);
        BitSet bitSet45 = rel_path;
        bitSet43.andNot(bitSet45);
        BitSet bitSet46 = new BitSet(256);
        disallowed_opaque_part = bitSet46;
        bitSet46.or(bitSet44);
        BitSet bitSet47 = opaque_part;
        bitSet46.andNot(bitSet47);
        BitSet bitSet48 = new BitSet(256);
        allowed_authority = bitSet48;
        bitSet48.or(authority);
        bitSet48.clear(37);
        BitSet bitSet49 = new BitSet(256);
        allowed_opaque_part = bitSet49;
        bitSet49.or(bitSet47);
        bitSet49.clear(37);
        BitSet bitSet50 = new BitSet(256);
        allowed_reg_name = bitSet50;
        BitSet bitSet51 = reg_name;
        bitSet50.or(bitSet51);
        bitSet50.clear(37);
        BitSet bitSet52 = new BitSet(256);
        allowed_userinfo = bitSet52;
        bitSet52.or(userinfo);
        bitSet52.clear(37);
        BitSet bitSet53 = new BitSet(256);
        allowed_within_userinfo = bitSet53;
        bitSet53.or(within_userinfo);
        bitSet53.clear(37);
        BitSet bitSet54 = new BitSet(256);
        allowed_IPv6reference = bitSet54;
        bitSet54.or(IPv6reference);
        bitSet54.clear(91);
        bitSet54.clear(93);
        BitSet bitSet55 = new BitSet(256);
        allowed_host = bitSet55;
        bitSet55.or(hostname);
        bitSet55.or(bitSet54);
        BitSet bitSet56 = new BitSet(256);
        allowed_within_authority = bitSet56;
        bitSet56.or(server);
        bitSet56.or(bitSet51);
        bitSet56.clear(59);
        bitSet56.clear(58);
        bitSet56.clear(64);
        bitSet56.clear(63);
        bitSet56.clear(47);
        BitSet bitSet57 = new BitSet(256);
        allowed_abs_path = bitSet57;
        BitSet bitSet58 = abs_path;
        bitSet57.or(bitSet58);
        bitSet57.andNot(percent);
        bitSet57.clear(43);
        BitSet bitSet59 = new BitSet(256);
        allowed_rel_path = bitSet59;
        bitSet59.or(bitSet45);
        bitSet59.clear(37);
        bitSet59.clear(43);
        BitSet bitSet60 = new BitSet(256);
        allowed_within_path = bitSet60;
        bitSet60.or(bitSet58);
        bitSet60.clear(47);
        bitSet60.clear(59);
        bitSet60.clear(61);
        bitSet60.clear(63);
        BitSet bitSet61 = new BitSet(256);
        allowed_query = bitSet61;
        bitSet61.or(bitSet44);
        bitSet61.clear(37);
        BitSet bitSet62 = new BitSet(256);
        allowed_within_query = bitSet62;
        bitSet62.or(bitSet61);
        bitSet62.andNot(reserved);
        BitSet bitSet63 = new BitSet(256);
        allowed_fragment = bitSet63;
        bitSet63.or(bitSet44);
        bitSet63.clear(37);
    }

    protected URI() {
        this.hash = 0;
        this._uri = null;
        this.protocolCharset = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
    }

    protected static String decode(String str, String str2) throws URIException {
        if (str != null) {
            try {
                return EncodingUtil.getString(URLCodec.decodeUrl(EncodingUtil.getAsciiBytes(str)), str2);
            } catch (DecoderException e2) {
                throw new URIException(e2.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Component array of chars may not be null");
        }
    }

    protected static char[] encode(String str, BitSet bitSet, String str2) throws URIException {
        if (str == null) {
            throw new IllegalArgumentException("Original string may not be null");
        } else if (bitSet != null) {
            return EncodingUtil.getAsciiString(URLCodec.encodeUrl(bitSet, EncodingUtil.getBytes(str, str2))).toCharArray();
        } else {
            throw new IllegalArgumentException("Allowed bitset may not be null");
        }
    }

    public static String getDefaultDocumentCharset() {
        return defaultDocumentCharset;
    }

    public static String getDefaultDocumentCharsetByLocale() {
        return defaultDocumentCharsetByLocale;
    }

    public static String getDefaultDocumentCharsetByPlatform() {
        return defaultDocumentCharsetByPlatform;
    }

    public static String getDefaultProtocolCharset() {
        return defaultProtocolCharset;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }

    public static void setDefaultDocumentCharset(String str) throws DefaultCharsetChanged {
        defaultDocumentCharset = str;
        throw new DefaultCharsetChanged(2, "the default document charset changed");
    }

    public static void setDefaultProtocolCharset(String str) throws DefaultCharsetChanged {
        defaultProtocolCharset = str;
        throw new DefaultCharsetChanged(1, "the default protocol charset changed");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public synchronized Object clone() throws CloneNotSupportedException {
        URI uri;
        uri = (URI) super.clone();
        uri._uri = this._uri;
        uri._scheme = this._scheme;
        uri._opaque = this._opaque;
        uri._authority = this._authority;
        uri._userinfo = this._userinfo;
        uri._host = this._host;
        uri._port = this._port;
        uri._path = this._path;
        uri._query = this._query;
        uri._fragment = this._fragment;
        uri.protocolCharset = this.protocolCharset;
        uri._is_hier_part = this._is_hier_part;
        uri._is_opaque_part = this._is_opaque_part;
        uri._is_net_path = this._is_net_path;
        uri._is_abs_path = this._is_abs_path;
        uri._is_rel_path = this._is_rel_path;
        uri._is_reg_name = this._is_reg_name;
        uri._is_server = this._is_server;
        uri._is_hostname = this._is_hostname;
        uri._is_IPv4address = this._is_IPv4address;
        uri._is_IPv6reference = this._is_IPv6reference;
        return uri;
    }

    public int compareTo(Object obj) throws ClassCastException {
        URI uri = (URI) obj;
        if (!equals(this._authority, uri.getRawAuthority())) {
            return -1;
        }
        return toString().compareTo(uri.toString());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof URI)) {
            return false;
        }
        URI uri = (URI) obj;
        return equals(this._scheme, uri._scheme) && equals(this._opaque, uri._opaque) && equals(this._authority, uri._authority) && equals(this._path, uri._path) && equals(this._query, uri._query) && equals(this._fragment, uri._fragment);
    }

    public String getAboveHierPath() throws URIException {
        char[] rawAboveHierPath = getRawAboveHierPath();
        if (rawAboveHierPath == null) {
            return null;
        }
        return decode(rawAboveHierPath, getProtocolCharset());
    }

    public String getAuthority() throws URIException {
        char[] cArr = this._authority;
        if (cArr == null) {
            return null;
        }
        return decode(cArr, getProtocolCharset());
    }

    public String getCurrentHierPath() throws URIException {
        char[] rawCurrentHierPath = getRawCurrentHierPath();
        if (rawCurrentHierPath == null) {
            return null;
        }
        return decode(rawCurrentHierPath, getProtocolCharset());
    }

    public String getEscapedAboveHierPath() throws URIException {
        char[] rawAboveHierPath = getRawAboveHierPath();
        if (rawAboveHierPath == null) {
            return null;
        }
        return new String(rawAboveHierPath);
    }

    public String getEscapedAuthority() {
        char[] cArr = this._authority;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public String getEscapedCurrentHierPath() throws URIException {
        char[] rawCurrentHierPath = getRawCurrentHierPath();
        if (rawCurrentHierPath == null) {
            return null;
        }
        return new String(rawCurrentHierPath);
    }

    public String getEscapedFragment() {
        char[] cArr = this._fragment;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public String getEscapedName() {
        char[] rawName = getRawName();
        if (rawName == null) {
            return null;
        }
        return new String(rawName);
    }

    public String getEscapedPath() {
        char[] rawPath = getRawPath();
        if (rawPath == null) {
            return null;
        }
        return new String(rawPath);
    }

    public String getEscapedPathQuery() {
        char[] rawPathQuery = getRawPathQuery();
        if (rawPathQuery == null) {
            return null;
        }
        return new String(rawPathQuery);
    }

    public String getEscapedQuery() {
        char[] cArr = this._query;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public String getEscapedURI() {
        char[] cArr = this._uri;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public String getEscapedURIReference() {
        char[] rawURIReference = getRawURIReference();
        if (rawURIReference == null) {
            return null;
        }
        return new String(rawURIReference);
    }

    public String getEscapedUserinfo() {
        char[] cArr = this._userinfo;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public String getFragment() throws URIException {
        char[] cArr = this._fragment;
        if (cArr == null) {
            return null;
        }
        return decode(cArr, getProtocolCharset());
    }

    public String getHost() throws URIException {
        char[] cArr = this._host;
        if (cArr != null) {
            return decode(cArr, getProtocolCharset());
        }
        return null;
    }

    public String getName() throws URIException {
        if (getRawName() == null) {
            return null;
        }
        return decode(getRawName(), getProtocolCharset());
    }

    public String getPath() throws URIException {
        char[] rawPath = getRawPath();
        if (rawPath == null) {
            return null;
        }
        return decode(rawPath, getProtocolCharset());
    }

    public String getPathQuery() throws URIException {
        char[] rawPathQuery = getRawPathQuery();
        if (rawPathQuery == null) {
            return null;
        }
        return decode(rawPathQuery, getProtocolCharset());
    }

    public int getPort() {
        return this._port;
    }

    public String getProtocolCharset() {
        String str = this.protocolCharset;
        return str != null ? str : defaultProtocolCharset;
    }

    public String getQuery() throws URIException {
        char[] cArr = this._query;
        if (cArr == null) {
            return null;
        }
        return decode(cArr, getProtocolCharset());
    }

    public char[] getRawAboveHierPath() throws URIException {
        char[] rawCurrentHierPath = getRawCurrentHierPath();
        if (rawCurrentHierPath == null) {
            return null;
        }
        return getRawCurrentHierPath(rawCurrentHierPath);
    }

    public char[] getRawAuthority() {
        return this._authority;
    }

    public char[] getRawCurrentHierPath() throws URIException {
        char[] cArr = this._path;
        if (cArr == null) {
            return null;
        }
        return getRawCurrentHierPath(cArr);
    }

    public char[] getRawFragment() {
        return this._fragment;
    }

    public char[] getRawHost() {
        return this._host;
    }

    public char[] getRawName() {
        int i2;
        char[] cArr = this._path;
        if (cArr == null) {
            return null;
        }
        int length = cArr.length;
        while (true) {
            length--;
            if (length < 0) {
                i2 = 0;
                break;
            } else if (this._path[length] == '/') {
                i2 = length + 1;
                break;
            }
        }
        char[] cArr2 = this._path;
        int length2 = cArr2.length - i2;
        char[] cArr3 = new char[length2];
        System.arraycopy(cArr2, i2, cArr3, 0, length2);
        return cArr3;
    }

    public char[] getRawPath() {
        return this._is_opaque_part ? this._opaque : this._path;
    }

    public char[] getRawPathQuery() {
        if (this._path == null && this._query == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this._path;
        if (cArr != null) {
            stringBuffer.append(cArr);
        }
        if (this._query != null) {
            stringBuffer.append('?');
            stringBuffer.append(this._query);
        }
        return stringBuffer.toString().toCharArray();
    }

    public char[] getRawQuery() {
        return this._query;
    }

    public char[] getRawScheme() {
        return this._scheme;
    }

    public char[] getRawURI() {
        return this._uri;
    }

    public char[] getRawURIReference() {
        char[] cArr = this._fragment;
        if (cArr == null) {
            return this._uri;
        }
        if (this._uri == null) {
            return cArr;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new String(this._uri));
        stringBuffer.append("#");
        stringBuffer.append(new String(this._fragment));
        return stringBuffer.toString().toCharArray();
    }

    public char[] getRawUserinfo() {
        return this._userinfo;
    }

    public String getScheme() {
        char[] cArr = this._scheme;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public String getURI() throws URIException {
        char[] cArr = this._uri;
        if (cArr == null) {
            return null;
        }
        return decode(cArr, getProtocolCharset());
    }

    public String getURIReference() throws URIException {
        char[] rawURIReference = getRawURIReference();
        if (rawURIReference == null) {
            return null;
        }
        return decode(rawURIReference, getProtocolCharset());
    }

    public String getUserinfo() throws URIException {
        char[] cArr = this._userinfo;
        if (cArr == null) {
            return null;
        }
        return decode(cArr, getProtocolCharset());
    }

    public boolean hasAuthority() {
        return this._authority != null || this._is_net_path;
    }

    public boolean hasFragment() {
        return this._fragment != null;
    }

    public boolean hasQuery() {
        return this._query != null;
    }

    public boolean hasUserinfo() {
        return this._userinfo != null;
    }

    public int hashCode() {
        if (this.hash == 0) {
            char[] cArr = this._uri;
            if (cArr != null) {
                for (char c2 : cArr) {
                    this.hash = (this.hash * 31) + c2;
                }
            }
            char[] cArr2 = this._fragment;
            if (cArr2 != null) {
                for (char c3 : cArr2) {
                    this.hash = (this.hash * 31) + c3;
                }
            }
        }
        return this.hash;
    }

    /* access modifiers changed from: protected */
    public int indexFirstOf(String str, String str2) {
        return indexFirstOf(str, str2, -1);
    }

    public boolean isAbsPath() {
        return this._is_abs_path;
    }

    public boolean isAbsoluteURI() {
        return this._scheme != null;
    }

    public boolean isHierPart() {
        return this._is_hier_part;
    }

    public boolean isHostname() {
        return this._is_hostname;
    }

    public boolean isIPv4address() {
        return this._is_IPv4address;
    }

    public boolean isIPv6reference() {
        return this._is_IPv6reference;
    }

    public boolean isNetPath() {
        return this._is_net_path || this._authority != null;
    }

    public boolean isOpaquePart() {
        return this._is_opaque_part;
    }

    public boolean isRegName() {
        return this._is_reg_name;
    }

    public boolean isRelPath() {
        return this._is_rel_path;
    }

    public boolean isRelativeURI() {
        return this._scheme == null;
    }

    public boolean isServer() {
        return this._is_server;
    }

    public void normalize() throws URIException {
        if (isAbsPath()) {
            this._path = normalize(this._path);
            setURI();
        }
    }

    /* access modifiers changed from: protected */
    public void parseAuthority(String str, boolean z) throws URIException {
        int i2;
        boolean z2;
        int i3;
        this._is_IPv6reference = false;
        this._is_IPv4address = false;
        this._is_hostname = false;
        this._is_server = false;
        this._is_reg_name = false;
        String protocolCharset2 = getProtocolCharset();
        int indexOf = str.indexOf(64);
        if (indexOf != -1) {
            String substring = str.substring(0, indexOf);
            this._userinfo = z ? substring.toCharArray() : encode(substring, allowed_userinfo, protocolCharset2);
            i2 = indexOf + 1;
        } else {
            i2 = 0;
        }
        if (str.indexOf(91, i2) >= i2) {
            int indexOf2 = str.indexOf(93, i2);
            if (indexOf2 != -1) {
                i3 = indexOf2 + 1;
                String substring2 = str.substring(i2, i3);
                this._host = z ? substring2.toCharArray() : encode(substring2, allowed_IPv6reference, protocolCharset2);
                this._is_IPv6reference = true;
                z2 = true;
            } else {
                throw new URIException(1, "IPv6reference");
            }
        } else {
            i3 = str.indexOf(58, i2);
            if (i3 == -1) {
                i3 = str.length();
                z2 = false;
            } else {
                z2 = true;
            }
            char[] charArray = str.substring(i2, i3).toCharArray();
            this._host = charArray;
            if (validate(charArray, IPv4address)) {
                this._is_IPv4address = true;
            } else if (validate(this._host, hostname)) {
                this._is_hostname = true;
            } else {
                this._is_reg_name = true;
            }
        }
        if (this._is_reg_name) {
            this._is_IPv6reference = false;
            this._is_IPv4address = false;
            this._is_hostname = false;
            this._is_server = false;
            if (z) {
                char[] charArray2 = str.toCharArray();
                this._authority = charArray2;
                if (!validate(charArray2, reg_name)) {
                    throw new URIException("Invalid authority");
                }
                return;
            }
            this._authority = encode(str, allowed_reg_name, protocolCharset2);
            return;
        }
        if (str.length() - 1 > i3 && z2 && str.charAt(i3) == ':') {
            try {
                this._port = Integer.parseInt(str.substring(i3 + 1));
            } catch (NumberFormatException unused) {
                throw new URIException(1, "invalid port number");
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this._userinfo;
        if (cArr != null) {
            stringBuffer.append(cArr);
            stringBuffer.append('@');
        }
        char[] cArr2 = this._host;
        if (cArr2 != null) {
            stringBuffer.append(cArr2);
            if (this._port != -1) {
                stringBuffer.append(ASCIIPropertyListParser.A);
                stringBuffer.append(this._port);
            }
        }
        this._authority = stringBuffer.toString().toCharArray();
        this._is_server = true;
    }

    /* access modifiers changed from: protected */
    public void parseUriReference(String str, boolean z) throws URIException {
        int i2;
        int i3;
        int i4;
        if (str != null) {
            String trim = str.trim();
            int length = trim.length();
            if (length > 0) {
                char[] cArr = {trim.charAt(0)};
                BitSet bitSet = delims;
                if (validate(cArr, bitSet) && length >= 2) {
                    int i5 = length - 1;
                    if (validate(new char[]{trim.charAt(i5)}, bitSet)) {
                        trim = trim.substring(1, i5);
                        length -= 2;
                    }
                }
            }
            int indexOf = trim.indexOf(58);
            int indexOf2 = trim.indexOf(47);
            boolean z2 = (indexOf <= 0 && !trim.startsWith("//")) || (indexOf2 >= 0 && indexOf2 < indexOf);
            int indexFirstOf = indexFirstOf(trim, z2 ? "/?#" : ":/?#", 0);
            if (indexFirstOf == -1) {
                indexFirstOf = 0;
            }
            if (indexFirstOf <= 0 || indexFirstOf >= length || trim.charAt(indexFirstOf) != ':') {
                i2 = 0;
            } else {
                char[] charArray = trim.substring(0, indexFirstOf).toLowerCase().toCharArray();
                if (validate(charArray, scheme)) {
                    this._scheme = charArray;
                    indexFirstOf++;
                    i2 = indexFirstOf;
                } else {
                    throw new URIException("incorrect scheme");
                }
            }
            this._is_hier_part = false;
            this._is_rel_path = false;
            this._is_abs_path = false;
            this._is_net_path = false;
            if (indexFirstOf >= 0 && indexFirstOf < length && trim.charAt(indexFirstOf) == '/') {
                this._is_hier_part = true;
                int i6 = 2 + indexFirstOf;
                if (i6 < length && trim.charAt(indexFirstOf + 1) == '/' && !z2) {
                    int indexFirstOf2 = indexFirstOf(trim, "/?#", i6);
                    if (indexFirstOf2 == -1) {
                        indexFirstOf2 = trim.substring(i6).length() == 0 ? i6 : trim.length();
                    }
                    indexFirstOf = indexFirstOf2;
                    parseAuthority(trim.substring(i6, indexFirstOf), z);
                    this._is_net_path = true;
                    i2 = indexFirstOf;
                }
                if (i2 == indexFirstOf) {
                    this._is_abs_path = true;
                }
            }
            if (i2 < length) {
                int indexFirstOf3 = indexFirstOf(trim, "?#", i2);
                if (indexFirstOf3 == -1) {
                    indexFirstOf3 = trim.length();
                }
                indexFirstOf = indexFirstOf3;
                if (!this._is_abs_path) {
                    if ((!z && prevalidate(trim.substring(i2, indexFirstOf), disallowed_rel_path)) || (z && validate(trim.substring(i2, indexFirstOf).toCharArray(), rel_path))) {
                        this._is_rel_path = true;
                    } else if ((z || !prevalidate(trim.substring(i2, indexFirstOf), disallowed_opaque_part)) && (!z || !validate(trim.substring(i2, indexFirstOf).toCharArray(), opaque_part))) {
                        this._path = null;
                    } else {
                        this._is_opaque_part = true;
                    }
                }
                String substring = trim.substring(i2, indexFirstOf);
                if (z) {
                    setRawPath(substring.toCharArray());
                } else {
                    setPath(substring);
                }
            }
            String protocolCharset2 = getProtocolCharset();
            if (indexFirstOf >= 0 && (i4 = indexFirstOf + 1) < length && trim.charAt(indexFirstOf) == '?') {
                int indexOf3 = trim.indexOf(35, i4);
                if (indexOf3 == -1) {
                    indexOf3 = trim.length();
                }
                indexFirstOf = indexOf3;
                String substring2 = trim.substring(i4, indexFirstOf);
                if (z) {
                    char[] charArray2 = substring2.toCharArray();
                    this._query = charArray2;
                    if (!validate(charArray2, uric)) {
                        throw new URIException("Invalid query");
                    }
                } else {
                    this._query = encode(substring2, allowed_query, protocolCharset2);
                }
            }
            if (indexFirstOf >= 0 && (i3 = 1 + indexFirstOf) <= length && trim.charAt(indexFirstOf) == '#') {
                if (i3 == length) {
                    this._fragment = "".toCharArray();
                } else {
                    String substring3 = trim.substring(i3);
                    this._fragment = z ? substring3.toCharArray() : encode(substring3, allowed_fragment, protocolCharset2);
                }
            }
            setURI();
            return;
        }
        throw new URIException("URI-Reference required");
    }

    /* access modifiers changed from: protected */
    public boolean prevalidate(String str, BitSet bitSet) {
        if (str == null) {
            return false;
        }
        char[] charArray = str.toCharArray();
        for (char c2 : charArray) {
            if (bitSet.get(c2)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public char[] removeFragmentIdentifier(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        int indexOf = new String(cArr).indexOf(35);
        return indexOf != -1 ? new String(cArr).substring(0, indexOf).toCharArray() : cArr;
    }

    /* access modifiers changed from: protected */
    public char[] resolvePath(char[] cArr, char[] cArr2) throws URIException {
        String str = cArr == null ? "" : new String(cArr);
        if (cArr2 == null || cArr2.length == 0) {
            return normalize(cArr);
        }
        if (cArr2[0] == '/') {
            return normalize(cArr2);
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf != -1) {
            str.substring(0, lastIndexOf + 1).toCharArray();
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + cArr2.length);
        stringBuffer.append(lastIndexOf != -1 ? str.substring(0, lastIndexOf + 1) : "/");
        stringBuffer.append(cArr2);
        return normalize(stringBuffer.toString().toCharArray());
    }

    public void setEscapedAuthority(String str) throws URIException {
        parseAuthority(str, true);
        setURI();
    }

    public void setEscapedFragment(String str) throws URIException {
        if (str == null) {
            this._fragment = null;
            this.hash = 0;
            return;
        }
        setRawFragment(str.toCharArray());
    }

    public void setEscapedPath(String str) throws URIException {
        if (str == null) {
            this._opaque = null;
            this._path = null;
            setURI();
            return;
        }
        setRawPath(str.toCharArray());
    }

    public void setEscapedQuery(String str) throws URIException {
        if (str == null) {
            this._query = null;
            setURI();
            return;
        }
        setRawQuery(str.toCharArray());
    }

    public void setFragment(String str) throws URIException {
        if (str == null || str.length() == 0) {
            this._fragment = str == null ? null : str.toCharArray();
        } else {
            this._fragment = encode(str, allowed_fragment, getProtocolCharset());
        }
        this.hash = 0;
    }

    public void setPath(String str) throws URIException {
        if (str == null || str.length() == 0) {
            char[] charArray = str == null ? null : str.toCharArray();
            this._opaque = charArray;
            this._path = charArray;
            setURI();
            return;
        }
        String protocolCharset2 = getProtocolCharset();
        if (this._is_net_path || this._is_abs_path) {
            this._path = encode(str, allowed_abs_path, protocolCharset2);
        } else if (this._is_rel_path) {
            StringBuffer stringBuffer = new StringBuffer(str.length());
            int indexOf = str.indexOf(47);
            if (indexOf != 0) {
                if (indexOf > 0) {
                    stringBuffer.append(encode(str.substring(0, indexOf), allowed_rel_path, protocolCharset2));
                    stringBuffer.append(encode(str.substring(indexOf), allowed_abs_path, protocolCharset2));
                } else {
                    stringBuffer.append(encode(str, allowed_rel_path, protocolCharset2));
                }
                this._path = stringBuffer.toString().toCharArray();
            } else {
                throw new URIException(1, "incorrect relative path");
            }
        } else if (this._is_opaque_part) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.insert(0, encode(str.substring(0, 1), uric_no_slash, protocolCharset2));
            stringBuffer2.insert(1, encode(str.substring(1), uric, protocolCharset2));
            this._opaque = stringBuffer2.toString().toCharArray();
        } else {
            throw new URIException(1, "incorrect path");
        }
        setURI();
    }

    public void setQuery(String str) throws URIException {
        if (str == null || str.length() == 0) {
            this._query = str == null ? null : str.toCharArray();
            setURI();
            return;
        }
        setRawQuery(encode(str, allowed_query, getProtocolCharset()));
    }

    public void setRawAuthority(char[] cArr) throws URIException, NullPointerException {
        parseAuthority(new String(cArr), true);
        setURI();
    }

    public void setRawFragment(char[] cArr) throws URIException {
        if (cArr == null || cArr.length == 0 || validate(cArr, fragment)) {
            this._fragment = cArr;
            this.hash = 0;
            return;
        }
        throw new URIException(3, "escaped fragment not valid");
    }

    public void setRawPath(char[] cArr) throws URIException {
        if (cArr == null || cArr.length == 0) {
            this._opaque = cArr;
            this._path = cArr;
            setURI();
            return;
        }
        char[] removeFragmentIdentifier = removeFragmentIdentifier(cArr);
        if (this._is_net_path || this._is_abs_path) {
            if (removeFragmentIdentifier[0] != '/') {
                throw new URIException(1, "not absolute path");
            } else if (!validate(removeFragmentIdentifier, abs_path)) {
                throw new URIException(3, "escaped absolute path not valid");
            }
        } else if (this._is_rel_path) {
            int indexFirstOf = indexFirstOf(removeFragmentIdentifier, '/');
            if (indexFirstOf == 0) {
                throw new URIException(1, "incorrect path");
            } else if ((indexFirstOf > 0 && !validate(removeFragmentIdentifier, 0, indexFirstOf - 1, rel_segment) && !validate(removeFragmentIdentifier, indexFirstOf, -1, abs_path)) || (indexFirstOf < 0 && !validate(removeFragmentIdentifier, 0, -1, rel_segment))) {
                throw new URIException(3, "escaped relative path not valid");
            }
        } else if (!this._is_opaque_part) {
            throw new URIException(1, "incorrect path");
        } else if (uric_no_slash.get(removeFragmentIdentifier[0]) || validate(removeFragmentIdentifier, 1, -1, uric)) {
            this._opaque = removeFragmentIdentifier;
            setURI();
        } else {
            throw new URIException(3, "escaped opaque part not valid");
        }
        this._path = removeFragmentIdentifier;
        setURI();
    }

    public void setRawQuery(char[] cArr) throws URIException {
        if (cArr == null || cArr.length == 0) {
            this._query = cArr;
        } else {
            char[] removeFragmentIdentifier = removeFragmentIdentifier(cArr);
            if (validate(removeFragmentIdentifier, query)) {
                this._query = removeFragmentIdentifier;
            } else {
                throw new URIException(3, "escaped query not valid");
            }
        }
        setURI();
    }

    /* access modifiers changed from: protected */
    public void setURI() {
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArr = this._scheme;
        if (cArr != null) {
            stringBuffer.append(cArr);
            stringBuffer.append(ASCIIPropertyListParser.A);
        }
        if (this._is_net_path) {
            stringBuffer.append("//");
            char[] cArr2 = this._authority;
            if (cArr2 != null) {
                stringBuffer.append(cArr2);
            }
        }
        char[] cArr3 = this._opaque;
        if (cArr3 == null || !this._is_opaque_part) {
            char[] cArr4 = this._path;
            if (!(cArr4 == null || cArr4.length == 0)) {
                stringBuffer.append(cArr4);
            }
        } else {
            stringBuffer.append(cArr3);
        }
        if (this._query != null) {
            stringBuffer.append('?');
            stringBuffer.append(this._query);
        }
        this._uri = stringBuffer.toString().toCharArray();
        this.hash = 0;
    }

    public String toString() {
        return getEscapedURI();
    }

    /* access modifiers changed from: protected */
    public boolean validate(char[] cArr, int i2, int i3, BitSet bitSet) {
        if (i3 == -1) {
            i3 = cArr.length - 1;
        }
        while (i2 <= i3) {
            if (!bitSet.get(cArr[i2])) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public URI(String str) throws URIException {
        this.hash = 0;
        this._uri = null;
        this.protocolCharset = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        parseUriReference(str, false);
    }

    protected static String decode(char[] cArr, String str) throws URIException {
        if (cArr != null) {
            return decode(new String(cArr), str);
        }
        throw new IllegalArgumentException("Component array of chars may not be null");
    }

    /* access modifiers changed from: protected */
    public boolean equals(char[] cArr, char[] cArr2) {
        if (cArr == null && cArr2 == null) {
            return true;
        }
        if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (cArr[i2] != cArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public char[] getRawCurrentHierPath(char[] cArr) throws URIException {
        if (this._is_opaque_part) {
            throw new URIException(1, "no hierarchy level");
        } else if (cArr != null) {
            String str = new String(cArr);
            int indexOf = str.indexOf(47);
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf == 0) {
                return rootPath;
            }
            return (indexOf == lastIndexOf || lastIndexOf == -1) ? cArr : str.substring(0, lastIndexOf).toCharArray();
        } else {
            throw new URIException(1, "empty path");
        }
    }

    /* access modifiers changed from: protected */
    public int indexFirstOf(String str, String str2, int i2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > str.length()) {
            return -1;
        }
        int length = str.length();
        char[] charArray = str2.toCharArray();
        for (char indexOf : charArray) {
            int indexOf2 = str.indexOf(indexOf, i2);
            if (indexOf2 >= 0 && indexOf2 < length) {
                length = indexOf2;
            }
        }
        if (length == str.length()) {
            return -1;
        }
        return length;
    }

    /* access modifiers changed from: protected */
    public char[] normalize(char[] cArr) throws URIException {
        int lastIndexOf;
        if (cArr == null) {
            return null;
        }
        String str = new String(cArr);
        if (str.startsWith("./")) {
            str = str.substring(1);
        } else if (str.startsWith("../") || str.startsWith("..")) {
            str = str.substring(2);
        }
        while (true) {
            int indexOf = str.indexOf("/./");
            if (indexOf == -1) {
                break;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, indexOf));
            stringBuffer.append(str.substring(indexOf + 2));
            str = stringBuffer.toString();
        }
        if (str.endsWith("/.")) {
            str = str.substring(0, str.length() - 1);
        }
        int i2 = 0;
        while (true) {
            int indexOf2 = str.indexOf("/../", i2);
            if (indexOf2 == -1) {
                break;
            }
            int lastIndexOf2 = str.lastIndexOf(47, indexOf2 - 1);
            if (lastIndexOf2 >= 0) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(str.substring(0, lastIndexOf2));
                stringBuffer2.append(str.substring(indexOf2 + 3));
                str = stringBuffer2.toString();
            } else {
                i2 = indexOf2 + 3;
            }
        }
        if (str.endsWith("/..") && (lastIndexOf = str.lastIndexOf(47, str.length() - 4)) >= 0) {
            str = str.substring(0, lastIndexOf + 1);
        }
        while (true) {
            int indexOf3 = str.indexOf("/../");
            if (indexOf3 != -1 && str.lastIndexOf(47, indexOf3 - 1) < 0) {
                str = str.substring(indexOf3 + 3);
            }
        }
        if (str.endsWith("/..") && str.lastIndexOf(47, str.length() - 4) < 0) {
            str = "/";
        }
        return str.toCharArray();
    }

    /* access modifiers changed from: protected */
    public boolean validate(char[] cArr, BitSet bitSet) {
        return validate(cArr, 0, -1, bitSet);
    }

    public URI(String str, String str2) throws URIException {
        this.hash = 0;
        this._uri = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        this.protocolCharset = str2;
        parseUriReference(str, false);
    }

    /* access modifiers changed from: protected */
    public int indexFirstOf(char[] cArr, char c2) {
        return indexFirstOf(cArr, c2, 0);
    }

    public URI(String str, String str2, String str3) throws URIException {
        this.hash = 0;
        char[] cArr = null;
        this._uri = null;
        this.protocolCharset = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        if (str != null) {
            char[] charArray = str.toLowerCase().toCharArray();
            if (validate(charArray, scheme)) {
                this._scheme = charArray;
                this._opaque = encode(str2, allowed_opaque_part, getProtocolCharset());
                this._is_opaque_part = true;
                this._fragment = str3 != null ? str3.toCharArray() : cArr;
                setURI();
                return;
            }
            throw new URIException(1, "incorrect scheme");
        }
        throw new URIException(1, "scheme required");
    }

    /* access modifiers changed from: protected */
    public int indexFirstOf(char[] cArr, char c2, int i2) {
        if (!(cArr == null || cArr.length == 0)) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 > cArr.length) {
                return -1;
            }
            while (i2 < cArr.length) {
                if (cArr[i2] == c2) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public URI(String str, String str2, String str3, int i2) throws URIException {
        this(str, str2, str3, i2, (String) null, (String) null, (String) null);
    }

    public URI(String str, String str2, String str3, int i2, String str4) throws URIException {
        this(str, str2, str3, i2, str4, (String) null, (String) null);
    }

    public URI(String str, String str2, String str3, int i2, String str4, String str5) throws URIException {
        this(str, str2, str3, i2, str4, str5, (String) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public URI(java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, java.lang.String r11, java.lang.String r12, java.lang.String r13) throws org.apache.commons.httpclient.URIException {
        /*
            r6 = this;
            if (r9 != 0) goto L_0x0005
            r8 = 0
        L_0x0003:
            r2 = r8
            goto L_0x0043
        L_0x0005:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = ""
            if (r8 == 0) goto L_0x0020
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r2.append(r8)
            r8 = 64
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            goto L_0x0021
        L_0x0020:
            r8 = r1
        L_0x0021:
            r0.append(r8)
            r0.append(r9)
            r8 = -1
            if (r10 == r8) goto L_0x003b
            java.lang.StringBuffer r8 = new java.lang.StringBuffer
            r8.<init>()
            java.lang.String r9 = ":"
            r8.append(r9)
            r8.append(r10)
            java.lang.String r1 = r8.toString()
        L_0x003b:
            r0.append(r1)
            java.lang.String r8 = r0.toString()
            goto L_0x0003
        L_0x0043:
            r0 = r6
            r1 = r7
            r3 = r11
            r4 = r12
            r5 = r13
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.httpclient.URI.<init>(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public URI(String str, String str2, String str3, String str4) throws URIException {
        this(str, str2, str3, (String) null, str4);
    }

    public URI(String str, String str2, String str3, String str4, String str5) throws URIException {
        this.hash = 0;
        this._uri = null;
        this.protocolCharset = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
            stringBuffer.append(ASCIIPropertyListParser.A);
        }
        if (str2 != null) {
            stringBuffer.append("//");
            stringBuffer.append(str2);
        }
        if (str3 != null) {
            if (!(str == null && str2 == null) && !str3.startsWith("/")) {
                throw new URIException(1, "abs_path requested");
            }
            stringBuffer.append(str3);
        }
        if (str4 != null) {
            stringBuffer.append('?');
            stringBuffer.append(str4);
        }
        if (str5 != null) {
            stringBuffer.append('#');
            stringBuffer.append(str5);
        }
        parseUriReference(stringBuffer.toString(), false);
    }

    public URI(String str, boolean z) throws URIException, NullPointerException {
        this.hash = 0;
        this._uri = null;
        this.protocolCharset = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        parseUriReference(str, z);
    }

    public URI(String str, boolean z, String str2) throws URIException, NullPointerException {
        this.hash = 0;
        this._uri = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        this.protocolCharset = str2;
        parseUriReference(str, z);
    }

    public URI(URI uri, String str) throws URIException {
        this(uri, new URI(str));
    }

    public URI(URI uri, String str, boolean z) throws URIException {
        this(uri, new URI(str, z));
    }

    public URI(URI uri, URI uri2) throws URIException {
        boolean z = false;
        this.hash = 0;
        this._uri = null;
        this.protocolCharset = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        char[] cArr = uri._scheme;
        if (cArr != null) {
            if (cArr != null) {
                this._scheme = cArr;
                this._authority = uri._authority;
                this._is_net_path = uri._is_net_path;
            }
            boolean z2 = uri._is_opaque_part;
            if (z2 || uri2._is_opaque_part) {
                this._scheme = uri._scheme;
                this._is_opaque_part = (z2 || uri2._is_opaque_part) ? true : z;
                this._opaque = uri2._opaque;
                this._fragment = uri2._fragment;
                setURI();
                return;
            }
            boolean equals = Arrays.equals(uri._scheme, uri2._scheme);
            char[] cArr2 = uri2._scheme;
            if (cArr2 == null || (equals && uri2._authority == null)) {
                char[] cArr3 = uri._authority;
                if (cArr3 != null && cArr2 == null) {
                    this._is_net_path = uri._is_net_path;
                    this._authority = cArr3;
                    boolean z3 = uri._is_server;
                    if (z3) {
                        this._is_server = z3;
                        this._userinfo = uri._userinfo;
                        this._host = uri._host;
                        this._port = uri._port;
                    } else {
                        boolean z4 = uri._is_reg_name;
                        if (z4) {
                            this._is_reg_name = z4;
                        }
                    }
                }
            } else {
                this._scheme = cArr2;
                this._is_net_path = uri2._is_net_path;
                this._authority = uri2._authority;
                boolean z5 = uri2._is_server;
                if (z5) {
                    this._is_server = z5;
                    this._userinfo = uri2._userinfo;
                    this._host = uri2._host;
                    this._port = uri2._port;
                } else {
                    boolean z6 = uri2._is_reg_name;
                    if (z6) {
                        this._is_reg_name = z6;
                    }
                }
                this._is_abs_path = uri2._is_abs_path;
                this._is_rel_path = uri2._is_rel_path;
                this._path = uri2._path;
            }
            char[] cArr4 = uri2._authority;
            if (cArr4 != null) {
                this._is_net_path = uri2._is_net_path;
                this._authority = cArr4;
                boolean z7 = uri2._is_server;
                if (z7) {
                    this._is_server = z7;
                    this._userinfo = uri2._userinfo;
                    this._host = uri2._host;
                    this._port = uri2._port;
                } else {
                    boolean z8 = uri2._is_reg_name;
                    if (z8) {
                        this._is_reg_name = z8;
                    }
                }
                this._is_abs_path = uri2._is_abs_path;
                this._is_rel_path = uri2._is_rel_path;
                this._path = uri2._path;
            }
            if (uri2._authority == null && (uri2._scheme == null || equals)) {
                char[] cArr5 = uri2._path;
                if ((cArr5 == null || cArr5.length == 0) && uri2._query == null) {
                    this._path = uri._path;
                    this._query = uri._query;
                } else {
                    this._path = resolvePath(uri._path, cArr5);
                }
            }
            char[] cArr6 = uri2._query;
            if (cArr6 != null) {
                this._query = cArr6;
            }
            char[] cArr7 = uri2._fragment;
            if (cArr7 != null) {
                this._fragment = cArr7;
            }
            setURI();
            parseUriReference(new String(this._uri), true);
            return;
        }
        throw new URIException(1, "base URI required");
    }

    public URI(char[] cArr) throws URIException, NullPointerException {
        this.hash = 0;
        this._uri = null;
        this.protocolCharset = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        parseUriReference(new String(cArr), true);
    }

    public URI(char[] cArr, String str) throws URIException, NullPointerException {
        this.hash = 0;
        this._uri = null;
        this._scheme = null;
        this._opaque = null;
        this._authority = null;
        this._userinfo = null;
        this._host = null;
        this._port = -1;
        this._path = null;
        this._query = null;
        this._fragment = null;
        this.protocolCharset = str;
        parseUriReference(new String(cArr), true);
    }
}
