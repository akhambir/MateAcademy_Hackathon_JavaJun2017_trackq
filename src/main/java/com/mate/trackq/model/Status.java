package com.mate.trackq.model;

public enum Status {
    OPEN("new"),TO_CHECK("to check"),IN_DEVELOPMENT("in development"),DONE("done");
    String name;

    Status(String s) {
        this.name=s;
    }

    public String getName() {
        return name;
    }
}
