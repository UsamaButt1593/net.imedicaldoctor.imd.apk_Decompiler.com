package net.lingala.zip4j.model;

import java.util.ArrayList;
import java.util.List;

public class CentralDirectory {

    /* renamed from: a  reason: collision with root package name */
    private List<FileHeader> f30602a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private DigitalSignature f30603b = new DigitalSignature();

    public DigitalSignature a() {
        return this.f30603b;
    }

    public List<FileHeader> b() {
        return this.f30602a;
    }

    public void c(DigitalSignature digitalSignature) {
        this.f30603b = digitalSignature;
    }

    public void d(List<FileHeader> list) {
        this.f30602a = list;
    }
}
