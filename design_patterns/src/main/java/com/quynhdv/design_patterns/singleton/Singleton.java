package com.quynhdv.design_patterns.singleton;

public class Singleton {
    public static void main(String[] args) {
        System.out.println(ApplicationLoader.getInstance().getS());
        System.out.println(ApplicationLoader.getInstance().getS());
        System.out.println(ApplicationLoader.getInstance().getS());
        System.out.println(ApplicationLoader.getInstance().getS());
        System.out.println(ApplicationLoader.getInstance().getS());
    }
}

class ApplicationLoader {
    private static ApplicationLoader application;
    private String s;

    private ApplicationLoader() {
        s = "I'm the only one ! " + System.currentTimeMillis();
    }

    public static ApplicationLoader getInstance() {
        if (application == null) {
            application = new ApplicationLoader();
        }
        return application;
    }

    public String getS() {
        return s;
    }
}
