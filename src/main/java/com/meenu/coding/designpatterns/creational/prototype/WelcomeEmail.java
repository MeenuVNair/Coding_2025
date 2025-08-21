package com.meenu.coding.designpatterns.creational.prototype;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class WelcomeEmail implements EmailTemplate {
    private String subject;
    private String content;

    public WelcomeEmail() {
        this.subject = "Welcome";
        this.content = "Thanks for joining !";
    }

    @Override
    public EmailTemplate clone() {
        try {
            return (WelcomeEmail) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed", e);
        }
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send(String toEmail) {
        System.out.println("Sending email to " + toEmail + " : [" + subject + "] " + content);
    }
}