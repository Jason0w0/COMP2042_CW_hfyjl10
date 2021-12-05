package model;

public class HomeMenuModel {

    private boolean startClicked;
    private boolean menuClicked;

    public HomeMenuModel() {}

    public boolean isStartClicked() {
        return startClicked;
    }

    public void setStartClicked(boolean startClicked) {
        this.startClicked = startClicked;
    }

    public boolean isMenuClicked() {
        return menuClicked;
    }

    public void setMenuClicked(boolean menuClicked) {
        this.menuClicked = menuClicked;
    }
}
