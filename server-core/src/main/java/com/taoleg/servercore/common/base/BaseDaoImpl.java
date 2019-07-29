package com.taoleg.servercore.common.base;

import java.io.Serializable;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    @Override
    public void save(T entity) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public T findById(Serializable id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }
//    /**
//     * 设置一些操作的常量
//     */
//    public static final String SQL_INSERT = "insert";
//    public static final String SQL_UPDATE = "update";
//    public static final String SQL_DELETE = "delete";
//
//
//    private Class<T> entityClass;
//
//    @SuppressWarnings("unchecked")
//    public BaseDaoImpl() {
//        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
//        entityClass = (Class<T>) type.getActualTypeArguments()[0];
//        System.out.println("Dao实现类是：" + entityClass.getName());
//    }
//
//    public void save(T entity) {
//        String sql = this.makeSql(SQL_INSERT);
//        Object[] args = this.setArgs(entity, SQL_INSERT);
//        int[] argTypes = this.setArgTypes(entity, SQL_INSERT);
//        jdbcTemplate.update(sql.toString(), args, argTypes);
//    }
//
//    public void update(T entity) {
//        String sql = this.makeSql(SQL_UPDATE);
//        Object[] args = this.setArgs(entity, SQL_UPDATE);
//        int[] argTypes = this.setArgTypes(entity, SQL_UPDATE);
//        jdbcTemplate.update(sql, args, argTypes);
//    }
//
//    public void delete(T entity) {
//        String sql = this.makeSql(SQL_DELETE);
//        Object[] args = this.setArgs(entity, SQL_DELETE);
//        int[] argTypes = this.setArgTypes(entity, SQL_DELETE);
//        jdbcTemplate.update(sql, args, argTypes);
//    }
//
//    public void delete(Serializable id) {
//        String sql = " DELETE FROM " + entityClass.getSimpleName() + " WHERE id=?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    public void deleteAll() {
//        Table table = entityClass.getAnnotation(Table.class);
//        String tableName = table == null ? entityClass.getSimpleName() : table.name();
//
//        String sql = " TRUNCATE TABLE " + tableName;
//        jdbcTemplate.execute(sql);
//    }
//
//    public T findById(Serializable id) {
//        Table table = entityClass.getAnnotation(Table.class);
//        String tableName = table == null ? entityClass.getSimpleName() : table.name();
//        Field[] fields = entityClass.getDeclaredFields();
//        String idName = null;
//        for (int i = 0; fields != null && i < fields.length; i++) {
//            fields[i].setAccessible(true); // 暴力反射
//            Column column = fields[i].getAnnotation(Column.class);
//            Id classid = fields[i].getAnnotation(Id.class);
//            if (classid != null) { // 主键
//                idName = column.name();
//                continue;
//            }
//        }
//
//        String sql = "SELECT * FROM " + tableName + " WHERE " + idName + "=?";
//        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
//        return jdbcTemplate.query(sql, rowMapper, id).get(0);
//    }
//
//    public List<T> findAll() {
//        Table table = entityClass.getAnnotation(Table.class);
//        String tableName = table == null ? entityClass.getSimpleName() : table.name();
//
//        String sql = "SELECT * FROM " + tableName;
//        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
//        return jdbcTemplate.query(sql, rowMapper);
//    }
//
//    // 组装SQL
//    private String makeSql(String sqlFlag) {
//        StringBuffer sql = new StringBuffer();
//
//        //获取表名
//        Table table = entityClass.getAnnotation(Table.class);
//        String tableName = table == null ? entityClass.getSimpleName() : table.name();
//
//        Field[] fields = entityClass.getDeclaredFields();
//        if (sqlFlag.equals(SQL_INSERT)) {
//            sql.append(" INSERT INTO " + tableName);
//            sql.append("(");
//            for (int i = 0; fields != null && i < fields.length; i++) {
//                fields[i].setAccessible(true); // 暴力反射
//                Column column = fields[i].getAnnotation(Column.class);
//                String fieldsName = column == null ? fields[i].getName() : column.name();
//                sql.append(fieldsName).append(",");
//            }
//            sql = sql.deleteCharAt(sql.length() - 1);
//            sql.append(") VALUES (");
//            for (int i = 0; fields != null && i < fields.length; i++) {
//                sql.append("?,");
//            }
//            sql = sql.deleteCharAt(sql.length() - 1);
//            sql.append(")");
//        } else if (sqlFlag.equals(SQL_UPDATE)) {
//            sql.append(" UPDATE " + tableName + " SET ");
//            String idName = null;
//            for (int i = 0; fields != null && i < fields.length; i++) {
//                fields[i].setAccessible(true); // 暴力反射
//
//                Column column = fields[i].getAnnotation(Column.class);
//                Id id = fields[i].getAnnotation(Id.class);
//                if (id != null) { // 主键
//                    idName = column.name();
//                    continue;
//                }
//                String fieldsName = column == null ? fields[i].getName() : column.name();
//                sql.append(fieldsName).append("=").append("?,");
//            }
//            sql = sql.deleteCharAt(sql.length() - 1);
//            sql.append(" WHERE " + idName + "=?");
//        } else if (sqlFlag.equals(SQL_DELETE)) {
//            sql.append(" DELETE FROM " + tableName);
//            String idName = null;
//            for (int i = 0; fields != null && i < fields.length; i++) {
//                fields[i].setAccessible(true); // 暴力反射
//                Column column = fields[i].getAnnotation(Column.class);
//                Id id = fields[i].getAnnotation(Id.class);
//                if (id != null) { // 主键
//                    idName = column.name();
//                    continue;
//                }
//            }
//            sql.append(" WHERE " + idName + "=?");
//        }
//        System.out.println("SQL：" + sql);
//        return sql.toString();
//
//    }
//
//    // 设置参数
//    private Object[] setArgs(T entity, String sqlFlag) {
//        Field[] fields = entityClass.getDeclaredFields();
//        if (sqlFlag.equals(SQL_INSERT)) {
//            Object[] args = new Object[fields.length];
//            for (int i = 0; args != null && i < args.length; i++) {
//                try {
//                    fields[i].setAccessible(true); // 暴力反射
//                    args[i] = fields[i].get(entity);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            return args;
//        } else if (sqlFlag.equals(SQL_UPDATE)) {
//            Object[] tempArr = new Object[fields.length];
//            for (int i = 0; tempArr != null && i < tempArr.length; i++) {
//                try {
//                    fields[i].setAccessible(true); // 暴力反射
//                    tempArr[i] = fields[i].get(entity);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            Object[] args = new Object[fields.length];
//            System.arraycopy(tempArr, 1, args, 0, tempArr.length - 1); // 数组拷贝
//            args[args.length - 1] = tempArr[0];
//            return args;
//        } else if (sqlFlag.equals(SQL_DELETE)) {
//            Object[] args = new Object[1]; // 长度是1
//            fields[0].setAccessible(true); // 暴力反射
//            try {
//                args[0] = fields[0].get(entity);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return args;
//        }
//        return null;
//
//    }
//
//    // 设置参数类型（写的不全，只是一些常用的）
//    private int[] setArgTypes(T entity, String sqlFlag) {
//        Field[] fields = entityClass.getDeclaredFields();
//        if (sqlFlag.equals(SQL_INSERT)) {
//            int[] argTypes = new int[fields.length];
//            try {
//                for (int i = 0; argTypes != null && i < argTypes.length; i++) {
//                    fields[i].setAccessible(true); // 暴力反射
//                    if (fields[i].get(entity).getClass().getName().equals("java.lang.String")) {
//                        argTypes[i] = Types.VARCHAR;
//                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Double")) {
//                        argTypes[i] = Types.DECIMAL;
//                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Integer")) {
//                        argTypes[i] = Types.INTEGER;
//                    } else if (fields[i].get(entity).getClass().getName().equals("java.util.Date")) {
//                        argTypes[i] = Types.DATE;
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return argTypes;
//        } else if (sqlFlag.equals(SQL_UPDATE)) {
//            int[] tempArgTypes = new int[fields.length];
//            int[] argTypes = new int[fields.length];
//            try {
//                for (int i = 0; tempArgTypes != null && i < tempArgTypes.length; i++) {
//                    fields[i].setAccessible(true); // 暴力反射
//                    if (fields[i].get(entity).getClass().getName().equals("java.lang.String")) {
//                        tempArgTypes[i] = Types.VARCHAR;
//                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Double")) {
//                        tempArgTypes[i] = Types.DECIMAL;
//                    } else if (fields[i].get(entity).getClass().getName().equals("java.lang.Integer")) {
//                        tempArgTypes[i] = Types.INTEGER;
//                    } else if (fields[i].get(entity).getClass().getName().equals("java.util.Date")) {
//                        tempArgTypes[i] = Types.DATE;
//                    }
//                }
//                System.arraycopy(tempArgTypes, 1, argTypes, 0, tempArgTypes.length - 1); // 数组拷贝
//                argTypes[argTypes.length - 1] = tempArgTypes[0];
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return argTypes;
//
//        } else if (sqlFlag.equals(SQL_DELETE)) {
//            int[] argTypes = new int[1]; // 长度是1
//            try {
//                fields[0].setAccessible(true); // 暴力反射
//                if (fields[0].get(entity).getClass().getName().equals("java.lang.String")) {
//                    argTypes[0] = Types.VARCHAR;
//                } else if (fields[0].get(entity).getClass().getName().equals("java.lang.Integer")) {
//                    argTypes[0] = Types.INTEGER;
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return argTypes;
//        }
//        return null;
//    }
//
//    private List<T> find(int pageNo, int pageSize, Map<String, String> where, LinkedHashMap<String, String> orderby) {
//        // where 与 order by 要写在select * from table 的后面，而不是where rownum<=? )
//        // where rn>=?的后面
//        StringBuffer sql = new StringBuffer(
//                " SELECT * FROM (SELECT t.*,ROWNUM rn FROM (SELECT * FROM " + entityClass.getSimpleName());
//        if (where != null && where.size() > 0) {
//            sql.append(" WHERE "); // 注意不是where
//            for (Map.Entry<String, String> me : where.entrySet()) {
//                String columnName = me.getKey();
//                String columnValue = me.getValue();
//                sql.append(columnName).append(" ").append(columnValue).append(" AND "); // 没有考虑or的情况
//            }
//            int endIndex = sql.lastIndexOf("AND");
//            if (endIndex > 0) {
//                sql = new StringBuffer(sql.substring(0, endIndex));
//            }
//        }
//        if (orderby != null && orderby.size() > 0) {
//            sql.append(" ORDER BY ");
//            for (Map.Entry<String, String> me : orderby.entrySet()) {
//                String columnName = me.getKey();
//                String columnValue = me.getValue();
//                sql.append(columnName).append(" ").append(columnValue).append(",");
//            }
//            sql = sql.deleteCharAt(sql.length() - 1);
//        }
//        sql.append(" ) t WHERE ROWNUM<=? ) WHERE rn>=? ");
//        System.out.println("SQL=" + sql);
//        Object[] args = {pageNo * pageSize, (pageNo - 1) * pageSize + 1};
//        RowMapper<T> rowMapper = BeanPropertyRowMapper.newInstance(entityClass);
//        return jdbcTemplate.query(sql.toString(), args, rowMapper);
//    }

//    private int count(Map<String, String> where) {
//        StringBuffer sql = new StringBuffer(" SELECT COUNT(*) FROM " + entityClass.getSimpleName());
//        if (where != null && where.size() > 0) {
//            sql.append(" WHERE ");
//            for (Map.Entry<String, String> me : where.entrySet()) {
//                String columnName = me.getKey();
//                String columnValue = me.getValue();
//                sql.append(columnName).append(" ").append(columnValue).append(" AND "); // 没有考虑or的情况
//            }
//            int endIndex = sql.lastIndexOf("AND");
//            if (endIndex > 0) {
//                sql = new StringBuffer(sql.substring(0, endIndex));
//            }
//        }
//        System.out.println("SQL=" + sql);
//        return jdbcTemplate.queryForInt(sql.toString());
//    }
}