package jp.yoyoyousei;

/**
 * Created by s-sumi on 2017/07/09.
 */
public class ReceivedValues {
    public String str;
    public Integer num;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public ReceivedValues() {
    }

    public ReceivedValues(String str, Integer num) {

        this.str = str;
        this.num = num;
    }
}
