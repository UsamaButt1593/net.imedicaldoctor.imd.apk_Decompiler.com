package com.itextpdf.tool.xml.parser.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MonitorInputReader extends BufferedReader {
    private final ParserMonitor s;

    public MonitorInputReader(Reader reader, ParserMonitor parserMonitor) {
        super(reader);
        this.s = parserMonitor;
    }

    public int read(char[] cArr) throws IOException {
        int read = super.read(cArr);
        this.s.a(cArr);
        return read;
    }
}
