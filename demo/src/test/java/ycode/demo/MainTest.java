package ycode.demo;

import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class MainTest {
    @Test
    public void appHasAGreeting() {
        Main classUnderTest = new Main();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
