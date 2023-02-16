package test.java.forum;

import main.java.forum.ForumComment;
import main.java.forum.Forum;
import main.java.forum3.CommentLeaf;
import main.java.forum3.ThreadComposite;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ForumTests {


//    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//
//    @Before
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outContent));
//    }
//
//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//    }


    @Test
    public void testForumComponentDisplay() {
        // Create forum, thread, and comments
        Forum forum = new Forum("My Forum");
        ThreadComposite thread1 = new ThreadComposite("Thread 1");
        CommentLeaf comment1 = new CommentLeaf("Alice", "I have a question.");
        ForumComment comment2 = new ForumComment("Bob", "What's your question?");
        thread1.addComment(comment1);
        thread1.addComment(comment2);
        comment1.addComment(new ForumComment("Alice", "How do I use the Composite pattern in Java?"));
        comment2.addComment(new ForumComment("Bob", "You can start by creating a Thread and adding Comments to it."));
        comment2.addComment(new ForumComment("Alice", "Thanks, that helps!"));
        forum.addComponent(thread1);

        // Set up output stream for console
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the display method to display the forum
        forum.display();

        // Verify that the output matches the expected output
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String expectedOutput = "Forum: My Forum\n" +
                "Thread: Thread 1\n" +
                "Comment by Alice on " + formatter.format(now) + ": I have a question.\n" +
                "Comment by Bob on " + formatter.format(now) + ": What's your question.\n" +
                "Comment by Alice on " + formatter.format(now) + ": How do I use the Composite pattern in Java?\n" +
                "Comment by Bob on " + formatter.format(now) + ": You can start by creating a Thread and adding Comments to it.\n" +
                "Comment by Alice on " + formatter.format(now) + ": Thanks, that helps!\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

}
