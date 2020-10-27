package pojo;

public class WpWh {
    private String wpName;
    private int num;
    private String wh_name;
    private String u_name;

    public WpWh() {
    }

    public WpWh(String wpName, int num, String wh_name, String u_name) {
        this.wpName = wpName;
        this.num = num;
        this.wh_name = wh_name;
        this.u_name = u_name;
    }

    @Override
    public String toString() {
        return "WpWh{" +
                "wpName='" + wpName + '\'' +
                ", num=" + num +
                ", wh_name='" + wh_name + '\'' +
                ", u_name='" + u_name + '\'' +
                '}';
    }

    public String getWpName() {
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getWh_name() {
        return wh_name;
    }

    public void setWh_name(String wh_name) {
        this.wh_name = wh_name;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }
}
