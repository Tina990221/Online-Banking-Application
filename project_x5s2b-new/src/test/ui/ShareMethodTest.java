package ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import placeholder.ShareMethod;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShareMethodTest {

    public ShareMethod shareMethod;
    public Boolean within6months;

    @BeforeEach
    public void setup(){
        shareMethod = new ShareMethod();
        within6months = true;
    }


    @Test
    public void testcardIsValid(){
        shareMethod.within6months = false;
        assertFalse(shareMethod.cardIsValid () == true);
        assertTrue(shareMethod.cardIsValid () == false);

        shareMethod.within6months = true;
        assertFalse(shareMethod.cardIsValid () == false);
        assertTrue(shareMethod.cardIsValid () == true);

    }
}
