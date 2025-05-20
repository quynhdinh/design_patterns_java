package com.quynhdv.design_patterns.factory;

public class Factory {
    public static void main(String[] args) {
        Printer printer = PrinterFactory.getPrinter(PrinterEnum.STANDARD);
        printer.print("An important text !");
        Printer colorPrinter = PrinterFactory.getPrinter(PrinterEnum.COLOR);
        colorPrinter.print("A very important text!");
    }
}

enum PrinterEnum {
    COLOR,
    STANDARD;
}

class ColorPrinter implements Printer {

    @Override
    public void print(String text) {
        System.out.println("Printing with color text " + text);
    }
}

class StandardPrinter implements Printer {

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}

interface Printer {
    void print(String text);
}

final class PrinterFactory {
    public static Printer getPrinter(PrinterEnum printer) {
        if (printer.equals(PrinterEnum.COLOR)) {
            return new ColorPrinter();
        } else if(printer.equals(PrinterEnum.STANDARD)){
            return new StandardPrinter();
        }
        throw new IllegalArgumentException();
    }
}
