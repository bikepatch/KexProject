import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExampleTests {
    private I iMock;
    private Example example;

    @Before
    public void setup(){
        iMock = mock(I.class);
        example = new Example();
    }

    @Test
    public void testMut(){
        when(iMock.nextValue()).thenReturn(-1);
        when(iMock.name()).thenReturn("Value");




        when(iMock.nextValue()).thenReturn(1);
        when(iMock.name()).thenReturn("negative");
    }
}
