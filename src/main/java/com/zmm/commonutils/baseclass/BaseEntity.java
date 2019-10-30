package com.zmm.commonutils.baseclass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * 
 * 实体对象基类
 * 
 * @author lzy
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 4895380346398331215L;

	private Pagination pagination;

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	@SuppressWarnings("unchecked")
	public <T> T copyEntity() {
		ByteArrayOutputStream byteArrayOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			byteArrayOutputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(this);

			ByteArrayInputStream byteIn = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

			ObjectInputStream in = new ObjectInputStream(byteIn);
			T result = (T) in.readObject();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (byteArrayOutputStream != null) {
				try {
					byteArrayOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
