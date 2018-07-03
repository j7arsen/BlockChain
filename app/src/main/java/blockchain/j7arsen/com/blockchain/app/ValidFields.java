package blockchain.j7arsen.com.blockchain.app;

public class ValidFields {

    public static boolean isNotEmptyField(String text) {
        return !text.trim().isEmpty();
    }

    public static boolean isNullOrEmpty(String value){
        return value == null || value.isEmpty();
    }

}
