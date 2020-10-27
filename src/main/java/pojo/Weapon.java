package pojo;

public class Weapon {
    private int id;//武器编号
    private String name;//武器名称
    private int u_id;//维护人员id
    private int wh_id;//仓库编号
    private int range;//射程

    public Weapon() {
    }

    public Weapon(int id, String name, int u_id, int wh_id, int range) {
        this.id = id;
        this.name = name;
        this.u_id = u_id;
        this.wh_id = wh_id;
        this.range = range;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", u_id=" + u_id +
                ", wh_id=" + wh_id +
                ", range=" + range +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getWh_id() {
        return wh_id;
    }

    public void setWh_id(int wh_id) {
        this.wh_id = wh_id;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
