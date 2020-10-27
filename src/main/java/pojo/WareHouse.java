package pojo;

public class WareHouse {
    private int ware_id;//仓库编号
    private String address;//仓库地址
    private String name;//仓库名称

    public WareHouse() {
    }

    public WareHouse(int ware_id, String address, String name) {
        this.ware_id= ware_id;
        this.address = address;
        this.name = name;
    }

    @Override
    public String toString() {
        return "WareHouse{" +
                "ware_id=" + ware_id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getWare_id() {
        return ware_id;
    }

    public void setWare_id(int ware_id) {
        this.ware_id = ware_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
