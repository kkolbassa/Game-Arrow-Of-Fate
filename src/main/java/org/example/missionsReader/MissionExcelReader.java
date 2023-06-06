package org.example.missionsReader;

import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class MissionExcelReader {
    public ArrayList<MissionData> createMissionsFromExcel() {
        ArrayList<MissionData> missions = new ArrayList<>();

        InputStream inputStream = MissionExcelReader.class.getClassLoader().getResourceAsStream("data/Миссии.xlsx");
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> iterator = sheet.iterator();

        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Cell cell1 = currentRow.getCell(0);
            Cell cell2 = currentRow.getCell(1);
            Cell cell3 = currentRow.getCell(2);

            missions.add(new MissionData(cell1.getStringCellValue(),cell2.getStringCellValue(),cell3.getStringCellValue()));
        }

        return missions;
    }
}
