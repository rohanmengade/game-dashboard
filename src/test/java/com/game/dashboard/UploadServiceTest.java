package com.game.dashboard;

import com.game.dashboard.repository.GameRepository;
import com.game.dashboard.service.GameDashboardService;
import com.game.dashboard.service.UploadService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@ExtendWith( SpringExtension.class )
public class UploadServiceTest {

    GameRepository gameRepository;
    GameDashboardService gameDashboardService;
    UploadService uploadService;

    @Before
    public void init() {
        gameRepository = Mockito.mock(GameRepository.class);
        gameDashboardService = Mockito.spy(new GameDashboardService(gameRepository));
        uploadService = Mockito.spy(new UploadService(gameDashboardService));
    }

    @Test
    public void testUploadFile_ShouldAbleToUploadFileIndDB() throws IOException {

        MultipartFile multipartFile = new MockMultipartFile("fileThatDoesNotExists.txt",
                "data.csv",
                "text/plain",
                "This is a dummy file content".getBytes(StandardCharsets.UTF_8));

        Assertions.assertDoesNotThrow(() -> {
            uploadService.uploadFile(multipartFile);
        });
    }
}