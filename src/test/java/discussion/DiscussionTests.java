
package discussion;

import org.junit.Test;
import discussion.DiscussionPost;
import discussion.DiscussionThread;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class DiscussionTests {
    @Test
    public void DISCUSSION_TEST_1_discussion_created_successfully(){

        DiscussionThread thread1 = new DiscussionThread("Java Programming");
        DiscussionPost post1 = new DiscussionPost("What are the benefits of using Java over other programming languages?");
        DiscussionPost post2 = new DiscussionPost("How do you handle exceptions in Java?");
        thread1.addPost(post1);
        thread1.addPost(post2);

        DiscussionThread thread2 = new DiscussionThread("Web Development");
        DiscussionPost post3 = new DiscussionPost("What are the most important technologies for web development?");
        thread2.addPost(post3);

        DiscussionThread forum = new DiscussionThread("Discussion Forum");
        forum.addPost(thread1);
        forum.addPost(thread2);

        String expectedOutput = "Thread: Discussion Forum\n" +
                "Thread: Java Programming\n" +
                " - What are the benefits of using Java over other programming languages?\n" +
                " - How do you handle exceptions in Java?\n" +
                "Thread: Web Development\n" +
                " - What are the most important technologies for web development?\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        forum.display();

        String actualOutput = outputStream.toString();

        assertEquals(
                expectedOutput.replace("\n", "").replace("\r", "").replace(" ", ""),
                actualOutput.replace("\n", "").replace("\r", "").replace(" ", "")
        );

    }

    @Test
    public void DISCUSSION_TEST_2_single_post_displayed_successfully() {
        DiscussionPost post = new DiscussionPost("This is a test post");
        DiscussionThread thread = new DiscussionThread("Test Thread");
        thread.addPost(post);

        DiscussionThread forum = new DiscussionThread("Discussion Forum");
        forum.addPost(thread);

        String expectedOutput = "Thread: Discussion Forum\n" +
                "Thread: Test Thread\n" +
                " - This is a test post\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        forum.display();

        String actualOutput = outputStream.toString();

        assertEquals(
                expectedOutput.replace("\n", "").replace("\r", "").replace(" ", ""),
                actualOutput.replace("\n", "").replace("\r", "").replace(" ", "")
        );
    }

    @Test
    public void DISCUSSION_TEST_3_thread_with_no_posts_displayed_successfully() {
        DiscussionThread thread = new DiscussionThread("Empty Thread");

        DiscussionThread forum = new DiscussionThread("Discussion Forum");
        forum.addPost(thread);

        String expectedOutput = "Thread: Discussion Forum\n" +
                " - Empty Thread\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        forum.display();

        String actualOutput = outputStream.toString();

        assertEquals(
                expectedOutput.replace("\n", "").replace("\r", ""),
                actualOutput.replace("\n", "").replace("\r", "")
        );
    }

    @Test
    public void DISCUSSION_TEST_4_adding_post_to_thread_successfully() {
        DiscussionThread thread = new DiscussionThread("Java Programming");

        DiscussionThread forum = new DiscussionThread("Discussion Forum");
        forum.addPost(thread);

        DiscussionThread thread2 = (DiscussionThread) forum.getPost(0);

        DiscussionPost post1 = new DiscussionPost("What are the benefits of using Java over other programming languages?");
        thread2.addPost(post1);

        DiscussionPost post2 = new DiscussionPost("How do you handle exceptions in Java?");
        thread2.addPost(post2);

        String expectedOutput = "Thread: Discussion Forum\n" +
                "Thread: Java Programming\n" +
                " - What are the benefits of using Java over other programming languages?\n" +
                " - How do you handle exceptions in Java?\n";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        forum.display();

        String actualOutput = outputStream.toString();

        assertEquals(
                expectedOutput.replace("\n", "").replace("\r", "").replace(" ", ""),
                actualOutput.replace("\n", "").replace("\r", "").replace(" ", "")
        );
    }

    // Unhappy flow
    @Test(expected = NullPointerException.class)
    public void DISCUSSION_TEST_5_unhappy_add_null_post_to_thread() {
        DiscussionThread thread = new DiscussionThread("Test Thread");
        thread.addPost(null);
    }

    // test case for getting a non-existent post from a thread
    @Test(expected = IndexOutOfBoundsException.class)
    public void DISCUSSION_TEST_6_unhappy_test_get_non_existent_post_from_thread() {
        DiscussionThread thread = new DiscussionThread("Test Thread");
        thread.getPost(0);
    }



}
