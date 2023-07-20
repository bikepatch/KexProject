import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ExampleTest {
    private I iMock;
    private Example example;
    private int result;

    @Before
    public void setup(){
        // Setting instances of our classes
        iMock = mock(I.class);
        example = new Example();
        result = 0;
    }

    @Test
    public void testMut(){
        // Checking cases when this doesn't enter first if for both
        when(iMock.nextValue()).thenReturn(-1);
        when(iMock.name()).thenReturn("Value").thenReturn("negative");

        // First call, it doesn't enter anywhere
        result = example.mut(iMock);
        verify(iMock, times(1)).nextValue();
        verify(iMock, times(1)).name();
        assertEquals(0, result);

        // Second call, it enters just second if
        result = example.mut(iMock);
        verify(iMock, times(3)).nextValue();
        verify(iMock, times(2)).name();
        assertEquals(1, result);

        // Checking cases when this enters first if and then first inner if
        result = 0;
        when(iMock.nextValue()).thenReturn(1).thenReturn(-1);
        when(iMock.name()).thenReturn("Value");

        // Third call, it doesn't enter second if after first, it drops an exception
        try{
            result = example.mut(iMock);
        }catch (IllegalStateException e){
            // Just keep testing
        }
        verify(iMock, times(5)).nextValue();
        verify(iMock, times(3)).name();
        assertEquals(0, result);

        // Checking cases when this enters first if and then second inner if
        result = 0;
        when(iMock.nextValue()).thenReturn(1);
        when(iMock.name()).thenReturn("Value");

        // Fourth call
        result = example.mut(iMock);
        verify(iMock, times(8)).nextValue();
        verify(iMock, times(4)).name();
        assertEquals(1, result);

    }
}
