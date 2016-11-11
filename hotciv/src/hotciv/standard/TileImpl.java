package hotciv.standard;

import hotciv.framework.Position;
import hotciv.framework.Tile;

/**
 * Created by Christian on 11/11/2016.
 */
public class TileImpl implements Tile{

    Position oceanP = new Position(1,0);
    Position mountainP = new Position(2,2);
    Position hillsP = new Position(0,1);
    Position p = GameImpl.p;

    //The tile has to be either ocean or mountain, an if statement is used to differenciete.
    @Override
    public String getTypeString() {
        if(oceanP.equals(p)) {
            return "ocean";
        }else if(mountainP.equals(p)){
            return "mountain";
        }else if(hillsP.equals(p)){
            return "hills";
        }else{
            return "plains";
        }
    }
}