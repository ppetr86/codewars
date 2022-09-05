package com.example.codewars3.entwicklerheld;

import java.util.Iterator;

public class NumberOfIslandsRefactored {

    public static class Map implements Iterable<MapPart> {
        private final MapPart[][] mapParts;

        public Map(char[][] grid) {
            if (grid == null || grid.length == 0)
                mapParts = new MapPart[0][0];
            else {
                mapParts = new MapPart[grid.length][grid[0].length];
                MapPart p;
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[i].length; j++) {
                        p = new MapPart(i, j, grid[i][j]);
                        mapParts[i][j] = p;
                    }
                }
            }
        }

        public MapPart getTopMapPart(MapPart referenceMapPart) {
            if (!isInRange(1, mapParts.length + 1, referenceMapPart.row)
                    || !isInRange(0, mapParts[0].length, referenceMapPart.column)) {
                return new MapPart(referenceMapPart.row, referenceMapPart.column, '0');
            }

            return mapParts[referenceMapPart.row - 1][referenceMapPart.column];
        }

        private boolean isInRange(int min, int max, int param) {
            return param >= min && param < max;
        }

        public MapPart getBottomMapPart(MapPart referenceMapPart) {
            if (!isInRange(0, mapParts.length - 1, referenceMapPart.row)
                    || !isInRange(0, mapParts[0].length, referenceMapPart.column)) {
                return new MapPart(referenceMapPart.row, referenceMapPart.column, '0');
            }
            return mapParts[referenceMapPart.row + 1][referenceMapPart.column];
        }

        public MapPart getLeftMapPart(MapPart referenceMapPart) {
            if (!isInRange(0, mapParts.length, referenceMapPart.row)
                    || !isInRange(1, mapParts[0].length, referenceMapPart.column)) {
                return new MapPart(referenceMapPart.row, referenceMapPart.column, '0');
            }
            return mapParts[referenceMapPart.row][referenceMapPart.column - 1];

        }

        public MapPart getRightMapPart(MapPart referenceMapPart) {
            if (!isInRange(0, mapParts.length, referenceMapPart.row)
                    || !isInRange(0, mapParts[0].length - 1, referenceMapPart.column)) {
                return new MapPart(referenceMapPart.row, referenceMapPart.column, '0');
            }
            return mapParts[referenceMapPart.row][referenceMapPart.column + 1];
        }

        public Iterator<MapPart> iterator() {
            return new Iterator<MapPart>() {

                private int currentRow = 0;
                private int currentColumn = 0;
                private int pointer = 0;
                private int size = defineSize(mapParts);

                private int defineSize(MapPart[][] mapParts) {
                    if (mapParts == null || mapParts.length == 0) return 0;
                    return mapParts.length * mapParts[0].length;
                }

                public boolean hasNext() {
                    if (mapParts == null || mapParts.length == 0 || mapParts[0].length == 0)
                        return false;
                    return pointer < size;
                }

                public MapPart next() {
                    int col = currentColumn;
                    int row = currentRow;
                    if (currentColumn != mapParts[currentRow].length - 1)
                        currentColumn++;
                    else {
                        currentColumn = 0;
                        currentRow++;
                    }

                    pointer++;
                    return mapParts[row][col];
                }

                public void remove() {
                    mapParts[currentRow][currentColumn] = null;
                }
            };
        }

        public MapPart[][] getMapParts() {
            return mapParts;
        }
    }


    public int numIslands(char[][] grid) {
        Map map = new Map(grid);
        int islandCount = 0;

        for (MapPart mapPart : map) {
            if (mapPart.isWater() || mapPart.wasChecked) {
                continue;
            }

            islandCount += 1;
            mapPart.wasChecked = true;

            this.checkSurroundings(map, mapPart);
        }
        return islandCount;
    }

    private void checkSurroundings(Map map, MapPart part) {
        MapPart topMapPart = map.getTopMapPart(part);
        if (topMapPart.isLand() && !topMapPart.wasChecked) {
            topMapPart.wasChecked = true;
            checkSurroundings(map, topMapPart);
        }

        MapPart bottomPart = map.getBottomMapPart(part);
        if (bottomPart.isLand() && !bottomPart.wasChecked) {
            bottomPart.wasChecked = true;
            checkSurroundings(map, bottomPart);
        }

        MapPart rightPart = map.getRightMapPart(part);
        if (rightPart.isLand() && !rightPart.wasChecked) {
            rightPart.wasChecked = true;
            checkSurroundings(map, rightPart);
        }

        MapPart leftPart = map.getLeftMapPart(part);
        if (leftPart.isLand() && !leftPart.wasChecked) {
            leftPart.wasChecked = true;
            checkSurroundings(map, leftPart);
        }
    }
}