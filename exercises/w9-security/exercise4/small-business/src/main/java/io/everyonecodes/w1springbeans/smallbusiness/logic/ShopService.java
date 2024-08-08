package io.everyonecodes.w1springbeans.smallbusiness.logic;

import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private String shopStatus = "CLOSED";

    public String getShopStatus() {
        return shopStatus;
    }

    public void closeShop(){
        shopStatus = "CLOSED";
    }

    public void openShop(){
        shopStatus = "OPENED";
    }

}
