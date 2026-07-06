package org.example.Mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
public class VoidMethodTest {

    @Test
    void testVoidMethod() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).deleteData();
        MyService service = new MyService(mockApi);
        service.removeData();
        verify(mockApi).deleteData();
    }
}