package eu.execom.helenazecevic.monumentum.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import eu.execom.helenazecevic.monumentum.utils.ConstantsDatabase;

/**
 * Created by Helena Zecevic on 15.05.2016..
 */
@DatabaseTable(tableName = "type")
public class MonumentType {

    @DatabaseField(columnName = ConstantsDatabase.ID_FIELD_NAME, canBeNull = false, generatedId = true)
    private int id;

    @DatabaseField(columnName = ConstantsDatabase.NAME_FIELD_NAME, canBeNull = false)
    private String name;

    public MonumentType() {
    }

    public MonumentType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
