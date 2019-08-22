package com.juma.vms.common;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * 功能 :
 *
 * @author : Bruce(刘正航) 22:42 2019-02-19
 */
public class DateUtilsTest {

    @Test
    public void testDistance() {
        String startDate = "2017-06-01 00:00";
        int year = (int)Math.ceil(DateUtil.betweenDays(DateUtils.parse(startDate,DateUtils.Parttern.FORMAT_YYMMDDHM_MID).toDate(),new Date()))/365;
        int year2 = DateUtils.distanceYears(DateUtils.parse(startDate,DateUtils.Parttern.FORMAT_YYMMDDHM_MID),DateUtils.create());
        Assert.assertEquals(year,year2);
    }

    @Test
    public void testBeginEnd(){
        DateTime originDate = DateUtils.parse("2019-05-30 11:03:48 546",DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID);
        Assert.assertEquals("2019-01-01 00:00:00 000",DateUtils.format(DateUtils.getYearOfBegin(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));
        Assert.assertEquals("2019-12-31 23:59:59 999",DateUtils.format(DateUtils.getYearOfEnd(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));

        Assert.assertEquals("2019-05-01 00:00:00 000",DateUtils.format(DateUtils.getMonthOfBegin(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));
        Assert.assertEquals("2019-05-31 23:59:59 999",DateUtils.format(DateUtils.getMonthOfEnd(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));

        Assert.assertEquals("2019-05-27 00:00:00 000",DateUtils.format(DateUtils.getWeekOfBegin(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));
        Assert.assertEquals("2019-06-02 23:59:59 999",DateUtils.format(DateUtils.getWeekOfEnd(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));

        Assert.assertEquals("2019-05-30 00:00:00 000",DateUtils.format(DateUtils.getDayOfBegin(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));
        Assert.assertEquals("2019-05-30 23:59:59 999",DateUtils.format(DateUtils.getDayOfEnd(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));

        Assert.assertEquals("2019-05-30 11:00:00 000",DateUtils.format(DateUtils.getHourOfBegin(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));
        Assert.assertEquals("2019-05-30 11:59:59 999",DateUtils.format(DateUtils.getHourOfEnd(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));

        Assert.assertEquals("2019-05-30 11:03:00 000",DateUtils.format(DateUtils.getMinuteOfBegin(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));
        Assert.assertEquals("2019-05-30 11:03:59 999",DateUtils.format(DateUtils.getMinuteOfEnd(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));

        Assert.assertEquals("2019-05-30 11:03:48 000",DateUtils.format(DateUtils.getSecondOfBegin(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));
        Assert.assertEquals("2019-05-30 11:03:48 999",DateUtils.format(DateUtils.getSecondOfEnd(originDate),DateUtils.Parttern.FORMAT_YYMMDDHMSS_MID));
    }
}
