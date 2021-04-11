package Animal;

import java.util.List;

public class DuckStore {

    private List<Duck> ducks;

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }

    @Override
    public String toString() {
        return "DuckStore{" +
                "ducks=" + ducks +
                '}';
    }
}
