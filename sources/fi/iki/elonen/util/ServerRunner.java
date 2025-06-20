package fi.iki.elonen.util;

import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerRunner {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f28325a = Logger.getLogger(ServerRunner.class.getName());

    public static void a(NanoHTTPD nanoHTTPD) {
        try {
            nanoHTTPD.N(5000, false);
        } catch (IOException e2) {
            PrintStream printStream = System.err;
            printStream.println("Couldn't start server:\n" + e2);
            System.exit(-1);
        }
        System.out.println("Server started, Hit Enter to stop.\n");
        try {
            System.in.read();
        } catch (Throwable unused) {
        }
        nanoHTTPD.O();
        System.out.println("Server stopped.\n");
    }

    public static <T extends NanoHTTPD> void b(Class<T> cls) {
        try {
            a((NanoHTTPD) cls.newInstance());
        } catch (Exception e2) {
            f28325a.log(Level.SEVERE, "Cound nor create server", e2);
        }
    }
}
