package io.everyonecodes.w1springbeans.threepwoodcinema;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateMessageFinder {
    List<Template> templates;
    String defaultMessage;

    public TemplateMessageFinder(@Value("${cinema.specialOffer.defaultMessage}") String defaultMessage, List<Template> templates) {
        this.templates = templates;
        this.defaultMessage = defaultMessage;
    }

    public String find(String name){
        return templates.stream()
                .filter(template -> name.contains(template.getKeyword()))
                .map(Template::getMessage)
                .findFirst()
                .orElse(defaultMessage);
    }

}
