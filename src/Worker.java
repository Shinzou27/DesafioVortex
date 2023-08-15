public class Worker {
    private String name;
    private int code;
    private int jobCode;

    public Worker(String name, int code, int jobCode) {
        this.name = name;
        this.code = code;
        this.jobCode = jobCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getJobCode() {
        return jobCode;
    }

    public void setJobCode(int jobCode) {
        this.jobCode = jobCode;
    }

    @Override
    public String toString() {
        return "\nFuncionário: " + getName() + '\n' + "Código: " + getCode();
    }
}
