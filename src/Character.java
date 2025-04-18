import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.ArrayList;

public class Character {
    private static final List<Character> characterArrayList = new ArrayList<>();
    @JsonProperty("Equipment")
    private final List<String> inventory = new ArrayList<>();
    @JsonIgnore
    private final CommandManager commandManager;
    @JsonProperty("ResourcePoints")
    private ResourcePoints resourcePoints;
    @JsonProperty("Position")
    private Position position;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("PC")
    private boolean pc;

    public Character() {
        this.commandManager = new CommandManager();
    }

    public Character(String name, Position position, ResourcePoints resourcePoints) {
        this.name = name;
        this.position = position;
        this.resourcePoints = resourcePoints;
        this.commandManager = new CommandManager();

        /* Commented out so this code will compile...
        Cell initialCell = MapGenerator.getCellAt(this.position.getX(), this.position.getY());
        if (initialCell != null && !initialCell.isOccupied()) {
            initialCell.occupyCell();
        }
         */

        characterArrayList.add(this);
    }

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public ResourcePoints getResourcePoints() { return this.resourcePoints; }

    public List<String> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return String.format("""
                Character{
                "pc"=%b
                "name"=%s
                "position"=%s
                "resourcePoints"=%s
                "inventory"=%s
                }
                """, this.pc, this.name, this.position, this.resourcePoints, this.inventory);
    }
}