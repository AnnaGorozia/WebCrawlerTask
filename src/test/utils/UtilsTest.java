package utils;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
	@Test
	public void isEmpty() throws Exception {
		Assert.assertTrue(Utils.isEmpty("     "));
		Assert.assertFalse(Utils.isEmpty("    a"));
	}

}