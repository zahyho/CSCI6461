public class IRR {
    /*
    * Initial result register
    * */
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void pushToRegister(Register reg){
        reg.setValue(this.value);
    }
}
