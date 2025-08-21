package com.meenu.coding.designpatterns.creational.prototype_pattern;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class EmailTemplateRegistry {
    private static final Map<String, EmailTemplate> templates = new HashMap<>();

    static {
        templates.put("welcome", new WelcomeEmail());
        templates.put("discount", new DiscountEmail());
        // templates.put("feature-update", new FeatureUpdateEmail());
    }

    public static EmailTemplate getTemplate(String type) {
        return templates.get(type).clone(); // clone to avoid modifying original
    }
}
