package org.example.MockitoAdvanced;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FileServiceTest {

    @Test
    void testServiceWithMockFileIO() {
        FileReader reader = mock(FileReader.class);
        FileWriter writer = mock(FileWriter.class);
        when(reader.read()).thenReturn("Mock File Content");
        FileService service = new FileService(reader, writer);
        String result = service.processFile();
        assertEquals("Processed Mock File Content", result);
        verify(writer).write("Mock File Content");
    }
}