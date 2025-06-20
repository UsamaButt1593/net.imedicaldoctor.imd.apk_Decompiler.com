package net.lingala.zip4j.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ZipModel implements Cloneable {
    private List<DataDescriptor> X = new ArrayList();
    private EndOfCentralDirectoryRecord X2 = new EndOfCentralDirectoryRecord();
    private ArchiveExtraDataRecord Y = new ArchiveExtraDataRecord();
    private Zip64EndOfCentralDirectoryLocator Y2 = new Zip64EndOfCentralDirectoryLocator();
    private CentralDirectory Z = new CentralDirectory();
    private Zip64EndOfCentralDirectoryRecord Z2 = new Zip64EndOfCentralDirectoryRecord();
    private boolean a3;
    private long b3 = -1;
    private File c3;
    private boolean d3 = false;
    private boolean e3;
    private long f3;
    private long g3;
    private List<LocalFileHeader> s = new ArrayList();

    public void A(Zip64EndOfCentralDirectoryLocator zip64EndOfCentralDirectoryLocator) {
        this.Y2 = zip64EndOfCentralDirectoryLocator;
    }

    public void B(Zip64EndOfCentralDirectoryRecord zip64EndOfCentralDirectoryRecord) {
        this.Z2 = zip64EndOfCentralDirectoryRecord;
    }

    public void D(boolean z) {
        this.d3 = z;
    }

    public void E(File file) {
        this.c3 = file;
    }

    public ArchiveExtraDataRecord a() {
        return this.Y;
    }

    public CentralDirectory b() {
        return this.Z;
    }

    public List<DataDescriptor> c() {
        return this.X;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public long d() {
        return this.g3;
    }

    public EndOfCentralDirectoryRecord e() {
        return this.X2;
    }

    public List<LocalFileHeader> f() {
        return this.s;
    }

    public long g() {
        return this.b3;
    }

    public long h() {
        return this.f3;
    }

    public Zip64EndOfCentralDirectoryLocator i() {
        return this.Y2;
    }

    public Zip64EndOfCentralDirectoryRecord l() {
        return this.Z2;
    }

    public File m() {
        return this.c3;
    }

    public boolean n() {
        return this.e3;
    }

    public boolean o() {
        return this.a3;
    }

    public boolean p() {
        return this.d3;
    }

    public void q(ArchiveExtraDataRecord archiveExtraDataRecord) {
        this.Y = archiveExtraDataRecord;
    }

    public void r(CentralDirectory centralDirectory) {
        this.Z = centralDirectory;
    }

    public void s(List<DataDescriptor> list) {
        this.X = list;
    }

    public void t(long j2) {
        this.g3 = j2;
    }

    public void u(EndOfCentralDirectoryRecord endOfCentralDirectoryRecord) {
        this.X2 = endOfCentralDirectoryRecord;
    }

    public void v(List<LocalFileHeader> list) {
        this.s = list;
    }

    public void w(boolean z) {
        this.e3 = z;
    }

    public void x(boolean z) {
        this.a3 = z;
    }

    public void y(long j2) {
        this.b3 = j2;
    }

    public void z(long j2) {
        this.f3 = j2;
    }
}
