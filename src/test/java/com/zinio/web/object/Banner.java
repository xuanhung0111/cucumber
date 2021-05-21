package com.zinio.web.object;

import com.zinio.web.data.BannerData;
import com.zinio.web.data.GeneralData;
import com.zinio.web.utilities.StringUtils;

import java.util.HashMap;

import static com.zinio.web.data.BannerData.NUMBER_TARGET_REQUEST_PARAMETERS;

public class Banner {

    public String title;
    public String subTitle;
    public String action;
    public String actionObjectID;
    public String type;
    public String status;
    public String image2x1;
    public String image3x1;
    public String image4x1;
    public String id;
    public String modifiedAt;
    public String[] platform;
    public String targetKey;
    public String targetLayout;
    public HashMap<String, String> targetRequestParameters;

    public Banner randomValues() {
        randomRequiredValues();
        subTitle = StringUtils.randomString("Subtitle ", 10);
        setActionValue(GeneralData.OPTION.any.toString());
        setImage2x1(GeneralData.OPTION.any.toString());
        setImage3x1(GeneralData.OPTION.any.toString());
        setImage4x1(GeneralData.OPTION.any.toString());
        platform(GeneralData.OPTION.any.toString());
        targetKey(GeneralData.OPTION.any.toString());
        targetLayout(GeneralData.OPTION.any.toString());
        targetRequestParameters(GeneralData.OPTION.any.toString());
        return this;
    }

    public Banner randomRequiredValues() {
        title = StringUtils.randomString("Banner title ", 10);
        setTypeValue(GeneralData.OPTION.any.toString());
        setStatusValue(GeneralData.OPTION.any.toString());
        return this;
    }

    public Banner setActionValue(String actionValue) {
        action = actionValue.equals(GeneralData.OPTION.any.toString()) ?
                StringUtils.getRandomItem(BannerData.ACTION) : actionValue;
        return this;
    }

    public Banner setTypeValue(String typeValue) {
        type = typeValue.equals(GeneralData.OPTION.any.toString()) ?
                StringUtils.getRandomItem(BannerData.TYPE) : typeValue;
        return this;
    }

    public Banner setStatusValue(String statusValue) {
        status = statusValue.equals(GeneralData.OPTION.any.toString()) ?
                StringUtils.getRandomItem(BannerData.STATUS) : statusValue;
        return this;
    }

    public Banner setImage2x1(String imageType) {
        image2x1 = imageType.equals(GeneralData.OPTION.any.toString()) ? StringUtils.getRandomItemOn2DArray(BannerData
                .URLIMAGE2x1)[1] :
                StringUtils.getDataFromKey(BannerData.URLIMAGE2x1, imageType);
        return this;
    }

    public Banner setImage3x1(String imageType) {
        image3x1 = imageType.equals(GeneralData.OPTION.any.toString()) ? StringUtils.getRandomItemOn2DArray(BannerData
                .URLIMAGE3x1)[1] :
                StringUtils.getDataFromKey(BannerData.URLIMAGE3x1, imageType);
        return this;
    }

    public Banner setImage4x1(String imageType) {
        image4x1 = imageType.equals(GeneralData.OPTION.any.toString()) ? StringUtils.getRandomItemOn2DArray(BannerData
                .URLIMAGE4x1)[1] :
                StringUtils.getDataFromKey(BannerData.URLIMAGE4x1, imageType);
        return this;
    }

    public Banner platform(String... platform) {
        if (platform[0].equals(GeneralData.OPTION.all.toString())) {
            this.platform = BannerData.PLATFORM;
        } else if (platform[0].toString().equals(GeneralData.OPTION.any.toString())) {
            this.platform = StringUtils.getRandomItems(BannerData.PLATFORM);
        } else {
            this.platform = platform;
        }

        return this;
    }

    public Banner targetKey(String targetKey) {
        this.targetKey = targetKey.equals(GeneralData.OPTION.any.toString()) ?
                StringUtils.randomString("", 10) : targetKey;
        return this;
    }

    public Banner targetLayout(String targetLayout) {
        this.targetLayout = targetLayout.equals(GeneralData.OPTION.any.toString()) ?
                StringUtils.randomString("", 10) : targetLayout;
        return this;
    }

    public Banner targetRequestParameters(Object object) {
        if (object.toString().equals(GeneralData.OPTION.any.toString())) {
            this.targetRequestParameters = new HashMap<>();
            int numberOfTargetRequestParameter = StringUtils.randomNumberInRange(1,NUMBER_TARGET_REQUEST_PARAMETERS);
            for (int i = 0; i < numberOfTargetRequestParameter; i++) {
                String key = StringUtils.randomString("Key", 4);
                String value = StringUtils.randomString("", 10);
                this.targetRequestParameters.put(key, value);
            }
        } else {
            this.targetRequestParameters = (HashMap<String, String>) object;
        }

        return this;
    }
}
