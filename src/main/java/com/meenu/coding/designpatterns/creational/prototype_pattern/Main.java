package com.meenu.coding.designpatterns.creational.prototype_pattern;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

/*******  APPROACH ******************** 

 */

public class Main {
    public static void main(String[] args) {
        EmailTemplate welcomeEmail1 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail1.setContent("Welcome to interview preparation");
        welcomeEmail1.send("meenu@emil.com");

        EmailTemplate welcomeEmail2 = EmailTemplateRegistry.getTemplate("welcome");
        //welcomeEmail2.setContent("Hi Bob, thanks for joining!");
        welcomeEmail2.send("bob@example.com");

        EmailTemplate discountEmail = EmailTemplateRegistry.getTemplate("discount");
        discountEmail.setContent("Hi Meenu, you have a discount");
        discountEmail.send("meenu@email.com");

        // Reuse the base WelcomeEmail structure, just changing dynamic content
    }
}