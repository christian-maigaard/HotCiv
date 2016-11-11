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
  //which player has the turn, RED is set to begin
  Player whosTurn = RED;
  int age = 4000;

  public Tile getTileAt( Position p ) {

    TileImpl Ocean = new TileImpl();

    //String s = Ocean.getTypeString();
    //System.out.print(s);

    return Ocean;
  }
  public Unit getUnitAt( Position p ) { return null; }
  public City getCityAt( Position p ) { return null; }

  //returns the variable whosTurn
  public Player getPlayerInTurn() { return whosTurn; }

  public Player getWinner() {
    if (getAge()==3000){
      return RED;
    }
    else{
      return null;
    }

  }

  public int getAge() { return age; }
  public boolean moveUnit( Position from, Position to ) {
    return false;
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
  public void changeProductionInCityAt( Position p, String unitType ) {}
  public void performUnitActionAt( Position p ) {}
}
