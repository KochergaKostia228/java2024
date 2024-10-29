package org.itstep.model;

public abstract class Publication implements PublicationInterface {
    protected String title;

    public Publication(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
