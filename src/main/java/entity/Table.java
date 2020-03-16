package com.hartley.entity;

public class Table implements Comparable<Table> {
    private final String catalog;
    private final String schema;
    private final String name;
    private final String fullName;
    private final String container;
    protected CaseInsensitiveMap<TableColumn> columns = new CaseInsensitiveMap<>();
    private final List<TableColumn> primaryKeys = new ArrayList<>();
    private final CaseInsensitiveMap<ForeignKeyConstraint> foreignKeys = new CaseInsensitiveMap<>();
    private final CaseInsensitiveMap<TableIndex> indexes = new CaseInsensitiveMap<>();
    private Object id;
    private final Map<String, String> checkConstraints = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private long numRows;
    protected final Database db;
    private String comments;
    private int maxChildren;
    private int maxParents;

    public Table(Database db, String catalog, String schema, String name, String comments){
        this.db = db;
        this.catalog = catalog;
        this.schema = schema;
        this.container = schema != null ? schema : catalog != null ? catalog : db.getTableName();
        this.name = name;
        this.fullName = getFullName(db.getTableName(), catalog, schema, name);

        setComments(comments);

        public String getTableName() {
            return name;
        }

        public String getFullName(String db, String catalog, String schema, String table){
            return (catalog == null && schema == null ? db + '.' : "") +
                    (catalog == null ? "" : catalog + '.') +
                    (schema == null ? "" : schema + '.') + table;
        }
        }


    }

}
