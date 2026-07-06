package org.example.Mockito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ExceptionVoidTest {
    @Test
    void testVoidException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Delete Failed")).when(mockApi).deleteData();
        MyService service = new MyService(mockApi);
        assertThrows(RuntimeException.class, () -> service.removeData());
    }
}