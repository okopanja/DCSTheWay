package main.Waypoints.PlanesCommands;

import main.Utils.CoordinateUtils;
import main.Utils.UnitConvertorUtils;
import main.models.DMMCoordinate;
import main.models.Hemisphere;
import main.models.Point;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Ka50_3 {
    public static JSONArray getCommands(List<Point> coords, BigDecimal selfX, BigDecimal selfZ, JSONObject aircraftSpecificData) {
        /*
           button list, all are device 20
           Waypoint button     3011
           Enter             3018
           PVI mode ENT     3026 rotary value 0.2
           PVI Mode OPER     3026 rotary value 0.3

           0/+     3001 +for north and east
           1/-     3002 -for south and west
           2       3003
           3       3004
           4       3005
           5       3006
           6       3007
           7       3008
           8       3009
           9       3010

           */

        JSONArray commandArray = new JSONArray();

        //PVI to Entry mode
        commandArray.put(new JSONObject().put("device", "20").put("code", "3026").put("delay", "10").put("activate", "0.2").put("addDepress", "false"));
        //Press waypoint button
        commandArray.put(new JSONObject().put("device", "20").put("code", "3011").put("delay", "0").put("activate", "1").put("addDepress", "true"));
        for(int i=1; i<= coords.size(); i++){
            //Press the corresponding waypoint number
            switch (i){
                case 1:
                    commandArray.put(new JSONObject().put("device", "20").put("code", "3002").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                    break;
                case 2:
                    commandArray.put(new JSONObject().put("device", "20").put("code", "3003").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                    break;
                case 3:
                    commandArray.put(new JSONObject().put("device", "20").put("code", "3004").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                    break;
                case 4:
                    commandArray.put(new JSONObject().put("device", "20").put("code", "3005").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                    break;
                case 5:
                    commandArray.put(new JSONObject().put("device", "20").put("code", "3006").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                    break;
                case 6:
                    commandArray.put(new JSONObject().put("device", "20").put("code", "3007").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                    break;
            }
            //Check if latitude is N or S
            if (coords.get(i-1).getLatitudeHemisphere() == Hemisphere.NORTH) {
                //press 0/+ for North
                commandArray.put(new JSONObject().put("device", "20").put("code", "3001").put("delay", "0").put("activate", "1").put("addDepress", "true"));
            } else {
                //press 1/- for South
                commandArray.put(new JSONObject().put("device", "20").put("code", "3002").put("delay", "0").put("activate", "1").put("addDepress", "true"));
            }
            //Start typing latitude
            for(char digit:coords.get(i-1).getLatitude().toCharArray()){
                switch (digit){
                    case '1':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3002").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '2':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3003").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '3':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3004").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '4':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3005").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '5':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3006").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '6':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3007").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '7':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3008").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '8':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3009").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '9':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3010").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '0':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3001").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                }
            }
            //Check if longitude is E or W
            if (coords.get(i-1).getLongitudeHemisphere() == Hemisphere.EAST) {
                //press 0/+ for East
                commandArray.put(new JSONObject().put("device", "20").put("code", "3001").put("delay", "0").put("activate", "1").put("addDepress", "true"));
            } else {
                //press 1/- for West
                commandArray.put(new JSONObject().put("device", "20").put("code", "3002").put("delay", "0").put("activate", "1").put("addDepress", "true"));
            }
            //Start typing longitude
            for(char digit:coords.get(i-1).getLongitude().toCharArray()){
                switch (digit){
                    case '1':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3002").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '2':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3003").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '3':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3004").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '4':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3005").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '5':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3006").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '6':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3007").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '7':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3008").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '8':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3009").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '9':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3010").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                    case '0':
                        commandArray.put(new JSONObject().put("device", "20").put("code", "3001").put("delay", "0").put("activate", "1").put("addDepress", "true"));
                        break;
                }
            }
            //Press Enter
            commandArray.put(new JSONObject().put("device", "20").put("code", "3018").put("delay", "0").put("activate", "1").put("addDepress", "true"));
        }
        //PVI to OPER
        commandArray.put(new JSONObject().put("device", "20").put("code", "3026").put("delay", "20").put("activate", "0.3").put("addDepress", "false"));
        
        int i = 0;
        // PVI: enter each waypoint as steer point
        for (i = 0; i < coords.size(); i++) {
            // PVI: select steer point
            commandArray.put(new JSONObject().put("device", "20").put("code", Integer.toString(3002 + i)).put("delay", "20").put("activate", "1").put("addDepress", "true"));
            // PVI: conform steer point
            commandArray.put(new JSONObject().put("device", "20").put("code", "3018").put("delay", "0").put("activate", "10").put("addDepress", "true"));
        }
        // PVI: activate steerpoint 1
        commandArray.put(new JSONObject().put("device", "20").put("code", Integer.toString(3002)).put("delay", "10").put("activate", "1").put("addDepress", "true"));
        //Press waypoint button
        commandArray.put(new JSONObject().put("device", "20").put("code", "3011").put("delay", "10").put("activate", "1").put("addDepress", "true"));
        if (i < 6) {
            //Press waypoint button
            commandArray.put(new JSONObject().put("device", "20").put("code", "3011").put("delay", "10").put("activate", "1").put("addDepress", "true"));
        }
        // PVI: activate steerpoint 1
        commandArray.put(new JSONObject().put("device", "20").put("code", Integer.toString(3002)).put("delay", "10").put("activate", "1").put("addDepress", "true"));

        // Place ABRIS into MENU mode, no matter in which mode it is currently in
        abrisCycleToMenuMode(commandArray, aircraftSpecificData);
        // Workaround ABRIS/SNS drift (this occurs only on the first usage, but for simplicity we will repeat it every time)
        abrisWorkaroundInitialSNSDrift(commandArray, selfX, selfZ);
        // Make sure there is no route loaded
        abrisUnloadRoute(commandArray);
        // Start entering
        abrisStartRouteEntry(commandArray);
        // Enter waypoints
        abrisEnterRouteWaypoints(coords, selfX, selfZ, commandArray);
        // Complete and store route
        abrisCompleteRouteEntry(commandArray);

        return commandArray;
    }

    private static void abrisCycleToMenuMode(JSONArray commandArray, JSONObject aircraftSpecificData) {
        // we need to know how many times the button 5 needs to be pressed to get to the MENU mode
        int cycleNumber = determineNumberOfModePresses(aircraftSpecificData);
        System.out.println("Cycle number: " + cycleNumber);
        for (int i = 0; i < cycleNumber; i++) 
            commandArray.put(new JSONObject().put("device", "09").put("code", "3005").put("delay", "10").put("activate", "1").put("addDepress", "true"));
    }

    private static int determineNumberOfModePresses(JSONObject aircraftSpecificData) {
        // this function is based on Ka-50/Cockpit/Scripts/ABRIS/ABRIS_init.lua which contains definition of mode structure. Please refer to line containing: ABRIS modes
        // please note that DCS actually reduces each value by 1, despite the definitions in the file
        JSONObject modeStruct = aircraftSpecificData.getJSONObject("ABRIS").getJSONObject("mode");
        int master = modeStruct.getInt("master");
        int level_2 = modeStruct.getInt("level_2");
        int level_3 = modeStruct.getInt("level_3");
        int level_4 = modeStruct.getInt("level_4");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(master);
        stringBuilder.append(level_2);
        stringBuilder.append(level_3);
        stringBuilder.append(level_4);
        String mode = stringBuilder.toString();
        System.out.println("Found: '" + mode + "'");

        if (mode.equals("0000"))
            return 0;
        if(mode.equals("9000"))
            return 1;
        // if already in men just cycle 
        if(mode.startsWith("5") == false)
            return 4;
        if(mode.equals("5000"))
            return 4;
        if(mode.equals("5500"))
            return 3;
        if(mode.equals("5100"))
            return 2;
        if(mode.equals("5400"))
            return 5;
        if(mode.equals("5310"))
            return 5;
        if(mode.equals("5200"))
            return 5;
        if(mode.equals("5430"))
            return 5;
        if(mode.equals("5240"))
            return 5;

        System.out.println("Unprocessed: " + mode);
        return 5;
    }

    private static void abrisWorkaroundInitialSNSDrift(JSONArray commandArray, BigDecimal selfX, BigDecimal selfZ) {
        // on the first route entry, initial point can be set to one of the following cases:
        // 1. center of map, e.g. in case of Caucasus, the center is on Crimea
        // 2. early SNS results that may drift few km from actual position
        // 3. correct position (rarely)
        // To deal with this method will:
        // 1. enter first a dummy navpoint consisting of a single point (current location)
        // 2. initiate navigation
        // 3. return the ABRIS to MENU mode
        // Starting from this point ABRIS will not drift anymore and real route will be entered
        ArrayList<Point> dummy = new ArrayList<Point>();
        dummy.add(new Point(null, null, null, null, null, selfX, selfZ));
        abrisUnloadRoute(commandArray);
        abrisStartRouteEntry(commandArray);
        abrisEnterRouteWaypoints(dummy, selfX, selfZ, commandArray);
        abrisCompleteRouteEntry(commandArray);
        for(int i = 0; i < 4; i++ )
            commandArray.put(new JSONObject().put("device", "09").put("code", "3005").put("delay", "0").put("activate", "1").put("addDepress", "true"));
    }
    
    private static void abrisEnterRouteWaypoints(List<Point> coords, BigDecimal selfX, BigDecimal selfZ, JSONArray commandArray) {
        //waypoints are entered relative to the last waypoint. Initially we start with aircraft current location
        Point priorCoord = new Point(null, null, null, null, null, selfX, selfZ);
        // first waypoint is already marked at our current location
        // that was easy: complete entry of current location
        // abrisStartNextWaypoint(commandArray);
        // abrisStartNextWaypoint(commandArray);
        System.out.println("self.LocationX: " + selfX + " , self.LocationZ: " + selfZ);
        for(int i = 0; i < coords.size(); i++) {
            Point coord = coords.get(i);
            System.out.println(coord);
            if (i == 0)
                abrisAddWaypoint(commandArray, coord, priorCoord, false);
            else
                abrisAddWaypoint(commandArray, coord, priorCoord, true);
            priorCoord = coord;
        }
    }

    private static void abrisStartNextWaypoint(JSONArray commandArray) {
        // ABRIS: edit
        commandArray.put(new JSONObject().put("device", "09").put("code", "3001").put("delay", "1").put("activate", "1").put("addDepress", "true"));
        // ABRIS: add
        commandArray.put(new JSONObject().put("device", "09").put("code", "3001").put("delay", "1").put("activate", "1").put("addDepress", "true"));
    }

    private static void abrisAddWaypoint(JSONArray commandArray, Point coord, Point priorCoord, boolean needsEditInsert) {
        // Calculate deltaX and deltaY to the prior coordinate
        BigDecimal deltaX = coord.getX().subtract(priorCoord.getX());
        BigDecimal deltaZ = coord.getZ().subtract(priorCoord.getZ());
        System.out.println("DeltaX: " + deltaX + " DeltaZ: " + deltaZ);

        // ABRIS: start entry of waypoint, by default Z coordinate (west -> east) is the first 
        if(needsEditInsert)
            abrisStartNextWaypoint(commandArray);
        
        // determine the smallest bounding Z range
        ABRISZoomRange range = findSmallestBoundingZRange(priorCoord, coord);    
        // ABRIS: zoom to the bounding range
        abrisZoomToRange(commandArray, range.getLevel());
        // calculate number of dial rotations
        BigDecimal rotationsZ = range.toRotationsZ(deltaZ);
        System.out.println("Level: " + range.getLevel() + " Z rotations: " + rotationsZ);
        // ABRIS: rotate dial for Z
        commandArray.put(new JSONObject().put("device", "09").put("code", "3006").put("delay", "1").put("activate", rotationsZ.toPlainString()).put("addDepress", "true"));

        // ABRIS: switch to X
        commandArray.put(new JSONObject().put("device", "09").put("code", "3007").put("delay", "1").put("activate", "1").put("addDepress", "true"));

        // determine the smallest bounding X range
        range = findSmallestBoundingXRange(priorCoord, coord);
        // ABRIS: zoom to the bounding range
        abrisZoomToRange(commandArray, range.getLevel());
        // calculate number of dial rotations
        BigDecimal rotationsX = range.toRotationsX(deltaX);
        System.out.println("Level: " + range.getLevel() + " X revolutions: " + rotationsX);
        // ABRIS: rotate dial for X
        commandArray.put(new JSONObject().put("device", "09").put("code", "3006").put("delay", "1").put("activate", rotationsX.toPlainString()).put("addDepress", "true"));

        // ABRIS: complete entry of waypoint
        abrisStartNextWaypoint(commandArray);
    }

    private static void abrisCompleteRouteEntry(JSONArray commandArray) {
        // ABRIS: switch back to PLAN
        commandArray.put(new JSONObject().put("device", "09").put("code", "3005").put("delay", "1").put("activate", "1").put("addDepress", "true"));
        // ABRIS: activate the route
        commandArray.put(new JSONObject().put("device", "09").put("code", "3004").put("delay", "1").put("activate", "1").put("addDepress", "true"));
    }

    private static void abrisStartRouteEntry(JSONArray commandArray) {
        // ABRIS: plan mode
        commandArray.put(new JSONObject().put("device", "09").put("code", "3003").put("delay", "0").put("activate", "1").put("addDepress", "true"));
        // ABRIS: activate EDIT menu
        commandArray.put(new JSONObject().put("device", "09").put("code", "3002").put("delay", "0").put("activate", "1").put("addDepress", "true"));
        // ABRIS: zoom in to maximum to make sure we start with known zoom level 0
        abrisFullZoom(commandArray);
    }

    private static void abrisZoomIn(JSONArray commandArray, int relativeZoomLevel) {
        // negative zoom in value: ignore
        if (relativeZoomLevel < 0)
            return;
        // zoom in of the defined number of levels
        for(int i = 0; i < relativeZoomLevel; i++)
            commandArray.put(new JSONObject().put("device", "09").put("code", "3003").put("delay", "1").put("activate", "1").put("addDepress", "true"));
        zoomLevel = zoomLevel - relativeZoomLevel;
    }

    private static void abrisZoomOut(JSONArray commandArray, int relativeZoomLevel) {
        // negative zoom out value: ignore
        if (relativeZoomLevel < 0)
            return;
        // zoom out of the defined number of levels
        for(int i = 0; i < relativeZoomLevel; i++)
            commandArray.put(new JSONObject().put("device", "09").put("code", "3004").put("delay", "1").put("activate", "1").put("addDepress", "true"));
        zoomLevel = java.lang.Math.min(zoomLevel + relativeZoomLevel, Ka50_3.ranges.size());
    }

    private static void abrisZoomToRange(JSONArray commandArray, int level) {
        // calculate difference between desired and current zoom
        int delta = level - zoomLevel;
        // zoom in or zoom out
        if (delta < 0)
            abrisZoomIn(commandArray, -delta);
        else if (delta > 0){
            abrisZoomOut(commandArray, delta);
        }
    }

    private static void abrisFullZoom(JSONArray commandArray) {
        abrisZoomIn(commandArray, Ka50_3.ranges.size());
        zoomLevel = 0;
    }

    private static ABRISZoomRange findSmallestBoundingXRange(Point current, Point next) {
        // for precision we search for the smallest possible range where X coordinates of both points are. Otherwise ABRIS will misbehave!
        for(ABRISZoomRange range: ranges) {
            if(range.areBothPointsWithinXRange(current, next))
                return range;
        }
        return null;
    }

    private static ABRISZoomRange findSmallestBoundingZRange(Point current, Point next) {
        // for precision we search for the smallest possible range where Z coordinates of both points are. Otherwise ABRIS will misbehave!
        for(ABRISZoomRange range: ranges) {
            if(range.areBothPointsWithinZRange(current, next))
                return range;
        }
        return null;
    }

    private static void abrisUnloadRoute(JSONArray commandArray) {
        // ABRIS: plan mode
        commandArray.put(new JSONObject().put("device", "09").put("code", "3003").put("delay", "0").put("activate", "1").put("addDepress", "true"));
        // ABRIS: activate select menu
        commandArray.put(new JSONObject().put("device", "09").put("code", "3001").put("delay", "0").put("activate", "1").put("addDepress", "true"));
        // ABRIS: select menu move down 2 entries (this will be split into 4 increments of 0.4)
        for(int i = 0; i < 4; i++)
            commandArray.put(new JSONObject().put("device", "09").put("code", "3006").put("delay", "0").put("activate", "0.4").put("addDepress", "false"));
        // ABRIS: activate unload option
        commandArray.put(new JSONObject().put("device", "09").put("code", "3001").put("delay", "0").put("activate", "1").put("addDepress", "true"));
        // ABRIS: activate select menu again
        commandArray.put(new JSONObject().put("device", "09").put("code", "3001").put("delay", "0").put("activate", "1").put("addDepress", "true"));
        // now move back 2 entries up
        for(int i = 0; i < 4; i++)
            commandArray.put(new JSONObject().put("device", "09").put("code", "3006").put("delay", "0").put("activate", "-0.4").put("addDepress", "false"));
        // now switch to menu mode again
        commandArray.put(new JSONObject().put("device", "09").put("code", "3005").put("delay", "0").put("activate", "1").put("addDepress", "true"));
    }

    public static List<Point> getCoords(List<Point> dcsPoints) {
        List<Point> Ka50Points = new ArrayList<>();
        for (Point dcsPoint : dcsPoints) {
            BigDecimal dcsLat = new BigDecimal(dcsPoint.getLatitude());
            BigDecimal dcsLong = new BigDecimal(dcsPoint.getLongitude());
            Double dcsElev = Double.parseDouble(dcsPoint.getElevation());

            DMMCoordinate dmmLat = CoordinateUtils.decimalToDMM(dcsLat);
            DMMCoordinate dmmLong = CoordinateUtils.decimalToDMM(dcsLong);

            DecimalFormat latDegDf = new DecimalFormat("00");
            DecimalFormat latMinDf = new DecimalFormat("00.0");
            DecimalFormat longDegDf = new DecimalFormat("000");
            DecimalFormat longMinDf = new DecimalFormat("00.0");
            String Ka50Latitude = latDegDf.format(dmmLat.getDegrees()) + latMinDf.format(dmmLat.getMinutes()).replace(".", "");
            String Ka50Longitude = longDegDf.format(dmmLong.getDegrees()) + longMinDf.format(dmmLong.getMinutes()).replace(".", "");
            String Ka50Elevation = String.valueOf(Math.round(UnitConvertorUtils.metersToFeet(dcsElev)));

            var Ka50Point = new Point(Ka50Latitude, Ka50Longitude, Ka50Elevation, dcsPoint.getLatitudeHemisphere(), dcsPoint.getLongitudeHemisphere(), dcsPoint.getX(), dcsPoint.getZ());
            Ka50Points.add(Ka50Point);
        }
        return Ka50Points;
    }

    // static list holding the zoom ranges
    private static List<ABRISZoomRange> ranges;
    // current zoomLevel
    private static int zoomLevel = 10;
    static {
        // create a list of ABRIS zoom ranges
        ranges = new ArrayList<ABRISZoomRange>();
        ranges.add(new ABRISZoomRange("150"));
        ranges.add(new ABRISZoomRange("200.00"));
        ranges.add(new ABRISZoomRange("250.00"));
        ranges.add(new ABRISZoomRange("300.00"));
        ranges.add(new ABRISZoomRange("500.00"));
        ranges.add(new ABRISZoomRange("600.00"));
        ranges.add(new ABRISZoomRange("750.00"));
        ranges.add(new ABRISZoomRange("1000.00"));
        ranges.add(new ABRISZoomRange("1250.00"));
        ranges.add(new ABRISZoomRange("1500.00"));
        ranges.add(new ABRISZoomRange("2000.00"));
        ranges.add(new ABRISZoomRange("2500.00"));
        ranges.add(new ABRISZoomRange("3000.00"));
        ranges.add(new ABRISZoomRange("4000.00"));
        ranges.add(new ABRISZoomRange("5000.00"));
        ranges.add(new ABRISZoomRange("6000.00"));
        ranges.add(new ABRISZoomRange("7500.00"));
        ranges.add(new ABRISZoomRange("10000.00"));
        ranges.add(new ABRISZoomRange("12500.00"));
        ranges.add(new ABRISZoomRange("15000.00"));
        ranges.add(new ABRISZoomRange("20000.00"));
        ranges.add(new ABRISZoomRange("25000.00"));
        ranges.add(new ABRISZoomRange("30000.00"));
        ranges.add(new ABRISZoomRange("40000.00"));
        ranges.add(new ABRISZoomRange("50000.00"));
        ranges.add(new ABRISZoomRange("100000.00"));
    }

    private static class ABRISZoomRange {
        private static final BigDecimal ROTATION_TO_SCREEN_FACTOR = new BigDecimal("1.23456");
        private static final BigDecimal HORIZONTAL_ROTATIONS = new BigDecimal("10");
        private static final BigDecimal VERTICAL_ROTATIONS = new BigDecimal("8");
        private int level;
        private static int nextRangeLevel = 0; 
        public ABRISZoomRange(String value) {
            // in any scale it takes 8 revolutions for vertical coordinate to reach edge (X axis)
            // horizontal distance is somewhat larger (Z axis)
            // calculate distance from center point toward edges of the screen in m
            this.vertical = new BigDecimal(value).multiply(VERTICAL_ROTATIONS).divide(ROTATION_TO_SCREEN_FACTOR, RoundingMode.HALF_UP) ;
            // this.horizontal = vertical * 1.25;
            this.horizontal = new BigDecimal(value).multiply(HORIZONTAL_ROTATIONS).divide(ROTATION_TO_SCREEN_FACTOR, RoundingMode.HALF_UP);
            level = nextRangeLevel++;
            System.out.println("Level: " + level +  " scale: " + value + " horizontal: " + horizontal + " vertical: " + vertical);
        }
        public boolean areBothPointsWithinXRange(Point current, Point next) {
          return (next.getX().subtract(current.getX())).abs().compareTo(vertical) <= 0;
        }

        public boolean areBothPointsWithinZRange(Point current, Point next) {
            
            return  (next.getZ().subtract(current.getZ())).abs().compareTo(horizontal) <= 0;
        }

        public int getLevel() {
            return level;
        }

        public BigDecimal toRotationsX(BigDecimal deltaX) {
            return VERTICAL_ROTATIONS.multiply(deltaX).divide(vertical, RoundingMode.HALF_UP);
        }

        public BigDecimal toRotationsZ(BigDecimal deltaZ) {
            return HORIZONTAL_ROTATIONS.multiply(deltaZ).divide(horizontal, RoundingMode.HALF_UP);
        }

        private BigDecimal horizontal;
        private BigDecimal vertical;
    }
}
