import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class Character {
    @JsonProperty("PC")
    private boolean pc;
    @JsonProperty("Name")
    private String name;
    private int hp;
    private int mp;
    private int ap;
    private int xp;
    private int sp;
    @JsonProperty("Position")
    private Position position;
    @JsonProperty("Equipment")
    private List<String> equipment;

    // Getters and setters
    public boolean isPc() {
        return pc;
    }

    public void setPc(boolean pc) {
        this.pc = pc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Character{" +
                "pc=" + pc +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", mp=" + mp +
                ", ap=" + ap +
                ", xp=" + xp +
                ", sp=" + sp +
                ", position=" + position +
                ", equipment=" + equipment +
                '}';
    }
}