package sit707_tasks;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "S223798216";
        Assert.assertNotNull("Student ID is ", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Chandrakanth";
        Assert.assertNotNull("Student name is ", studentName);
    }

//    @Test
//    public void testIncrementLastDayOfJanuary() {
//        DateUtil date = new DateUtil(31, 1, 2021);
//        date.increment();
//        Assert.assertEquals(1, date.getDay());
//        Assert.assertEquals(2, date.getMonth());
//    }
//
//    @Test
//    public void testIncrementLastDayOfFebruaryLeapYear() {
//        DateUtil date = new DateUtil(29, 2, 2020);
//        date.increment();
//        Assert.assertEquals(1, date.getDay());
//        Assert.assertEquals(3, date.getMonth());
//    }
//
//    @Test
//    public void testIncrementLastDayOfFebruaryNonLeapYear() {
//        DateUtil date = new DateUtil(28, 2, 2021);
//        date.increment();
//        Assert.assertEquals(1, date.getDay());
//        Assert.assertEquals(3, date.getMonth());
//    }
//
//    @Test
//    public void testIncrementLastDayOfApril() {
//        DateUtil date = new DateUtil(30, 4, 2021);
//        date.increment();
//        Assert.assertEquals(1, date.getDay());
//        Assert.assertEquals(5, date.getMonth());
//    }
//
//    @Test
//    public void testIncrementLastDayOfDecember() {
//        DateUtil date = new DateUtil(31, 12, 2021);
//        date.increment();
//        Assert.assertEquals(1, date.getDay());
//        Assert.assertEquals(1, date.getMonth());
//        Assert.assertEquals(2022, date.getYear());
//    }
//
//    @Test
//    public void testDecrementFirstDayOfMarchLeapYear() {
//        DateUtil date = new DateUtil(1, 3, 2020);
//        date.decrement();
//        Assert.assertEquals(29, date.getDay());
//        Assert.assertEquals(2, date.getMonth());
//    }
//
//    @Test
//    public void testDecrementFirstDayOfMarchNonLeapYear() {
//        DateUtil date = new DateUtil(1, 3, 2021);
//        date.decrement();
//        Assert.assertEquals(28, date.getDay());
//        Assert.assertEquals(2, date.getMonth());
//    }
//
//    @Test
//    public void testDecrementFirstDayOfMay() {
//        DateUtil date = new DateUtil(1, 5, 2021);
//        date.decrement();
//        Assert.assertEquals(30, date.getDay());
//        Assert.assertEquals(4, date.getMonth());
//    }
//
//    @Test
//    public void testDecrementFirstDayOfJanuary() {
//        DateUtil date = new DateUtil(1, 1, 2021);
//        date.decrement();
//        Assert.assertEquals(31, date.getDay());
//        Assert.assertEquals(12, date.getMonth());
//        Assert.assertEquals(2020, date.getYear());
//    }
//
//    @Test
//    public void testDecrementSecondDayOfFebruaryLeapYear() {
//        DateUtil date = new DateUtil(2, 2, 2020);
//        date.decrement();
//        Assert.assertEquals(1, date.getDay());
//        Assert.assertEquals(2, date.getMonth());
//    }
    
    @Test
    public void testDateUtilConstructor() {
        
        // Invalid day
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(0, 1, 2023));
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(32, 1, 2023));
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(30, 2, 2023));
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(29, 2, 2023)); // Not a leap year

        // Invalid month
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(1, 0, 2023));
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(1, 13, 2023));

        // Invalid year
        Assert.assertThrows(RuntimeException.class, () -> new DateUtil(1, 1, 1699));
       Assert.assertThrows(RuntimeException.class, () -> new DateUtil(1, 1, 2025));
    }
    
    @Test
    public void testIncrement() {
        DateUtil date = new DateUtil(1, 1, 2023);
        date.increment();
        Assert.assertEquals("2 January 2023", date.toString());

        date = new DateUtil(31, 12, 2023);
        date.increment();
        Assert.assertEquals("1 January 2024", date.toString());

        date = new DateUtil(28, 2, 2023); // Non-leap year
        date.increment();
        Assert.assertEquals("1 March 2023", date.toString());

        date = new DateUtil(28, 2, 2024); // Leap year
        date.increment();
        Assert.assertEquals("29 February 2024", date.toString());
    }

    @Test
    public void testDecrement() {
        DateUtil date = new DateUtil(2, 1, 2023);
        date.decrement();
        Assert.assertEquals("1 January 2023", date.toString());

        date = new DateUtil(1, 1, 2023);
        date.decrement();
        Assert.assertEquals("31 December 2022", date.toString());

        date = new DateUtil(1, 3, 2023); // Non-leap year
        date.decrement();
        Assert.assertEquals("28 February 2023", date.toString());

        date = new DateUtil(1, 3, 2024); // Leap year
        date.decrement();
        Assert.assertEquals("29 February 2024", date.toString());
    }

    @Test
    public void testAddDays() {
        Assert.assertEquals(LocalDate.of(2023, 1, 2), DateUtil.addDays(LocalDate.of(2023, 1, 1), 1));
        Assert.assertEquals(LocalDate.of(2023, 1, 31), DateUtil.addDays(LocalDate.of(2023, 1, 1), 30));
        Assert.assertEquals(LocalDate.of(2023, 2, 1), DateUtil.addDays(LocalDate.of(2023, 1, 1), 31));
        Assert.assertEquals(LocalDate.of(2023, 3, 1), DateUtil.addDays(LocalDate.of(2023, 2, 1), 28));
    }

    @Test
    public void testSubtractDays() {
        Assert.assertEquals(LocalDate.of(2023, 1, 1), DateUtil.subtractDays(LocalDate.of(2023, 1, 2), 1));
        Assert.assertEquals(LocalDate.of(2023, 1, 1), DateUtil.subtractDays(LocalDate.of(2023, 1, 31), 30));
        Assert.assertEquals(LocalDate.of(2022, 12, 1), DateUtil.subtractDays(LocalDate.of(2023, 1, 1), 31));
        Assert.assertEquals(LocalDate.of(2023, 1, 1), DateUtil.subtractDays(LocalDate.of(2023, 2, 1), 31));
    }

    @Test
    public void testIsValidDateRange() {
        Assert.assertTrue(DateUtil.isValidDateRange(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));
        Assert.assertTrue(DateUtil.isValidDateRange(LocalDate.of(2023, 5, 1), LocalDate.of(2023, 5, 31)));
        Assert.assertFalse(DateUtil.isValidDateRange(LocalDate.of(2023, 12, 31), LocalDate.of(2023, 1, 1)));
        Assert.assertFalse(DateUtil.isValidDateRange(LocalDate.of(2023, 5, 31), LocalDate.of(2023, 5, 1)));
    }

    @Test
    public void testLeapYearHandling() {
        Assert.assertEquals(LocalDate.of(2020, 2, 29), DateUtil.addDays(LocalDate.of(2020, 2, 28), 1));
        Assert.assertEquals(LocalDate.of(2021, 3, 1), DateUtil.addDays(LocalDate.of(2021, 2, 28), 1));
        Assert.assertEquals(LocalDate.of(2019, 2, 28), DateUtil.subtractDays(LocalDate.of(2020, 2, 29), 366));
    }
}
