package mountains.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Andrea Zirn and Irina Terribilini, oop2, Dieter Holz, HS2015
 */
public class LanguageSwitcher {

    public enum Lang {DE, EN}

    enum MultilanguageText {
        APPLICATION_TITLE("Schweizer Berge", "Swiss Mountains"),
        GERMAN_BUTTON_TEXT("Deutsch", "German"),
        ENGLISH_BUTTON_TEXT("Englisch", "English"),

        ADD_BUTTON_TEXT("Hinzufügen", "Add"),
        SAVE_BUTTON_TEXT("Sichern", "Save"),
        DELETE_BUTTON_TEXT("Löschen", "Delete"),
        UNDO_BUTTON_TEXT("Zurücksetzen", "Undo"),
        REDO_BUTTON_TEXT("Wiederholen", "Redo"),

        NAME_TEXT("Name:", "Name:"),
        HOEHE_TEXT("Höhe:", "Height:"),
        DOMINANZ_TEXT("Dominanz:", "Topographic isolation:"),
        KM_TEXT("Km bis:", "Km to:"),
        M_TEXT("M bis:", "M to:"),
        SCHARTEN_TEXT("Schartenhöhe:", "Topographic prominence:"),
        TYP_TEXT("Typ:", "Type:"),
        REGION_TEXT("Region:", "Region:"),
        KANTON_TEXT("Kanton:", "Canton:"),
        GEBIET_TEXT("Region:", "Area:"),
        BILDUNT_TEXT("Bildunterschrift:", "Caption:"),

        ID_COLUMN_TEXT("ID", "ID"),
        NAME_COLUMN_TEXT("NAME", "NAME"),
        HOEHE_COLUMN_TEXT("HÖHE", "HEIGHT"),

        SEARCH_TEXT("Suche:", "Search:");


        private final String germanLabel;
        private final String englishLabel;

        MultilanguageText(String germanLabel, String englishLabel){
            this.germanLabel = germanLabel;
            this.englishLabel = englishLabel;
        }

        public String getGermanLabel() {
            return germanLabel;
        }

        public String getEnglishLabel() {
            return englishLabel;
        }


        public String getText(Lang lang){
            switch (lang){
                case DE:
                    return getGermanLabel();
                case EN:
                    return getEnglishLabel();
                default:
                    return getGermanLabel();
            }
        }
    }

    private final StringProperty applicationTitle       = new SimpleStringProperty();

    private final StringProperty nameLabel = new SimpleStringProperty();
    private final StringProperty hoeheLabel = new SimpleStringProperty();
    private final StringProperty dominanzLabel = new SimpleStringProperty();
    private final StringProperty kmBisLabel = new SimpleStringProperty();
    private final StringProperty mBisLabel = new SimpleStringProperty();
    private final StringProperty schartenhoeheLabel = new SimpleStringProperty();
    private final StringProperty typLabel = new SimpleStringProperty();
    private final StringProperty regionLabel = new SimpleStringProperty();
    private final StringProperty kantonLabel = new SimpleStringProperty();
    private final StringProperty gebietLabel = new SimpleStringProperty();
    private final StringProperty bildunterschriftLabel = new SimpleStringProperty();

    private final StringProperty germanButtonText  = new SimpleStringProperty();
    private final StringProperty englishButtonText = new SimpleStringProperty();
    private final StringProperty addButtonText = new SimpleStringProperty();
    private final StringProperty saveButtonText = new SimpleStringProperty();
    private final StringProperty deleteButtonText = new SimpleStringProperty();
    private final StringProperty undoButtonText = new SimpleStringProperty();
    private final StringProperty redoButtonText = new SimpleStringProperty();

    private final StringProperty idColumnText = new SimpleStringProperty();
    private final StringProperty nameColumnText = new SimpleStringProperty();
    private final StringProperty hoeheColumnText = new SimpleStringProperty();

    private final StringProperty searchLabel = new SimpleStringProperty();


    public LanguageSwitcher() {
        setLanguage(Lang.DE);
    }

    public void setLanguage(Lang lang) {
        setApplicationTitle(MultilanguageText.APPLICATION_TITLE.getText(lang));

        setGermanButtonText(MultilanguageText.GERMAN_BUTTON_TEXT.getText(lang));
        setEnglishButtonText(MultilanguageText.ENGLISH_BUTTON_TEXT.getText(lang));
        setAddButtonText(MultilanguageText.ADD_BUTTON_TEXT.getText(lang));
        setSaveButtonText(MultilanguageText.SAVE_BUTTON_TEXT.getText(lang));
        setDeleteButtonText(MultilanguageText.DELETE_BUTTON_TEXT.getText(lang));
        setUndoButtonText(MultilanguageText.UNDO_BUTTON_TEXT.getText(lang));
        setRedoButtonText(MultilanguageText.REDO_BUTTON_TEXT.getText(lang));

        setNameLabel(MultilanguageText.NAME_TEXT.getText(lang));
        setHoeheLabel(MultilanguageText.HOEHE_TEXT.getText(lang));
        setDominanzLabel(MultilanguageText.DOMINANZ_TEXT.getText(lang));
        setKmBisLabel(MultilanguageText.KM_TEXT.getText(lang));
        setmBisLabel(MultilanguageText.M_TEXT.getText(lang));
        setSchartenhoeheLabel(MultilanguageText.SCHARTEN_TEXT.getText(lang));
        setTypLabel(MultilanguageText.TYP_TEXT.getText(lang));
        setRegionLabel(MultilanguageText.REGION_TEXT.getText(lang));
        setKantonLabel(MultilanguageText.KANTON_TEXT.getText(lang));
        setGebietLabel(MultilanguageText.GEBIET_TEXT.getText(lang));
        setBildunterschriftLabel(MultilanguageText.BILDUNT_TEXT.getText(lang));

        setIdColumnText(MultilanguageText.ID_COLUMN_TEXT.getText(lang));
        setNameColumnText(MultilanguageText.NAME_COLUMN_TEXT.getText(lang));
        setHoeheColumnText(MultilanguageText.HOEHE_COLUMN_TEXT.getText(lang));

        setSearchLabel(MultilanguageText.SEARCH_TEXT.getText(lang));

    }


    public String getApplicationTitle() {
        return applicationTitle.get();
    }

    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }

    public void setApplicationTitle(String windowTitle) {
        this.applicationTitle.set(windowTitle);
    }

    public String getNameLabel() {
        return nameLabel.get();
    }

    public StringProperty nameLabelProperty() {
        return nameLabel;
    }

    public void setNameLabel(String nameLabel) {
        this.nameLabel.set(nameLabel);
    }

    public String getHoeheLabel() {
        return hoeheLabel.get();
    }

    public StringProperty hoeheLabelProperty() {
        return hoeheLabel;
    }

    public void setHoeheLabel(String hoeheLabel) {
        this.hoeheLabel.set(hoeheLabel);
    }

    public String getDominanzLabel() {
        return dominanzLabel.get();
    }

    public StringProperty dominanzLabelProperty() {
        return dominanzLabel;
    }

    public void setDominanzLabel(String dominanzLabel) {
        this.dominanzLabel.set(dominanzLabel);
    }

    public String getKmBisLabel() {
        return kmBisLabel.get();
    }

    public StringProperty kmBisLabelProperty() {
        return kmBisLabel;
    }

    public void setKmBisLabel(String kmBisLabel) {
        this.kmBisLabel.set(kmBisLabel);
    }

    public String getmBisLabel() {
        return mBisLabel.get();
    }

    public StringProperty mBisLabelProperty() {
        return mBisLabel;
    }

    public void setmBisLabel(String mBisLabel) {
        this.mBisLabel.set(mBisLabel);
    }

    public String getSchartenhoeheLabel() {
        return schartenhoeheLabel.get();
    }

    public StringProperty schartenhoeheLabelProperty() {
        return schartenhoeheLabel;
    }

    public void setSchartenhoeheLabel(String schartenhoeheLabel) {
        this.schartenhoeheLabel.set(schartenhoeheLabel);
    }

    public String getTypLabel() {
        return typLabel.get();
    }

    public StringProperty typLabelProperty() {
        return typLabel;
    }

    public void setTypLabel(String typLabel) {
        this.typLabel.set(typLabel);
    }

    public String getRegionLabel() {
        return regionLabel.get();
    }

    public StringProperty regionLabelProperty() {
        return regionLabel;
    }

    public void setRegionLabel(String regionLabel) {
        this.regionLabel.set(regionLabel);
    }

    public String getKantonLabel() {
        return kantonLabel.get();
    }

    public StringProperty kantonLabelProperty() {
        return kantonLabel;
    }

    public void setKantonLabel(String kantonLabel) {
        this.kantonLabel.set(kantonLabel);
    }

    public String getGebietLabel() {
        return gebietLabel.get();
    }

    public StringProperty gebietLabelProperty() {
        return gebietLabel;
    }

    public void setGebietLabel(String gebietLabel) {
        this.gebietLabel.set(gebietLabel);
    }

    public String getBildunterschriftLabel() {
        return bildunterschriftLabel.get();
    }

    public StringProperty bildunterschriftLabelProperty() {
        return bildunterschriftLabel;
    }

    public void setBildunterschriftLabel(String bildunterschriftLabel) {
        this.bildunterschriftLabel.set(bildunterschriftLabel);
    }

    public String getGermanButtonText() {
        return germanButtonText.get();
    }

    public StringProperty germanButtonTextProperty() {
        return germanButtonText;
    }

    public void setGermanButtonText(String germanButtonText) {
        this.germanButtonText.set(germanButtonText);
    }

    public String getEnglishButtonText() {
        return englishButtonText.get();
    }

    public StringProperty englishButtonTextProperty() {
        return englishButtonText;
    }

    public void setEnglishButtonText(String englishButtonText) {
        this.englishButtonText.set(englishButtonText);
    }

    public String getAddButtonText() {
        return addButtonText.get();
    }

    public StringProperty addButtonTextProperty() {
        return addButtonText;
    }

    public void setAddButtonText(String addButtonText) {
        this.addButtonText.set(addButtonText);
    }

    public String getSaveButtonText() {
        return saveButtonText.get();
    }

    public StringProperty saveButtonTextProperty() {
        return saveButtonText;
    }

    public void setSaveButtonText(String saveButtonText) {
        this.saveButtonText.set(saveButtonText);
    }

    public String getDeleteButtonText() {
        return deleteButtonText.get();
    }

    public StringProperty deleteButtonTextProperty() {
        return deleteButtonText;
    }

    public void setDeleteButtonText(String deleteButtonText) {
        this.deleteButtonText.set(deleteButtonText);
    }

    public String getUndoButtonText() {
        return undoButtonText.get();
    }

    public StringProperty undoButtonTextProperty() {
        return undoButtonText;
    }

    public void setUndoButtonText(String undoButtonText) {
        this.undoButtonText.set(undoButtonText);
    }

    public String getRedoButtonText() {
        return redoButtonText.get();
    }

    public StringProperty redoButtonTextProperty() {
        return redoButtonText;
    }

    public void setRedoButtonText(String redoButtonText) {
        this.redoButtonText.set(redoButtonText);
    }

    public String getIdColumnText() {
        return idColumnText.get();
    }

    public StringProperty idColumnTextProperty() {
        return idColumnText;
    }

    public void setIdColumnText(String idColumnText) {
        this.idColumnText.set(idColumnText);
    }

    public String getNameColumnText() {
        return nameColumnText.get();
    }

    public StringProperty nameColumnTextProperty() {
        return nameColumnText;
    }

    public void setNameColumnText(String nameColumnText) {
        this.nameColumnText.set(nameColumnText);
    }

    public String getHoeheColumnText() {
        return hoeheColumnText.get();
    }

    public StringProperty hoeheColumnTextProperty() {
        return hoeheColumnText;
    }

    public void setHoeheColumnText(String hoeheColumnText) {
        this.hoeheColumnText.set(hoeheColumnText);
    }

    public String getSearchLabel() {
        return searchLabel.get();
    }

    public StringProperty searchLabelProperty() {
        return searchLabel;
    }

    public void setSearchLabel(String searchLabel) {
        this.searchLabel.set(searchLabel);
    }
}
