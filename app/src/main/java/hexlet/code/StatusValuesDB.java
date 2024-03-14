package hexlet.code;

public final class StatusValuesDB {
    private String key;
    private Object value1;
    private Object value2;

    public StatusValuesDB(String key, Object value1) {
        this.key = key;
        this.value1 = value1;
    }

    public StatusValuesDB(String key, Object value1, Object value2) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getKey() {
        return key;
    }

    public Object getValue1() {
        return value1;
    }

    public Object getValue2() {
        return value2;
    }
}
