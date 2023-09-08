/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phamh
 */
public class RoundFloat {

    public static float roundToOneDecimal(float number) {
        return Math.round(number * 10.0f) / 10.0f;
    }

    public static void main(String[] args) {
        float floatValue = 8.666666f;
        float roundedValue = roundToOneDecimal(floatValue);
        System.out.println("Số gốc: " + floatValue);
        System.out.println("Số làm tròn: " + roundedValue);
    }
}
