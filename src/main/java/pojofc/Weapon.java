package pojofc;

public class Weapon {
    private Integer weaponid;
    private String weaponname;
    private String launchplace;
    private Integer range;
    private Integer amount;

    public Integer getWeaponid() {
        return weaponid;
    }

    public void setWeaponid(Integer weaponid) {
        this.weaponid = weaponid;
    }

    public String getWeaponname() {
        return weaponname;
    }

    public void setWeaponname(String weaponname) {
        this.weaponname = weaponname;
    }

    public String getLaunchplace() {
        return launchplace;
    }

    public void setLaunchplace(String launchplace) {
        this.launchplace = launchplace;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponid=" + weaponid +
                ", weaponname='" + weaponname + '\'' +
                ", launchplace='" + launchplace + '\'' +
                ", range=" + range +
                ", amount=" + amount +
                '}';
    }
}
