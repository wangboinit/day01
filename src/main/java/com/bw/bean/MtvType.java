package com.bw.bean;;


public class MtvType implements java.io.Serializable {

	//columns START
	private Integer mtid;
	private Integer mid;
	private Integer tid;
	//columns END
	public MtvType(){
	}
	public MtvType(Integer mtid,Integer mid,Integer tid){
		this.mtid=mtid;		this.mid=mid;		this.tid=tid;	}

	public void setMtid(Integer mtid){
		this.mtid=mtid;
	}
	public Integer getMtid(){
		return mtid;
	}

	public void setMid(Integer mid){
		this.mid=mid;
	}
	public Integer getMid(){
		return mid;
	}

	public void setTid(Integer tid){
		this.tid=tid;
	}
	public Integer getTid(){
		return tid;
	}
}

