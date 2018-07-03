package blockchain.j7arsen.com.blockchain.utils.error;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import blockchain.j7arsen.com.blockchain.R;
import blockchain.j7arsen.com.blockchain.utils.ResUtils;
import retrofit2.HttpException;

public class ErrorHandler {

    public static final int ERROR_400 = 400;
    public static final int ERROR_401 = 401;

    private String defaultMessage;
    private ResUtils resUtils;

    public ErrorHandler(ResUtils resUtils) {
        this.resUtils = resUtils;
        this.defaultMessage = resUtils.getString(R.string.message_error_default);
    }

    public String getError(Throwable throwable) {
        if (throwable instanceof UnknownHostException || throwable instanceof ConnectException) {
            return resUtils.getString(R.string.message_error_connect);
        } else if (throwable instanceof SocketTimeoutException) {
            return resUtils.getString((R.string.message_error_socket));
        } else if (throwable instanceof HttpException) {
            int errorCode = ((HttpException) throwable).code();
            switch (errorCode){
                case ERROR_400:
                case ERROR_401:
                    if(((HttpException) throwable).response() != null && ((HttpException) throwable).response().errorBody() != null){
                        try {
                            String error = ((HttpException) throwable).response().errorBody().string();
                            if(error != null && !error.isEmpty()) {
                                return error;
                            } else{
                                return defaultMessage;
                            }
                        } catch (IOException e){
                            return defaultMessage;
                        }
                    } else{
                        return defaultMessage;
                    }
                default:
                    return defaultMessage;
            }
        } else if (throwable instanceof SSLException) {
            return resUtils.getString((R.string.message_error_connect));

        } else {
            return defaultMessage;
        }
    }

}
