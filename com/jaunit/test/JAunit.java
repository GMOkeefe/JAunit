package com.jaunit.test;

import java.util.List;
import java.util.ArrayList;

import com.jaunit.flow.Check;
import com.jaunit.flow.False;
import com.jaunit.flow.Loop;
import com.jaunit.flow.True;

public class JAunit {
    private static JAunit self;
    private List<Test> tests;

    private JAunit() {
        tests = new ArrayList<>();
    }

    public static void addTest(Test test) {
        if (self == null) {
            self = new JAunit();
        }

        self.tests.add(test);
    }

    public static void runTests() {
        List<String> errorMessages = new ArrayList<>();
        Loop<Test> loop = new Loop<>(self.tests);

        loop.forEach((t) -> {
            try {
                t.apply();
            }
            catch (AssertionError e) {
                errorMessages.add(e.getMessage());
            }
        });

        int numMessages = errorMessages.size();
        try {
            Check.greaterThan(numMessages, 0);
        }
        catch (True e) {
            int numTests = self.tests.size();
            System.out.println((numTests - numMessages) + " of " + numTests +
                " tests failed to pass");
            Loop<String> errLoop = new Loop<>(errorMessages);

            errLoop.forEach((s) -> {
                System.out.println(s);
            });
        }
        catch (False e) {
            System.out.println("All " + self.tests.size() + " tests passed");
        }
    }
}
