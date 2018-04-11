package magicfinmart.datacomp.com.finmartserviceapi.pospapp.controller.login;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;

import magicfinmart.datacomp.com.finmartserviceapi.pospapp.IResponseSubcriber;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.facade.LoginFacade;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestbuilder.LoginRequestBuilder;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.requestmodels.LoginRequestEntity;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.CertificateResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LoginResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.LogoutResponse;
import magicfinmart.datacomp.com.finmartserviceapi.pospapp.response.SendAdminResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Rajeev Ranjan on 23/03/2017.
 */

public class LoginController implements ILogin {
    LoginRequestBuilder.LoginNetworkService loginNetworkService;
    Context mContext;

    public LoginController(Context context) {
        loginNetworkService = new LoginRequestBuilder().getService();
        mContext = context;
    }

    @Override
    public void login(LoginRequestEntity loginRequestEntity, final IResponseSubcriber iResponseSubcriber) {

        loginNetworkService.login(loginRequestEntity).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                try {

                    new LoginFacade(mContext).storeUser(response.body().getResult());
                    iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());

                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }

    @Override
    public void logout(int UserId, int FBAID, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameters = new HashMap<String, String>();
        bodyParameters.put("UserId", "" + UserId);
        bodyParameters.put("FBAId", "" + FBAID);
        loginNetworkService.logout(bodyParameters).enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        ///new LoginFacade(mContext).storeUser(response.body().getResult());
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<LogoutResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }

    @Override
    public void requestAdmin(String email, final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameters = new HashMap<String, String>();
        bodyParameters.put("email", email);
        loginNetworkService.requestAdmin(bodyParameters).enqueue(new Callback<SendAdminResponse>() {
            @Override
            public void onResponse(Call<SendAdminResponse> call, Response<SendAdminResponse> response) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        ///new LoginFacade(mContext).storeUser(response.body().getResult());
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<SendAdminResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }

    @Override
    public void getCertificate(final IResponseSubcriber iResponseSubcriber) {
        HashMap<String, String> bodyParameters = new HashMap<String, String>();
        bodyParameters.put("UserId", "" + new LoginFacade(mContext).getUser().getUserId());
        loginNetworkService.getCertificate(bodyParameters).enqueue(new Callback<CertificateResponse>() {
            @Override
            public void onResponse(Call<CertificateResponse> call, Response<CertificateResponse> response) {
                try {
                    if (response.body().getStatusNo() == 0) {
                        ///new LoginFacade(mContext).storeUser(response.body().getResult());
                        iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());
                    } else {
                        iResponseSubcriber.OnFailure(new RuntimeException(response.body().getMessage()));
                    }
                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<CertificateResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }

    @Override
    public void loginByFBAId(LoginRequestEntity loginRequestEntity, final IResponseSubcriber iResponseSubcriber) {
        loginNetworkService.LoginByFBAId(loginRequestEntity).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                try {

                    new LoginFacade(mContext).storeUser(response.body().getResult());
                    iResponseSubcriber.OnSuccess(response.body(), response.body().getMessage());

                } catch (InterruptedException e) {
                    iResponseSubcriber.OnFailure(new RuntimeException(e.getMessage()));
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                if (t instanceof ConnectException) {
                    iResponseSubcriber.OnFailure(t);
                } else if (t instanceof SocketTimeoutException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else if (t instanceof UnknownHostException) {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                } else {
                    iResponseSubcriber.OnFailure(new RuntimeException(t.getMessage()));
                }
            }
        });
    }
}
