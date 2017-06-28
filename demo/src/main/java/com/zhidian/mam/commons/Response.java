package com.zhidian.mam.commons;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * <p>Copyright: All Rights Reserved</p>
 * <p>Company: 指点无限(北京)科技有限公司   http://www.zhidianwuxian.cn</p>
 * <p>Description: rest接口返回值 </p>
 * <p>Author:jmzhang/张际明, 16/09/29</p>
 */
@XmlRootElement
@Data
public class Response<T> implements Serializable {
	private static final long serialVersionUID = 7741130044036793402L;
	/**
	 * 成功标志
	 */
	public static final int OK = 0;
	/**
	 * 失败标志
	 */
	public static final int ERROR = 1;
	private int code;
	private String message;
	private T value;

	public Response(int code, String message, T value) {
		this.code = code;
		this.message = message;
		this.value = value;
	}
}
