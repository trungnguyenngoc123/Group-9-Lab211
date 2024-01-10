package Model;

public class Model {
    private String binaryNum;
    private int decimalNum;
    private String hexNum; 

    public Model() {
    }

    public Model(String binaryNum, int decimalNum, String hexNum) {
        this.binaryNum = binaryNum;
        this.decimalNum = decimalNum;
        this.hexNum = hexNum;
    }

    public String getBinaryNum() {
        return binaryNum;
    }

    public void setBinaryNum(String binaryNum) {
        this.binaryNum = binaryNum;
    }

    public int getDecimalNum() {
        return decimalNum;
    }

    public void setDecimalNum(int decimalNum) {
        this.decimalNum = decimalNum;
    }

    public String getHexNum() {
        return hexNum;
    }

    public void setHexNum(String hexNum) {
        this.hexNum = hexNum;
    }

}
