package com.itextpdf.text.pdf.fonts.cmaps;

import java.io.IOException;
import java.util.HashMap;

public class CMapCache {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, CMapUniCid> f26804a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, CMapCidUni> f26805b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, CMapCidByte> f26806c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, CMapByteCid> f26807d = new HashMap<>();

    public static CMapByteCid a(String str) throws IOException {
        CMapByteCid cMapByteCid;
        HashMap<String, CMapByteCid> hashMap = f26807d;
        synchronized (hashMap) {
            cMapByteCid = hashMap.get(str);
        }
        if (cMapByteCid == null) {
            cMapByteCid = new CMapByteCid();
            CMapParserEx.b(str, cMapByteCid, new CidResource());
            synchronized (hashMap) {
                hashMap.put(str, cMapByteCid);
            }
        }
        return cMapByteCid;
    }

    public static CMapCidByte b(String str) throws IOException {
        CMapCidByte cMapCidByte;
        HashMap<String, CMapCidByte> hashMap = f26806c;
        synchronized (hashMap) {
            cMapCidByte = hashMap.get(str);
        }
        if (cMapCidByte == null) {
            cMapCidByte = new CMapCidByte();
            CMapParserEx.b(str, cMapCidByte, new CidResource());
            synchronized (hashMap) {
                hashMap.put(str, cMapCidByte);
            }
        }
        return cMapCidByte;
    }

    public static CMapCidUni c(String str) throws IOException {
        CMapCidUni cMapCidUni;
        HashMap<String, CMapCidUni> hashMap = f26805b;
        synchronized (hashMap) {
            cMapCidUni = hashMap.get(str);
        }
        if (cMapCidUni == null) {
            cMapCidUni = new CMapCidUni();
            CMapParserEx.b(str, cMapCidUni, new CidResource());
            synchronized (hashMap) {
                hashMap.put(str, cMapCidUni);
            }
        }
        return cMapCidUni;
    }

    public static CMapUniCid d(String str) throws IOException {
        CMapUniCid cMapUniCid;
        HashMap<String, CMapUniCid> hashMap = f26804a;
        synchronized (hashMap) {
            cMapUniCid = hashMap.get(str);
        }
        if (cMapUniCid == null) {
            cMapUniCid = new CMapUniCid();
            CMapParserEx.b(str, cMapUniCid, new CidResource());
            synchronized (hashMap) {
                hashMap.put(str, cMapUniCid);
            }
        }
        return cMapUniCid;
    }
}
