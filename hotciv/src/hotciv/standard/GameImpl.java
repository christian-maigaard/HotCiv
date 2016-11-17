package hotciv.standard;

import hotciv.framework.*;

import static hotciv.framework.Player.*;

/** Skeleton implementation of HotCiv.
 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Department of Computer Science
     Aarhus University
   
   Please visit http://www.baerbak.com/ for further information.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

public class GameImpl implements Game {
  //@param p to enable access to the positions
  public static Position p;

  //which player has the turn, RED is set to begin
  Player whosTurn = RED;
  //Starting year
  int age = 4000;
  private World world = new WorldImpl();

  //Gets a new tile terrainTile, and returns it.
  public Tile getTileAt( Position p ) {
    this.p = p;
    Tile tile = WorldImpl.worldTileMap.get(p);
    return tile;
  }
  //Returns a unit at position p
  public Unit getUnitAt( Position p ) {
    return WorldImpl.unitMap.get(p);
  }
  //Returns cityPosition at Position p
  public CityImpl getCityAt( Position p ) {
    return WorldImpl.cityMap.get(p);
  }

  //returns the variable whosTurn
  public Player getPlayerInTurn() { return   whosTurn; }

  //returns the winning player, which is RED at year 3000BC
  public Player getWinner() {
    if (getAge()==3000){
      return RED;
    }
    else{
      return null;
    }

  }

  //returns the current year of the game (age varaible)
  public int getAge() { return age; }

  //Returns true and removes the unit from current position, and adds the unit to the wanted position.
  //Unless the wanted position is either a mountain tile or ocean tile.
  public boolean moveUnit( Position from, Position to ) {

    //Saving the type of tile in the @param tileType
    String tileType = WorldImpl.worldTileMap.get(to).getTypeString();
    if(tileType.equals(GameConstants.MOUNTAINS)) {return false;}
    else if(tileType.equals(GameConstants.OCEANS)){return false;}
    else if(WorldImpl.unitMap.get(to) != null){
      Player thisUnitOwner = WorldImpl.unitMap.get(from).getOwner();
      Player otherUnitOwner = WorldImpl.unitMap.get(to).getOwner();
      if(!thisUnitOwner.equals(otherUnitOwner)){
        Unit unit = WorldImpl.unitMap.get(from);
        WorldImpl.unitMap.remove(from);
        WorldImpl.unitMap.put(to, unit);
        return true;
      }
      return false;}
    else{
      Unit unit = WorldImpl.unitMap.get(from);
      WorldImpl.unitMap.remove(from);
      WorldImpl.unitMap.put(to, unit);
      return true;
    }
  }

  //at the end of turn switch turn to the correct player and set age to 100
  public void endOfTurn() {

    if(whosTurn == BLUE){
      whosTurn = RED;
      age += -100;
    }
    else{
      whosTurn = BLUE;
    }
  }

  public void changeWorkForceFocusInCityAt( Position p, String balance ) {}
  public void changeProductionInCityAt( Position p, String unitType ) {
    CityImpl city = getCityAt(p);
    city.changeProduction(unitType);
  }
  public void performUnitActionAt( Position p ) {}
}
