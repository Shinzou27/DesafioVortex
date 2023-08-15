public class Job {
    private int code;
    private float value;

    public Job(int code, float value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cargo: " + getCode()  + "\t Salário : R$" + String.format("%.2f",getValue());
    }
}
