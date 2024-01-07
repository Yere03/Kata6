import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestGrid {
    @Test
    public void MustReturnAnEmptyGridGivenAGridWithLastRowFull() {
        Grid grid = new Grid("""
                0000
                0000
                0000
                XXXX""");
        grid.next();
        assertThat(grid.map()).isEqualTo("""
                0000
                0000
                0000
                0000""");
    }

    @Test
    public void MustReturnANotEmptyGridGivenAGridWithLastRowFullAndMiddleRowsNotEmpties() {
        Grid grid = new Grid(TestCases.Grid4x4WithLastRowFullAndMiddleRowsNotEmptiesAndThereAreSeveralFullRows);
        grid.next();
        assertThat(grid.map()).isEqualTo("""
                0000
                0000
                0000
                X000""");
    }

    @Test
    public void MustReturnAGridWithFirstRowEmptyGivenAGridWithFirstRowNotEmptyAndLastRowFull() {
        Grid grid = new Grid(TestCases.Grid4x4WithLastRowFullAndMiddleRowsNotEmptiesAndTheFirstRowIsNotEmpty);
        grid.next();
        assertThat(grid.map()).isEqualTo("""
                0000
                0X00
                0X00
                XXX0""");
    }

    private static class TestCases{
        static String Grid4x4WithLastRowFullAndMiddleRowsNotEmptiesAndThereAreSeveralFullRows = """
                0000
                X000
                XXXX
                XXXX""";
        static String Grid4x4WithLastRowFullAndMiddleRowsNotEmptiesAndTheFirstRowIsNotEmpty = """
                0X00
                0X00
                XXX0
                XXXX""";
    }
}

