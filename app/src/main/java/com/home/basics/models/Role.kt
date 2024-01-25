package com.home.basics.models

enum class ROLE(val value: Int) {
    COMMON(1),
    ADM(2);

    companion object {
        fun getFromBuild(flavor: String) : ROLE {
            if(flavor === "adm") {
                return ADM
            }
            return COMMON
        }
    }
}
