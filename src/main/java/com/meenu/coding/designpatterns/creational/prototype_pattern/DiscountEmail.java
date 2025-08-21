package com.meenu.coding.designpatterns.creational.prototype_pattern;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class DiscountEmail implements EmailTemplate {
    private String content;
    private String subject;

    public DiscountEmail() {
        this.content = "Discount";
        this.subject = "Huge Discount";
    }

    @Override
    public EmailTemplate clone() {
        try {
            return (DiscountEmail) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone failed ", e);
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
