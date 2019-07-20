package com.megathon.smarthome.ui.home.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AppliancesUpdateModel {
    @SerializedName("result")
    @Expose
    private val result: Result? = null
    @SerializedName("connection")
    @Expose
    private val connection: Connection? = null
    @SerializedName("n")
    @Expose
    private val n: Int? = null
    @SerializedName("nModified")
    @Expose
    private val nModified: Int? = null
    @SerializedName("opTime")
    @Expose
    private val opTime: OpTime? = null
    @SerializedName("electionId")
    @Expose
    private val electionId: String? = null
    @SerializedName("ok")
    @Expose
    private val ok: Int? = null
    @SerializedName("operationTime")
    @Expose
    private val operationTime: String? = null
    @SerializedName("\$clusterTime")
    @Expose
    private val clusterTime: ClusterTime? = null
}
class Connection {
     @SerializedName("id")
     @Expose
     private val id: Int? = null
     @SerializedName("host")
     @Expose
     private val host: String? = null
     @SerializedName("port")
     @Expose
     private val port: Int? = null
}

class Result{
    @Expose
    private val n: Int? = null
    @SerializedName("nModified")
    @Expose
    private val nModified: Int? = null
    @SerializedName("opTime")
    @Expose
    private val opTime: OpTime? = null
    @SerializedName("electionId")
    @Expose
    private val electionId: String? = null
    @SerializedName("ok")
    @Expose
    private val ok: Int? = null
    @SerializedName("operationTime")
    @Expose
    private val operationTime: String? = null
    @SerializedName("\$clusterTime")
    @Expose
    private val clusterTime: ClusterTime? = null
}

class ClusterTime{
    @SerializedName("clusterTime")
    @Expose
    private val clusterTime: String? = null
    @SerializedName("signature")
    @Expose
    private val signature: Signature? = null
}

class Signature{
    @SerializedName("hash")
    @Expose
    private val hash: String? = null
    @SerializedName("keyId")
    @Expose
    private val keyId: String? = null
}

class OpTime{
    @SerializedName("ts")
    @Expose
    private val ts: String? = null
    @SerializedName("t")
    @Expose
    private val t: Int? = null
}