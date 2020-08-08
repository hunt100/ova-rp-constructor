package kz.xaw.ovaanimerp.util;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Arrays;
import java.util.List;

public final class MagicCostUtil {

    private static final Table<Integer, Integer, Integer> spellCost;
    private static final List<Integer> COSTS = Arrays.asList(60, 50, 40, 30, 20, 10, 5, 2, 0);
    private static int rowSize = Integer.MIN_VALUE;
    private static final int COL_SIZE = 5;

    private MagicCostUtil() {
        throw new IllegalStateException("Util class");
    }

    static {
        spellCost = HashBasedTable.create();
        for (int i = 0, value = 20; i < COL_SIZE; i++, value+=10) {
            getValuesFromCurrentPlace(value, i);
        }
    }

    private static void getValuesFromCurrentPlace(int value, int col) {
        int index = COSTS.indexOf(value);
        if (rowSize == Integer.MIN_VALUE) {
            rowSize = COSTS.size() - index;
        }

        for (int i = 0; i < rowSize; i++) {
            spellCost.put(i, col, COSTS.get(index++));
        }
    }

    public static Table<Integer, Integer, Integer> getSpellCost() {
        return spellCost;
    }

    public static Integer getEnduranceCostForSpecificLevels(int row, int col) {
        return spellCost.get(row, col);
    }
}
