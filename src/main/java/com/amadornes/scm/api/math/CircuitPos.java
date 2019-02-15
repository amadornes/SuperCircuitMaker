package com.amadornes.scm.api.math;

public final class CircuitPos {

    private final int x, y, z;

    public CircuitPos(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }

    public final int getZ() {
        return z;
    }

    public final CircuitPos add(CircuitPos pos) {
        return add(pos.x, pos.y, pos.z);
    }

    public final CircuitPos add(int x, int y, int z) {
        return new CircuitPos(this.x + x, this.y + y, this.z + z);
    }

    public final CircuitPos sub(CircuitPos pos) {
        return sub(pos.x, pos.y, pos.z);
    }

    public final CircuitPos sub(int x, int y, int z) {
        return new CircuitPos(this.x - x, this.y - y, this.z - z);
    }

    public final CircuitPos scale(CircuitPos pos) {
        return scale(pos.x, pos.y, pos.z);
    }

    public final CircuitPos scale(int amt) {
        return scale(amt, amt, amt);
    }

    public final CircuitPos scale(int x, int y, int z) {
        return new CircuitPos(this.x * x, this.y * y, this.z * z);
    }

    public final CircuitPos offset(CircuitDirection direction) {
        return offset(direction, 1);
    }

    public final CircuitPos offset(CircuitDirection direction, int amount) {
        return add(direction.getOffset().scale(amount));
    }

}
