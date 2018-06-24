package com.asdi.hris.util;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void test() throws ParseException {

		assertEquals("2017-10-02",DateUtil.reformatDate("10/02/2017"));
	}

}
