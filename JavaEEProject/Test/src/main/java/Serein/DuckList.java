package Serein;

import java.util.List;

public class DuckList {

    private List<Duck> ducks;

    @Override
    public String toString() {
        return "DuckList{" +
                "ducks=" + ducks +
                '}';
    }

    public List<Duck> getDucks() {
        return ducks;
    }

    public void setDucks(List<Duck> ducks) {
        this.ducks = ducks;
    }


}
