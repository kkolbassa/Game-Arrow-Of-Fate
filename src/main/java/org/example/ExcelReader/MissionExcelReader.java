package org.example.ExcelReader;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.missions.Mission;
import org.example.missionsFactory.MissionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MissionExcelReader {
    public static void readData() throws IOException {
        InputStream inputStream = MissionExcelReader.class.getClassLoader().getResourceAsStream("data/Текстовые описания.xlsx");
        Workbook workbook = new XSSFWorkbook(inputStream);
        readMissions(workbook);
        readBeginStory(workbook);
        readEndStory(workbook);
    }

    private static void readBeginStory(Workbook workbook) {
        ArrayList<String> beginStory = new ArrayList<>();

        Sheet sheet = workbook.getSheet("Начало");
        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Cell cell = currentRow.getCell(0);
            beginStory.add(cell.getStringCellValue());
        }
        StoryData.getInstance().setBeginStory(beginStory);
    }

    private static void readEndStory(Workbook workbook) {
        ArrayList<String> endStory = new ArrayList<>();

        Sheet sheet = workbook.getSheet("Конец");
        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Cell cell = currentRow.getCell(0);
            endStory.add(cell.getStringCellValue());
        }
        StoryData.getInstance().setEndStory(endStory);
    }

    private static void readMissions(Workbook workbook) {
        new MissionFactory() {
            @Override
            public Mission create(boolean significant) {
                return null;
            }
        };

        Sheet sheet = workbook.getSheet("Миссии");
        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Cell region = currentRow.getCell(0);
            Cell task = currentRow.getCell(1);
            Cell description = currentRow.getCell(2);

            MissionFactory.addMissionData(new MissionData(region.getStringCellValue(), task.getStringCellValue(), description.getStringCellValue()));
        }
    }
}
