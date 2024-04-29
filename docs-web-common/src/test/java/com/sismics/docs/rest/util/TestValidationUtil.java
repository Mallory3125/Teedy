package com.sismics.docs.rest.util;

import com.sismics.rest.exception.ClientException;
import com.sismics.rest.util.ValidationUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test the validations.
 *
 * @author jtremeaux 
 */
public class TestValidationUtil {
    @Test
    public void testValidateHttpUrlFail() throws Exception {
        ValidationUtil.validateHttpUrl("http://www.google.com", "url");
        ValidationUtil.validateHttpUrl("https://www.google.com", "url");
        ValidationUtil.validateHttpUrl(" https://www.google.com ", "url");
        try {
            ValidationUtil.validateHttpUrl("ftp://www.google.com", "url");
            Assert.fail();
        } catch (ClientException e) {
            // NOP
        }
        try {
            ValidationUtil.validateHttpUrl("http://", "url");
            Assert.fail();
        } catch (ClientException e) {
            // NOP
        }
    }

    @Test
    public void testvalidateLength() throws Exception{
        String validString = "MyValidString";
        String result = ValidationUtil.validateLength(validString, "TestString", 5, 15, false);
        Assert.assertEquals(validString, result);

        String emptyString = "";
        result = ValidationUtil.validateLength(emptyString, "TestString", 5, 15, true);
        Assert.assertEquals("", result);

        try {
            ValidationUtil.validateLength(emptyString, "TestString", 5, 15, false);
            Assert.fail();
        } catch (ClientException e) {
            // NOP
        }

    }
}
