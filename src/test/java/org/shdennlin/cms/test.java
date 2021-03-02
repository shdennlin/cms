package org.shdennlin.cms;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test {
    @Test
    public void test1() {
        System.out.println("test");
    }
}

// ===============================================================================================

interface IRequest {
    public void execute();
}

class HelloRequest implements IRequest {
    private String name;

    public HelloRequest(String name) {
        this.name = name;
    }

    public void execute() {
        System.out.printf("Hello! %s!%n", name);
    }
}

class WelcomeRequest implements IRequest {
    private String place;

    public WelcomeRequest(String place) {
        this.place = place;
    }

    public void execute() {
        System.out.printf("Welcome to %s!%n", place);
    }
}

class temp {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int n = (int) (Math.random() * 10) % 2;
            switch (n) {
                case 0:
                    doRequest(
                            new HelloRequest("caterpillar"));
                    break;
                case 1:
                    doRequest(new WelcomeRequest("PmWiki"));
            }
        }
    }

    public static void doRequest(IRequest request) {
        request.execute();
    }
}
