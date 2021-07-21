package com.rcl.nvrst.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    int[][] image = {
            { 1, 0, 1, 1, 1, 1 },
            { 0, 1, 0, 1, 0, 0 },
            { 0, 0, 0, 1, 1, 1 },
            { 0, 1, 1, 0, 0, 0 }
    };

    @Test
    void testNotFound() {
        int[][] pattern = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertEquals(0, result.length);
    }

    @Test
    void test00() {
        int[][] pattern = {
                { 1, 0, 1 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertTrue(result.length > 0);
        assertEquals(0, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    void test10() {
        int[][] pattern = {
                { 0, 1, 1 },
                { 1, 0, 1 },
                { 0, 0, 1 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertTrue(result.length > 0);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    void test20() {
        int[][] pattern = {
                { 1, 1, 1 },
                { 0, 1, 0 },
                { 0, 1, 1 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertTrue(result.length > 0);
        assertEquals(2, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    void test30() {
        int[][] pattern = {
                { 1, 1, 1 },
                { 1, 0, 0 },
                { 1, 1, 1 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertTrue(result.length > 0);
        assertEquals(3, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    void test01() {
        int[][] pattern = {
                { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 1 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertTrue(result.length > 0);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void test11() {
        int[][] pattern = {
                { 1, 0, 1 },
                { 0, 0, 1 },
                { 1, 1, 0 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertTrue(result.length > 0);
        assertEquals(1, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void test21() {
        int[][] pattern = {
                { 0, 1, 0 },
                { 0, 1, 1 },
                { 1, 0, 0 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertTrue(result.length > 0);
        assertEquals(2, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void test31() {
        int[][] pattern = {
                { 1, 0, 0 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        int[] result = Main.findPatternCoordinates(image, pattern);
        assertTrue(result.length > 0);
        assertEquals(3, result[0]);
        assertEquals(1, result[1]);
    }
}
