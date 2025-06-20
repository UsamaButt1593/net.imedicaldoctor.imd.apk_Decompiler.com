package org.apache.commons.httpclient.util;

public final class TimeoutController {

    public static class TimeoutException extends Exception {
    }

    private TimeoutController() {
    }

    public static void execute(Runnable runnable, long j2) throws TimeoutException {
        Thread thread = new Thread(runnable, "Timeout guard");
        thread.setDaemon(true);
        execute(thread, j2);
    }

    public static void execute(Thread thread, long j2) throws TimeoutException {
        thread.start();
        try {
            thread.join(j2);
        } catch (InterruptedException unused) {
        }
        if (thread.isAlive()) {
            thread.interrupt();
            throw new TimeoutException();
        }
    }
}
