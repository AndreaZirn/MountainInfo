package mountains.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by andreazirn on 28/12/15.
 */
public class LanguageSwitcher {

    enum Lang {DE, EN}

    enum MultilanguageText {
        WINDOW_TITLE("Schweizer Berge", "Swiss Mountains"),
        GERMAN_BUTTON_TEXT("Deutsch", "German"),
        ENGLISH_BUTTON_TEXT("Englisch", "English"),

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
        BILDUNT_TEXT("Bildunterschrift:", "Caption:");


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

    private final StringProperty windowTitle       = new SimpleStringProperty();

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

    public LanguageSwitcher() {
        setLanguage(Lang.DE);
    }

    public void setLanguage(Lang lang) {
        setWindowTitle(MultilanguageText.WINDOW_TITLE.getText(lang));
        setGermanButtonText(MultilanguageText.GERMAN_BUTTON_TEXT.getText(lang));
        setEnglishButtonText(MultilanguageText.ENGLISH_BUTTON_TEXT.getText(lang));

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
    }


    public String getWindowTitle() {
        return windowTitle.get();
    }

    public StringProperty windowTitleProperty() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle.set(windowTitle);
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
}
