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

    private class Grid {
        private final String[] map;

        public String map() {
            return String.join("\n",map);
        }

        public Grid(String string) {
            map = string.split("\n");
        }

        public void next() {
            map[NumberOfRows()-1] = map[NumberOfRows()-2];
        }

        private int NumberOfRows() {
            return map.length;
        }
    }
}
