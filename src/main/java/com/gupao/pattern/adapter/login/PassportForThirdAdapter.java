package com.gupao.pattern.adapter.login;

/**
 * Created by Yan on 2019/3/18.
 */
public class PassportForThirdAdapter extends SignService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String qq) {
        return  processLogin(qq,LoginForQQAdapter.class);
    }

    private ResultMsg processLogin(String qq, Class<?extends  LoginAdapter> clazz) {
        try {
            LoginAdapter adapter=clazz.newInstance();
            if(adapter.support(adapter)){
                return adapter.login(qq,adapter);
            }else{
                return null;
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMsg loginForWechat(String openId) {
        return processLogin(openId,LoginForWechatAdapter.class);
    }

    @Override
    public ResultMsg loginForToken(String token) {
        return processLogin(token,LoginForTokeAdapter.class);
    }

    @Override
    public ResultMsg loginForSina(String id) {
        return processLogin(id,LoginForSinaAdapter.class);
    }

    @Override
    public ResultMsg loginForTel(String tel) {
        return processLogin(tel,LoginForTokeAdapter.class);
    }

    @Override
    public ResultMsg loginForRegist(String userName, String password) {
        register(userName,password);
        return login(userName, password);
    }
}
