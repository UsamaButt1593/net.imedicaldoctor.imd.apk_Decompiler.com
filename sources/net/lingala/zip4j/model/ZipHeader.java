package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;

public abstract class ZipHeader {

    /* renamed from: a  reason: collision with root package name */
    private HeaderSignature f30638a;

    public HeaderSignature a() {
        return this.f30638a;
    }

    public void b(HeaderSignature headerSignature) {
        this.f30638a = headerSignature;
    }
}
