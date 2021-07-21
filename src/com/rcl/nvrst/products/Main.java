package com.rcl.nvrst.products;

import java.util.*;

public class Main {

    /**
     * Finds the a region in one image that best matches another, smaller, image.
     */
    public static int[] findPatternCoordinates(int[][] image, int[][] pattern) {
        Set<String> invalid = new HashSet<>();
        for (int y = 0; y <= image.length - pattern.length; y++) {
            for (int x = 0; x <= image[y].length - pattern[y].length; x++) {
                String point = String.format("%d%d", x, y);
                if (invalid.contains(point)) {
                    continue;
                } else {
                    int[][] region = getRegion(image, x, y, pattern[0].length, pattern.length);
                    boolean isMatch = region.length > 0 && compareImages(region, pattern);
                    if (!isMatch) {
                        invalid.add(point);
                    } else {
                        return new int[]{ x, y };
                    }
                }
            }
        }
        return new int[]{};
    }

    /**
     * Extract a specific region from the image.
     */
    private static int[][] getRegion(int[][] image, int startX, int startY, int width, int height) {
        int xBoundary = startX + width;
        int yBoundary = startY + height;
        System.out.println();
        System.out.printf("xBoundary = %d >= imageWidth = %d", xBoundary, image[0].length);
        System.out.println();
        System.out.printf("yBoundary = %d >= imageHeight = %d", yBoundary, image.length);
        System.out.println();
        if (xBoundary > image[0].length || yBoundary > image.length) {
            return new int[][]{};
        }
        int[][] region = new int[height][width];
        for (int y = startY; y < yBoundary; y++) {
            for (int x = startX; x < xBoundary; x++) {
                System.out.printf(
                        "Copy Image(x,y)=(%d,%d) to region(x,y)=(%d,%d)",
                        x, y, (x - startX), (y- startY));
                System.out.println();
                region[y- startY][x - startX] = image[y][x];
            }
        }
        return region;
    }

    /**
     * Determines how different two identically sized regions are.
     */
    private static boolean compareImages(int[][] image, int[][] template) {
        assert(image.length == template.length && image[0].length == template[0].length);
        for(int x = 0; x < image[0].length; x++) {
            for(int y = 0; y < image.length; y++) {
                if (image[x][y] != template[x][y])
                    return false;
            }
        }
        return true;
    }
}
