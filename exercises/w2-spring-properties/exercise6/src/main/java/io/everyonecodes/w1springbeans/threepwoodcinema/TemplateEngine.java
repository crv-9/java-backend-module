package io.everyonecodes.w1springbeans.threepwoodcinema;

import org.springframework.stereotype.Service;

@Service
public class TemplateEngine {
    private TemplateMessageFinder templateMessageFinder;

    public TemplateEngine(TemplateMessageFinder templateMessageFinder) {
        this.templateMessageFinder = templateMessageFinder;
    }

    public String customiseMessage(String customerName) {
        String template = templateMessageFinder.find(customerName);
        return template.replaceAll("--name--", customerName);
    }

}
