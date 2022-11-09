package xyz.ibudai.model;

public class Mail {

    private String owner;

    private String target;

    private String subject;

    private String message;

    public Mail() {

    }

    public Mail(String owner, String target, String subject, String message) {
        this.owner = owner;
        this.target = target;
        this.subject = subject;
        this.message = message;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
