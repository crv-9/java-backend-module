package io.everyonecodes.w1springbeans.amazinghelloworld;

import org.springframework.stereotype.Service;

@Service
public class AmazingHelloWorld {
    Hello hello;
    World world;
    public AmazingHelloWorld(Hello hello, World world) {
        this.hello = hello;
        this.world = world;
    }

    public String get(){
        String hello = this.hello.get();
        String world = this.world.get();
        return hello + " " + world;
    }
}
