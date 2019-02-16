package com.amadornes.scm.api.math;

public enum CircuitDirection {
    DOWN(0, -1, 0),
    UP(0, 1, 0),
    NORTH(0, 0, -1),
    SOUTH(0, 0, 1),
    WEST(-1, 0, 0),
    EAST(1, 0, 0);

    public static final CircuitDirection[] VALUES = values();
    public static final CircuitDirection[] HORIZONTALS = { NORTH, SOUTH, WEST, EAST };

    private final CircuitPos offset;

    CircuitDirection(int x, int y, int z) {
        this.offset = new CircuitPos(x, y, z);
    }

    public CircuitPos getOffset() {
        return offset;
    }

    public CircuitDirection getOpposite() {
        return VALUES[ordinal() ^ 1];
    }

}
