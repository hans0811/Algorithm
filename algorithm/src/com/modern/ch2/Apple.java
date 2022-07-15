package com.modern.ch2;

public class Apple {
    private int weight = 0;
    private String color = "";

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    /**
     * @param {@link #(weight)}
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @return {@link #weight }
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @param {@link #(color)}
     */
    public String getColor() {
        return color;
    }

    /**
     * @return {@link #color }
     */
    public void setColor(String color) {
        this.color = color;
    }

    @SuppressWarnings("boxing")
    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
