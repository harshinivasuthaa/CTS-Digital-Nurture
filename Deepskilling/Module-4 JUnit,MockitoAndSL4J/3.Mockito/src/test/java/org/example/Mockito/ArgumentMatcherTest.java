package org.example.Mockito;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ArgumentMatcherTest {

    @Test
    void testArgumentMatcher() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.saveData("Hello");
        verify(mockApi).sendData(anyString());
    }
}