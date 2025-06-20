package net.imedicaldoctor.imd.Fragments;

public final class CommandRunnable implements Runnable {
    public final String command;
    public final activationActivity.activationFragment activationFragment;

    public CommandRunnable(activationActivity.activationFragment activationfragment, String str) {
        this.activationFragment = activationfragment;
        this.command = str;
    }

    public void run() {
        this.activationFragment.onCommandRun(this.command);
    }
}
