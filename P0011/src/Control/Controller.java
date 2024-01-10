package Control;

import View.Menu;
import Control.Calculate;
import Model.Model;

public class Controller extends Menu {

    public Controller() {
        super("\nCHANGE BASE NUMBER SYSTEM", new String[]{"Change from Binary", "Change from Decimal", "Change from Hexadecimal", "Exit"});
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                BinaryConversionMenu binaryMenu = new BinaryConversionMenu();
                binaryMenu.run();
                break;
            case 2:
                DecimalConversionMenu decimalMenu = new DecimalConversionMenu();
                decimalMenu.run();
                break;
            case 3:
                HexConversionMenu hexMenu = new HexConversionMenu();
                hexMenu.run();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice, please choice again !");
        }
    }

    class DecimalConversionMenu extends Menu {//ok

        private Model decimal;

        public DecimalConversionMenu() {
            super("\nCONVERT FROM DECIMAL", new String[]{"Input Decimal Number", "Decimal to Binary", "Decimal to Hexadecimal", "Back"});
        }

        @Override
        public void execute(int ch) {
            Calculate mg = new Calculate();
            switch (ch) {
                case 1:
                    decimal = mg.inputDecimalNum();
                    break;
                case 2:
                    if (decimal != null) {
                        mg.convertDecimalToBinary(decimal);
                    } else {
                        System.err.println("You should input decimal number before convert!");
                        decimal = mg.inputDecimalNum();
                        mg.convertDecimalToBinary(decimal);
                    }
                    break;
                case 3:
                    if (decimal != null) {
                        mg.convertDecimalToHex(decimal);
                    } else {
                        System.err.println("You should input decimal number before convert!");
                        decimal = mg.inputDecimalNum();
                        mg.convertDecimalToHex(decimal);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice, please try again !");
            }
        }
    }

    class BinaryConversionMenu extends Menu {//ok

        private Model binary;

        public BinaryConversionMenu() {
            super("\nCONVERT FROM BINARY", new String[]{"Input Binary Number", "Binary to Decimal", "Binary to Hexadecimal", "Back"});
        }

        @Override
        public void execute(int ch) {
            Calculate mg = new Calculate();
            switch (ch) {
                case 1:
                    binary = mg.inputBinaryNum();
                    break;
                case 2:
                    if (binary != null) {
                        mg.convertBinaryToDecimal(binary);
                    } else {
                        System.err.println("You should input Binary Number before convert !");
                        binary = mg.inputBinaryNum();
                        mg.convertBinaryToDecimal(binary);
                    }
                    break;
                case 3:
                    if (binary != null) {
                        mg.convertBinaryToHex(binary);
                    } else {
                        System.err.println("You should input Binary Number before convert !");
                        binary = mg.inputBinaryNum();
                        mg.convertBinaryToHex(binary);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice, please try again !");
            }
        }
    }

    class HexConversionMenu extends Menu {

        private Model hex;

        public HexConversionMenu() {
            super("\nCONVERT FROM HEXADECIMAL", new String[]{"Input Hexadecimal Number", "Hexadecimal to Decimal", "Hexadecimal to Binary", "Back"});
        }

        @Override
        public void execute(int ch) {
            Calculate mg = new Calculate();
            switch (ch) {
                case 1:
                    hex = mg.inputHexNum();
                    break;
                case 2:
                    if (hex != null) {
                        mg.convertHexToDecimal(hex);
                    } else {
                        System.err.println("You should input Hexadecimal Number before convert!");
                        hex = mg.inputHexNum();
                        mg.convertHexToDecimal(hex);
                    }
                    break;
                case 3:
                    if (hex != null) {
                        mg.convertHexToBinary(hex);
                    } else {
                        System.err.println("You should input Hexadecimal Number before convert!");
                        hex = mg.inputHexNum();
                        mg.convertHexToBinary(hex);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice, please try again !");
            }
        }
    }
}
