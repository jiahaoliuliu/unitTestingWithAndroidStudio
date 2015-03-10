package com.jiahaoliuliu.unittestingwithandroidstudio;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by jiahao on 3/10/15.
 */
@RunWith(RobolectricGradleTestRunner.class)
public class CalculatorTest {

    @Test
    public void testSimpleMockito() {
        // Mock creation
        List mockedList = mock(List.class);

        // Using mock object
        mockedList.add("one");
        mockedList.clear();

        // verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

}
