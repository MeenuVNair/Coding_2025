package com.meenu.coding.designpatterns.creational.prototype_pattern;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public interface EmailTemplate extends Cloneable {
    EmailTemplate clone(); // Recommended to perform deep copy
    void setContent(String content);
    void send(String toEmail);
}
