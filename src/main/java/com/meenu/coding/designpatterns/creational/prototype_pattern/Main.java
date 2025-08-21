package com.meenu.coding.designpatterns.creational.prototype_pattern;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

/*******  APPROACH ******************** 
 The Prototype Pattern is a creational design pattern used to clone existing objects instead of constructing them from scratch.
 It enables efficient object creation, especially when the initialization process is complex or costly.

 In simpler terms:
     Imagine you already have a perfectly set-up object — like a well-written email template or a configured game character.
     Instead of building a new one every time (which can be repetitive and expensive), you just copy the existing one and make small adjustments.
     This is what the Prototype Pattern does. It allows you to create new objects by copying existing ones, saving time and resources.

 Real-life Analogy (Photocopy Machine)
     Think of preparing ten offer letters.
     Instead of typing the same letter ten times, you write it once, photocopy it, and change just the name on each copy.
     This is how the Prototype Pattern works: start with a base object and produce modified copies with minimal changes.


 ===================================
 Deep Cloning VS Shallow Cloning
 ===================================
 There are two types of cloning in Java: Shallow Cloning and Deep Cloning.

 In the context of the Prototype Pattern, Deep Cloning is often preferred.
 This means that when you clone an object, not only the object itself is copied, but also all the objects it references.
 This ensures that changes to the cloned object do not affect the original object or any of its referenced objects.

 Deep cloning is considered safer as well than shallow cloning because it avoids unintended side effects and ensures each clone is truly independent — especially important when templates contain complex internal structures (like nested configuration objects, lists, etc.).
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