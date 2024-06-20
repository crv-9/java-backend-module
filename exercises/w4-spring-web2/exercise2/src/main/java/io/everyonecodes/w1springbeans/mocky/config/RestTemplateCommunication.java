package io.everyonecodes.w1springbeans.mocky.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateCommunication {
    RestTemplate restTemplate;
    private final String singleurl;
    private final String arrayurl;
    private final String singlepostcardurl;
    private final String listpostcardurl;

    public RestTemplateCommunication(RestTemplate restTemplate, @Value("${url.singleurl}") String singleurl, @Value("${url.arrayurl}") String arrayurl, @Value("${url.singlpostcardeurll}") String singlepostcardurl,  @Value("${url.listpostcardurl}")String listpostcardurl) {
        this.restTemplate = restTemplate;
        this.singleurl = singleurl;
        this.arrayurl = arrayurl;
        this.singlepostcardurl = singlepostcardurl;
        this.listpostcardurl = listpostcardurl;
    }

    public String getSingleString(){
        return restTemplate.getForObject(singleurl, String.class);
    }
    public String getArrayString(){
        return restTemplate.getForObject(arrayurl, String.class);
    }
    public String getSinglePostcard(){
        return restTemplate.getForObject(singlepostcardurl, String.class);
    }
    public String getListPostcard(){
        return restTemplate.getForObject(listpostcardurl, String.class);
    }




}
