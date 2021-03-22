package org.StatePattern;

import org.Main.Main;

public class ShowMap extends ShowMapAbstract {

    GameEngine1 d_ge;
    Main d_m;

    ShowMap(GameEngine1 p_ge) {
        super(p_ge);
        this.d_ge = p_ge;
    }

    @Override
    public void ShowMaps() throws Exception {
        d_m = new Main();
        d_m.mapShow();
        d_ge.setPhase(this);

    }

    public void next(){
        d_ge.setPhase(new MapEditor(d_ge));
    }


}
