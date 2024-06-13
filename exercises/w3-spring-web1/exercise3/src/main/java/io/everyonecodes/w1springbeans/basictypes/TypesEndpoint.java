package io.everyonecodes.w1springbeans.basictypes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/types")
public class TypesEndpoint {

    @GetMapping("/text")
    public String getTextType(){
        return "Types";
    }

    @GetMapping("/number")
    public int getNumberType(){
        return 25920;
    }

    @GetMapping("/choice")
    public boolean getChoiceType(){
        return false;
    }
}
