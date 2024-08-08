package io.everyonecodes.w1springbeans.smallbusiness.endpoints;

import io.everyonecodes.w1springbeans.smallbusiness.logic.ShopService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shop")
public class ShopEndpoint {

    private final ShopService shopService;

    public ShopEndpoint(ShopService shopService) {
        this.shopService = shopService;
    }

    @PutMapping("/open")
    @Secured("ROLE_OWNER")
    public String openShop() {
        shopService.openShop();
        return shopService.getShopStatus();
    }

    @PutMapping("/close")
    @Secured("ROLE_OWNER")
    public String closeShop() {
        shopService.closeShop();
        return shopService.getShopStatus();
    }

    @GetMapping
    @Secured("ROLE_OWNER")
    public String getShopStatus(){
        return shopService.getShopStatus();
    }
}
