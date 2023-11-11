package org.mycompany;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AsciiSmileyAnimationTest {
    private AsciiSmileyAnimation animation;

    @BeforeEach
    void setUp() {
        animation = new AsciiSmileyAnimation();
    }

    @Test
    void testInitialState() {
        assertTrue(animation.isEyeOpen, "Initially, the eye should be open.");
    }

    @Test
    void testToggleEyeState() {
        animation.isEyeOpen = !animation.isEyeOpen;
        assertFalse(animation.isEyeOpen, "After toggling, the eye should be closed.");
    }

    // Example test cases that may not directly test GUI, but the underlying logic

    // This set of tests would ideally check for the content of the smiley
    // But for simplicity, let's assume we are just checking the eye state representation
    @Test
    void testSmileyOpenContainsO() {
        assertTrue(animation.smileyOpen.contains("6"), "Open eyes should contain '6'.");
    }

    @Test
    void testSmileyClosedContainsDash() {
        assertTrue(animation.smileyClosed.contains("-"), "Closed eyes should contain '-'.");
    }

}
