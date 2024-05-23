package sit707_tasks;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TaskInboxTest {
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

    @Test
    public void testGetTaskInbox() {
        TaskInbox inbox = new TaskInbox();
        String studentId = "12345";
        String expectedOutput = "Task1: Submitted, Feedback: Pending\n" +
                                "Task2: Submitted, Feedback: Given\n" +
                                "Chat: Hi there!, Sure, let me check.";
        assertEquals(expectedOutput, inbox.getTaskInbox(studentId)); // Right
    }

    @Test
    public void testGetTaskInboxNoTasks() {
        TaskInbox inbox = new TaskInbox();
        String studentId = "54321";
        String expectedOutput = "No tasks found for the given student ID.";
        assertEquals(expectedOutput, inbox.getTaskInbox(studentId)); // Right
    }

    @Test
    public void testGetTaskInboxInvalidStudentId() {
        TaskInbox inbox = new TaskInbox();
        String studentId = "";
        String expectedOutput = "Invalid student ID.";
        assertEquals(expectedOutput, inbox.getTaskInbox(studentId)); // Boundary, Error Conditions
    }

    @Test
    public void testGetTaskInboxNullStudentId() {
        TaskInbox inbox = new TaskInbox();
        String studentId = null;
        String expectedOutput = "Invalid student ID.";
        assertEquals(expectedOutput, inbox.getTaskInbox(studentId)); // Boundary, Error Conditions
    }

    @Test
    public void testPerformance() {
        TaskInbox inbox = new TaskInbox();
        String studentId = "12345";
        long startTime = System.currentTimeMillis();
        inbox.getTaskInbox(studentId);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertTrue("Performance test failed, took too long", duration < 100); // Performance
    }
}
