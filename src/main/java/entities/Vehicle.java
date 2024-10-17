package entities;

public class Vehicle {
    private final long _id;
    private final long dateMiseInService;
    private final String type;
    private long kilom;
    private long kilomReste;

    public Vehicle(long _id, long dateMiseInService, String type) {
        this._id = _id;
        this.dateMiseInService = dateMiseInService;
        this.type = type;
    }

    public Vehicle(long _id, long dateMiseInService, String type, long kilom, long kilomReste) {
        this._id = _id;
        this.dateMiseInService = dateMiseInService;
        this.type = type;
        this.kilom = kilom;
        this.kilomReste = kilomReste;
    }

    public long get_id() {
        return _id;
    }

    public long getDateMiseInService() {
        return dateMiseInService;
    }

    public String getType() {
        return type;
    }

    public long getKilom() {
        return kilom;
    }

    public long getKilomReste() {
        return kilomReste;
    }
}
