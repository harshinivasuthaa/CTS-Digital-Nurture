package org.example.MockitoAdvanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ApiServiceTest {

    @Test
    void testServiceWithMockRestClient() {
        RestClient mockClient = mock(RestClient.class);
        when(mockClient.getResponse()).thenReturn("Mock Response");
        ApiService api = new ApiService(mockClient);
        String result = api.fetchData();
        assertEquals("Fetched Mock Response", result);
    }
}