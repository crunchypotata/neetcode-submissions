class Solution {
	public boolean isValidSudoku(char[][] board) {

        // 1. Создаем и инициализируем массивы сетов
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                char val = board[row][col];

                if (val == '.') {
                    continue;
                }

                int boxIndex = (row / 3) * 3 + (col / 3);

                // проверяем есть ли дубликаты
                if (rows[row].contains(val) || cols[col].contains(val) || boxes[boxIndex].contains(val)) {
                    return false;
                }

                rows[row].add(val);
                cols[col].add(val);
                boxes[boxIndex].add(val);
            }
        }

        return true;
    }
}