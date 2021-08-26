package com.iamceph.resulter.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleResultTest {

    @Test
    public void testOk() {
        final var result = SimpleResult.ok();

        Assertions.assertTrue(result.isOk());

        Assertions.assertFalse(result.isFail());
        Assertions.assertFalse(result.isWarning());

        assertNull(result.error());
        assertNotNull(result.message());

        Assertions.assertEquals(result.message(), "Ok.");
    }

    @Test
    public void testOkWithMessage() {
        final var result = SimpleResult.ok("test message");

        Assertions.assertTrue(result.isOk());

        Assertions.assertFalse(result.isFail());
        Assertions.assertFalse(result.isWarning());

        assertNull(result.error());
        assertNotNull(result.message());

        Assertions.assertEquals(result.message(), "test message");
    }

    @Test
    public void testFailWithMessage() {
        final var result = SimpleResult.fail("test message");

        Assertions.assertTrue(result.isFail());

        Assertions.assertFalse(result.isOk());
        Assertions.assertFalse(result.isWarning());

        assertNull(result.error());
        assertNotNull(result.message());

        Assertions.assertEquals(result.message(), "test message");
    }

    @Test
    public void testFailWithMessageAndThrowable() {
        final var result = SimpleResult.fail("test message", new UnsupportedOperationException("This is not supposed to happen. :)"));

        Assertions.assertTrue(result.isFail());

        Assertions.assertFalse(result.isOk());
        Assertions.assertFalse(result.isWarning());

        assertNotNull(result.error());
        assertNotNull(result.message());

        Assertions.assertEquals(result.message(), "test message");

        assertSame(Objects.requireNonNull(result.error()).getClass(), UnsupportedOperationException.class);
    }

    @Test
    public void testFailWithThrowable() {
        final var result = SimpleResult.fail(new UnsupportedOperationException("This is not supposed to happen. :)"));

        Assertions.assertTrue(result.isFail());

        Assertions.assertFalse(result.isOk());
        Assertions.assertFalse(result.isWarning());

        assertNotNull(result.error());
        assertNotNull(result.message());

        Assertions.assertEquals(result.message(), "This is not supposed to happen. :)");

        assertSame(Objects.requireNonNull(result.error()).getClass(), UnsupportedOperationException.class);
    }

    @Test
    public void testWarningWithMessage() {
        final var result = SimpleResult.warning("test message");

        Assertions.assertTrue(result.isWarning());

        Assertions.assertFalse(result.isOk());
        Assertions.assertFalse(result.isFail());

        assertNull(result.error());
        assertNotNull(result.message());

        Assertions.assertEquals(result.message(), "test message");
    }

    @Test
    public void testWarningWithMessageAndThrowable() {
        final var result = SimpleResult.warning("test message", new UnsupportedOperationException("This is not supposed to happen. :)"));

        Assertions.assertTrue(result.isWarning());

        Assertions.assertFalse(result.isOk());
        Assertions.assertFalse(result.isFail());

        assertNotNull(result.error());
        assertNotNull(result.message());

        Assertions.assertEquals(result.message(), "test message");

        assertSame(Objects.requireNonNull(result.error()).getClass(), UnsupportedOperationException.class);
    }

    @Test
    public void testWarningWithThrowable() {
        final var result = SimpleResult.warning(new UnsupportedOperationException("This is not supposed to happen. :)"));

        Assertions.assertTrue(result.isWarning());

        Assertions.assertFalse(result.isOk());
        Assertions.assertFalse(result.isFail());

        assertNotNull(result.error());
        assertNotNull(result.message());

        Assertions.assertEquals(result.message(), "This is not supposed to happen. :)");

        assertSame(Objects.requireNonNull(result.error()).getClass(), UnsupportedOperationException.class);
    }
}
