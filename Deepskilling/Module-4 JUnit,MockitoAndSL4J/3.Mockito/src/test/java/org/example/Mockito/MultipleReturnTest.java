package org.example.Mockito;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MultipleReturnTest {

    @Test
    void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second");
        MyService service = new MyService(mockApi);
        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
    }
}