public class Grid {
    private final String[] map;

    public String map() {
        return String.join("\n", map);
    }

    public Grid(String string) {
        map = string.split("\n");
    }

    public void next() {
        boolean AtleastOneRowIsFull = false;
        for (int i = NumberOfRows()-1; i >= 0 ; i--) {
            while(RowIsFull(i)){
                MoveAllRowsAbove(i);
                map[0] = "0".repeat(NumberOfColumns());
            }
        }
    }

    private int NumberOfColumns() {
        return map[0].length();
    }

    private void MoveAllRowsAbove(int row) {
        for (int j = row; j >= 1; j--) {
            map[j] = map[j-1];
        }
    }

    private boolean RowIsFull(int row) {
        return map[row].chars().noneMatch(a -> a == '0');
    }

    private int NumberOfRows() {
        return map.length;
    }
}