package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.XmlSignatureAppearance;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.xml.crypto.dom.DOMStructure;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.XMLObject;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.DigestMethodParameterSpec;
import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.crypto.dsig.spec.XPathFilter2ParameterSpec;
import javax.xml.crypto.dsig.spec.XPathType;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.jcp.xml.dsig.internal.dom.DOMKeyInfoFactory;
import org.apache.jcp.xml.dsig.internal.dom.DOMReference;
import org.apache.jcp.xml.dsig.internal.dom.DOMSignedInfo;
import org.apache.jcp.xml.dsig.internal.dom.DOMUtils;
import org.apache.jcp.xml.dsig.internal.dom.DOMXMLSignature;
import org.apache.jcp.xml.dsig.internal.dom.XMLDSigRI;
import org.apache.xml.security.utils.Base64;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MakeXmlSignature {

    private static class EmptyKey implements Key {
        private static EmptyKey s = new EmptyKey();

        private EmptyKey() {
        }

        public static EmptyKey a() {
            return s;
        }

        public String getAlgorithm() {
            return null;
        }

        public byte[] getEncoded() {
            return new byte[0];
        }

        public String getFormat() {
            return null;
        }
    }

    private static XMLSignatureFactory a() {
        return XMLSignatureFactory.getInstance("DOM", new XMLDSigRI());
    }

    private static Element b(NodeList nodeList, String str) {
        for (int length = nodeList.getLength() - 1; length >= 0; length--) {
            Node item = nodeList.item(length);
            if (item.getNodeType() == 1 && item.getLocalName().equals(str)) {
                return (Element) item;
            }
        }
        return null;
    }

    private static Reference c(XMLSignatureFactory xMLSignatureFactory, XmlSignatureAppearance xmlSignatureAppearance, String str) throws GeneralSecurityException {
        DigestMethod newDigestMethod = xMLSignatureFactory.newDigestMethod(SecurityConstants.f27338k, (DigestMethodParameterSpec) null);
        ArrayList arrayList = new ArrayList();
        TransformParameterSpec transformParameterSpec = null;
        arrayList.add(xMLSignatureFactory.newTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature", (TransformParameterSpec) null));
        XpathConstructor i2 = xmlSignatureAppearance.i();
        if (i2 != null && i2.a().length() > 0) {
            arrayList.add(xMLSignatureFactory.newTransform("http://www.w3.org/2002/06/xmldsig-filter2", new XPathFilter2ParameterSpec(Collections.singletonList(new XPathType(i2.a(), XPathType.Filter.INTERSECT)))));
        }
        return xMLSignatureFactory.newReference("", newDigestMethod, arrayList, (String) null, str);
    }

    private static Reference d(XMLSignatureFactory xMLSignatureFactory, String str, String str2, String str3) throws GeneralSecurityException {
        return xMLSignatureFactory.newReference(str, xMLSignatureFactory.newDigestMethod(SecurityConstants.f27338k, (DigestMethodParameterSpec) null), (List) null, str2, str3);
    }

    private static KeyInfo e(PublicKey publicKey) throws GeneralSecurityException {
        DOMKeyInfoFactory dOMKeyInfoFactory = new DOMKeyInfoFactory();
        return dOMKeyInfoFactory.newKeyInfo(Collections.singletonList(dOMKeyInfoFactory.newKeyValue(publicKey)));
    }

    private static KeyInfo f(Certificate[] certificateArr, XmlSignatureAppearance xmlSignatureAppearance) {
        Certificate certificate = certificateArr[0];
        xmlSignatureAppearance.j(certificate);
        DOMKeyInfoFactory dOMKeyInfoFactory = new DOMKeyInfoFactory();
        return dOMKeyInfoFactory.newKeyInfo(Collections.singletonList(dOMKeyInfoFactory.newX509Data(Collections.singletonList(certificate))));
    }

    private static XMLObject g(XMLSignatureFactory xMLSignatureFactory, XmlSignatureAppearance xmlSignatureAppearance, String str, String str2, String str3, String[] strArr) throws GeneralSecurityException {
        Element element;
        MessageDigest instance = MessageDigest.getInstance(SecurityConstants.o);
        Certificate b2 = xmlSignatureAppearance.b();
        Document c2 = xmlSignatureAppearance.h().c();
        Element createElementNS = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.M);
        createElementNS.setAttribute(SecurityConstants.y, "#" + str);
        Element createElementNS2 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.L);
        createElementNS2.setAttribute(SecurityConstants.w, str3);
        createElementNS2.setIdAttribute(SecurityConstants.w, true);
        Element createElementNS3 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.K);
        Element createElementNS4 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.J);
        String format = new SimpleDateFormat(SecurityConstants.V).format(xmlSignatureAppearance.e().getTime());
        createElementNS4.appendChild(c2.createTextNode(format.substring(0, format.length() - 2).concat(":").concat(format.substring(format.length() - 2))));
        createElementNS3.appendChild(createElementNS4);
        Element createElementNS5 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.I);
        Element createElementNS6 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.H);
        Element createElementNS7 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.G);
        Element createElementNS8 = c2.createElementNS(SecurityConstants.f27336i, SecurityConstants.p);
        createElementNS8.setAttribute(SecurityConstants.v, SecurityConstants.f27338k);
        createElementNS7.appendChild(createElementNS8);
        Element element2 = createElementNS;
        Element createElementNS9 = c2.createElementNS(SecurityConstants.f27336i, SecurityConstants.q);
        String str4 = "#";
        createElementNS9.appendChild(c2.createTextNode(Base64.encode(instance.digest(b2.getEncoded()))));
        createElementNS7.appendChild(createElementNS9);
        createElementNS6.appendChild(createElementNS7);
        if (b2 instanceof X509Certificate) {
            Element createElementNS10 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.F);
            Element createElementNS11 = c2.createElementNS(SecurityConstants.f27336i, SecurityConstants.u);
            X509Certificate x509Certificate = (X509Certificate) b2;
            createElementNS11.appendChild(c2.createTextNode(j(x509Certificate)));
            createElementNS10.appendChild(createElementNS11);
            Element createElementNS12 = c2.createElementNS(SecurityConstants.f27336i, SecurityConstants.t);
            createElementNS12.appendChild(c2.createTextNode(k(x509Certificate)));
            createElementNS10.appendChild(createElementNS12);
            createElementNS6.appendChild(createElementNS10);
        }
        createElementNS5.appendChild(createElementNS6);
        createElementNS3.appendChild(createElementNS5);
        if (strArr != null) {
            Element createElementNS13 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.N);
            Element createElementNS14 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.O);
            Element createElementNS15 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.P);
            Element createElementNS16 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.Q);
            createElementNS16.appendChild(c2.createTextNode(strArr[0]));
            Element element3 = createElementNS2;
            createElementNS16.setAttribute(SecurityConstants.z, SecurityConstants.f27330c);
            createElementNS15.appendChild(createElementNS16);
            Element createElementNS17 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.C);
            createElementNS17.appendChild(c2.createTextNode(strArr[1]));
            createElementNS15.appendChild(createElementNS17);
            createElementNS14.appendChild(createElementNS15);
            Element createElementNS18 = c2.createElementNS(SecurityConstants.f27337j, SecurityConstants.R);
            Element createElementNS19 = c2.createElementNS(SecurityConstants.f27336i, SecurityConstants.p);
            createElementNS19.setAttribute(SecurityConstants.v, SecurityConstants.f27338k);
            createElementNS18.appendChild(createElementNS19);
            Element createElementNS20 = c2.createElementNS(SecurityConstants.f27336i, SecurityConstants.q);
            createElementNS20.appendChild(c2.createTextNode(Base64.encode(instance.digest(h(createElementNS15)))));
            createElementNS18.appendChild(createElementNS20);
            createElementNS14.appendChild(createElementNS18);
            createElementNS13.appendChild(createElementNS14);
            createElementNS3.appendChild(createElementNS13);
            element = element3;
        } else {
            element = createElementNS2;
        }
        element.appendChild(createElementNS3);
        Element createElement = c2.createElement(SecurityConstants.E);
        Element createElement2 = c2.createElement(SecurityConstants.D);
        createElement2.setAttribute(SecurityConstants.x, str4 + str2);
        String c3 = xmlSignatureAppearance.c();
        if (c3 != null) {
            Element createElement3 = c2.createElement(SecurityConstants.C);
            createElement3.appendChild(c2.createTextNode(c3));
            createElement2.appendChild(createElement3);
        }
        Element createElement4 = c2.createElement(SecurityConstants.B);
        createElement4.appendChild(c2.createTextNode(xmlSignatureAppearance.d()));
        createElement2.appendChild(createElement4);
        String b3 = xmlSignatureAppearance.h().b();
        if (b3 != null) {
            Element createElement5 = c2.createElement(SecurityConstants.A);
            createElement5.appendChild(c2.createTextNode(b3));
            createElement2.appendChild(createElement5);
        }
        createElement.appendChild(createElement2);
        element.appendChild(createElement);
        Element element4 = element2;
        element4.appendChild(element);
        return xMLSignatureFactory.newXMLObject(Collections.singletonList(new DOMStructure(element4)), (String) null, (String) null, (String) null);
    }

    private static byte[] h(Node node) {
        try {
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty(XMLWriter.B, "yes");
            newTransformer.transform(new DOMSource(node), streamResult);
            return streamResult.getWriter().toString().getBytes();
        } catch (Exception unused) {
            return new ByteArrayOutputStream().toByteArray();
        }
    }

    private static String i() {
        return UUID.randomUUID().toString().substring(24);
    }

    private static String j(X509Certificate x509Certificate) {
        return x509Certificate.getIssuerX500Principal().toString();
    }

    private static String k(X509Certificate x509Certificate) {
        return x509Certificate.getSerialNumber().toString();
    }

    private static void l(XMLSignatureFactory xMLSignatureFactory, ExternalSignature externalSignature, XmlLocator xmlLocator, DOMSignedInfo dOMSignedInfo, XMLObject xMLObject, KeyInfo keyInfo, String str) throws DocumentException {
        Document c2 = xmlLocator.c();
        DOMSignContext dOMSignContext = new DOMSignContext(EmptyKey.a(), c2.getDocumentElement());
        DOMXMLSignature newXMLSignature = xMLSignatureFactory.newXMLSignature(dOMSignedInfo, keyInfo, xMLObject != null ? Collections.singletonList(xMLObject) : null, str, (String) null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            newXMLSignature.marshal(dOMSignContext.getParent(), dOMSignContext.getNextSibling(), DOMUtils.getSignaturePrefix(dOMSignContext), dOMSignContext);
            Element b2 = b(c2.getDocumentElement().getChildNodes(), SecurityConstants.r);
            if (str != null) {
                b2.setAttributeNS(SecurityConstants.f27335h, SecurityConstants.f27329b, SecurityConstants.f27337j);
            }
            List references = dOMSignedInfo.getReferences();
            for (int i2 = 0; i2 < references.size(); i2++) {
                ((DOMReference) references.get(i2)).digest(dOMSignContext);
            }
            dOMSignedInfo.canonicalize(dOMSignContext, byteArrayOutputStream);
            b(b2.getChildNodes(), SecurityConstants.s).appendChild(c2.createTextNode(Base64.encode(externalSignature.c(byteArrayOutputStream.toByteArray()))));
            xmlLocator.a(c2);
        } catch (Exception e2) {
            throw new DocumentException(e2);
        }
    }

    public static void m(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, Certificate[] certificateArr, boolean z) throws GeneralSecurityException, DocumentException, IOException {
        String[] strArr;
        XmlSignatureAppearance xmlSignatureAppearance2 = xmlSignatureAppearance;
        s(xmlSignatureAppearance, externalSignature);
        String str = externalSignature.a().equals(SecurityConstants.f27341n) ? "http://www.w3.org/2000/09/xmldsig#rsa-sha1" : externalSignature.a().equals(SecurityConstants.f27340m) ? "http://www.w3.org/2000/09/xmldsig#dsa-sha1" : null;
        String str2 = SecurityConstants.S + i();
        String str3 = SecurityConstants.T + i();
        String str4 = SecurityConstants.U + i();
        XMLSignatureFactory a2 = a();
        KeyInfo f2 = f(certificateArr, xmlSignatureAppearance2);
        if (z) {
            String[] strArr2 = new String[2];
            if (str.equals("http://www.w3.org/2000/09/xmldsig#rsa-sha1")) {
                strArr2[0] = SecurityConstants.f27333f;
                strArr2[1] = SecurityConstants.f27334g;
            } else {
                strArr2[0] = SecurityConstants.f27331d;
                strArr2[1] = SecurityConstants.f27332e;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        C14NMethodParameterSpec c14NMethodParameterSpec = null;
        l(a2, externalSignature, xmlSignatureAppearance.h(), a2.newSignedInfo(a2.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec) null), a2.newSignatureMethod(str, (SignatureMethodParameterSpec) null), Arrays.asList(new Reference[]{d(a2, "#" + str3, SecurityConstants.f27339l, (String) null), c(a2, xmlSignatureAppearance2, str2)}), (String) null), g(a2, xmlSignatureAppearance, str4, str2, str3, strArr), f2, str4);
        xmlSignatureAppearance.a();
    }

    public static void n(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, Certificate[] certificateArr) throws GeneralSecurityException, DocumentException, IOException {
        m(xmlSignatureAppearance, externalSignature, certificateArr, false);
    }

    public static void o(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, Certificate[] certificateArr) throws GeneralSecurityException, DocumentException, IOException {
        m(xmlSignatureAppearance, externalSignature, certificateArr, true);
    }

    public static void p(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, PublicKey publicKey) throws GeneralSecurityException, DocumentException, IOException {
        q(xmlSignatureAppearance, externalSignature, e(publicKey));
    }

    public static void q(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, KeyInfo keyInfo) throws GeneralSecurityException, IOException, DocumentException {
        s(xmlSignatureAppearance, externalSignature);
        XMLSignatureFactory a2 = a();
        C14NMethodParameterSpec c14NMethodParameterSpec = null;
        l(a2, externalSignature, xmlSignatureAppearance.h(), a2.newSignedInfo(a2.newCanonicalizationMethod("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (C14NMethodParameterSpec) null), a2.newSignatureMethod(externalSignature.a().equals(SecurityConstants.f27341n) ? "http://www.w3.org/2000/09/xmldsig#rsa-sha1" : externalSignature.a().equals(SecurityConstants.f27340m) ? "http://www.w3.org/2000/09/xmldsig#dsa-sha1" : null, (SignatureMethodParameterSpec) null), Collections.singletonList(c(a2, xmlSignatureAppearance, (String) null))), (XMLObject) null, keyInfo, (String) null);
        xmlSignatureAppearance.a();
    }

    public static void r(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature, Certificate[] certificateArr) throws DocumentException, GeneralSecurityException, IOException {
        q(xmlSignatureAppearance, externalSignature, f(certificateArr, xmlSignatureAppearance));
    }

    private static void s(XmlSignatureAppearance xmlSignatureAppearance, ExternalSignature externalSignature) throws DocumentException {
        if (xmlSignatureAppearance.h() == null) {
            throw new DocumentException(MessageLocalization.b("xmllocator.cannot.be.null", new Object[0]));
        } else if (!externalSignature.b().equals(SecurityConstants.o)) {
            throw new UnsupportedOperationException(MessageLocalization.b("support.only.sha1.hash.algorithm", new Object[0]));
        } else if (!externalSignature.a().equals(SecurityConstants.f27341n) && !externalSignature.a().equals(SecurityConstants.f27340m)) {
            throw new UnsupportedOperationException(MessageLocalization.b("support.only.rsa.and.dsa.algorithms", new Object[0]));
        }
    }
}
