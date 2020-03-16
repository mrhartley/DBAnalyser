package com.hartley;

public class Analyse {
    public static List<Table> getTablesWithoutIndexes(){
        List<Table> withoutIndexes = new ArrayList<>();

        for (Table table : tables){
            if (table.getIndexes().isEmpty() && !tables.isView() && !table.isLogical())
                withoutIndexes.add(table);
        }
        return sortTablesByName(withoutIndexes);
    }
}

