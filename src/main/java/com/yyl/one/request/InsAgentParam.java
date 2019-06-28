package com.yyl.one.request;

import java.io.Serializable;

/**
 * author:yangyuanliang Date:2019-06-28 Time:10:55
 **/
public class InsAgentParam extends BaseRequestParam<InsAgentParam> {
    private InsAgentInput insAgentInput;

    public InsAgentInput getInsAgentInput() {
        return insAgentInput;
    }

    public void setInsAgentInput(InsAgentInput insAgentInput) {
        this.insAgentInput = insAgentInput;
    }

    public static class InsAgentInput implements Serializable{
         private String sfzh;
         private String sbkh;

        public String getSfzh() {
            return sfzh;
        }

        public void setSfzh(String sfzh) {
            this.sfzh = sfzh;
        }

        public String getSbkh() {
            return sbkh;
        }

        public void setSbkh(String sbkh) {
            this.sbkh = sbkh;
        }
    }
}
