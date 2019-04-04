package com.ufal.classmates_forum.testsExceptions;

import com.ufal.classmates_forum.DefaultControllerTest;
import com.ufal.classmates_forum.exceptions.UserNotLoggedException;
import org.junit.Test;

public class UserNotLoggedExceptionTests extends DefaultControllerTest {

    @Test
    public void testUserNotLogged(){
        Exception e = new UserNotLoggedException("Testee");
        Exception e2 = new UserNotLoggedException();

        assert e.getMessage().equals("Testee") && e2.getClass().equals(e.getClass());
    }
}
