package blockchain.j7arsen.com.blockchain.di.app.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import blockchain.j7arsen.com.blockchain.app.Constants;
import blockchain.j7arsen.com.blockchain.network.NullOnEmptyConverterFactory;
import blockchain.j7arsen.com.blockchain.network.PrimitiveConverterFactory;
import blockchain.j7arsen.com.blockchain.network.typeconverter.TicketTypeConverter;
import blockchain.j7arsen.com.blockchain.utils.ResUtils;
import blockchain.j7arsen.com.blockchain.utils.error.ErrorHandler;
import blockchain.j7arsen.com.data.api.ApiService;
import blockchain.j7arsen.com.data.api.Environment;
import blockchain.j7arsen.com.data.models.net.TickerObjectEntity;
import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Singleton
    @Provides
    public ApiService provideApiService() {
        final Retrofit retrofit = initRetrofit();
        return retrofit.create(ApiService.class);
    }

    @Singleton
    @Provides
    public ErrorHandler provideErrorHandler(ResUtils utils) {
        return new ErrorHandler(utils);
    }

    private Retrofit initRetrofit() {
        final Retrofit.Builder retrofitBuilder =
                new Retrofit.Builder()
                        .baseUrl(Environment.BASE_URL)
                        .addConverterFactory(initConverterFactory())
                        .addConverterFactory(initNullConverterFactory())
                        .addConverterFactory(initPrimitiveTypeConverterFactory())
                        .addCallAdapterFactory(initCallAdapterFactory())
                        .client(initOkHttpClient());
        return retrofitBuilder.build();
    }

    private Converter.Factory initConverterFactory() {
        return GsonConverterFactory.create(initGson());
    }

    private Converter.Factory initNullConverterFactory() {
        return NullOnEmptyConverterFactory.create();
    }

    private Converter.Factory initPrimitiveTypeConverterFactory() {
        return PrimitiveConverterFactory.create();
    }

    private CallAdapter.Factory initCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    private Gson initGson() {
        return new GsonBuilder()
                .registerTypeAdapter(TickerObjectEntity.class, new TicketTypeConverter())
                .setLenient()
                .enableComplexMapKeySerialization()
                .serializeNulls()
                .setPrettyPrinting()
                .setVersion(1.0)
                .create();
    }

    private OkHttpClient initOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(Constants.CONNECT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS);
        builder.readTimeout(Constants.TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                request = request.newBuilder()
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .addHeader("Accept", "application/json")
                        .build();
                Response response = chain.proceed(request);
                return response;
            }
        });
        builder.addNetworkInterceptor(logging);
        return builder.build();
    }

}
