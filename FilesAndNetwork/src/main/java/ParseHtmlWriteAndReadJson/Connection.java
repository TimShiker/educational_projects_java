package ParseHtmlWriteAndReadJson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Connection {

    private String numberLine;
    private String nameStation;

    public Connection(String numberLine, String nameStation){
        this.numberLine = numberLine;
        this.nameStation = nameStation;
    }

    public String getLine() {
        return numberLine;
    }

    public String getStation() {
        return nameStation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Connection)) return false;
        Connection that = (Connection) o;
        return Objects.equals(numberLine, that.numberLine) && Objects.equals(nameStation, that.nameStation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberLine, nameStation);
    }

}
