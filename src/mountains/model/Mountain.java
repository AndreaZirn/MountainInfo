package mountains.model;


import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.io.InputStream;


/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */

public class Mountain {

    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final DoubleProperty hoehe = new SimpleDoubleProperty();
    private final DoubleProperty dominanz = new SimpleDoubleProperty();
    private final DoubleProperty schartenhoehe = new SimpleDoubleProperty();
    private final StringProperty kmBis = new SimpleStringProperty();
    private final StringProperty mBis = new SimpleStringProperty();
    private final StringProperty typ = new SimpleStringProperty();
    private final StringProperty region = new SimpleStringProperty();
    private final StringProperty kanton = new SimpleStringProperty();
    private final StringProperty gebiet = new SimpleStringProperty();
    private final StringProperty bildunterschrift = new SimpleStringProperty();

    //ImageHandling
    private static final Image NO_PICTURE = new Image(Mountain.class.getResourceAsStream("/mountainpictures/noPicture.jpg"));
    private final ObjectProperty imageProperty = new SimpleObjectProperty<>();


    //Default Konstruktor
    public Mountain() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Mountain mountain = (Mountain) o;

        return getId() == mountain.getId();
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    //Reihenfolge nach Spalten in csv-Datei
    public Mountain(String[] line) {
        setId(Integer.valueOf(line[0]));
        setName(line[1]);
        setHoehe(Double.valueOf(line[2]));
        setTyp(line[3]);
        setRegion(line[4]);
        setKanton(line[5]); //TODO in mountain.csv ist diese Zeile leer. Evtl. Kantone einf�gen?
        setGebiet(line[6]);
        setDominanz(Double.valueOf(line[7]));
        setKmBis(line[8]);
        setSchartenhoehe(Double.valueOf(line[9]));
        setmBis(line[10]);
        setBildunterschrift(line[11]);

        //ImageHandling
        setImageProperty(getPicture());
    }

    //gleiche Reihenfolge wie oben bei "public Mountain (String..."
    public String infoAsLine() {
        StringBuffer info = new StringBuffer();
        info.append(getId() + ";");
        info.append(getName() + ";");
        info.append(getHoehe() + ";");
        info.append(getTyp() + ";");
        info.append(getRegion() + ";");
        info.append(getKanton() + ";");
        info.append(getGebiet() + ";");
        info.append(getDominanz() + ";");
        info.append(getKmBis() + ";");
        info.append(getSchartenhoehe() + ";");
        info.append(getmBis() + ";");
        info.append(getBildunterschrift() + ";");

        return info.toString();
    }

    public Image getPicture(){
        InputStream stream = Mountain.class.getResourceAsStream("/mountainpictures/" + getId() + "-1.jpg");

        return stream != null ? new Image(stream) : NO_PICTURE;
    }

    //getter und setter

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public double getHoehe() {
        return hoehe.get();
    }

    public DoubleProperty hoeheProperty() {
        return hoehe;
    }

    public void setHoehe(Double hoehe) {
        this.hoehe.set(hoehe);
    }

    public double getDominanz() {
        return dominanz.get();
    }

    public DoubleProperty dominanzProperty() {
        return dominanz;
    }

    public void setDominanz(double dominanz) {
        this.dominanz.set(dominanz);
    }

    public double getSchartenhoehe() {
        return schartenhoehe.get();
    }

    public DoubleProperty schartenhoeheProperty() {
        return schartenhoehe;
    }

    public void setSchartenhoehe(double schartenhoehe) {
        this.schartenhoehe.set(schartenhoehe);
    }

    public String getKmBis() {
        return kmBis.get();
    }

    public StringProperty kmBisProperty() {
        return kmBis;
    }

    public void setKmBis(String kmBis) {
        this.kmBis.set(kmBis);
    }

    public String getmBis() {
        return mBis.get();
    }

    public StringProperty mBisProperty() {
        return mBis;
    }

    public void setmBis(String mBis) {
        this.mBis.set(mBis);
    }

    public String getTyp() {
        return typ.get();
    }

    public StringProperty typProperty() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ.set(typ);
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getKanton() {
        return kanton.get();
    }

    public StringProperty kantonProperty() {
        return kanton;
    }

    public void setKanton(String kanton) {
        this.kanton.set(kanton);
    }

    public String getGebiet() {
        return gebiet.get();
    }

    public StringProperty gebietProperty() {
        return gebiet;
    }

    public void setGebiet(String gebiet) {
        this.gebiet.set(gebiet);
    }

    public String getBildunterschrift() {
        return bildunterschrift.get();
    }

    public StringProperty bildunterschriftProperty() {
        return bildunterschrift;
    }

    public void setBildunterschrift(String bildunterschrift) {
        this.bildunterschrift.set(bildunterschrift);
    }

    public Object getImageProperty() {
        return imageProperty.get();
    }

    public ObjectProperty imagePropertyProperty() {
        return imageProperty;
    }

    public void setImageProperty(Object imageProperty) {
        this.imageProperty.set(imageProperty);
    }

    public void setHoehe(double hoehe) {
        this.hoehe.set(hoehe);
    }

}
