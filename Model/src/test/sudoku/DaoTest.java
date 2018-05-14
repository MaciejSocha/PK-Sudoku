package sudoku;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class DaoTest {
    @Test
    void FileSudokuBoardTest_Write() {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        SudokuBoard sb = new SudokuBoard();
        sb.fillBoard();
        Dao d = factory.getFileDao("test.txt");
        d.write(sb);

        File f = new File("test.txt");

        assertTrue(f.exists());
    }

    @Test
    void FileSudokuBoardTest_Read() {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        Dao d = factory.getFileDao("test.txt");
        SudokuBoard sb = new SudokuBoard();
        sb.fillBoard();
        d.write(sb);

        SudokuBoard sb2 = (SudokuBoard)d.read();

        boolean a = false;
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                if (sb.getValue(i, j) == sb2.getValue(i, j)) a = true;
                else a = false;
            }
        }

        assertTrue(a);
    }

}
