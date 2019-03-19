package com.gupao.pattern.adapter.mybusiness.upgrade;

/**
 * Created by Yan on 2019/3/19.
 */
public class OpenForThirdAdapter extends OpenService implements IOpenForThird {
    @Override
    public ResultMsg openIQiYI(String mac, String sn) {
        return processOpen(mac, sn, OpenIQiYiAdapter.class);
    }

    private ResultMsg processOpen(String mac, String sn, Class<? extends OpenAdapter> clazz) {
        try {
            OpenAdapter adapter = clazz.newInstance();
            if(adapter.support(adapter)){
                super.openDaMai(mac,sn);
            return adapter.open(mac,sn,adapter);}else{
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
    public ResultMsg openTencent(String mac, String sn) {
        return processOpen(mac, sn, OpenTencentAdapter.class);    }

    @Override
    public ResultMsg openMongo(String mac, String sn) {
        return processOpen(mac, sn, OpenMongoAdapter.class);
    }

    @Override
    public ResultMsg openYouKu(String mac, String sn) {
        return processOpen(mac, sn, OpenYouKuAdapter.class);
    }
}
