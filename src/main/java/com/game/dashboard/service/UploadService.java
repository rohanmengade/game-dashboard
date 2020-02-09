package com.game.dashboard.service;

import com.game.dashboard.dao.GameData;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UploadService {

    private final GameDashboardService gameDashboardService;


    @Autowired
    public UploadService(GameDashboardService gameDashboardService) {
        this.gameDashboardService = gameDashboardService;
    }

    public List<GameData> uploadFile(MultipartFile multipartFile) throws IOException {
        File file = convertMultiPartToFile(multipartFile);
        return storeGameData(file);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convertFile = new File(file.getOriginalFilename());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(convertFile);
            fos.write(file.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != fos )
                fos.close();
        }
        return convertFile;
    }

    private List<GameData> storeGameData(File file) throws IOException {
        List<GameData> mandatoryMissedList = new ArrayList<GameData>();
        try (Reader reader = new FileReader(file)) {

            CsvToBean<GameData> csvToBean = new CsvToBeanBuilder<GameData>(reader)
                    .withType(GameData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<GameData> GameDataList = csvToBean.parse();

            Iterator<GameData> GameDataListClone = GameDataList.iterator();

            while (GameDataListClone.hasNext()) {

                GameData GameData = GameDataListClone.next();

                if (GameData.getGameName() == null || GameData.getPlatform().isEmpty()) {
                    mandatoryMissedList.add(GameData);
                    GameDataListClone.remove();
                }

                gameDashboardService.store(GameData);
            }
            //gameDashboardService.batchStore(GameDataList);
        }
        return mandatoryMissedList;
    }

}